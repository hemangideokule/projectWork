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
<br><br>
<h3> Come Here To Update....!!</h3>
<div class="container">
<c:url value="/supplierUpdate" var="pro"></c:url>
<form method="post" action="${pageContext.request.contextPath }/admin/supplierUpdate"  >
	<span id="reauth-email" class="reauth-email"></span>
	<input type="hidden" name="sid" value="${supp.sid }">
	
	<h4 class ="input-title"> Supplier Name: </h4>
	<input value="${supp.supplierName}" type="text" name="supplierName" required/ >
	<h4 class ="input-title"> Supplier Address : </h4>  
	 <input value="${supp.address}"  type="text" name="address" required />
	<h4 class ="input-title"> Supplier Phone : </h4>
	<input value="${supp.phone}" type="number" name="phone" required/ >
	

	
<%-- 
	
	<div class="form-group">
		<table>
		<tr>
		   <td> Select Supplier</td>
		   <td> 
		   <select class="form-control" name="pSupplier" required/>
		  <!--  <option value="">---Select Supplier---</option> -->
		   
		   <c:forEach items="${satList}" var="sat">
            <option value="${sat.sid }">${sat.supplierName}</option>
		   </c:forEach>
		</select>
	
		</tr>
		</table>
	</div> --%>
	
	<br>
	<br>
	
	<button class="btn btn-lg btn-primary" type="submit"> Update</button>
	<button class="btn btn-lg btn-warning" type="reset"> Cancel</button>
	
	</form>
</div>
</body>
</html>