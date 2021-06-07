<%@page import="in.swetha.dao.TouristPlaceDAO"%>
<%@page import="in.swetha.service.TouristPlaceService"%>
<%@page import="in.swetha.model.Tourist"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<%
String loggedInUsername = (String) session.getAttribute("LOGGED_IN_USER");
%>
<head>
<meta charset="ISO-8859-1">
<title>TouristApp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
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
		<h3>Tourist Package</h3>
		<table class="table table-bordered">
			<caption>*Package include Room</caption>
			<thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Images</th>
					<th scope="col">Places</th>
					<th scope="col">Price(Rs)</th>
					<th scope="col">Status</th>
			</thead>
			<tbody>

				<%
				List<Tourist> tourist = TouristPlaceService.displayTouristPlace();

				int i = 0;
				for (Tourist touristPlaces : tourist) {
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><img src="assets/img/<%=touristPlaces.getImageURL()%>"
						width="100" height="100"></td>
					<td><%=touristPlaces.getTouristPlace()%></td>
					<td>Rs.<%=touristPlaces.getAmount()%></td>
					<td><a
						href="UserLogin.jsp?TouristPlace=<%=touristPlaces.getTouristPlace()%>"
						class="btn btn-info">Book</a> <%
 if (loggedInUsername != null && loggedInUsername.equalsIgnoreCase("ADMIN")) {
 %>
					<td><a
						href="DeleteTouristPlaceServlet?TouristPlace=<%=touristPlaces.getTouristPlace()%>"
						class="btn btn-danger">Delete</a> <%
 }
 %> <%
 }
 %>
				</tr>

			</tbody>
		</table>
		
	</main>
	<%
	if (loggedInUsername != null && loggedInUsername.equalsIgnoreCase("ADMIN")) {
	%>
	<a href="AddTouristPlace.jsp">Add Place</a>
	<%
	}
	%>
</body>
</html>
