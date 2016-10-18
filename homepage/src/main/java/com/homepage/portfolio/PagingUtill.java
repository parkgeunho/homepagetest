package com.homepage.portfolio;

public class PagingUtill {
	
	
	private Integer displayDataCount = 1;           // 출력할 데이터 개수
	private Integer rowStart;                       // 시작행번호
	private Integer rowEnd;                         // 종료행 번호
	private Integer totalPage;                        // 전체 페이수
	private Integer totalData = 0;                     // 전체 데이터 수
	private Integer page;                           // 현재 페이지
	private Integer pageStart;                      // 시작페이지
	private Integer pageEnd;                        // 종료페이지
	private Integer displayPageCount = 5;			// 표기할 페이지 수
	
	//dataCount : 전체 데이터의 갯수
	public void getPageCount(int dataCount){
		getPage();
		totalData = dataCount;
		totalPage = totalData / displayDataCount;
		
		if(dataCount % displayDataCount != 0)
			totalPage++;
		
		pageStart = (page - (page - 1 ) % displayPageCount);
		pageEnd = pageStart + displayPageCount-1;
		
		if (pageEnd>totalPage) {
			pageEnd = totalPage;
		}
		
        rowStart = ((page - 1) * displayDataCount) + 1 ;
        rowEnd   = rowStart + displayDataCount - 1;
	}
	
	



	public Integer getPage() {
		
		 if (page == null || page == 0) {
	            page = 1;
	        }
		return page;
	}





	public Integer getDisplayDataCount() {
		return displayDataCount;
	}


	public void setDisplayDataCount(Integer displayDataCount) {
		this.displayDataCount = displayDataCount;
	}


	public Integer getRowStart() {
		return rowStart;
	}


	public void setRowStart(Integer rowStart) {
		this.rowStart = rowStart;
	}


	public Integer getRowEnd() {
		return rowEnd;
	}


	public void setRowEnd(Integer rowEnd) {
		this.rowEnd = rowEnd;
	}


	public Integer getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}


	public Integer getTotalData() {
		return totalData;
	}


	public void setTotalData(Integer totalData) {
		this.totalData = totalData;
	}


	public Integer getPageStart() {
		return pageStart;
	}


	public void setPageStart(Integer pageStart) {
		this.pageStart = pageStart;
	}


	public Integer getPageEnd() {
		return pageEnd;
	}


	public void setPageEnd(Integer pageEnd) {
		this.pageEnd = pageEnd;
	}


	public Integer getDisplayPageCount() {
		return displayPageCount;
	}


	public void setDisplayPageCount(Integer displayPageCount) {
		this.displayPageCount = displayPageCount;
	}


	public void setPage(Integer page) {
		this.page = page;
	}
	
	
	
	
		
	
}
