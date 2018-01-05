<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<s:url var="css" value="/resources/css" />
<s:url var="js" value="/resources/js" />
<s:url var="img" value="/resources/images" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="omashop">
<meta name="author" content="niyaz">

<title>BIILING</title>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme CSS -->
<link href="${css}/bootstrap-cus-theme.css" rel="stylesheet">
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="${css}/shop-homepage.css" rel="stylesheet">


<!-- jQuery -->
<script src="${js}/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${js}/bootstrap.min.js"></script>

<script type="text/javascript" src="${js}/jquery.dataTables.js"></script>


<script type="text/javascript" src="${js}/dataTables.bootstrap.js"></script>


<script type="text/javascript" src="${js}/modernizr-2.6.2.min.js"></script>

</head>
	<body>
		<div class="container">
		<div align="center">
		<img src="${img}/logo.jpg" alt="cakes" height="150" width="150" align="center"  class="img-circle">
		<h2 class="page-header">ORDER SUMMARY</h2>
		</div>
		
		<div>
			<form:form modelAttribute="cartModel" class="form-horizontal" method="post">
					<h3>CUSTOMER DETAILS</h3>
					<div class="form-group">
						<label class="control-label col-sm-2">Customer Name:</label>
						<div class="col-sm-10 displayinfo">${cartModel.user.userName}</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">Email:</label>
						<div class="col-sm-10 displayinfo">${cartModel.user.email}</div>
						
					</div>
					
					<h3>SHIPPING ADDRESS DETAILS</h3>
					<div class="form-group">
						<label class="control-label col-sm-2">Address :</label>
						<div class="col-sm-10 displayinfo">${cartModel.address.shippingAddress}</div>
					</div>		
					
					<div class="form-group">
						<label class="control-label col-sm-2">State:</label>
						<div class="col-sm-10 displayinfo">${cartModel.address.state}</div>
					</div>		
					<div class="form-group">
						<label class="control-label col-sm-2">City:</label>
						<div class="col-sm-10 displayinfo">${cartModel.address.city}</div>
					</div>				
						
					<div class="form-group">
						<label class="control-label col-sm-2">Pincode:</label>
						<div class="col-sm-10 displayinfo">${cartModel.address.pincode}</div>
					</div>					
					<h3>PRODUCT DETAILS</h3>
					<div class="form-group">
						<table border="1">
						<ul>
							
							<c:forEach items="${cartModel.cartItemList }" var="item">
							<tr>
							<td>
								
								
								
								
									<ul class="list-inline">
									
										<li class="col-sm-6 displayinfo">Name:${item.product.name}</li>
										<li class="col-sm-6 displayinfo">Quantity:${item.quantity}</li>
										<li class="col-sm-6 displayinfo">Unit Price:&#8377;&nbsp;${item.product.price}</li>
										
									<br><br><br>
									</ul>
									
									
									
								
								</td>
							</tr>	
							</c:forEach>
							
						</ul>
						</table>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">Grand Total:</label>
						<div class="col-sm-10 displayinfo">${cartModel.cart.grandTotal}</div>
					</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input name="_eventId_submit" type="submit" value="Next" class="btn btn-primary btn-lg" /> 
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>