<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="Error.jsp"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Employee Update</title>

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
<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title></title>
	</head>
	<body>
	<% session.setAttribute("ErrorSource","Employee Modify");%>
		<html:form action="employeeInfoClickToModify">
		<center>
		<h3>View Employee Details</h3>
		<br></br>
		
			<table width="100%">
				<tr>
					<td ><label >Employee ID </label></td>
					<td><html:text property = "employeeCode"/></td>
				</tr>
				<tr>
					<td colspan="2"><html:submit value = "View Details"></html:submit></td>
				</tr>
			</table>
			<br></br>
			</center>
		</html:form>
	</body>
</html:html>
	</div>
	</div>
	</div>
	<!-- end content -->
	
<!-- end page -->

</body>
</html>

