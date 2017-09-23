$(document)
		.ready(
				function() {
					var total = 5;
					$.ajax({
						type : "post",
						datatype : "json",
						url : "linkage/getPageTotal",
						data : {},
						success : function(data) {
							if (data != null) {
								// 将后台传过来的json字符串转换为json对象
								var obj = JSON.parse(data);
								// 总页数
								var tp = obj.pageTotal;
								// 总记录
								var dt = obj.dataTotal;
								// 调用分页方法
								$("#page").paging({
									pageNo : 1,
									totalPage : tp,
									totalSize : dt,
									callback : function(num) {
										$
												.ajax({
													type : "post",
													url : "linkage/getLinkageOneData",
													datatype : "json",
													data : {
														"start" : 1,
														"total" : total
													},
													success : function(data) {
														$("tbody").empty();
														for (var i = 0; i < total; i++) {
															$("tbody")
																	.append(
																			"<tr><td>"
																					+ data[i].lo_id
																					+ "</td><td>"
																					+ data[i].lo_name
																					+ "</td><td>"
																					+ data[i].lo_create_time
																					+ "</td><td>"
																					+ data[i].lo_creater
																					+ "</td><td>"
																					+ data[i].lo_update_time
																					+ "</td><td>"
																					+ data[i].lo_modifier
																					+ "</td></tr>");
														}

													}
												});
									}
								});
							}
						}

					});

					// 分页
					$("#page")
							.paging(
									{

										callback : function(num) {
											$
													.ajax({
														type : "post",
														url : "linkage/getLinkageOneData",
														datatype : "json",
														data : {
															"start" : num,
															"total" : total
														},
														success : function(data) {
															for (var i = 0; i < total; i++) {
																$("tbody")
																		.append(
																				"<tr><td>"
																						+ 2222
																						+ "</td><td>"
																						+ data[i].lo_name
																						+ "</td><td>"
																						+ data[i].lo_create_time
																						+ "</td><td>"
																						+ data[i].lo_creater
																						+ "</td><td>"
																						+ data[i].lo_update_time
																						+ "</td><td>"
																						+ data[i].lo_modifier
																						+ "</td></tr>");
															}

														}
													});
										}
									})

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
				});