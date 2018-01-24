<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['content'].changed}">title= "${checkResult['content'].info}";</c:if>
						   >
			<span class="${checkResult['content'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.ProjectInfo.content"/>:
									<c:out value="${tempBean.content}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['cover'].changed}">title= "${checkResult['cover'].info}";</c:if>
						   >
			<span class="${checkResult['cover'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.ProjectInfo.cover"/>:
									${tempBean.cover.name}
			</span>
		</label>
	</section>