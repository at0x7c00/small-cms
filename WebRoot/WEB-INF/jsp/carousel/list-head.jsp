<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<th  data-sortfield="id" class="${nfn:sortClass(pageBean,'id')}"><spring:message code="base.function.table.head.no"/></th>
			<th align="center" data-sortfield="picture" class="${nfn:sortClass(pageBean,'picture')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.Carousel.picture"/>
		</th>
			<th align="center" data-sortfield="url" class="${nfn:sortClass(pageBean,'url')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.Carousel.url"/>
		</th>
			<th align="center" data-sortfield="orderNum" class="${nfn:sortClass(pageBean,'orderNum')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.Carousel.orderNum"/>
		</th>
			<th align="center" data-sortfield="status" class="${nfn:sortClass(pageBean,'status')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.Carousel.status"/>
		</th>