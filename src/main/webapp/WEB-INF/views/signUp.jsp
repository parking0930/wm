<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>WEB MAPIA - SIGN UP</title>
	<link href="<c:url value="/resources/css/signUp.css" />" rel="stylesheet">
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/signUp.js" />"></script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div id="image_area">
		<div id="img_wrap">
			<img src="<c:url value="/resources/img/signuplogo.png" />">
		</div>
	</div>
	<form action="/member/signup" method="post" id="frm">
	<div id="info_area">
		<div class="info_title">
			기본 정보 입력
		</div>
		<div class="info_text">
			<div class="left_text">
				아이디 *
			</div>
			<input class="right_box" type="text" name="id" id="id_input">
			<div class="right_btn" onclick="checkID(0);">중복 확인</div>
		</div>
		<div class="info_text">
			<div class="left_text">
				비밀번호 *
			</div>
			<input class="right_box" type="password" name="pw" id="pw_text">
		</div>
		<div class="info_text">
			<div class="left_text">
				비밀번호 확인 *
			</div>
			<input class="right_box" type="password" name="pwchk" id="pwchk_text">
		</div>
		<div class="check_div">
			<div class="check_text" id="pw_chk">
			</div>
		</div>
		<div class="info_text">
			<div class="left_text">
				닉네임 *
			</div>
			<input class="right_box" type="text" name="nickname" id="nick_input">
			<div class="right_btn" onclick="checkNickname(0);">중복 확인</div>
		</div>
	</div>
	<div id="contents_div">
		<div id="contents_wrap">		
			<div class="info_title">
				약관 동의
			</div>
			<div class="top_div">
				(필수) WEB MAPIA 이용약관
			</div>
			<div class="agree_text_box">
				WEB MAPIA 이용약관입니다.
			</div>
			<div class="agree_div">
				<input type="checkbox" name="service" id="service1">
           		<label for="service1">동의합니다.</label>
			</div>
			<div class="top_div">
				(필수) 개인정보 수집 및 이용
			</div>
			<div class="agree_text_box">
				WEB MAPIA 개인정보 수집 및 이용약관입니다.
			</div>
			<div class="agree_div">
				<input type="checkbox" name="service" id="service2">
           		<label for="service2">동의합니다.</label>
			</div>
			<div id="nextBtn" onclick="submit_reg();">
				가입하기
			</div>
		</div>
	</div>
	</form>
	<jsp:include page="footer.jsp"/>
</body>
</html>