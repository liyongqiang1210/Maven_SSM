$(document).ready(function() {
	$("#all").click(function() {
		if($("#all").is(':checked') == true) {
			$("[name = option]:checkbox").attr("checked", true);
		} else {
			$("[name = option]:checkbox").attr("checked", false);
		}
	});
	//当前页
	var currentPage = $("#currentPage").text();
	currentPage = 5;
	//总页数
	var totalPage = $("#pageTotal").text();
	var start = null;
	$("li#page_one").live('click',function() {
		$("li#page_one").attr("class", "paginItem current");
		$("li#page_two").attr("class", "paginItem");
		$("li#page_three").attr("class", "paginItem");
		$("li#page_four").attr("class", "paginItem");
		$("li#page_five").attr("class", "paginItem");
		$("li#page_last").attr("class", "paginItem");
		$("li#page_next").attr("class", "paginItem");
		start = $("li#page_one > a").text();
		$("#currentPage").replaceWith("<i class='blue' id='currentPage'>"+start+"&nbsp;</i>");
		$.ajax({
			type: "post",
			dataType: "json",
			url: "getNewsToPage",
			data: {
				"start": start
			},
			success: function(data) {
				if(data != "") {
					$("tbody").empty();
					for(var i = 0; i <= 13; i++) {
						var title = data[i].title;
						if(title.length>20){
							title = title.substring(0,20)+"....";
						}
						$("tbody").append("<tr><td style='width: 10px;'><input name='option' type='checkbox' /></td><td id='id'>" + data[i].id + "</td><td id='title'>" + title + "</td><td id='type'>" + data[i].type + "</td><td id='source'>" + data[i].source + "</td><td id='release_time'>" + data[i].release_time + "</td><td>" + data[i].create_time + "</td><td><a href='#' class='tablelink'>查看</a> <a href='#' class='tablelink'> 删除</a></td></tr>");
					}

				}
			}
		});
	});
	$("li#page_two").live('click',function() {
		$("li#page_one").attr("class", "paginItem");
		$("li#page_two").attr("class", "paginItem current");
		$("li#page_three").attr("class", "paginItem");
		$("li#page_four").attr("class", "paginItem");
		$("li#page_five").attr("class", "paginItem");
		$("li#page_last").attr("class", "paginItem");
		$("li#page_next").attr("class", "paginItem");
		start = $("li#page_two > a").text();
		$("#currentPage").replaceWith("<i class='blue' id='currentPage'>"+start+"&nbsp;</i>");
		$.ajax({
			type: "post",
			dataType: "json",
			url: "getNewsToPage",
			data: {
				"start": start
			},
			success: function(data) {
				if(data != "") {
					$("tbody").empty();
					for(var i = 0; i <= 13; i++) {
						var title = data[i].title;
						if(title.length>20){
							title = title.substring(0,20)+"....";
						}
						$("tbody").append("<tr><td style='width: 10px;'><input name='option' type='checkbox' /></td><td id='id'>" + data[i].id + "</td><td id='title'>" + title + "</td><td id='type'>" + data[i].type + "</td><td id='source'>" + data[i].source + "</td><td id='release_time'>" + data[i].release_time + "</td><td>" + data[i].create_time + "</td><td><a href='#' class='tablelink'>查看</a> <a href='#' class='tablelink'> 删除</a></td></tr>");
					}

				}
			}
		});
	});
	$("li#page_three").live('click',function() {
		$("li#page_one").attr("class", "paginItem");
		$("li#page_two").attr("class", "paginItem");
		$("li#page_three").attr("class", "paginItem current");
		$("li#page_four").attr("class", "paginItem");
		$("li#page_five").attr("class", "paginItem");
		$("li#page_last").attr("class", "paginItem");
		$("li#page_next").attr("class", "paginItem");
		start = $("li#page_three > a").text();
		$("#currentPage").replaceWith("<i class='blue' id='currentPage'>"+start+"&nbsp;</i>");
		$.ajax({
			type: "post",
			dataType: "json",
			url: "getNewsToPage",
			data: {
				"start": start
			},
			success: function(data) {
				if(data != "") {
					$("tbody").empty();
					for(var i = 0; i <= 13; i++) {
						var title = data[i].title;
						if(title.length>20){
							title = title.substring(0,20)+"....";
						}
						$("tbody").append("<tr><td style='width: 10px;'><input name='option' type='checkbox' /></td><td id='id'>" + data[i].id + "</td><td id='title'>" + title + "</td><td id='type'>" + data[i].type + "</td><td id='source'>" + data[i].source + "</td><td id='release_time'>" + data[i].release_time + "</td><td>" + data[i].create_time + "</td><td><a href='#' class='tablelink'>查看</a> <a href='#' class='tablelink'> 删除</a></td></tr>");
					}

				}
			}
		});
	});
	$("li#page_four").live('click',function() {
		$("li#page_one").attr("class", "paginItem");
		$("li#page_two").attr("class", "paginItem");
		$("li#page_three").attr("class", "paginItem");
		$("li#page_four").attr("class", "paginItem current");
		$("li#page_five").attr("class", "paginItem");
		$("li#page_last").attr("class", "paginItem");
		$("li#page_next").attr("class", "paginItem");
		start = $("li#page_four > a").text();
		$("#currentPage").replaceWith("<i class='blue' id='currentPage'>"+start+"&nbsp;</i>");
		$.ajax({
			type: "post",
			dataType: "json",
			url: "getNewsToPage",
			data: {
				"start": start
			},
			success: function(data) {
				if(data != "") {
					$("tbody").empty();
					for(var i = 0; i <= 13; i++) {
						var title = data[i].title;
						if(title.length>20){
							title = title.substring(0,20)+"....";
						}
						$("tbody").append("<tr><td style='width: 10px;'><input name='option' type='checkbox' /></td><td id='id'>" + data[i].id + "</td><td id='title'>" + title + "</td><td id='type'>" + data[i].type + "</td><td id='source'>" + data[i].source + "</td><td id='release_time'>" + data[i].release_time + "</td><td>" + data[i].create_time + "</td><td><a href='#' class='tablelink'>查看</a> <a href='#' class='tablelink'> 删除</a></td></tr>");
					}

				}
			}
		});
	});
	$("li#page_five").live('click',function() {
		$("li#page_one").attr("class", "paginItem");
		$("li#page_two").attr("class", "paginItem");
		$("li#page_three").attr("class", "paginItem");
		$("li#page_four").attr("class", "paginItem");
		$("li#page_five").attr("class", "paginItem current");
		$("li#page_last").attr("class", "paginItem");
		$("li#page_next").attr("class", "paginItem");
		start = $("li#page_five > a").text();
		$("#currentPage").replaceWith("<i class='blue' id='currentPage'>"+start+"&nbsp;</i>");
		$.ajax({
			type: "post",
			dataType: "json",
			url: "getNewsToPage",
			data: {
				"start": start
			},
			success: function(data) {
				if(data != "") {
					$("tbody").empty();
					for(var i = 0; i <= 13; i++) {
						var title = data[i].title;
						if(title.length>20){
							title = title.substring(0,20)+"....";
						}
						$("tbody").append("<tr><td style='width: 10px;'><input name='option' type='checkbox' /></td><td id='id'>" + data[i].id + "</td><td id='title'>" + title + "</td><td id='type'>" + data[i].type + "</td><td id='source'>" + data[i].source + "</td><td id='release_time'>" + data[i].release_time + "</td><td>" + data[i].create_time + "</td><td><a href='#' class='tablelink'>查看</a> <a href='#' class='tablelink'> 删除</a></td></tr>");
					}

				}
			}
		});
	});
	$("li#page_last").live('click',function() {

		var i = $("li#page_one > a").text();
		if(parseInt(i) > 5) {
			var a = parseInt(i) - 5;
			var b = parseInt(i) - 4;
			var c = parseInt(i) - 3;
			var d = parseInt(i) - 2;
			var e = parseInt(i) - 1;
			$("ul.paginList").empty();
			$("ul.paginList").append("<li class='paginItem'  id='page_last'><a href='javascript:;' id='page_last_a'><span class='pagepre'>上5页</span></a></li><li class='paginItem' id='page_one'><a href='javascript:;'>" + a + "</a></li><li class='paginItem' id='\page_two'><a href='javascript:;'>" + b + "</a></li><li class='paginItem' id='page_three'><a href='javascript:;'>" + c + "</a></li><li class='paginItem' id='page_four'><a href='javascript:;'>" + d + "</a></li><li class='paginItem' id='page_five'><a href='javascript:;'>" + e + "</a></li><li class='paginItem'  id='page_next'><a href='javascript:;' id='page_next_a'><span class='pagenxt'>下5页</span></a></li>");
			}else{
			$("li#page_last").css("hover", null);
		}

	});
	$("li#page_next").live('click',function() {

		var i = $("li#page_five > a").text();
		if(parseInt(i) < parseInt(totalPage)) {
			var a = parseInt(i) + 1;
			var b = parseInt(i) + 2;
			var c = parseInt(i) + 3;
			var d = parseInt(i) + 4;
			var e = parseInt(i) + 5;
			$("ul.paginList").empty();
			$("ul.paginList").append("<li class='paginItem'  id='page_last'><a href='javascript:;' id='page_last_a'><span class='pagepre'>上5页</span></a></li><li class='paginItem' id='page_one'><a href='javascript:;'>" + a + "</a></li><li class='paginItem' id='\page_two'><a href='javascript:;'>" + b + "</a></li><li class='paginItem' id='page_three'><a href='javascript:;'>" + c + "</a></li><li class='paginItem' id='page_four'><a href='javascript:;'>" + d + "</a></li><li class='paginItem' id='page_five'><a href='javascript:;'>" + e + "</a></li><li class='paginItem'  id='page_next'><a href='javascript:;' id='page_next_a'><span class='pagenxt'>下5页</span></a></li>");

		}


	});
	

});