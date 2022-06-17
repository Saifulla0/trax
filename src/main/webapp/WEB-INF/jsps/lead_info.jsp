<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lead | Info</title>
</head>
<body>
	<h2>Lead Info</h2>
	
	First Name:${lead.firstName}<br>
	Last Name:${lead.lastName}<br>
	Lead Source:${lead.leadSource}<br>
	Email:${lead.email}<br>
	Mobile:${lead.mobile}<br>
	

	
	<form action="sendEmail" method="post">
		<input type="hidden" name="email" value="${lead.email}"/><br/>
		<input type="submit" value="Send Mail"/><br/>
	${msg}
	</form>
	<form action="convertLead" method="post">
		<input type="hidden" name="id" value="${lead.id}"/><br/>
		<input type="submit" value="Convert"/><br/>
	</form>
	${emailerror}
</body>
</html>