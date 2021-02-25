$(document).ready(function(){
	var div=document.querySelector("[contentEditable=\"true\"]");
	div.onkeyup=function(e){
  		var a=document.activeElement;
  		if( a.lastChild && a.lastChild.nodeName!="BR" ){
			a.appendChild(document.createElement("br"));
		}
		if( e.keyCode==13 )
			scrollchange();
	};
	div.onkeypress=function(e){
		if( e.keyCode==13 ){
			var selection=window.getSelection(),
			range=selection.getRangeAt(0),
			br=document.createElement("br");
			range.deleteContents();
			range.insertNode(br);
			range.setStartAfter(br);
			range.setEndAfter(br);
			range.collapse(false);
			selection.removeAllRanges();
			selection.addRange(range);
			return false;
		}
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
	var popupHeight = 130;
	var popupX = (window.screen.width / 2) - (popupWidth / 2);
	var popupY= (window.screen.height / 2) - (popupHeight / 2);
	window.name = "parentForm";
	window.open("imgupload", "childForm", "width=350, height=130, resizable = no, scrollbars = no, left="+ popupX + ", top="+ popupY);
}