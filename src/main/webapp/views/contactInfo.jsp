<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Save Contact Here</h3>
	
	<font color='green'>${success }</font>
	<font color='red'>${error }</font>
	
	<form:form action="saveContact?contactId=${contact.contactId }" modelAttribute="contact" method="POST">
		<table>
			<tr>
			<td>Contact Name:</td>
			<td><form:input path="contactName"/></td>
			</tr>
			<tr>
			<td>Contact Email:</td>
			<td><form:input path="contactEmail"/></td>
			</tr>
			<tr>
			<td>Contact Number:</td>
			<td><form:input path="contactNumber"/></td>
			</tr>
			<tr>
			<td></td>
			<td><input type="submit" value="Save"/></td>
			</tr>
		</table>
	</form:form>
	<a href="viewAllContact">View All Contacts</a>
</body>
</html>