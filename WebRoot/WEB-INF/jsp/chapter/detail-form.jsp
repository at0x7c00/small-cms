<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['creator'].changed}">title= "${checkResult['creator'].info}";</c:if>
						   >
			<span class="${checkResult['creator'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Chapter.creator"/>:
									${tempBean.creator.chineseName}
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['readCount'].changed}">title= "${checkResult['readCount'].info}";</c:if>
						   >
			<span class="${checkResult['readCount'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Chapter.readCount"/>:
									<c:out value="${tempBean.readCount}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['createTime'].changed}">title= "${checkResult['createTime'].info}";</c:if>
						   >
			<span class="${checkResult['createTime'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Chapter.createTime"/>:
									<fmt:formatDate value="${tempBean.createTime}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['title'].changed}">title= "${checkResult['title'].info}";</c:if>
						   >
			<span class="${checkResult['title'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Chapter.title"/>:
									<c:out value="${tempBean.title}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['content'].changed}">title= "${checkResult['content'].info}";</c:if>
						   >
			<span class="${checkResult['content'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Chapter.content"/>:
									<c:out value="${tempBean.content}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['page'].changed}">title= "${checkResult['page'].info}";</c:if>
						   >
			<span class="${checkResult['page'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Chapter.page"/>:
									${tempBean.page.name}
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['cover'].changed}">title= "${checkResult['cover'].info}";</c:if>
						   >
			<span class="${checkResult['cover'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Chapter.cover"/>:
									${tempBean.cover.name}
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['orderNum'].changed}">title= "${checkResult['orderNum'].info}";</c:if>
						   >
			<span class="${checkResult['orderNum'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Chapter.orderNum"/>:
									<c:out value="${tempBean.orderNum}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['status'].changed}">title= "${checkResult['status'].info}";</c:if>
						   >
			<span class="${checkResult['status'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Chapter.status"/>:
								${useStatusMap[tempBean.status]}
			</span>
		</label>
	</section>