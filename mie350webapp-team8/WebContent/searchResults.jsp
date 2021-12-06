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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


    <link rel="stylesheet" type="text/css" href="css/mystyle.css">
</head>

<body>


  <%@ include file="navbar.jsp"%>



    <div class="sidebar">
        <h3>Filter and Sort</h3>
        <h4>Filter By:</h4>
        <form method="POST" action="FilterController">
          <h5>Cuisine</h5>
          <input type="radio" name="cuisine" id="any" value="any">
          <label for="any">Any</label><br>
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
          <button name="filter" type="submit" class="updateButton">Filter Restults</button>
        </form>

        <h4>Sort By:</h4>
        <form method="POST" action="SortController">
          <input type="radio" name="sortBy" id="priceHighLow" value="priceHighLow">
          <label for="priceHighLow"><h5>Price: High to Low</h5></label><br>
          <input type="radio" name="sortBy" id="priceLowHigh" value="priceLowHigh">
          <label for="priceLowHigh"><h5>Price: Low to High</h5></label><br>
          <input type="radio" name="sortBy" id="ratingHighLow" value="ratingHighLow">
          <label for="ratingHighLow"><h5>Rating: High to Low</h5></label><br>
          <input type="radio" name="sortBy" id="ratingLowHigh" value="ratingLowHigh">
          <label for="ratingLowHigh"><H5>Rating: Low to High</H5></label><br>

          <button name="sort" type="submit" class="updateButton">Sort Results</button>
        </form>

    </div>

    <div class=content>
        <div class="searchBar">
            <input type="text" placeholder="Search for more restaurants...">
            <button type="submit"><i class="fa fa-search"></i></button>
        </div>
        <h1>Search Results</h1>
        <c:forEach items="${restaurants}" var="restaurant">
          <div class="searchResult">
            <img class="resPic" src="<c:out value="${restaurant.getPicture()}"></c:out>">
            <div class="container">
                <div class="row">
                    <div class="col-xs-5">
                        <h2 class="resName"><b><c:out value="${restaurant.getName()}"></c:out></b></h2>
                        <p class="resRating"><c:out value="${restaurant.getRating()}"></c:out></p>
                        <p class="resPrice"><c:out value="${restaurant.getPrice()}"></c:out></p>
                        <p class="resCuisine"><b><c:out value="${restaurant.getCuisine()}"></c:out></b></p>
                        <p class="resNumReviews"><c:out value="${restaurant.getNumReviews()}"></c:out></p>
                        <button class="resButton"><span>View More</span></button>
                    </div>
                    <div class="col-xs-3">
                    </div>
                    <div class="col-xs-4">
                        <ul class="resHours" style="list-style-type: none;">
                          <c:out value="${restaurant.getHours()}"></c:out>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>
        


<%@ include file="footer.jsp"%>


</body>
</html>
