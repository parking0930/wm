package com.wmproject.domain;

import java.util.Date;

public class BoardVO {
	private String board;
	private String id;
	private String title;
	private String contents;
	private String nickname;
	private String date;
	private int view;
	
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
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
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	@Override
	public String toString() {
		return "BoardVO [board=" + board + ", id=" + id + ", title=" + title + ", contents=" + contents + ", nickname="
				+ nickname + ", date=" + date + ", view=" + view + "]";
	}

}
