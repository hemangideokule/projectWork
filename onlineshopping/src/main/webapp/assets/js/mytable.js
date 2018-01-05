$(function() {

	$('#mytable')
			.DataTable(
					{
						ajax : {
							url : '/onlineshopping/admin/all/category',
							dataSrc : ''
						},
						columns : [
								/*{
									data : 'category_id'
								},*/
								{
									data : 'name'
								},
								{
									data : 'description'
								},
								{
									data : null,
									mRender : function(data, type, row) {
										return '<img src="/onlineshopping/resources/images/'
												+ row.imageUrl+'" height="50" width="50">';
									}
								},
								{
									mRender : function(data, type, row) {
										return "<a class='btn btn-primary' href='/onlineshopping/admin/show/category/"
												+ row.id
												+ "'>Update Item</a> &nbsp;<a class='btn btn-primary' href='/onlineshopping/admin/delete/"
												+ row.id
												+ "/category'>Delete</a>";
									}
								}

						]
					});

});
