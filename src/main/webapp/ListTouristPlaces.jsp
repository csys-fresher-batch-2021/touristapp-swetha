<%@page import="in.swetha.service.TouristPlaceService"%>
<%@page import="in.swetha.model.Tourist"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
<meta charset="ISO-8859-1">
<title>TouristApp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Tourist Package</h3>
		<table class="table table-bordered">
			<caption>*Package include Room</caption>
			<thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Places</th>
					<th scope="col">Price(Rs)</th>
					<th scope="col">Option</th>
			</thead>
			<tbody>
				<%
				List<Tourist> tourist = TouristPlaceService.getTouristPlaces();
						int i = 0;
						for (Tourist touristPlaces : tourist) {
							i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=touristPlaces.getTouristPlace()%></td>
					<td>Rs.<%=touristPlaces.getAmount()%></td>
					<td><a href="DeleteTouristPlaceServlet?TouristPlace=<%=touristPlaces.getTouristPlace()%>" 
					class="btn btn-danger">Delete</a>
				</tr>
				<%
				}
				%> 
			</tbody>
		</table>
			</main>
</body><a href="addTouristPlace.jsp">Add Place</a>
</html>
