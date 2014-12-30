<%@ page contentType="text/html; charset=UTF-8" errorPage="Error.jsp" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<link href="default.css" rel="stylesheet" type="text/css" />
		<title>Appointment Page</title>
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
		<br></br> 
		<% session.setAttribute("ErrorSource","AppointmentAdd");%>
			<html:form action="appoint.do" >
				<table >
					<tr>
						<td>
							Employee Code*
						</td>
						<td>
							<input type="text" name ="emp_code" /> 
							
						</td>
					</tr>
					<tr>
						<td>
							Appointment Number*
						</td>
						<td>
							<input type="text" name ="appt_no"/> 
						</td>
					</tr>
					<tr>
						<td>
							Appointment Start Date 
						</td>
						
                       <td>
                      		<input type="text" name ="appt_start_date"/> 
                       </td>
						
					</tr>
					<tr>
						<td>
							Appointment End Date
						</td>
						<td>
							<input type="text" name ="appt_end_date"/> 
						</td>
					</tr>
					<tr>
						<td>
							Business code
						</td>
						<td>
							<input type="text" name ="bu_code" /> 
						</td>
					</tr>
					<tr>
						<td>
							Job Code
						</td>
						<td>
							<input type="text" name ="job_code" /> 
						</td>
					</tr>
					<tr>
						<td>
							Position ID
						</td>
						<td>
							<input type="text" name ="posn_id"/> 
						</td>
					</tr>
					<tr>
						<td>
							Reports to
						</td>
						<td>
							<input type="text" name ="reports_to" /> 
						</td>
					</tr>
					<tr>					
						<td></td>
						<td><input type="submit" value = "submit"/> </td>
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

