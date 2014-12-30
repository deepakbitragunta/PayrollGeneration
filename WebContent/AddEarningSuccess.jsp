<%@ page contentType="text/html; charset=UTF-8" errorPage="Error.jsp" %>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>


<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title>SuccessfulEarningAdd</title>
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

<div id="page">
	<!-- start content -->
	<div id="content">
		<div class="post">
		<% session.setAttribute("ErrorSource","AddEarningSuccess");%>
	<%
	int j;
	
	String[][] resValues = (String[][])session.getAttribute("val");
	%>
		<table Border = "5">
		<tr>
		<td>
			<table Border = "1">
			<tr>
			<td >Employee Code:</td>
			<td> <%= resValues[0][0] %>
			</tr>			
			<tr>
			<td>Employee Name:</td>
			<td><%=resValues[0][1] %>  <%=resValues[0][3] %></td>
			</tr>				
			</table>
		</td>
		<td>	
			<table Border = "1">
			<tr>
			<td>Tax Year:</td>
			<td><%= resValues[1][1]%></td>
			</tr>			
			<tr>
			<td>Pay Period No:</td>
			<td><%= resValues[1][0]%></td>
			</tr>
			<tr>
			<td>Pay Date</td>
			<td><%= resValues[1][2]%></td>			
			</tr>		
			</table>
		</td>
		</tr>
		<tr>
		<td>
			<table Border = "1">
			<tr>
			<td style = "font-weight: Bold">Earnings:</td>
			<td style = "font-weight: Bold">Amount
			</td>
			</tr>			
			<% 
			for(j = 2; ;j++)
			{
				if(resValues[j][0].equals("0"))
					break;
			%>
			<tr>
			<td><%= resValues[j][1]%></td>
			<td><%= resValues[j][2]%></td>
			</tr>	
			<%
			}
			%>					
			</table>
		</td>
		<td>	
			<table Border = "1">
			<tr>
			<td style = "font-weight: Bold">Deductions:</td>
			<td style = "font-weight: Bold">Amount</td>
			</tr>			
			<% 
			for(;resValues[j][0].equals("0") ;j++)
			{
			%>
			<tr>
			<td><%= resValues[j][1]%></td>
			<td><%= resValues[j][2]%></td>
			</tr>	
			<%
			}
			%>					
			
			</table>
		</td>
		</tr>
		<tr>
		<td>
			<table  Border = "1">
			<tr>
			<td style = "font-weight: Bold">Amount Paid:</td>
			</tr>			
			<tr>
			<td>Earnings:</td>
			<td><%= resValues[j][0]%></td>
			
			</tr>	
			<tr>
			<td>Deductions:</td>
			<td><%= resValues[j][1]%></td>
			
			</tr>
			<tr>
			<td>Net Pay:</td>
			<td><%= resValues[j][2]%></td>
			</tr>			
			</table>
		</td>
		<td>	
			
		</td>
		</tr>
		</table>
		</div>
		</div>
		</div>
	</body>
</html:html>

