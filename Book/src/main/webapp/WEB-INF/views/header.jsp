<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<title> KingsLand</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <link href=" https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<!-- <link href="/resources/nav.css" rel="stylesheet" type="text/javascript"> -->
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><i>BookStore</i></a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="${pageContext.request.contextPath }/index">HOME</a></li>
  
      
      
      <security:authorize access="hasRole('ROLE_ADMIN')">
          <li><a href="${pageContext.request.contextPath }/productList">Product List</a></li>
      <li><a href="${ pageContext.request.contextPath}/admin/adding">Admin</a></li>
	      <li class="dropdown">
	      <a class="dropdown-toggle" data-toggle="dropdown" 
	      href="#">Admin List<span class="caret"></span></a>
	      <ul class="dropdown-menu">
	         <li><a href="${ pageContext.request.contextPath}/admin/categoryList"> Category</a></li>
	            <li><a href="${ pageContext.request.contextPath}/admin/supplierList"> Supplier</a></li>
	             <li><a href="${ pageContext.request.contextPath}/admin/productList">Product</a></li> 
	              <%-- <li><a href="${ pageContext.request.contextPath}/categoryList"> Category</a></li>
	            <li><a href="${ pageContext.request.contextPath}/supplierList"> Supplier</a></li>
	             <li><a href="${ pageContext.request.contextPath}/productList">Product</a></li> --%>
	           </ul>
	        </li>   
	        </security:authorize>
	        
	
<%--     <security:authorize access="hasRole('ROLE_USER')"> --%>
        <li><a href="${pageContext.request.contextPath }/onlyProductCustList">Product List</a></li>
 <li class="dropdown">
 <a class="dropdown-toggle" data-toggle="dropdown" href="#">
 Category Choice<span class="caret"></span></a>
     <ul class="dropdown-menu">
     <c:forEach var="catVal" items="${catList }">
	           <li><a href="productCustList?cid=${catVal.cid}">${catVal.cname}</a></li>
	  </c:forEach>
	   </ul>
	    </li> 
	  <li><a href="${ pageContext.request.contextPath}/goToCart">My Cart</a></li>
	<%--    </security:authorize> --%>
 <li>   
<ul class="nav navbar-nav navbar right">  
    <c:if test="${pageContext.request.userPrincipal.name==null }">
       <li><a href="${pageContext.request.contextPath }/goToRegister"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
       <li><a href="${pageContext.request.contextPath }/goToLogin">Log In</a></li>
     </c:if>
     
    <c:if test="${pageContext.request.userPrincipal.name!=null }">
    	<li><a>Welcome:${pageContext.request.userPrincipal.name}</a></li>
       	<li><a href="${pageContext.request.contextPath }/logout">Log Out</a></li>
       	<li><a href="${pageContext.request.contextPath }/goToCart"></a>
   </c:if>
     
     
</ul>
</li>
    
 </ul>
   
  </div>
</nav>
</body>
</html>