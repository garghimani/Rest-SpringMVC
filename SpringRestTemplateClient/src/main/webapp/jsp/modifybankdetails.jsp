<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>modifybankdetails</title>
</head>
<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">

	<center>
		<h2>Modify Bank Details</h2>
		<%@include file="displayformerrors.jsp"%>
	</center>
	<!--Body: view contact information-->
	<center>
		<form method="post" modelAttribute="modifybankVOO"
		action="/springmvc-hibernate/modifybankDetails.do">
			<table cellpadding="0" cellspacing="0" width="50%"">
				<tr>
					<td bgcolor="#FAFAF9" style="padding-left: 10px;">First Name</td>
					<td><input type="text" name="personId" value="<%=session.getAttribute("firstName")%>" maxlength="50"
						value="" /></td>
				</tr>
				<tr>
					<td bgcolor="#FAFAF9" style="padding-left: 10px;">Bank Name</td>
					<td><input type="text" name="bankName" value="<%=session.getAttribute("bankName")%>" maxlength="50"
						value="" /></td>
				</tr>
				<tr>
					<td bgcolor="#FAFAF9" style="padding-left: 10px;">Account Number</td>
					<td><input type="text" name="accountNumber" value="<%=session.getAttribute("accountNumber")%>" maxlength="50"
						value="" /></td>
				</tr>
				<tr>
					<td bgcolor="#FAFAF9" style="padding-left: 10px;">SSN</td>
					<td><input type="text" name="ssn" value="<%=session.getAttribute("ssn")%>" maxlength="50"
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