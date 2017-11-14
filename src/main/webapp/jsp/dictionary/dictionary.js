$(document).ready(function() {
	// 调用全选反选的方法
	checkBox();
	$.ajax({
		url:"/Maven_SSM/dictionary/getDataByConditions",
		type:"post",
		data:{"dictionary-key":$("#dictionary-key").val(),"dictionary-create-time":$("dictionary-create-time").val(),"page":1},
		dataType:"json",
		success:function(data){
			var str = '';
			if(data!=null&&data!=""){
				for(var i = 0;i<data.length;i++){
					str+="<tr><td><input type='checkbox' name='option'></td><td>"+data[i].dictionary_id+"</td><td>"+data[i].dictionary_key+"</td><td>"+data[i].dictionary_value+"</td><td>"+data[i].dictionary_create_time+"</td><td>"+
						"<button type='button' class='btn btn-info btn-xs'>编辑</button><button type='button' class='btn btn-danger btn-xs'>删除</button></td></tr>";
				}
				$("#tbody").empty().append(str);
			}
		}
		
	});
});
function paging(){
	var dictionary_key = $("#dictionary-key").val();
	alert("key:"+dictionary_key);
}
