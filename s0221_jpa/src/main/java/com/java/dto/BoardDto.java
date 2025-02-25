package com.java.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BoardDto {
//	@SequenceGenerator(name = "board_seq_generator", //시퀀스 이름 
//					   sequenceName = "boarddto_seq", // 생성된 시퀀스 이름
//					   initialValue = 1, // 초기값
//					   allocationSize = 1 // 증가값
//						)
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //시퀀스 자동생성

	private int bno;
	
	@Column(nullable = false, length = 100)
	private String btitle;
	
	@Lob // 대용량 데이터
	private String bcontent;
	
//	select * from boarddto, memberdto where boarddto.id = memberdto.id;
	
	@ManyToOne(fetch = FetchType.EAGER) // 한 사람이 여러 게시글 작성 가능
	@JoinColumn(name = "id") // Fk키 등록
	private MemberDto memberDto; // memberdto 테이블 primary key - 객체타입 입력불가
	
	private int bgroup; //답변달기 그룹핑
	
	@ColumnDefault("0") // 숫자 "0", 문자 "'남자'"
	private int bstep;  //답변달기 순서
	
	@ColumnDefault("0") // 숫자 "0", 문자 "'남자'"
	private int bindent;//답변달기 들여쓰기
	
	@ColumnDefault("0") // 숫자 "0", 문자 "'남자'"
	private int bhit;
	
	@UpdateTimestamp // 자동시간 입력
	private Timestamp bdate;
	
	@Column(nullable = true, length = 100)
	private String bfile;

	

}
