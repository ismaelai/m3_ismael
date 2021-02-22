<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class = "container">
		
		<h1>User Directory</h1>
		<hr/>
		
		<p>${NOTIFICATION}</p>
		
		<p>
			<button class = "btn btn-primary" onclick="window.location.href = 'views/user-form.jsp'">Add User</button>
		</p>
	
		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<th>Name</th>
				<th>Email</th>
				<th>Description</th>
				<th>Actions</th>
			</tr>
			
			<c:forEach items="${list}" var="user">
			
				<tr>
					<td>${user.Name}</td>
					<td>${user.Email}</td>
					<td>${user.Description}</td>
					<td> 
						<a href = "${pageContext.request.contextPath}/UserController?action=EDIT&id=${user.id}">Edit</a> 
						| 
						<a href = "${pageContext.request.contextPath}/UserController?action=DELETE&id=${user.id}">Delete</a> 
					</td>
				</tr>
				
			</c:forEach>
			
		</table>
		
	</div>
<jsp:include page="footer.jsp"></jsp:include>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>