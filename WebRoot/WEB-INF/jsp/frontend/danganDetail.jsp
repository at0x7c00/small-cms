<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<title>${qa.title} - 质量档案 - ${systemTitle}</title>
		<%@include file="/WEB-INF/jsp/frontend/common/resource.jsp" %>
		
		<link rel="stylesheet" type="text/css" media="screen" href="${basePath}js/3d-gallery/css/style.css">
		<link rel="stylesheet" type="text/css" media="screen" href="${basePath}resource/frontend/theme/default/css/detail.css">
		
		<link href="http://vjs.zencdn.net/5.8.8/video-js.css" rel="stylesheet">

		 <!-- If you'd like to support IE8 -->
		 <script src="http://vjs.zencdn.net/ie8/1.1.2/videojs-ie8.min.js"></script>
		 <style type="text/css">
		 .video-js .vjs-big-play-button {
		    font-size: 3em;
		    line-height: 1.5em;
		    height: 1.5em;
		    width: 3em;
		    display: block;
		    position: absolute;
		    top:80%;
		    bottom: 10px;
		    left: 10px;
		    padding: 0;
		    cursor: pointer;
		    opacity: 1;
		    border: 0.06666em solid #fff;
		    background-color: #2B333F;
		    background-color: rgba(43, 51, 63, 0.7);
		    -webkit-border-radius: 0.3em;
		    -moz-border-radius: 0.3em;
		    border-radius: 0.3em;
		    -webkit-transition: all 0.4s;
		    -moz-transition: all 0.4s;
		    -o-transition: all 0.4s;
		    transition: all 0.4s;
		}
		 </style>
  	</head>
  
  <body>
  		<div class="container">
	  
  			<div class="dangan-detail-line"></div>
  			<img alt="" src="${basePath}resource/frontend/theme/default/css/img/detail-top-bg.jpg" class="img-full-page">
  			
  			<div class="qute">
  				<div style="text-align:center;" class="image-devider">
		  			<img alt="" src="${basePath}resource/frontend/theme/default/css/img/qiyejianjie.png" class="img-full-page">
  				</div>
	  			<div>
	  				<table width="100%" border="0">
	  					<tr>
	  						<td width="45%" style="text-align:right;padding-right:20px;">
	  						<c:if test="${not empty qa.detailCover }">
		  						<c:choose>
		  							<c:when test="${qa.detailCover.video }">
				  							<div style="width:364px;height:240px;float:right;">
						  						<video id="my-video" class="video-js" controls preload="auto" width="340" height="264"
											  poster="${basePath}filee/viewPic.do?manageKey=${qa.detailCover.manageKey}" data-setup="{}">
											    <source src="${basePath}filee/downloadFile.do?key=${qa.detailCover.manageKey}" type='video/mp4'>
											    <p class="vjs-no-js">
											      To view this video please enable JavaScript, and consider upgrading to a web browser that
											      <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
											    </p>
											  </video>
				  							</div>
		  							</c:when>
		  							<c:otherwise>
				  						<img alt="" src="${basePath}filee/viewPic.do?manageKey=${qa.detailCover.manageKey}" width="300" height="225">
		  							</c:otherwise>
		  						</c:choose>
	  						</c:if>
	  						</td>
	  						<td style="vertical-align: top;">
	  							<h1 style="font-size:16px;font-weight:bold;color:black;text-align: center;">
	  							<n:shorthand length="30" content="${qa.title}"></n:shorthand> 
	  							</h1>
	  							<p style="text-indent: 2em;line-height:1.5em;">
	  							<n:html value="${qa.content}"/> 
	  							</p>
	  						</td>
	  					</tr>
	  				</table>
	  			</div>
  			</div>
  			<div class="qute">
  				<div class="image-devider">
	  			<img alt="" src="${basePath}resource/frontend/theme/default/css/img/product.png" class="img-full-page">
  				</div>
  				<div class="gallery">
  					<div class="g-container">
  						<c:forEach items="${qa.productDisplay}" var="p">
							 <div class="img-holder">
							    <img src="${basePath}filee/viewPic.do?manageKey=${p.manageKey}">
							  	<div class="title">水溶性无尘粉笔</div>
							    <div class="img-ref">
							       <img src="${basePath}filee/viewPic.do?manageKey=${p.manageKey}">
							    </div>
							  </div>
  						</c:forEach>
					</div>
					
					<div class="scrolller-container">
					    <div class="scroller"></div>
					  </div>
					  
					  <div class="arrow left">
					  	<i class="fa fa-chevron-left"></i>
					  </div>
					  
					  <div class="arrow right">
					  	<i class="fa fa-chevron-right"></i>
					  </div>
					
				</div>
					
					  
					
  			</div>
  			<div class="qute" >
  					<div class="image-devider">
	  					<img alt="" src="${basePath}resource/frontend/theme/default/css/img/rongyu.png" style="height:130px;width:auto;"/>
  					</div>
  					
  					
  					<div style="margin-top:20px;">
  					
  					
  					<div id="mygallery" class="stepcarousel">
					<div class="belt" id="displaycssbelt">
						<c:forEach items="${qa.gloryDisplay}" var="p">
							<div class="panel">
								<div class="subfeature"><a href="javascript:void(0);"><img src="${basePath}filee/viewPic.do?manageKey=${p.manageKey}" alt="butterflies-are-gross" class="post-image" width="150" height="200" /></a>
								<%--
									<div class="subfeature-txt"><h2><a href="javascript:void(0);">Butterflies are Gross</a></h2></div>
								 --%>
								</div>
							</div>	
						</c:forEach>
					</div>
					</div>
  					
  					
  					</div>
  					
  					
  			</div>
  		</div>
  		
  		<div class="detail-footer">
  			<div class="line"></div>
  			<div style="text-align:center;color:#663333;font-weight:bold;font-size:16px;padding:20px 0px 30px 0px;">
  				<span>品质·信誉·未来</span>
  			</div>
  		</div>
  </body>
  
	  <script src='${basePath}js/3d-gallery/js/TweenMax.min.js'></script>
	  <script src='${basePath}js/3d-gallery/js/Draggable.min.js'></script>
  	  <script src="${basePath}js/3d-gallery/js/index.js"></script>
  	  
  	  <script src="http://vjs.zencdn.net/5.8.8/video.js"></script>
  	  
  	  <script type="text/javascript">
		stepcarousel.setup({
			galleryid: 'mygallery', //id of carousel DIV
			beltclass: 'belt', //class of inner "belt" DIV containing all the panel DIVs
			panelclass: 'panel', //class of panel DIVs each holding content
			panelbehavior: {speed:500, wraparound:false, persist:true},
			autostep: {enable:true, moveby:4, pause:10000},
			defaultbuttons: {enable: true, moveby: 4, leftnav: ['${basePath}js/step-gallery/images/butt-left.gif', 0, 64], rightnav: ['${basePath}js/step-gallery/images/butt-right.gif', -11, 64]},
			statusvars: ['statusA', 'statusB', 'statusC'], //register 3 variables that contain current panel (start), current panel (last), and total panels
			contenttype: ['inline'], //content setting ['inline'] or ['external', 'path_to_external_file']
			oninit:function(){
				isloaded=true
				document.getElementById('displaycssbelt').style.visibility="visible";
				//document.getElementById('stocklevels').style.visibility="visible";
			}
		});
		</script>
</html>