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

<div align="center">
<img src="${img}/logo.jpg" alt="cakessss" height="100" width="100" align="center"  class="img-circle">
<h3>Billing Address</h3>
</div>
		<div class="content">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="form-container col-md-8">
					<form:form class="form-horizontal" method="POST" modelAttribute="address">
						
						

						<div class="row">
							<div class="form-group">
								<label class="col-md-3 control-lable" for="billingAddress">ADDRESS</label>
								<form:input path="billingAddress" type="text" class="form-control"
									placeholder="Enter the Address" />
								<div class="has-error">
									<form:errors style="color:red" path="billingAddress"
										class="help-inline" />
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="form-group">
								<label class="col-md-3 control-lable" for="city">CITY</label>
								<form:input path="city" type="text" class="form-control" placeholder="Enter the City"/>
								<div class="has-error">
									<form:errors style="color:red" path="city"
										class="help-inline" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group">
								<label class="col-md-3 control-lable" for="pincode">Pincode</label>
								<form:input path="pincode" type="text" class="form-control"
									placeholder="Enter Pincode" />
								<div class="has-error">
									<form:errors style="color:red" path="pincode" class="help-inline" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group">
								<label class="col-md-3 control-lable" for="state">State</label>
								<form:input path="state" type="text" class="form-control" placeholder="Enter the State"/>
								<div class="has-error">
									<form:errors style="color:red" path="state" class="help-inline" />
								</div>
							</div>
						</div>

						 <%-- <div class="row">
							<div class="form-group">
								<form:checkbox path="shippingAddress" class="form-control" />
								Shipping address is same as Billing address
							</div>
						</div> 
 --%>
						<div class="row">
							<div class="form-group">
								<input type="submit" name="_eventId_submit" value="Submit" class="btn btn-primary btn-md"/>
							</div>
						</div>
						
					</form:form>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
	</body>
</html>