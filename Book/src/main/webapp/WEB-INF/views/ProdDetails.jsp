<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<div class="container">
<div class="row">
<div class="col-sm-4 item-photo">
<img style="max-width:100%"; margin-top:30px;"
src="${pageContext.request.contextPath }/resources/${prod.imgName}"/>
</div>
<div class="col-sm-4" style="border:0px solid gray">
<h3>${prod.prodName }</h3>
<h4>${prod.description }</h4>
<h4>Rs. ${prod.price }</h4>
<h5>${prod.supplierName }</h5>

<div class="section" style="padding-bottom:20px;">

<form action="${pageContext.request.contextPath }/addToCart" method="post">

<input type="hidden"  value="${prod.pid }" name="pid"/>
<input type="hidden"  value="${prod.price }" name="pPrice"/>
<input type="hidden"  value="${prod.prodName }" name="pName"/>
<input type="hidden"  value="${prod.imgName }" name="imgName"/>
<label>Quantity</label>
<input type="number" class="form-control" name="pQty" required/><br><br>

<input class="btn btn-warning btn-lg" type="submit" value="Add To Cart" >
<h6><span class="glyphicon-heart-empty" style="cursor:pointer; color:Red;"></span>Wish List</h6>

</form>
</div>
</div>
<hr>
<div class="col-sm-9">
<h3> Product Details</h3>
<ul class="menu-item">
<li> All Books Are Checked  by corresponding Authority</li> 
</ul>
</div>

<br><br>
<h6> We Are Authorized company by Indian Government</h6>
</div>
</div>
</body>
</html>