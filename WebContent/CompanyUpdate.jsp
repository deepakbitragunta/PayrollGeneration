<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page errorPage="Error.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Update Company</title>

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
		<% session.setAttribute("ErrorSource","CompanyUpdate");%>
		<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html:html>
<html:form action="Details.do">

	<center>
	<h3>Company already exists!!! You can only Update </h3>
	<br></br>
	<br></br>
	<table>
		<tr> 
			<td>Enter Company Name:</td><td>
			<td><html:select property="company_name">
			<%  
			String name = (String) session.getAttribute("cname");
			%>
	<html:option value = "<%=name %>" > <%= name %></html:option>
			</html:select></td>
		</tr>
		
		
		
		</table>
		<br></br>
		<br></br>
			<html:submit  value="Modify"></html:submit>
			
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
		