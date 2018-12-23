<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<h3 align="center">Category Page</h3>
<form action="<c:url value="/addCategory"/>" method="post">

<table align="center">
	<tr>
		<td>Category Name </td>
		<td><input type="text" id="categoryName" name="categoryName"/></td>
	</tr>
	<tr>
		<td>Category Desc </td>
		<td><input type="text" id="categoryDesc" name="categoryDesc"/></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Add Category"/></td>
	</tr>
</table>
</form>

<table align="center" border="1">
	<tr>
		<td>Category ID</td>
		<td>Category Name</td>
		<td>Category Desc</td>
		<td>Operations</td>
	</tr>
	<c:forEach items="${ListCategories}" var="Category">
	<tr>
		<td>${Category.categoryid}</td>
		<td>${Category.categoryname}</td>
		<td>${Category.categorydesc}</td>
		<td>
			<a href="<c:url value="/editCategory/${Category.categoryid}"/>">Edit</a>
			<a href="<c:url value="/deleteCategory/${Category.categoryid}"/>">Delete</a>
		</td>
	</tr>
	</c:forEach>
</table>
 <!-- Footer -->
 	<%@include file="./shared/footer.jsp" %> 
</body>
</html>