<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="Error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Info</title>
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
				<% session.setAttribute("ErrorSource","Employee Details");%>
				<a href = "EmployeeInfo.jsp">Add Employee</a>
				<a href = "EmployeeInfoDelete.jsp">Delete Employee</a>
				<a href = "EmployeeInfoClickToModify.jsp"> Modify Employee</a>
				</div>
				</div>
				</div>
</body>
</html>