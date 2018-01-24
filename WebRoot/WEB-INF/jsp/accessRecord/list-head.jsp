<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<th  data-sortfield="id" class="${nfn:sortClass(pageBean,'id')}"><spring:message code="base.function.table.head.no"/></th>
			<th align="center" data-sortfield="key" class="${nfn:sortClass(pageBean,'key')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.AccessRecord.key"/>
		</th>
			<th align="center" data-sortfield="accessTime" class="${nfn:sortClass(pageBean,'accessTime')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.AccessRecord.accessTime"/>
		</th>
			<th align="center" data-sortfield="url" class="${nfn:sortClass(pageBean,'url')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.AccessRecord.url"/>
		</th>
			<th align="center" data-sortfield="origin" class="${nfn:sortClass(pageBean,'origin')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.AccessRecord.origin"/>
		</th>
			<th align="center" data-sortfield="ip" class="${nfn:sortClass(pageBean,'ip')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.AccessRecord.ip"/>
		</th>