<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['name'].changed}">title= "${checkResult['name'].info}";</c:if>
						   >
			<span class="${checkResult['name'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchiveCategory.name"/>:
									<c:out value="${tempBean.name}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['orderNum'].changed}">title= "${checkResult['orderNum'].info}";</c:if>
						   >
			<span class="${checkResult['orderNum'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchiveCategory.orderNum"/>:
									<c:out value="${tempBean.orderNum}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['status'].changed}">title= "${checkResult['status'].info}";</c:if>
						   >
			<span class="${checkResult['status'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchiveCategory.status"/>:
								${useStatusMap[tempBean.status]}
			</span>
		</label>
	</section>