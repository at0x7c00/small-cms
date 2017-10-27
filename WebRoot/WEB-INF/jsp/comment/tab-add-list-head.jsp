<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
		<th align="center" data-sortfield="user" class="${nfn:sortClass(pageBean,'user')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.Comment.user"/>
		</th>
		<th align="center" data-sortfield="remark" class="${nfn:sortClass(pageBean,'remark')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.Comment.remark"/>
		</th>
		<th align="center" data-sortfield="phone" class="${nfn:sortClass(pageBean,'phone')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.Comment.phone"/>
		</th>
		<th align="center" data-sortfield="email" class="${nfn:sortClass(pageBean,'email')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.Comment.email"/>
		</th>
		<th align="center" data-sortfield="content" class="${nfn:sortClass(pageBean,'content')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.Comment.content"/>
		</th>
		<th align="center" data-sortfield="createTime" class="${nfn:sortClass(pageBean,'createTime')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.Comment.createTime"/>
		</th>
		<th align="center" data-sortfield="replyStatus" class="${nfn:sortClass(pageBean,'replyStatus')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.Comment.replyStatus"/>
		</th>