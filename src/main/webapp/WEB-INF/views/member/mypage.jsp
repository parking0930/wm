<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>WEB MAPIA - My Page</title>
	<link href="<c:url value="/resources/css/mypage.css" />" rel="stylesheet">
</head>
<body>
	<jsp:include page="../header.jsp"/>
	<div id="center_contents">
		<p id="main_font">My Page</p>
		<form action="/member/mypageSubmit" method="post" enctype="multipart/form-data">
			<p class="fonts">아이디</p>
			<div class="text_div"><input class="textboxs" type="text" name="id" value="${member.id}" disabled></div>
			<p class="fonts">비밀번호</p>
			<div class="text_div"><input class="textboxs" type="password" name="pw"></div>
			<p class="fonts">비밀번호 확인</p>
			<div class="text_div"><input class="textboxs" type="password" name="pwchk"></div>
			<p class="fonts">닉네임</p>
			<div class="text_div"><input class="textboxs" type="text" name="nickname" value="${member.nickname}" disabled></div>
			<p class="fonts">프로필 사진</p>
			<div class="text_div"><div id="file_div"><input type="file" name="file" accept="image/gif,image/jpeg,image/png"></div></div>
			<p class="sub_font">90X90 사이즈의 사진 업로드를 권장합니다.</p>
			<div><input type="submit" value="적용" id="reg_submit"></div>
		</form>
	</div>
	<jsp:include page="../footer.jsp"/>
</body>
</html>