package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.MemDto;
import com.java.dto.StuDto;


@Controller
public class FController {
	
	@GetMapping("/")
	public String index() {
		System.out.println("index페이지가 열립니다.");
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@PostMapping("/login")
	public String login(HttpServletRequest request, Model model,
			@RequestParam("id") String aid, //form name="id" 데이터 입력받음
			@RequestParam(required = false) String pw, // null값 허용
			String name, // @RequestParam 생략 가능, form name과 변수명이 같아야함
			@RequestParam int kor,
			@RequestParam(defaultValue = "0") int eng,
			int math) {
		
		int total = kor + eng + math;
		double avg = total/3.0;
		
		model.addAttribute("id", aid);
		model.addAttribute("pw", pw);
		model.addAttribute("name", name);
		model.addAttribute("kor", kor);
		model.addAttribute("eng", eng);
		model.addAttribute("math", math);
		model.addAttribute("total", total);
		model.addAttribute("avg", avg);
		
//		String id = request.getParameter("id");
//		String apw = request.getParameter("pw");
//		int akor = Integer.parseInt(request.getParameter("kor"));
//		int aeng = Integer.parseInt(request.getParameter("eng"));
//		int amath = Integer.parseInt(request.getParameter("math"));
//		int total = akor + aeng + amath;
//		double avg = total/3.0;
		
		
        return "dologin";		
	}
	
	@GetMapping("/stuInput")
	public String stuInput() {
		return "stuInput";
	}
	@PostMapping("/stuInput")
	public String stuInput(int stuno, String name, int kor, int eng, int math, Model model) {
        int total = kor + eng + math;
        double avg = total/3.0;
        
        StuDto s = StuDto.builder().stuno(stuno).name(name)
				.kor(kor).eng(eng).math(math).total(total).avg(avg).build();
        model.addAttribute("stu",s);
        
        return "doStuInput";
	}
	
	@GetMapping("/board")
	public String board(int bno, String btitle, 
			Model model) {
		System.out.println("bno :"+bno);
		System.out.println("btitle :"+btitle);
		
		model.addAttribute("bno", bno);
		model.addAttribute("btitle", btitle);
		
		return "board";
	}
	
	
	
	

}
