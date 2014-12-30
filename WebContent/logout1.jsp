<%@ page contentType="text/html; charset=UTF-8" errorPage="Error.jsp"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User</title>
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
	<div id="header">
	<div id="menu">
	<ul>
			<li><a href="logout1.jsp">logout</a></li>
				
		</ul> 
	</div>
	<div id="logo">
		<h1><a href="#">Payroll maniacs</a></h1>
		
	</div>
</div>
	
<div id="page">
	<!-- start content -->
	<div id="content">
		<div class="post">
		<% session.setAttribute("ErrorSource","user");%>
		<form action = signout.do>
Do you really want to signout
<input type = submit value = signout>
</form>
 
		</div>
		</div>
		</div>
		
</body>
</html:html>