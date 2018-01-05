<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container-fluid">
<div class="row">
	<div class="col-md-offset-2 col-md-8" style="width:80%">
		<table class="table table-striped table-bordered" id="catProducts">
			<thead>
				<tr>
					<th>Brand</th>
					<th>Product Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>Image</th>
					<th></th>
				</tr>
			</thead>
		</table>
	</div>
</div>

<script type="text/javascript">
$(document).ready(function(){
window.id='${id}';
$('#catProducts')
.DataTable(
		{
			ajax : {
				url : '/onlineshopping/category/'+id,
				dataSrc : ''
			},
			
			columns : [
					/*{
						data : 'category_id'
					},*/
					{
						data : 'brand'
					},
					{
						data : 'name'
					},
					{
						data : 'description'
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
							return '<a class="btn btn-primary" href="${contextRoot}/showproduct/' 
			+ row.id+ '">View Item</a> &nbsp;<a class="btn btn-primary" href="${contextRoot}/cart/user/addtocart/' 
			+ row.id + '"><span></span>Add To Cart</a>';
						}
					}

			]
		});


})
</script>


</div>
</div>