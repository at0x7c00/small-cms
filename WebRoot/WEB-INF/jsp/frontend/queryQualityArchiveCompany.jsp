<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<c:choose>
	<c:when test="${ empty tempBean}">
		没有查询到结果.
	</c:when>
	<c:otherwise>
		<table width="100%" cellpadding="5px">
				<tr>
 					<td colspan="2">
 						档案号：${tempBean.archiveId }
 					</td>
 				</tr>
 				<tr>
 					<td colspan="2">
 						公司名称：<strong style="color:#56a5f9;">${tempBean.name}</strong>
 					</td>
 				</tr>
 				<tr>
 					<td colspan="2">
 						法人代表：${tempBean.lawPerson }
 					</td>
 				</tr>
 				<tr>
 					<td colspan="2">
 						企业所在地：${tempBean.address }
 					</td>
 				</tr>
 				<tr>
 					<td colspan="2">
 						收录年限：<fmt:formatDate value="${tempBean.timeStart }" pattern="yyyy年MM月"/>-
 						<fmt:formatDate value="${tempBean.timeEnd }" pattern="yyyy年MM月"/>
 					</td>
 				</tr>
 				
 				<tr>
 					<td width="50%" style="text-align: right;vertical-align: top;">
 						<div>
 						<img alt="" src="${basePath}filee/viewPic.do?manageKey=${tempBean.license.manageKey}" class="query-pic" style="cursor:pointer;">
 						</div>
 					</td>
 					
 					<td>
 						<div>
 						<img alt="" src="${basePath}filee/viewPic.do?manageKey=${tempBean.apply.manageKey}" class="query-pic" style="cursor:pointer;">
 						</div>
 					</td>
 				</tr>
 				<tr>
 					<td width="50%" style="text-align: right;vertical-align: top;">
 						<div style="text-align: center;">
 						营业执照
 						</div>
 					</td>
 					
 					<td>
 						<div  style="text-align: center;">
 						入档申请表
 						</div>
 					</td>
 				</tr>
 			</table>
	</c:otherwise>
</c:choose>
