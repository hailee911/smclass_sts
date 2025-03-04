package com.java.service;

import java.util.List;

import com.java.dto.MemberDto;

public interface MemberService {

	MemberDto login(MemberDto mdto);

	List<MemberDto> memberList(); //리액트 자바스크립트 회원 전체 가져오기 3/04

	MemberDto memberView(String id); //리액트 자바스크립트 회원 1명 가져오기 3/04

}
