package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor // 전체생성자
@NoArgsConstructor // 기본생성자
@Data // getter, setter 자동생성
public class StuDto {
	private String stuno;
	private String name;
	private String kor;
	private String eng;
	private String math;
	private int total;
	private double avg;
	
}
