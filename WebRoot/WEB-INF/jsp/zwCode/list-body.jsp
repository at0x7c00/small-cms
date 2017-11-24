<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<td width="50px">${tempBean.id}</td>
		<td>
		${tempBean.companyName}
		</td>
		<td width="250px">
		<a href="${basePath}filee/viewPic.do?manageKey=${tempBean.code.manageKey}" target="_blank">
			${tempBean.code.name}
		</a>
		</td>