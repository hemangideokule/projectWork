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
<div id="myCarousel" class="carousel slide" data-ride="carousel">
<ol class="carousel-indicators">

<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
<li data-target="#myCarousel" data-slide-to="1" ></li>
<li data-target="#myCarousel" data-slide-to="2" ></li>
<li data-target="#myCarousel" data-slide-to="3" ></li>

</ol>

<div  class="carousel-inner">
<div class="item active">
<%-- <img class="img-responsive centre block" class="img-responsive centre block" src="<spring:url value="/resources/pic1.jpg/"></spring:url>" style="width:100%" height="80%">
 --%>
<img class="img-responsive centre block"  src="E:\pic1.jpg" style="width:100%" "height:100%">

</div>
<div class="item">
<%-- <img class="img-responsive centre block" class="img-responsive centre block" src="<spring:url value="/resources/pic2.jpg/"></spring:url>" style="width:100%"> 
 --%>
 <img class="img-responsive centre block"  src="E:\pic5.jpg" style="width:100%" "height:100%">
 </div>
<div class="item">
<%-- <img class="img-responsive centre block" class="img-responsive centre block" src="<springs:url value="/resources/pic3.jpg/"></spring:url>" style="width:100%">
 --%>
 <img class="img-responsive centre block" src="E:\pic3.jpg" style="width:100%" "height:100%">
 </div>
<div class="item">
<%-- <img class="img-responsive centre block" class="img-responsive centre block" src="<spring:url value="/resources/pic4.jpg/"></spring:url>" style="width:100%">
 --%>
 <img class="img-responsive centre block"  src="E:\pic4.jpg" style="width:100%" "height:100%">
 </div>


</div>


<a class="left carousel-control" href="#myCarousel" data-slide="prev">
<span class="glyphicon glyphicon-chevron-left"></span>
<span class="sr-only">Previous</span>
</a>
<a class="right carousel-control" href="#myCarousel" data-slide="next">
<span class="glyphicon glyphicon-chevron-right"></span>
<span class="sr-only">Next</span>
</a>

</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>