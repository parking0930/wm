var start = 10;
var memberArray;
$(document).ready(function(){
	$('#div_scroll_controll').scroll(function(){
		var scrollT = $(this).scrollTop();
		var scrollH = $(this).height();
		var contentH = $('#div_content').height();
		if(scrollT + scrollH+1 >= contentH) {
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