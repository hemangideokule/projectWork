<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<title>Womens Shopping-${title}</title>
<script>
window.menu='${title}';
</script>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/shop-homepage.css" rel="stylesheet">
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
<link href="${css}/jquery.dataTables.css" rel="stylesheet">

<script src="${js}/jquery-3.1.1.js"></script>
<script src="${js}/bootstrap.min.js"></script>

<!-- self coded javascript -->
<script src="${js}/myapp.js"></script>

<!--  reference to data table files-->
<script src="${js}/mytable.js"></script>
<script src="${js}/productdata.js"></script>
<script src="${js}/jquery.dataTables.js"></script>
<script src="${js}/dataTables.bootstrap.js"></script>
