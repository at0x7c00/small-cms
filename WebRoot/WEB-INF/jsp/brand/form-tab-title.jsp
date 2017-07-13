<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
		<c:if test="${not historyView}">
	<li>
		<a href="#logos" data-toggle="tab" <c:if test="${checkResult['logo'].changed}">style="color:red;" </c:if>><spring:message code="props.me.huqiao.smallcms.ppll.entity.Brand.logo"/></a>
	</li>
		</c:if>