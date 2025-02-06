package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	@Autowired HttpSession session;
	
	@GetMapping("/")
	public String index() {
		System.out.println("index페이지가 열립니다.");
		return "index";
	}
	
	@GetMapping("/member")
	public String member() {
		return "member";
	}
	
	@PostMapping("/member")
	public ModelAndView member(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String gender = request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
		String hobby = "";
		for (int i = 0; i < hobbys.length; i++) {
			if (i==0) hobby += hobbys[i];
			else hobby += ", " + hobbys[i];
		}
		
		//ModelAndView 사용
		ModelAndView mv = new ModelAndView();
		mv.setViewName("memInfo");
		mv.addObject("member", new MemberDto(id, pw, name, tel, gender, hobby));
		return mv;
		
		//model 사용
//		model.addAttribute("member", new MemberDto(id, pw, name, tel, gender, hobby));
//		return "memInfo";
	}
	
	
	@GetMapping("/memInfo")
	public String memInfo() {
		return "memInfo";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String doLogin(HttpServletRequest request, Model model) {
		System.out.println("로그인 post방식");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		session.setAttribute("session_id", id);
		
		return "loginInfo";
	}
	
	@RequestMapping("/logout") // get, post 둘다 받음
	public String logout() {
		session.invalidate();
		return "logout";
	}

}
