package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MController {

	@Autowired HttpSession session; // 세션 객체
	
	@GetMapping("/login")
	public String login(String chk) {
		return "member/login";
	}
	
	@PostMapping("/login")
	public String login(String id, String pw, Model model) {
		// db접근해서 id, pw가 맞는지 확인
		if (id.equals("aaa") && pw.equals("1111")) {
			session.removeAttribute("id");
			session.setAttribute("session_id", id);
			return "redirect:/?chk=1";
		}else {
			return "redirect:/member/login?chk=0";
		}
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		session.setAttribute("logoutChk", "1");
		return "redirect:/?outChk=1";
	}
	
	
}
