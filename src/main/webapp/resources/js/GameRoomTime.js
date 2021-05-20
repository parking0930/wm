var timerElement
window.onload = function(){
	timerElement = document.getElementById("now_time");
	NowTimeinit();
}

function NowTime() {
    var date = new Date();
	var hours = date.getHours();
	var minutes = date.getMinutes();
	var ampm = hours >= 12 ? 'PM' : 'AM';
	hours = hours % 12;
	hours = hours ? hours : 12; // 0이면 12로 바뀜
	hours = hours < 10 ? "0"+hours : hours;
	minutes = minutes < 10 ? '0'+minutes : minutes;
    timerElement.innerText = ampm +' ' + hours + ':' + minutes;
}

function NowTimeinit() {
	NowTime();
	setInterval(NowTime, 1000);
}