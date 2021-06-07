<%@page import="in.swetha.dao.TouristPlaceDAO"%>
<%@page import="in.swetha.model.Tourist"%>
<%@page import="java.util.List"%>
<%@page import="in.swetha.service.TouristPlaceService"%>
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
		<h3>Tourist Package</h3>
		<table class="table table-bordered">
			<caption>*Package include Room</caption>
			<thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Images</th>
					<th scope="col">Places</th>
					<th scope="col">Price(Rs)</th>
			</thead>
			<tbody>
				<%
				TouristPlaceDAO place= new TouristPlaceDAO();
				List<Tourist> detailList = place.getSearchTouristPlace();
						int i = 0;
						for (Tourist touristPlaces : detailList) {
							
							i++;
				%>
				<tr>
					<td><%=i%></td>
					<td>
					<img src="assets/img/<%=touristPlaces.getImageURL()%>" 
					 alt="places" width="100" height="100">
					</td>
					<td><%=touristPlaces.getTouristPlace()%></td>
					<td>Rs.<%=touristPlaces.getAmount()%></td>
					</tr>
				<%
				}
				%> 
</tbody>
</table>
</main>
</body>
</html>