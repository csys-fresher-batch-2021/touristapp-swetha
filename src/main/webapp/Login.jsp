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
		<h3>Login Page</h3>
		
		
		<form action=AdminLoginServlet method="get">
			<label for="name">AdminName:</label> <input type="text"
				name="adminname" id="adminname" autofocus ><br/>
			<label for="name">AdminPassword:</label> <input type="password"
				name="adminpassword" id="adminpassword" ><br/>
				<br/> 
			<button class="btn btn-info">LOGIN</button>
			<button class="btn btn-danger">RESET</button>
	
	
	</form>
	
	<%
          String message=request.getParameter("message");
			if(message==null)
			{
				out.print("");
			}
			else
			{
				
				out.print("<font color='red'>"+message+"</font>");
			}
         %>
		</main>
		<br/>
		<li>Admin Name Password Hard Coded</li>
		<li>Admin Name:admin</li>
		<li>Admin Password:admin@123</li>
</body>
</html>