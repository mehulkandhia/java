<%@include file="header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3 align="center">Update Category Page</h3>

<form action="<c:url value="/updateCategory"/>" method="post">

<table align="center">
	<tr>
		<td>Category ID </td>
		<td><input type="text" id="categoryid" name="categoryid" value="${Category.categoryid}"/></td>
	</tr>
	<tr>
		<td>Category Name </td>
		<td><input type="text" id="categoryName" name="categoryName" value="${Category.categoryname}"/></td>
	</tr>
	<tr>
		<td>Category Desc </td>
		<td><input type="text" id="categoryDesc" name="categoryDesc" value="${Category.categorydesc}"/></td>
	</tr>
	<tr>
		<center>
		<td colspan="2"><input type="submit" value="Update Category"/></td>
		</center>
	</tr>
</table>
</form>