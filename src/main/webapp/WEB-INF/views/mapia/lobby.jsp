<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>WEB MAPIA - Lobby</title>
	<link href="<c:url value="/resources/css/defaultSetting.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/lobby.css" />" rel="stylesheet">
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/lobby.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/GameRoomTime.js" />"></script>
</head>
<body>
	<div id="body_wrap">
		<div id="top_content">
			<div id="img_div">
				<img id="mapia_logo" src="<c:url value="/resources/img/webmapiaMini.png" />">
			</div>
			<div id="player_div">
				<div id="player_wrap">
					<div id="top_profile_div">
						<img id="top_profile_img" src="<c:url value="/resources/upload/profile/${member.profile}"/>">
					</div>
					<div id="top_player_info">Lv.${member.level} ${member.nickname}님</div>
				</div>
			</div>
			<div id="split_div">
				|
			</div>
			<div id="now_time">
				PM 12:00
			</div>
		</div>
		<div id="main_content">
			<div id="room_info">
				<div id="room_top">
					<div class="title_font"># 대기방 정보</div>
				</div>
				<div id="room_content">
					<table style="border-collapse:collapse;">
						<tr class="room_tr">
							<td class="room_no">1</td>
							<td class="room_title">마피아 ㄱㄱ</td>
							<td class="room_creator">관리자</td>
							<td class="room_status">10/10</td>
						</tr>
						<tr class="room_tr">
							<td class="room_no">ㅇㅇ</td>
							<td class="room_title">ㅇㅇ</td>
							<td class="room_creator">ㅇㅇ</td>
							<td class="room_status">ㅇㅇ</td>
						</tr>
						<tr class="room_tr">
							<td class="room_no">ㅇㅇ</td>
							<td class="room_title">ㅇㅇ</td>
							<td class="room_creator">ㅇㅇ</td>
							<td class="room_status">ㅇㅇ</td>
						</tr>
						<tr class="room_tr">
							<td class="room_no">ㅇㅇ</td>
							<td class="room_title">ㅇㅇ</td>
							<td class="room_creator">ㅇㅇ</td>
							<td class="room_status">ㅇㅇ</td>
						</tr>
						<tr class="room_tr">
							<td class="room_no">ㅇㅇ</td>
							<td class="room_title">ㅇㅇ</td>
							<td class="room_creator">ㅇㅇ</td>
							<td class="room_status">ㅇㅇ</td>
						</tr>
						<tr class="room_tr">
							<td class="room_no">ㅇㅇ</td>
							<td class="room_title">ㅇㅇ</td>
							<td class="room_creator">ㅇㅇ</td>
							<td class="room_status">ㅇㅇ</td>
						</tr>
						<tr class="room_tr">
							<td class="room_no">ㅇㅇ</td>
							<td class="room_title">ㅇㅇ</td>
							<td class="room_creator">ㅇㅇ</td>
							<td class="room_status">ㅇㅇ</td>
						</tr>
						<tr class="room_tr">
							<td class="room_no">ㅇㅇ</td>
							<td class="room_title">ㅇㅇ</td>
							<td class="room_creator">ㅇㅇ</td>
							<td class="room_status">ㅇㅇ</td>
						</tr>
						<tr class="room_tr">
							<td class="room_no">ㅇㅇ</td>
							<td class="room_title">ㅇㅇ</td>
							<td class="room_creator">ㅇㅇ</td>
							<td class="room_status">ㅇㅇ</td>
						</tr>
						<tr class="room_tr">
							<td class="room_no">ㅇㅇ</td>
							<td class="room_title">ㅇㅇ</td>
							<td class="room_creator">ㅇㅇ</td>
							<td class="room_status">ㅇㅇ</td>
						</tr>
						<tr class="room_tr">
							<td class="room_no">ㅇㅇ</td>
							<td class="room_title">ㅇㅇ</td>
							<td class="room_creator">ㅇㅇ</td>
							<td class="room_status">ㅇㅇ</td>
						</tr>
						<tr class="room_tr">
							<td class="room_no">ㅇㅇ</td>
							<td class="room_title">ㅇㅇ</td>
							<td class="room_creator">ㅇㅇ</td>
							<td class="room_status">ㅇㅇ</td>
						</tr>
						<tr class="room_tr">
							<td class="room_no">ㅇㅇ</td>
							<td class="room_title">ㅇㅇ</td>
							<td class="room_creator">ㅇㅇ</td>
							<td class="room_status">ㅇㅇ</td>
						</tr>
						<tr class="room_tr">
							<td class="room_no">ㅇㅇ</td>
							<td class="room_title">ㅇㅇ</td>
							<td class="room_creator">ㅇㅇ</td>
							<td class="room_status">ㅇㅇ</td>
						</tr>
						<tr class="room_tr">
							<td class="room_no">ㅇㅇ</td>
							<td class="room_title">ㅇㅇ</td>
							<td class="room_creator">ㅇㅇ</td>
							<td class="room_status">ㅇㅇ</td>
						</tr>
						<tr class="room_tr">
							<td class="room_no">ㅇㅇ</td>
							<td class="room_title">ㅇㅇ</td>
							<td class="room_creator">ㅇㅇ</td>
							<td class="room_status">ㅇㅇ</td>
						</tr>
						<tr class="room_tr">
							<td class="room_no">ㅇㅇ</td>
							<td class="room_title">ㅇㅇ</td>
							<td class="room_creator">ㅇㅇ</td>
							<td class="room_status">ㅇㅇ</td>
						</tr>
						<tr class="room_tr">
							<td class="room_no">ㅇㅇ</td>
							<td class="room_title">ㅇㅇ</td>
							<td class="room_creator">ㅇㅇ</td>
							<td class="room_status">ㅇㅇ</td>
						</tr>
					</table>
				</div>
				<div id="room_menu">
					<div class="btn_design">방 만들기</div>
					<div class="btn_design">새로고침</div>
				</div>
			</div>
			<div id="center_content">
				<div id="connect_area">
					<div id="connect_top">
						<div id="userCount" class="title_font"># 동시 접속자: 0</div>
					</div>
					<div id="connect_member">
						<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
					</div>
				</div>
				<div id="chat_area">
					<div id="chat_top">
						<div class="title_font"># 채팅방</div>
					</div>
					<div id="chat_content">
						<!-- 채팅이 들어갈 영역입니다. -->
					</div>
					<div id="chat_input">
						<input id="chat_input_design" type="text" placeholder="채팅을 입력하세요.">
					</div>
				</div>
			</div>
			<div id="right_content">
				<div id="my_info">
					<div id="my_info_top">
						<div class="title_font"># 내 정보</div>
						<div id="logout_btn" onclick="location.href='/member/logout';">로그아웃</div>
					</div>
					<div id="my_info_inner">
						<img id="my_info_profile_img" src="<c:url value="/resources/upload/profile/${member.profile}"/>">
						<div class="my_info_text">Lv.${member.level} ${member.nickname}</div>
						<div class="my_info_subtext">포인트: ${member.point}</div>
						<div class="my_info_subtext">전적: ${member.win}승 ${member.lose}패</div>
						<div class="my_info_subtext">가입일: ${member.date}</div>
					</div>
				</div>
				<div id="user_ranking">
					<div id="ranking_top">
						<div class="title_font"># 종합 랭킹</div>
					</div>
					<div id="ranking_area">
						<table style="border-collapse:collapse;">
							<c:forEach var="memberVO" items="${rankingList}" varStatus="status">
							<tr class="ranking_tr">
							<c:if test="${status.count==1}">
								<td class="ranking_no"><img class="ranking_img"src="<c:url value="/resources/img/gold.png"/>"></td>
							</c:if>
							<c:if test="${status.count==2}">
								<td class="ranking_no"><img class="ranking_img"src="<c:url value="/resources/img/silver.png"/>"></td>
							</c:if>
							<c:if test="${status.count==3}">
								<td class="ranking_no"><img class="ranking_img"src="<c:url value="/resources/img/bronze.png"/>"></td>
							</c:if>
							<c:if test="${status.count>3}">
								<td class="ranking_no">${status.count}</td>
							</c:if>
								<td class="ranking_nickname">
									<div class="ranking_user_area_wrap">
										<img class="ranking_profile" src="<c:url value="/resources/upload/profile/${memberVO.profile}"/>">
										<div class="ranking_user_area">Lv.${memberVO.level} ${memberVO.nickname}</div>
									</div>
								</td>
							</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				<div id="notice">
					<div id="megaphone_div">
						<img id="megaphone_img" src="<c:url value="/resources/img/megaphone.png"/>">
					</div>
					<div id="notice_text">
						공지사항: 공지사항이 없습니다.
					</div>
				</div>
				<div id="howtoGame">
					게임 방법
				</div>
				<div id="exitBtn" onclick="location.href='/';">
					Exit Game
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	var nickname = "${member.nickname}";
</script>
</html>