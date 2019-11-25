<%@page import="java.util.List"%>
<%@page import="za.co.bankingsystem.model.Account"%>
<%@page import="za.co.bankingsystem.model.Transaction"%>
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
<div  style="background: #9400D3">
<h3  style="color : #FFFFFF ">TRANSACTIONS</h3>
</div>
<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>TRANSACTION TYPE</th>
				<th>AMOUNT</th>
				<th>TRANSACTION TIME</th>
			</tr>
		</thead>
		<tbody>
			<%
				Account acc = (Account)request.getAttribute("actions");
			%>
 
			<%
				for (int i =0; i < acc.getTransactions().size();i++) {
			%>
			<tr>
				<td><%=acc.getTransactions().get(i).getTransaction_id() %></td>
				<td><%=acc.getTransactions().get(i).getTransactionType()%></td>
				<td><%=acc.getTransactions().get(i).getTransactionBalance()%></td>
				<td><%=acc.getTransactions().get(i).getTransactionDateTime()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	</div>
</body>
</html>