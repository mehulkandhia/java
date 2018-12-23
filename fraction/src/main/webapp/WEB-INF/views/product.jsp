

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
  <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
  </head>
 <body>
<%@include file="./shared/navbar.jsp" %>
<div class="container">
<div class="row">
<div class="col-md-offset-2 col-md-8">
<div class="panel panel-primary">
<div class="panel-heading">
<h4>Product Management</h4>
</div>
<div class="panel-body">

<form:form class="form-horizontal" action="InsertProduct" modelAttribute="prod" enctype="multipart/form-data" method="post">
<div class="form-group">
<label class="control-label col-md-4" for="productname">Product Name</label>
<div class="col-md-8">
<form:input path="productname" placeholder="Product Name" class="form-control"/>
</div>
</div>

<div class="form-group">
<label class="control-label col-md-4" for="brandname">Enter Product Name</label>
<div class="col-md-8">
<form:input path="brandname" placeholder="Brand Name" class="form-control"/>
</div>
</div>

<div class="form-group">
<label class="control-label col-md-4" for="productdesc">Enter Product Description</label>
<div class="col-md-8">
<form:input path="productdesc" placeholder="Product Description" class="form-control" />
</div>
</div>

<div class="form-group">
<label class="control-label col-md-4" for="price">Enter Product Price</label>
<div class="col-md-8">
<form:input path="price" placeholder="Product Price in &$8377" class="form-control"/>
</div>
</div>

<div class="form-group">
<label class="control-label col-md-4" for="stock">Product Stock</label>
<div class="col-md-8">
<form:input path="stock" placeholder="Stock" class="form-control"/>
</div>
</div>

<div class="form-group">
<label class="control-label col-md-4" for="supplierid">Supplier Id</label>
<div class="col-md-8">
<form:input path="supplierid" placeholder="Supplier Id" class="form-control"/>
</div>
</div>

<div class="form-group">
<label class="control-label col-md-4" for="categoryid">Select Category:</label>
<div class="col-md-8">
<form:select path="categoryid" class="form-control">
<form:option value="0" label="---Select List---"/>
<form:options items="${ListCategory }"/>
</form:select>
</div>
</div>

<div class="form-group">
<label class="control-label col-md-4" for="pimage">Supplier Id</label>
<div class="col-md-8">
<form:input type="file" path="pimage" placeholder="Image" class="form-control"/>
</div>
</div>

<div class="form-group">
<div class="col-md-offset-4 col-md-8">
<input type="submit" value="insert" class="btn btn-primary"/>
</div>
</div>
</form:form>

</div>
</div>
</div>
</div>
</div>
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
<form action="<c:url value="/editProduct/${product.productid}"/>" method="post">
<tr>

<td>${product.productname}</td>
<td>${product.categoryid}</td>
<td><input type="text" name="price" value="${product.price}" required/></td>
<td><input type="text" name="stock" value="${product.stock}" required/></td>
<td>
<input type="submit" value="update" class="btn btn-success"/>

<a class="btn btn-danger" href="<c:url value="/deleteProduct/${product.productid}"/>">delete</a>
</td>
</tr>
</form>
</c:forEach>
</table>
</div>
<%@include file="./shared/footer.jsp" %>
</body>
</html>
