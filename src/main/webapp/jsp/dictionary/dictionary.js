$(document).ready(
		function() {

			// 选中的id集合
			var list_id = new Array();
			var id = "";
			// 页数默认为1
			var page = 1;
			// 调用全选反选的方法
			checkBox();
			// 添加数据字典模态框
			dictionaryModal();
			// 查询首页数据
			getPageData(page);
			//获取页数与数据总数
			var pageTotal = getPageTotalAndDataTotal(page);
			// 为每个编辑按钮绑定点击事件
			$("#tbody").on(
					"click",
					"button[name='edit']",
					function() {
						// 获取当前行id
						id = $(this).parents("tr").find("td:eq(1)").text();
						// 根据id获取相应的数据
						$.ajax({
							url : "/Maven_SSM/dictionary/selectDictionaryByID",
							data : {
								"dictionary_id" : id
							},
							type : "post",
							dataType : "json",
							success : function(data) {
								$("#dictionary-key-update").prop("value",
										data.dictionary_key);
								$("#dictionary-value-update").prop("value",
										data.dictionary_value);
							},
							error : function() {
								alert("错误")
							}
						});

					});
			// 为每个删除按钮绑定点击事件
			$("#tbody").on("click", "button[name='delete']", function() {
				// 获取当前行id
				id = $(this).parents("tr").find("td:eq(1)").text();

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
			$("#dictionary-key-update").blur(function() {
				dictionary_key_update();
			});
			$("#dictionary-value-update").blur(function() {
				dictionary_value_update();
			});
			// 移除表单验证提示
			$("#add-close").click(function() {
				$("input#dictionary-key-add+span").remove();
				$("input#dictionary-value-add+span").remove();
			});
			// 移除表单验证提示
			$("#update-close").click(function() {
				$("input#dictionary-key-update+span").remove();
				$("input#dictionary-value-update+span").remove();
			});
			// 添加提交表单方法事件
			$("#submit-add").click(function() {
				submit_add_check();
			});
			// 更新提交表单方法事件
			$("#submit-update").click(function() {
				submit_update_check(id);
			});
			// 删除事件
			$("#submit-delete").click(function() {
				submit_delete(id);
			});

			// 删除所选事件
			$("#submit-deletes").click(function() {
				// 获取选中的数据集合
				$("[name='option']:checked").each(function() {
					var id = $(this).parents("tr").find("td:eq(1)").text();
					list_id.push(id);
				});
				$.ajax({
					url : "/Maven_SSM/dictionary/deleteDictionarysByID",
					data : {
						"list" : list_id
					},
					dateType : "json",
					type : "post",
					success : function() {
						$("#deleteDictionarys").modal("hide");
						// 将数组清空
						list_id.length = 0;
						getPageData(page);
					},
					error : function() {

					}
				});

			});
			// 根据页数获取页面数据
			$("div.paging").on(
					"click",
					"ul#pageSelect>li",
					function() {
						// 获取选中的页数
						var selectPage = $(this).parents("ul#pageSelect").find(
								"li.sel-page").text();
						page = selectPage-1;
						// 获取选中页数据
						getPageData(page);
					});
			// 上一页，下一页，首页，尾页
			$("div.paging").on("click", "button#prePage", function() {
				
				if (parseInt(page) > 0) {
					page = parseInt(page) - 1;
				}
				getPageData(page);

			});
			$("div.paging").on("click", "button#nextPage", function() {
				
				if(parseInt(page)<parseInt(pageTotal)-1){
					page = parseInt(page)+1;
				}
				getPageData(page);

			});
			$("div.paging").on("click", "button#lastPage", function() {
				page = pageTotal-1;
				getPageData(pageTotal-1);

			});
			$("div.paging").on("click", "button#firstPage", function() {
				page = 0;
				getPageData(page);
				/*if(page == 0){
					$("button#firstPage").prop("disabled",true);
					$("button#prePage").prop("disabled",true);
				}
				if(page+1 == pageTotal){
					$("button#lastPage").prop("disabled",true);
					$("button#nextPage").prop("disabled",true);
				}*/
			});
			$("div.paging").on("click", "button#jumpBtn", function() {
				var jump = $("input#jumpText").val();
				if(jump!=""&&jump!=null&&jump<pageTotal){
					page = jump-1;
				}
				getPageData(page);
			});
			

		});
// -----------------------------------------组装页面start-----------------------------------------------------------------------
// 添加弹框
function dictionaryModal() {
	var add_str = "<div class='modal-dialog'><div class='modal-content'><div class='modal-header'><button type='button' class='close' data-dismiss='modal' aria-hidden='true'>&times;</button><h4 class='modal-title' id='myModalLabel'>添加数据字典</h4></div><div class='modal-body'><form class='form-horizontal' role='form'><div class='form-group'><div class='col-sm-2'></div><label for='dictionary-key-add' class='col-sm-2 control-label'>字典key:</label><div class='col-sm-8'>	<input type='text' class='form-control' id='dictionary-key-add' placeholder='请输入字典key'></div><div class='col-sm-2'></div></div><div class='form-group'><div class='col-sm-2'></div><label for='dictionary-value-add' class='col-sm-2 control-label'>字典value:</label><div class='col-sm-8'><input type='text' class='form-control' id='dictionary-value-add' placeholder='请输入字典value'></div></div></form></div><div class='modal-footer'><button type='button' class='btn btn-default' data-dismiss='modal' id='add-close'>关闭</button><button type='button' class='btn btn-primary' id='submit-add'>提交</button></div></div></div>";
	$("#addDictionary").append(add_str);
	var update_str = "<div class='modal-dialog'><div class='modal-content'><div class='modal-header'><button type='button' class='close' data-dismiss='modal' aria-hidden='true'>&times;</button><h4 class='modal-title' id='myModalLabel'>编辑数据字典</h4></div><div class='modal-body'><form class='form-horizontal' role='form'><div class='form-group'><div class='col-sm-2'></div><label for='dictionary-key-add' class='col-sm-2 control-label'>字典key:</label><div class='col-sm-8'>	<input type='text' class='form-control' id='dictionary-key-update' placeholder='请输入字典key'></div><div class='col-sm-2'></div></div><div class='form-group'><div class='col-sm-2'></div><label for='dictionary-value-update' class='col-sm-2 control-label'>字典value:</label><div class='col-sm-8'><input type='text' class='form-control' id='dictionary-value-update' placeholder='请输入字典value'></div></div></form></div><div class='modal-footer'><button type='button' class='btn btn-default' data-dismiss='modal' id='update-close'>关闭</button><button type='button' class='btn btn-primary' id='submit-update'>提交</button></div></div></div>";
	$("#updateDictionary").append(update_str);
	var delete_str = "<div class='modal-dialog modal-sm' role='document'><div class='modal-content'><div class='modal-header'><button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button><h4 class='modal-title'>删除数据字典</h4></div><div class='modal-body'><p>是否删除？</p></div><div class='modal-footer'><button type='button' class='btn btn-default' data-dismiss='modal'>否</button><button type='button' class='btn btn-primary' id='submit-delete'>是</button></div></div></div>";
	$("#deleteDictionary").append(delete_str);
	var deletes_str = "<div class='modal-dialog modal-sm' role='document'><div class='modal-content'><div class='modal-header'><button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button><h4 class='modal-title'>删除选中数据字典</h4></div><div class='modal-body'><p>是否删除选中的数据？</p></div><div class='modal-footer'><button type='button' class='btn btn-default' data-dismiss='modal'>否</button><button type='button' class='btn btn-primary' id='submit-deletes'>是</button></div></div></div>";
	$("#deleteDictionarys").append(deletes_str);
}
// 获取页面数据方法
function getPageData(page) {
	// 获取详细数据
	$
			.ajax({
				url : "/Maven_SSM/dictionary/getDataByConditions",
				type : "post",
				async : false,
				data : {
					"dictionary-key" : $("#dictionary-key").val(),
					"dictionary-create-time" : $("#dictionary_create_time")
							.val(),
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
									+ "<button type='button' class='btn btn-info btn-xs' name='edit' data-toggle='modal' data-target='#updateDictionary'>编辑</button><button type='button' class='btn btn-danger btn-xs' name='delete' data-toggle='modal' data-target='#deleteDictionary'>删除</button></td></tr>";
						}
						$("tbody#tbody").empty().append(str);
					}
				}

			});

}
// 获取页数与数据总数
function getPageTotalAndDataTotal(page) {
	var pageTotal = 0;
	// 获取页数与数据总数
	$.ajax({
		url : "/Maven_SSM/dictionary/getDataTotal",
		type : "post",
		async : false,
		data : {
			"dictionary-key" : $("#dictionary-key").val(),
			"dictionary-create-time" : $("#dictionary_create_time").val(),
			"page" : page
		},
		dataType : "json",
		success : function(data) {
			$('#paging').paging({
				initPageNo : page, // 初始页码
				totalPages : data.pageTotal, // 总页数
				totalCount : '合计' + data.dataTotal + '条数据', // 条目总数
				slideSpeed : 300, // 缓动速度。单位毫秒
				jump : true, // 是否支持跳转
				callback : function(page) { // 回调函数
					console.log(page);
				}
			
			});
			pageTotal = data.pageTotal;
		}
		
	});
	return pageTotal;
}
// ---------------------------------------------------------组装页面end-----------------------------------------------------------------------
// ---------------------------------------------------------表单验证start-------------------------------------------------------------
// 添加提交表单方法
function submit_add_check(page) {
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
					getPageData(page);
				} else {
					alert("添加失败");
				}
			},
			error : function() {
				alert("出现异常");
			}
		});
	}
}
// 更新提交表单方法
function submit_update_check(id,page) {
	// 校验key值
	dictionary_key_update();
	// 校验value值
	dictionary_value_update();
	if (dictionary_key_update() == true && dictionary_value_update() == true) {
		$.ajax({
			url : "/Maven_SSM/dictionary/updateDictionary",
			data : {
				"dictionary_id" : id,
				"dictionary_key" : $("#dictionary-key-update").val(),
				"dictionary_value" : $("#dictionary-value-update").val()
			},
			type : "post",
			dateType : "json",
			success : function(data) {
				var state = JSON.parse(data).state;
				if (state == 1) {
					$("#updateDictionary").modal("hide");
					getPageData(page);
				} else {
					alert("添加失败");
				}
			},
			error : function() {
				alert("出现异常");
			}
		});
	}
}
// 删除数据方法
function submit_delete(id,page) {
	// 根据id删除相应的数据
	$.ajax({
		url : "/Maven_SSM/dictionary/deleteDictionaryByID",
		data : {
			"dictionary_id" : id
		},
		type : "post",
		dataType : "json",
		success : function(data) {
			$("#deleteDictionary").modal("hide");
			getPageData(page);
		},
		error : function() {
			alert("错误")
		}
	});
}
// 校验value值方法
function dictionary_value_add() {
	var state = false;
	// 校验key值：只能是英文字母数字"_","-","."的2-20位字符串
	var value_pattern = /^([a-zA-Z0-9]|[_\-.]){2,20}$/;
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
function dictionary_value_update() {
	var state = false;
	// 校验key值：只能是英文字母数字"_","-","."的2-20位字符串
	var value_pattern = /^([a-zA-Z0-9]|[_\-.]){2,20}$/;
	var dictionary_value_update = $("#dictionary-value-update").val();
	if (value_pattern.test(dictionary_value_update)
			&& dictionary_value_update != "") {
		$("input#dictionary-value-update+span").remove();
		$("#dictionary-value-update")
				.after(
						"<span class='glyphicon glyphicon-ok' style='color:#009966;'></span>");
		state = true;
	} else {
		$("input#dictionary-value-update+span").remove();
		$("#dictionary-value-update")
				.after(
						"<span class='glyphicon glyphicon-remove' style='color:red;'></span>");
		state = false;
	}
	return state;
}

// 校验key值方法
function dictionary_key_add() {
	var state = false;
	// 校验key值：只能是汉字英文字母数字"_","-","."的2-20位字符串
	var key_pattern = /^([^\x00-\x80]|[a-zA-Z0-9]|[_\-.]){2,20}$/;
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
function dictionary_key_update() {
	var state = false;
	// 校验key值：只能是汉字英文字母数字"_","-","."的2-20位字符串
	var key_pattern = /^([^\x00-\x80]|[a-zA-Z0-9]|[_\-.]){2,20}$/;
	var dictionary_key_update = $("#dictionary-key-update").val();
	if (key_pattern.test(dictionary_key_update) && dictionary_key_update != "") {
		$("input#dictionary-key-update+span").remove();
		$("#dictionary-key-update")
				.after(
						"<span class='glyphicon glyphicon-ok' style='color:#009966;'></span>");
		state = true;
	} else {
		$("input#dictionary-key-update+span").remove();
		$("#dictionary-key-update")
				.after(
						"<span class='glyphicon glyphicon-remove' style='color:red;'></span>");
		state = false;
	}
	return state;
}
// ---------------------------------------------------------表单验证end-------------------------------------------------------------

