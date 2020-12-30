let pwchkval = false;

$(document).ready(function(){
	$("#pwchk_text").keyup(function() {
			let pw = document.getElementById('pw_text').value;
			let pwchk = document.getElementById('pwchk_text').value;
			if(pw==pwchk){
				pwchkval = true;
				document.getElementById('pw_chk').innerHTML = "비밀번호가 일치합니다.";
				$(".check_text").css("color", "blue");
			}else{
				pwchkval = false;
				document.getElementById('pw_chk').innerHTML = "비밀번호가 틀렸습니다.";
				$(".check_text").css("color", "red");
			}
		}
	);
});
function checking(){
	let chk = document.getElementsByName("service");
	for(let i=0;i<chk.length;i++){
		if (chk[i].checked==false){
			alert("모든 약관에 동의해야합니다.");
			return;
		}
	}
	if(pwchkval==false){
		alert("비밀번호가 일치하지 않습니다.");
		return;
	}
	document.getElementById('frm').submit();
}

function checkID(mode){
	let id = document.getElementById('id_input').value;
	if(id==""){
		alert("아이디를 입력해주세요.");
		return;
	}
	let form = {
		id:id
	}
	$.ajax({
		url: "/member/checkID",
		type: "POST",
		data: form,
		async:false,
		success: function(data){
			if(mode==0){
				if(data==0) alert("사용 가능한 아이디입니다.");
				else alert("이미 사용중인 아이디입니다.");
			}else{
				if(data==0){
					checkNickname(1);
				}else{
					alert("아이디 중복체크바랍니다.");
					return;
				}
			}
		},
		error: function(){
			alert("error!");
		}
	});
}

function checkNickname(mode){
	let nickname = document.getElementById('nick_input').value;
	if(nickname==""){
		alert("닉네임을 입력해주세요.");
		return;
	}
	let form = {
		nickname:nickname
	}
	$.ajax({
		url: "/member/checkNickname",
		type: "POST",
		data: form,
		async:false,
		success: function(data){
			if(mode==0){
				if(data==0) alert("사용 가능한 닉네임입니다.");
				else alert("이미 사용중인 닉네임입니다.");
			}else{
				if(data==0){
					checking();
				}else{
					alert("닉네임 중복체크바랍니다.");
					return;
				}
			}
		},
		error: function(){
			alert("err");
		}
	});
}

function submit_reg(){
	checkID(1);
}