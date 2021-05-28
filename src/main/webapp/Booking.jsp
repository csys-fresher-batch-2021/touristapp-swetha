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
<form action=BookingServlet><label for="startDate"><strong>Journey From date</strong></label><br>
		<input type="date" name="startDate" placeholder="YYYY-MM-DD" required>
		
		<br>
		<label for="endDate"><strong>Journey To date</strong></label><br>
		<input type="date"  name="endDate" placeholder="YYYY-MM-DD" required>
		<br>
		<br>
		<button class="btn btn-primary">Submit</button>
		<button class="btn btn-danger">Reset</button>
	
		</form>
		<%
          String message=request.getParameter("Booking Status");
			if(message==null)
			{
				out.print("");
			}
			else
			{
				
				out.print("<font color='green'>"+message+"</font>");
			}
         %>
         <%
          String errormessage=request.getParameter("errorMessage");
			if(errormessage==null)
			{
				out.print("");
			}
			else
			{
				
				out.print("<font color='red'>"+errormessage+"</font>");
			}
         %>
	
</main>
</body>
</html>