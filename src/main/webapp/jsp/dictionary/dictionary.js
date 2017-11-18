$(document).ready(function() {
	// 调用全选反选的方法
	checkBox();
	var dictionary_key = $("#dictionary-key").val();
	var dictionary_create_time = $("#dictionary-create-time").val();
	// 页数默认为1
	var page = 1;
	// 调用页面数据组装方法
	paging(dictionary_key, dictionary_create_time, page);
	/* 为每个按钮绑定点击事件 */
	$("#tbody").on("click","button[name='edit']", function() {
		/* 获取当前行某一列的数据 */
		var text = $(this).parents("tr").find("td:eq(1)");
		alert(text.text());
	});
	// 点击添加按钮时清空model中的值
	$("#add").click(function() {
		$("input").val("");
		$("span").remove();
	});
	// 输入框添加失去焦点事件
	$("#dictionary-key-add").blur(function() {
		dictionary_key_add();
	});
	$("#dictionary-value-add").blur(function() {
		dictionary_value_add();
	});
	// 提交表单方法
	$("#submit").click(function() {
		// 校验key值
		dictionary_key_add();
		// 校验value值
		dictionary_value_add();
		if (dictionary_key_add() == true && dictionary_value_add() == true) {
			$.ajax({
				url : "/Maven_SSM/dictionary/insertDictionary",
				data : {
					"dictionary_key" : $("#dictionary-key-add").val(),
					"dictionary_value" : $("#dictionary-value-add").val()
				},
				type : "post",
				dateType : "json",
				success : function(data) {
					var state = JSON.parse(data).state;
					if (state == 1) {
						$("#addDictionary").modal("hide");
					} else {
						alert("添加失败");
					}
				},
				error : function() {
					alert("出现异常");
				}
			});
		}
	});

});

// 校验value值方法
function dictionary_value_add() {
	var state = false;
	// 校验value值：只能是汉字英文字母数字"_","-","."的2-20位字符串
	var value_pattern = /^([^\x00-\x80]|[a-zA-Z0-9]|[_\-.]){2,20}$/;
	var dictionary_value_add = $("#dictionary-value-add").val();
	if (value_pattern.test(dictionary_value_add) && dictionary_value_add != "") {
		$("input#dictionary-value-add+span").remove();
		$("#dictionary-value-add")
				.after(
						"<span class='glyphicon glyphicon-ok' style='color:#009966;'></span>");
		state = true;
	} else {
		$("input#dictionary-value-add+span").remove();
		$("#dictionary-value-add")
				.after(
						"<span class='glyphicon glyphicon-remove' style='color:red;'></span>");
		state = false;
	}
	return state;
}

// 校验key值方法
function dictionary_key_add() {
	var state = false;
	// 校验key值：只能是英文字母数字"_","-","."的2-20位字符串
	var key_pattern = /^([a-zA-Z0-9]|[_\-.]){2,20}$/;
	var dictionary_key_add = $("#dictionary-key-add").val();
	if (key_pattern.test(dictionary_key_add) && dictionary_key_add != "") {
		$("input#dictionary-key-add+span").remove();
		$("#dictionary-key-add")
				.after(
						"<span class='glyphicon glyphicon-ok' style='color:#009966;'></span>");
		state = true;
	} else {
		$("input#dictionary-key-add+span").remove();
		$("#dictionary-key-add")
				.after(
						"<span class='glyphicon glyphicon-remove' style='color:red;'></span>");
		state = false;
	}
	return state;
}

// 获取页面数据方法
function paging(dictionary_key, dictionary_create_time, page) {
	// 获取详细数据
	$
			.ajax({
				url : "/Maven_SSM/dictionary/getDataByConditions",
				type : "post",
				data : {
					"dictionary-key" : dictionary_key,
					"dictionary-create-time" : dictionary_create_time,
					"page" : page
				},
				dataType : "json",
				success : function(data) {
					var str = '';
					if (data != null && data != "") {
						for (var i = 0; i < data.length; i++) {
							str += "<tr><td><input type='checkbox' name='option'></td><td>"
									+ data[i].dictionary_id
									+ "</td><td>"
									+ data[i].dictionary_key
									+ "</td><td>"
									+ data[i].dictionary_value
									+ "</td><td>"
									+ data[i].dictionary_create_time
									+ "</td><td>"
									+ "<button type='button' class='btn btn-info btn-xs' name='edit'>编辑</button><button type='button' class='btn btn-danger btn-xs' name = 'delete'>删除</button></td></tr>";
						}
						$("#tbody").empty().append(str);
					}
				}

			});
	// 获取页数与数据总数
	$.ajax({
		url : "/Maven_SSM/dictionary/getDataTotal",
		type : "post",
		data : {},
		dataType : "json",
		success : function(data) {
			addPage(data.pageTotal);
			$("#p-pageTotal").append("共" + data.pageTotal + "页");
			$("#p-dataTotal").append("合计" + data.dataTotal + "条数据");
		}
	});
}

// 拼接页码按钮
function addPage(data) {
	var str = "";
	if (data > 5) {
		for (var i = 1; i < 6; i++) {
			str += "<button type='button' class='btn btn-default paging-pages-btn'>"
					+ i + "</button>";
		}
	} else if (data == 0) {
		$(".paging-pages").css("width", data * 55 + "px");
		$("div.paging>button").prop("disabled", "disabled");
	} else {
		$(".paging-pages").css("width", data * 55 + "px");
		for (var i = 1; i < data + 1; i++) {
			str += "<button type='button' class='btn btn-default paging-pages-btn'>"
					+ i + "</button>";
		}
	}

	$("div.paging-pages").empty().append(str);
}
