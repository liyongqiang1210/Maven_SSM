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

			var totalPage = getTotalPage();
			var dataTotal = getTotalData();
			
			/**
			 * 获取总页数
			 */
			function getTotalPage() {
				var tp = null;
				$.ajax({
					type : "post",
					dataType : "json",
					url : "linkage/getPageTotal",
					data : {
						"total" : total
					},
					success : function(data) {
						if (data != null) {
							// 总页数
							tp = data.pageTotal;
						}
					}

				});
				return tp;
			}
			
			/**
			 * 获取数据总数
			 */
			function getTotalData(){
				var dt = null;
				$.ajax({
					type : "post",
					dataType : "json",
					url : "linkage/getPageTotal",
					data : {
						"total" : total
					},
					success : function(data) {
						if (data != null) {
							// 总记录
							dt = data.dataTotal;
						}
					}

				});
				return dt;
			}
			alert(totalPage+":"+dataTotal);
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
						// 调用分页
						$("#page").paging({
							pageNo : 1,
							totalPage : tp,
							totalSize : dt,
						});
					}
				}

			});
			// 获取当前页面信息
			$("#page").paging({
				totalPage : totalPage,
				totalSize : dataTotal,
				callback : function(num) {
					// 调用分页的方法
					page(num, total);
				}
			})

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
									"<tr><td>" + obj.lo_id + "</td><td>"
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
