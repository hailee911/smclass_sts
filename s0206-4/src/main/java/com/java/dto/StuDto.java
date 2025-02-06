package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StuDto {
	private String stuno;
	private String name;
	private String kor;
	private String eng;
	private String math;
	private int total;
	private double avg;

}
