<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Registration Form</h1><br>
<form id="form1" action="Register1" method="post">
<table border="1" align="center">
<tr>
<td>First Name:</td>
<td><input type="text" name="fname"></td>
</tr>
<tr>
<td>Last Name:</td>
<td><input type="text" name="lname"></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="pass"></td>
</tr>
<tr>
<td>Confirm Password</td>
<td><input type="password" name="confpass"></td>
</tr>
<tr>
<td>Mobile Number</td>
<td><input type="tel" name="mobno"></td>
</tr>
<tr>
<td>Emailid</td>
<td><input type="email" name="email"></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="submit"></td>
</tr>
</table>
</form>
</body>
</html>