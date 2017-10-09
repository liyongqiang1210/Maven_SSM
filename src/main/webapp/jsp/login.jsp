<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="en" class="no-js">
<head>
	<meta charset="UTF-8">
	<base href="<%=basePath %>">
		<title>后台登录页面</title>
		<link rel="stylesheet" href="html/css/login.css" />
		<script type="text/javascript" src="html/js/jquery.min.js"></script>
		<script type="text/javascript" src="html/js/login.js" ></script>
	</head>

	<body>
		<div id="lyq-div-login">
			<form action="user/login" method="post">
				<div id="lyq-div-username">
					<label><img alt="username" src="html/images/icon_profile.png"></label>
					<input type="text" id="lyq-input-username" placeholder="username" name="username"/>
				</div>
				<div id="lyq-div-password">
					<label><img alt="password" src="html/images/icon_lock_alt.png"></label>
					<input type="password" id="lyq-input-password" placeholder="password" name="password"/>
				</div>
				<div id="lyq-div-remember">
					<input type="checkbox" />
					<p>记住用户名</p>
				</div>
				<div id="lyq-div-span">
					<span class="lyq-input-tooltip">${message}</span>
				</div>
				<div id="lyq-div-login-submit">
					<input type="button" class="register" value="注册" />
					<input type="submit" class="login" value="登录" onclick="return check()"/>
				</div>
			</form>
		</div>
	</body>

</html>


