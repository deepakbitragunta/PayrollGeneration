<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>


<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title></title>
		<link href="default.css" rel="stylesheet" type="text/css" />
	</head>
	<body>	
<%  String uid = (String)session.getAttribute("uid");
	if(uid == null)
	{
		response.sendRedirect("Login.jsp");
	}
	%>
	<div style="position:absolute; top:10px; left: 1200px;"><label style="text-align:right"><%=session.getAttribute("uid")%></label></div>
	<jsp:include page="Header.jsp" />	
<div id="page">
	<!-- start content -->
	<div id="content">
		<div class="post">
	<% String  Name = (String)session.getAttribute("ErrorSource");%>
 <label><font color="#ff0000"><center>Exception from <%=Name %> file</center></font></label>
		</div>
		</div>
		</div>
	</body>
</html:html>



