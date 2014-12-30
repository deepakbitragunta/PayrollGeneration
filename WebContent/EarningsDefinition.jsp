<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page errorPage="Error.jsp" %>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Earning Definitions</title>
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
		<div class="post" style = "font-weight: bolder; font-size: 24px;">
<% session.setAttribute("ErrorSource","EarningsDefinition");%>
<html:form action = "modifyEarnings.do">
<a href = EarningAdd.jsp> Add Earnings</a><br>
<a href = EarningModify.jsp> Modify Earnings</a><br>
<a href = EarningDelete.jsp> Delete Earnings</a><br>
</html:form>
</div>
</div>
</div>
</body>
</html:html>