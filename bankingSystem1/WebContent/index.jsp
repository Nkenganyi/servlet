<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form method="POST" action="login.jsp">
			<label>Enter Your email</label> <br /> <input type="text"
				name="username" /> <br /> <label>Enter Password</label> <br /> <input
				type="password" name="password" /> <br /> <input type="submit"
				value="Login now!" /><br />

			<% String message = (String)request.getAttribute("message"); %>
			<% if(message != null){
			out.print(message);
		} %>
		</form>
	</div>
</body>
</html>