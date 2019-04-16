<%@ include file="../common/header.jsp" %>
	<div class="container">
		<div class="row mt-3">
			<div class="col-12">
				<h1>Course</h1>
				<p class="text-right">
					<a class="btn btn-primary" href="/course/add">add</a>
				</p>
				<table class="table">
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Cost</th>
						<th>Action</th>
					</tr>
					<c:forEach items="${ courses }" var="course">
						<tr>
							<td>${ course.id }</td>
							<td>${ course.name }</td>
							<td><fmt:formatNumber type="currency" value="${ course.cost }"></fmt:formatNumber></td>
							<td><c:url var="viewLink" value="/course/view/${ course.id }">
								</c:url>
								<c:url var="updateLink" value="/course/edit/${ course.id }">
								</c:url> 
								<c:url var="deleteLink" value="/course/delete/${ course.id }">
								</c:url> 
								<%-- <a class="btn btn-primary btn-sm" href="${ viewLink }">view</a>  --%>
								<a class="btn btn-warning btn-sm" href="${ updateLink }">edit</a>
								<a class="btn btn-danger btn-sm" href="${ deleteLink }">delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>