<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page errorPage="Error.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Create Company</title>

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
		<% session.setAttribute("ErrorSource","CreateCompany");%>
		<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
		
		<center>
			<form action = "control.do">
				CREATE A NEW COMPANY
				<br></br>
				<br></br>
				<input type = submit value = "Create">
				
				</center>
			</form>
</div>
		</div>
	</div>
	
	


</body>
</html>