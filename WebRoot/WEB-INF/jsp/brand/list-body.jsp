<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<td>${tempBean.id}</td>
		<td>
		${tempBean.name}
		</td>
		<td>
		${tempBean.url}
		</td>
			<td>${tempBean.logo.manageKey}</td>
		<td>
		${tempBean.orderNum}
		</td>
		<td>
		${useStatusMap[tempBean.status]}
		</td>