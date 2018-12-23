
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
<table class="table table-striped table-bordered">
<tr>
<td>Product Name</td>
<td>Price</td>
<td>Quantity</td>
<td>Total Price</td>
</tr>
<c:forEach items="${cartitems}" var="cart">

<tr>
<td>${cart.productname}</td>
<td>${cart.price}</td>
<td><input type="text" name="quantity" value="${cart.quantity}" required/></td>
<td>${cart.quantity * cart.price}</td>
</tr>

</c:forEach>
<tr bgcolor="cyan">
	<td colspan="4"><b>Grand Total</b></td>
	<td colspan="2"><b>Rs.${grandTotal}/-</b></td>
</tr>
</table>
<c:forEach items="${productList}" var="product">
<form action="<c:url value="/payment/${product.productid}/addition"/>" method="post">
<table class="table table-striped table-bordered">

<tr bgcolor="cyan">
<td>Payment detail</td>
</tr>
<tr bgcolor="orange">
<td>Payment Type</td>
<td><input type="radio" name="pmode" value="COD"/>Cash on Delivery
<input type="radio" name="pmode" value="CC"/>Credit Card
</td>
</tr>
<tr bgcolor="orange">
<td>Credit Card</td>
<td>
<input type="text" name="creditcard">
</td>
</tr>
<tr bgcolor="orange">
<td>CVV<input type="text" name="cvv"/></td>
<td>Valid Upto<input type="text" name="valid"/></td>
</tr>
<tr bgcolor="cyan">
<td><input type="submit" value="pay"></td>
</tr>
</table>
</form>
</c:forEach>
 <!-- Footer -->
 	<%@include file="./shared/footer.jsp" %> 
</body>
</html>