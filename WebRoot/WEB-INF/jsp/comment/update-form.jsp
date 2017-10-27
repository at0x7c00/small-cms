<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Comment.user"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="user"
											id="comment.user"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Comment.phone"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="phone"
											id="comment.phone"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Comment.email"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="email"
											id="comment.email"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-12">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Comment.content"/>:
							<font style='color:red' class="required-mark">*</font>
										<label class="textarea">
										<form:textarea path="content"
											id="comment.content" cols="60"
											rows="5"
											cssClass="required"
											 />
										</label>
					</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Comment.createTime"/>:
							<font style='color:red' class="required-mark">*</font>
								<label class="input">
								<i class="icon-append fa fa-calendar"></i>
								<input name="createTime" id="comment.createTime" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}' value='${tempBean.createTime}'/>" class="date_required required textInput valid"/>
								</label>
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Comment.replyStatus"/>:
							<font style='color:red' class="required-mark">*</font>
								<label class="select">
								<form:select id="replyStatus" path="replyStatus" cssClass="required comboxed">
								<option value=""><spring:message code="base.common.selectone"/></option>
									<form:options  items="${yesNoMap}"/>
								</form:select><i></i>
								</label>
				</label>
				</section>
				<section class="col col-12">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Comment.remark"/>:
										<label class="textarea">
										<form:textarea path="remark"
											id="comment.remark" cols="60"
											rows="5"
											cssClass=""
											 />
										</label>
					</label>
				</section>