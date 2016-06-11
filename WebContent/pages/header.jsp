<%@ taglib uri="/tags/struts-bean" prefix="b"%>
<%@ taglib uri="/tags/struts-html" prefix="h"%>
<%@ taglib uri="/jstl/core" prefix="c"%>

<nav class="navbar navbar-default navbar-static-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				<span class="sr-only">Toogle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="HomePage.do">StrutsClient</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<c:if test="${empty user}">
					<li><a href="LoginPage.do"><b:message key="menu.item.page.login"/></a></li>
				</c:if>
				<li><a href="ReservationPage.do"><b:message key="menu.item.page.reservation"/></a></li>
				<li><a href="CustomerPage.do"><b:message key="menu.item.page.customer"/></a></li>
				<li><a href="FareFamilyPage.do"><b:message key="menu.item.page.fareFamily"/></a></li>
			</ul>

			<c:if test="${not empty user}">
				<p class="navbar-text">
					<span class="label label-info"><c:out value="${user.name}"/></span>
				</p>
				<h:form styleClass="navbar-form navbar-left" action="/Logout.do">
					<h:submit styleClass="btn btn-default"><b:message key="menu.item.logout"/></h:submit>
				</h:form>
			</c:if>

			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><b:message key="menu.item.lang"/> <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="ChangeLocale.do?lang=en"><b:message key="menu.item.lang.en"/></a></li>
						<li><a href="ChangeLocale.do?lang=ru"><b:message key="menu.item.lang.ru"/></a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>
