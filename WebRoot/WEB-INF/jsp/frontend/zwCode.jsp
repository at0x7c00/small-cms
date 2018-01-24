<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<c:choose>
	<c:when test="${ empty tempBean}">
		<h4 style="text-align:center;">没有查询到结果.</h4>
	</c:when>
	<c:otherwise>
		<table width="100%" cellpadding="5px" border="0">
 				<tr>
 					<td style="text-align:center;">
	 					<strong style="color:#0b68b0;font-size:20px;">
	 					企业名称：
 						${tempBean.companyName}</strong>
 					</td>
 				</tr>
 				<tr>
 					<td style="text-align:center">
 						<img src="${basePath}filee/viewPic.do?manageKey=${tempBean.code.manageKey}"  style="height:400px;width:auto;"/>
 					</td>
 				</tr>
 				<tr>
 					<td style="text-align:center">在图片上单击右键选择“图片另存为”保存到电脑</td>
 				</tr>
 				
 				<tr>
 					<td style="text-align:center">
 						<a href="${basePath}filee/downloadFile.do?key=${tempBean.code.manageKey}" target="_blank" class="button lg">下载图片</a>
 						<a href="${basePath}api/code/download.do?key=${tempBean.manageKey}" target="_blank" class="button lg">漂浮窗代码</a>
 					</td>
 				</tr>
 			</table>
	</c:otherwise>
</c:choose>
