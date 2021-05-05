package com.wmproject.domain;

public class RankPagingVO {
	private int totalUser;
	private int cntPerPage;
	private int start; // SQL start

	public RankPagingVO(int totalUser, int start, int cntPerPage) {
		this.totalUser = totalUser;
		this.cntPerPage = cntPerPage;
		this.start = start;
	}

	public int getTotalUser() {
		return totalUser;
	}

	public void setTotalUser(int totalUser) {
		this.totalUser = totalUser;
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
		return "RankPagingVO [totalUser=" + totalUser + ", cntPerPage=" + cntPerPage + ", start=" + start + "]";
	}

}
