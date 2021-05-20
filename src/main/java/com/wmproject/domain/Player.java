package com.wmproject.domain;

import javax.websocket.Session;

public class Player {
	private String roomId;
	private MemberVO member;
	private Session session;
		
	public Player(MemberVO member, Session session, String roomId) {
		this.member = member;
		this.session = session;
		this.roomId = roomId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public MemberVO getMember() {
		return member;
	}

	public void setMember(MemberVO member) {
		this.member = member;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public String toString() {
		return "Player [roomId=" + roomId + ", member=" + member + ", session=" + session + "]";
	}
	
}