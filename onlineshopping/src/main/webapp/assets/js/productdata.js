$(function() {
	$('#myproduct')
			.DataTable(
					{
						ajax : {
							url : '/onlineshopping/admin/admin/displayproducts',
							dataSrc : ''
						},
						columns : [
								{
									data : 'name'
								},
								{
									data : 'description'
								},
								{
									data : 'quantity'
								},
								{
									data : 'price',
									mRender : function(data, type, row) {
										return "&#8377; &#160;" + data;
									}
								},

								{
									data : null,
									mRender : function(data, type, row) {
										return '<img src="/onlineshopping/resources/images/'
												+ row.imageUrl+'" height="50" width="50">';
									}
								},
								{
									data : null,
									mRender : function(data, type, row) {
										return '<a class="btn btn-primary" href="/onlineshopping/admin/showproduct/'
												+ row.id+ '">Update Item</a> &nbsp;<a class="btn btn-primary" href="/onlineshopping/admin/delete/'
												+ row.id+ '">Delete</a>';
									}
								} ]
					});

});
