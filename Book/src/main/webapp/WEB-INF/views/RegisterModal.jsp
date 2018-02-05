<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
<br>
<div class="modal fade bs-example-modal-sm" tabindex="1" role="dialog"
aria-labelleby="myModal" aria-hidden="true" id="onload" >

<div class="modal-dialog modal-sm">
   <div class="modal-content">
    
     <div class="modal-header">
     <button type="button" class="close" data-dismiss="modal">X</button>
     </div>
     
    	 <div class="modal-body"><span> Registered Successfully..!!</span>
    	</div>
     
     <div class="modal-footer">
     <a href="${pageContext.request.contextPath }/index"
     class="btn btn-info" role="button"> Back</a>
     </div>
     
     </div>
</div>

</div>
</div>
<script type="text/javascript">
$(document).ready(function()
		{
     $('#onload').modal('show');	
		});
		

</script>
</body>
</html>