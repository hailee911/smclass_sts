package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.MemberDto;

@Mapper
public interface MemberMapper {

	MemberDto selectLogin(MemberDto mdto);

	List<MemberDto> selectAll(); // 리액트 자바스크립트 회원 전체 가져오기 3/04

	MemberDto selectOne(String id); // 리액트 자바스크립트 회원 1명 가져오기 3/04

}
