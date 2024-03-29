<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>
<section id="widget-grid" class="">
	<div class="row">
		<article class="col-sm-12 col-md-12 col-lg-12">
			<form:form method="post" action="company/add.do"
					   class="smart-form required-validate" commandName="company"
				onsubmit="return validateCallback(this, ${targetPanel eq 'dialog' ? 'dialog' :'navTab' }AjaxDone);">
				<input type="hidden" name="targetPanel" value="${targetPanel}"/>
				<ul id="myTab1" class="nav nav-tabs bordered">
					<li class="active"><a href="#baseProperties" data-toggle="tab"><spring:message code="base.common.form.props"/></a></li>
					<%@include file="/WEB-INF/jsp/company/form-tab-title.jsp" %>
				</ul>
				<div id="myTabContent1" class="tab-content">
					<div class="tab-pane fade in active" id="baseProperties">	
						<fieldset>
							<div class="row">
								<%@include file="/WEB-INF/jsp/company/add-form.jsp" %>
							</div>
						</fieldset>
					</div>
					<%@include file="/WEB-INF/jsp/company/add-x2many-form.jsp" %>
				</div>
				<footer>
					<button type="submit" class="btn btn-primary smart-form-submit-btn">
						<spring:message code="base.common.ok"></spring:message>
					</button>
					<button type="button" class="btn btn-default btn-cancel" data-targetpanel = "${targetPanel}">
						<spring:message code="base.common.cancel"></spring:message>
					</button>
				</footer>
			</form:form>
		</article>
	</div>
</section>
<%@include  file="/WEB-INF/jsp/common/pageSetJS.jsp"%>