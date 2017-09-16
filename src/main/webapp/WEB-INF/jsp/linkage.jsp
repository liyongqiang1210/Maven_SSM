<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>数据列表</title>
<link rel="stylesheet" href="js/css/common.css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="http://www.jq22.com/jquery/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/right.js"></script>
<script type="text/javascript">
	var w, h, className;
	function getSrceenWH() {
		w = $(window).width(300);
		h = $(window).height(500);
		$('#dialogBg').width(w).height(h);
	}

	window.onresize = function() {
		getSrceenWH();
	}
	$(window).resize();

	$(function() {
		getSrceenWH();

		//显示弹框
		$('.toolbar>li#add').click(
				function() {
					className = $(this).attr('class');
					$('#dialogBg').fadeIn(300);
					$('#dialog').removeAttr('class').addClass(
							'animated ' + className + '').fadeIn();
				});

		//关闭弹窗
		$('.claseDialogBtn').click(function() {
			$('#dialogBg').fadeOut(300, function() {
				$('#dialog').addClass('bounceOutUp').fadeOut();
			});
		});
	});
</script>
</head>
<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">数据表</a></li>
			<li><a href="#">基本内容</a></li>
		</ul>
	</div>

	<div class="rightinfo">

		<div class="tools">

			<ul class="toolbar">
				<li class="click" id="add1"><span><img
						src="images/t01.png" /></span>添加菜单</li>
				<li class="click" id="update"><span><img
						src="images/t02.png" /></span>修改</li>
				<li><span><img src="images/t03.png" /></span>删除</li>
				<li><span><img src="images/t04.png" /></span>统计</li>
			</ul>

			<ul class="toolbar1">
				<li><span><img src="images/t05.png" /></span>设置</li>
			</ul>

		</div>

		<table class="tablelist" id="table">
			<thead>
				<tr>
					<th><input id="all" name="all" type="checkbox" /></th>
					<th>编号<i class="sort"><img src="images/px.gif" /></i></th>
					<th>菜单名</th>
					<th>创建时间</th>
					<th>创建人</th>
					<th>修改时间</th>
					<th>修改人</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${News}" var="news">
					<tr>
						<td id="select_id"><input name="option" type="checkbox" /></td>
						<td id="id"></td>
						<td id="title">${news.title }</td>
						<td id="type">${news.type }</td>
						<td id="source">${news.source }</td>
						<td id="release_time">${news.release_time }</td>
						<td id="create_time">${news.create_time }</td>
						<td id="operate"><a href="#" class="tablelink">查看</a> <a
							href="#" class="tablelink"> 删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="pagin">
			<div class="message">
				共<i class="blue">${dataTotal }</i>条记录，当前显示第&nbsp;<i class="blue"
					id="currentPage">1&nbsp;</i>页，总&nbsp;<i class="blue" id="pageTotal">${pageTotal }&nbsp;</i>页
			</div>
			<ul class="paginList">
				<li class="paginItem" id="page_last"><a href="javascript:;"
					id="page_last_a"><span class="pagepre">上5页</span></a></li>
				<li class="paginItem" id="page_one"><a href="javascript:;">1</a></li>
				<li class="paginItem" id="page_two"><a href="javascript:;">2</a></li>
				<li class="paginItem" id="page_three"><a href="javascript:;">3</a></li>
				<li class="paginItem" id="page_four"><a href="javascript:;">4</a></li>
				<li class="paginItem" id="page_five"><a href="javascript:;">5</a></li>
				<li class="paginItem" id="page_next"><a href="javascript:;"
					id="page_next_a"><span class="pagenxt">下5页</span></a></li>
			</ul>
		</div>
	</div>
</body>
</html>