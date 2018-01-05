<html>
<head>
<%@ include file="./shared/el.jsp" %>
<script type="text/javascript">
	$(function() {
		$('#myProductTable')
				.DataTable(
						{
							ajax : {
								url : '/onlineshopping/allproducts',
								dataSrc : ''
							},
							columns : [
									
									{
										data : 'name'
									},{
										data : 'brand'
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
							+ row.imageUrl+ '" height="50" width="50">';
										}
									},
									{
										data : null,
										mRender : function(data, type, row) {
											return '<a class="btn btn-primary" href="${contextRoot}/showproduct/' 
							+ row.id+ '">View Item</a> &nbsp;<a class="btn btn-primary" href="${contextRoot}/cart/user/addtocart/' 
							+ row.id + '"><span class="glyphicon glyphicon-shopping-cart"></span>Add To Cart</a>';
										}
									} ]
						});
	});
</script>
</head>
<body>
<%@ include file="./shared/navbar.jsp" %>
	<div class="col-md-offset-2 col-md-6" style="width:80%">
		<table class="table table-striped table-bordered" id="myProductTable" align="left">
			<thead>
				<tr>
					<th>Name</th>
					<th>Brand</th>
					<th>Description</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Image</th>
					<th></th>
				</tr>
			</thead>
		</table>
	</div>
	
</body>
</html>							