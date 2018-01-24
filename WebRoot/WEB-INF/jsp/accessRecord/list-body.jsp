<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<td>${tempBean.id}</td>
		<td>
		${tempBean.key}
		</td>
			<td><fmt:formatDate value="${tempBean.accessTime}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/></td>
		<td title="${tempBean.url}">
		<n:shorthand content="${tempBean.url}" length="30"></n:shorthand>
		</td>
		<td title="${tempBean.origin}">
		<n:shorthand content="${tempBean.origin}" length="30"></n:shorthand>
		</td>
		<td title="${tempBean.ip}">
		<n:shorthand content="${tempBean.ip}" length="30"></n:shorthand>
		</td>