<%@page import="in.swetha.model.Tourist"%>
<%@page import="java.util.List"%>
<%@page import="in.swetha.service.TouristPlaceService"%>
<%@page import="in.swetha.service.TouristPlaceService2"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
					<th scope="col">Status</th>
			</thead>
			<tbody>
				<%
				List<Tourist> detailList = TouristPlaceService.displaySearchList();
						int i = 0;
						for (Tourist touristPlaces : detailList) {
							i++;
				%>
				<tr>
					<td><%=i%></td>
					<td>
					<img src="assets/img/<%=touristPlaces.getImageURL()%>" width="100" height="100">
					
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