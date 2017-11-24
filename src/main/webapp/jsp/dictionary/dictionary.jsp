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
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="bootstrap/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="css/paging.css" />
<script type="text/javascript" src="jquery/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap/js/bootstrap-datetimepicker.js"></script>
<script src="bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="js/checkbox.js"></script>
<script src="js/paging.js"></script>
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
							<label for="dictionary-create-time">创建时间: </label>
							<div class="input-group date form_datetime" id="form_datetime"
								data-date-format="yyyy-mm-dd HH:mm:ss"
								data-link-field="dtp_input1">
								<input class="form-control" size="17" type="text"
									id="dictionary-time" placeholder="请选择时间" value="" readonly><span
									class="input-group-addon"><span
									class="glyphicon glyphicon-remove"></span></span> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-th"></span></span>
							</div>
						</div>
						<div class="form-group">
							<button type="button" class="btn btn-default" id="select">查询</button>
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
			<table class="table table-bordered table-hover" id="table-dictionary">
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
			<!--分页  -->
			<div class="paging" id="paging"></div>
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