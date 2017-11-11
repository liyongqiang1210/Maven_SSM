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
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>后台管理系统</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
<script type="text/javascript" src="jquery-2.0.0/jquery.min.js"></script>
<link rel="stylesheet" href="css/main.css" />
<link rel="icon" href="585150.png">
<script>
	$(document).ready(function() {
		/* 控制菜单列表子菜单的显示与隐藏 */
		var name = null; //一级菜单类名
		$(".news").click(function() {
			name = "news";
			open_and_close_menu(name);
		});
		$(".user").click(function() {
			name = "user";
			open_and_close_menu(name);
		});
		$(".shop").click(function() {
			name = "shop";
			open_and_close_menu(name);
		});
		$(".system").click(function() {
			name = "system";
			open_and_close_menu(name);
		});
		$(".dictionary").click(function() {
			name = "dictionary";
			open_and_close_menu(name);
		});
	});
	/*打开和关闭菜单的方法*/
	function open_and_close_menu(name) {
		var state = $("." + name + "-list").css("display");
		if (state == "block") { /*关闭菜单*/
			$("." + name + "-list").slideUp("500");
			$("span.menu-" + name + "-icon").removeClass("span-open");
			$("span.menu-" + name + "-icon").addClass("span-close");
		} else if (state == "none") { /*打开菜单*/
			/*关闭其他打开的菜单*/
			close_menu();
			$("." + name + "-list").slideDown("500");
			$("span.menu-" + name + "-icon").removeClass("span-close");
			$("span.menu-" + name + "-icon").addClass("span-open");
		}
	}
	/*关闭所有菜单的方法*/
	function close_menu() {
		$(".li-ul-menu").each(function() {
			$("span.menu-icon").removeClass("span-open");
			$("span.menu-icon").addClass("span-close");
			$(this).slideUp("500");
		});
	}
</script>
</head>

<body>
	<!--顶部信息-->
	<div class="div-top">
		<div class="lyq-div-left">
			<p class="lyq-title">后台信息管理</p>
		</div>
	</div>
	<!--左侧导航-->
	<div class="div-left-nav">
		<!--菜单列表-->
		<div class="nav">
			<ul class="ul-menu menu-ul-list">
				<li class="li-nav-item"><a href="javascript:;">首页</a>
				</li>
				<li class="li-nav-item user"><a href="javascript:;">用户管理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
						class="menu-icon menu-user-icon span-close"></a></li>
				<ul class="li-ul-menu user-list">
					<li class="li-nav-item"><a href="javascript:;">新浪新闻</a>
					</li>
					<li class="li-nav-item"><a href="javascript:;">腾讯新闻</a>
					</li>
					<li class="li-nav-item"><a href="javascript:;">搜狐新闻</a>
					</li>
					<li class="li-nav-item"><a href="javascript:;">凤凰网</a>
					</li>
				</ul>
				<li class="li-nav-item system"><a href="javascript:;">系统管理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
						class="menu-icon menu-system-icon span-close"></a></li>
				<ul class="li-ul-menu system-list">
					<li class="li-nav-item"><a href="javascript:;">新浪新闻</a>
					</li>
					<li class="li-nav-item"><a href="javascript:;">腾讯新闻</a>
					</li>
					<li class="li-nav-item"><a href="javascript:;">搜狐新闻</a>
					</li>
					<li class="li-nav-item"><a href="javascript:;">凤凰网</a>
					</li>
				</ul>
				<li class="li-nav-item news"><a href="javascript:;">新闻数据列表<span
						class="menu-icon menu-news-icon span-close"></span></a></li>
				<ul class="li-ul-menu news-list">
					<li class="li-nav-item"><a href="javascript:;">新浪新闻</a>
					</li>
					<li class="li-nav-item"><a href="javascript:;">腾讯新闻</a>
					</li>
					<li class="li-nav-item"><a href="javascript:;">搜狐新闻</a>
					</li>
					<li class="li-nav-item"><a href="javascript:;">凤凰网</a>
					</li>
				</ul>
				<li class="li-nav-item shop"><a href="javascript:;">商品数据列表<span
						class="menu-icon menu-shop-icon span-close"></span></a></li>
				<ul class="li-ul-menu shop-list">
					<li class="li-nav-item"><a href="javascript:;">服装</a>
					</li>
					<li class="li-nav-item"><a href="javascript:;">数码</a>
					</li>
					<li class="li-nav-item"><a href="javascript:;">手机</a>
					</li>
					<li class="li-nav-item"><a href="javascript:;">零食</a>
					</li>
				</ul>
				<li class="li-nav-item dictionary"><a href="javascript:;">数据字典列表<span
						class="menu-icon menu-dictionary-icon span-close"></span></a></li>
				<ul class="li-ul-menu dictionary-list">
					<li class="li-nav-item"><a href="javascript:;">博客园</a>
					</li>
				</ul>
			</ul>
		</div>
	</div>
	<!--右侧内容-->
	<div class="div-right-content">
		<iframe
			src="http://localhost:8080/Maven_SSM/jsp/dictionary/dictionary.jsp"></iframe>
	</div>
	<!--底部信息-->
	<div class="div-bottom">
		<p>copyright © 2017</p>
	</div>
</body>

</html>