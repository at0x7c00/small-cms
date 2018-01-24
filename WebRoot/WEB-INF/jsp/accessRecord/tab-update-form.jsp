<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<td>
		<label class="checkbox">
			<input type="checkbox" name="${trTarget}Chk" value="${trIndex}"/>
			<i></i></label>
		<input type="hidden" name="rowGuard${trIndex}" value="1"/>
	</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].key"
											id="${propName}[${trIndex}].key"
											class="textInput required"
											 value="<c:out value="${tmpTmpBean.key}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
								<label class="input">
								<i class="icon-append fa fa-calendar"></i>
								<input name="${propName}[${trIndex}].accessTime" id="${propName}[${trIndex}].accessTime" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}' value='${tmpTmpBean.accessTime}'/>" class="date_required required textInput valid"/>
								</label>
				</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].url"
											id="${propName}[${trIndex}].url"
											class="textInput required"
											 value="<c:out value="${tmpTmpBean.url}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].origin"
											id="${propName}[${trIndex}].origin"
											class="textInput "
											 value="<c:out value="${tmpTmpBean.origin}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].ip"
											id="${propName}[${trIndex}].ip"
											class="textInput "
											 value="<c:out value="${tmpTmpBean.ip}"/>"
											maxlength="255" />
								</label>
				</td>