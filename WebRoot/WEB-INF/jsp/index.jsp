<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en-us">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title> ${systemTitle}-首页 </title>
		<%@include file="/WEB-INF/jsp/frontend/common/resource.jsp" %>
		
		<link rel="stylesheet" type="text/css" media="screen" href="${basePath}js/image-flow/style.css">
		<script src="${basePath}js/image-flow/image-flow.js"></script>
  	</head>
   
  <body>
  		<div class="container">
  			
			<%@include file="/WEB-INF/jsp/frontend/common/header.jsp" %>
	  		
	  		<div class="main-content">
	  			<div class="module-group"  style="min-height:370px;">
		  			<div class="module left">
		  				<div class="module-title">
		  					新闻动态
		  				</div>
		  				<div class="module-header">
		  					<a class="more" href="${basePath}zhengcedongtai.do"></a>
		  				</div>
		  				<ul class="module-content">
		  					<c:forEach items="${zhengcedongtaiList}" var="chapter">
			  					<li>
			  					<font class="title-prefix">■</font>
			  					<a href="${basePath}chapterDetail.do?k=${chapter.manageKey}"  target="_blank" title="${chapter.title}"><n:shorthand length="30" content="${chapter.title}"></n:shorthand> </a></li>
		  					</c:forEach>
		  				</ul>
		  			</div>
		  			
		  			<div class="module right">
		  				<div class="module-title">
		  					质量热点
		  				</div>
		  				<div class="module-header">
		  					<a class="more" href="${basePath}zhiliangredian.do"></a>
		  				</div>
		  				<ul class="module-content">
		  					<c:forEach items="${zhiliangredianList}" var="chapter">
			  					<li>
			  					<font class="title-prefix">■</font>
			  					<a href="${basePath}chapterDetail.do?k=${chapter.manageKey}"  target="_blank" title="${chapter.title}"><n:shorthand length="30" content="${chapter.title}"></n:shorthand> </a></li>
		  					</c:forEach>
		  				</ul>
		  			</div>
	  			</div>
	  			
	  			<div class="module-group">
		  			<div class="module full-page">
		  				<div class="module-title">
		  					会员风采
		  				</div>
		  				<div class="module-header">
		  					<a class="more" href="${basePath}huiyuanfengcai.do"></a>
		  				</div>
		  				<div>	
		  					<table width="100%" border="0">
		  						<tr>
		  							<td width="590px" style="text-align:center;">
		  								<a href="${basePath}chapterDetail.do?k=${huiyuanfengcaiList[0].manageKey}" target="_blank">
				  								<img alt="" style="width:550px;height:270px;" src="${basePath}filee/viewPic.do?manageKey=${huiyuanfengcaiList[0].cover.manageKey}">
		  								</a>
		  							</td>
		  							<td>
		  								<ul class="module-content" style="padding-left:5px;">
						  					<c:forEach items="${huiyuanfengcaiList}" var="chapter">
							  					<li>
							  					<font class="title-prefix">■</font>
							  					<a href="${basePath}chapterDetail.do?k=${chapter.manageKey}"  target="_blank" title="${chapter.title}"><n:shorthand length="30" content="${chapter.title}"></n:shorthand> </a></li>
						  					</c:forEach>
						  				</ul>
		  							</td>
		  						</tr>
		  					</table>
		  				</div>
		  			</div>
		  		</div>
		  		
		  		<div class="module-group" style="min-height:243px;">
		  			<div class="module full-page">
		  				<div class="module-title">
		  					质量热点
		  				</div>
		  				<div class="module-header">
		  					<a class="more" href="${basePath}zhiliangdangan.do"></a>
		  				</div>
		  				
		  				<div class="module-content" style="padding-bottom:10px;position:relative;" >
		  				
		  				
		  				<span id="btn-left" class="btn btn-left"></span>
		  				<span id="btn-right" class="btn btn-right"></span>
					  <div id="image-flow">
					    <ul id="image-flow-ul">
					      <c:forEach items="${qualityArchiveList }" var="qa">
					      	<li>
					      	<a href="${basePath}dangan.do?id=${qa.id}" target="_blank" title="${qa.title}">
					      	<img src="${basePath}filee/viewPic.do?manageKey=${qa.cover.manageKey}">
					      	</a>
					      	<a href="${basePath}dangan.do?id=${qa.id}" target="_blank" title="${qa.title}">
							<span>
							<n:shorthand length="14" content="${qa.title}"></n:shorthand>
							</span>					
							</a>
					      	</li>
					      </c:forEach>
					    </ul>
					  </div>
		  				
		  				
		  				</div>
		  				
		  			</div>
		  		</div>
		  		
		  		<div class="module-group">
		  			<div class="module full-page">
		  				<div class="module-title">
		  					行业资讯
		  				</div>
		  				<div class="module-header">
		  					<a class="more" href="${basePath}hangyezixun.do"></a>
		  				</div>
		  				<ul class="module-content bordered">
		  					<c:forEach items="${hangyezixunList}" var="chapter"> 
			  					<li>
			  					<font class="title-prefix">■</font>
			  					<a href="${basePath}chapterDetail.do?k=${chapter.manageKey}"  target="_blank" title="${chapter.title}"><n:shorthand length="50" content="${chapter.title}"></n:shorthand> </a>
			  					<span class="publish-date"><fmt:formatDate value="${chapter.createTime}" pattern="yyyy/MM/dd"/></span>
			  					</li>
		  					</c:forEach>
		  				</ul>
		  			</div>
		  		</div>
		  		
		  		
		  		<div class="module-group"  style="min-height:73px;">
		  			<div class="module full-page">
		  				<div class="module-title">
		  					品牌展示
		  				</div>
		  				<div class="module-header">
		  				</div>
		  				<div class="module-content" style="height:280px;width:1240px;overflow: hidden;">
		  					<c:forEach items="${brandList}" var="bList" varStatus="bs">
		  						<div class="brand-table">
			  						<c:forEach items="${bList}" var="bPair">
			  							<div>
					  						<c:forEach items="${bPair}" var="b" varStatus="s">
					  						<c:if test="${not empty b }">
						  						<img src="${basePath}filee/viewPic.do?manageKey=${b.logo.manageKey}" 
						  						title="${b.name }" data-href="${b.url}"
						  						class="img${s.count}"/>
						  					</c:if>
						  					</c:forEach>
					  					</div>
				  					</c:forEach>
		  						</div>
		  					</c:forEach>
		  				</div>
		  			</div>
		  		</div>
		  		
		  		<div class="module-group"  style="min-height:73px;">
		  			<div class="module full-page">
		  				<div class="module-title">
		  				友情链接
		  				</div>
		  				<div class="module-header">
		  				</div>
		  				<div class="module-content">
		  					<c:forEach items="${flinkList}" var="flink">
			  					<a href="${flink.url}" target="_blank" style="font-family:'SourceHanSansCN-Light';font-size:20px;color:#444;">${flink.name}</a>
		  					</c:forEach>
		  				</div>
		  			</div>
		  		</div>
		  		
		  		<%@include file="/WEB-INF/jsp/frontend/common/footer.jsp" %>
		  		
	  		</div>
	  		
  		</div>
 		<%@include file="/WEB-INF/jsp/frontend/common/js.jsp" %>
 		<script type="text/javascript">
 		var bindex = 0;
 		$(function(){
 			displayBrand();
 			window.setInterval(function(){
 				displayBrand();
 			},15000);
 			
 			$(".img1,.img2").click(function(){
 				if($(this).data("href")){
	 				window.open($(this).data("href"));
 				}
 			});
 		});
 		function displayBrand(){
 				var divs = $(".brand-table");
 				if(divs.length<=1){
 					return;
 				}
 				divs.removeClass("current_mark");
 				divs.find("img").removeClass("img1").removeClass("img2");
 				divs.animate({marginLeft:"-1500px"},500);
 				
 				window.setTimeout(function(){
 					divs.fadeOut(100);
 	 				divs.animate({marginLeft:"2000px"},0);
 					var count = 0;
 					while(bindex<divs.length){
 						count++;
 						$(divs.eq(bindex)).addClass("current_mark");
 						bindex++; 
 						if(count>2){
 							break;
 						}
 					}
 					window.setTimeout(function(){
	 					$("div.current_mark").fadeIn(200).animate({marginLeft:"0px"},500);
	 					if(bindex>=divs.length){
	 						bindex = 0;
	 					}
	 					window.setTimeout(function(){
		 					divs.find("div>img:first-child").addClass("img1");
		 					divs.find("div>img:last-child").addClass("img2");
	 					},500);
 					},100);
 				},200);
 		}
 		</script>
  </body>
</html>
