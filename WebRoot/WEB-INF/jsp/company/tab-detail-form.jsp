<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>
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
				<td>
								<fmt:formatDate value="${tempBean.timeStart}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
				</td>
				<td>
								<fmt:formatDate value="${tempBean.timeEnd}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
				</td>
				<td>
									${tempBean.license.manageKey}
				</td>
				<td>
									${tempBean.apply.manageKey}
				</td>