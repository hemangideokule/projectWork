<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<html>
	<head>
		<title>Sign In</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
		<s:url value="/resources/images" var="images"/>
		<s:url value="/resources/css" var="css"/>
		
		<%-- <link rel="stylesheet" type="text/css" href="${css}/singlePage.css"> --%>
	</head>
	<body>
		<div class="container">
		<h2 class="page-header">Receipt</h2>
		<div>
			<form:form modelAttribute="cartModel" class="form-horizontal" method="post">
				<c:forEach items="${cartModel.user.orderItem}" var="adr">
					<div class="form-group">
						<label class="control-label col-sm-2" for="orderId">Order Id:</label>
						<div class="col-sm-10 displayinfo">${adr.orderId}</div>
					</div>	
					<div class="form-group">
						<label class="control-label col-sm-2" for="productName">Product Name:</label>
						<div class="col-sm-10 displayinfo">${adr.productName}</div>
					</div>		
					<div class="form-group">
						<label class="control-label col-sm-2" for="quantity">Quantity:</label>
						<div class="col-sm-10 displayinfo">${adr.quantity}</div>
					</div>	
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="grandTotal">Grand Total:</label>
						<div class="col-sm-10 displayinfo">${adr.grandTotal}</div>
					</div>
					
			</c:forEach>
			</form:form>
			</div>
