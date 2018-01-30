<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
 <link type="text/css" rel="stylesheet" href="resources/nav.css">

</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
<br><br><br><br>
<div class="container">
<c:url value="/productUpdate" var="pro"></c:url>
<form method="post" action="productUpdate" enctype="multipart/form-data" >
	<span id="reauth-email" class="reauth-email"></span>
	<input type="hidden" name="pid" value="${prod.pid }">
	
	<h4 class ="input-title"> Product Name :	<input value="${prod.prodName}" type="text" name="prodName" required/ >
	 </h4>

	<h4 class ="input-title"> Product Description :	<input value="${prod.description}"  type="text" name="description" required /> </h4> <br> 

	
	<h4 class ="input-title"> Product Price :  	<input value="${prod.price}" type="number" name="price" required/ ></h4>

	
	<h4 class ="input-title"> Product Stock :	<input value="${prod.stock}" type="number" name="stock" required/ ></h4>

	<br>
<div class="form-group">
		<table>
		<tr>
		   <td> Select Supplier</td>
		   <td> 
		   <select class="form-control" name="sid" required/>
		  <!--  <option value="">---Select Supplier---</option> -->
		   
		   <c:forEach items="${satList}" var="sat">
            <option value="${sat.sid }">${sat.supplierName}</option>
		   </c:forEach>
		</select>
	
		</tr>
		</table>
	</div>
	
	<div class="form-group">
		<table>
		<tr>
		   <td> Select Category</td>
		   <td> 
		   <select class="form-control" name="cid" required/>
		 <!--   <option value="">---Select Category---</option> -->
		   
		   <c:forEach items="${catList}" var="cat">
            <option value="${cat.cid }">${cat.cname}</option>
		   </c:forEach>
		</select>
	</tr>
		</table>
	</div>
	
	<div class="fileinput fileinput-new" data-provides="fileinput">
	<td> Product Image</td>
	<td><input class="form-control" type="file" name="file" accept="image/*"></td>

	</div>
	
	
	<br>
	<button class="btn btn-lg btn-primary" type="submit"> Update</button>
	<button class="btn btn-lg btn-warning" type="reset"> Cancel</button>
	
	</form>
</div>
</body>
</html>