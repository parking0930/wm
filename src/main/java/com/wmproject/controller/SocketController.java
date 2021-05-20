package com.wmproject.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.ServerEndpoint;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wmproject.domain.GameRoom;
import com.wmproject.domain.HttpSessionConfigurator;
import com.wmproject.domain.MemberVO;
import com.wmproject.domain.Message;
import com.wmproject.domain.Player;
import com.wmproject.domain.RoomManage;
import com.wmproject.service.MemberService;
 
@Controller
@ServerEndpoint(value="/socket", configurator=HttpSessionConfigurator.class)
public class SocketController {
	
	@Inject
    private MemberService service; // 추후 승리 수 또는 포인트 추가 시 사용
	
	private static RoomManage roomManage = new RoomManage();
	private Map<Session, EndpointConfig> configs = Collections.synchronizedMap(new HashMap<>());
    
    @OnOpen
    public void onOpen(Session session, EndpointConfig config) throws Exception {
    	if (!configs.containsKey(session)) {
    		configs.put(session, config);
    	}
    }
    
    @OnMessage
    public void onMessage(String message,Session session) throws Exception {
    	ObjectMapper mapper = new ObjectMapper();
    	Message msg =  mapper.readValue(message, new TypeReference<Message>(){});
    	
    	switch(msg.getEvent()) {
    		case "ADD": // 플레이어 추가 이벤트
    			addEventHandler(msg, session);
    			break;
    		case "CHAT": // 채팅 이벤트
    			chatEventHandler(msg, session);
    			break;
    	}
    	
    }
    
    @OnError
    public void onError(Throwable e,Session session) {
        
    }
    
    @OnClose
    public void onClose(Session session) throws Exception{
    	Player player = roomManage.getPlayerBySession(session);
    	if(player!=null) { // 해당 플레이어를 찾았으면
    		roomManage.playerOut(player);
    		roomManage.getRoomById(player.getRoomId()).setNowIn(roomManage.getRoomById(player.getRoomId()).getNowIn()-1); // 인원 1명 줄임
    		if(player.getRoomId().equals("Lobby")){ // 로비일 경우, Max가 없기에 구분함
    			RefreshUserList(player.getRoomId()); // 동접자 새로고침
    		}else { // 게임방일 경우 현재인원, 최대인원, 인원데이터 순으로 보냄
    			
    		}
    		sendMessageById(new Message(player.getRoomId(), "SYS", "시스템", player.getMember().getNickname()+"님이 퇴장하셨습니다."));
    		roomManage.getRoomById(player.getRoomId()).changeRoomMaker();
            roomManage.deleteRoom(); // 사람이 없는 방 제거
    	}else {
    		System.out.println("Error: 비정상적인 종료 발생! - onClose()");
    	}
		//sendRoomRefresh();
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void sendMessageById(Message sendMessage) throws Exception {
    	ObjectMapper mapper = new ObjectMapper();
    	String jsonMsg = mapper.writeValueAsString(sendMessage);

    	ArrayList<Player> playerlist = roomManage.getRoomById(sendMessage.getRoomId()).getPlayerlist();
    	if(playerlist.size()==0)
    		return;
    	for(int i=0;i<playerlist.size();i++) { // 해당 방 인원 수만큼 반복
    		playerlist.get(i).getSession().getBasicRemote().sendText(jsonMsg);
		}
    }
    
    public void addEventHandler(Message msg, Session session) throws Exception{
    	if (!configs.containsKey(session)) session.close(); // Map에 해당 세션이 없으면 내보냄
		EndpointConfig config = configs.get(session);
    	HttpSession httpSession = (HttpSession)config.getUserProperties().get(HttpSessionConfigurator.Session);
    	
    	boolean isCreate = false; // 새로 방을 만들었으면 새로고침을 방송하기 위한 변수
		
		if(!roomManage.isRoomExist(msg.getRoomId())) { // 플레이어가 접근하려는 방이 서버에 존재하지 않으면 생성
			GameRoom gameRoom = new GameRoom();
			gameRoom.setRoomId(msg.getRoomId());
			if(!msg.getRoomId().equals("Lobby")) { // 요청하는 방이 로비가 아니면
				//gameRoom.setRoomName(방 제목 예시..); // 방 제목 설정
				//System.out.println("새로운 방("+roomId+" : "+gameRoom.getRoomName()+")이 생성되었습니다.");
				//isCreate = 1;
			}
			else { // 로비 생성일 경우
				System.out.println("로비(Lobby)를 생성합니다.");
			}
			roomManage.AddRoom(gameRoom);
		}
		
		// 새로운 플레이어 생성
		Player newPlayer = new Player(((MemberVO)httpSession.getAttribute("member")), session, msg.getRoomId());
		
		if(!msg.getRoomId().equals("Lobby") && roomManage.getRoomById(msg.getRoomId()).getNowIn()==roomManage.getRoomById(msg.getRoomId()).getMaxIn()) {
			// 로비가 아닌 게임룸이고 방 인원이 꽉 찼으면 방을 나가도록 함
			//this.sendMessageById(msg.getRoomId(), "nowFull", "");
		}
		else {
			roomManage.AddPlayer(msg.getRoomId(), newPlayer);
    		roomManage.getRoomById(msg.getRoomId()).changeRoomMaker();
			///////////////////////// (추가) 입장 알림 /////////////////////////
			sendMessageById(new Message(msg.getRoomId(), "SYS", "시스템", newPlayer.getMember().getNickname()+"님이 입장하셨습니다."));
			////////////////////////////////////////////////////////////////
			
    		if(msg.getRoomId().equals("Lobby")){ // 로비일 경우, Max 인원이 없기에 구분함
    			RefreshUserList(msg.getRoomId());
    		}
    		else { // 게임 방일 경우(인원이 다 차지 않은 경우)
    			
    		}
		}
		
		if(isCreate) { // 이번 이벤트로 방을 만들었다면 새로고침 방송
			//sendRoomRefresh();
		}
    }
    
    public void chatEventHandler(Message msg, Session session) throws Exception{
    	if (!configs.containsKey(session)) session.close(); // Map에 해당 세션이 없으면 내보냄
		EndpointConfig config = configs.get(session);
    	HttpSession httpSession = (HttpSession)config.getUserProperties().get(HttpSessionConfigurator.Session);
    	
    	MemberVO member = (MemberVO)httpSession.getAttribute("member");
    	if(member==null) session.close(); // 세션 만료 혹은 다른 창에서 로그아웃 했을 시 대비
    	
    	sendMessageById(new Message(msg.getRoomId(), "CHAT", member, msg.getData2()));
    }
    
    public void RefreshUserList(String roomId) throws Exception {
		List<Player> playerList = roomManage.getRoomById(roomId).getPlayerlist();
		
		sendMessageById(new Message(roomId, "RefreshUserList"));
		
		for(Player p:playerList)
			sendMessageById(new Message(roomId, "AddUserToList", p.getMember().getProfile(),
					"Lv."+p.getMember().getLevel()+" "+p.getMember().getNickname()));
		
    }
}