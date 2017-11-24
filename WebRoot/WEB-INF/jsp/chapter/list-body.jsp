<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
		<td>${tempBean.id}</td>
		<td>
		<a href="${basePath}chapter/update.do?manageKey=${tempBean.manageKey}" target="dialogTodo" title="修改文章">
		<strong>${tempBean.title}</strong>
		</a>
		<a href="${basePath}chapterDetail.do?k=${tempBean.manageKey}" target="_blank" title="查看文章" style="text-decoration: none;">
			<i class="fa  fa-external-link"></i>
		</a>
		<br/>
		<ul class="chapter-detail">
		<li>
		<spring:message code="props.me.huqiao.smallcms.cms.entity.Chapter.creator"/>:${tempBean.creator.chineseName}
		</li>
		<li>
		<spring:message code="props.me.huqiao.smallcms.cms.entity.Chapter.createTime"/>:<fmt:formatDate value="${tempBean.createTime}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
		</li>
		<li>
		修改时间:<fmt:formatDate value="${tempBean.updateTime}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
		</li>
		<li>
		<spring:message code="props.me.huqiao.smallcms.cms.entity.Chapter.page"/>:${tempBean.page.name}
		</li>
		<li>
		<spring:message code="props.me.huqiao.smallcms.cms.entity.Chapter.readCount"/>:${tempBean.readCount}
		</li>
		</ul>
		</td>
		<td>
		${tempBean.orderNum}
		</td>
		<td>
		${useStatusMap[tempBean.status]}
		</td>