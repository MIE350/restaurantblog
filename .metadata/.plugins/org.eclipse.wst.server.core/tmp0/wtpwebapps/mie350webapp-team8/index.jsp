<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>MIE350 Sample Web App</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Date Picker Javascript -->
<!-- https://jqueryui.com/datepicker/ -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<link rel="stylesheet" type="text/css" href="css/mystyle.css">
</head>
<body>

	<%@ include file="navbar.jsp"%>



	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<!-- You can put left sidebar links here if you want to. -->
			</div>
			<div class="col-sm-8 text-left">
				<h1>Welcome to Team 8's (Prototype) Web Application!</h1>
				<p>This web application will be an online community platform that can help students 
					find restaurants in Toronto. Students will be able to:
				<ul>
					<li>create and manage a profile</li>
					<li>look for restaurants by cuisine, rating and price range using a filtered search</li>
					<li>shortlist restaurants they want to visit in the future</li>
					<li>leave and reply to reviews for different restaurants</li>
				</ul>
				This prototype is a work-in-progress, but our team is excited to get going!</p>
				<hr>
				<h3>Testing the Web Application on Internet Browsers</h3>
				<p>The team will aim to make sure the web application will run on the 
					following web browsers:
				<ul>
					<li>Google Chrome</li>
					<li>Mozilla Firefox</li>
					<li>Internet Explorer (or Microsoft Edge)</li>
				</ul>
				We will <b>avoid using the Eclipse built-in web-browser</b>. It's weird to look at.
				</p>
			</div>
			<div class="col-sm-2 sidenav">
				<!-- You can put right sidebar links here if you want to. -->
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>


</body>
</html>
