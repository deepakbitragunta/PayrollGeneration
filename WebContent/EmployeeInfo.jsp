<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="Error.jsp"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Employee Add</title>

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
<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title></title>
	</head>
	<body>
	
	
	<% session.setAttribute("ErrorSource","Employee Details");%>
		<html:form action="employeeInfo" styleId="employeeInfofrm">
		<center>
	<h3>Enter Employee Details</h3>
	<br></br>
			<table width="100%">
				<tr>
					<td ><label >Employee ID </label></td>
					<td><html:text property = "employeeCode"/></td>
				</tr>
				<tr>
					<td ><label>First Name </label></td>
					<td><html:text property = "firstName"/></td>
				</tr>
				<tr>
					<td><label>Middle Name </label></td>
					<td><html:text property = "middleName"/></td>
				</tr>
				<tr>
					<td><label>Last Name </label></td>
					<td><html:text property = "lastName"/></td>
				</tr>
				<tr>
					<td><label>Title </label></td>
					<td><html:select property = "title">
							<html:option value="">- Select One -</html:option>   	
							<html:option value="Member Technical G1">Member Technical G1</html:option>
							<html:option value="Member Technical G2">Member Technical G2</html:option>
							<html:option value="Member Technical G3">Member Technical G3</html:option>
							<html:option value="Member Technical G4">Member Technical G4</html:option>
						</html:select>
					</td>
				</tr>
				<tr>
					<td><label>Date of Birth </label></td>
					
   					<td>Date:&nbsp;&nbsp;<html:select property="birthDay">
   						<html:option value="">-Date-</html:option>   						
   						<c:forEach begin="1" end="31" var="date">
   							<html:option value="${date}"/>
   						</c:forEach>
   						</html:select>
   						&nbsp;&nbsp;Month:&nbsp;&nbsp;<html:select property="birthMonth">
   						<html:option value="">-Month-</html:option>   						
   						<c:forEach begin="1" end="12" var="month">
   							<html:option value="${month}"/>
   						</c:forEach>
   						</html:select>
   						&nbsp;&nbsp;Year:&nbsp;&nbsp;<html:select property="birthYear">
   						<html:option value="">-Year-</html:option>   						
   						<c:forEach begin="1965" end="2011" var="year">
   							<html:option value="${year}"/>
   						</c:forEach>
   						</html:select>
   					</td>
				</tr>
				<tr>
					<td><label>Gender </label></td>
					<td><html:select property="gender">
							<html:option value="">- Select One -</html:option>   	
							<html:option value="male">Male</html:option>
							<html:option value="female">Female</html:option>
						</html:select>
					</td>
				</tr>
				<tr>
					<td><label>Martial Status </label></td>
					<td><html:select property = "maritalStatus">
							<html:option value="">- Select One -</html:option>   	
							<html:option value="single">Single</html:option>
							<html:option value="married">Married</html:option>
							<html:option value="divorced">Divorced</html:option>
						</html:select>
					</td>
				</tr>
				<tr>
					<td><label>Nationality</label></td>
					<td><html:text property = "nationality"/></td>
				</tr>
				<tr>
					<td><label>Address Line 1 </label></td>
					<td><html:text property = "addressLine1"/></td>
				</tr>
				<tr>
					<td><label>Address Line 2 </label></td>
					<td><html:text property = "addressLine2"/></td>
				</tr>
				<tr>
					<td><label>Town </label></td>
					<td><html:text property = "town"/></td>
				</tr>
				<tr>
					<td><label>State </label></td>
					<td><html:text property = "state"/></td>
				</tr>
				<tr>
					<td><label>Postal Code </label></td>
					<td><html:text property = "postCode" value=""/></td>
				</tr>
				<tr>
					<td><label>Phone Number </label></td>
					<td><html:text property = "phoneNumber"/></td>
				</tr>
				<tr>
					<td colspan="2"><html:submit value = "Save"></html:submit></td>
				</tr>
			</table>
		</center>
		</html:form>
		
	</body>
</html:html>
	</div>
	</div>
	</div>
	<!-- end content -->
	
<!-- end page -->

</body>
</html>

