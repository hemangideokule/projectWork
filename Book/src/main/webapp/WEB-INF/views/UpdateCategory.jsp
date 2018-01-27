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

<body><%-- 
<jsp:include page="header.jsp"></jsp:include> --%>
<br><br><br><br>
<div class="container">

<c:url value="/categoryUpdate" var="pro"></c:url>
<form method="post" action="categoryUpdate" enctype="multipart/form-data" >
	<span id="reauth-email" class="reauth-email"></span>
	<input type="hidden" name="cid" value="${cat.cid }">
	<h4 class ="input-title">Choose To Update Category </h4>
	<div class="form-group">
		<table>
		<tr>
		   <td> Select Category</td>
		   <td> 
		   <select class="form-control" name="pCategory" required/>
		 <!--   <option value="">---Select Category---</option> -->
		   
		   <c:forEach items="${catList}" var="cat">
            <option value="${cat.cid }">${cat.cname}</option>
		   </c:forEach>
		</select>
	</tr>
		</table>
	</div>
	
	
	
	<br>
	<button class="btn btn-lg btn-primary" type="submit"> Update</button>
	<button class="btn btn-lg btn-warning" type="reset"> Cancel</button>
	
	
	</form>
</div>
</body>
</html>