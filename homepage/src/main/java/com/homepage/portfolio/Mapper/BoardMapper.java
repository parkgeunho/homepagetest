package com.homepage.portfolio.Mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.homepage.portfolio.PagingUtill;
import com.homepage.portfolio.DTO.BoardDTO;
import com.homepage.portfolio.DTO.FileDTO;

@Repository
public interface BoardMapper {
	
	void insertBoard(BoardDTO dto);
	List<BoardDTO> seleteList(PagingUtill paging);
	
	void deleteBoard(int boardnum);
	
	void updateBoard(BoardDTO dto);
	BoardDTO selectBoard(int boardnum);
	int selectCount();
	
	void fileUploadTest(FileDTO dto);
}
