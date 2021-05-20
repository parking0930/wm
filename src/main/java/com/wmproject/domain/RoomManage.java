package com.wmproject.domain;


import java.util.ArrayList;

import javax.websocket.Session;

public class RoomManage {
	private ArrayList<GameRoom> roomlist;
	
	public RoomManage() {
		roomlist = new ArrayList<GameRoom>();
	}
	
	public ArrayList<GameRoom> getRoomlist() {
		return roomlist;
	}

	public void setRoomlist(ArrayList<GameRoom> roomlist) {
		this.roomlist = roomlist;
	}
	
	public void AddRoom(GameRoom g) {
		roomlist.add(g);
	}
	
	public void AddPlayer(String roomId, Player player) {
		for(int i=0;i<roomlist.size();i++) {
			if(roomlist.get(i).getRoomId().equals(roomId)) {
				GameRoom gameRoom = roomlist.get(i);
				gameRoom.getPlayerlist().add(player);
				gameRoom.setNowIn(gameRoom.getNowIn()+1);
				return;
			}
		}
		System.out.println("Error : Room is not exist - AddPlayer");
	}
	
	public boolean isRoomExist(String roomId) {
		for(int i=0;i<roomlist.size();i++) {
			if(roomlist.get(i).getRoomId().equals(roomId))
				return true;
		}
		return false;
	}
	
	public Player getPlayerBySession(Session session) {
		for(int i=0;i<roomlist.size();i++) {
			for(int j=0;j<roomlist.get(i).getPlayerlist().size();j++) {
				if(roomlist.get(i).getPlayerlist().get(j).getSession().equals(session)) {
					return roomlist.get(i).getPlayerlist().get(j);
				}
			}
		}
		return null;
	}
	
	public GameRoom getRoomById(String roomId) {
		for(int i=0;i<roomlist.size();i++) {
			if(roomlist.get(i).getRoomId().equals(roomId))
				return roomlist.get(i);
		}
		return null;
	}
	
	public void playerOut(Player player) {
		for(int i=0;i<roomlist.size();i++) {
			if(roomlist.get(i).getRoomId().equals(player.getRoomId())) { // 플레이어가 속한 방을 찾음
				roomlist.get(i).RoomOut(player);
			}
		}
	}
	
	public void deleteRoom() { // 방에 사람이 없으면 방을 지움
		for(int i=0;i<roomlist.size();i++) {
			if(roomlist.get(i).getPlayerlist().size()==0) {
				System.out.println(roomlist.get(i).getRoomId()+" 방이 삭제됩니다.");
				roomlist.remove(i);
			}
		}
	}
	
	public String setRoomId() {
		if(roomlist.size() == 1) return "1"; // WaitRoom밖에 없는 상태면 1번방 지정
		if(roomlist.get(roomlist.size()-1).getRoomId().equals("Hello")) { // 마지막 방이 WaitRoom 이면
			int roomId = Integer.parseInt(roomlist.get(roomlist.size()-2).getRoomId())+1;
			return Integer.toString(roomId); // 마지막 방이 WaitRoom이 아니면
		}else {
			int roomId = Integer.parseInt(roomlist.get(roomlist.size()-1).getRoomId())+1;
			return Integer.toString(roomId); // 마지막 방이 WaitRoom이 아니면
		}
	}
}