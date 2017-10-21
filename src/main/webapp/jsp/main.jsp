<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<base href="<%=basePath%>">
		<title>后台管理页面</title>
		<link rel="stylesheet" href="html/bootstrap/css/bootstrap.css" />
		<script type="text/javascript" src="html/jquery-2.0.0/jquery.min.js"></script>
		<script type="text/javascript" src="html/bootstrap/js/bootstrap.js"></script>
		<script>
			$(document).ready(function() {
				/**
				 * 控制菜单列表的显示与隐藏
				 * 
				 * */
				$(".sina").click(function() {
					var state = $(".sina-list").css("display");
					if(state == "block") {
						$(".sina-list").slideUp("500");
						$("div.sina>p>span").addClass("glyphicon-triangle-left");
						$("div.sina>p>span").removeClass("glyphicon-triangle-bottom");
					} else if(state == "none") {
						close_div();
						$(".sina-list").slideDown("500");
						$("div.sina>p>span").removeClass("glyphicon-triangle-left");
						$("div.sina>p>span").addClass("glyphicon-triangle-bottom");
					}
				});
				$(".sina2").click(function() {
					var state = $(".sina2-list").css("display");
					if(state == "block") {
						$(".sina2-list").slideUp("500");
						$("div.sina2>p>span").addClass("glyphicon-triangle-left");
						$("div.sina2>p>span").removeClass("glyphicon-triangle-bottom");
					} else if(state == "none") {
						close_div();
						$(".sina2-list").slideDown("500");
						$("div.sina2>p>span").removeClass("glyphicon-triangle-left");
						$("div.sina2>p>span").addClass("glyphicon-triangle-bottom");
					}

				});
				$(".blog").click(function() {
					var state = $(".blog-list").css("display");
					if(state == "block") {
						$(".blog-list").slideUp("500");
						$("div.blog>p>span").addClass("glyphicon-triangle-left");
						$("div.blog>p>span").removeClass("glyphicon-triangle-bottom");
					} else if(state == "none") {
						close_div();
						$(".blog-list").slideDown("500");
						$("div.blog>p>span").removeClass("glyphicon-triangle-left");
						$("div.blog>p>span").addClass("glyphicon-triangle-bottom");
					}
				});
				$(".shop").click(function() {
					var state = $(".shop-list").css("display");
					if(state == "block") {
						$(".shop-list").slideUp("500");
						$("div.shop>p>span").addClass("glyphicon-triangle-left");
						$("div.shop>p>span").removeClass("glyphicon-triangle-bottom");
					} else if(state == "none") {
						close_div();
						$(".shop-list").slideDown("500");
						$("div.shop>p>span").removeClass("glyphicon-triangle-left");
						$("div.shop>p>span").addClass("glyphicon-triangle-bottom");
					}
				});
			});

			/*隐藏全部菜单的方法*/
			function close_div() {
				$("div.lyq-div-menu-list").each(function() {
					$(this).slideUp("500");
					
				});
			}
			
			
		</script>
		<style>
			body,
			html {
				height: 100%;
				background-color: #F5F5F5;
			}
			
			.div-top {
				position: fixed;
				width: 100%;
				height: 50px;
			}
			
			.top {
				position: fixed;
				width: 100%;
				height: 50px;
				background-color: #000000;
				box-shadow: 2px 2px 10px #888888;
			}
			
			p.lyq-title {
				display: block;
				height: 50px;
				width: 100%;
				margin-left: 40px;
				margin-top: 10px;
				font-size: 20px;
				color: #FFFFFF;
			}
			
			.div-main {
				height: 93%;
				width: 100%;
			}
			/*左侧导航栏容器  */
			
			.div-left-nav {
				position: fixed;
				top: 80px;
				left: 30px;
				height: 88%;
				width: 200px;
			}
			
			div.lyq-div-menu-name {
				margin-top: 1px;
				width: 180px;
				height: 35px;
				background-color: #056DAE;
				border-radius: 2px;
				cursor: pointer;
			}
			
			div>a {
				margin-top: 1px;
				width: 180px;
				height: 30px;
				display: block;
				padding-left: 65px;
				padding-top: 4px;
				background-color: #3C95C8;
				border-radius: 2px;
			}
			
			div>a:hover {
				border-radius: 2px;
				background-color: #676767;
			}
			
			div>a:focus {
				border-radius: 2px;
				background-color: #676767;
			}
			
			div.lyq-div-menu-name>p {
				display: block;
				height: 35px;
				padding-left: 45px;
				padding-top: 5px;
				font-size: 15px;
				color: #FFFFFF;
			}
			
			div.lyq-div-menu-name>p:hover {
				border-radius: 2px;
				background-color: #555555;
			}
			
			div.sina-list,
			div.sina2-list {
				width: 180px;
				height: 154px;
				display: none;
			}
			
			div.blog-list {
				width: 180px;
				height: 154px;
				display: none;
			}
			
			div.shop-list {
				width: 180px;
				height: 216px;
				display: none;
			}
			/*内容页面  */
			
			.lyq-iframe {
				position: relative;
				margin-top: 80px;
				left: 16%;
				width: 82%;
				height: 90%;
				background-color: #f2f2f2;
				border: 0px solid white;
				box-shadow: 2px 2px 10px #888888;
			}
			/*a标签样式*/
			
			a:link {
				color: #ffffff;
				text-decoration: none;
			}
			
			a:visited {
				color: #ffffff;
				text-decoration: none;
			}
			
			a:hover {
				color: #ffffff;
				text-decoration: none;
			}
			
			ul,
			li {
				list-style: none;
				margin-top: 5px;
			}
			
			.lyq-div-sina-menu {
				background-color: #080808;
			}
			
			h1,
			h2,
			h3,
			h4,
			h5,
			h6,
			h7 {
				color: #FFFFFF;
			}
		</style>
	</head>

	<body>
		<div class="div-top">
			<div class="top">
				<div class="lyq-div--left">
					<p class="lyq-title">爬虫后台信息管理</p>
				</div>
			</div>

		</div>
		<div class="div-main">
			<div class="div-left-nav">
				<div class="lyq-div-menu-name sina">
					<p>
						新浪数据列表<span class="glyphicon glyphicon-triangle-left"></span>
					</p>
				</div>
				<div class="lyq-div-menu-list sina-list">
					<a href="http://localhost:8080/Maven_SSM/linkage/getLinkageOne" target="iframe_a">军事</a>
					<a href="javascript:;">农业</a>
					<a href="javascript:;">娱乐</a>
					<a href="javascript:;">文化</a>
					<a href="javascript:;">社会</a>
				</div>
				<div class="lyq-div-menu-name shop">
					<p>
						商品数据列表<span class="glyphicon glyphicon-triangle-left lyq-p-span"></span>
					</p>
				</div>
				<div class="lyq-div-menu-list shop-list">
					<a href="http://localhost:8080/Maven_SSM/linkage/getLinkageOne" target="iframe_a">军事</a>
					<a href="javascript:;">服装</a>
					<a href="javascript:;">化妆品</a>
					<a href="javascript:;">手机</a>
					<a href="javascript:;">零食</a>
					<a href="javascript:;">家具</a>
					<a href="javascript:;">数码</a>
				</div>
				<div class="lyq-div-menu-name blog">
					<p>
						博客数据列表<span class="glyphicon glyphicon-triangle-left"></span>
					</p>
				</div>
				<div class="lyq-div-menu-list blog-list">
					<a href="http://localhost:8080/Maven_SSM/linkage/getLinkageOne" target="iframe_a">军事</a>
					<a href="javascript:;">博客园</a>
					<a href="javascript:;">CSDN</a>
					<a href="javascript:;">知乎</a>
					<a href="javascript:;">新浪微博</a>
				</div>
				<div class="lyq-div-menu-name sina2">
					<p>
						用户信息管理<span class="glyphicon glyphicon-triangle-left"></span>
					</p>
				</div>
				<div class="lyq-div-menu-list sina2-list">
					<a href="http://localhost:8080/Maven_SSM/linkage/getLinkageOne" target="iframe_a">军事</a>
					<a href="javascript:;">农业</a>
					<a href="javascript:;">娱乐</a>
					<a href="javascript:;">文化</a>
					<a href="javascript:;">社会</a>
				</div>
			</div>
			<iframe class="lyq-iframe" src="index.jsp" name="iframe_a"></iframe>
		</div>
	</body>

</html>