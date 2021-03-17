$(document).ready(function(){
	var div=document.querySelector("[contentEditable=\"true\"]");
	div.onkeyup=function(e){
		if( e.keyCode==13 )
			scrollchange();
	};
});

function scrollchange(){
	$("#textarea_text").scrollTop($("#textarea_text")[0].scrollHeight);
}

function writeSubmit(){
	document.getElementById('replace_area').value = document.getElementById('textarea_text').innerHTML;
	document.getElementById('frm').submit();
}

function img_upload(){
	var popupWidth = 350;
	var popupHeight = 135;
	var popupX = (window.screen.width / 2) - (popupWidth / 2);
	var popupY= (window.screen.height / 2) - (popupHeight / 2);
	window.name = "parentForm";
	window.open("imgupload", "childForm", "width="+popupWidth+", height="+popupHeight+", resizable = no, scrollbars = no, left="+ popupX + ", top="+ popupY);
}