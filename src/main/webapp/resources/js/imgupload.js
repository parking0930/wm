function img_upload(){
	var tmp = document.getElementById('filename').value.split("\\");
	if(tmp.length==1){
		alert("이미지 업로드를 하지 않았습니다.");
		return;
	}
	var formData = new FormData($('#uploadform')[0]);
	$.ajax({
		type: 'POST',
		url: '/board/imgupload',
		data: formData,
		async: false,
		contentType: false,
		processData: false,
		success: function(data){
			ChangeAndexit(data);
		},
		error: function(){
			alert("error!");
		}
	})
}
function ChangeAndexit(fname){
	opener.document.getElementById('textarea_text').innerHTML =
		opener.document.getElementById('textarea_text').innerHTML+'<img style="max-width:670px" src="/resources/upload/'+fname+'"><br>';
	setTimeout(function(){
		opener.scrollchange();
		window.close();
	}, 100);
}