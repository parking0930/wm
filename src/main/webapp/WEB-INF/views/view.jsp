<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>WEB MAPIA - VIEW</title>
	<link href="<c:url value="/resources/css/view.css" />" rel="stylesheet">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/view.js" />"></script>
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
		<div id="right_contents">
			<div id="view_board_name_font"># 공지사항</div>
			<div id="view_title_font">${getBoard.title}</div>
			<div style="float:left;" class="date_view">${getBoard.date}</div>
			<div class="date_view">조회 ${getBoard.view}</div>
			<div id="view_content">
				${getBoard.contents}
			</div>
			<div id="view_info_box">
				<div id="writer_info">USER INFO</div>
				<div id="img_box">
					<img id="profile_img" src="<c:url value="/resources/img/${writerInfo.profile}" />">
				</div>
				<div id="user_info">
					<div class="user_info_main_font">${writerInfo.nickname} 님</div>
					<div class="user_info_font">전적 : ${writerInfo.win}승 ${writerInfo.lose}패</div>
					<div class="user_info_font">포인트 : ${writerInfo.point}P</div>
					<div class="user_info_font">가입일 : ${writerInfo.date}</div>
				</div>
			</div>
			<div id="comment_relative">댓글 ${CommentCount}</div>
			<div class="cut_line"></div>
			<c:forEach var="comment" items="${commentList}">
				<div class="comments">
					<div class="comment_user_img_box">
						<img class="comment_profile" src="<c:url value="/resources/img/${writerInfo.profile}" />">
					</div>
					<div class="comment_user_info">Lv${comment.writerinfo.level}. ${comment.writerinfo.nickname}</div>
					<div class="comment_date">
						${comment.date}
					</div>
					<div class="comment_content">
						${comment.comment}
					</div>
				</div>
			</c:forEach>
			<%if(session.getAttribute("member")!=null){ %>
			<form id="frm" action="/board/comment" method="post">
			<div id="comment_write">
				<input type="hidden" name="board" value="${board}">
				<input type="hidden" name="bid" value="${getBoard.id}">
				<textarea id="comment_area" name="comment" onkeydown="resize(this)" onkeyup="resize(this)"></textarea>
				<div id="comment_btn_area">
					<div id="comment_submit" onclick="submitComment();">작성</div>
				</div>
			</div>
			</form>
			<%} %>
		</div><br>
		<div id="board_tools">
			<%if((boolean)request.getAttribute("myData")){ %>
			<div class="buttons" onclick="location.href='/board/write?board=${board}&id=${getBoard.id}';">수정</div>
			<div class="buttons">삭제</div>
			<%} %>
			<div class="buttons" onclick="location.href='/board?board=${board}';">목록</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>