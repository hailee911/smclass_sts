package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller // url 모든 링크 -> controller로 분기
public class FController {
	
	@Autowired HttpSession session;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		System.out.println("get방식");
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(HttpServletRequest request) {
		session.setAttribute("session_id", "aaa");
		System.out.println("post방식");
		return "/index";
	}
	
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "logout";
	}
	
	
}
