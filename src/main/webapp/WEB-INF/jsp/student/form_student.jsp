<%@ include file="../common/header.jsp" %>
	<div class="container">
		<h1 class="mt-3">Form Add/Edit Student</h1>
		<div class="row">
			<div class="col-8">
				<form:form action="/student/add" modelAttribute="student" method="post">
					<form:hidden path="id" />
					<div class="form-group">
						<label>Name</label>
						<form:input path="name" cssClass="form-control ${ validated }" placeholder="Name" />
						<form:errors path="name" cssClass="invalid-feedback" />
					</div>
					<div class="form-group">
						<label>Grade</label>
						<form:select path="grade" cssClass="form-control">
							<form:options items="${ grades }"></form:options>
						</form:select>
					</div>
					<div class="form-group">
						<label>Payment</label>
						<form:input path="payment" cssClass="form-control"
							placeholder="Payment" />
					</div>
					<div class="form-check">
						<form:checkbox path="status" cssClass="form-check-input" />
						<label>Status</label>
					</div>
					<div class="form-group">
 						<form:select path="courses" cssClass="form-control" multiple="true">
							<c:forEach items="${ courses }" var="course">
							<form:option value="${ course.id }" selected="${ course.selected == 'selected' ? true : ''}" label="${ course.name }"></form:option>
							</c:forEach>
						</form:select>
					</div>
					<input type="submit" class="btn btn-primary" value="Submit"></input>
				</form:form>
			</div>
		</div>
	</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>