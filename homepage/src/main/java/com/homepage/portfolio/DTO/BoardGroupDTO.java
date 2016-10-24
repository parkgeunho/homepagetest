package com.homepage.portfolio.DTO;

public class BoardGroupDTO {
	
	
	private int boardGroupnum;        // 그룹 번호
	private String boardGroupName;    // 게시판 이름
	private int boardGroupParent;     // 부모값
	private String boardGroupUse;     // 사용 여부
	private String authorGroup;       // 그룹별 권한
	private String authorUser;        // 유저별 권한
	private String date; 			  // 만든 날짜
	
	
	
	
	public int getBoardGroupnum() {
		return boardGroupnum;
	}
	public void setBoardGroupnum(int boardGroupnum) {
		this.boardGroupnum = boardGroupnum;
	}
	public String getBoardGroupName() {
		return boardGroupName;
	}
	public void setBoardGroupName(String boardGroupName) {
		this.boardGroupName = boardGroupName;
	}
	public int getBoardGroupParent() {
		return boardGroupParent;
	}
	public void setBoardGroupParent(int boardGroupParent) {
		this.boardGroupParent = boardGroupParent;
	}
	public String getBoardGroupUse() {
		return boardGroupUse;
	}
	public void setBoardGroupUse(String boardGroupUse) {
		this.boardGroupUse = boardGroupUse;
	}
	public String getAuthorGroup() {
		return authorGroup;
	}
	public void setAuthorGroup(String authorGroup) {
		this.authorGroup = authorGroup;
	}
	public String getAuthorUser() {
		return authorUser;
	}
	public void setAuthorUser(String authorUser) {
		this.authorUser = authorUser;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	

}
