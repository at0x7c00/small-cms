<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="header">
	<div>
	<div class="left-full">
		<div class="logo-img"></div>
	</div>
	<div class="right-full">
		<div class="right-note">
			<input type="text" class="search-box" placeholder="请输入关键字" value="${key}"/>
			<button class="search-btn"></button>
		</div>
	</div>
	</div>
</div>
<div class="menu-bar" data-request="${_request_url}">
	<ul>
		<li>
			<a href="${basePath}index.do" >首页<i></i></a>
		</li>
		<li>
			<a href="${basePath}zhengcedongtai.do">新闻动态<i></i></a>
		</li>
		<li>
			<a href="${basePath}zhiliangdangan.do">质量档案<i></i></a>
		</li>
		<li>
			<a href="${basePath}zhiliangredian.do">质量新闻<i></i></a>
		</li>
		<li>
			<a href="${basePath}zhiliangbaoguang.do">质量曝光<i></i></a>
		</li>
		<li>
			<a href="${basePath}hangyezixun.do">行业资讯<i></i></a>
		</li>
		<li>
			<a href="${basePath}huiyuanfengcai.do">企业风采<i></i></a>
		</li>
		<li>
			<a href="${basePath}huodonghuigu.do">活动回顾<i></i></a>
		</li>
		<li>
			<a href="${basePath}about.do">关于我们<i></i></a>
		</li>
	</ul>
</div>