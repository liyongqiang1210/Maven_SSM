/**
 * right页面的js
 */
$(document).ready(function(){
	
	$("#all").click(function(){
		if($("#all").is(':checked') == true){
			$("[name = option]:checkbox").attr("checked", true);
		}else{
			$("[name = option]:checkbox").attr("checked", false);
		}
	});
});

