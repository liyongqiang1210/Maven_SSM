<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>  
<%@ page contentType="text/html;charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8">
<base href="<%=basePath %>">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>用户登录</title>
<meta name="keywords" content="">
<meta name="description" content="">

<link rel="shortcut icon" href="favicon.ico">
<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">
<!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
<script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>

<body class="gray-bg">

	<div class="middle-box text-center loginscreen  animated fadeInDown">
		<div>
			<div>

				<h1 class="logo-name">L</h1>

			</div>
			<h3>欢迎进入后台管理系统</h3>

			<form class="m-t" role="form" action="user/login" method="post">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="用户名" name="username"
						required="">
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="密码" name="password"
						required="">
				</div>
				<button type="submit" class="btn btn-primary block full-width m-b">登
					录</button>


				<p class="text-muted text-center">
					<a href="#"><small>忘记密码了？</small></a> | <a
						href="register">注册一个新账号</a>
				</p>

			</form>
		</div>
	</div>

	<!-- 全局js -->
	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.6"></script>




</body>

</html>