package com.homepage.portfolio.Mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.homepage.portfolio.DTO.BoardDTO;
import com.homepage.portfolio.DTO.FileDTO;
import com.homepage.portfolio.DTO.ReplyDTO;
import com.homepage.portfolio.DTO.SearchDTO;

@Repository
public interface BoardMapper {
	
	void insertBoard(BoardDTO dto);
	List<BoardDTO> seleteList(SearchDTO search);
	
	void deleteBoard(int boardnum);
	
	void updateBoard(BoardDTO dto);
	BoardDTO selectBoard(int boardnum);
	
	int selectCount(SearchDTO search);
	
	void fileUploadTest(FileDTO dto);
	
	List<FileDTO> findfile(int boardnum);
	FileDTO downfile(int filenum);
	
	void deletefile(int boardnum);
	
	
	
	// 댓글 저장
	void insertReply(ReplyDTO reply);
	
	// 댓글 단일 읽기
	ReplyDTO selectReply(int replynum);
	
	// 댓글수정
	void updateReply(ReplyDTO reply);
	
	// 순서변환
	void updateOrder(ReplyDTO reply);
	
	// 삭제
	void deleteReply(int replynum);
	
	List<ReplyDTO> listreply(int boardnum);
	
	int maxreplynum();
	
	
	
	
	
	
}
