<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KEN MUTUAL BANK</title>
</head>
<body>
	<div align="center">
	<div style="background: #9400D3">
	<h3 style="color: #FFFFFF">LOGIN</h3>
	</div>
		<form method="POST" action="loginA.jsp">
			<label>Enter Your email</label> <br /> 
			<input type="text" name="username" /> <br /> 
			<label>Enter Password</label> <br /> 
			<input type="password" name="password" /> <br />
			 
			<input type="submit"  value="Login" /><br />

			<% String message = (String)request.getAttribute("message"); %>
			<% if(message != null){
			out.print(message);
		} %>
		</form>
	</div>
</body>
</html>