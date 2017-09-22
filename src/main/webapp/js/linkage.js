	$(document).ready(function() {
		var tp;
		 $.ajax({url:"/linkage/getLinkagePages",success:function(result){
		        tp = result;
		    }});
		//分页
		$("#page").paging({
			pageNo:1,
			totalPage: tp,
			totalSize: 300,
			callback: function(num) {
				
			}
		})
		
		//添加菜单
		$(".div-main").hide();
		$("#create-button").click(function() {
			$(".div-main").show();
		});
		//更新菜单
		$(".div-main").hide();
		$("#update-button").click(function() {
			$(".div-main").show();
		});
		//点击X的时候关闭弹出窗口
		$(".div-close").click(function() {
			$(".div-main").hide();
		});
		//取消按钮
		$("#input-button").click(function() {
			$(".div-main").hide();
		});
		//窗口拖动
		$(".div-main").draggable({
			containment: ".div-out",
			scroll: false,
			cancel:".div-center",
		});
	});