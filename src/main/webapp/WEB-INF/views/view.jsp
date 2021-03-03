<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>WEB MAPIA - VIEW</title>
	<link href="<c:url value="/resources/css/view.css" />" rel="stylesheet">
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script  src="<c:url value="/resources/js/view.js" />"></script>
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
				<c:forEach var="bname" items="${boardList}">
					<div class="board_list_name">
						${bname}
					</div>
				</c:forEach>
			</div>
		</div>
		<div id="right_contents">
			<div id="view_board_name_font"># 공지사항</div>
			<div id="view_title_font">제목이 없습니다.</div>
			<div style="float:left;" class="date_view">2021.03.03. 20:03</div>
			<div class="date_view">조회 1</div>
			<div id="view_content">
				안녕하세요~~~~~~~~~~~~~~~~~~~~~~~<br>
				~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			</div>
			<div id="view_info_box">
				<div id="writer_info">USER INFO</div>
				<div id="img_box">
					<img id="profile_img" src="<c:url value="/resources/img/profile.png" />">
				</div>
				<div id="user_info">
					<div class="user_info_main_font">운영자 님</div>
					<div class="user_info_font">전적 : 400승 100패</div>
					<div class="user_info_font">포인트 : 10000P</div>
					<div class="user_info_font">가입일 : 2021.03.03.</div>
				</div>
			</div>
			<div class="cut_line"></div>
		</div>
		<div id="board_tools">
			<div class="buttons">수정</div>
			<div class="buttons">삭제</div>
			<div class="buttons">목록</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>