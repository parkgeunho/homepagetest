package com.homepage.portfolio.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homepage.portfolio.DTO.BoardDTO;
import com.homepage.portfolio.DTO.FileDTO;
import com.homepage.portfolio.DTO.SearchDTO;
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
	public List<BoardDTO> seleteList(SearchDTO search) {
		
		return boardmapper.seleteList(search);
	}


	@Override
	public void deleteBoard(int boardnum) {

		if(findfile(boardnum)!=null){
			
			boardmapper.deletefile(boardnum);
		}
		
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


	@Override
	public int selectCount(SearchDTO search) {
		return boardmapper.selectCount(search);
	}


	@Override
	public void fileUploadTest(List<FileDTO> filelist) {

		for (FileDTO f : filelist){
			
			boardmapper.fileUploadTest(f);
		}
		
	}


	@Override
	public void save(BoardDTO dto, List<FileDTO> files) {
		
		insertBoard(dto);
		fileUploadTest(files);
		
	}


	@Override
	public List<FileDTO> findfile(int boardnum) {

		return boardmapper.findfile(boardnum);
	}


	@Override
	public FileDTO downfile(int filenum) {
		
		return boardmapper.downfile(filenum);
	}








}
