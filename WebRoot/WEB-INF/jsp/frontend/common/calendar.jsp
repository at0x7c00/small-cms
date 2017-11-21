<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="pic-calendar">
	<div class="cal-bar">
		<ul>
			<c:forEach items="${page.list}"  varStatus="s">
			<c:if test="${s.count<6}">
			<li data-index="${s.index}"><fmt:formatNumber value="${s.count}" pattern="##"></fmt:formatNumber> </li>
			</c:if>
			</c:forEach>
			
		</ul>
	</div>
	<ul class="cal-imgs">
		<c:forEach items="${page.list}" var="chapter" varStatus="s">
			<c:if test="${s.count<6}">
				<li>
					<img src="${basePath}filee/viewPic.do?manageKey=${chapter.largeCoverFirst.manageKey}" data-url="${basePath}chapterDetail.do?k=${chapter.manageKey}"/>
				</li>
			</c:if>
		</c:forEach>
	</ul>
</div>