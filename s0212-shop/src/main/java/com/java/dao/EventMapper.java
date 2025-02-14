package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.CboardDto;
import com.java.dto.EventDto;

@Mapper
public interface EventMapper {

	ArrayList<EventDto> selectAll();

	EventDto selectOne(int eno);

	ArrayList<CboardDto> selectAllCboard(int eno);

	//댓글 저장하기
	void insertCboard(CboardDto cdto);
	//댓글 수정하기
	void updateCboard(CboardDto cdto);

	//저장된 댓글 가져오기
	CboardDto selectOneCboard(int cno);

	//댓글 삭제하기
	void deleteCboard(int cno);


	
}
