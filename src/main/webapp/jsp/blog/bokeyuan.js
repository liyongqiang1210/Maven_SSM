  (function() {
  	$('#exampleTableEvents').bootstrapTable({
  		url: "../js/demo/bootstrap_table_test.json",
  		search: true,
  		pagination: true,
  		showRefresh: true,
  		showToggle: true,
  		showColumns: true,
  		clickToSelect: true,
  		striped: true,
  		pageSize: 5,
  		pageList: [5, 10, 15, 20],
  		iconSize: 'outline',
  		toolbar: '#exampleTableEventsToolbar',
  		icons: {
  			refresh: 'glyphicon-repeat',
  			toggle: 'glyphicon-list-alt',
  			columns: 'glyphicon-list'
  		}
  	});

  })(document, window, jQuery);