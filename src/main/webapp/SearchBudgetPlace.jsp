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
	<form action="SearchBudgetPlaceServlet">
<label>Enter Your Budget Amount</label><br/>
<input type="number" id="PackageAmount" name="PackageAmount">
<button class="btn btn-info">Search</button>
</form>
</main>
</body>
</html>