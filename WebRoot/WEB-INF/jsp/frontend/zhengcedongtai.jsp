<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<%@include file="/WEB-INF/jsp/frontend/common/resource.jsp" %>
  	</head>
  
  <body>
  		<div class="container">
  			
			<%@include file="/WEB-INF/jsp/frontend/common/header.jsp" %>
	  		
	  		<div class="main-content">
	  			<div class="module-group">
		  			<div class="module left lg">
		  				<div class="module-title">
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/zhengce-2.png">
		  				</div>
		  				<div class="module-header">
		  				</div>
		  				<ul class="module-content">
		  					<c:forEach items="${page.list}" var="chapter" varStatus="s">
			  					<li><a href="${basePath}frontend/chapterDetail.do?k=${chapter.manageKey}"  target="_blank" title="${chapter.title}"><n:shorthand length="30" content="${chapter.title}"></n:shorthand> </a></li>
			  					<c:if test="${s.count%5==0}">
			  						<li class="devider"></li>
			  					</c:if>
		  					</c:forEach>
		  				</ul>
		  				
		  				<div class="page-bar">
		  					<c:if test="${page.pageNum>1}">
		  						<a href="${basePath}frontend/zhengcedongtai.do?pageNum=${page.pageNum-1}" style="padding-left:15px;padding-right:15px;">&lt;</a>
		  					</c:if>
		  					<c:forEach items="${page.pageBarIndex}" var="x"> 
			  					<a href="${basePath}frontend/zhengcedongtai.do?pageNum=${x}" class="${x eq page.pageNum ? 'active':'' }">${x}</a>
		  					</c:forEach>
		  					
		  					<c:if test="${page.pageNum<page.countPage}">
			  					<a href="${basePath}frontend/zhengcedongtai.do?pageNum=${page.pageNum+1}" style="padding-left:15px;padding-right:15px;">&gt;</a>
		  					</c:if>
		  				</div>
		  				
		  			</div>
		  			
		  			<div class="module right blue">
		  				<div class="module-title">
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/zhiliangredian-left.png">
		  				</div>
		  				<div class="module-header">
		  					<a class="more" href="${basePath}frontend/zhiliangredian.do"></a>
		  				</div>
		  				<ul class="module-content">
		  					<c:forEach items="${zhiliangredianList}" var="chapter">
			  					<li><a href="${basePath}frontend/chapterDetail.do?k=${chapter.manageKey}"  target="_blank" title="${chapter.title}"><n:shorthand length="15" content="${chapter.title}"></n:shorthand> </a></li>
		  					</c:forEach>
		  				</ul>
		  			</div>
		  			
		  			
		  			<div class="module right blue" style="margin-top:32px;">
		  				<div class="module-title">
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/hangye-left.png">
		  				</div>
		  				<div class="module-header">
		  					<a class="more" href="${basePath}frontend/hangyezixun.do"></a>
		  				</div>
		  				<ul class="module-content">
		  					<c:forEach items="${hangyezixunList}" var="chapter"> 
			  					<li>
			  					<a href="${basePath}frontend/chapterDetail.do?k=${chapter.manageKey}"  target="_blank" title="${chapter.title}"><n:shorthand length="15" content="${chapter.title}"></n:shorthand> </a>
			  					</li>
		  					</c:forEach>
		  				</ul>
		  			</div>
	  			</div>
		  		
		  		<%@include file="/WEB-INF/jsp/frontend/common/footer.jsp" %>
		  		
	  		</div>
	  		
  		</div>
 		<%@include file="/WEB-INF/jsp/frontend/common/js.jsp" %>
  </body>
</html>
