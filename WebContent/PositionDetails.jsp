<%@page errorPage="Error.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Position-Add</title>

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
<% session.setAttribute("ErrorSource","PositionDetails");%>


<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title></title>
	</head>
	<body>
		
		<html:form  action = "position">
		<center>
		<h3> Enter Position Details</h3>
		<br></br>
		<table>
	<tr>
                    <td><label>BU Name </label></td>
                    <td><html:text property = "bu_name"> </html:text>        
                             </td>
                </tr>
	<tr>
                    <td><label>Job Tiltle </label></td>
                    <td><html:text property = "job_title">
                                  </html:text>
                    </td>
                </tr>
	<tr>
	<td> Position ID</td>
	<td><html:text property="posn_id" ></html:text></td>
	</tr>
	<tr>
	<td> Position Description</td>
	<td><html:text property="posn_title" ></html:text></td>
	</tr>
	<tr>
                    <td><label>Start Date </label></td>
                   
                       <td>Date:&nbsp;&nbsp;<html:select property="startDay">
                           <html:option value="">-Date-</html:option>                          
                           <c:forEach begin="1" end="31" var="date">
                               <html:option value="${date}"/>
                           </c:forEach>
                           </html:select>
                           &nbsp;&nbsp;Month:&nbsp;&nbsp;<html:select property="startMonth">
                           <html:option value="">-Month-</html:option>                          
                           <c:forEach begin="1" end="12" var="month">
                               <html:option value="${month}"/>
                           </c:forEach>
                           </html:select>
                           &nbsp;&nbsp;Year:&nbsp;&nbsp;<html:select property="startYear">
                           <html:option value="">-Year-</html:option>                          
                           <c:forEach begin="1965" end="2050" var="year">
                               <html:option value="${year}"/>
                           </c:forEach>
                           </html:select>
                       </td>
                </tr>
               <tr>
                    <td><label>End Date </label></td>
                   
                       <td>Date:&nbsp;&nbsp;<html:select property="endDay">
                           <html:option value="">-Date-</html:option>                          
                           <c:forEach begin="1" end="31" var="date">
                               <html:option value="${date}"/>
                           </c:forEach>
                           </html:select>
                           &nbsp;&nbsp;Month:&nbsp;&nbsp;<html:select property="endMonth">
                           <html:option value="">-Month-</html:option>                          
                           <c:forEach begin="1" end="12" var="month">
                               <html:option value="${month}"/>
                           </c:forEach>
                           </html:select>
                           &nbsp;&nbsp;Year:&nbsp;&nbsp;<html:select property="endYear">
                           <html:option value="">-Year-</html:option>                          
                           <c:forEach begin="1965" end="2011" var="year">
                               <html:option value="${year}"/>
                           </c:forEach>
                           </html:select>
                       </td>
                </tr>
                <tr>
                    <td><label>Status Code </label></td>
                    <td><html:select property = "posn_status_code">
                            <html:option value="">- Select One -</html:option>      
                            <html:option value="closed">closed</html:option>
                            <html:option value="Open">Open</html:option>
                            <html:option value="Frozen">Frozen</html:option>
                         </html:select>
                    </td>
                </tr>
	<tr>
	<td></td>
	<td><html:submit value = "Save"></html:submit></td></tr></table>
	</center>
	<br></br>
	<br></br>
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

