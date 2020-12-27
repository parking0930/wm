<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>WEB MAPIA - MAIN</title>
	<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div id="banner_div">
		<div id="banner_div_wrap">
			<div id="banner_text_wrap">
				<font class="banner_text">WELCOME</font><br>
				<font class="banner_text">TO WEB MAPIA</font>
			</div>
		</div>
	</div>
	<div id="contents_div">
		<div id="contents_div_wrap">
			<div class="board_contents">
				<div class="title_div">
					<font class="board_name_text">공지사항</font>
					<font class="board_more_text">더보기</font>
				</div>
				<div class="board_title">
					<font class="board_title_font">· 테스트용 게시글입니다.</font>
				</div>
				<div class="board_title">
					<font class="board_title_font">· 테스트용 게시글입니다.</font>
				</div>
				<div class="board_title">
					<font class="board_title_font">· 테스트용 게시글입니다.</font>
				</div>
				<div class="board_title">
					<font class="board_title_font">· 테스트용 게시글입니다.</font>
				</div>
				<div class="board_title">
					<font class="board_title_font">· 테스트용 게시글입니다.</font>
				</div>
				<div class="board_title">
					<font class="board_title_font">· 테스트용 게시글입니다.</font>
				</div>
			</div>
			<div class="board_contents">
				<div class="title_div">
					<font class="board_name_text">커뮤니티</font>
					<font class="board_more_text">더보기</font>
				</div>
				<div class="board_title">
					<font class="board_title_font">· 테스트용 게시글입니다.</font>
				</div>
				<div class="board_title">
					<font class="board_title_font">· 테스트용 게시글입니다.</font>
				</div>
				<div class="board_title">
					<font class="board_title_font">· 테스트용 게시글입니다.</font>
				</div>
				<div class="board_title">
					<font class="board_title_font">· 테스트용 게시글입니다.</font>
				</div>
				<div class="board_title">
					<font class="board_title_font">· 테스트용 게시글입니다.</font>
				</div>
				<div class="board_title">
					<font class="board_title_font">· 테스트용 게시글입니다.</font>
				</div>
			</div>
			<div id="right_contents">
				<div id="my_contents">
					<font id="login_text">로그인하고 게임을 시작하세요!</font>
					<div id="loginBtn">
						로그인
					</div>
					<div id="reg_div">
						<font class="reg_text">회원가입</font>
						<font class="reg_text" style="margin-left:10px;">아이디·비밀번호 찾기</font>
					</div>
				</div>
				<img id="gamestartBtn" src="<c:url value="/resources/img/GameStart.png" />">
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>