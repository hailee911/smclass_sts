package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberMapper;
import com.java.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberMapper memberMapper;
	
	@Override
	public MemberDto login(MemberDto mdto) {
		System.out.println("MemberServiceImpl id : "+mdto.getId());
		MemberDto memberDto = memberMapper.selectLogin(mdto);
		return memberDto;
	}

	@Override //리액트 회원전체 가져오기
	public List<MemberDto> memberList() {
		List<MemberDto> list = memberMapper.selectAll();
		return list;
	}

	@Override
	public MemberDto memberView(String id) {
		MemberDto memberDto = memberMapper.selectOne(id);
		return memberDto;
	}

}
