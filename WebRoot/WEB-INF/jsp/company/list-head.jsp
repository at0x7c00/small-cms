<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<th  data-sortfield="id" class="${nfn:sortClass(pageBean,'id')}"><spring:message code="base.function.table.head.no"/></th>
			<th align="center" data-sortfield="archiveId" class="${nfn:sortClass(pageBean,'archiveId')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.Company.archiveId"/>
		</th>
			<th align="center" data-sortfield="name" class="${nfn:sortClass(pageBean,'name')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.Company.name"/>
		</th>
			<th align="center" data-sortfield="lawPerson" class="${nfn:sortClass(pageBean,'lawPerson')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.Company.lawPerson"/>
		</th>
			<th align="center" data-sortfield="address" class="${nfn:sortClass(pageBean,'address')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.Company.address"/>
		</th>
			<th align="center" data-sortfield="timeStart" class="${nfn:sortClass(pageBean,'timeStart')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.Company.timeStart"/>
		</th>
			<th align="center" data-sortfield="timeEnd" class="${nfn:sortClass(pageBean,'timeEnd')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.Company.timeEnd"/>
		</th>
			<th align="center" data-sortfield="license" class="${nfn:sortClass(pageBean,'license')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.Company.license"/>
		</th>
			<th align="center" data-sortfield="apply" class="${nfn:sortClass(pageBean,'apply')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.Company.apply"/>
		</th>