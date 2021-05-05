<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>WEB MAPIA - RANKING</title>
	<link href="<c:url value="/resources/css/ranking.css" />" rel="stylesheet">
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script  src="<c:url value="/resources/js/ranking.js" />"></script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div id="center_contents">
		<div class="center_top_div">
			<div class="img_div">
				<img id="crown_img" src="<c:url value="/resources/img/crown.png"/>">
			</div>
			<div class="title_font">유저 랭킹(종합)</div>
			<div class="sub_font">각종 데이터 기반 유저 랭킹을 검색할 수 있습니다.</div>
		</div>
		<div id="buttons_div">
			<button class="button_design">종합 랭킹</button>
			<button class="button_design">포인트 랭킹</button>
			<button class="button_design">인기도 랭킹</button>
		</div>
		<div id="table_wrap">
			<table class="ranking_table">
				<tr id="ranking_title_box">
					<td class="ranking_no ranking_tr_plus">순위</td>
					<td class="ranking_user ranking_tr_plus">유저</td>
					<td class="ranking_win ranking_tr_plus">승리</td>
					<td class="ranking_lose ranking_tr_plus">패배</td>
					<td class="ranking_fame ranking_tr_plus">인기도</td>
				</tr>
			</table>
			<div id="div_scroll_controll">
				<div id="div_content">
					<table id="ranking_add" class="ranking_table">
						<c:forEach var="memberVO" items="${rankingList}" varStatus="status">
						<tr class="ranking_struct_bottom">
							<c:if test="${status.count==1}">
								<td class="ranking_no ranking_font"><img class="ranking_img"src="<c:url value="/resources/img/gold.png"/>"></td>
							</c:if>
							<c:if test="${status.count==2}">
								<td class="ranking_no ranking_font"><img class="ranking_img"src="<c:url value="/resources/img/silver.png"/>"></td>
							</c:if>
							<c:if test="${status.count==3}">
								<td class="ranking_no ranking_font"><img class="ranking_img"src="<c:url value="/resources/img/bronze.png"/>"></td>
							</c:if>
							<c:if test="${status.count>3}">
								<td class="ranking_no ranking_font">${status.count}</td>
							</c:if>
							<td class="ranking_user ranking_font">
								<div class="user_area_wrap">
									<img class="profile_img" src="<c:url value="/resources/upload/profile/${memberVO.profile}"/>">
									<div class="user_area">Lv.${memberVO.level} ${memberVO.nickname}</div>
								</div>
							</td>
							<td class="ranking_win ranking_font">${memberVO.win}</td>
							<td class="ranking_lose ranking_font">${memberVO.lose}</td>
							<td class="ranking_fame ranking_font">0</td>
						</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>