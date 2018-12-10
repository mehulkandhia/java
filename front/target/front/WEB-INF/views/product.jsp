<%@include file="header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form:form action="InsertProduct" modelAttribute="prod" method="post">
<table align="center">
<tr>
<td>Product Name</td>
<td><form:input path="productname"/></td>
</tr>

<tr>
<td>Price</td>
<td><form:input path="price"/></td>
</tr>

<tr>
<td>Stock</td>
<td><form:input path="stock"/></td>
</tr>

<tr>
<td>Category</td>
<td>
<form:select path="categoryid">
<form:option value="0" label="---Select List---"/>
<form:options items="${ListCategory }"/>
</form:select>
</td>
</tr>
<tr>
<td>Supplier</td>
<td><form:input path="supplierid"/></td>
</tr>
<tr>
<td>Product Description</td>
<td><form:input path="productdesc"/></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="insert"/>
</td>
</tr>
</table>
</form:form>

<table align="center" border="1">
<tr>
<td>Product Id</td>
<td>Product Name</td>
<td>Category</td>
<td>Price</td>
<td>Supplier</td>
<td>Operation</td>
</tr>
<c:forEach items="${productList}" var="product">
<tr>
<td>${product.productid}</td>
<td>${product.productname}</td>
<td>${product.categoryid}</td>
<td>${product.price}</td>
<td>${product.supplierid}</td>
<td>
<a class="btn btn-success" href="<c:url value="/editProduct/${product.productid}"/>">Edit</a>
<a class="btn btn-delete" href="<c:url value="/deleteProduct/${product.productid}"/>">delete</a>
</td>
</tr>
</c:forEach>
</table>