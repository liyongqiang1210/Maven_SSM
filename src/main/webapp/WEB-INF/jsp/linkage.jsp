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
<title>一级菜单</title>
<!--jq对话框js，css文件  -->
<link rel="stylesheet"
	href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
<script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<link rel="stylesheet" href="jqueryui/style.css">

<style>
body {
	font-size: 62.5%;
}

label, input {
	display: block;
}

input.text {
	margin-bottom: 12px;
	width: 95%;
	padding: .4em;
}

fieldset {
	padding: 0;
	border: 0;
	margin-top: 25px;
}

div#users-contain {
	width: 100%;
	margin: 20px 0;
}

div#users-contain table {
	margin: 1em 0;
	border-collapse: collapse;
	width: 100%;
}

div#users-contain table td, div#users-contain table th {
	border: 1px solid #eee;
	padding: .6em 10px;
	text-align: left;
}

.ui-dialog .ui-state-error {
	padding: .3em;
}

.validateTips {
	border: 1px solid transparent;
	padding: 0.3em;
}
/* /* 
#create-button, #update-button, #deletes-button {
	background-color: #008CBA;
	border: 1px solid green;
	color: white;
	padding: 8px 15px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 10px;
	margin: 4px 2px;
	cursor: pointer;
	float: left;
	-webkit-transition-duration: 0.4s;
	transition-duration: 0.4s;
}

#create-button, #update-button, #deletes-button {
	background-color: white;
	color: black;
	border: 2px solid #008CBA;
}

#create-button:hover, #update-button:hover, #deletes-button:hover {
	background-color: #008CBA;
	color: white;
} */
</style>
<script>
	$(function() {
		var linkage_name = $("#linkage_name"), allFields = $([]).add(
				linkage_name), tips = $(".validateTips");

		function updateTips(t) {
			tips.text(t).addClass("ui-state-highlight");
			setTimeout(function() {
				tips.removeClass("ui-state-highlight", 1500);
			}, 500);
		}

		/* function checkLength(o, n, min, max) {
			 if (o.val().length > max || o.val().length < min) {
				o.addClass("ui-state-error");
				updateTips("" + n + " 的长度必须在 " + min + " 和 " + max + " 之间。");
				return false;
			} else {
				return true;
			} 
			return true;
		} */

		function checkRegexp(o, regexp, n) {
			if (!(regexp.test(o.val()))) {
				o.addClass("ui-state-error");
				updateTips(n);
				return false;
			} else {
				return true;
			}
		}

		$("#dialog-form").dialog(
				{
					autoOpen : false,
					height : 500,
					width : 700,
					modal : true,
					buttons : {
						"确认添加" : function() {
							var bValid = true;
							allFields.removeClass("ui-state-error");

						/* 	bValid = bValid
									&& checkLength(linkage_name,
											"linkage_name", 3, 16); */
							bValid = bValid
									&& checkRegexp(linkage_name,
											/^[a-z]([0-9a-z_])+$/i,
											"用户名必须由 a-z、0-9、下划线组成，且必须以字母开头。");
							if (bValid) {
								alert("确认提交");
								$(this).dialog("close");
							}
						},
						"取消" : function() {
							$(this).dialog("close");
						}

					},
					close : function() {
						allFields.val("").removeClass("ui-state-error");
					}
				});

		$("#create-button").button().click(function() {
			$("#dialog-form").dialog("open");
		});
		$("#update-button").button().click(function() {
			$("#dialog-form").dialog("open");
		});
		$("#deletes-button").button().click(function() {
			$("#dialog-form").dialog();
		});
	});
</script>
</head>
<body>

	<div id="dialog-form" title="添加菜单">
		<form>
			<fieldset>
				<label for="linkage_name">菜单名</label> <input type="text"
					name="linkage_name" id="name"
					class="text ui-widget-content ui-corner-all">
			</fieldset>
		</form>
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
				<tr>
					<td>John Doe</td>
					<td>john.doe@example.com</td>
					<td>johndoe1</td>
					<td>John Doe</td>
					<td>john.doe@example.com</td>
					<td>johndoe1</td>
				</tr>
			</tbody>
		</table>
	</div>



</body>
</html>