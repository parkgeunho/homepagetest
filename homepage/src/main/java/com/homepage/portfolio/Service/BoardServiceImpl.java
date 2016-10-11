package com.homepage.portfolio.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homepage.portfolio.DTO.BoardDTO;
import com.homepage.portfolio.Mapper.BoardMapper;

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
	
	

}
