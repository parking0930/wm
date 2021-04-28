package com.wmproject.domain;

public class PagingVO {
	private String board;
	private int nowPage;
	private int startPage;
	private int endPage;
	private int total;
	private int cntInPage;
	private int lastPage;
	private int start; // SQL start
	private int end; // SQL end
	private int cntPageLength = 5; // 한번에 보여줄 페이지 수
	
	public PagingVO(String board, int total, int nowPage, int cntInPage) {
		this.board = board;
		this.nowPage = nowPage;
		this.total = total;
		this.cntInPage = cntInPage;
		calcLastPage();
		calcPage();
		calcStartEnd();
	}
	public void calcLastPage() { // 마지막 페이지 계산
		this.lastPage = this.total / this.cntInPage + 1;
	}
	public void calcPage() { // 현재 페이지 기준 처음과 끝 페이지 계산
		int calc = (int)Math.ceil((double)this.nowPage / (double)cntPageLength);
		if(this.lastPage <= 5)
		{
			this.endPage = this.lastPage;
			this.startPage = 1;
		}else {
			this.endPage = 5 * calc;
			this.startPage = this.endPage - 4;
			
			if(this.endPage > this.lastPage)
				this.endPage = this.lastPage;
		}
	}
	public void calcStartEnd() { // 시작과 끝 게시글을 계산
		this.end = this.nowPage * this.cntInPage;
		this.start = this.end - this.cntInPage + 1;
		if(this.start!=0) this.start -= 1;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCntInPage() {
		return cntInPage;
	}
	public void setCntInPage(int cntInPage) {
		this.cntInPage = cntInPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getCntPageLength() {
		return cntPageLength;
	}
	public void setCntPageLength(int cntPageLength) {
		this.cntPageLength = cntPageLength;
	}
	@Override
	public String toString() {
		return "PagingVO [board=" + board + ", nowPage=" + nowPage + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", total=" + total + ", cntInPage=" + cntInPage + ", lastPage=" + lastPage + ", start=" + start
				+ ", end=" + end + ", cntPageLength=" + cntPageLength + "]";
	}
	
}
