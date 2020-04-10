
<!-- errors display -->
<% 
String formErrors = (String) request.getSession().getAttribute("Errors");
%>

<%if (formErrors != null && !formErrors.equals("")){%>
<h3>
	<font color="red" face="Arial, Helvetica, sans-serif" size="3">Please
		correct the following errors and try again:</font>
</h3>
<ul>



	<font size="2" color="black" face="Arial, Helvetica, sans-serif">
		<%=request.getSession().getAttribute("Errors") %></font>
</ul>
<% request.getSession().removeAttribute("Errors"); %>
<%}%>
<!-- end errors display -->