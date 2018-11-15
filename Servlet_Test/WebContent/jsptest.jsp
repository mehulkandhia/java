<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h1>Registration Form</h1></center>
<center>
<form id="form1" method="post" action="ServletTest">
<fieldset>
<label>First Name</label>
&nbsp;&nbsp;<input type="text" name="fname" required><br><br>
<label>Last Name</label>
&nbsp;&nbsp;<input type="text" name="lname" required><br><br>
<label>Password</label>
&nbsp;&nbsp;<input type="password" name="pass" required><br><br>
<label>Mobile Number</label>
&nbsp;&nbsp;<input type="tel" name="mobno" required><br><br>
<label>Email Id</label>
&nbsp;&nbsp;<input type="email" name="email" required><br><br>
<input type="submit" value="submit">
</fieldset>
</form>
</center>
</body>
</html>