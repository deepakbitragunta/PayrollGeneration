<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page errorPage="Error.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Update Company Details</title>

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
		<% session.setAttribute("ErrorSource","CompanyDetails");%>
		<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<form action="updateCompanyDetails.do">
<%
String[] details = (String[])session.getAttribute("details");
int i =0;
%>



	<center>
	<h3>Update Company Details </h3>
	<br></br>
	<br></br>
	<br></br>
	<input type = hidden name = company_code value = <%= details[i++] %>>
	Company is <%=details[i] %>	
	<input type = hidden name = company_name value = <%= details[i++] %>>
		
	<table>
		<tr>
			<td>Company Start Date:</td>
			<td><input type = text name = cmp_start_date value = <%= details[i++] %>></td>
		</tr>
		<tr>
			<td>Company End Date:</td>
			<td><input type = text name = cmp_end_date value = <%= details[i++] %>></td>
		</tr>
		<tr>
			<td>Address Line1:</td>
			<td><input type = text name =  cmp_add_ln1 value = <%= details[i++] %>></td>
		</tr>
		<tr>
			<td>Address Line2:</td>
			<td><input type = text name = cmp_add_ln2 value = <%= details[i++] %>></td>
		</tr>
		<tr>
			<td>Address Line3:</td>
			<td><input type = text name = cmp_add_ln3 value = <%= details[i++] %>></td>
		</tr>
		<tr>
			<td>Town:</td>
			<td><input type = text name = cmp_town value = <%= details[i++] %>></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><input type = text name = cmp_state value = <%= details[i++] %>></td>
		</tr>	
		<tr>
			<td>Country:</td>
			<td><input type = text name = cmp_country value = <%= details[i++] %>></td>
		</tr>
		<tr>
			<td>PostCode:</td>
			<td><input type = text name = cmp_postcode value = <%= details[i++] %>></td>
		</tr>
		<tr>
			<td>Phone no.:</td>
			<td><input type = text name = cmp_phone value = <%= details[i++] %>></td>
		</tr>
	</table>
			
			<input type = submit value = "Update">
			</center>
			<br></br>
<br></br>
<br></br>
</input>
</form>

</div>
		</div>
	</div>
	
	


</body>
</html>
