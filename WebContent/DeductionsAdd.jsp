<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page errorPage="Error.jsp" %>
<html:html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Add Deduction Details</title>

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
<div id="page">
	<!-- start content -->
	<div id="content">
		<div class="post">
<% session.setAttribute("ErrorSource","DeductionsAdd");%>
<html:form action = "addDeductions.do">
<center>
<h3>Add Deduction Details of Employee</h3>
	<table >
		<tr>
			<td>
				Enter Earning code * 
			</td>
			<td>
				<input type = text name = code>
			</td>
		</tr>
		<tr>
			<td>
				Enter Deduction description 
			</td>
			<td>
				<input type = text name = desc>
			</td>
		</tr>
		<tr>
			<td>
				Enter Deduction Start Date * 
			</td>
			<td>
				<input type = text name = start_date>
			</td>
		</tr>
		<tr>
			<td>
				Enter End date 
			</td>
			<td>
				<input type = text name = end_date>
			</td>
		</tr>
		<tr>
			<td>
				Enter ER_Code 
			</td>
			<td>
				<input type = text name = er_code>
			</td>
		</tr>

		<tr>
			<td>
				Enter Taxability 
			</td>
			<td>
				<select name = "taxability" id = "taxability">
					<option value = "Pre-Tax">Pre-Tax</option>
					<option value = "Post-Tax">Post-Tax</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				Enter Default Amount 
			</td>
			<td>
				<input type = text name = dflt_amount>
			</td>
		</tr>
	</table>
	<input type = submit value = "Insert Data">
	</center>
</html:form>
	</div>
		</div>
	</div>
	<!-- end content -->
</body>
</html:html>