<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
		<th align="center" data-sortfield="name" class="${nfn:sortClass(pageBean,'name')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.Brand.name"/>
		</th>
		<th align="center" data-sortfield="url" class="${nfn:sortClass(pageBean,'url')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.Brand.url"/>
		</th>
		<th align="center" data-sortfield="logo" class="${nfn:sortClass(pageBean,'logo')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.Brand.logo"/>
		</th>
		<th align="center" data-sortfield="orderNum" class="${nfn:sortClass(pageBean,'orderNum')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.Brand.orderNum"/>
		</th>
		<th align="center" data-sortfield="status" class="${nfn:sortClass(pageBean,'status')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.Brand.status"/>
		</th>