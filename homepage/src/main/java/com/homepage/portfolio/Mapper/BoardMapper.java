package com.homepage.portfolio.Mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.homepage.portfolio.DTO.BoardDTO;

@Repository
public interface BoardMapper {
	
	void insertBoard(BoardDTO dto);
	List<BoardDTO> seleteList();
	
	void deleteBoard(int boardnum);
	
	void updateBoard(BoardDTO dto);
	BoardDTO selectBoard(int boardnum);
}
