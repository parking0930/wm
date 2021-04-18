package com.wmproject.domain;

public class CommentVO {
	private int id;
	private int bid;
	private String board;
	private String comment;
	private String nickname;
	private String date;
	private MemberVO writerinfo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public MemberVO getWriterinfo() {
		return writerinfo;
	}
	public void setWriterinfo(MemberVO writerinfo) {
		this.writerinfo = writerinfo;
	}
	@Override
	public String toString() {
		return "CommentVO [id=" + id + ", bid=" + bid + ", board=" + board + ", comment=" + comment + ", nickname="
				+ nickname + ", date=" + date + ", writerinfo=" + writerinfo + "]";
	}
}
