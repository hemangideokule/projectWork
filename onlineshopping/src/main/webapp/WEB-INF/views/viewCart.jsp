<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<spring:url value="/resources/images/" var="images" />

<div class="container">
	<div class="row">

		<!--  Display the actual products -->
		<div class="col-md-12">
			<div class="row">
				<div class="col-lg-12">

					<c:if test="${userClickedViewCart == true}">
						<!--  Adding breadcrumb component -->
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">View Cart</li>
						</ol>
					</c:if>
					<!--  End of C:if  -->
				</div>
				<!--  End of col-lg-12 -->
			</div>
			<!--  End of row -->
		</div>
		<!--  end of col-md-12 -->
	</div>
	<div class="row">
		<div class="col-xs-8">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">
						<div class="row">
							<div class="col-xs-6">
								<h5>
									<span class="glyphicon glyphicon-shopping-cart"></span>
									Shopping Cart
								</h5>
							</div>
							<div class="col-xs-6">
								<a class="btn btn-primary btn-sm btn-block"
									href="${contextRoot}/"> <span
									class="glyphicon glyphicon-share-alt"></span> Continue shopping
								</a>
							</div>
						</div>
					</div>
				</div>


				<c:choose>
					<c:when test="${not empty cartitemlist}">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Name</th>
									<th>Quantity</th>
									<th>Amount</th>
									<th>Remove</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${cartitemlist}" var="cartitems">
									<tr>
										<td>${cartitems.product.name}</td>
										<td>${cartitems.quantity}</td>
										<td>&#8377;&nbsp;${cartitems.totalPrice}</td>

										<td><a
											href="${contextRoot}/cart/user/delete/${cartitems.id}"
											class="btn btn-primary" role=button>REMOVE PRODUCT</a></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
						<br><br>
						<div class="col-xs-9">
							<h4 class="text-right">
								Total <strong>&#8377;&nbsp;${cartitems.grandTotal}</strong>
							</h4>
						</div>
						<div>
							<a href="${contextRoot}/checkout" class="btn btn-success "
								role=button>CHECKOUT</a>
						</div>
					</c:when>
					<c:when test="${empty cartitemlist}">
						<center>
							<h2>No Product Added Yet in the Cart</h2>
						</center>
					</c:when>
				</c:choose>
			</div>
		</div>
	</div>
</div>