<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="Error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Company Foundation</title>
<link href="default.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div style="position:absolute; top:10px; left: 1200px;"><label style="text-align:right">Hello <%=session.getAttribute("uid")%></label></div>
	<jsp:include page="Header.jsp" />
<!-- end header -->
<!-- start page -->
<% session.setAttribute("ErrorSource","AddEarningSuccess");%>
<div id="page">
	<!-- start content -->
	<div id="content">
		<div class="post" style = "font-weight: bolder; font-size: 24px;">
	 <a href = "CreateCompany.jsp">Company</a><br> 
	 <a href = "EarningsDefinition.jsp">Earnings</a><br> 
	 <a href = "DeductionsDefinition.jsp">Deduction</a> <br>
	 <a href = "BusinessUnitDetails.jsp">Business Unit</a><br>
	 <a href = "JobDetails.jsp">Job</a><br>
	 <a href = "PositionDetails.jsp">Position</a>
	 </div>
	 </div>
	 </div>
</body>
</html>