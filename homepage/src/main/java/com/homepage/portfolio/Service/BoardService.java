package com.homepage.portfolio.Service;

import java.util.List;

import com.homepage.portfolio.DTO.BoardDTO;

public interface BoardService {
	
	public void insertBoard(BoardDTO dto);
	public List<BoardDTO> seleteList();
}
