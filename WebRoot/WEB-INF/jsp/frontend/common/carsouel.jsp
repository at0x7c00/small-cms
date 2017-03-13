<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="carousel" style="position:relative;">
    <div style="height:360px;width:100%;position:absolute;z-index:1;background: #fff;">
    	<div style="padding-top:150px;text-align:center;">
    	<img src="${basePath}js/simple-modal/images/loader.gif"/>
    	<br/>
    	加载中...
    	</div>
    </div>
	<ul class="bxslider" style="z-index:2;">
		<c:forEach items="${carouselList }" var="c">
        <li style="display:none;">
        <a href="${c.url}" target="_blank" title="${c.title}">
        <img data-u="image" src="${basePath}filee/viewPic.do?manageKey=${c.picture.manageKey}" title="${c.title}"/>
        </a>
        </li>
        </c:forEach>
	</ul>
</div>
<script>
$(function(){
	
	$('.bxslider').bxSlider({
		  mode: 'fade',
		  captions: true,
		  adaptiveHeight:false,
		  pagerType:'full',
		  auto:true,
		  pause:3000
	});
	
	 $(".bxslider").show();
	
	
	
});
</script>