<%@ page contentType="text/html; charset=UTF-8" errorPage="Error.jsp"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>


<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<link href="default.css" rel="stylesheet" type="text/css" />
		<title>Earnings Deductions Page</title>
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
		<h3>You have successfully added the Employment details! Enter the employee earnings and deductions</h3>
		
		<% session.setAttribute("ErrorSource","StrutEarnDed");%>
		<html:form  action = "earnded.do">
			<table>
				<tr>
					<td>
						Enter Employee code * 
					</td>
					<td>
						<input type = "text" name = "emp_code">
					</td>
				</tr>
				<tr>
					<td>
						Enter Earning code * 
					</td>
					<td>
						<input type = "text" name = "earn_code">
					</td>
				</tr>
				<tr>
					<td>
						Enter Earning Start Date *  
					</td>
					<td>
						<input type = "text" name = "earn_start_date">
					</td>
				</tr>
				
				<tr>
					<td>
						Enter Earning End date *
					</td>
					<td>
						<input type = "text" name = "ee_earn_end_date">
					</td>
				</tr>
				<tr>
					<td>
						Enter Earning Status Code 
					</td>
					<td>
						<input type = "text" name = "ee_earn_status_code">
					</td>
				</tr>
				<tr>
					<td>
						Enter Earning Default Amount 
					</td>
					<td>
						<input type = "text" name = "ee_earn_dflt_amt">
					</td>
				</tr>
				
				<tr>
					<td>
						Enter deduction code * 
					</td>
					<td>
						<input type = "text" name = "ded_code">
					</td>
				</tr>
				<tr>
					<td>
						Enter Deduction Start Date *  
					</td>
					<td>
						<input type = "text" name = "ded_start_date">
					</td>
				</tr>
				
				<tr>
					<td>
						Enter Deduction End date *
					</td>
					<td>
						<input type = "text" name = "ee_ded_end_date">
					</td>
				</tr>
				<tr>
					<td>
						Enter Deduction Status Code 
					</td>
					<td>
						<input type = "text" name = "ee_ded_status_code">
					</td>
				</tr>
				<tr>
					<td>
						Enter Deduction Default Amount 
					</td>
					<td>
						<input type = "text" name = "ee_ded_dflt_amt">
					</td>
					
				</tr>	
			</table>
		<input type = submit value = "Insert Data">
		
		
	</html:form>
			</div>
		</div>
	</div>
	<!-- end content -->
	

	
	</body>
</html:html>

