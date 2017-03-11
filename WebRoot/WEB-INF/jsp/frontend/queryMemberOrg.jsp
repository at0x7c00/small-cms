<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<c:choose>
	<c:when test="${ empty tempBean}">
		没有查询到结果.
	</c:when>
	<c:otherwise>
		<table width="100%" cellpadding="5px">
 				<tr>
 					<td width="100px" style="text-align: right">公司名称：</td>
 					<td>
 						<strong style="color:#56a5f9;">${tempBean.name}</strong>
 					</td>
 				</tr>
 				<tr>
 					<td width="100px" style="text-align: right">合作期限：</td>
 					<td>
 						<fmt:formatDate value="${tempBean.corporateFrom}" pattern="yyyy-MM-dd"/>至<fmt:formatDate value="${tempBean.corporateTo}" pattern="yyyy-MM-dd"/>
 					</td>
 				</tr>
 				<tr>
 					<td colspan="2" style="text-align:center;">
 						<c:if test="${not empty tempBean.certFile }">
 						<img alt="" src="${basePath}filee/viewPic.do?manageKey=${tempBean.certFile.manageKey}" style="height:200px;width:auto;"/>
 						</c:if>
 					</td>
 				</tr>
 			</table>
	</c:otherwise>
</c:choose>
