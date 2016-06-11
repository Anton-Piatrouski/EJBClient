<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<tiles:insert definition="company-template">
	<tiles:put name="body" value="/pages/customer/customer-body.jsp"/>
</tiles:insert>