<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.AccessRecord.key"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="key"
											id="accessRecord.key"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.AccessRecord.accessTime"/>:
							<font style='color:red' class="required-mark">*</font>
								<label class="input">
								<i class="icon-append fa fa-calendar"></i>
								<input name="accessTime" id="accessRecord.accessTime" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}' value='${tempBean.accessTime}'/>" class="date_required required textInput valid"/>
								</label>
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.AccessRecord.url"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="url"
											id="accessRecord.url"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.AccessRecord.origin"/>:
										<form:input path="origin"
											id="accessRecord.origin"
											cssClass="textInput "
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.AccessRecord.ip"/>:
										<form:input path="ip"
											id="accessRecord.ip"
											cssClass="textInput "
											maxlength="255" />
				</label>
				</section>