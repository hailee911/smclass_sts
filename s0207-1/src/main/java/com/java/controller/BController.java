package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.BoardDto;
import com.java.service.BService;

@Controller
@RequestMapping("/board")
public class BController {
	
//	BService bService = new BServiceImpl();
	@Autowired BService bService;
	
	@GetMapping("/blist")
	public String blist(Model model) {
		// 게시판리스트 - 게시글 여러개가 존재함 BoardDto 여러개 arrayList
		// 게시글 1개만 가져오기 - BoardDto
		ArrayList<BoardDto> list = bService.blist();
		
		// jsp페이지에 보냄.
		model.addAttribute("list", list);
		return "board/blist";
	}

}
