<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<td>${tempBean.id}</td>
<td>
<b style="display:block;font-size:1.3em;font-weight:400;">${tempBean.content}</b>
by ${tempBean.user} 
<c:if test="${not empty tempBean.email}">
| ${tempBean.email} 
</c:if>
<c:if test="${not empty tempBean.phone}">
| ${tempBean.phone} 
</c:if>
| <c:choose>
	<c:when test="${tempBean.replyStatus eq 'Yes' }">
		<span style="color:green;">已处理</span>
	</c:when>
	<c:otherwise>
		<span style="color:red;">未处理</span>
	</c:otherwise>
</c:choose>
<c:if test="${not empty tempBean.remark}">
| <i class="fa fa-comment-o">${tempBean.remark}</i>
</c:if>

</td>
<td><fmt:formatDate value="${tempBean.createTime}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/></td>
