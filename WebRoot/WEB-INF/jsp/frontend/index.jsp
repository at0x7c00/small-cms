<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<title> ${systemTitle}-首页 </title>
		<%@include file="/WEB-INF/jsp/frontend/common/resource.jsp" %>
  	</head>
   
  <body>
  		<div class="container">
  			
			<%@include file="/WEB-INF/jsp/frontend/common/header.jsp" %>
	  		
	  		<div class="main-content">
	  			<div class="module-group">
		  			<div class="module left">
		  				<div class="module-title">
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/zhengce.png">
		  				</div>
		  				<div class="module-header">
		  					<a class="more" href="${basePath}frontend/zhengcedongtai.do"></a>
		  				</div>
		  				<ul class="module-content">
		  					<c:forEach items="${zhengcedongtaiList}" var="chapter">
			  					<li>
			  					<font class="title-prefix">■</font>
			  					<a href="${basePath}frontend/chapterDetail.do?k=${chapter.manageKey}"  target="_blank" title="${chapter.title}"><n:shorthand length="30" content="${chapter.title}"></n:shorthand> </a></li>
		  					</c:forEach>
		  				</ul>
		  			</div>
		  			
		  			<div class="module right">
		  				<div class="module-title">
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/zhiliangredian.png">
		  				</div>
		  				<div class="module-header">
		  					<a class="more" href="${basePath}frontend/zhiliangredian.do"></a>
		  				</div>
		  				<ul class="module-content">
		  					<c:forEach items="${zhiliangredianList}" var="chapter">
			  					<li>
			  					<font class="title-prefix">■</font>
			  					<a href="${basePath}frontend/chapterDetail.do?k=${chapter.manageKey}"  target="_blank" title="${chapter.title}"><n:shorthand length="30" content="${chapter.title}"></n:shorthand> </a></li>
		  					</c:forEach>
		  				</ul>
		  			</div>
	  			</div>
	  			
	  			<div class="ad-group">
	  				<div class="ad left">
	  					<a href="${ adList[0].url}" target="_blank" title="${adList[0].title }">
		  					<img src="${basePath}filee/viewPic.do?manageKey=${adList[0].picture.manageKey}" />
	  					</a>
	  				</div>
	  				<div class="ad right">
	  					<a href="${ adList[1].url}" target="_blank" title="${adList[1].title }">
	  						<img src="${basePath}filee/viewPic.do?manageKey=${adList[1].picture.manageKey}" />
	  					</a>
	  				</div>
	  			</div>
	  			
	  			<div class="module-group">
		  			<div class="module full-page">
		  				<div class="module-title">
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/huiyuan.png">
		  				</div>
		  				<div class="module-header">
		  					<a class="more" href="${basePath}frontend/huiyuanfengcai.do"></a>
		  				</div>
		  				<div>	
		  					<table width="100%" border="0">
		  						<tr>
		  							<td width="590px" style="text-align:center;">
		  								<a href="${basePath}frontend/chapterDetail.do?k=${huiyuanfengcaiList[0].manageKey}" target="_blank">
				  								<img alt="" style="width:550px;height:270px;" src="${basePath}filee/viewPic.do?manageKey=${huiyuanfengcaiList[0].cover.manageKey}">
		  								</a>
		  							</td>
		  							<td>
		  								<ul class="module-content" style="padding-left:5px;">
						  					<c:forEach items="${huiyuanfengcaiList}" var="chapter">
							  					<li>
							  					<font class="title-prefix">■</font>
							  					<a href="${basePath}frontend/chapterDetail.do?k=${chapter.manageKey}"  target="_blank" title="${chapter.title}"><n:shorthand length="30" content="${chapter.title}"></n:shorthand> </a></li>
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
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/zhiliangdangan.png">
		  				</div>
		  				<div class="module-header">
		  					<a class="more" href="${basePath}frontend/zhiliangdangan.do"></a>
		  				</div>
		  				
		  				<div class="module-content">
		  				
		  				<div id="mygallery" class="stepcarousel" style="margin-top:15px;">
								<div class="belt" id="displaycssbelt">
								
								<c:forEach items="${qualityArchiveList }" var="qa">
									<div class="panel">
										<div class="subfeature">
											<a href="${basePath}frontend/danganDetail.do?manageKey=${qa.manageKey}" target="_blank" title="${qa.title}" style="display:inline-block;height:160px;width:235px;text-align:center;padding:0px;margin:0px;">
												<img src="${basePath}filee/viewPic.do?manageKey=${qa.cover.manageKey}" alt="butterflies-are-gross" class="post-image" style="border:1px solid #eee;width:235px;height:160px;" style="padding:0px;margin:0px;"/>
											</a>
											<div class="subfeature-txt" style="text-align: center;">
												<a href="${basePath}frontend/danganDetail.do?manageKey=${qa.manageKey}" target="_blank" title="${qa.title}">
												<n:shorthand length="14" content="${qa.title}"></n:shorthand>
												</a>
											</div>
										</div>
									</div>		
								</c:forEach>
								
										
							</div>
							</div>
		  				
		  				</div>
		  				
		  			</div>
		  		</div>
		  		
		  		<div class="module-group">
		  			<div class="module full-page">
		  				<div class="module-title">
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/hangye.png">
		  				</div>
		  				<div class="module-header">
		  					<a class="more" href="${basePath}frontend/hangyezixun.do"></a>
		  				</div>
		  				<ul class="module-content bordered">
		  					<c:forEach items="${hangyezixunList}" var="chapter"> 
			  					<li>
			  					<font class="title-prefix">■</font>
			  					<a href="${basePath}frontend/chapterDetail.do?k=${chapter.manageKey}"  target="_blank" title="${chapter.title}"><n:shorthand length="50" content="${chapter.title}"></n:shorthand> </a>
			  					<span class="publish-date"><fmt:formatDate value="${chapter.createTime}" pattern="yyyy/MM/dd"/></span>
			  					</li>
		  					</c:forEach>
		  				</ul>
		  			</div>
		  		</div>
		  		
		  		<div class="module-group"  style="min-height:73px;">
		  			<div class="module full-page">
		  				<div class="module-title">
		  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/youqing.png">
		  				</div>
		  				<div class="module-header">
		  				</div>
		  				<div class="module-content">
		  					<c:forEach items="${flinkList}" var="flink">
			  					<a href="${flink.url}" target="_blank">${flink.name}</a>
		  					</c:forEach>
		  				</div>
		  			</div>
		  		</div>
		  		
		  		
		  		<%@include file="/WEB-INF/jsp/frontend/common/footer.jsp" %>
		  		
	  		</div>
	  		
  		</div>
 		<%@include file="/WEB-INF/jsp/frontend/common/js.jsp" %>
 		<script type="text/javascript">
		stepcarousel.setup({
			galleryid: 'mygallery', //id of carousel DIV
			beltclass: 'belt', //class of inner "belt" DIV containing all the panel DIVs
			panelclass: 'panel', //class of panel DIVs each holding content
			panelbehavior: {speed:500, wraparound:false, persist:true},
			autostep: {enable:true, moveby:5, pause:10000},
			defaultbuttons: {enable: true, moveby: 4, leftnav: ['${basePath}js/step-gallery/images/butt-left.png', 0, 64], rightnav: ['${basePath}js/step-gallery/images/butt-right.png', -11, 64]},
			statusvars: ['statusA', 'statusB', 'statusC'], //register 3 variables that contain current panel (start), current panel (last), and total panels
			contenttype: ['inline'], //content setting ['inline'] or ['external', 'path_to_external_file']
			oninit:function(){
				isloaded=true
				document.getElementById('displaycssbelt').style.visibility="visible";
				//document.getElementById('stocklevels').style.visibility="visible";
			}
		});
		</script>
  </body>
</html>
