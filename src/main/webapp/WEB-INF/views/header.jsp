<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>WEB MAPIA - HEADER</title>
	<link href="<c:url value="/resources/css/defaultSetting.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet">
</head>
<body>
	<div id="top">
		<div id="locationBar">
			<div id="top_location_wrap">
				<div id="top_location_left">
					<img id="top_main_logo" src="<c:url value="/resources/img/GameListLogo.png" />">
					<img id="top_location_logo_now" src="<c:url value="/resources/img/webmapiaMini.png" />">
					<img class="top_location_logo" src="<c:url value="/resources/img/halligalliMini.png" />">
					
				</div>
				<div id="top_location_right">
					<%if(session.getAttribute("member")==null){ %>
					<a href="/login" class="top_location_text">로그인</a>
					<a href="/signUp" class="top_location_text">회원가입</a>
					<%}else{ %>
					<a href="/member/logout" class="top_location_text">로그아웃</a>
					<a href="/member/mypage" class="top_location_text">마이페이지</a>
					<%} %>
				</div>
			</div>
		</div>
		<div id="MenuBar">
			<div id="top_MenuBar_wrap">
				<div id="top_MenuBar_left">
					<img id="top_mainLogo" src="<c:url value="/resources/img/Logo.png" />" onclick="location.href='/';">
				</div>
				<div id="top_MenuBar_right">
					<a href="/board?board=notice" class="top_MenuBar_text">공지사항</a>
					<a href="/board?board=free" class="top_MenuBar_text">커뮤니티</a>
					<a href="/ranking" class="top_MenuBar_text">랭킹</a>
					<a href="/shop" class="top_MenuBar_text">포인트샵</a>
					<a href="/board/tel" class="top_MenuBar_text">고객센터</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>