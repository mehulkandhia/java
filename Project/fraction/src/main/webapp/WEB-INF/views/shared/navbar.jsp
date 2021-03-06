<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Navigation -->
     <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="/fraction/home4">Online Shopping</a>
       <!-- <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button> -->
        <div class="navbar-collapse collapse" id="navbarResponsive" style="">
          
              <!-- <a  href="">Home
                <span class="sr-only">(current)</span>
              </a>
            &nbsp;&nbsp;&nbsp;
              
           &nbsp;&nbsp;&nbsp; --> 
              
            
            
            <c:if test="${!sessionScope.loggedIn}">
            <a class="navbar-brand" href="/fraction/about">About</a>
              &nbsp;
              <a class="navbar-brand" href="/fraction/contact">Contact</a>
              <div class="text-right">
              <a class="nav-link" href="/fraction/AddUser1" style="font-size:17px;"><b>Sign Up</b></a>&nbsp;&nbsp;&nbsp;
               <a class="nav-link" href="/fraction/login1" style="font-size:17px;"><b>Sign In</b></a>
               </div>
            <!-- <div class="text-right">
            <a class="nav-link" href="/fraction/AddUser1" style="font-size:17px;">Sign Up</a>
              &nbsp;&nbsp;&nbsp;
               <a class="nav-link" href="/fraction/login1" style="font-size:17px;">Sign In</a>
               </div>
              &nbsp;&nbsp;&nbsp;
              <a class="nav-link" href="/fraction/about">About</a>
              &nbsp;&nbsp;&nbsp;
              <a class="nav-link" href="/fraction/contact">Contact</a> -->
              </c:if> 
              
			  <c:if test="${sessionScope.loggedIn}">
			  <c:if test="${sessionScope.role=='Role_Admin' }"> 
			  <a class="navbar-brand" href="/fraction/category1">Manage Category</a>
			  <a class="navbar-brand" href="/fraction/product4">Manage Products</a>
			   </c:if> 

			  <c:if test="${sessionScope.role=='Role_User' }"> 
			  <a class="nav navbar-nav navbar-brand" href="/fraction/listproducts/products">Products</a>
			  <a class="nav navbar-nav navbar-brand" href="/fraction/cart">Product Cart</a>
			  <a class="nav navbar-nav navbar-brand" href="/fraction/orderdetail">Your Orders</a>
			  </c:if>
			  </c:if> 
        </div>
        <div class="nav navbar-nav navbar-right">
        <c:if test="${sessionScope.loggedIn}">
        <div id="userdetail">
        <font color="white">
        Welcome ${sessionScope.username}
    </font>
        <a href="perform_logout">LOGOUT</a>
        </div>
        </c:if> 
        </div>
        </div>
    </nav>
    <!-- Navigation -->
</body>
</html>