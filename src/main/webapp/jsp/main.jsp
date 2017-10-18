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
	width: 100%;
	height: 7%;
}

.top {
	position:absolute;
	width:100%;
	height:100%;
	background-color: #0099ff;
	box-shadow: 2px 2px 10px #888888;
}

.div-main {
	height: 93%;
	width: 100%;
}

.div-left-nav {
	position: absolute;
	height: 93%;
	width: 13%;
	border: 2px solid white;
}

.lyq-ul-color {
	background-color: #b3d9ff;
}

.lyq-iframe {
	position: absolute;
	left: 13%;
	width: 87%;
	height: 93%;
	background-color: #f2f2f2;
	border: 2px solid white;
}
</style>
</head>

<body>
	<div class="div-top">
		<div class="top">
			<div class="lyq-div-nav-left">
				<a class="navbar-brand" href="#">爬虫后台信息管理</a>
			</div>
			<div class="lyq-div-nav-right">
				<ul class="nav navbar-nav">
					<li><a href="javascript:;"></a></li>
				</ul>
			</div>
		</div>

	</div>
	<div class="div-main">
		<div class="div-left-nav">
			<div class="col-xs col-xs-12">
				<ul class=" nav nav-stacked lyq-ul-color">
					<li><a href="javascript:;" class="lyq-a-news">新闻数据列表</a>
						<ul class="nav nav-pills nav-stacked lyq-ul lyq-ul-news">
							<li><a
								href="http://localhost:8080/Maven_SSM/linkage/getLinkageOne"
								target="iframe_a">军事</a></li>
							<li><a href="javascript:;">农业</a></li>
							<li><a href="javascript:;">娱乐</a></li>
							<li><a href="javascript:;">文化</a></li>
							<li><a href="javascript:;">社会</a></li>
						</ul></li>
					<li><a href="javascript:;" class="lyq-a-shop">商品数据列表</a>
						<ul class="nav nav-pills nav-stacked  lyq-ul lyq-ul-shop">
							<li><a href="javascript:;">服装</a></li>
							<li><a href="javascript:;">化妆品</a></li>
							<li><a href="javascript:;">手机</a></li>
							<li><a href="javascript:;">数码</a></li>
							<li><a href="javascript:;">家具</a></li>
						</ul></li>
					<li><a href="javascript:;" class="lyq-a-blog">博客数据列表</a>
						<ul class="nav nav-pills nav-stacked  lyq-ul lyq-ul-blog">
							<li><a href="javascript:;">博客园</a></li>
							<li><a href="javascript:;">CSDN</a></li>
							<li><a href="javascript:;">知乎</a></li>
							<li><a href="javascript:;">新浪微博</a></li>
						</ul></li>
					<li><a href="javascript:;" class="lyq-a-forum">论坛数据列表</a>
						<ul class="nav nav-pills nav-stacked  lyq-ul lyq-ul-forum">
							<li><a href="javascript:;">军事</a></li>
							<li><a href="javascript:;">农业</a></li>
							<li><a href="javascript:;">娱乐</a></li>
							<li><a href="javascript:;">文化</a></li>
							<li><a href="javascript:;">社会</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<iframe class="lyq-iframe" src="index.jsp" name="iframe_a"></iframe>
	</div>
</body>

</html>