package com.java.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.java.dto.BoardDto;
import com.java.repository.BoardRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {
	
    @Autowired BoardRepository boardRepository;
    
//	@Override
//	public List<BoardDto> findAll() {
		
		// Sort 다중 정렬을 사용해서 검색
//		Sort sort = Sort.by(Sort.Order.desc("bgroup"), Sort.Order.asc("bstep"));
//		List<BoardDto> list = boardRepository.findAll(sort);
		
		// nativeQuery - repository 정렬
//		List<BoardDto> list = boardRepository.findAll();
//		return list;
//	}

	@Override
	public BoardDto findById(int bno) {
		BoardDto boardDto = boardRepository.findById(bno).orElseThrow(() ->{return new IllegalArgumentException("게시글이 존재하지 않습니다."); });
		
		boardDto.setBhit(boardDto.getBhit() + 1); // 조회수 증가
//		boardRepository.save(boardDto); // transactional 사용시 save 안해도 됨
		return boardDto;
	}

	@Override
	public Page<BoardDto> findAll(Pageable pageable) {
		Page<BoardDto> page = boardRepository.findAll(pageable);
		return page;
	}

}
