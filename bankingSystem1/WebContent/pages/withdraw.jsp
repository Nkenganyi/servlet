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
		<h3>WITHDRAWAL</h3>
	</div>
	<form method = "POST" action = "withdraw.jsp">
	
		<label>Account Number</label><br/>
		<input type="number" name="accountNumber"/><br/>
		<label>Deposit Amount</label><br/>
		<input type="number" name="amount"/><br/>
		<input type="submit" value = "save" />
		
	
	</form>
		<button>cancel</button>
</div>
</body>
</html>