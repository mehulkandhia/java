
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
<h3 align="center">Receipt</h3>
<c:forEach items="${cartitems}" var="cart">
<form action="<c:url value="/confirm"/>" method="post">
<table class="table table-striped table-bordered">
<tr>
<td>Order Id</td>
<td>${paymentDetail.orderid}</td>
<td>Order Date</td>
<td>${paymentDetail.orderDate}</td>
</tr>
<tr>
<td>Customer</td>
<td>${user.username}</td>
<td>Shipping Amount</td>
<td>${paymentDetail.pmode}</td>
</tr>
<tr>
<td>Address</td>
<td colspan="3">${user.address }</td>
</tr>

<tr>
<td>Product Name</td>
<td>Price</td>
<td>Quantity</td>
<td>Total Price</td>
</tr>


<tr>
<td>${cart.productname}</td>
<td>${cart.price}</td>
<td><input type="text" name="quantity" value="${cart.quantity}" required/></td>
<td>${cart.quantity * cart.price}</td>
</tr>

<tr bgcolor="cyan">
	<td colspan="4"><b>Grand Total</b></td>
	<td colspan="2"><b>Rs.${paymentDetail.totalShippingAmount}/-</b></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="Confirm"></td>
</tr>
</table>

</form>
</c:forEach>
 <!-- Footer -->
 	<%@include file="./shared/footer.jsp" %> 
</body>
</html>