<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Add Tourist Package</h3>
		<form action=AddTouristPlacesServlet>
			<label for="TouristPlace">TouristPlace:</label> <input type="text"
				id="TouristPlace" name="TouristPlace" required /><br /> <label>PackageAmount:</label>
			<input type="number" id="PackageAmount" name="PackageAmount"/><br />
			<button class="btn btn-primary">Submit</button>
		</form>
	</main>
</body>
</html>