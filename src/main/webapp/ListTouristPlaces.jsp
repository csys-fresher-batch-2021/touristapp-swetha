<%@page import="in.swetha.service.ListOfTouristPlaces"%>
<%@page import="in.swetha.model.Tourist"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TouristApp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Tourist Package</h3>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>S.No</td>
					<td>Places</td>
					<td>Price(Rs)</td>
			</thead>
			<tbody>
				<%
				List<Tourist> tourist = ListOfTouristPlaces.getTouristPlaces();
				int i = 0;
				for (Tourist touristPlaces : tourist) {
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=touristPlaces.touristPlace%></td>
					<td>Rs.<%=touristPlaces.Amount%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</main>
</body>
</html>
