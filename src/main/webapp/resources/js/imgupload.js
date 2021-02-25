function img_upload(){
	var tmp = document.getElementById('filename').value.split("\\");
	if(tmp.length==1){
		alert("이미지 업로드를 하지 않았습니다.");
		return;
	}
	var formData = new FormData($('#uploadform')[0]);
	$.ajax({
		type: 'POST',
		url: '/write/imgupload',
		data: formData,
		async: false,
		contentType: false,
		processData: false
	})
	ChangeAndexit();
}
function ChangeAndexit(){
	var tmp = document.getElementById('filename').value.split("\\");
	tmp = tmp[tmp.length-1];
	opener.document.getElementById('textarea_text').innerHTML = opener.document.getElementById('textarea_text').innerHTML+'<img style="max-width:670px" src="./upload/'+tmp+'">';
	opener.document.getElementById('textarea_text').scrollTop = opener.document.getElementById('textarea_text').scrollHeight;
	window.close();
}