package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface CustomerMapper {

	ArrayList<BoardDto> selectAll(int startrow, int endrow);

	BoardDto selectOne(int bno);

	void updateBhit(int bno);

	BoardDto selectOnePrev(int bno);

	BoardDto selectOneNext(int bno);

	int countAll(String category);


}
