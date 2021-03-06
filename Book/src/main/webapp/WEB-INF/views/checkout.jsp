<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
<div class="col-xs-6" jumbotron>
<div class="head">
<br>
<br>
<br>
<br>

<label>Customer Shipping Details</label>
</div>
<div class="outer">
<div class="well" style="width:100%">
<form action="/orderProcess" method="post">
<c:set var="gtot" value="0"></c:set>
<c:forEach var="c" items="${cart}">
<c:set var="gtot" value="${gtot+c.cartPrice*c.cartQuantity}"></c:set>

</c:forEach>
<div class="well">
<table>
<tr>
<td colspan="3">NAME:</td><td>${user.name}</td>
</tr>

<tr>
<td colspan="3">EMAIL ID:</td><td>${user.email}</td>
</tr>

<tr>
<td colspan="3">ADDRESS:</td><td>${user.address}</td>
</tr>

<tr>
<td colspan="3">PHONE NO:</td><td>${user.phone}</td>
</tr>
</table>
<div class="outer">
<h3>Enter Payment Details</h3>
<br>
<label> Select Payment</label>
<select name="payment">
<option value="COD">Cash On Delivery</option>
<option value="Net">Net Banking</option>
</select>
<br><br>
</div>
Name: <input type="text" name="name on card">
<br>

Card Number:<input type="number" name="card number">
<br>
CVV:<input type="number" name="cvv">

<input type="hidden" name="total" value="${gtot}">

</div>
</form>
</div>
<input type="submit" value="PROCEED" style="width:75%" class="btn btn-danger">
<input type="reset" value="CANCEL" style="width:75%" class="btn btn-primary">


</div>




</div>
</div>
</div>
</body>
</html>