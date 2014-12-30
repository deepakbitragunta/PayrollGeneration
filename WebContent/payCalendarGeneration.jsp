<%@ page contentType="text/html; charset=UTF-8" errorPage="Error.jsp" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Pay Calendar</title>

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
		<% session.setAttribute("ErrorSource","payCalendarGeneration");%>
		<% String[][] calendarRecords = new String[12][9];
		   calendarRecords = (String[][])session.getAttribute("calendarRecords");
		   int i;
		   int j;%>
		   <center>
				<html:html>
				<h3> Pay Calendar for the selected tax-year</h3>
					<html:form action = "getInfo.do">
				<table Border="1" title="Pay Calendar">
						<tr> 
							<td> Pay Period No</td>
							<td> Period Start Date</td>
							<td> Period End Date</td>
							<td> Pay Date</td>
							<td> Process Date</td>
						</tr>
						<%for(i=0;i<12;i++){ %>
						<tr> 
							<%for(j=0;j<5;j++){ %>
							<td> <%=calendarRecords[i][j]  %></td>
							<% }%>
						</tr>
						<%} 
						String payFrequency = (String)session.getAttribute("payFrequency");
						int taxYear = (Integer)session.getAttribute("taxYear");
						%>
						
					</table>
					<br><br> 
					<input type = hidden name = pay_frequency value = <%= payFrequency  %>>
					<input type = hidden name = tax_year value = <%= taxYear%>>
					Pay Frequency is <%= payFrequency %>
					<br><br>Tax Year is <%= taxYear %></label>
					<br><br>
					Enter pay Period Number<input type = "text" name = pay_period_no>
					<input type = "submit" value = "Get Pay Slips">
					</html:form>
				</html:html>
			</center>
		</div>
	</div>
</div>
	<!-- end content -->
	
</div>
<!-- end page -->

</body>
</html>
		