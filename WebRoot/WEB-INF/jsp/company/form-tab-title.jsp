<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
		<c:if test="${not historyView}">
	<li>
		<a href="#licenses" data-toggle="tab" <c:if test="${checkResult['license'].changed}">style="color:red;" </c:if>><spring:message code="props.me.huqiao.smallcms.ppll.entity.Company.license"/></a>
	</li>
		</c:if>
		<c:if test="${not historyView}">
	<li>
		<a href="#applys" data-toggle="tab" <c:if test="${checkResult['apply'].changed}">style="color:red;" </c:if>><spring:message code="props.me.huqiao.smallcms.ppll.entity.Company.apply"/></a>
	</li>
		</c:if>