<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>WEB MAPIA - LOGIN</title>
	<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
</head>
<body>
	<jsp:include page="../header.jsp"/>
	<div id="login_box">
		<div id="login_logo_text">
			WEB MAPIA LOGIN
		</div>
		<form action="/member/login" method="post">
			<div class="input_box_div">
				<input type="text" placeholder="아이디" name="id" class="input_box">
			</div>
			<div class="input_box_div">
				<input type="password" placeholder="비밀번호" name="pw" class="input_box">
			</div>
			<div class="input_box_div">
				<input type="submit" id="login_btn" value="로그인">
			</div>
		</form>
		<div class="input_box_div">
			<div id="hr_style"></div>
		</div>
		<div class="input_box_div">
			<a href="./signUp" class="login_bottom_font">회원가입</a>
			<font class="login_bottom_font" style="margin-left:10px">아이디·비밀번호 찾기</font>
		</div>
	</div>
	<jsp:include page="../footer.jsp"/>
</body>
</html>