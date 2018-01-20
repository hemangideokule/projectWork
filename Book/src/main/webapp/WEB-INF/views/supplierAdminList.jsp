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
<h2> Supplier List For Admin</h2>
<table class="table table-hover" id="asl" class="display" border="2" width="80" align="center">
<tr>
<th> SI No</th>
<th> SID </th>
<th>Supplier Name</th>
<th class="span2"> Action</th>
</tr>
<c:if test="${empty satList }">
<tr>
<td colspan="10" align="center"> No Record Exist!!</td>
</tr>
</c:if>

<c:forEach var="p" varStatus="st" items="${satList }">
<tr>
<td><c:out value="${st.count }"></c:out></td>
<td><c:out value="${p.sid}"></c:out></td>
<td><c:out value="${p.supplierName }"></c:out></td>
<td class="span4">
<c:set var="contextRoot" value="${ pageContext.request.contextPath}/supplierList"></c:set>
<a class="btn btn-info" role="button" href="${contextRoot }/admin/updateSat?sid= <c:out value="${p.sid }" ></c:out>" > Edit</a>
 
 
<a class="btn btn-danger" role="button" href="<c:url value="/admin/deleteSat/${p.sid}"/>"> Delete</a></td>

</tr>
</tr>
</c:forEach>





</table>
</div>

</body>
</html>