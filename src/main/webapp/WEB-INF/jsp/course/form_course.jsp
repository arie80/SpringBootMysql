<%@ include file="../common/header.jsp" %>
	<div class="container">
		<h1 class="mt-3">Form Add/Edit Course</h1>
		<div class="row">
			<div class="col-8">
				<form:form action="/course/add" modelAttribute="course" method="post">
					<form:hidden path="id" />
					<div class="form-group">
						<label>Name</label>
						<form:input path="name" cssClass="form-control ${ validated }" placeholder="Name" />
						<form:errors path="name" cssClass="invalid-feedback" />
					</div>
					<div class="form-group">
						<label>Cost</label>
						<form:input path="cost" cssClass="form-control"
							placeholder="Cost" />
					</div>
					<input type="submit" class="btn btn-primary" value="Submit"></input>
				</form:form>
			</div>
		</div>
	</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>