<%@ page contentType="text/html; charset=UTF-8" errorPage="Error.jsp" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Delete Employee</title>

<link href="default.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!-- start header -->
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
<% session.setAttribute("ErrorSource","EmployeeInfoDelete");%>
<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title></title>
	</head>
	<body>
		<html:form action="employeeInfoDelete">
		<center>
		<h3>Delete Employee</h3>
		<br></br>
			<table>
				<tr>
					<td align="right"><label >Employee ID </label></td>
					<td><html:text property = "employeeCode"/></td>
				</tr>
				<tr>
					<td colspan="2"><html:submit value = "Delete"></html:submit></td>
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

