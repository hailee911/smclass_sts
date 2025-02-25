package com.java.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.dto.BoardDto;

public interface BoardRepository extends JpaRepository<BoardDto, Integer> {

	Page<BoardDto> findAll(Pageable pageable);
	
	
//	@Query(value = "select * from boarddto order by bgroup desc, bstep asc", nativeQuery = true)
//	List<BoardDto> findAll();

}
