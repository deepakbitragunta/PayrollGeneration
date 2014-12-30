<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page errorPage="Error.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Insert your title</title>

<link href="default.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!-- start header -->
<div id="header">
	<div id="menu">
	
<%  String uid = (String)session.getAttribute("uid");
	if(uid == null)
	{
		response.sendRedirect("Login.jsp");
	}
	else if(uid.equals("admin") == false)
	{
		response.sendRedirect("user.jsp");
	}
		
	%>
		<ul>
			<li><a href="FoundationData.jsp">Foundation Data</a></li>
				
			<li><a href="EmployeeData.jsp">Employee Data</a></li>
			<li class="active"><a href="PayCalendarGenerate.jsp">PayRoll</a></li>
			<li><a href = "logout.jsp">Log Out</a></li> 
		</ul> 
	</div>
	<div id="logo">
		<h1><a href="#">Payroll maniacs</a></h1>
		
	</div>
</div>
