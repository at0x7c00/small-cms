<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<th  data-sortfield="id" class="${nfn:sortClass(pageBean,'id')}" width="50px"><spring:message code="base.function.table.head.no"/></th>
<th align="center" data-sortfield="content" class="${nfn:sortClass(pageBean,'content')}">
	<spring:message code="props.me.huqiao.smallcms.cms.entity.Comment.content"/>
</th>
<th align="center" data-sortfield="createTime" class="${nfn:sortClass(pageBean,'createTime')}" width="150px">
	<spring:message code="props.me.huqiao.smallcms.cms.entity.Comment.createTime"/>
</th>
