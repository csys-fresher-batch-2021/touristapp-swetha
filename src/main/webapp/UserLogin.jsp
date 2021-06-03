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
		<h3>User LoginPage</h3>


		<form action=UserLoginServlet method="get">
			<label for="name">UserName:</label> <input type="text"
				name="username" id="username" autofocus><br> <label
				for="name">UserPassword:</label> <input type="password"
				name="userpassword" id="userpassword"><br> <br>
			<button class="btn btn-info">LOGIN</button>
			<button class="btn btn-danger">RESET</button>
			<a href="Register.jsp" class="btn btn-primary">NEW USER</a>

		</form>

		<%
		String message = request.getParameter("message");
		
		if (message == null) {
			out.print("");
		} else {

			out.print("<font color='red'>" + message + "</font>");
		}
		%>
	</main>
</body>
</html>

</body>
</html>