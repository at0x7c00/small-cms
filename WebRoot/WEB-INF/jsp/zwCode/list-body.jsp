<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<td width="50px">${tempBean.id}</td>
		<td>
		
		<a href="${basePath}zwCode/update.do?manageKey=${tempBean.manageKey}" target="dialogTodo" title="修改">
		<b>${tempBean.companyName}</b>
		</a>
		</td>
		<td width="150px">
			<a href="${basePath}accessRecord/list.do?key=zlda_wechat_${tempBean.codeId}" target="dialogTodo" title="访问记录">
				${tempBean.wechatAccessCount}
			</a>
		</td>
		<td width="150px">
			<a href="${basePath}accessRecord/list.do?key=zlda_code_button_${tempBean.codeId}" target="dialogTodo" title="访问记录">
				${tempBean.btnAccessCount}
			</a>
		</td>
		<td width="250px">
		<a href="${basePath}filee/viewPic.do?manageKey=${tempBean.code.manageKey}" target="_blank">
			${tempBean.code.name}
		</a>
		</td>