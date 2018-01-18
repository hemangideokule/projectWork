<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
<h1> Authentication Error...!!</h1>
<h3> Go back to HOME or <a href="${pageContext.request.contextPath }/reLogin"> Login</a></h3>
<img class="img-responsive centre block" class="img-responsive centre block" src="E:\error.png" style="width:50%" height="50%">
 

</div>

</body>
</html>