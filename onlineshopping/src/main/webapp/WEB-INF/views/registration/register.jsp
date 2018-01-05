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

<title>Homepage ${title}</title>

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
	<%-- <%@include file="../shared/navbar.jsp"%> --%>
	<%@taglib prefix="security"
		uri="http://www.springframework.org/security/tags"%>
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${contextRoot}/home"><img
					src="${img}/logo.jpg" alt="cakes" height="50" width="50"
					class="img-circle"></a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li id="Products"><a href="${contextRoot}/products">Products</a>
					</li>
					<li id="Contact"><a href="#">ContactUs</a></li>

					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<div class="content">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="form-container col-md-6">
				<form:form class="form-horizontal" method="POST"
					modelAttribute="user">
					<h3>REGISTER</h3>
					<br>
					<br>

					<div class="row">
						<div class="form-group">
							<label class="col-md-3 control-lable" for="userName">User
								Name</label>
							<form:input path="userName" type="text" class="form-control" />

							<div class="has-error">
								<form:errors style="color:red" path="userName"
									class="help-inline" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group">
							<label class="col-md-3 control-lable" for="firstName">First
								Name</label>
							<form:input path="firstName" type="text" class="form-control" />

							<div class="has-error">
								<form:errors style="color:red" path="firstName"
									class="help-inline" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group">
							<label class="col-md-3 control-lable" for="lastName">Last
								Name</label>
							<form:input path="lastName" type="text" class="form-control" />

							<div class="has-error">
								<form:errors style="color:red" path="lastName"
									class="help-inline" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group">
							<label class="col-md-3 control-lable" for="email">Email</label>
							<form:input path="email" type="email" class="form-control" />
							<div class="has-error">
								<form:errors style="color:red" path="email" class="help-inline" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group">
							<label class="col-md-3 control-lable" for="password">Password</label>
							<form:input path="password" type="password" class="form-control" />
							<div class="has-error">
								<form:errors style="color:red" path="password"
									class="help-inline" />
							</div>
						</div>
					</div>

					<%-- <div class="row">
						<div class="form-group">
							<label class="col-md-3 control-lable" for="confirmPassword">Confirmpassword</label>
							<form:input path="confirmPassword" type="password" class="form-control" />
							<div class="has-error">
								<form:errors style="color:red" path="confirmPassword"	class="help-inline" />
							</div>
						</div>
					</div> --%>
					<div class="row">
						<div class="form-group">
							<label class="col-md-3 control-lable" for="role">Role</label>
							<form:select path="role" type="text" class="form-control">
								<form:option value="User" label="User" selected="true" />
								<form:option value="Supplier" label="Supplier" />
							</form:select>
							<div class="has-error">
								<form:errors style="color:red" path="role" class="help-inline" />
							</div>
						</div>
					</div>







					<div class="row">
						<div class="form-group">
							<input type="submit" name="_eventId_submit" value="Register"
								class="btn btn-primary btn-md" />
						</div>
					</div>
				</form:form>

			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</body>
</html>