<%@ taglib uri="/tags/struts-bean" prefix="b"%>
<%@ taglib uri="/tags/struts-html" prefix="h"%>

<div class="content">
	<div class="page-header">
		<h1><b:message key="login.jsp.content.header"/></h1>
	</div>
	<h:form action="/Login.do" focus="userName">
		<label for=""><b:message key="login.jsp.prompt.user"/></label>
		<div class="input-alert-group">
			<h:text styleClass="form-control" property="userName" size="20"/>
			<div class="alert alert-warning" role="alert"><h:errors property="userName"/></div>
		</div>
		
		<label for=""><b:message key="login.jsp.prompt.password"/></label>
		<div class="input-alert-group">
			<h:password styleClass="form-control" property="password" size="20"/>
			<div class="alert alert-warning" role="alert"><h:errors property="password"/></div>
		</div>
		
		<div class="alert alert-danger" role="alert"><h:errors property="failure"/></div>
		<div>
			<h:submit styleClass="btn btn-success"><b:message key="login.jsp.prompt.submit"/></h:submit>
		</div>
	</h:form>
</div>