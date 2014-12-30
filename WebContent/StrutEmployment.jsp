<%@ page contentType="text/html; charset=UTF-8" errorPage="Error.jsp"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>


<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<link href="default.css" rel="stylesheet" type="text/css" />
		<title>Employment Page</title>
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
		<h3>You have successfully added the appointment details! Enter the employment details</h3>
		<% session.setAttribute("ErrorSource","StrutEmployment");%>
			<html:form action="emp.do" >
				<table id="">
					<tr>
						<td>
							Employee Code
						</td>
						<td>
							<input type="text" name ="emp_code"> 
							
						</td>
					</tr>
					<tr>
						<td>
							Hire Date*
						</td>
						<td>
							<input type="text" name ="hire_date"> 
						</td>
					</tr>
					<tr>
						<td>
							Employee Term Date
						</td>
						<td>
							<input type="text" name ="emp_term_date"> 
						</td>
					</tr>
					<tr>
						<td>
							Employee Status*
						</td>
						<td>
							<input type="text" name ="ee_status"> 
						</td>
					</tr>
					<tr>
						<td>
							Full Part Time
						</td>
						<td>
							<input type="text" name ="full_part_time"> 
						</td>
					</tr>
					<tr>
						<td>
							Permanent or Temporary
						</td>
						<td>
							<input type="text" name ="permanent_temp"> 
						</td>
					</tr>
					<tr>
						<td>
							Leaving Reason
						</td>
						<td>
							<input type="text" name ="leaving_reason"> 
						</td>
					</tr>
					<tr>
						<td>
							Notice Period
						</td>
						<td>
							<input type="text" name ="notice_period"> 
						</td>
					</tr>
					<tr>
						<td>
							Motice Period Unit
						</td>
						<td>
							<input type="text" name ="notice_period_unit"> 
						</td>
					</tr>
					<tr>
						<td>
							Probation period
						</td>
						<td>
							<input type="text" name ="prob_period"> 
						</td>
					</tr>
					<tr>
						<td>
							Probation period Unit
						</td>
						<td>
							<input type="text" name ="prob_period_unit"> 
						</td>
					</tr>
					<tr>
						<td>
							Pay Frequency*
						</td>
						<td>
							<select name ="pay_frequency">
								<option>Monthly</option>
								<option>Weekly</option>		
							</select>
						</td>
					</tr>
					<tr> 
						<td> <input type="submit" Value ="SUBMIT"> </td>
					</tr>
				</table>
		</html:form> 
	
		</div>
	</div>
	<!-- end content -->
	
</div>
<!-- end page -->
		
	</body>
</html:html>

