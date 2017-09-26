$(document).ready(
		function() {
			// 每页显示的记录数
			var total = 15;

			// 添加菜单
			$(".div-main").hide();
			$("#create-button").click(function() {
				$(".div-main").show();
			});
			
			
			// 更新菜单
			$(".div-main").hide();
			$("#update-button").click(function() {
				$(".div-main").show();
			});
			
			
			// 点击X的时候关闭弹出窗口
			$(".div-close").click(function() {
				$(".div-main").hide();
			});
			
			
			// 取消按钮
			$("#input-button").click(function() {
				$(".div-main").hide();
			});
			
			
			// 窗口拖动
			$(".div-main").draggable({
				containment : ".div-out",
				scroll : false,
				cancel : ".div-center",
			});
			
			$("#all").click(function(){
				if($("#all").is(':checked') == true) {
					$("[name = option]:checkbox").prop("checked", true);
				} else {
					$("[name = option]:checkbox").prop("checked", false);
				}
			});
			
			// 获取页面页数与记录数信息
			$.ajax({
				type : "post",
				dataType : "json",
				url : "linkage/getPageTotal",
				data : {
					"total" : total
				},
				success : function(data) {
					if (data != null) {
						// 将后台传过来的json字符串转换为json对象
						var obj = data;
						// 总页数
						var tp = obj.pageTotal;
						// 总记录
						var dt = obj.dataTotal;
						/**
						 * 分页方法入口
						 * pageNo  当前页
						 * totalPage 总页数
						 * totalSize 数据总数
						 * callback 回调函数获取当前页数据
						 */
						$("#page").paging({
							pageNo : 1,
							totalPage : tp,
							totalSize : dt,
							callback : function(num) {
								// 获取当前页数据方法
								page(num, total);
							}
						});
					}
				}

			});

			
			// 分页方法
			function page(num, total) {
				$.ajax({
					type : "post",
					url : "linkage/getLinkageOneData",
					dataType : "json",
					data : {
						"start" : num,
						"total" : total
					},
					success : function(data) {
						$("tbody").empty();
						for (var i = 0; i < total; i++) {
							var obj = data[i];

							$("tbody").append(
									"<tr><td><input type='checkbox' name='option' id='check'/></td><td>" + obj.lo_id + "</td><td>"
											+ obj.lo_name + "</td><td>"
											+ obj.lo_create_time + "</td><td>"
											+ obj.lo_creater + "</td><td>"
											+ obj.lo_update_time + "</td><td>"
											+ obj.lo_modifier + "</td></tr>");
						}

					}
				});
			}
		});
