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
</head>
<body>
<%@include file="./shared/navbar.jsp" %>
<div class="row">
<div class="col-xs-12">
<div class="list-group">
<table class="table table-striped table-bordered">
<thead>
<tr>

<th>Order ID</th>
<th>User Name</th>
<th>Order Date</th>
<th>Shipping Amount</th>
<th>Payment Mode</th>
<th></th>
</tr>
</thead>
<c:forEach items="${orderList}" var="ordering"> 

<tr>

<td>${ordering.orderid}</td>
<td>${user.username}</td>
<td>${ordering.orderDate}</td>
<td>${ordering.totalShippingAmount }</td>
<td>${ordering.pmode}</td>
                        <!-- <button class="btn btn-success">Buy Now</button> -->
</tr>
 </c:forEach> 
</table>
</div>
</div>
</div>
<%@include file="./shared/footer.jsp" %>
</body>
</html>