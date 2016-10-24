package com.homepage.portfolio.DTO;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {
	
	private int boardnum; // 번호
	private String subject; //제목
	private String content; //내용
	private String date; //작성일
	
	private String reparent; // 부모값
    private String redepth;  // 들어갈 값
    private Integer reorder; // 순서값
    private int group; // 그룹값
    
    private List<MultipartFile> uploadlists;
    
    
    
	
    
    
	
	public List<MultipartFile> getUploadlists() {
		return uploadlists;
	}
	public void setUploadlists(List<MultipartFile> uploadlists) {
		this.uploadlists = uploadlists;
	}
	public String getReparent() {
		return reparent;
	}
	public void setReparent(String reparent) {
		this.reparent = reparent;
	}
	public String getRedepth() {
		return redepth;
	}
	public void setRedepth(String redepth) {
		this.redepth = redepth;
	}
	public Integer getReorder() {
		return reorder;
	}
	public void setReorder(Integer reorder) {
		this.reorder = reorder;
	}
	public int getBoardnum() {
		return boardnum;
	}
	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	
	
}
