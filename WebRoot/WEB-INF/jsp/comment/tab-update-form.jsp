<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<td>
		<label class="checkbox">
			<input type="checkbox" name="${trTarget}Chk" value="${trIndex}"/>
			<i></i></label>
		<input type="hidden" name="rowGuard${trIndex}" value="1"/>
	</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].user"
											id="${propName}[${trIndex}].user"
											class="textInput required"
											 value="<c:out value="${tmpTmpBean.user}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].remark"
											id="${propName}[${trIndex}].remark"
											class="textInput "
											 value="<c:out value="${tmpTmpBean.remark}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].phone"
											id="${propName}[${trIndex}].phone"
											class="textInput required"
											 value="<c:out value="${tmpTmpBean.phone}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].email"
											id="${propName}[${trIndex}].email"
											class="textInput required"
											 value="<c:out value="${tmpTmpBean.email}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].content"
											id="${propName}[${trIndex}].content"
											class="textInput required"
											 value="<c:out value="${tmpTmpBean.content}"/>"
											maxlength="300" />
								</label>
				</td>
				<td>
								<label class="input">
								<i class="icon-append fa fa-calendar"></i>
								<input name="${propName}[${trIndex}].createTime" id="${propName}[${trIndex}].createTime" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}' value='${tmpTmpBean.createTime}'/>" class="date_required required textInput valid"/>
								</label>
				</td>
				<td>
								<label class="select">
								<select id="${propName}[${trIndex}].replyStatus" name="${propName}[${trIndex}].replyStatus" cssClass="required comboxed">
								<option value=""><spring:message code="base.common.selectone"/></option>
									<c:forEach items="${yesNoMap}" var="entry" >
										<option value="${entry.key}" ${tmpTmpBean.replyStatus eq entry.key ? 'selected' : ''}><c:out value="${entry.value}"/></option>
									</c:forEach>
								</select><i></i>
								</label>
				</td>