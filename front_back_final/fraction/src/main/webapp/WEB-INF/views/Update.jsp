
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
 <!-- Footer -->
 	<%@include file="./shared/footer.jsp" %> 
</body>
</html>