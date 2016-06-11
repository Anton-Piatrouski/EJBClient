<%@ taglib prefix="ctg" uri="customtags"%>
<%@ taglib uri="/jstl/core" prefix="c"%>
<%@ taglib uri="/tags/struts-bean" prefix="b"%>

<div class="content">
	<div class="page-header">
		<h1><b:message key="reserv.jsp.content.header"/></h1>
	</div>
	
	<ctg:reservationInfo var="resComponents"/>
	
	<c:forEach var="component" items="${resComponents}">
		<table class="table table-striped">
			<tr>
				<td><b:message key="reserv.jsp.prompt.compCode"/></td>
				<td><c:out value="${component.componentTypeCode}"/></td>
			</tr>
			<tr>
				<td><b:message key="reserv.jsp.prompt.createDateTime"/></td>
				<td><c:out value="${component.createDateTime}"/></td>
			</tr>
			<tr>
				<td><b:message key="reserv.jsp.prompt.internalStatus"/></td>
				<td><c:out value="${component.internalStatus}"/></td>
			</tr>
			<tr>
				<td><b:message key="reserv.jsp.prompt.sequence"/></td>
				<td><c:out value="${component.sequence}"/></td>
			</tr>
		</table>
	</c:forEach>
</div>