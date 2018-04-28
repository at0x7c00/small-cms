<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<td>${tempBean.id}</td>
		<td>
		${tempBean.archiveId}
		</td>
		<td>
		${tempBean.name}
		</td>
		<td>
		${tempBean.lawPerson}
		</td>
		<td>
		${tempBean.address}
		</td>
		<td><fmt:formatDate value="${tempBean.timeStart}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/></td>
		<td><fmt:formatDate value="${tempBean.timeEnd}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/></td>
		<td>
		<a href="${basePath}filee/viewPic.do?manageKey=${tempBean.license.manageKey}" target="_blank">
		<img alt="" src="${basePath}filee/viewPic.do?manageKey=${tempBean.license.manageKey}" class="table-pic"/>
		</a>
		</td>
		<td>
		<a href="${basePath}filee/viewPic.do?manageKey=${tempBean.apply.manageKey}" target="_blank">
		<img alt="" src="${basePath}filee/viewPic.do?manageKey=${tempBean.apply.manageKey}" class="table-pic"/>
		</a>
		</td>