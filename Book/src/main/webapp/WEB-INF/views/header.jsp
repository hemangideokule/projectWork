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
<style>
.dropbtn {
    background-color: #4CAF50;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
}
.dropdown {
    position: relative;
    display: inline-block;
}
.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}
.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}
.dropdown-content a:hover {background-color: #f1f1f1}
.dropdown:hover .dropdown-content {
    display: block;
}
.dropdown:hover .dropbtn {
    background-color: #3e8e41;
}
</style>



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
	      <a class="dropdown-hover" data-hover="dropdown" 
	      href="#">Admin List<span class="caret"></span></a>
	      <ul class="dropdown-content">
	         <li><a href="${ pageContext.request.contextPath}/admin/categoryList"> Category</a></li>
	            <li><a href="${ pageContext.request.contextPath}/admin/supplierList"> Supplier</a></li>
	             <li><a href="${ pageContext.request.contextPath}/admin/productList">Product</a></li> 
	              <%-- <li><a href="${ pageContext.request.contextPath}/categoryList"> Category</a></li>
	            <li><a href="${ pageContext.request.contextPath}/supplierList"> Supplier</a></li>
	             <li><a href="${ pageContext.request.contextPath}/productList">Product</a></li> --%>
	           </ul>
	        </li>   
	        </security:authorize>
	        
    <security:authorize access="hasRole('ROLE_USER')">
        <li><a href="${pageContext.request.contextPath }/onlyProductCustList">Product List</a></li>
       </security:authorize> 
 <li class="dropdown">
 <a class="dropdown-hover" data-hover="dropdown" href="#">
 Category Choice<span class="caret"></span></a>
     <ul class="dropdown-content">
     <c:forEach var="catVal" items="${catList }">
	           <li><a href="productCustList?cid=${catVal.cid}">${catVal.cname}</a></li>
	  </c:forEach>
	   </ul>
	    </li> 

	
 <li>   
<ul class="nav navbar-nav navbar right">  
    <c:if test="${pageContext.request.userPrincipal.name==null }">
       <li><a href="${pageContext.request.contextPath }/goToRegister"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
       <li><a href="${pageContext.request.contextPath }/goToLogin">Log In</a></li>
     </c:if>
     
    <c:if test="${pageContext.request.userPrincipal.name!=null }">
    	<li><a>Welcome:${pageContext.request.userPrincipal.name}</a></li>
       	<li><a href="${pageContext.request.contextPath }/logout">Log Out</a></li>
       	<li><a href="${pageContext.request.contextPath }/goToCart">My Cart
       	<i class="fa fa-cart-plus"  aria-hidden="true"></i></a></li>
   </c:if>
     
     
</ul>
</li>
    
 </ul>
   
  </div>
</nav>
</body>
</html>