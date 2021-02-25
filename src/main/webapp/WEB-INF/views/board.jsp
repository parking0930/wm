<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>WEB MAPIA - Board</title>
	<link href="<c:url value="/resources/css/board.css" />" rel="stylesheet">
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div id="board_logo">
		<img style="position:absolute;" src="<c:url value="/resources/img/board.png" />">
		<div id="board_logo_text">공지사항</div>
	</div>
	<div id="center_contents">
		<div id="left_contents">
			<div id="left_logo">
				공지사항
			</div>
			<div id="board_list">
				<div class="board_list_name">
					공지사항
				</div>
			</div>
		</div>
		<div id="right_contents">
			<font id="board_name">공지사항</font><br>
			<font id="board_comment">공지사항 게시판입니다.</font>
			<div id="table_wrap">
				<table id="board_table">
					<tr id="board_title_box">
						<td class="board_no board_tr_plus">번호</td>
						<td class="board_title board_tr_plus">제목</td>
						<td class="board_writer board_tr_plus">작성자</td>
						<td class="board_date board_tr_plus">작성일</td>
						<td class="board_view board_tr_plus">조회수</td>
					</tr>
					<tr class="board_struct_bottom">
						<td class="board_no board_font">13</td>
						<td class="board_title board_font">ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</td>
						<td class="board_writer board_font">ㅇㅇㅇㅇ</td>
						<td class="board_date board_font">2020.11.11</td>
						<td class="board_view board_font">10000</td>
					</tr>
					<tr class="board_struct_bottom">
						<td class="board_no board_font">12</td>
						<td class="board_title board_font">ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</td>
						<td class="board_writer board_font">ㅇㅇㅇㅇ</td>
						<td class="board_date board_font">2020.11.11</td>
						<td class="board_view board_font">10000</td>
					</tr>
					<tr class="board_struct_bottom">
						<td class="board_no board_font">11</td>
						<td class="board_title board_font">ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</td>
						<td class="board_writer board_font">ㅇㅇㅇㅇ</td>
						<td class="board_date board_font">2020.11.11</td>
						<td class="board_view board_font">10000</td>
					</tr>
					<tr class="board_struct_bottom">
						<td class="board_no board_font">10</td>
						<td class="board_title board_font">ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</td>
						<td class="board_writer board_font">ㅇㅇㅇㅇ</td>
						<td class="board_date board_font">2020.11.11</td>
						<td class="board_view board_font">10000</td>
					</tr>
					<tr class="board_struct_bottom">
						<td class="board_no board_font">9</td>
						<td class="board_title board_font">ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</td>
						<td class="board_writer board_font">ㅇㅇㅇㅇ</td>
						<td class="board_date board_font">2020.11.11</td>
						<td class="board_view board_font">10000</td>
					</tr>
					<tr class="board_struct_bottom">
						<td class="board_no board_font">8</td>
						<td class="board_title board_font">ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</td>
						<td class="board_writer board_font">ㅇㅇㅇㅇ</td>
						<td class="board_date board_font">2020.11.11</td>
						<td class="board_view board_font">10000</td>
					</tr>
					<tr class="board_struct_bottom">
						<td class="board_no board_font">7</td>
						<td class="board_title board_font">ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</td>
						<td class="board_writer board_font">ㅇㅇㅇㅇ</td>
						<td class="board_date board_font">2020.11.11</td>
						<td class="board_view board_font">10000</td>
					</tr>
					<tr class="board_struct_bottom">
						<td class="board_no board_font">6</td>
						<td class="board_title board_font">ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</td>
						<td class="board_writer board_font">ㅇㅇㅇㅇ</td>
						<td class="board_date board_font">2020.11.11</td>
						<td class="board_view board_font">10000</td>
					</tr>
					<tr class="board_struct_bottom">
						<td class="board_no board_font">5</td>
						<td class="board_title board_font">ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</td>
						<td class="board_writer board_font">ㅇㅇㅇㅇ</td>
						<td class="board_date board_font">2020.11.11</td>
						<td class="board_view board_font">10000</td>
					</tr>
					<tr class="board_struct_bottom">
						<td class="board_no board_font">4</td>
						<td class="board_title board_font">ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</td>
						<td class="board_writer board_font">ㅇㅇㅇㅇ</td>
						<td class="board_date board_font">2020.11.11</td>
						<td class="board_view board_font">10000</td>
					</tr>
					<tr class="board_struct_bottom">
						<td class="board_no board_font">3</td>
						<td class="board_title board_font">ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</td>
						<td class="board_writer board_font">ㅇㅇㅇㅇ</td>
						<td class="board_date board_font">2020.11.11</td>
						<td class="board_view board_font">10000</td>
					</tr>
					<tr class="board_struct_bottom">
						<td class="board_no board_font">2</td>
						<td class="board_title board_font">ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</td>
						<td class="board_writer board_font">ㅇㅇㅇㅇ</td>
						<td class="board_date board_font">2020.11.11</td>
						<td class="board_view board_font">10000</td>
					</tr>
					<tr class="board_struct_bottom">
						<td class="board_no board_font">1</td>
						<td class="board_title board_font">ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</td>
						<td class="board_writer board_font">ㅇㅇㅇㅇ</td>
						<td class="board_date board_font">2020.11.11</td>
						<td class="board_view board_font">10000</td>
					</tr>
				</table>
			</div>
			<div id="board_buttons">
				<%if(session.getAttribute("member")!=null){ %>
				<div class="btn_design" onclick="location.href='/board/write';">글쓰기</div>
				<%} %>
			</div>
			<div id="board_num">
				< 1 2 3 >
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>