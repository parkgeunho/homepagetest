package com.homepage.portfolio.DTO;

public class ReplyDTO {
	
	private Integer boardnum;
	private Integer replynum;
	private String rewriter;
	private String recontent;
	private String deletecontent;
	private String date;
	
	private int reparent;
	private int redepth;
	private int reorder;
	
	
	
	
	public Integer getBoardnum() {
		return boardnum;
	}
	public void setBoardnum(Integer boardnum) {
		this.boardnum = boardnum;
	}
	public Integer getReplynum() {
		return replynum;
	}
	public void setReplynum(Integer replynum) {
		this.replynum = replynum;
	}
	public String getRewriter() {
		return rewriter;
	}
	public void setRewriter(String rewriter) {
		this.rewriter = rewriter;
	}
	public String getRecontent() {
		return recontent;
	}
	public void setRecontent(String recontent) {
		this.recontent = recontent;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getReparent() {
		return reparent;
	}
	public void setReparent(int reparent) {
		this.reparent = reparent;
	}
	public int getRedepth() {
		return redepth;
	}
	public void setRedepth(int redepth) {
		this.redepth = redepth;
	}
	public int getReorder() {
		return reorder;
	}
	public void setReorder(int reorder) {
		this.reorder = reorder;
	}
	public String getDeletecontent() {
		return deletecontent;
	}
	public void setDeletecontent(String deletecontent) {
		this.deletecontent = deletecontent;
	}
	
	
	
	
	

}
