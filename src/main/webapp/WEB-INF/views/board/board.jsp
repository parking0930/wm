<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>WEB MAPIA - BOARD</title>
	<link href="<c:url value="/resources/css/board.css" />" rel="stylesheet">
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<jsp:include page="../header.jsp"/>
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
			<font id="board_name">${mainTitle}</font><br>
			<font id="board_comment">${subTitle}</font>
			<div id="table_wrap">
				<table id="board_table">
					<tr id="board_title_box">
						<td class="board_no board_tr_plus">번호</td>
						<td class="board_title board_tr_plus">제목</td>
						<td class="board_writer board_tr_plus">작성자</td>
						<td class="board_date board_tr_plus">작성일</td>
						<td class="board_view board_tr_plus">조회수</td>
					</tr>
					<!-- 최대 13개의 글 표시할 것! -->
					<c:forEach var="getboard" items="${getlist}">
						<tr class="board_struct_bottom">
							<td class="board_no board_font">${getboard.id}</td>
							<td class="board_title board_font">
								<a href="/board/view?board=${board}&id=${getboard.id}">${getboard.title}</a>
							</td>
							<td class="board_writer board_font">${getboard.nickname}</td>
							<td class="board_date board_font">${getboard.date}</td>
							<td class="board_view board_font">${getboard.view}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div id="board_buttons">
				<%if(session.getAttribute("member")!=null){ %>
				<div class="btn_design" onclick="location.href='/board/write?board=${board}';">글쓰기</div>
				<%} %>
			</div>
			<div id="board_num">
				<%if((boolean)request.getAttribute("startArrow")){ %>
					<a class="urlStyle" href="/board?board=${board}&page=${pagingManager.startPage-1}"><</a>
				<%} %>
				<c:forEach var="i" begin="${pagingManager.startPage}" end="${pagingManager.endPage}">
					<c:if test="${i==pagingManager.nowPage}">
						<font class="nowStyle">${i}</font>
					</c:if>
					<c:if test="${i!=pagingManager.nowPage}">
						<a class="urlStyle" href="/board?board=${board}&page=${i}">${i}</a>
					</c:if>
				</c:forEach>
				<%if((boolean)request.getAttribute("endArrow")){ %>
					<a class="urlStyle" href="/board?board=${board}&page=${pagingManager.endPage+1}">></a>
				<%} %>
			</div>
		</div>
	</div>
	<jsp:include page="../footer.jsp"/>
</body>
</html>