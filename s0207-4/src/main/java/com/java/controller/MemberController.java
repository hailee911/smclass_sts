package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.java.dto.MemberDto;
import com.java.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired MemberService memberService;
	
	@GetMapping("/mlist")
	public String mlist(Model model) {
		ArrayList<MemberDto> list = memberService.selectAll();
		model.addAttribute("list", list);
		return "member/mlist";
	}
	

}
