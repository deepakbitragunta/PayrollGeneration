<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page errorPage="Error.jsp" %>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Deductions-Modify</title>
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
<!-- end header -->
<!-- start page -->
<div id="page">
	<!-- start content -->
	<div id="content">
		<div class="post">
<% session.setAttribute("ErrorSource","DeductionsModify");%>
<html:form action = "modifyEarnings.do">
<center>
<h3>Modify Deduction Details</h3>

	<table id = "content">
		<tr>
			<td>
				Enter Earning code * 
			</td>
			<td>
				<input type = text name = code>
			</td>
		</tr>
		<tr>
			<td>
				Enter Earning description 
			</td>
			<td>
				<input type = text name = desc>
			</td>
		</tr>
		</table>
		<input type = submit value = Modify>
	</html:form>
			</div>
		</div>
	</div>
</body>
</html:html>