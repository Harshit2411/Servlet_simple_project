<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<form action="insertCustomer" method="get">
	<label>ID:</label><br> <input type="number"
		placeholder="enter customer id" name="id"><br> <label>NAME:</label><br>
	<input type="text" placeholder="enter customer name" name="name"><br>
	<label>EMAIL:</label><br> <input type="email"
		placeholder="enter customer email" name="email"><br> <label>Phone:</label><br>
	<input type="tel" placeholder="enter customer phone" name="phone"><br>
	<label>Password:</label><br> <input type="password"
		placeholder="enter customer password" name="password"><br>
	<input type="submit" value="register">
</form>
</body>
</html>