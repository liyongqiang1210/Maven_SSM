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
<script type="text/javascript" src="jquery-2.0.0/jquery.min.js"></script>
<script src="js/table.js"></script>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading">数据字典</div>
		<div class="panel-body">
			<div class="panel panel-default">
				<div class="panel-body">
					<form class="form-inline">
						<div class="form-group">
							<label for="exampleInputName2">字典key: </label> <input type="text"
								class="form-control" id="exampleInputName2"
								placeholder="请输入字典的key值">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail2">创建时间: </label> <input
								type="email" class="form-control" id="exampleInputEmail2"
								placeholder="请输入创建时间">
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-default">查询</button>
						</div>
						<div class="form-group">
							<button type="button" class="btn btn-default">添加数据字典</button>
							<button type="button" class="btn btn-default">删除所选</button>
						</div>
					</form>
				</div>
			</div>
			<table class="table table-bordered table-hover">
				<thead>
					<tr class="active">
						<th style="width: 2%;"><input type="checkbox" id="all"></th>
						<th style="width: 20%;">字典ID</th>
						<th style="width: 15%;">字典key</th>
						<th style="width: 15%;">字典value</th>
						<th style="width: 15%;">创建时间</th>
						<th style="width: 25%;">编辑</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="checkbox" name="option"></td>
						<td>Bangalore</td>
						<td>560001</td>
						<td>Bangalore</td>
						<td>560001</td>
						<td>
							<button type="button" class="btn btn-info btn-xs">编辑</button>
							<button type="button" class="btn btn-danger btn-xs">删除</button>
						</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="option"></td>
						<td>Bangalore</td>
						<td>560001</td>
						<td>Bangalore</td>
						<td>560001</td>
						<td>
							<button type="button" class="btn btn-info btn-xs">编辑</button>
							<button type="button" class="btn btn-danger btn-xs">删除</button>
						</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="option"></td>
						<td>Bangalore</td>
						<td>560001</td>
						<td>Bangalore</td>
						<td>560001</td>
						<td>
							<button type="button" class="btn btn-info btn-xs">编辑</button>
							<button type="button" class="btn btn-danger btn-xs">删除</button>
						</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="option"></td>
						<td>Bangalore</td>
						<td>560001</td>
						<td>Bangalore</td>
						<td>560001</td>
						<td>
							<button type="button" class="btn btn-info btn-xs">编辑</button>
							<button type="button" class="btn btn-danger btn-xs">删除</button>
						</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="option"></td>
						<td>Bangalore</td>
						<td>560001</td>
						<td>Bangalore</td>
						<td>560001</td>
						<td>
							<button type="button" class="btn btn-info btn-xs">编辑</button>
							<button type="button" class="btn btn-danger btn-xs">删除</button>
						</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="option"></td>
						<td>Bangalore</td>
						<td>560001</td>
						<td>Bangalore</td>
						<td>560001</td>
						<td>
							<button type="button" class="btn btn-info btn-xs">编辑</button>
							<button type="button" class="btn btn-danger btn-xs">删除</button>
						</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="option"></td>
						<td>Bangalore</td>
						<td>560001</td>
						<td>Bangalore</td>
						<td>560001</td>
						<td>
							<button type="button" class="btn btn-info btn-xs">编辑</button>
							<button type="button" class="btn btn-danger btn-xs">删除</button>
						</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="option"></td>
						<td>Bangalore</td>
						<td>560001</td>
						<td>Bangalore</td>
						<td>560001</td>
						<td>
							<button type="button" class="btn btn-info btn-xs">编辑</button>
							<button type="button" class="btn btn-danger btn-xs">删除</button>
						</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="option"></td>
						<td>Bangalore</td>
						<td>560001</td>
						<td>Bangalore</td>
						<td>560001</td>
						<td>
							<button type="button" class="btn btn-info btn-xs">编辑</button>
							<button type="button" class="btn btn-danger btn-xs">删除</button>
						</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="option"></td>
						<td>Bangalore</td>
						<td>560001</td>
						<td>Bangalore</td>
						<td>560001</td>
						<td>
							<button type="button" class="btn btn-info btn-xs">编辑</button>
							<button type="button" class="btn btn-danger btn-xs">删除</button>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="paging">
				<button type="button" class="btn btn-default paging-btn">首页</button>
				<button type="button" class="btn btn-default paging-btn">上一页</button>
				<div class="paging-pages">
					<button type="button" class="btn btn-default paging-pages-btn">1</button>
					<button type="button" class="btn btn-default paging-pages-btn">2</button>
					<button type="button" class="btn btn-default paging-pages-btn">3</button>
					<button type="button" class="btn btn-default paging-pages-btn">4</button>
					<button type="button" class="btn btn-default paging-pages-btn">5</button>
				</div>
				<button type="button" class="btn btn-default paging-btn">下一页</button>
				<button type="button" class="btn btn-default paging-btn">尾页</button>
				<input type="text" class="paging-input" />
				<button type="button" class="btn btn-default paging-btn">跳转</button>
				<p class="paging-p">共30页</p>
				<p class="paging-p">合计1000条数据</p>
			</div>
		</div>
	</div>
</body>
</html>