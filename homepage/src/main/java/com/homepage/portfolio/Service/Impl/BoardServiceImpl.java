package com.homepage.portfolio.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homepage.portfolio.DTO.BoardDTO;
import com.homepage.portfolio.Mapper.BoardMapper;
import com.homepage.portfolio.Service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	
	@Autowired
	BoardMapper boardmapper;
	
	
	@Override
	public void insertBoard(BoardDTO dto) {
		
		boardmapper.insertBoard(dto);
	}


	@Override
	public List<BoardDTO> seleteList() {
		
		return boardmapper.seleteList();
	}


	@Override
	public void deleteBoard(int boardnum) {

		boardmapper.deleteBoard(boardnum);
		
	}


	@Override
	public void updateBoard(BoardDTO dto) {
		
		boardmapper.updateBoard(dto);
		
	}


	@Override
	public BoardDTO selectBoard(int boardnum) {
		BoardDTO dto = boardmapper.selectBoard(boardnum);
		return dto;
	}



}
