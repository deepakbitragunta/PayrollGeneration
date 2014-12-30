<%@ page contentType="text/html; charset=UTF-8" errorPage="Error.jsp"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Pay Calendar Generate</title>

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
		<% session.setAttribute("ErrorSource","PayCalendarGenerate");%>
			<html:html>
			<center>
	<body>
	<h3> Enter payslip requirements</h3>
		<html:form action="payCalendarGenerate">
		<table>
		<tr>
		<td>
		Select Pay Frequency:
		</td>
		<td>
		<html:select property="payFrequency">
		<html:option value="">-PayFrequency-</html:option>
		<html:option value="Monthly"/>
		</html:select>
		</td>
		</tr>
		<tr>
		<td>
		Select Tax Year:
		</td>
		<td>
		<html:select property="taxYear">
		<html:option value="">-TaxYear-</html:option>                          
            <c:forEach begin="1965" end="2015" var="year">
            <html:option value="${year}"/>
            </c:forEach>
            </html:select>
         </td>
         </tr>
         </table>
         <center>		
		<html:submit value="Generate PayCalendar"></html:submit>
		</center>
		</html:form>
	</body>
	</center>
</html:html>

			</div>
		</div>
	</div>
	<!-- end content -->
	
</div>
<!-- end page -->

</body>
</html>



