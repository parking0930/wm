var start = 10;
var memberArray;
$(document).ready(function(){
	$('#div_scroll_controll').scroll(function(){
		var scrollT = $(this).scrollTop(); //스크롤바의 상단위치
		var scrollH = $(this).height(); //스크롤바를 갖는 div의 높이
		var contentH = $('#div_content').height(); //문서 전체 내용을 갖는 div의 높이
		if(scrollT + scrollH+1 >= contentH) { // 스크롤바가 아래 쪽에 위치할 때
			$.ajax({
		        url: "/ranking",
		        type: "POST",
		        data: {
					start:start
		        },
				async: false,
		        contentType: "application/x-www-form-urlencoded; charset=UTF-8;",
				success: function(data){
					memberArray = JSON.parse(data);
					for (var key in memberArray) {
						document.getElementById("ranking_add").innerHTML =
							document.getElementById("ranking_add").innerHTML + 
							`
								<tr class="ranking_struct_bottom">
									<td class="ranking_no ranking_font">`+(Number(start)+Number(key)+1)+`</td>
									<td class="ranking_user ranking_font">
										<div class="user_area_wrap">
											<img class="profile_img" src="/resources/upload/profile/`+memberArray[key]["profile"]+`">
											<div class="user_area">Lv.`+memberArray[key]["level"]+` `+memberArray[key]["nickname"]+`</div>
										</div>
									</td>
									<td class="ranking_win ranking_font">`+memberArray[key]["win"]+`</td>
									<td class="ranking_lose ranking_font">`+memberArray[key]["lose"]+`</td>
									<td class="ranking_fame ranking_font">0</td>
								</tr>
							`;
					}
					start = start + memberArray.length;
				},
				error: function(){
					alert("error!");
				}
		    });
		}
	});
});