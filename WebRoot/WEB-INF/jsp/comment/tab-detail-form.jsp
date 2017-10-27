<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>
				<td>
									${tempBean.user}
				</td>
				<td>
									${tempBean.remark}
				</td>
				<td>
									${tempBean.phone}
				</td>
				<td>
									${tempBean.email}
				</td>
				<td>
									${tempBean.content}
				</td>
				<td>
								<fmt:formatDate value="${tempBean.createTime}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
				</td>
				<td>
									${yesNoMap[tempBean.replyStatus]}
				</td>