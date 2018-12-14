<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>

<!DOCTYPE html>
<html lang="en">

  <head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="${css}/testcss.css">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <title>Online Shopping - {title}</title>
    
  </head>
  <body>

    <!-- Navigation -->
     <%@include file="./shared/navbar.jsp" %>
     <div class="col-lg-2">
    <%@include file="./shared/sidebar.jsp" %>
    </div>
    <!-- Loading Home Page -->
    <c:if test="${userClickHome == true }">
    <!-- Loading Page Content-->
	<%@include file="home.jsp" %>
	</c:if>
	
	<!-- Loading About Us Page-->
	<c:if test="${userClickAbout == true }">
    <!-- Loading Page Content-->
	<%@include file="about.jsp" %>
	</c:if>
	
	<!-- Loading About Us Page-->
	<c:if test="${userClickProduct == true }">
    <!-- Loading Page Content-->
	<%@include file="product.jsp" %>
	</c:if>
	
	<!-- Loading Contact Us -->
	<c:if test="${userClickContact == true }">
    <!-- Loading Page Content -->
	<%@include file="contact.jsp" %>
	</c:if>
	
	<!-- Loading Product List -->
	<c:if test="${userClickAllProducts == true or userClickAllCategoryProducts == true}">
    <!-- Loading Page Content -->
	<%@include file="listproducts.jsp" %>
	</c:if>
	
	<!-- Loading Product List -->
	<c:if test="${userClickShowProduct == true }">
    <!-- Loading Page Content -->
	<%@include file="showproduct.jsp" %>
	</c:if>
	
	<c:if test="${userClickAddCart == true }">
	<%@include file="Cart1.jsp" %>
	</c:if>
        <!-- Footer -->
   <%@include file="./shared/footer.jsp" %>
  </body>

</html>
