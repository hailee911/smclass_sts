package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired HttpSession session;
	@Autowired MemberService memberService;
	
	//회원 전체 가져오기
	@CrossOrigin
	@ResponseBody
	@GetMapping("/member/memberList")
	public List<MemberDto> memberView() {
		List<MemberDto> list = memberService.memberList();
		return list;
	}
	
	//회원 1명 가져오기 , 자바스크립트에서 json 데이터로 전달을 받으면 @RequestBody 붙여야 함.
	@CrossOrigin
	@ResponseBody
	@GetMapping("/member/memberView")
	public MemberDto memberView(String id) {
		System.out.println("memberView id : "+id);
		MemberDto memberDto = memberService.memberView(id);
		return memberDto;
	}
	
	
	
	@GetMapping("/member/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/?loginChk=0";
	}
	
	@GetMapping("/member/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/member/login")
	public String login(MemberDto mdto, Model model) {
		System.out.println("controller id : "+mdto.getId());
		MemberDto memberDto = memberService.login(mdto);
		if (memberDto != null) {
			session.setAttribute("session_id", memberDto.getId());
			return "redirect:/?loginChk=1";
		}else {
			model.addAttribute("loginChk", 0);
			return "member/login";
		}
	}

}
