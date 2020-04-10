<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SuccesfullyRegistered</title>
</head>
<body>
	<center>
		<h1>
			<font color=red>You've Registered Successfully</font>
		</h1>
	</center>
	<center>
		<h3>
			<font>Personal Details</font>
		</h3>
		<table border="1" cellpadding="1" cellspacing="0" width="40%"">
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">First Name</td>
				<td><%=session.getAttribute("firstName")%></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Middle Name</td>
				<td><%=session.getAttribute("middleName")%></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Last Name</td>
				<td><%=session.getAttribute("lastName")%></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Gender</td>
				<td><%=session.getAttribute("gender")%></td>
			</tr>
		</table>
		<h3>
			<font>Contact Information</font>
		</h3>
		<table border="1" cellpadding="1" cellspacing="0" width="40%"">
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Address</td>
				<td><%=session.getAttribute("address")%></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">City</td>
				<td><%=session.getAttribute("city")%></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">State</td>
				<td><%=session.getAttribute("state")%></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Country</td>
				<td><%=session.getAttribute("country")%></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Phone Number</td>
				<td><%=session.getAttribute("phone")%></td>
			</tr>
		</table>
		<h3>

			<font>Account Details</font>
		</h3>
		<table border="1" cellpadding="1" cellspacing="0" width="40%"">
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Bank Name</td>
				<td><%=session.getAttribute("bankName")%></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Account No.</td>
				<td><%=session.getAttribute("accountNumber")%></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">SSN</td>
				<td><%=session.getAttribute("ssn")%></td>
			</tr>
		</table>
		<br> <br> <input type="button"
			onClick="location.href = '/springmvc-hibernate/jsp/home.jsp'" value="Home Page"
			style="margin: 0 34">
	</center>
</body>
</html>