<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=basePath%>assets/css/reset.css">
<script type="text/javascript"
	src="<%=basePath%>js/jquery-easyui-1.4.5/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/jquery-easyui-1.4.5/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/jquery-easyui-1.4.5/themes/icon.css">
<script type="text/javascript"
	src="<%=basePath%>js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery-easyui-1.4.5/local/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=basePath%>js/user.js"></script>
<title>用户列表</title>
</head>
<body>

	<!--user列表表单  -->
	<table id="dg" title="用户列表" class="easyui-datagrid"
		url="<%=basePath%>user/getUserList"
		toolbar="#toolbar" rownumbers="true" fitColumns="true"
		singleSelect="true">
		<thead>
			<tr>
				<th field="id" width="30%">id</th>
				<th field="username" width="30%">Name</th>
				<th field="password" width="39%">password</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
			onclick="newUser()">添加User</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editUser()">编辑User</a> <a
			href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
			onclick="destroyUser()">删除User</a>
	</div>

	<!--增加或编辑user  -->
	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">User Information</div>
		<form id="fm" method="post">
			<div class="fitem">
				<label>id:</label> <input name="id" class="easyui-validatebox"
					required="true">
			</div>
			<div class="fitem">
				<label>username:</label> <input name="username"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>password:</label> <input name="password:"
					class="easyui-validatebox" required="true">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveUser()">Save</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
	</div>

</body>
</html>