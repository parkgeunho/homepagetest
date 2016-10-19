package com.homepage.portfolio.Service;

import java.util.List;

import com.homepage.portfolio.PagingUtill;
import com.homepage.portfolio.DTO.BoardDTO;
import com.homepage.portfolio.DTO.FileDTO;

public interface BoardService {
	
	public void insertBoard(BoardDTO dto);
	public List<BoardDTO> seleteList(PagingUtill paging);
	
	
	public void deleteBoard(int boardnum);
	
	public void updateBoard(BoardDTO dto);
	public BoardDTO selectBoard(int boardnum);
	
	public int selectCount();
	
	public void fileUploadTest(List<FileDTO> filelist);
	
	public void save(BoardDTO dto , List<FileDTO> files);
	
	public List<FileDTO> findfile(int boardnum);
	
	public FileDTO downfile(int filenum);
}
