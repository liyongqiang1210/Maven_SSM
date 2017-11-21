<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="css/paging.css" />
<script type="text/javascript" src="jquery/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="js/checkbox.js"></script>
<script src="jsp/dictionary/dictionary.js"></script>
</head>
<body>
	<div class="panel panel-default panel-update">
		<div class="panel-heading">数据字典</div>
		<div class="panel-body">
			<div class="panel panel-default">
				<div class="panel-body">
					<form class="form-inline">
						<div class="form-group">
							<label for="dictionary-key">字典key: </label> <input type="text"
								class="form-control" id="dictionary-key"
								placeholder="请输入字典的key值">
						</div>
						<div class="form-group">
							<label for="dictionary-create-time">创建时间: </label> <input
								type="email" class="form-control" id="dictionary-create-time"
								placeholder="请输入创建时间">
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-default" id="select">查询</button>
						</div>
						<div class="form-group">
							<button type="button" id="add" class="btn btn-default"
								data-toggle="modal" data-target="#addDictionary">添加数据字典</button>
							<button type="button" id="deleteSelect" class="btn btn-default"
								data-toggle="modal" data-target="#deleteDictionarys">删除所选</button>
						</div>
					</form>
				</div>
			</div>
			<table class="table table-bordered table-hover">
				<thead>
					<tr class="active">
						<th style="width: 2%;"><input type="checkbox" id="all"></th>
						<th style="width: 30%;">字典ID</th>
						<th style="width: 15%;">字典key</th>
						<th style="width: 15%;">字典value</th>
						<th style="width: 15%;">创建时间</th>
						<th style="width: 15%;">编辑</th>
					</tr>
				</thead>
				<tbody id="tbody">
				</tbody>
			</table>
			<div class="paging">
				<button type="button" class="btn btn-default paging-btn">首页</button>
				<button type="button" class="btn btn-default paging-btn">上一页</button>
				<div class="paging-pages"></div>
				<button type="button" class="btn btn-default paging-btn">下一页</button>
				<button type="button" class="btn btn-default paging-btn">尾页</button>
				<input type="text" class="paging-input" />
				<button type="button" class="btn btn-default paging-btn">跳转</button>
				<p class="paging-p" id="p-pageTotal"></p>
				<p class="paging-p" id="p-dataTotal"></p>
			</div>
		</div>
	</div>
	<!-- Modal -->
	<!-- 添加模态框（Modal） -->
	<div class="modal fade" id="addDictionary" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"></div>
	<!--编辑弹框  -->
	<div class="modal fade" id="updateDictionary" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	</div>
	<!--删除弹框  -->
	<div class="modal fade bs-example-modal-sm" id="deleteDictionary"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		aria-hidden="true"></div>
	<!--删除所选弹框  -->
	<div class="modal fade bs-example-modal-sm" id="deleteDictionarys"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		aria-hidden="true"></div>
</body>
</html>