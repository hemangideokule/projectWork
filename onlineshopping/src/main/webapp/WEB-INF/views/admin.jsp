<div class="container">
	<div class="container col-md-offset-2 col-md-col-md-8">
		<form:form action="/onlineshopping/admin/add/category" method="POST"
			modelAttribute="category" enctype="multipart/form-data" class="form-horizontal">
			<form:hidden path="id" />

			<div class="form-group">
				<label class="col-md-2 control-label" for="name">Category Name</label>
				<div class="col-sm-6">
					<form:input type="text" path="name" id="name" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="name" class="help-inline" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label" for="imageUrl">Upload Image</label>
				<div class="col-sm-6">
					<form:input type="file" path="file" id="imageUrl"
						class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="file" class="help-inline" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label" for="description">Description</label>
				<div class="col-sm-6">
					<form:input type="text" path="description" id="description"
						class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="description" class="help-inline" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Add</button>
				</div>
			</div>
		</form:form>
	</div>
</div>

<div class="container">
	<div class="row">
		<div class="col-md-offset-2 col-md-col-md-8">
			<table id="mytable" class="table table-hover">
				<thead>
					<tr>
						
						<th>Name</th>
						<th>Description</th>
						<th>Image</th>
						<th></th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>
