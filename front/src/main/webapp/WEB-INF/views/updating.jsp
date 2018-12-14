<%@include file="header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form action="UpsetProduct" modelAttribute="prod" method="POST">
	<table align="center">
		<tr>
			<td>Product Name</td>
			<td><form:input path="productname" placeholder="Product Name" class="form-control"/></td>
		</tr>
		<tr>
		<td>Product Description</td>
		<td><form:input path="productdesc" placeholder="Product Description" class="form-control" /></td>
		</tr>
		<tr>
			<td>Price</td>
			<td><form:input path="price" placeholder="Product Price in &$8377" class="form-control"/></td>
		</tr>

		<tr>
			<td>Stock</td>
			<td><form:input path="stock" placeholder="Stock" class="form-control"/></td>
		</tr>

		<!-- <tr> -->
		<!-- <td>Category</td> -->
		<!-- <td> -->
		<%-- <form:select path="categoryid"> --%>
		<%-- <form:option value="0" label="---Select List---"/> --%>
		<%-- <form:options items="${ListCategory }"/> --%>
		<%-- </form:select> --%>
		<!-- </td> -->
		<!-- </tr> -->
		<tr>
			<td>Supplier</td>
			<td><form:input path="supplierid" placeholder="Supplier Id" class="form-control"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="update" /></td>
		</tr>
	</table>
</form:form>