<%@ include file="../common/header.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-8">
				<h1 class="mt-3">Student</h1>
				<table class="table table-striped">
					<tr>
						<td>Name</td>
						<td>${ student.name }</td>
					</tr>
					<tr>
						<td>Grade</td>
						<td>${ student.grade }</td>
					</tr>
					<tr>
						<td>Status</td>
						<td>${ student.status }</td>
					</tr>
					<tr>
						<td>Student ID</td>
						<td>${ student.studentId }</td>
					</tr>
					<tr>
						<td>Course</td>
						<td>
							<ul class="list-unstyled">
							<c:forEach items="${ student.courses }" var="course">
								<li>- ${ course.name }</li>
							</c:forEach>
							</ul>
							</td>
							
					</tr>
					<tr>
						<td>Payment</td>
						<td><fmt:formatNumber type="currency" value="${ payment}"></fmt:formatNumber></td>
					</tr>
					<tr>
						<td>Total Cost</td>
						<td><fmt:formatNumber type="currency" value="${ totalCost }"></fmt:formatNumber></td>
					</tr>
					<tr>
						<td><b>Balance</b></td>
						<td><b><fmt:formatNumber type="currency" value="${ balance }"></fmt:formatNumber></b></td>
					</tr>

				</table>
			</div>
		</div>
	</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>