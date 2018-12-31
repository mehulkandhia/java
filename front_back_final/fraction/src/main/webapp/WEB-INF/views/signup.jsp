<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%-- <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> --%>
<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
	<%-- <link rel="stylesheet" href="${css}/testcss.css"> --%>
	<link rel="stylesheet" href="${css}/testcss.css"/>
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
<title>Sign Up</title>
</head>
<body style="background-color: cyan;">
<%@include file="./shared/navbar.jsp" %>

    <div class="container">
	<div class="row">
        <div class="col-md-4 login-sec">        	
            <div class="wrap">
            	
                <p class="form-title">Sign Up</p>
                <form class="login" name="myForm" action="<c:url value="/addUser"/>" onsubmit="return checkPass()" method="post">
					<div class="form-group">
<label class="text-uppercase" for="username" style="font-weight:bold;">User Name</label>
<input type="text" name="username" placeholder="Enter UserName" class="form-control" required/> 
  </div>
  <div class="form-group">
    <label for="password" class="text-uppercase">Password</label>
    <input type="password" name="password" class="form-control" placeholder="Enter Password" required/>
  </div>
  <div class="form-group">
    <label for="confirmpassword" class="text-uppercase">Confirm Password</label>
    <input type="password" name="confirmpassword" class="form-control" placeholder="Enter Confirm Password" required/>
  </div>
  <div class="form-group">
<label class="text-uppercase" for="customerName">Customer Name</label>
<input type="text" name="customerName" placeholder="Enter Customer Name" class="form-control" required/> 
  </div>
  <div class="form-group">
    <label for="mobileno" class="text-uppercase">Mobile Number</label>
    <input type="text" name="mobileno" class="form-control" placeholder="Enter Mobile Number" required/>
  </div>
  <div class="form-group">
<label class="text-uppercase" for="emailid">Email Id</label>
<input type="email" name="emailid" placeholder="Enter Your Email Id" class="form-control" required/> 
  </div>
  <div class="form-group">
    <label for="address" class="text-uppercase">Address</label>
    <input type="text" name="address" class="form-control" placeholder="Enter Your Address" required/>
  </div>
  <div class="form-group">
    <label for="role" class="text-uppercase">User</label>
    <input type="text" name="role" class="form-control" value="Role_User" readonly/>
  </div>
					<input type="submit" value="Sign Up" class="btn btn-default btn-sm" />
                </form>
                 
            </div>
			</div>
        </div>
        <%@include file="./shared/footer.jsp" %>
    </div>
     
    </body>
    </html>