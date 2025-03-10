package com.java.service;

import java.util.List;

import com.java.dto.MemberDto;

public interface MemberService {

	// 회원가입
	void save(MemberDto mdto);

	// 전체 회원리스트
	List<MemberDto> findAll();

	// 회원정보 1명
	MemberDto findById(String id);

	void deleteById(String id);

	MemberDto findByIdAndPw(String id, String pw);





}
