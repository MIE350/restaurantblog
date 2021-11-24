<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>Toronto Food Blog</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<link rel="stylesheet" type="text/css" href="css/mystyle.css">
</head>
<body>

	<%@ include file="navbar.jsp"%>



	<div class="sidebar">
        <h3>Filter and Sort</h3>
        <h4>Sort By:</h4>
        <input type="radio" name="sortBy" id="recommended" value="recommended">
        <label for="recommended">Recommended</label><br>
        <input type="radio" name="sortBy" id="highestRating" value="highestRating">
        <label for="highestRating">Highest Rating</label><br>
        <input type="radio" name="sortBy" id="mostReviewed" value="mostReviewed">
        <label for="mostReviewed">Most Reviewed</label><br>

        <h4>Filter By:</h4>
        <h5>Rating</h5>
        <input type="radio" name="rating" id="onestar" value="onestar">
        <label for="onestar">&starf;&star;&star;&star;&star;</label><br>
        <input type="radio" name="rating" id="twostars" value="twostars">
        <label for="twostars">&starf;&starf;&star;&star;&star;</label><br>
        <input type="radio" name="rating" id="threestars" value="threestars">
        <label for="threestars">&starf;&starf;&starf;&star;&star;</label><br>
        <input type="radio" name="rating" id="fourstars" value="fourstars">
        <label for="fourstars">&starf;&starf;&starf;&starf;&star;</label><br>
        <input type="radio" name="rating" id="fivestars" value="fivestars">
        <label for="fivestars">&starf;&starf;&starf;&starf;&starf;</label><br>

        <h5>Price</h5>
        <input type="radio" name="price" id="$" value="$">
        <label for="$">$</label><br>
        <input type="radio" name="price" id="$$" value="$$">
        <label for="$$">$$</label><br>
        <input type="radio" name="price" id="$$$" value="$$$">
        <label for="$$$">$$$</label><br>
        <input type="radio" name="price" id="$$$$" value="$$$$">
        <label for="$$$$">$$$$</label><br>

        <h5>Cuisine</h5>
        <input type="radio" name="cuisine" id="pub" value="pub">
        <label for="pub">Pub</label><br>
        <input type="radio" name="cuisine" id="italian" value="italian">
        <label for="italian">Italian</label><br>
        <input type="radio" name="cuisine" id="chinese" value="chinese">
        <label for="chinese">Chinese</label><br>
        <input type="radio" name="cuisine" id="japanese" value="japanese">
        <label for="japanese">Japanese</label><br>
        <input type="radio" name="cuisine" id="indian" value="indian">
        <label for="indian">Indian</label><br>

     </div>

     <div class=content>
        <div class="searchBar">
            <input type="text" placeholder="Search for more restaurants...">
            <button type="submit"><i class="fa fa-search"></i></button>
         </div>
         <h1>Search Results</h1>

         <div class="searchResult">
             <img class="resPic" src="img/kasamoto.jpeg">
             <div class="container">
                <div class="row">
                  <div class="col-xs-5">
                    <h2 class="resName"><b>Kasamoto</b></h2>
                    <p class="resRating">&starf;&starf;&starf;&starf;&star;</p>
                    <p class="resPrice">$$$$</p>
                    <p class="resCuisine"><b>Japanese</b></p>
                    <p class="resNumReviews">127 Reviews</p>
                    <button class="resButton"><span>View More</span></button>
                  </div>
                  <div class="col-xs-3">
                  </div>
                  <div class="col-xs-4">
                    <ul class="resHours" style="list-style-type: none;">
                        <li><i>Hours:</i></li>
                        <li>Monday: 9:00-22:00</li>  
                        <li>Tuesday: 9:00-22:00</li>
                        <li>Wednesday: 9:00-22:00</li>
                        <li>Thursday: 9:00-22:00</li>  
                        <li>Friday: 9:00-22:00</li>
                        <li>Saturday: 9:00-22:00</li>
                        <li>Sunday: 9:00-18:00</li>
                    </ul>
                  </div>
                </div>
              </div>
         </div>

         <div class="searchResult">
            <img class="resPic" src="img/nervosa.jpeg">
            <div class="container">
               <div class="row">
                 <div class="col-xs-5">
                   <h2 class="resName"><b>Trattoria Nervosa</b></h2>
                   <p class="resRating">&starf;&starf;&starf;&starf;&starf;</p>
                   <p class="resPrice">$$$</p>
                   <p class="resCuisine"><b>Italian</b></p>
                   <p class="resNumReviews">250 Reviews</p>
                   <button class="resButton"><span>View More</span></button>
                 </div>
                 <div class="col-xs-3">
                 </div>
                 <div class="col-xs-4">
                   <ul class="resHours" style="list-style-type: none;">
                       <li><i>Hours:</i></li>
                       <li>Monday: 9:00-22:00</li>  
                       <li>Tuesday: 9:00-22:00</li>
                       <li>Wednesday: 9:00-22:00</li>
                       <li>Thursday: 9:00-22:00</li>  
                       <li>Friday: 9:00-22:00</li>
                       <li>Saturday: 9:00-22:00</li>
                       <li>Sunday: 9:00-18:00</li>
                   </ul>
                 </div>
               </div>
             </div>
        </div>

        <div class="searchResult">
            <img class="resPic" src="img/hemingways.jpeg">
            <div class="container">
               <div class="row">
                 <div class="col-xs-5">
                   <h2 class="resName"><b>Hemingway's</b></h2>
                   <p class="resRating">&starf;&starf;&starf;&starf;&star;</p>
                   <p class="resPrice">$$$</p>
                   <p class="resCuisine"><b>New Zealand</b></p>
                   <p class="resNumReviews">327 Reviews</p>
                   <button class="resButton"><span>View More</span></button>
                 </div>
                 <div class="col-xs-3">
                 </div>
                 <div class="col-xs-4">
                   <ul class="resHours" style="list-style-type: none;">
                       <li><i>Hours:</i></li>
                       <li>Monday: 9:00-22:00</li>  
                       <li>Tuesday: 9:00-22:00</li>
                       <li>Wednesday: 9:00-22:00</li>
                       <li>Thursday: 9:00-22:00</li>  
                       <li>Friday: 9:00-22:00</li>
                       <li>Saturday: 9:00-22:00</li>
                       <li>Sunday: 9:00-18:00</li>
                   </ul>
                 </div>
               </div>
             </div>
     </div>


	<%@ include file="footer.jsp"%>


</body>
</html>
