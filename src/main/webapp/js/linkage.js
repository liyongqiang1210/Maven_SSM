$(document).ready(function() {
	var w, h, className;
	function getSrceenWH() {
		w = $(window).width(300);
		h = $(window).height(500);
		$('#dialogBg').width(w).height(h);
	}

	window.onresize = function() {
		getSrceenWH();
	}
	$(window).resize();

	$(function() {
		getSrceenWH();

		//显示弹框
		$('.toolbar>li#add').click(
				function() {
					className = $(this).attr('class');
					$('#dialogBg').fadeIn(300);
					$('#dialog').removeAttr('class').addClass(
							'animated ' + className + '').fadeIn();
				});

		//关闭弹窗
		$('.claseDialogBtn').click(function() {
			$('#dialogBg').fadeOut(300, function() {
				$('#dialog').addClass('bounceOutUp').fadeOut();
			});
		});
	});
	
})