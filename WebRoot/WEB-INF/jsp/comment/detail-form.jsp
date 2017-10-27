<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['user'].changed}">title= "${checkResult['user'].info}";</c:if>
						   >
			<span class="${checkResult['user'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Comment.user"/>:
									<c:out value="${tempBean.user}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['remark'].changed}">title= "${checkResult['remark'].info}";</c:if>
						   >
			<span class="${checkResult['remark'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Comment.remark"/>:
									<c:out value="${tempBean.remark}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['phone'].changed}">title= "${checkResult['phone'].info}";</c:if>
						   >
			<span class="${checkResult['phone'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Comment.phone"/>:
									<c:out value="${tempBean.phone}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['email'].changed}">title= "${checkResult['email'].info}";</c:if>
						   >
			<span class="${checkResult['email'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Comment.email"/>:
									<c:out value="${tempBean.email}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['content'].changed}">title= "${checkResult['content'].info}";</c:if>
						   >
			<span class="${checkResult['content'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Comment.content"/>:
									<c:out value="${tempBean.content}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['createTime'].changed}">title= "${checkResult['createTime'].info}";</c:if>
						   >
			<span class="${checkResult['createTime'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Comment.createTime"/>:
									<fmt:formatDate value="${tempBean.createTime}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['replyStatus'].changed}">title= "${checkResult['replyStatus'].info}";</c:if>
						   >
			<span class="${checkResult['replyStatus'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Comment.replyStatus"/>:
								${yesNoMap[tempBean.replyStatus]}
			</span>
		</label>
	</section>