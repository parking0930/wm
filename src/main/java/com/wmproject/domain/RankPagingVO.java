package com.wmproject.domain;

public class RankPagingVO {
	private int cntPerPage;
	private int start; // SQL start

	public RankPagingVO(int start, int cntPerPage) {
		this.cntPerPage = cntPerPage;
		this.start = start;
	}

	public int getCntPerPage() {
		return cntPerPage;
	}

	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	@Override
	public String toString() {
		return "RankPagingVO [cntPerPage=" + cntPerPage + ", start=" + start + "]";
	}

}