  (function() {
  	$('#exampleTableEvents').bootstrapTable({
  		url:"../js/demo/bootstrap_table_test.json",
  		search: true,
  		cache: false,
  		pagination: true,
  		showRefresh: true,
  		showToggle: true,
  		showColumns: true,
  		clickToSelect: true,
  		uniqueId: "video_id", //每一行的唯一标识，一般为主键列 
  		striped: true, //是否显示行间隔色 
  		sidePagination: "client", //分页方式：client客户端分页，server服务端分页（*）  
  		pageNumber: 1,
  		pageSize: 5,
  		//height: 750,//设置行高会导致表格的表头与内容对不齐
  		pageList: [5, 10, 15, 20],
  		iconSize: 'outline',
  		toolbar: '#exampleTableEventsToolbar',
  		icons: {
  			refresh: 'glyphicon-repeat',
  			toggle: 'glyphicon-list-alt',
  			columns: 'glyphicon-list'
  		},
  		columns: [{
  				checkbox: true
  			},
  			{
  				title: '序号',
  				field: 'video_id',
  				align: 'center'
  			},
  			{
  				title: '视频名称',
  				field: 'video_title',
  				align: 'center'
  			},
  			{
  				title: '视频url',
  				field: 'video_url',
  				align: 'center'
  			},
  			{
  				title: '视频价格',
  				field: 'video_price',
  				align: 'center'
  			},
  			{
  				title: '学习人数',
  				field: 'video_number',
  				align: 'center'
  			},
  			{
  				title: '操作',
  				align: 'center',
  				field: 'video_id',
  				formatter: function(value, row, index) {
  					var html = '<a href="javascript:EditVideo(' + value + ')">编辑</a>';
  					html += '　<a href="javascript:DeleteVideo(' + value + ')">删除</a>';
  					html += '   <a href="../blog/bokeyuan.html">查看详细课程</a>'
  					
  					return html;
  				}
  			}
  		]
  	});

  })(document, window, jQuery);

  function EditVideo(str) {
  	alert("id:" + str);
  }
  function DeleteVideo(str) {
  	alert("id:" + str);
  }
  function SelectVideo(str) {
  	alert("id:" + str);
  }