<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="en">

<head>
<meta charset="utf-8">
<base href="<%=basePath %>">
<title>一级菜单</title>
<link rel="stylesheet" href="css/jquery-ui.min.css">
<link rel="stylesheet" href="css/form.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/linkage.js"></script>
<script type="text/javascript" src="js/paging.js"></script>
</head>

<body>
	<div class="div-out">
		<div class="div-main">
			<div class="div-up">
				<div class="div-title">一级菜单</div>
				<div class="div-close">X</div>
			</div>
			<div class="div-center">
				<form>
					<div class="div-table">
						<table id="div-table">
							<tr>
								<td class="table-name">菜单名：</td>
								<td class="table-input"><input name="linkage_name"
									type="text" id="linkage_name"></td>
							</tr>

						</table>
					</div>
					<div class="buttons">
						<input value="确认" type="submit" id="input-submit"> <input
							value="取消" type="button" id="input-button">
					</div>
				</form>
			</div>
			<div class="div-down"></div>
		</div>
		<div id="users-contain" class="ui-widget">
			<button id="create-button">添加菜单</button>
			<button id="update-button">更新菜单</button>
			<button id="deletes-button">批量删除菜单</button>
			<table id="users" class="ui-widget ui-widget-content">
				<thead>
					<tr class="ui-widget-header ">
						<th>一级菜单ID</th>
						<th>一级菜单名</th>
						<th>一级菜单创建时间</th>
						<th>一级菜单创建人</th>
						<th>一级菜单更新时间</th>
						<th>一级菜单更新人</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${linkages }" var="linkage">
					<tr>
						<td>${linkage.lo_id }</td>
						<td>${linkage.lo_name }</td>
						<td>${linkage.lo_create_time }</td>
						<td>${linkage.lo_creater }</td>
						<td>${linkage.lo_update_time }</td>
						<td>${linkage.lo_modifier }</td>
					</tr>
				</c:forEach>
				

				</tbody>
			</table>
			<div id="page" class="page_div"></div>
		</div>
	</div>
</body>

</html>