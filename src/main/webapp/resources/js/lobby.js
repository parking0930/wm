$(document).ready(function(){
	$('#chat_input_design').keydown(function(key){
		if(key.keyCode==13)
		{
			if($('#chat_input_design').val()!='')
			{
				var message = {
					roomId:'Lobby',
					event:'CHAT',
					data:$('#chat_input_design').val()
				}
				webSocket.send(JSON.stringify(message));
				$('#chat_input_design').val('');
				$('#chat_input_design').focus();
			}
		}
	});
});

//////////////////소켓 통신 부분//////////////////
var webSocket = new WebSocket('ws://localhost:8080/socket');
var userCount = 0;
var testmsg;

webSocket.onerror = function(event) {
	onError(event)
};

webSocket.onopen = function(event) {
	onOpen(event)
};

webSocket.onmessage = function(event) {
	onMessage(event);
};

webSocket.onclose = function(event) {
	location.replace("/");
};

function onOpen(event) {
	var message = {
		roomId:'Lobby',
		event:'ADD'
	}
	webSocket.send(JSON.stringify(message));
}

function onMessage(message) {
	var msg = JSON.parse(message.data);
	console.log(msg);
	testmsg = msg;
	switch(msg.event){
		case 'SYS':
			var player = msg.data;
			var msg = msg.data2;
			$('#chat_content').append(`<div class="player_chat_info">
										<div class="player_chat_img_div">
											<img class="player_chat_img" src="/resources/upload/profile/settings.png">
										</div>
										<div class="player_chat_top">
											`+player+`
										</div>
									</div>
									<div class="player_chat_sys">`+
										msg
									+`</div>`);
			$('#chat_content').scrollTop($('#chat_content')[0].scrollHeight);
			break;
		case 'CHAT':
			var player = msg.data;
			var msg = msg.data2;
			$('#chat_content').append(`<div class="player_chat_info">
										<div class="player_chat_img_div">
											<img class="player_chat_img" src="/resources/upload/profile/`+player.profile+`">
										</div>
										<div class="player_chat_top">
											Lv.`+player.level+` `+player.nickname+`
										</div>
									</div>`);
			if(player.nickname==nickname){
				$('#chat_content').append(`
									<div class="player_chat_my">`+
										msg
									+`</div>`);
			}else{
				$('#chat_content').append(`
									<div class="player_chat_all">`+
										msg
									+`</div>`);
			}
			$('#chat_content').scrollTop($('#chat_content')[0].scrollHeight);
			break;
		case 'RefreshUserList':
			$('#connect_member').empty();
			userCount = 0;
			$('#userCount').html('# 동시 접속자: '+userCount);
			break;
		case 'AddUserToList':
			var profile = msg.data;
			var data = msg.data2;
			userCount += 1;
			$('#userCount').html('# 동시 접속자: '+userCount);
			$('#connect_member').append(`<div class="player_connect">
											<div class="player_chat_img_div">
												<img class="player_chat_img" src="/resources/upload/profile/`+profile+`">
											</div>
											<div class="player_chat_top">`+data+`</div>
										</div>`);
			$('#connect_member').scrollTop($('#connect_member')[0].scrollHeight);
			break;
	}
}

function onError(event) {
	
}