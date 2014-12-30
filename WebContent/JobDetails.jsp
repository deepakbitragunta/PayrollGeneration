<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page errorPage="Error.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>New Job Details</title>

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
		<% session.setAttribute("ErrorSource","JobDetails");%>
		<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title></title>
	</head>
	<body>
	
		<html:form  action = "login">
		<center>
		<h3>Add New Job Details</h3>
		<br></br>
		<table>
	<tr>
		<td>Job Code</td>
		<td><html:text property="jobcode"  ></html:text></td>
	</tr>
	<tr>
	<td>Title</td>
	<td><html:text property="jobtitle" ></html:text></td>
	</tr>
	<tr>
	<td> Job Description</td>
	<td><html:text property="description" ></html:text></td>
	</tr>
	<tr>
	<td></td>
	<td><html:submit value = "Save"></html:submit></td></tr></table>
	<br></br>
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
