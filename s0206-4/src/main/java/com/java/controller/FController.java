package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.java.dto.MemDto;
import com.java.dto.StuDto;



@Controller
public class FController {
	@GetMapping("/")
	public String index() {
		return "/index";
	}
	
	@GetMapping("/member")
	public String member() {
		return "/member";
	}
	
	@GetMapping("/stuInput")
	public String stuInput() {
		return "/stuInput";
	}
	
	@PostMapping("/stuInfo")
	public String stuInfo(StuDto sDto, Model model) {
		sDto.setTotal(Integer.parseInt(sDto.getKor()) + Integer.parseInt(sDto.getEng()) + Integer.parseInt(sDto.getMath()));
        sDto.setAvg(sDto.getTotal()/3.0);
        
        model.addAttribute("stu", sDto);
		return "/stuInfo";
	}
	
	@PostMapping("/memInfo")
	public String memInfo(MemDto mDto, Model model) {
		model.addAttribute("mem", mDto);
		return "/memInfo";
	}
	
	
	
	

}
