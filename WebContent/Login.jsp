<%@ page contentType="text/html; charset=UTF-8" errorPage="Error.jsp" %>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Login Page</title>

<link href="default.css" rel="stylesheet" type="text/css" />
</head>
<body>

<!-- start header -->
<div id="header">
	<div id="menu">
		
	</div>
	<div id="logo">
		<h1><a href="#">Payroll maniacs</a></h1>
		
	</div>
</div>
<!-- end header -->
<!-- start page -->
<div id="page">
	<!-- start content -->
	<div id="content">
		<div class="post">
		<% session.setAttribute("ErrorSource","Login");%>
<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title></title>
	</head>
	<body>
	<h3> Enter your details to login<br></h3>
		<html:form action="LoginInfo">	
		<center>
			<table>
				<tr>
					<td ><label >User Name </label></td>
					<td><html:text property = "userName" value = ""/></td>
				</tr>
				<tr>
					<td ><label>Password </label></td>
					<td><html:password property = "password" value = ""/></td>
				</tr>
				<tr>
					<td colspan="2"><html:submit value = "Login"></html:submit></td>
				</tr>
			</table>
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

