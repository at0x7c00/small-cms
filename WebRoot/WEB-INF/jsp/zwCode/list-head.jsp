<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<th  data-sortfield="id" class="${nfn:sortClass(pageBean,'id')}"><spring:message code="base.function.table.head.no"/></th>
			<th align="center" data-sortfield="companyName" class="${nfn:sortClass(pageBean,'companyName')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.ZwCode.companyName"/>
		</th>
		<th>
		微信访问次数
		</th>
		<th>
		按钮访问次数
		</th>

			<th align="center" data-sortfield="code" class="${nfn:sortClass(pageBean,'code')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.ZwCode.code"/>
		</th>