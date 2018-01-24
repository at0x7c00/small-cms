<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<td>
	
	
	<div style="width:455px;height:305px;overflow: hidden;display:inline-block;float:left;">
		<c:if test="${not empty tempBean.cover }">
			<c:choose>
				<c:when test="${tempBean.cover.video}">
						视频:${tempBean.cover.name}
				</c:when>
				<c:otherwise>
					<img src="${basePath}filee/viewPic.do?manageKey=${tempBean.cover.manageKey}" style="width:455px;height:305px;"/>
				</c:otherwise>
			</c:choose>
		</c:if>
	</div>
	
	<div style="width:455px;height:305px;overflow: hidden;display:inline-block;float:left;padding:10px 20px;letter-spacing: 2px;fotn-size:14px;">
	<n:html value="${tempBean.content}"></n:html>
	<br/>
	<a href="${basePath}projectInfo/update.do?manageKey=${tempBean.manageKey}" 
	class="button"
	target="dialogTodo" title="修改项目简介">修改</a>
	</div>
	
	
	
	</td>
