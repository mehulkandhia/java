<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<html>
<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="${css}/testcss.css">
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  </head>
 <body>
<%@include file="./shared/navbar.jsp" %>
<div class="col-md-offset-3 text-center">
<table border="1">
<tr>
<td>Product Name</td>
<td>Category</td>
<td>Price</td>
<td>Supplier</td>
<td>Operation</td>
</tr>
<c:forEach items="${productList}" var="product">
<tr>
<td>${product.productname}</td>
<td>${product.categoryid}</td>
<td>${product.price}</td>
<td>${product.stock}</td>
<td>
<a class="btn btn-danger" href="<c:url value="/Update/${product.productid}"/>">Update</a>
<a class="btn btn-danger" href="<c:url value="/deleteProduct/${product.productid}"/>">Delete</a>
</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>