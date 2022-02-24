<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Revenueeeeeee Tracker</title>
</head>
<body>
<form action="RegisterServlet" method="post">
Name: <input type="text" name="employee_name">
Phone: <input type="text" name="employee_phone">
Pay: <input type="text" name="employee_pay">
Status: <select name="salary_status">
<option>Paid</option>
<option>Still Pending</option>
</select>
<input type="submit" value="Update Employee" />



</form>
</body>
</html>