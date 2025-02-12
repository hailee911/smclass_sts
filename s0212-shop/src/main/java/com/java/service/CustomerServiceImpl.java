package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.CustomerMapper;
import com.java.dto.BoardDto;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired CustomerMapper customerMapper;
	int rowPerPage = 10; // 한페이지당 게시글 수
	
	@Override
	public Map<String, Object> notice(int page, String category) {
		int count = customerMapper.countAll(category);
		// 마지막 페이지 넘버링
		int maxpage = (int) Math.ceil((double)count/rowPerPage);
		// 첫번째 번호 넘버링
		int startpage = ((int) ((page-1)/10)) * 10 + 1;
		// 마지막 번호 넘버링
		int endpage = startpage + 10 - 1;
		if(endpage > maxpage) endpage = maxpage;
		
		//요청페이지별 검색번호
		int startrow = (page-1)*10+1; // 4페이지 31 ~
		int endrow = startrow + rowPerPage-1; // 4페이지 ~ 40
		
		System.out.println("maxpage : " + maxpage);
				
		ArrayList<BoardDto> list = customerMapper.selectAll(startrow, endrow);
		
		Map<String, Object> map = new HashMap<>();
		map.put("page", page);
		map.put("startpage", startpage);
		map.put("endpage", endpage);
		map.put("maxpage", maxpage);
		map.put("list", list);
		
		return map;
	}

	@Override
	public Map<String, Object> nview(int bno) {
		Map<String, Object> map = new HashMap<>();
		customerMapper.updateBhit(bno); // 조회수 1 증가
		BoardDto boardDto = customerMapper.selectOne(bno); // 현재게시글 정보
		BoardDto prevDto = customerMapper.selectOnePrev(bno); // 이전게시글 정보
		BoardDto nextDto = customerMapper.selectOneNext(bno); // 다음게시글 정보
		
		map.put("boardDto", boardDto);
		map.put("prevDto", prevDto);
		map.put("nextDto", nextDto);
		
		return map;
	}


}
