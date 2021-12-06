<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
    <title>6ix Fixes - Restaurant PRofile</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <!-- Date Picker Javascript -->
    <!-- https://jqueryui.com/datepicker/ -->
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <link rel="stylesheet" type="text/css" href="css/mystyle.css">
</head>

<body>

    <%@ include file="navbar.jsp"%>
    <%
		Member member = (Member) session.getAttribute("currentSessionUser");

		String username = (String) session.getAttribute("username");
		String firstname = (String) session.getAttribute("firstname");
	%>


    <div class="restaurantProfile">
        <h1><c:out value="${restaurant.getName()}"></c:out></h1>
        <div class="row">
            <div class="col-lg-5">
                <div class="image-container">
                    <img src=<c:out value="${restaurant.getPicture()}"></c:out>>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="resInfo">
                    <button class="websiteButton" href="<c:out value="${restaurant.getWebsite()}"></c:out>">Visit Website</button>
                    <form method="POST" action=""><button class="saveButton">Save Restaurant</button></form>
                    <p class="resRating"><c:out value="${restaurant.getName()}"></c:out></p>
                    <p class="resPrice"><c:out value="${restaurant.getPrice()}"></c:out></p>
                    <p class="resCuisine"><b><c:out value="${restaurant.getCuisine()}"></c:out></b></p>
                    <p class="phoneNumber"><c:out value="${restaurant.getAddress()}"></c:out></p>
                </div>
            </div>
            <div class="col-lg-3">
                <ul style="list-style-type: none;">
                    <c:out value="${restaurant.getHours()}"></c:out>
                </ul>
            </div>
        </div>


        <div class="reviews">
            <h2>Reviews</h2>
            <c:forEach items="${reviews}" var="review">
            <div class="review">
                <h4><b><c:out value="${review.getRating()}"></c:out></b></h4>
                <h5><u><c:out value="${review.getUserId()}"></c:out></u></h5>
                <h6><c:out value="${review.getPostTime()}"></c:out></h6>
                <p><c:out value="${review.getReviewContent()}"></c:out></p>
                <c:forEach items="${replies}" var="reply">
                    <div class="reply">
                        <h5><b><c:out value="${reply.getUserId}"></c:out></b></h5>
                        <h6><c:out value="${review.getPostTime()}"></c:out></h6>
                        <p><c:out value="${review.getReviewContent()}"></c:out></p>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

    <%@ include file="footer.jsp"%>


</body>

</html>