package com.homepage.portfolio.Service;

import java.util.List;

import com.homepage.portfolio.DTO.BoardDTO;
import com.homepage.portfolio.DTO.FileDTO;
import com.homepage.portfolio.DTO.ReplyDTO;
import com.homepage.portfolio.DTO.SearchDTO;

public interface BoardService {
	
	public void insertBoard(BoardDTO dto);
	public List<BoardDTO> seleteList(SearchDTO search);
	
	
	public void deleteBoard(int boardnum);
	
	public void updateBoard(BoardDTO dto);
	public BoardDTO selectBoard(int boardnum);
	
	public int selectCount(SearchDTO search);
	
	public void fileUploadTest(List<FileDTO> filelist);
	
	public void save(BoardDTO dto , List<FileDTO> files);
	
	public List<FileDTO> findfile(int boardnum);
	
	public FileDTO downfile(int filenum);
	
	
	
	
	
	
	// 댓글 저장
	public void insertReply(ReplyDTO reply);
	
	// 댓글 단일 읽기
	public ReplyDTO selectReply(int replynum);
	
	// 댓글수정
	public void updateReply(ReplyDTO reply);
	
	// 순서변환
	public void updateOrder(ReplyDTO reply);
	
	// 삭제
	public void deleteReply(int replynum);
	
	public int maxreplynum();
}
