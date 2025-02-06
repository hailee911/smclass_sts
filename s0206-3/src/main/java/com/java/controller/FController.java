package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.MemberDto;
import com.java.dto.StuDto;
import com.java.service.BService;
import com.java.service.BServiceImpl;
import com.java.service.BServiceImpl2;
import com.java.service.BServiceImpl3;
import com.java.service.BServiceImpl4;




@Controller
public class FController {
	
	//객체선언
	@Autowired BService b;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/member")
	public String member() {
		return "member";
	}
	
	@PostMapping("/memInfo")
	public String memInfo(MemberDto mDto, Model model) {
		model.addAttribute("member", mDto);
		System.out.println(mDto.getHobby());
		return "memInfo";
	}
	
	@GetMapping("/stuInput")
	public String stuInput() {
		return "stuInput";
	}
	
	@PostMapping("/stuInfo")
	public String stuInfo(StuDto sDto, Model model) {
		sDto.setTotal(Integer.parseInt(sDto.getKor()) + Integer.parseInt(sDto.getEng()) + Integer.parseInt(sDto.getMath()));
		sDto.setAvg(sDto.getTotal()/3.0);
        model.addAttribute("stu", sDto);
        System.out.println(sDto.getTotal());
        return "stuInfo";
		
	}
	
	@GetMapping("/data")
	public String data(@RequestParam(defaultValue = "1") int bno, Model model) {
		model.addAttribute("bno", bno);
        return "data";
	}
	
	@GetMapping("/data2/{bno}") // PathVariable방식
	public String data2(@PathVariable int bno, Model model) {
		model.addAttribute("bno", bno);
		return "data2";
	}
	
	@GetMapping("/data3/{bno}")
	public String data3(@PathVariable List<Integer> bno, Model model) {
		model.addAttribute("bno", bno);
		return "data3";
	}
	
	@GetMapping("data4")
	public String data4() {
		String str = b.slist();
		System.out.println("str : " + str);
		return "data4";
	}
	
	
	
	
	
	
	
	
	// 매개변수로 전달받음
//	@PostMapping("/memInfo")
//	public String memInfo(String id, String pw, String tel, String gender, String[] hobby,Model model) {
//		String hobbys = "";
//		for(int i=0; i<hobby.length; i++) {
//			if(i==0) hobbys += hobby[i];
//			else hobbys += "," + hobby[i];
//        }
//		model.addAttribute("member", new MemberDto(id, pw, tel, gender, hobbys));
//		return "memInfo";
//	}
	
	

}
