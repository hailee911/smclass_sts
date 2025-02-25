package com.java.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

@DynamicInsert // 데이터값이 null경우 컬럼에서 제외
@Entity //jpa자동생성 - memberDto테이블 : 컬럼생성
public class MemberDto {

	@Id // primary key 생성
	@Column(length=100)
	private String id;
	
	@Column(nullable = false, length=100)
	private String pw;
	
	@Column(nullable = false, length=50)
	private String name;
	
	@Column(length=20)
	private String phone;
	
	@ColumnDefault(" '남자' ")
	private String gender;
	
	@Column(length = 100)
	private String hobby;
	
	@CreationTimestamp // 시간자동입력 - sysdate
	private Timestamp mdate;
}
