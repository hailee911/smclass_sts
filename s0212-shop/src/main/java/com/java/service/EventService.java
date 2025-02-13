package com.java.service;

import java.util.ArrayList;

import com.java.dto.CboardDto;
import com.java.dto.EventDto;

public interface EventService {

	ArrayList<EventDto> event(); //이벤트 리스트 가져오기

	EventDto eview(int eno); //이벤트 상세보기

	ArrayList<CboardDto> clist(int eno); //하단 댓글 리스트 가져오기

	CboardDto cwrite(CboardDto cdto);


}
