<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
<title> Book Store</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <link href=" https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">


</head>

<body>

<jsp:include page="header.jsp"></jsp:include>
<br><br>
<div class="container">
<br><br>
<br><br>
<div class="row">
<div class="col-sm-4">
<h2> Welcome to Login Page</h2>
<form action="${pageContext.request.contextPath }/login" class="form-signin" method="post">

<h3><lable> Email:</lable></h3>
<input type="text" name="username" class="login-box" required>

<h3><lable> Password:</lable></h3>
<input type="password" name="password" class="login-box" required>

<br><br><br>
	<button class="btn btn-lg btn-primary" type="submit"> LogIn</button>
	<button class="btn btn-lg btn-warning" type="reset"> Cancel</button>
</form>
</div>

<div class="col-sm-6 item-photo">
<img style="max-width:100%"; margin-top:30px;"
src="E:\logInScreen.gif" style="width:50%" height="50%"/>
</div>



</div>
</div>
</body>
</html>