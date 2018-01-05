<html lang="en">
<head>
<title>BAKERY</title>
<%@include file="./shared/el.jsp"%>
</head>
<body>
	<div class="wrapper">
		<!-- navigation -->
		<%@include file="./shared/navbar.jsp"%>
		<div class="content">
		<!-- Page Content -->
		<c:if test="${userClickHome==true}">
			<%@include file="page.jsp"%>
		</c:if>
		<!-- loads when user clicks about -->
		<c:if test="${userClickAbout==true}">
			<%@include file="about.jsp"%>
		</c:if>
		
		<!-- loads when user clicks about -->
		<c:if test="${userClickLogin==true}">
			<%@include file="login.jsp"%>
		</c:if>
		<!-- loads when user clicks admin -->
		<c:if test="${userClickAdmin==true}">
			<%@include file="admin.jsp"%>
		</c:if>

		<c:if test="${userClickProduct==true}">
			<%@include file="allproducts.jsp"%>
		</c:if>
		<!--  loading for all users -->
		<c:if test="${userClickAllProducts==true}">
			<%@include file="userproducts.jsp"%>
		</c:if>

		<c:if test="${userClickViewCart==true}">
			<%@include file="viewCart.jsp"%>

		</c:if>
		<c:if test="${catpro==true}">
			<%@include file="productsoncat.jsp"%>

		</c:if>
		</div>
		<!-- footer -->
		<%@include file="shared/footer.jsp"%>
	</div>
	<!-- container ends here -->


</body>
</html>