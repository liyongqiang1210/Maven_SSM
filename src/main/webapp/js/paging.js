(function($, window, document, undefined) {
	//定义分页类
	function Paging(element, options) {
		this.element = element;
		//传入形参
		this.options = {
			pageNo: options.pageNo || 1,//当前页
			totalPage: options.totalPage,//总页数
			totalSize: options.totalSize,
			callback: options.callback
		};
		//根据形参初始化分页html和css代码
		this.init();
	}
	//对Paging的实例对象添加公共的属性和方法
	Paging.prototype = {
		constructor: Paging,
		init: function() {
			this.creatHtml();
			this.bindEvent();
		},

		/**
		 * 页面样式定义规则：
		 * 如果current == i的话代表当前页数被选中，那么它的class应该是current-select
		 * 如果选中的页数是第一页的话，首页与上一页的按钮属性设置为禁用，
		 * 如果选中的页数是最后一页的话，下一页与尾页的按钮属性设置为禁用	
		 */
		creatHtml: function() {
			var me = this;
			var content = "";
			var current = me.options.pageNo;
			var total = me.options.totalPage;
			var totalNum = me.options.totalSize;
			//当current是第一页或者不是数字的时候将其修改成p标签使其不能跳转
			if(current == 1 || isNaN(current)) { 
				content += "<p id='firstPage-disable'>首页</p><p id='prePage-disable'>上一页</p>";

			} else {
				content += "<a id='firstPage'>首页</a><a id='prePage'>上一页</a>";
			}
			//总页数大于6时候
			if(total > 6) {
				//当前页数小于5时显示省略号
				if(current < 5) {
					for(var i = 1; i < 6; i++) {

						if(current == i) {
							content += "<a class='current-select'>" + i + "</a>";
						} else {
							content += "<a class='current'>" + i + "</a>";
						}
					}
					content += ". . .";
					content += "<a class='current'>" + total + "</a>";
				} else {
					//判断页码在末尾的时候
					if(current < total - 3) {
						for(var i = current - 2; i < current + 3; i++) {
							if(current == i) {
								content += "<a class='current-select'>" + i + "</a>";
							} else {
								content += "<a class='current'>" + i + "</a>";
							}
						}
						content += ". . .";
						content += "<a>" + total + "</a>";
						//页码在中间部分时候	
					} else {
						content += "<a>1</a>";
						content += ". . .";
						for(var i = total - 4; i < total + 1; i++) {
							if(current == i) {
								content += "<a class='current-select'>" + i + "</a>";
							} else {
								content += "<a class='current'>" + i + "</a>";
							}
						}
					}
				}

			}
			//页面总数小于6的时候
			else {
				for(var i = 1; i < total + 1; i++) {
					if(current == i) {
						content += "<a class='current-select'>" + i + "</a>";
					} else {
						content += "<a class='current'>" + i + "</a>";
					}
				}
			}
			
			//当current为最后一页或者不是数字的时候下一页与尾页设置为p标签使其按的时候不能跳转的
			if(current == total || isNaN(current)) { 
				content += "<p id='nextPage-disable'>下一页</p>";
				content += "<p id='lastPage-disable'>尾页</p>";
			} else {
				content += "<a id='nextPage'>下一页</a>";
				content += "<a id='lastPage' value="+total+">尾页</a>";
			}

			content += "<span class='totalPages'> 共<span>" + total + "</span>页 </span>";
			content += "<span class='totalSize'> 共<span>" + totalNum + "</span>条记录 </span>";
			me.element.html(content);
		},
		//添加页面操作事件
		bindEvent: function() {
			var me = this;
			me.element.on('click', 'a', function() {
				var lastPage = $(this).val();
				var num = $(this).html();
				var id = $(this).attr("id");
				if(id == "prePage") {
					if(me.options.pageNo == 1) {
						me.options.pageNo = 1;
					} else {
						me.options.pageNo = +me.options.pageNo - 1;
					}
				} else if(id == "nextPage") {
					if(me.options.pageNo == me.options.totalPage) {
						me.options.pageNo = me.options.totalPage;
					} else {
						me.options.pageNo = +me.options.pageNo + 1;
					}

				} else if(id == "firstPage") {
					me.options.pageNo = 1;
				} else if(id == "lastPage") {
					me.options.pageNo = me.options.totalPage;
				} else {
					me.options.pageNo = +num;
				}
				me.creatHtml();
				if(me.options.callback) {
					me.options.callback(me.options.pageNo);
				}
			});
		}
	};
	//通过jQuery对象初始化分页对象
	$.fn.paging = function(options) {
		return new Paging($(this), options);
	}
})(jQuery, window, document);