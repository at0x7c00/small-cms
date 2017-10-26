<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<title>质量档案 - ${systemTitle}</title>
		<%@include file="/WEB-INF/jsp/frontend/common/resource.jsp" %>
		<script src="${basePath}js/jqueryui/1.10.3/jquery-ui.min.js"></script>
		<link rel="stylesheet" type="text/css" media="screen" href="${basePath}js/jqueryui/1.10.3/css/jquery-ui-1.10.4.custom.min.css">
		<style type="text/css">
		.qa-search-div>span[role=status]{
			position: absolute;
			left:270px;
			padding:5px;
			background: #fff;
			top:2px;
			height:20px;
			line-height:20px;
		}
		</style>
  	</head>
  
  <body class="dangan">
 		<%@include file="/WEB-INF/jsp/frontend/common/logo-and-menu-dangan.jsp" %>
  		<div class="container">
 			
 			<!-- <div style="position:relative;" class="qa-search-div">
 			<input name="key" placeholder="输入关键字进行搜索" style="height:20px;width:250px;font-size:14px;line-height:20px;padding:5px;" id="keySearch"/>
 			</div> -->
 			
	  		<div class="main-content" style="margin-top: -30px;">
	  		
	  			<div class="module-group blue">
	  			
	  			
	  				<div>
	  					<h1 class="page-title">项目简介<a name="project"></a></h1>
	  					<p style="text-indent: 2em;">
	  					质量档案是在国家质检总局的指导下，由中国质量万里行促进会开展的项目，用于收录优秀质量企业信息，旨在推进国家质量体系建设，健全质量信息收集与发布制度。质量发展是兴国之道、强国之策，它既是企业和产业核心竞争力的体现，也是国家综合实力的体现。建立全国企业的优秀质量档案是国家质量体系建设的重要基础工作，也是社会质量信息互动平台建设的重要组成部分。
						</p>
	  				</div>
	  				
	  				<div>
	  					<h1 class="page-title">质量强企<a name="qy"></a></h1>
	  					
	  					<div>
	  						<div class="lunbo" style="width:455px;height:360px;display:inline-block;" id="lunbo1">
								<ul class="lb-imgs">
									<c:forEach items="${page.list}" var="chapter">
							        <li>
							        <a href="${basePath}chapterDetail.do?k=${chapter.manageKey}" target="_blank">
							        	<img data-u="image" src="${basePath}filee/viewPic.do?manageKey=${chapter.cover.manageKey}" title="${chapter.title}" data-url="${basePath}chapterDetail.do?k=${chapter.manageKey}"/>
							        </a>
							        </li>
							        </c:forEach>
								</ul>
								<ul class="lb-remarks">
										<c:forEach items="${page.list}" var="chapter">
											<li data-url="${basePath}chapterDetail.do?k=${chapter.manageKey}">
												<a href="${basePath}chapterDetail.do?k=${chapter.manageKey}" target="_blank">
													${chapter.title}
												</a>
											</li>
										</c:forEach>
								</ul>
								<div class="controller prev"><i class="fa fa-angle-left"></i></div>
								<div class="controller next"><i class="fa fa-angle-right"></i></div>
								
								<div class="pointer">
								<c:forEach items="${page.list}" var="chapter">
								<div ><i class="fa fa-circle"></i></div>
								</c:forEach>
								</div>
								
							</div>
							
							<ul class="module-content" style="width:720px;display: inline-block;float:right;margin-top:0px;padding-top:0px;">
		  					<c:forEach items="${page.list}" var="chapter">
			  					<li style="list-style-type: disc;">
			  					<a href="${basePath}chapterDetail.do?k=${chapter.manageKey}"  target="_blank" title="${chapter.title}"><n:shorthand length="33" content="${chapter.title}"></n:shorthand> </a>
			  					</li>
		  					</c:forEach>
		  				</ul>
							
	  					</div>
	  					
	  				</div>
	  				
	  				<div>
	  					<h1 class="page-title">质量档案<a name="qa"></a></h1>
	  					
	  					<div>
		  					<div class="brand-table-wrap" style="position: relative;">
		  						<div class="brand-table">
		  							<div class="img-container" style="width:${bWidth}px">
				  					<c:forEach items="${page.list}" var="b" varStatus="s">
				  						<c:forEach begin="0" end="30">
				  						<div class="img-wrap">
				  						<img src="${basePath}filee/viewPic.do?manageKey=${b.cover.manageKey}" 
				  						title="${b.title }" data-key="${b.id}" />
				  						<div><n:shorthand length="10" content="${b.title}"></n:shorthand> </div>
				  						</div>
				  						</c:forEach>
				  					</c:forEach>
		  							</div>
		  							
		  						</div>
	  							<div class="ctr prev"></div>
	  							<div class="ctr next"></div>
		  					</div>
	  					</div>
	  					
	  				</div>
	  				
	  				
	  				
	  				<%-- <div class="module-category">
	  					<div class="category-title">
	  						<a name="content"></a>
	  					</div>
	  					<div class="category-content">
	  						<c:forEach items="${categoryList }" var="c">
		  						<a href="${basePath}zhiliangdangan.do?categoryKey=${c.manageKey}#content" class="${category.manageKey eq c.manageKey ? 'active':'' }">${c.name}</a>
	  						</c:forEach>
	  					</div>
	  				</div> --%>
	  			
		  			
		  			<%-- <div class="dangan-content">
		  			<c:if test="${empty page.list}">
		  			暂无记录.
		  			</c:if>
		  			<c:forEach items="${page.list}" var="qa">
			  			<div class="dangan-detail">
			  				<div class="dangan-item">
			  					<div class="dangan-pic">
			  						<c:if test="${not empty qa.cover }">
				  						<a href="${basePath}dangan.do?id=${qa.id}" target="_blank">
					  						<img alt="" src="${basePath}filee/viewPic.do?manageKey=${qa.cover.manageKey}"/>
				  						</a>
			  						</c:if>
			  					</div>
			  					<div class="dangan-abstract" length="37">
			  						<a href="${basePath}dangan.do?id=${qa.id}" target="_blank"><n:html length="37" value="${qa.abstractContent}"></n:html>&nbsp;</a>
			  					</div>
			  				</div>
			  			</div>
			  			
		  			</c:forEach>
			  			<jsp:include page="/WEB-INF/jsp/frontend/common/pageBar.jsp">
		  				 	<jsp:param value="${page}" name="page"/>
		  				 	<jsp:param value="zhiliangdangan.do" name="url"/>
		  				 	<jsp:param value="categoryKey=${category.manageKey}" name="params"/>
		  				 </jsp:include>
		  			</div> --%>
		  			
	  			</div>
	  			
		  		
		  		
	  		</div>
	  		
  		</div>
	  	<%@include file="/WEB-INF/jsp/frontend/common/footer.jsp" %>
 		<%@include file="/WEB-INF/jsp/frontend/common/js.jsp" %>
 		<script type="text/javascript">
 		var imgContainerWidth = 0;
 		var brandInter = null;
 		var brandDirection = "left";
 		$(function(){
 			var imgSize = $(".img-container img").size();
 			var imgTotalWidth = (imgSize/2) * 240;
 			imgContainerWidth = $(".brand-table").width();
 			while(imgContainerWidth<imgTotalWidth){
 				imgContainerWidth += imgContainerWidth;
 			}
 			$(".img-container").css("width",imgContainerWidth+"px");
 			
 			
 			$(".brand-table-wrap .ctr.prev").click(function(){
 				brandDirection = "left";
 				stopBrandInter();
 				doBrandSwitch();
 				startBrandInter();
 			});
 			
 			$(".brand-table-wrap .ctr.next").click(function(){
 				brandDirection = "right";
 				stopBrandInter();
 				doBrandSwitch();
 				startBrandInter();
 			});
 			
 			startBrandInter();
 			
 			$(".img-container img").each(function(){
 				$(this).click(function(){
 					var key = $(this).data("key");
 					if(key){
	 					window.open("${basePath}dangan.do?id=" + key);
 					}
 				});
 			});
 			
 		});
 		
 		function stopBrandInter(){
 			if(brandInter){
				window.clearInterval(brandInter);
			}
 		}
 		
 		function startBrandInter(){
 			brandInter = window.setInterval(function(){
 				doBrandSwitch();
 			}, 4000);
 		}
 		
 		function doBrandSwitch(){
 			var left = $(".img-container").css("left");
			var step = $(".brand-table").width();
			if(left.indexOf("px")>0){
				left = parseInt(left.substring(0,left.length - 2));
			}
			if(brandDirection == 'left'){
				left -= step;
				if(left + imgContainerWidth<=0){//已经到最右边了
					left = 0;
				}
			}else{
				left += step;
				if(left > 0){//已经到最左边了
					left = $(".brand-table").width()-imgContainerWidth;
				}
			}
			
			$(".img-container").animate({left:left + "px"});
 		}
 		/* $(function(){
 				var x = $( "#keySearch" ).autocomplete({
			      source: "${basePath}search.do?target=qa",
			      minLength: 2,
			      select: function( event, ui ) {
			        log( "Selected: " + ui.item.title + " aka " + ui.item.id );
			      }
			    });
 				x.data('ui-autocomplete')._renderItem=function( ul, item ) {
 					
 					var a = $("<a href=\"${basePath}dangan.do?id=" + item.id +"\" target=\"_blank\">"+  item.title +"</a>")
 					
			    	  return $( "<li>" )
			    	    .attr( "data-value", item.id )
			    	    .append(a )
			    	    .appendTo( ul );
			    }
 		}); */
 		</script>
  </body>
</html>
