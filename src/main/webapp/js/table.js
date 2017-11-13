	$(document).ready(function() {
		/*全选与反选按钮*/
		$("#all").click(function() {
			var state = $("#all").prop("checked");
			if(state == true) {
				$("[name='option']").prop("checked", "checked");
			} else {
				$("[name='option']").prop("checked", "");
			}
		});
		/*------------------------------------------------------------------------------------*/
		/*根据复选框是否全部选中来判断全选框是否选中*/
		//获取当前页面数据条数
		var options = $("[name='option']");
		//给每一个复选框加上click事件
		$("input[name='option']").click(function() {
			//获取当前选中的复选框个数
			var i = $("input[name='option']:checked");
			//判断复选框选中个数是否等于当前页面数据条数
			if(i.length == options.length) { //如果两者值相等那么全选按钮也会选中
				$("#all").prop("checked", "checked");
			} else { //当两者值不相等时全选框便不会显示选中
				$("#all").prop("checked", "");
			}
		});

	});