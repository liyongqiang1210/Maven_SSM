$(document).ready(function() {
	// 调用全选反选的方法
	checkBox();
	var dictionary_key = $("#dictionary-key").val();
	var dictionary_create_time = $("#dictionary-create-time").val();
	var dictionary_key_add = $("#dictionary-key-add").val();
	var dictionary_value_add = $("#dictionary-value-add").val();
	// 页数默认为1
	var page = 1;
	// 调用页面数据组装方法
	paging(dictionary_key, dictionary_create_time, page);

	$("#submit").click(function() {
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
				if(state == 1){
					$("#addDictionary").modal("hide");
				}else{
					alert("添加失败");
				}
			},error:function(){
				alert("出现异常");
			}
		});
		
	});

});
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
									+ "<button type='button' class='btn btn-info btn-xs'>编辑</button><button type='button' class='btn btn-danger btn-xs'>删除</button></td></tr>";
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

// 拼接页按钮
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
