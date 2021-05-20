package com.wmproject.domain;

import java.util.ArrayList;
import java.util.List;

public class GameRoom {
	private String roomId;
	private String roomName;
	private String roomMaker;
	private int nowIn;
	private int maxIn;
	
	private ArrayList<Player> playerlist;
	
	public GameRoom() {
		playerlist = new ArrayList<Player>();
		nowIn = 0;
		maxIn = 2;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	public String getRoomMaker() {
		return roomMaker;
	}

	public void setRoomMake(String roomMaker) {
		this.roomMaker = roomMaker;
	}
	
	public int getNowIn() {
		return nowIn;
	}

	public void setNowIn(int nowIn) {
		this.nowIn = nowIn;
	}

	public int getMaxIn() {
		return maxIn;
	}

	public void setMaxIn(int maxIn) {
		this.maxIn = maxIn;
	}
	
	public ArrayList<Player> getPlayerlist() {
		return playerlist;
	}

	public void setPlayerlist(ArrayList<Player> playerlist) {
		this.playerlist = playerlist;
	}
	
	public void RoomOut(Player player) {
		for(int i=0;i<playerlist.size();i++) {
			if(playerlist.get(i).getMember().getId().equals(player.getMember().getId())) { // 해당 플레이어를 찾으면
				playerlist.remove(i);
				return;
			}
		}
		System.out.println("Error: Player is not exist - RoomOut()");
	}
	
	public void changeRoomMaker() {
		if(playerlist.size()==0) return;
		for(int i=0;i<playerlist.size();i++) { // 방 만든이가 존재하면 방장 변경 취소
			if(playerlist.get(i).getMember().getNickname().equalsIgnoreCase(this.roomMaker))
				return;
		}
		this.roomMaker = playerlist.get(0).getMember().getNickname(); // 방 만든이가 없으면 다음 사람으로 방장 변경
	}
}