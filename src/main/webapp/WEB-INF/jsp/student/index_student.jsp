<%@ include file="../common/header.jsp" %>
	<div class="container">
		<div class="row mt-3">
			<div class="col-12">
				<h1>Student</h1>
				<p class="text-right">
					<a class="btn btn-success" href="/student/add">add</a>
				</p>
				<table class="table">
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Grade</th>
						<th>Student ID</th>
 						<th>Payment</th>
						<th>Total Cost</th>
						<th>Balance</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
					<c:forEach items="${ students }" var="student">
						<tr>
							<td>${ student.id }</td>
							<td>${ student.name }</td>
							<td>${ student.grade }</td>
							<td>${ student.studentId }</td>
							<td><fmt:formatNumber type="currency" value="${ student.balance.payment }"></fmt:formatNumber></td>
							<td><fmt:formatNumber type="currency" value="${ student.balance.totalCost }"></fmt:formatNumber></td>
							<td><fmt:formatNumber type="currency" value="${ student.balance.tuitionBalance }"></fmt:formatNumber></td> 
							<td>${ student.status }</td>
							<td><c:url var="viewLink" value="/student/view/${ student.id }">
								</c:url>
								<c:url var="updateLink" value="/student/edit/${ student.id }">
								</c:url> 
								<c:url var="deleteLink" value="/student/delete/${ student.id }">
								</c:url> 
								<a class="btn btn-primary btn-sm" href="${ viewLink }">view</a> 
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