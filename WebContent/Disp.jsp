<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page errorPage="Error.jsp" %>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Payslip</title>
<link href="default.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%  String uid = (String)session.getAttribute("uid");
	if(uid == null)
	{
		response.sendRedirect("Login.jsp");
	}
	%>
	<div style="position:absolute; top:10px; left: 1200px;"><label style="text-align:right">Hello <%=session.getAttribute("uid")%></label></div>
	<jsp:include page="Header.jsp" />	
<div id="page">
	<!-- start content -->
	<div id="content">
		<div class="post">
		<% session.setAttribute("ErrorSource","Disp");%>
<html:form action = "getPaySlip.do">
<%
String[] res = (String[])session.getAttribute("validEmps");
for(int i = 0;res[i] != null;i++){
out.print(res[i]);
%>
<br><br>
<% } %>
<center>

<h3>View PaySlip</h3>
<br></br>

Enter the employee number
<input type = "text" name = "code">
<input type = "submit" value = "Get Pay Slip">
<br></br>
</center>
</html:form>
</div>
</div>
</div>
</body>
</html:html>