<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>
				<td>
									${tempBean.name}
				</td>
				<td>
									${tempBean.url}
				</td>
				<td>
									${tempBean.logo.manageKey}
				</td>
				<td>
									${tempBean.orderNum}
				</td>
				<td>
									${useStatusMap[tempBean.status]}
				</td>