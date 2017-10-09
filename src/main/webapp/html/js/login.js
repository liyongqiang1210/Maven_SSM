$(document).ready(function() {

	/*当鼠标移动到当前输入框的时候修改placeholder的值为空*/
	$("#lyq-input-username").hover(function() {
		$(this).prop("placeholder", "");
	});
	$("#lyq-input-password").hover(function() {
		$(this).prop("placeholder", "");
	});

	/*当鼠标离开输入框时修改placeholder的值为相对应的提示文字*/
	$("#lyq-input-username").mouseleave(function() {
		$(this).prop("placeholder", "username");
	});
	$("#lyq-input-password").mouseleave(function() {
		$(this).prop("placeholder", "password");
	});

})

function check() {
	var state = false;
	var usernameRegex = /^([a-zA-Z0-9])|\.|_|@{8,}$/; //用户名正则
	var passwordRegex = /^([a-zA-Z0-9])|\.{6,}$/; //密码正则
	var username = $("#lyq-input-username").val();
	var password = $("#lyq-input-password").val();
	if(username == "" && password == "") { //全部为空时
		$("span.lyq-input-tooltip").text("用户名和密码不能为空！");
	} else if(username == "" && password != "") {//用户名为空时
		$("span.lyq-input-tooltip").text("请输入用户名！");
	} else if(username != "" && password == "") {//密码为空时
		$("span.lyq-input-tooltip").text("请输入密码！");
	}else if(username != "" && password != ""){//用户名和密码都不为空时提交表单
		$("span.lyq-input-tooltip").text("");
		state = true;
	}
	return state;

}