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
	$(document)
			.ready(
					function() {
						$(".lyq-ul").prop("hidden", "hidden");

						$(".lyq-a-news").click(function() {
							var name = ".lyq-ul-news";
							hidden_ul(name);
						});
						$(".lyq-a-shop").click(function() {
							var name = ".lyq-ul-shop";
							hidden_ul(name);
						});
						$(".lyq-a-blog").click(function() {
							var name = ".lyq-ul-blog";
							hidden_ul(name);
						});
						$(".lyq-a-forum").click(function() {
							var name = ".lyq-ul-forum";
							hidden_ul(name);
						});
						$(".junshi")
								.click(
										function() {
											$(".lyq-div-contenxt")
													.load(
															"http://localhost:8080/Maven_SSM/linkage/getLinkageOne");
										});
					});

	/*打和开关闭菜单的方法*/
	function hidden_ul(name) {
		var state = $(name).prop("hidden");
		if (state == true) {
			//打开当前菜单前先隐藏全部菜单然后打开当前菜单
			close_ul();
			$(name).show(500);
			$(name).removeAttr("hidden");
		} else {
			$(name).hide(500);
			$(name).prop("hidden", "hidden");
		}
	}
	/*隐藏全部菜单的方法*/
	function close_ul() {
		$("ul.lyq-ul").each(function() {
			$(this).hide(500);
			$(this).prop("hidden", "hidden");
		});
	}
</script>
<style>
body, html {
	height: 100%;
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

.div-main {
	height: 93%;
	width: 100%;
}

/*左侧导航栏容器  */
.div-left-nav {
	position: fixed;
	top: 80px;
	left:30px;
	height: 88%;
	width: 200px;
	/* background-color: #ffffff;
	box-shadow: 2px 2px 8px #888888; */
}

ul>li {
	border: 1px solid #C0C0C0;
	background-color: #008BCA;
}

ul>li>ul>li {
	background-color: #6495ED;
	border: 1px solid #C0C0C0;
	border-bottom: 0px;
}

/*内容页面  */
.lyq-iframe {
	position: absolute;
	margin-top: 80px;
	left: 16%;
	width: 82%;
	height: 88%;
	background-color: #f2f2f2;
	border: 0px solid white;
	box-shadow: 2px 2px 10px #888888;
}

a {
	color: #ffffff;
}
</style>
</head>

<body>
	<div class="div-top">
		<div class="top">
			<div class="lyq-div-nav-left">
				<a class="navbar-brand" href="#">爬虫后台信息管理</a>
			</div>
		</div>

	</div>
	<div class="div-main">
		<div class="div-left-nav">
			<ul class=" nav nav-stacked ">
				<li><a href="javascript:;" class="lyq-a-news">新闻数据列表</a>
					<ul class="nav nav-stacked lyq-ul lyq-ul-news">
						<li><a
							href="http://localhost:8080/Maven_SSM/linkage/getLinkageOne"
							target="iframe_a">军事</a></li>
						<li><a href="javascript:;">农业</a></li>
						<li><a href="javascript:;">娱乐</a></li>
						<li><a href="javascript:;">文化</a></li>
						<li><a href="javascript:;">社会</a></li>
					</ul></li>
				<li><a href="javascript:;" class="lyq-a-shop">商品数据列表</a>
					<ul class="nav nav-stacked  lyq-ul lyq-ul-shop">
						<li><a href="javascript:;">服装</a></li>
						<li><a href="javascript:;">化妆品</a></li>
						<li><a href="javascript:;">手机</a></li>
						<li><a href="javascript:;">数码</a></li>
						<li><a href="javascript:;">家具</a></li>
					</ul></li>
				<li><a href="javascript:;" class="lyq-a-blog">博客数据列表</a>
					<ul class="nav nav-stacked  lyq-ul lyq-ul-blog">
						<li><a href="javascript:;">博客园</a></li>
						<li><a href="javascript:;">CSDN</a></li>
						<li><a href="javascript:;">知乎</a></li>
						<li><a href="javascript:;">新浪微博</a></li>
					</ul></li>
				<li><a href="javascript:;" class="lyq-a-forum">论坛数据列表</a>
					<ul class="nav nav-stacked  lyq-ul lyq-ul-forum">
						<li><a href="javascript:;">军事</a></li>
						<li><a href="javascript:;">农业</a></li>
						<li><a href="javascript:;">娱乐</a></li>
						<li><a href="javascript:;">文化</a></li>
						<li><a href="javascript:;">社会</a></li>
					</ul></li>
			</ul>
		</div>
		<iframe class="lyq-iframe" src="index.jsp" name="iframe_a"></iframe>
	</div>
</body>

</html>