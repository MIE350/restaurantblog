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

    <%
		Member member = (Member) session.getAttribute("currentSessionUser");

		String username = (String) session.getAttribute("username");
		String firstname = (String) session.getAttribute("firstName");
        String lastname = (String) session.getAttribute("lastName");
        String bio = (String) session.getAttribute("bio");
        RestaruantList savedRestaurants = (RestaruantList) session.getAttribute("shortlist");
	%>


    <div class="userProfile">
        <div class="userHeader">
            <div class="row">
                <div class="col-lg-4">
                    <img class="profilePicture" src="img/pfp.png">
                </div>
                <div class="col-lg-4">
                    <h2 name="name"><%=firstname%> <%=lastname%></h2>
                    <h3 name='username'><%=username%></h3>
                </div>
                <div class="col-lg-4">
                    <button href="editProfile.jsp" class="editProfile">Edit Profile</button>
                </div>
            </div>
        </div>
        <div class="bio">
            <p class="biography"><%=bio%></p>
        </div>
        <div class="savedRestaurants">
            <div class="row">
                <c:foreach items="${savedRestaurants}" var="restaurant">
                    <div class="col-lg-4">
                        <img src="<c:out value=" ${restaurant.getImage()}"></c:out>">
                        <button href="restaurantProfile.jsp">
                            <c:out value="${restaurant.getName()}"></c:out>
                        </button>
                    </div>
                </c:foreach>
            </div>
        </div>
    </div>


    <%@ include file="footer.jsp"%>


</body>

</html>