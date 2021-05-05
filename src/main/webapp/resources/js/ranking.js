var start = 10;
$(document).ready(function(){
	$('#div_scroll_controll').scroll(function(){
		var scrollT = $(this).scrollTop(); //스크롤바의 상단위치
		var scrollH = $(this).height(); //스크롤바를 갖는 div의 높이
		var contentH = $('#div_content').height(); //문서 전체 내용을 갖는 div의 높이
		if(scrollT + scrollH+1 >= contentH) { // 스크롤바가 아래 쪽에 위치할 때
			console.log("ㅇㅇ");
			$.ajax({
		        url: "/ranking",
		        type: "POST",
		        data: {
					start:start
		        },
				async: false,
		        contentType: "application/x-www-form-urlencoded; charset=UTF-8;",
				success: function(data){
					console.log(data);
				},
				error: function(){
					alert("error!");
				}
		    });
		}
	});
});