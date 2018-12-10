<%@include file="header.jsp" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form:form action="/front/UpdateProduct" modelAttribute="prod" method="POST">
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