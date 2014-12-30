<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Earning-Modify</title>
<link href="default.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@page errorPage="Error.jsp" %>
<%  String uid = (String)session.getAttribute("uid");
	if(uid == null)
	{
		response.sendRedirect("Login.jsp");
	}
	%>
	<div style="position:absolute; top:10px; left: 1200px;"><label style="text-align:right">Hello <%=session.getAttribute("uid")%></label></div>
	<jsp:include page="Header.jsp" />
<!-- end header -->
<!-- start page -->
<div id="page">
	<!-- start content -->
	<div id="content">
		<div class="post">

<html:form action = "modify.do">
<center>
<% session.setAttribute("ErrorSource","modifyEarning");%>
<%
String[] details = (String[])session.getAttribute("details");
int i =0;
%>
<input type = hidden name = code value = <%= details[i++]  %>>
<h3> Enter Earning Details</h3>
<table>

<tr><td>
Enter your description
</td>
<td>
<input type = text name = desc value = <%= details[i++] %>>
</td>
</tr>
<tr><td>
Enter your start date
</td>
<td>
<input type = text name = start_date value = <%= details[i++] %>>
</td>
</tr>
<tr><td>
Enter your end date
</td>
<td>
<input type = text name = end_date value = <%= details[i++] %>>
</td>
</tr>
<tr><td>
Enter your taxability
</td>
<td>
<input type = text name = taxability value = <%= details[i++] %>>
</td>
</tr>
<tr><td>
Enter your default amount
</td>
<td>
<input type = text name = dflt_amount value = <%= details[i++] %>>
</td>
</tr>
</table>
<input type = submit value = "Modify Earnings">
</center>
</html:form>
</div>
</div>
</div>
</body>
</html:html>