<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page errorPage="Error.jsp" %>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Earning- Delete</title>
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
<% session.setAttribute("ErrorSource","EarningDelete");%>
<html:form action = "delEarnings.do">
<center>
<h3>Delete Earning Details</h3>
<br></br>
	<table>
		<tr>
			<td>
				Enter Earning code * 
			</td>
			<td>
				<input type = text name = code>
			</td>
		</tr>
		</table>
		<input type = submit value = "Delete Data">
		</center>
	</html:form>
</div>
</div>
</div>
</body>
</html:html>