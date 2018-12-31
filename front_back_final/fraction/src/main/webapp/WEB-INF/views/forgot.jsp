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
	<script type="text/javascript">
	function checkPass(){
	  
	  var guess = document.myForm.password.value;
	  var secret = document.myForm.confirmpassword.value;
	  if (guess == secret){
		  
		  document.getElementById("password").innerHTML = "";
		  return true;
	  } else {
	    
	    alert("Password is incorrect");
	    return false;
	  }
	}
	</script>
<title>Login</title>
</head>
<body>
<%@include file="./shared/navbar.jsp" %>
<section class="login-block">
    <div class="container">
	<div class="row">
		<div class="col-md-4 login-sec">
		    <h2 class="text-center">Forgot Password</h2>
<form class="login-form" action="<c:url value="/updateUser"/>" onsubmit="return checkPass()" enctype="application/x-www-form-urlencoded" method="post">
<div class="form-group">
<label class="text-uppercase" for="username">User Name</label>
<input type="text" name="username" placeholder="Enter UserName" class="form-control"/> 
  </div>
  <div class="form-group">
<label class="text-uppercase" for="password">Password</label>
<input type="password" name="password" placeholder="Enter Password" class="form-control"/> 
  </div>
  <div class="form-group">
    <label for="confirmpassword" class="text-uppercase">Confirm Password</label>
    <input type="password" name="confirmpassword" class="form-control" placeholder="Enter Password"/>
  </div>
  <input type="submit" class="btn btn-login float-right" value="Submit"/>
  </form>
  </div>
  </div>
  </div>
  </section>
</body>
</html>