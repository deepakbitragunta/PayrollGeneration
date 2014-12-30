<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="Error.jsp"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Earnings- Add</title>
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
<!-- end header -->
<!-- start page -->
<div id="page">
	<!-- start content -->
	<div id="content">
		<div class="post">
		<% session.setAttribute("ErrorSource","EarningAdd");%>
<html:form action = "addEarnings.do">
<center>
<h3>Add Earning Details</h3>
<br></br>
	<table id = "content">
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
				Enter Earning description 
			</td>
			<td>
				<input type = text name = desc>
			</td>
		</tr>
		<tr>
			<td>
				Enter Earning Start Date * 
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
	<br></br>
	<input type = submit value = "Insert Data">
	</center>
</html:form>
</div>
		</div>
	</div>
	
</body>
</html:html>