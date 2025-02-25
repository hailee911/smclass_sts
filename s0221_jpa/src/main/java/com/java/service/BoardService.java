package com.java.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.java.dto.BoardDto;

public interface BoardService {

	BoardDto findById(int bno); // 게시글 가져오기

	Page<BoardDto> findAll(Pageable pageable);

}
