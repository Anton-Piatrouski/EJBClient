<%@ taglib prefix="ctg" uri="customtags"%>
<%@ taglib uri="/jstl/core" prefix="c"%>
<%@ taglib uri="/tags/struts-bean" prefix="b"%>

<div class="content">
	<div class="page-header">
		<h1><b:message key="customer.jsp.content.header"/></h1>
	</div>
	
	<ctg:customerInfo var="customer"/> 
	
	<c:set var="payments" scope="page" value="${customer.payments}"/>
	
	<table class="table table-striped">
		<tr>
			<td><b:message key="customer.jsp.prompt.firstName"/></td>
			<td><c:out value="${customer.firstName}"/></td>
		</tr>
		<tr>
			<td><b:message key="customer.jsp.prompt.lastName"/></td>
			<td><c:out value="${customer.lastName}"/></td>
		</tr>
		<tr>
			<td><b:message key="customer.jsp.prompt.emailAddr"/></td>
			<td><c:out value="${customer.emailAddress}"/></td>
		</tr>
		<tr>
			<td><b:message key="customer.jsp.prompt.phoneNumber"/></td>
			<td><c:out value="${customer.phoneNumber}"/></td>
		</tr>
		
		<c:forEach var="payment" items="${payments}">
			<tr>
				<td><b:message key="customer.jsp.prompt.amountPaid"/></td>
				<td><c:out value="${payment.amountPaid}"/></td>
			</tr>
			<tr>
				<td><b:message key="customer.jsp.prompt.paymentCode"/></td>
				<td><c:out value="${payment.formOfPaymentTypeCode}"/></td>
			</tr>
			<tr>
				<td><b:message key="customer.jsp.prompt.currencyCode"/></td>
				<td><c:out value="${payment.currencyCode}"/></td>
			</tr>
		</c:forEach>
	</table>
</div>