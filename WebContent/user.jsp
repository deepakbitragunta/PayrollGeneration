<%@ page contentType="text/html; charset=UTF-8" errorPage="Error.jsp"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User</title>
<link href="default.css" rel="stylesheet" type="text/css" />
</head>
<body>
<html:form action  = "payroll.do">
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
		<h3>Welcome User</h3>
		<br></br>
		<input type = "hidden" name = code value = <%= session.getAttribute("uid") %>>
		<input type = submit value = "get pay slip"> 
		</div>
		</div>
		</div>
		</html:form>
</body>
</html:html>