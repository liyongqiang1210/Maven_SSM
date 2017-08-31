<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>URL数据列表</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/right.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".click").click(function() {
			$(".tip").fadeIn(200);
		});

		$(".tiptop a").click(function() {
			$(".tip").fadeOut(200);
		});

		$(".sure").click(function() {
			$(".tip").fadeOut(100);
		});

		$(".cancel").click(function() {
			$(".tip").fadeOut(100);
		});

	});
</script>
</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">URL数据表</a></li>
			<li><a href="#">基本内容</a></li>
		</ul>
	</div>

	<div class="rightinfo">

		<div class="tools">

			<ul class="toolbar">
				<li class="click"><span><img src="images/t01.png" /></span>添加</li>
				<li class="click"><span><img src="images/t02.png" /></span>修改</li>
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
					<th>url</th>
					<th>名称</th>
					<th>创建时间</th>
					<th>更新时间</th>
					<th>创建人</th>
					<th>修改</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${webSites}" var="webSiite" >
					<tr>
						<td style="width: 10px;"><input name="option" type="checkbox" /></td>
						<td id="id">${webSite.id }</td>
						<td id="url">${webSite.url }</td>
						<td id="name">${webSite.name }</td>
						<td id="create_time">${webSite.create_time }</td>
						<td id="update_time">${webSite.update_time }</td>
						<td id="creater">${webSite.creater }</td>
						<td id="modifier">${webSite.modifier }</td>
						<td><a href="#" class="tablelink">查看</a> <a href="#"
							class="tablelink"> 删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="pagin">
			<div class="message">
				共<i class="blue">${dataTotal }</i>条记录，当前显示第&nbsp;<i class="blue">1&nbsp;</i>页，总&nbsp;<i class="blue">${pageTotal }&nbsp;</i>页
			</div>
			<ul class="paginList">
				<li class="paginItem"  id="page_last"><a href="javascript:;" id="page_last_a"><span
						class="pagepre">上5页</span></a></li>
				<li class="paginItem" id="page_one"><a href="javascript:;">1</a></li>
				<li class="paginItem" id="page_two"><a href="javascript:;">2</a></li>
				<li class="paginItem" id="page_three"><a href="javascript:;">3</a></li>
				<li class="paginItem" id="page_four"><a href="javascript:;">4</a></li>
				<li class="paginItem" id="page_five"><a href="javascript:;">5</a></li>
				<li class="paginItem"  id="page_next"><a href="javascript:;" id="page_next_a"><span
						class="pagenxt">下5页</span></a></li>
			</ul>
		</div>

		<div class="tip">
			<div class="tiptop">
				<span>提示信息</span> <a></a>
			</div>

			<div class="tipinfo">
				<span><img src="images/ticon.png" /></span>
				<div class="tipright">
					<p>是否确认对信息的修改 ？</p>
					<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
				</div>
			</div>

			<div class="tipbtn">
				<input name="" type="button" class="sure" value="确定" />&nbsp; <input
					name="" type="button" class="cancel" value="取消" />
			</div>

		</div>

	</div>

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>

</html>