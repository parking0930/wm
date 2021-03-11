<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>WEB MAPIA - WRITE</title>
	<link href="<c:url value="/resources/css/write.css" />" rel="stylesheet">
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script  src="<c:url value="/resources/js/write.js" />"></script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div id="board_logo">
		<img style="position:absolute;" src="<c:url value="/resources/img/board.png" />">
		<div id="board_logo_text">${mainTitle}</div>
	</div>
	<div id="center_contents">
		<div id="left_contents">
			<div id="left_logo">
				${leftTitle}
			</div>
			<div id="board_list">
				<c:forEach var="bMap" items="${boardList}">
					<div class="board_list_name" onclick="location.href='/board?board=${bMap.value}';">
						${bMap.key}
					</div>
				</c:forEach>
			</div>
		</div>
		<form action="/board/submit" method="post" id="frm">
		<div id="right_contents">
			<font id="board_name">${mainTitle}</font><br>
			<font id="board_comment">${subTitle}</font><br>
			<input type="hidden" name="boardName" value="${board}"><!-- 여기 수정 필요 -->
			<input type="text" name="title" id="title" placeholder="제목"><br>
			<div id="imgbtn_design" onclick="img_upload();">
				<img id="imgicon" src="<c:url value="/resources/img/imgicon.jpg" />">
				이미지
			</div>
			<textarea id="replace_area" name="contents" style="display:none;"></textarea>
			<div contentEditable="true" id="textarea_text"></div>
			<div id="button_area">
				<div class="btn_design" onclick="writeSubmit();">
					저장하기
				</div>
				<div class="btn_design" id="write_cancel" onclick="history.go(-1);">
					작성취소
				</div>
			</div>
		</div>
		</form>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>