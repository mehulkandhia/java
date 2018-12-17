<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<!DOCTYPE html>
<html lang="en">

  <head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${css}/testcss.css">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
</head>
<body>
<%@include file="./shared/navbar.jsp" %>
<div class="container">
<div class="row">
<div class="col-xs-12 col-sm-8">
<h3 align="center">Cart</h3>
<table class="table table-striped table-bordered">
<tr>
<td>Product Name</td>
<td>Price</td>
<td>Quantity</td>
<td>Total Price</td>
<td>Operation</td>
</tr>
<c:forEach items="${cartitems}" var="cart">
<form action="<c:url value="/UpdateCart/${cart.cartid}/update"/>" method="post">
<tr>

<td>${cart.productname}</td>
<td>${cart.price}</td>
<td><input type="text" name="quantity" value="${cart.quantity}" required/></td>
<td>${cart.quantity * cart.price}</td>
<td><input type="submit" value="update" class="btn btn-success"/>
<a class="btn btn-danger" href="<c:url value="/DeleteCart/${cart.cartid}/delete"/>">Delete</a></td>
</tr>
</form>
</c:forEach>
<tr bgcolor="cyan">
	<td colspan="4"><b>Grand Total</b></td>
	<td colspan="2"><b>Rs.${grandTotal}/-</b></td>
</tr>
<tr>
	<td colspan="3"><a href="<c:url value="/listproducts/products"/>" class="btn btn-warning">Continue Shopping</a></td>
	<td colspan="2"><a href="<c:url value="/CheckOut"/>" class="btn btn-success">Checkout</a></td>
</tr>
</table>
</div>
</div>
</div>
</body>
</html>