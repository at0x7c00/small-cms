<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
		<c:if test="${not historyView}">
	<li>
		<a href="#codes" data-toggle="tab" <c:if test="${checkResult['code'].changed}">style="color:red;" </c:if>><spring:message code="props.me.huqiao.smallcms.ppll.entity.ZwCode.code"/></a>
	</li>
		</c:if>