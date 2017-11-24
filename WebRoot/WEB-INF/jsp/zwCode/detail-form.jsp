<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['companyName'].changed}">title= "${checkResult['companyName'].info}";</c:if>
						   >
			<span class="${checkResult['companyName'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.ZwCode.companyName"/>:
									<c:out value="${tempBean.companyName}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['code'].changed}">title= "${checkResult['code'].info}";</c:if>
						   >
			<span class="${checkResult['code'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.ZwCode.code"/>:
									${tempBean.code.name}
			</span>
		</label>
	</section>