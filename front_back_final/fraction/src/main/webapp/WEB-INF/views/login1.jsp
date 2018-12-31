<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%-- <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> --%>
<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <link rel="stylesheet" href="${css}/testcss.css"> 
	<%-- <link rel="stylesheet" href="${css}/1.css"/> --%>
<title>Login</title>
</head>
<body>
<%@include file="./shared/navbar.jsp" %>
<section class="login-block">
    <div class="container">
	<div class="row">
		<div class="col-md-4 login-sec">
		    <h2 class="text-center">Login Now</h2>
		    <form class="login-form" action="perform_login" enctype="application/x-www-form-urlencoded" method="post">
  <div class="form-group">
<label class="text-uppercase" for="username">User Name</label>
<input type="text" name="username" placeholder="Enter UserName" class="form-control"/> 
  </div>
  <div class="form-group">
    <label for="password" class="text-uppercase">Password</label>
    <input type="password" name="password" class="form-control" placeholder="Enter Password"/>
  </div>
  <a href="/fraction/forgot" class="btn btn-success"> Forgot Password</a>
    
    <!-- <label class="form-check-label">
      <input type="checkbox" class="form-check-input">
      <small>Remember Me</small>
    </label> -->
    <input type="submit" class="btn btn-login float-right" value="Submit"/>  
</form>

		</div>
		<div class="col-md-8 banner-sec">
                <div id="myCarousel" class="carousel slide" data-ride="carousel">
	<!-- <hr class="bg-dark mb-4 w-25">
    <div class="row"> -->
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <div class="carousel-inner">
      <div class="item active">
        <center><img src="https://static.pexels.com/photos/33972/pexels-photo.jpg"  style="width:550px;height:400px;"></center>
      </div>

      <div class="item">
        <center><img src="https://images.pexels.com/photos/7097/people-coffee-tea-meeting.jpg"  style="width:550px;height:400px;"></center>
      </div>
    
      <div class="item">
        <center><img src="https://images.pexels.com/photos/872957/pexels-photo-872957.jpeg"  style="width:550px;height:400px;"></center>
      </div>
      
     </div>

	<!-- Left and right controls -->
    <!-- <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a> -->
</div>
		</div>
	</div>
</div>
</section>
 <!-- Footer -->
 	<%@include file="./shared/footer.jsp" %> 
</body>
</html>