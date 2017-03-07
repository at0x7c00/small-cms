<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<%@include file="/WEB-INF/jsp/frontend/common/resource.jsp" %>
		
		<link rel="stylesheet" type="text/css" media="screen" href="${basePath}js/3d-gallery/css/style.css">
		<link rel="stylesheet" type="text/css" media="screen" href="${basePath}resource/frontend/theme/default/css/detail.css">
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
	  						<img alt="" src="${basePath}resource/frontend/theme/default/css/img/video.png" width="300">
	  						<%--
	  						<embed src="http://player.video.qiyi.com/8291aa2c98a481281eb7f3542b0d0cbe/0/0/v_19rrmo5t5c.swf-albumId=202112801-tvId=298362300-isPurchase=0-cnId=3" allowFullScreen="true" quality="high" width="400" height="300" align="middle" allowScriptAccess="always" type="application/x-shockwave-flash"></embed>
	  						 --%>
	  						</td>
	  						<td style="vertical-align: top;">
	  							<h1 style="font-size:16px;font-weight:bold;color:black;text-align: center;">
	  							成都松齐明科技有限公司
	  							</h1>
	  							<p style="text-indent: 2em;line-height:1.5em;">
	  							成都松齐明科技有限公司是无尘板书方案提供商，创立于2004年，一直专注于100%无尘板书产品系列产品研发、生产、销售。公司汇聚
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
					  <div class="img-holder">
					    <img src="${basePath}js/step-gallery/images/butterflies640-200x150.jpg">
					  	<div class="title">水溶性无尘粉笔</div>
					    <div class="img-ref">
					       <img src="${basePath}js/step-gallery/images/butterflies640-200x150.jpg">
					    </div>
					  </div>
					
					  <div class="img-holder">
					    <img src="${basePath}js/step-gallery/images/pighead640b-200x150.jpg"> 
					  	<div class="title">水溶性无尘粉笔</div>
					      <div class="img-ref">
					       <img src="${basePath}js/step-gallery/images/pighead640b-200x150.jpg"> 
					    </div>
					  </div> 
					
					  <div class="img-holder"><img src="${basePath}js/step-gallery/images/canthanksgiving09-640-200x150.png">
					  	<div class="title">水溶性无尘粉笔</div>
					      <div class="img-ref">
					       <img src="${basePath}js/step-gallery/images/canthanksgiving09-640-200x150.png">
					    </div>
					  </div> 
					  <div class="img-holder"><img src="${basePath}js/step-gallery/images/weisswurst640-2-200x150.jpg">
					  	<div class="title">水溶性无尘粉笔</div>
					      <div class="img-ref">
					       <img src="${basePath}js/step-gallery/images/weisswurst640-2-200x150.jpg">
					    </div>
					  </div> 
					  <div class="img-holder"><img src="${basePath}js/step-gallery/images/cowhead-200.jpg">
					  	<div class="title">水溶性无尘粉笔</div>
					      <div class="img-ref">
					       <img src="${basePath}js/step-gallery/images/cowhead-200.jpg">
					    </div>
					  </div> 
					
					  <div class="img-holder"><img src="${basePath}js/step-gallery/images/drpepperfeast-200x150.jpg">
					  	<div class="title">水溶性无尘粉笔</div>
					      <div class="img-ref">
					       <img src="${basePath}js/step-gallery/images/drpepperfeast-200x150.jpg/">
					    </div>
					  </div> 
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
					<div class="panel">
					<div class="subfeature"><a href="javascript:void(0);"><img src="${basePath}js/step-gallery/images/butterflies640-200x150.jpg" alt="butterflies-are-gross" class="post-image" width="200" height="150" /></a>
					<div class="subfeature-txt"><h2><a href="javascript:void(0);">Butterflies are Gross</a></h2></div>
					</div>
					</div>		
					
					<div class="panel">
					<div class="subfeature">
					<a href="javascript:void(0);"><img src="${basePath}js/step-gallery/images/pighead640b-200x150.jpg" alt="pig-head-pozole" class="post-image" width="200" height="150" /></a>
					<div class="subfeature-txt"><h2><a href="javascript:void(0);">Pig Head Pozole and Crispy Baked Ears</a></h2></div>
					</div>
					</div>		
					
					<div class="panel">
					<div class="subfeature">
					
					<a href="javascript:void(0);"><img src="${basePath}js/step-gallery/images/canthanksgiving09-640-200x150.png" alt="canadian-thanksgiving-in-texas" class="post-image" width="200" height="150" /></a>
					<div class="subfeature-txt">
					<h2><a href="javascript:void(0);">Canadian Thanksgiving in Texas</a></h2>
					</div>
					</div>
					</div>		
					
					<div class="panel">
					<div class="subfeature">
					<a href="javascript:void(0);"><img src="${basePath}js/step-gallery/images/weisswurst640-2-200x150.jpg" alt="weisswurst-pretzels-and-beer-for-breakfast" class="post-image" width="200" height="150" /></a>
					<div class="subfeature-txt">
					<h2><a href="javascript:void(0);">Weisswurst, Pretzels and Beer for Breakfast</a></h2>
					</div>
					</div>
					</div>		
					
					<div class="panel">
					
					<div class="subfeature">
					<a href="javascript:void(0);"><img src="${basePath}js/step-gallery/images/cowhead-200.jpg" alt="cow-head-barbacoa" class="post-image" width="200" height="150" /></a>
					<div class="subfeature-txt"><h2><a href="javascript:void(0);">Cow Head Barbacoa</a></h2></div>
					</div>
					</div>		
					
					<div class="panel">
					<div class="subfeature">
					<a href="javascript:void(0);"><img src="${basePath}js/step-gallery/images/drpepperfeast-200x150.jpg" alt="cooking-with-dr-pepper" class="post-image" width="200" height="150" /></a>
					<div class="subfeature-txt">
					<h2><a href="javascript:void(0);">Cooking with Dr Pepper</a></h2>
					</div>
					</div>
					</div>		
					
					<div class="panel">
					<div class="subfeature">
					
					<a href="javascript:void(0);"><img src="${basePath}js/step-gallery/images/hatchchiles-thumb.jpg" alt="hatch-chile-feast" class="post-image" width="200" height="150" /></a>
					<div class="subfeature-txt">
					<h2><a href="javascript:void(0);">Hatch Chile Feast</a></h2>
					</div>
					</div>
					</div>		
					
					<div class="panel">
					<div class="subfeature">
					<a href="javascript:void(0);"><img src="${basePath}js/step-gallery/images/greece-200.jpg" alt="greece-eating-our-way-through-the-mainland" class="post-image" width="200" height="150" /></a>
					<div class="subfeature-txt">
					<h2><a href="javascript:void(0);">Greece: Eating Our Way Through the Mainland</a></h2>
					</div>
					</div>
					</div>		
					
					<div class="panel">
					
					<div class="subfeature">
					<a href="javascript:void(0);"><img src="${basePath}js/step-gallery/images/germany2009-tmb-200x150.jpg" alt="germany-eating-our-way-through-bavaria" class="post-image" width="200" height="150" /></a>
					<div class="subfeature-txt">
					<h2><a href="javascript:void(0);">Germany: Eating Our Way Through Bavaria</a></h2></div>
					</div>
					</div>		
					
					<div class="panel">
					<div class="subfeature">
					<a href="javascript:void(0);"><img src="${basePath}js/step-gallery/images/sP1000042-200x150.jpg" alt="braised-cow-lips" class="post-image" width="200" height="150" /></a>
					<div class="subfeature-txt"><h2><a href="javascript:void(0);">Braised Cow Lips</a></h2></div>
					</div>
					</div>		
					
					<div class="panel">
					<div class="subfeature">
					<a href="javascript:void(0);"><img src="${basePath}js/step-gallery/images/31birthday01-200x150.jpg" alt="sweetbreads-duck-breasts-ice-cream-cake-and-more" class="post-image" width="200" height="150" /></a>
					
					<div class="subfeature-txt">
					<h2><a href="javascript:void(0);">Sweetbreads, Duck Breasts, Ice Cream Cake and More!</a></h2>
					</div>
					</div>
					</div>		
					
					<div class="panel">
					<div class="subfeature">
					<a href="javascript:void(0);"><img src="${basePath}js/step-gallery/images/chickengizzards-640-200x150.jpg" alt="grilled-chicken-gizzards" class="post-image" width="200" height="150" /></a>
					<div class="subfeature-txt">
					<h2><a href="javascript:void(0);">Grilled Chicken Gizzards</a></h2>
					</div>
					</div>
					</div>		
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
				document.getElementById('stocklevels').style.visibility="visible";
			}
		});
		</script>
</html>