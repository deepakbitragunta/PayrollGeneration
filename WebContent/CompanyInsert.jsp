<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page errorPage="Error.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Create Company</title>

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
		<% session.setAttribute("ErrorSource","CompanyInsert");%>
		<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html:html>
<html:form action="insertcompanyDetails.do">

	<center>
	<h3>Insert New Company Details</h3>
	<br></br>
	<br></br>
	<table>
		<tr> 
			<td>Company Code:</td>
			<td><html:text property="company_code" ></html:text></td>
		</tr>
		<tr>
			<td>Company Name:</td>
			<td><html:text property="company_name"></html:text></td>
		</tr>
		<tr>
			<td>Company Start Date:</td>
			<td><html:text property="cmp_start_date"></html:text></td>
		</tr>
		<tr>
			<td>Company End Date:</td>
			<td><html:text property="cmp_end_date"></html:text></td>
		</tr>
		<tr>
			<td>Address Line1:</td>
			<td><html:text property="cmp_add_ln1"></html:text></td>
		</tr>
		<tr>
			<td>Address Line2:</td>
			<td><html:text property="cmp_add_ln2"></html:text></td>
		</tr>
		<tr>
			<td>Address Line3:</td>
			<td><html:text property="cmp_add_ln3"></html:text></td>
		</tr>
		<tr>
			<td>Town:</td>
			<td><html:text property="cmp_town"></html:text></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><html:text property="cmp_state"></html:text></td>
		</tr>	
		<tr>
			<td>Country:</td>
			<td><html:text property="cmp_country"></html:text></td>
		</tr>
		<tr>
			<td>PostCode:</td>
			<td><html:text property="cmp_postcode" value=""></html:text></td>
		</tr>
		<tr>
			<td>Phone no.:</td>
			<td><html:text property="cmp_phone"></html:text></td>
		</tr>
	</table>
	<br></br>
			<html:submit  value="Insert"></html:submit>
			
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
