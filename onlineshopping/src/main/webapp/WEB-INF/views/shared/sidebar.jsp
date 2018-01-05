<p class="lead">Category</p>
<div class="list-group">
	<c:forEach items="${categories}" var="category">
	
			<a href="${contextRoot}/catprod/${category.id}" class="list-group-item" id="a_${category.name}">${category.name}</a>
	</c:forEach>

</div>

