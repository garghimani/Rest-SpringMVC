<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>contactdetailssuccess</title>
</head>
<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">

	<center>
		<h2>Contact Details</h2>
		<%@include file="displayformerrors.jsp"%>
	</center>
	<!--Body: view contact information-->
	<center>
		<table border="1" cellpadding="1" cellspacing="0" width="25%"">
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Address</td>
				<td>${viewContactVOO.address}</td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">City</td>
				<td>${viewContactVOO.city}</td>
			</tr>

			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Sate</td>
				<td>${viewContactVOO.state}</td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Country</td>
				<td>${viewContactVOO.country}</td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Phone</td>
				<td>${viewContactVOO.phone}</td>
			</tr>

		</table>

		<br> <br> <input type="button"
			onClick="location.href = '/springmvc-hibernate/jsp/home.jsp'" value="Home Page"
			style="margin: 0 34">

	</center>
</body>
</html>