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
<table class="table table-hover" id="apl" class="display" border="2" width="80" align="center">
<tr>
<!-- <td>SI No<td> -->
<th> PID </th>
<th>Product Name</th>
<th>Product Quantity</th>
<th>Product Price</th>
<th>Product Image</th>
<th>Sub Total</th>
<th>Action</th>
</tr>
<c:if test="${empty prodList }">
<tr>
<td colspan="10" align="center"> No Record Exist!!</td>
</tr>
</c:if>

<c:forEach var="p" varStatus="st" items="${cartInfo}">
<tr>
<%-- <td><c:out value="${st.count }"></c:out></td> --%>
<td><c:out value="${p.prodName}"></c:out></td>
<td><c:out value="${p.qty }"></c:out></td>
<td><c:out value="${p.price }"></c:out></td>

<td><img src="${pageContext.request.contextPath }/resources/${p.imgName}" height="50px" width="50px"></td>
<td><c:out value="${p.qty * p.price }"></c:out></td>
<td class="span 2">
<c:set var="contextRoot" value="${ pageContext.request.contextPath}"></c:set>
<a class="btn btn-danger" role="button" href="<c:url value="/deletePCart/${p.cartId }"/>"> Delete</a>
</td>
</tr>
</c:forEach>
<td>
<c:set var="gtot" value="${gtot+p.price*p.qty }"></c:set>
<span class="col-lg-9" align="right"><label>Grand Total</label><c:out value="${gtot }"/></span>
</td>

<tfoot>
<td>
<a class="btn btn-warning btn-lg " href="${ pageContext.request.contextPath}/index">Continue Shopping</a>
</td>

<td>
<a class="btn btn-success btn-lg " href="${ pageContext.request.contextPath}/checkout">Checkout</a>
</td>

</tfoot>



</table>
</body>
</html>