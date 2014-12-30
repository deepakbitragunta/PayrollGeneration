<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page errorPage="Error.jsp" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>New Business Unit</title>

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
<% session.setAttribute("ErrorSource","BusinessUnitDetails");%>
<html:form action="addbusinessunit">
<br></br>

<center>
<h3>Add Business Unit</h3>
<br></br>
<table>
	<tr>
		<td>Business Unit Code:</td>
		<td><html:text property="bu_code"></html:text></td>
	</tr>
	<tr>
	<td>Business Unit Name:</td>
	<td><html:text property="bu_name"></html:text></td>
	</tr>
	<tr>
	<td>Unit Effective From:</td>
	<td><html:text property="bu_effective_from"></html:text></td>
	</tr>
	<tr>
	<td>Unit Effective To:</td>
	<td><html:text property="bu_effective_to"></html:text></td>
	</tr>
	<tr>
	<td>Business Unit Type:</td>
	<td><html:select property="bu_type">
	<html:option value="Admininstration">Admininstration</html:option>
	<html:option value="Finance">Finance</html:option>
	<html:option value="Human Resources">Human Resources</html:option>
	<html:option value="Payroll">Payroll</html:option>
	<html:option value="Technical">Technical</html:option>
	<html:option value="Sales and Marketing">Sales and Marketing</html:option>
	<html:option value="Production">Production</html:option>
	<html:option value="Packaging">Packaging</html:option>
	<html:option value="Quality Assurance">Quality Assurance</html:option>
	<html:option value="Warehouse">Warehouse</html:option>
	<html:option value="Transport">Transport</html:option>
</html:select></td>
</tr>
	<tr>
	<td>Parent Unit:</td>
	<td><html:text property="bu_parent"></html:text></td>
	</tr>
</table>
	<html:submit value="Save"></html:submit>
</center>
<br></br>
<br></br>
<br></br>
</html:form>
</html:html>
</div>
</div>
	</div>
	
	


</body>
</html>
