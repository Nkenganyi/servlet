<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KEN MUTUAL BANK</title>
</head>
<body>
<div align = "center">
	<div>
		<h3>PRINT STATEMENT</h3>
	</div>
	<form method = "POST" action = "tion.jsp">
	
		<label>Account Number</label><br/>
		<input type="number" name="accountNumber"/><br/>
		<input type="submit" value = "print" />
		<input type="button" value="cancel"/>
	
	</form>
	<% String message = (String)request.getAttribute("exception"); %>
			<% if(message != null){
			out.print(message);
		} %>
		
</div>

</body>
</html>