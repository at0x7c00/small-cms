<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['archiveId'].changed}">title= "${checkResult['archiveId'].info}";</c:if>
						   >
			<span class="${checkResult['archiveId'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Company.archiveId"/>:
									<c:out value="${tempBean.archiveId}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['name'].changed}">title= "${checkResult['name'].info}";</c:if>
						   >
			<span class="${checkResult['name'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Company.name"/>:
									<c:out value="${tempBean.name}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['lawPerson'].changed}">title= "${checkResult['lawPerson'].info}";</c:if>
						   >
			<span class="${checkResult['lawPerson'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Company.lawPerson"/>:
									<c:out value="${tempBean.lawPerson}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['address'].changed}">title= "${checkResult['address'].info}";</c:if>
						   >
			<span class="${checkResult['address'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Company.address"/>:
									<c:out value="${tempBean.address}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['timeStart'].changed}">title= "${checkResult['timeStart'].info}";</c:if>
						   >
			<span class="${checkResult['timeStart'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Company.timeStart"/>:
									<fmt:formatDate value="${tempBean.timeStart}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['timeEnd'].changed}">title= "${checkResult['timeEnd'].info}";</c:if>
						   >
			<span class="${checkResult['timeEnd'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Company.timeEnd"/>:
									<fmt:formatDate value="${tempBean.timeEnd}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['license'].changed}">title= "${checkResult['license'].info}";</c:if>
						   >
			<span class="${checkResult['license'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Company.license"/>:
									${tempBean.license}
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['apply'].changed}">title= "${checkResult['apply'].info}";</c:if>
						   >
			<span class="${checkResult['apply'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Company.apply"/>:
									${tempBean.apply}
			</span>
		</label>
	</section>