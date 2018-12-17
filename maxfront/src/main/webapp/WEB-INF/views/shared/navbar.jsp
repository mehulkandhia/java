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
        <a class="navbar-brand" href="/maxfront/home1">Online Shopping</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="navbar-collapse collapse" id="navbarResponsive" style="">
          
              <!-- <a  href="">Home
                <span class="sr-only">(current)</span>
              </a> -->
            <!-- &nbsp;&nbsp;&nbsp; -->
              
           &nbsp;&nbsp;&nbsp;
              <a class="nav-link" href="/maxfront/listproducts/products">View Products</a>
            &nbsp;&nbsp;&nbsp;
            
            <%-- <c:if test="${!sessionScope.loggedIn}">
 --%>              <a class="nav-link" href="/maxfront/login">Sign In</a>
              &nbsp;&nbsp;&nbsp;
              <a class="nav-link" href="/maxfront/about">About</a>
              &nbsp;&nbsp;&nbsp;
              <a class="nav-link" href="/maxfront/contact">Contact</a>
              <%-- </c:if> --%>
              
			  <%-- <c:if test="${!sessionScope.loggedIn}">
			  <c:if test="${sessionScope.role=='Role_Admin' }"> --%>
			  <a class="nav-link" href="/maxfront/category1">Manage Category</a>
			  <a class="nav-link" href="/maxfront/product4">Manage Products</a>
			  <%-- </c:if> --%>

			  <%-- <c:if test="${sessionScope.role=='Role_User' }"> --%>
			  <a class="nav-link" href="/maxfront/listproducts/products">Products</a>
			  <a class="nav-link" href="/maxfront/cart">Product Cart</a>
			  <%-- </c:if>
			  </c:if> --%>
        </div>
        <div class="nav navbar-nav navbar-right">
        <%-- <c:if test="${sessionScope.loggedIn}">
        <div id="userdetail">
        <font color="white">
        Welcome ${sessionScope.username}
    </font>
        <a href="perform_logout">LOGOUT</a>
        </div>
        </c:if> --%>
        </div>
      </div>
    </nav>
    <!-- Navigation -->
</body>
</html>