$(document).ready(function() {
	$("#right").click(function() {
		event.preventDefault();// 使a自带的方法失效，
		$.post(
			"getAllNews"
		);
	});
});
