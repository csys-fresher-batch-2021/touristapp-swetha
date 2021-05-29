<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Register Page</h3>


		<form action=RegisterServlet method="get">
			<label for="name">UserName:</label> <input type="text"
				name="username" id="username" autofocus required><br> <label
				for="password">UserPassword:</label> <input type="password"
				name="password" id="password" required><br> <label
				for="number">UserMobileNumber:</label> <input type="number"
				name="mobilenumber" id="mobilenumber" autofocus required><br>
			<button class="btn btn-info">LOGIN</button>
			<button class="btn btn-danger">RESET</button>
		</form>
		<%
		String message = request.getParameter("errorMessage");
		if (message == null) {
			out.print("");
		} else {

			out.print("<font color='red'>" + message + "</font>");
		}
		%>
	</main>


</body>
</html>