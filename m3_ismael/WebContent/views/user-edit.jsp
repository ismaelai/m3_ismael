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
<h1 class="text-center mt-3">Edit and create users</h1>

	<div class="container">

		<div class="row">

			<div class="col-sm-6">

				<form action=" UserController" method="POST">

					<div class="mb-3">
						<label for="input1" class="form-label">firstName</label>
						<input id="input1" type="text" class="form-control" name="nombre" placeholder="James">
					</div>
					<div class="mb-3">
						<label for="input1" class="form-label">lastName</label>
						<input id="input1" type="text" class="form-control" name="apellido" placeholder="Garcia">
					</div>
					<div class="mb-3">
						<label for="input2" class="form-label">Age</label>
						<input id="input2" type="number" class="form-control" name="edad" placeholder="33">
					</div>
					<div class="mb-3">
						<label for="input2" class="form-label">Nif</label>
						<input id="input2" type="text" class="form-control" name="nif" placeholder="33417856L">
					</div>
					<div class="mb-3">
						<label for="input2" class="form-label">email</label>
						<input id="input2" type="text" class="form-control" name="email" placeholder="exampl@gmail.com">
					</div>
					<div class="mb-3">
						<label for="input2" class="form-label">password</label>
						<input id="input2" type="text" class="form-control" name="password" placeholder="red1478">
					</div>

					<button type="submit" class="btn btn-primary">Submit</button>

				</form>
<jsp:include page="footer.jsp"></jsp:include>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>