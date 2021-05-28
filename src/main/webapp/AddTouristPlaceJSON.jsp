<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Tourist Place</title>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script> -->
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h3>ADD TOURIST PLACE</h3>
<form onSubmit="addPlace()">
<p id="message"></p>
<input type="text" id="touristPlace" required placeholder="Enter Tourist Place" required /><br/><br/>
<input type="number" id="packageAmount" required placeholder="Enter Place Amount" required /><br/><br/>
<button class="btn btn-secondary" type="submit">Add Tourist Place</button>
</form>
<script>

function addPlace(){
	
	event.preventDefault();
	console.log("All Tasks");
	
	let touristPlace = document.querySelector("#touristPlace").value;
	let packageAmount = document.querySelector("#packageAmount").value;
	console.log(touristPlace);
	const urldata="?touristPlace=" + touristPlace+"&packageAmount="+packageAmount;
	let url = "AddTouristPlacesServlet2"+urldata;
	fetch(url).then(res=> res.json()).then(res=>{
		console.log(res);
		let result = res;
		console.log(result);
		if(result.infoMessage != null){
			message=result.infoMessage;
		}
		else{
			message=result.errorMessage;
		}
		document.querySelector("#message").innerHTML=message;
		}
		);			
}
		

</script>


</main>
</body>
</html>



