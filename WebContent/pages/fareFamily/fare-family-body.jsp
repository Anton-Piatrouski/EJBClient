<%@ taglib prefix="ctg" uri="customtags"%>
<%@ taglib uri="/jstl/core" prefix="c"%>
<%@ taglib uri="/tags/struts-bean" prefix="b"%>

<div class="content">
	<div class="page-header">
		<h1><b:message key="fare.jsp.content.header"/></h1>
	</div>
	
	<ctg:fareFamilyInfo var="fareFamily"/> 
	
	<c:set var="components" scope="page" value="${fareFamily.ancillaryAirComponents}"/>
	
	<table class="table table-striped">
		<tr>
			<td><b:message key="fare.jsp.prompt.fareCode"/></td>
			<td><c:out value="${fareFamily.fareFamilyCode}"/></td>
		</tr>
		
		<c:forEach var="component" items="${components}">
			<tr>
				<td><b:message key="fare.jsp.prompt.airCompCode"/></td>
				<td><c:out value="${component.ancillaryAirComponentCode}"/></td>
			</tr>
		</c:forEach>
	</table>
</div>