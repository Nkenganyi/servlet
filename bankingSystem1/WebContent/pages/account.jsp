<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align = "center">
<div><h3>ACCOUNT REGISTRATION</h3></div>
	<div>
		<form method="POST" action="account.jsp">
		
			<label>First Name</label><br/>
            <input type="text" name="firstName" /><br/>
            <label>Last Name</label><br/>
            <input type="text" name="lastName" /><br/>
            <label>Id Number</label><br/>
            <input type="number" name="idNumber" /><br/>
            <label>Date Of Birth</label><br/>
            <input type="date" name="dateOfBirth" /><br/>
            <label>Phone Number</label><br/>
            <input type="number" name="phoneNumber" /><br/>
            <label>email Address</label><br/>
            <input type="email" name="emailAddress" /><br/>
            <label>Residential Address</label><br/>
            <input type="text" name="address" /><br/>
            <label>Country of Origin</label><br/>
            <input type="text" name="nationality" /><br/>
            <label>City</label><br/>
            <input type="text" name="city" /><br/>
            <label>Residential Country</label><br/>
            <input type="text" name="country" /><br/>
            <label>Position</label><br/>
            <input type="text" name="position" /><br/>
            <label>user name</label><br/>
            <input type="text" name="username" /><br/>
            <label>Password</label><br/>
            <input type="password" name="password" /><br/>
            <input type="submit" value="save"/>
            <a href="pages/employeeDashboard.jsp" ><button> cancel </button></a>
                                
		</form>
	</div>
</div>
</body>
</html>