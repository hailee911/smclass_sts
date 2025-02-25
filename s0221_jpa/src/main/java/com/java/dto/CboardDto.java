package com.java.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CboardDto { // 댓글db
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //자동시퀀스
	private int cno;

	@ManyToOne // 댓글개수여러개, id 1개
	@JoinColumn(name="id") // fk키 등록
	private MemberDto memberDto;
//	private String id;
	
	@Column(nullable = true, length = 100)
	private String cpw;
	
	@ManyToOne
	@JoinColumn(name="bno")
	private BoardDto boardDto;
//	private int bno;
	
	@Column(nullable = false, length = 2000)
	private String ccontent;
	
	@UpdateTimestamp
	private Timestamp cdate;
	
//	@OneToMany(mappedBy = "BoardDto")
//	private List<CboardDto> cboardDto;
}
