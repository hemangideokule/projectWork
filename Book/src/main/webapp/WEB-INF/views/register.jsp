<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
	<title>WELCOME</title>
	
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>

<body> 
<jsp:include page="header.jsp"></jsp:include>
<br><br>
h2>Registration Form</h2>
<div class="container">
<
	<div class="col-sm-8">
		<div class="row">
		
		<form:form modelAttribute="user" action="saveRegister" method="post">
			<div class="form-group">
		<label> Name :  </label>
		<form:input path="name" class="form-control" placeholder= "Enter name"/>
		</div>
		
		<div class="form-group">
		<label> Email :  </label><br>
		<form:input path="email" class="form-control" placeholder= "Enter Email"/>
		</div>
		
		<div class="form-group">
		<label> Password :  </label><br>
		<form:input path="password" class="form-control" placeholder= "Enter Password"/>
		</div>
		
		<div class="form-group">
		<label> Address :  </label><br>
		<form:input path="address" class="form-control" placeholder= "Enter Address"/>
		</div>
		
		<div class="form-group">
		<label> Phone No :  </label><br>
		<form:input path="phone" class="form-control" placeholder= "Enter Phone"/>
		</div>
		<br>
		<br>
		<button type="submit" class="btn btn-lg  btn-info">SUBMIT</button>
		<button type="reset" class="btn btn-lg  tn-danger">CANCEL</button>
		
		</form:form>
		
		</div> <!-- row end -->
	
	</div>

</div>
</body>
</html>