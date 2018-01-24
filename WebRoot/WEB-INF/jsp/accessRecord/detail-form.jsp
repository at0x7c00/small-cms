<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['key'].changed}">title= "${checkResult['key'].info}";</c:if>
						   >
			<span class="${checkResult['key'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.AccessRecord.key"/>:
									<c:out value="${tempBean.key}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['accessTime'].changed}">title= "${checkResult['accessTime'].info}";</c:if>
						   >
			<span class="${checkResult['accessTime'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.AccessRecord.accessTime"/>:
									<fmt:formatDate value="${tempBean.accessTime}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['url'].changed}">title= "${checkResult['url'].info}";</c:if>
						   >
			<span class="${checkResult['url'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.AccessRecord.url"/>:
									<c:out value="${tempBean.url}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['origin'].changed}">title= "${checkResult['origin'].info}";</c:if>
						   >
			<span class="${checkResult['origin'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.AccessRecord.origin"/>:
									<c:out value="${tempBean.origin}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['ip'].changed}">title= "${checkResult['ip'].info}";</c:if>
						   >
			<span class="${checkResult['ip'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.AccessRecord.ip"/>:
									<c:out value="${tempBean.ip}"/>
			</span>
		</label>
	</section>