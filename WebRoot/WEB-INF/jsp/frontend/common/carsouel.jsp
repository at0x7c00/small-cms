<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="carousel">
	<ul class="bxslider" >
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