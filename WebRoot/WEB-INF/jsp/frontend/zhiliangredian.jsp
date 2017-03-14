<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<title>质量热点 - ${systemTitle}</title>
		<%@include file="/WEB-INF/jsp/frontend/common/resource.jsp" %>
  	</head>
  
  <body>
  		<div class="container">
  			
			<%@include file="/WEB-INF/jsp/frontend/common/header.jsp" %>
	  		
	  		<div class="main-content">
	  			<div class="module-group">
		  			<div class="module left lg">
		  				<div class="module-title">
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/zhiliangredian.png">
		  				</div>
		  				<div class="module-header">
		  				</div>
		  				<ul class="module-content">
		  					<%@include file="/WEB-INF/jsp/frontend/common/pageContent.jsp" %>
		  				</ul>
		  				
		  				 <jsp:include page="/WEB-INF/jsp/frontend/common/pageBar.jsp">
		  				 	<jsp:param value="${page}" name="page"/>
		  				 	<jsp:param value="frontend/zhiliangredian.do" name="url"/>
		  				 </jsp:include>
		  				
		  			</div>
		  			
		  			<div class="module right blue">
		  				<div class="module-title">
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/zhengce-left.png">
		  				</div>
		  				<div class="module-header">
		  					<a class="more" href="${basePath}frontend/zhengcedongtai.do"></a>
		  				</div>
		  				<ul class="module-content">
	  						<c:forEach items="${hangyezixunList}" var="chapter"> 
	  							<%@include file="/WEB-INF/jsp/frontend/common/left-panel-list.jsp" %>
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
		  						<%@include file="/WEB-INF/jsp/frontend/common/left-panel-list.jsp" %>
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
