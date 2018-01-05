<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${contextRoot}/home"><img
				src="${images}/logo.jpg" alt="cakes" height="50" width="50"
				class="img-circle"></a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li id="Products"><a href="${contextRoot}/products">Products</a>
				</li>
				<li id="Contact"><a href="#">ContactUs</a></li>
				
				</li>
				<!-- <li id="Admin">
                    <a href="${contextRoot}/myadmin">Admin</a>
                    </li> -->
				<security:authorize access="hasAuthority('Admin')">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">ADMIN <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/admin">Category</a></li>
							<li><a
								href="${pageContext.request.contextPath}/admin/admin/Products">Product</a></li>

						</ul></li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<li id="logout"><a href="${contextRoot}/logout">Logout</a></li>
				</security:authorize>
				<security:authorize access="isAnonymous()">
					<li id="login"><a href="${contextRoot}/register">SignUp</a></li>
					<li id="Login"><a href="${contextRoot}/login">Login</a>
				</security:authorize>

				<security:authorize access="hasAuthority('User')">
					<li id="login"><a href="${contextRoot}/cart/user/viewcart">View
							Cart</a></li>
				</security:authorize>


			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>
