<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>modifycontactdetails</title>
</head>
<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">

	<center>
		<h2>Modify Contact Details</h2>
		<%@include file="displayformerrors.jsp"%>
	</center>
	<!--Body: view contact information-->
	<center>
		<form method="post" modelAttribute="modifyContactVOO"
		action="/springmvc-hibernate/modifyContactDetails.do">
			<table cellpadding="0" cellspacing="0" width="50%"">
				<tr>
					<td bgcolor="#FAFAF9" style="padding-left: 10px;">First Name</td>
					<td><input type="text" name="personID" value="<%=session.getAttribute("firstName")%>" maxlength="50"
						value="" /></td>
				</tr>
				<tr>
					<td bgcolor="#FAFAF9" style="padding-left: 10px;">Address</td>
					<td><input type="text" name="address" value="<%=session.getAttribute("address")%>" maxlength="50"
						value="" /></td>
				</tr>
				<tr>
					<td bgcolor="#FAFAF9" style="padding-left: 10px;">City</td>
					<td><input type="text" name="city" value="<%=session.getAttribute("city")%>" maxlength="50"
						value="" /></td>
				</tr>
				<tr>
					<td bgcolor="#FAFAF9" style="padding-left: 10px;">State</td>
					<td><input type="text" name="state" value="<%=session.getAttribute("state")%>" maxlength="50"
						value="" /></td>
				</tr>
				<tr>
					<td bgcolor="#FAFAF9" style="padding-left: 10px;">Country</td>
					<td><input type="text" name="country" value="<%=session.getAttribute("country")%>" maxlength="50"
						value="" /></td>
				</tr>
				<tr>
					<td bgcolor="#FAFAF9" style="padding-left: 10px;">Phone No.</td>
					<td><input type="text" name="phone" value="<%=session.getAttribute("phone")%>" maxlength="50"
						value="" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><br>
						<table width="50%">
							<tr>
								<td><input type="submit" name="modify" value="Modify" />&nbsp;</td>
								<td width="201"><input type="reset" name="clear"
									value="Clear" />&nbsp;</td>
								<td width="201"><input type="button"
									onClick="location.href = '/springmvc-hibernate/jsp/home.jsp'"
									value="Home Page" />&nbsp;</td>
							</tr>
						</table></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>