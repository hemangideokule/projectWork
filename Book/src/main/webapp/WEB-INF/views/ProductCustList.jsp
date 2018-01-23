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
<br><br>
<div class="container">
<br><br>
<br><br>

<h2> Product List For Customers</h2>

<table class="table table-hover" id="apl" class="display" border="2" width="80" align="center">
<tr>
<!-- <td>SI No<td> -->
<th> PID </th>
<th>Product Name</th>
<th>Product Supplier</th>
<th>Product Category</th>
<th>Description</th>
<th>Price</th>
<th>Stock</th>
<th>Image</th>
<th class="span2"> Action</th>
</tr>

<c:if test="${empty prodList }">
<tr>
<td colspan="10" align="center"> No Record Exist!!</td>
</tr>
</c:if>

<c:forEach var="p" varStatus="st" items="${prodList }">
<tr>
<%-- <td><c:out value="${st.count }"></c:out></td> --%>
<td><c:out value="${p.pid}"></c:out></td>
<td><c:out value="${p.prodName }"></c:out></td>
<td><c:out value="${p.supplier.supplierName}"></c:out></td>
<td><c:out value="${p.category.cname }"></c:out></td>
<td class="span3"><c:out value="${p.description }"></c:out></td>
<td><c:out value="${p.price }"></c:out></td>
<td><c:out value="${p.stock }"></c:out></td>

<td><img src="${pageContext.request.contextPath }/resources/${p.imgName}" height="50px" width="50px"></td>
<td class="span2">
<c:set var="contextRoot" value="${ pageContext.request.contextPath}<%-- /productList --%>"></c:set>
<a class="btn btn-info" role="button" href="<c:url value="/prodDetails/${p.pid }"/>"> View Item</a>
</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>

