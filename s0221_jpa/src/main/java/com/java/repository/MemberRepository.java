package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.dto.MemberDto;

// JpaRepository<MemberDto, String> : <리턴타입, primary key 타입>
public interface MemberRepository extends JpaRepository<MemberDto, String> {
	
//	MemberDto 로그인부분 쿼리
//	@Query(value = "select * from memberDto where id=? and pw=? order by bgroup desc, bstep asc", nativeQuery = true)
//	Optional<MemberDto> findByIdAndPW(String id, String pw);
	
	//select * from memberDto where id = #{id} and pw = #{pw}
	MemberDto findByIdAndPw(String id, String pw);

}
