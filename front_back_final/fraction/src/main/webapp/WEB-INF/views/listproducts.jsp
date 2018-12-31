<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<div class="container">

<div class="row">


<!-- To display the actual products -->
<div class="col-md-9">
<div class="row">
<div class="col-lg-12">

<c:if test="${userClickAllProducts == true}">
<ol class="breadcrumb">
<li><a href="/fraction/home4">Home</a></li>
<li class="active">All Products</li>
</ol>
</c:if>

<%-- <c:if test="${userClickAllCategoryProducts == true}">
<ol class="breadcrumb">
<li><a href="fraction/home4">Home</a></li>
<li class="active">Category</li>
</ol>
</c:if> --%>
</div>
</div>
<div class="row">
<div class="col-xs-12">
<div class="list-group">
<table class="table table-striped table-bordered">
<thead>
<tr>
<th>Product Image</th>
<th>Product Name</th>
<th>Brand</th>
<th>Price</th>
<th>Stock</th>
<th></th>
</tr>
</thead>
<c:forEach items="${productList}" var="product">
<tr>
<td><img src="${images}/${product.productid}.jpg"  style="width:100px;"></td>
<td>${product.productname}</td>
<td>${product.brandname}</td>
<td>${product.price}</td>
<td><c:if test="${product.stock > 0}">${product.stock}</c:if>
<c:if test="${product.stock <= 0}"><font color="green">Out Of Stock!!!</font></c:if>
</td>
<td>
<a href="/fraction/show/${product.productid}/product"><span class="glyphicon glyphicon-eye-open"></span></a>
</td>                        <!-- <button class="btn btn-success">Buy Now</button> -->
</tr>
</c:forEach>
</table>
</div>
</div>
</div>
</div>
</div>
</div>