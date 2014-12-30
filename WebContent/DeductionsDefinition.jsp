<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page errorPage="Error.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Deduction Definitions</title>

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
		<div class="post" style = "font-weight: bolder; font-size: 24px;">
		<form>
			<a href = "DeductionsAdd.jsp">Add Deductions</a><br></br>
			<a href = "DeductionsModify.jsp">Modify Deductions</a><br></br>
			<a href = "DeductionsDelete.jsp">Delete Deductions</a>
		</form>
		</div>
		</div>
	</div>
<% session.setAttribute("ErrorSource","DeductionsDefinition");%>
</body>
</html>