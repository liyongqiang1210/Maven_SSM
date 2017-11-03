<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
	<base href="<%=basePath %>">
		<title>后台登录页面</title>
		<link rel="stylesheet" href="css/login.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/login.js" ></script>
	</head>

	<body>
		<div id="lyq-div-login">
			<form action="user/login" method="post">
				<div id="lyq-div-username">
					<label><img alt="username" src="images/icon_profile.png"></label>
					<input type="text" id="lyq-input-username" placeholder="username" name="username"/>
				</div>
				<div id="lyq-div-password">
					<label><img alt="password" src="images/icon_lock_alt.png"></label>
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


