package com.wmproject.domain;

public class Message {
	private String roomId;
	private String event;
	private Object data;
	private Object data2;
	
	public Message() {}

	public Message(String roomId, String event) {
		this.roomId = roomId;
		this.event = event;
		this.data = "";
		this.data2 = "";
	}
	
	public Message(String roomId, String event, Object data) {
		this.roomId = roomId;
		this.event = event;
		this.data = data;
		this.data2 = "";
	}
	
	public Message(String roomId, String event, Object data, Object data2) {
		this.roomId = roomId;
		this.event = event;
		this.data = data;
		this.data2 = data2;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getData2() {
		return data2;
	}

	public void setData2(Object data2) {
		this.data2 = data2;
	}

	@Override
	public String toString() {
		return "Message [roomId=" + roomId + ", event=" + event + ", data=" + data + ", data2=" + data2 + "]";
	}
	
}
