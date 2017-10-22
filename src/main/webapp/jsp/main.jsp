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
		/* 控制菜单列表子菜单的显示与隐藏 */
		var name = null;//一级菜单类名
		$(".sina").click(function() {
			name = "sina";
			open_close_menu(name);
		});
		$(".user").click(function() {
			name = "user";
			open_close_menu(name);
		});
		$(".blog").click(function() {
			name = "blog";
			open_close_menu(name);
		});
		$(".shop").click(function() {
			name = "shop";
			open_close_menu(name);
		});
	});

	/*隐藏全部菜单的方法*/
	function close_div() {
		$("div.lyq-div-menu-list").each(function() {
			/*调整右侧小图标方向向下 */
			$("p>span.span-icon").removeClass("glyphicon-triangle-bottom");
			$("p>span.span-icon").addClass("glyphicon-triangle-left");
			/*收起当前菜单*/
			$(this).slideUp("500");

		});
	}
	/* 打开关闭菜单时的滑动效果已经右侧图标变化的方法 */
	function open_close_menu(name) {
		var state = $("." + name + "-list").css("display");
		if (state == "block") {
			$("." + name + "-list").slideUp("500");
			$("div." + name + ">p>span.span-icon").addClass(
					"glyphicon-triangle-left");
			$("div." + name + ">p>span.span-icon").removeClass(
					"glyphicon-triangle-bottom");
		} else if (state == "none") {
			close_div();
			$("." + name + "-list").slideDown("500");
			$("div." + name + ">p>span.span-icon").removeClass(
					"glyphicon-triangle-left");
			$("div." + name + ">p>span.span-icon").addClass(
					"glyphicon-triangle-bottom");
		}
	}
</script>
<style>
body, html {
	height: 100%;
	background-color: #000000;
}

.div-top {
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
	height: 95%;
	width: 100%;
}
/*左侧导航栏容器  */
.div-left-nav {
	position: fixed;
	top: 50px;
	height: 88%;
	width: 180px;
}

div.lyq-div-menu-name {
	margin-top: 1px;
	width: 180px;
	height: 35px;
	background-color: #056DAE;
	border-radius: 2px;
	cursor: pointer;
}
/*菜单列表a标签与p标签的样式  */
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

p.p-menu-name {
	display: block;
	height: 35px;
	width: 180px;
	padding-top: 5px;
	font-size: 15px;
	color: #FFFFFF;
}
/* 鼠标与当前a或p标签有交点时的样式 */
div>a:hover {
	border-radius: 2px;
	background-color: #676767;
}

p.p-menu-name:hover {
	border-radius: 2px;
	background-color: #555555;
}

/*选中某个菜单时的样式  */
div>a:focus {
	border-radius: 2px;
	background-color: #676767;
}

/* 菜单列表div的大小 */
div.sina-list, div.user-list {
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
	position: fixed;
	top:50px;
	left: 180px;
	width: 100%;
	height: 100%;
	background-color: #f2f2f2;
	border: 0px solid white;
	/* box-shadow: 2px 2px 10px #888888; */
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

/* 标题字体颜色 */
h1, h2, h3, h4, h5, h6, h7 {
	color: #FFFFFF;
}
</style>
</head>

<body>
	<div class="div-top">
			<div>
				<p class="lyq-title">后台信息管理系统</p>
			</div>
	</div>
	<div class="div-main">
		<div class="div-left-nav">
			<div class="lyq-div-menu-name user">
					<p class="p-menu-name">
						<span class="glyphicon-left glyphicon-user"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp用户信息管理<span
							class="glyphicon-right glyphicon-triangle-left span-icon"></span>
					</p>
			</div>
			<div class="lyq-div-menu-list user-list">
				<a href="http://localhost:8080/Maven_SSM/linkage/getLinkageOne"
					target="iframe_a">军事</a> <a href="javascript:;">农业</a> <a
					href="javascript:;">娱乐</a> <a href="javascript:;">文化</a> <a
					href="javascript:;">社会</a>
			</div>

			<div class="lyq-div-menu-name sina">
				<p class="p-menu-name">
					<span class="glyphicon-left glyphicon-list"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp新浪数据列表<span
						class="glyphicon-right glyphicon-triangle-left span-icon"></span>
				</p>
			</div>
			<div class="lyq-div-menu-list sina-list">
				<a href="http://localhost:8080/Maven_SSM/linkage/getLinkageOne"
					target="iframe_a">军事</a> <a href="javascript:;">农业</a> <a
					href="javascript:;">娱乐</a> <a href="javascript:;">文化</a> <a
					href="javascript:;">社会</a>
			</div>
			<div class="lyq-div-menu-name shop">
				<p class="p-menu-name">
					<span class="glyphicon-left glyphicon-list"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp商品数据列表<span
						class="glyphicon-right glyphicon-triangle-left span-icon"></span>
				</p>
			</div>
			<div class="lyq-div-menu-list shop-list">
				<a href="http://localhost:8080/Maven_SSM/linkage/getLinkageOne"
					target="iframe_a">军事</a> <a href="javascript:;">服装</a> <a
					href="javascript:;">化妆品</a> <a href="javascript:;">手机</a> <a
					href="javascript:;">零食</a> <a href="javascript:;">家具</a> <a
					href="javascript:;">数码</a>
			</div>
			<div class="lyq-div-menu-name blog">
				<p class="p-menu-name">
					<span class="glyphicon-left glyphicon-list"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp博客数据列表<span
						class="glyphicon-right glyphicon-triangle-left span-icon"></span>
				</p>
			</div>
			<div class="lyq-div-menu-list blog-list">
				<a href="http://localhost:8080/Maven_SSM/linkage/getLinkageOne"
					target="iframe_a">军事</a> <a href="javascript:;">博客园</a> <a
					href="javascript:;">CSDN</a> <a href="javascript:;">知乎</a> <a
					href="javascript:;">新浪微博</a>
			</div>
		</div>
		<iframe class="lyq-iframe" src="index.jsp" name="iframe_a"></iframe>
	</div>
</body>

</html>