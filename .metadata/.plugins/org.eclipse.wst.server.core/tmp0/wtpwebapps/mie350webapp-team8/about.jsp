<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>MIE350 Sample Web App - About</title>
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
				<h1>About Team 8</h1>
				This team consists of six Third-Year Industrial Engineering (Indy) students, 
				studying at the <a href="http://www.utoronto.ca">University of Toronto</a>. We are
				developing this web application for our <b>MIE350: Design & Analysis of Information 
				Systems</b> course.<br>
				<hr>
				<h2>Meet the Team Members</h2>
				<br>Read below for a quick message from each of our team members to get to know 
				them a bit better!<br>
				<h3>Gabriel Escobar</h3>
				<p>Hi! My name is Gabriel, and I'm an Industrial Engineering student at UofT who is very 
				interested in music and reading. Since starting University, I've become extremely interested 
				in Computer Science and have engaged in topics such as AI, web development, and video game 
				development. As such, I've gotten the chance to learn Python, Java, SQL, HTML, CSS, JavaScript, 
				and R. I love living in a big city like Toronto and am excited about working with this team to 
				create a web application that helps students find the best restaurants in the area.</p>
				<h3>Santiago Gomez Montenegro</h3>
				<p>I am a third-year student at the University of Toronto pursuing a Bachelor of Applied Science 
				in Industrial Engineering. Software development and artificial intelligence are my top academic 
				interests, and my program has provided me with the flexibility to explore them. This summer I got 
				the opportunity to work at Microsoft where I developed  a code coverage tool to assist Office 
				engineers in evaluating source code changes. I am hoping to bring some of my web development 
				experience from the internship to this project.</p>
				<h3>Alexandra Hon</h3>
				<p>Hey! I'm Alex and like the rest of my group members, I'm an Industrial Engineering student at 
				the University of Toronto. Over the past few years I've been able to develop my skills in Python, 
				Java, SQL and R. I love trying new restaurants and food stalls around Toronto so I'm excited to 
				work with this team to develop a website to help students explore the city through food!</p>
				<h3>Arieana Hussain</h3>
				<p>Hello! My name is Arieana and I am a third year Industrial Engineering student at the University 
				of Toronto. Some of my hobbies include photography, reading, and cooking. I have been working on 
				developing my technical skills by learning Python, Java, SQL and R. I am looking forward to applying 
				my skills to this website and providing university students with the opportunity to discover restaurants 
				around Toronto.</p>
				<h3>Maia Kanceljak</h3>
				<p>Hello hello! I'm Maia and I started out in Materials Science Engineering (MSE) in first year 
				before switching over to Indy. I like reading, doing sudoku puzzles, playing soccer, skiing, 
				and swimming. I worked with Big Data at Geotab this past summer and I got pretty good at Python, 
				SQL and writing documentation, so I'm excited to apply all that to this project!</p>
				<h3>Jose Pablo Siliezar Carrillo</h3>
				<p>Hello there! My name is Jose, and I'm an Industrial Engineering (Indy) student. Some of my 
				hobbies are exercising, listening to music and playing instruments! In the last few years, I've 
				learned Python, Java, SQL and a bit of R. I am looking forward to learning about project 
				management and website design (and the programming languages used in it).</p>
				<hr>
				<h2>Look at our lovely campus!</h2>
				<img src="img/campus.jpg"> <br />
				<p></p>
			</div>
			<div class="col-sm-2 sidenav">
				<!-- You can put right sidebar links here if you want to. -->
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>

</body>
</html>
