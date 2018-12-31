<%@taglib uri="http://www.springframework.org/tags/form" prefix="form1" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>
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
<div class="container">
<div class="row">
<div class="col-md-offset-2 col-md-8">
<div class="panel panel-primary">
<div class="panel-heading">
<h4>Product Management</h4>
</div>
<div class="panel-body">

<form class="form-horizontal" action="<c:url value="/UpdateProduct"/>" method="post">
<div class="form-group">
<label class="control-label col-md-4" for="productid">Product ID</label>
<div class="col-md-8">
<input type="text" name="productid" placeholder="Product ID" value="${product.productid}" class="form-control"/>
</div>
</div>

<div class="form-group">
<label class="control-label col-md-4" for="productname">Product Name</label>
<div class="col-md-8">
<input type="text" name="productname" placeholder="Product Name" value="${product.productname}" class="form-control"/>
</div>
</div>

<div class="form-group">
<label class="control-label col-md-4" for="brandname">Brand Name</label>
<div class="col-md-8">
<input type="text" name="brandname" placeholder="Brand Name" value="${product.brandname}" class="form-control"/>
</div>
</div>

<div class="form-group">
<label class="control-label col-md-4" for="productdesc">Product Description</label>
<div class="col-md-8">
<input type="text" name="productdesc" placeholder="Product Description" value="${product.productdesc}" class="form-control" />
</div>
</div>

<div class="form-group">
<label class="control-label col-md-4" for="price">Product Price</label>
<div class="col-md-8">
<input type="text" name="price" placeholder="Product Price in &$8377" value="${product.price}" class="form-control"/>
</div>
</div>

<div class="form-group">
<label class="control-label col-md-4" for="stock">Product Stock</label>
<div class="col-md-8">
<input type="text" name="stock" placeholder="Stock" value="${product.stock}" class="form-control"/>
</div>
</div>

<div class="form-group">
<label class="control-label col-md-4" for="supplierid">Supplier Id</label>
<div class="col-md-8">
<input type="text" name="supplierid" placeholder="Supplier Id" value="${product.supplierid}" class="form-control"/>
</div>
</div>

  <div class="form-group">
<label class="control-label col-md-4" for="categoryid">Select Category:</label>
<div class="col-md-8">

<select name="categoryid" class="form-control">
<option value="0" label="---Select List---"/>

        <c:forEach items="${ListCategory}" var="category">
        <option>${category}</option>
            </c:forEach>
        
    </select>
<%-- <select name="categoryid" class="form-control">
<option value="0" label="---Select List---"/>
<c:forEach var="item" items="${ListCategory}">
				
                 <option>
                  <c:out value="${item}" />
                </option>  
                
                </c:forEach>
<option value="${ListCategory }"/>

        <c:forEach items="${ListCategory}" var="category">
            <option value="0">${category.categoryname}</option>
        </c:forEach>
    </select> --%>
</div>
</div> 

<div class="form-group">
<div class="col-md-offset-4 col-md-8">
<input type="submit" value="update" class="btn btn-primary"/>
</div>
</div>
</form>

</div>
</div>
</div>
</div>
</div>
</body>
</html>