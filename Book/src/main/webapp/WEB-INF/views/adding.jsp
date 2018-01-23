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
<br><br>
<div class="container"><br>

<div class="page-header">
<div class="container">

<div class="row">
<div class="col-md-6">
<div class="panel with-nav-tabs panel-primary">
<div class="panel-heading">
      <ul class="nav nav-tabs">
      <li class="active"> <a href="#tab1" data-toggle="tab"><font color="Black" >Supplier</font></a>
      <li> <a href="#tab2" data-toggle="tab"><font color="Black" >Category</font></a>
      <li> <a href="#tab3" data-toggle="tab"><font color="Black" >Product</font></a>
      
      </ul>
</div>

<div class="panel-body">
<div class="tab-content">

<div class="tab-pane fade in active" id="tab1">
	<form method="post"  class="form-signin" action="<c:url value="/admin/saveSupp"/>">
	<span id="reauth-email" class="reauth-email"></span>
	<h3 class ="input-title"> Supplier Id</h3><br>
	<input class="form-control"  type="number" name="sid" required >
	<h3 class ="input-title"> Supplier name</h3><br>
	<input class="form-control"  type="text" name="sname" required >
		<br>
	<button class="btn btn-lg btn-primary" type="submit"> Save</button>
	<button class="btn btn-lg btn-warning" type="reset"> Cancel</button>
	</form>
</div>


<div class="tab-pane fade" id="tab2">
	<form method="post" class="form-signin" action="<c:url value="/admin/saveCat"/>" >
	<span id="reauth-email" class="reauth-email"></span>
	<h3 class ="input-title"> Category Id</h3><br>
	<input class="form-control"  type="number" name="cid" required >
	
	<h3 class ="input-title"> Category name</h3><br>
	<input class="form-control"  type="text" name="cname" required >
	
	<br>
	<button class="btn btn-lg btn-primary" type="submit"> Save</button>
	<button class="btn btn-lg btn-warning" type="reset"> Cancel</button>
	
	
	</form>
</div>
<div class="tab-pane fade" id="tab3">
	<form method="post" class="form-signin" action="<c:url value="/admin/saveProduct"/>" enctype="multipart/form-data" >
	<span id="reauth-email" class="reauth-email"></span>
	
	<h3 class ="input-title"> Product Name</h3><br>
	<input class="form-control"  type="text" name="pName" required >
	
	<h3 class ="input-title"> Product Description</h3><br>
	<input class="form-control"  type="text" name="pDescription" required >
	
	<h3 class ="input-title"> Product Price</h3><br>
	<input class="form-control"  type="number" name="pPrice" required >
	
	<h3 class ="input-title"> Product Stock</h3><br>
	<input class="form-control"  type="number" name="pStock" required >
	
<div class="form-group">
		<table>
		<tr>
		   <td> Select Supplier</td>
		   <td> 
		   <select class="form-control" name="pSupplier" required>
		   <option value="">---Select Supplier---</option>
		   
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
		   <select class="form-control" name="pCategory" required>
		   <option value="">---Select Category---</option>
		   
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
	<button class="btn btn-lg btn-primary" type="submit"> Save</button>
	<button class="btn btn-lg btn-warning" type="reset"> Cancel</button>
	
	</form>
</div>


</div>
</div>

</div>
</div>
</div>
</div>
</div>

</div>


</body>
</html>