<html>
<head>
<Title>Product Details</Title>
<%@include file="./shared/el.jsp"%>
</head>

<body>
	<%@include file="./shared/navbar.jsp"%>
	<div class="container" id="product-section">
		
		<div class="row">
			<table>
			<tr>
			<td>
			<div class="col-md-3">
				<img src="${images}/${prd.imageUrl}" height="200" width="200" class="img-circle" />
				<!--  adjusting image with the layout -->
			</div>
			</td>
			</tr>
			<tr>
			<td>
			<br><br>
			
			<div class="col-md-5 ">
				<ul>
					
					<span style="font-weight:bold ; font-size:18px">Product Name:</span> ${prd.name}<br>
					<span style="font-weight:bold ; font-size:18px">Product Price: </span><span>&#8377;&nbsp;</span>${prd.price}<br>
					
				</ul>
				<div class="button">
				<a href="/onlineshopping/cart/user/addtocart/${prd.id}" class="btn btn-primary" role=button>
				<span></span>Add To Cart</a>
				
				</div>
			</div>
			</td>
			</tr>
			</table>
				</div>
		</div>
	</div>
	<!-- end row -->
	<%@include file="./shared/footer.jsp"%>
	<!-- end container -->

</body>
</html>
