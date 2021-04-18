function resize(obj){
	obj.style.height = "1px";
	obj.style.height = (obj.scrollHeight)+"px";
}

function submitComment(){
	if(document.getElementById('comment_area').value==""){
		alert("댓글을 작성해주세요.");
		return;
	}
	document.getElementById('frm').submit();
}