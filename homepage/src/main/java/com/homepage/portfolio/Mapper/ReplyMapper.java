package com.homepage.portfolio.Mapper;

import org.springframework.stereotype.Repository;

import com.homepage.portfolio.DTO.ReplyDTO;

@Repository
public interface ReplyMapper {

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
}
