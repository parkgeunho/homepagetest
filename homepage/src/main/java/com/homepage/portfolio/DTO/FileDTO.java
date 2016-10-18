package com.homepage.portfolio.DTO;

public class FileDTO {
	
	private Integer filenum;
	private Integer boardnum;
	private String filename;
	private String originname;
	private long filesize;
	
	public Integer getFilenum() {
		return filenum;
	}
	public void setFilenum(Integer filenum) {
		this.filenum = filenum;
	}
	public Integer getBoardnum() {
		return boardnum;
	}
	public void setBoardnum(Integer boardnum) {
		this.boardnum = boardnum;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getOriginname() {
		return originname;
	}
	public void setOriginname(String originname) {
		this.originname = originname;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	
	
	

}
