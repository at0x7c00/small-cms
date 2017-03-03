<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchive.title"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="title"
											id="qualityArchive.title"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchive.content"/>:
							<font style='color:red' class="required-mark">*</font>
										<label class="textarea">
										<form:textarea path="content"
											id="qualityArchive.content" cols="60"
											rows="5"
											cssClass="required"
											 />
										</label>
					</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchive.detailCover"/>:
										<label class="select">
										<form:select id="detailCover" path="detailCover" cssClass=" comboxed">
										<option value=""><spring:message code="base.common.selectone"/></option>
											<form:options  items="${commonFileList}" itemValue="manageKey" itemLabel="manageKey"/>
										</form:select><i></i>
										</label>
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchive.creator"/>:
							<font style='color:red' class="required-mark">*</font>
										<label class="select">
										<form:select id="creator" path="creator" cssClass="required comboxed">
										<option value=""><spring:message code="base.common.selectone"/></option>
											<form:options  items="${userList}" itemValue="username" itemLabel="chineseName"/>
										</form:select><i></i>
										</label>
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchive.createTime"/>:
							<font style='color:red' class="required-mark">*</font>
								<label class="input">
								<i class="icon-append fa fa-calendar"></i>
								<input name="createTime" id="qualityArchive.createTime" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}' value='${tempBean.createTime}'/>" class="date_required required textInput valid"/>
								</label>
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchive.orderNum"/>:
							<font style='color:red' class="required-mark">*</font>
								<form:input path="orderNum"
									id="qualityArchive.orderNum" type="text"
									cssClass="textInput required digits" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchive.readCount"/>:
							<font style='color:red' class="required-mark">*</font>
								<label class="input">
								<i class="icon-append fa fa-calendar"></i>
								<input name="readCount" id="qualityArchive.readCount" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}' value='${tempBean.readCount}'/>" class="date_required required textInput valid"/>
								</label>
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchive.status"/>:
							<font style='color:red' class="required-mark">*</font>
								<label class="select">
								<form:select id="status" path="status" cssClass="required comboxed">
								<option value=""><spring:message code="base.common.selectone"/></option>
									<form:options  items="${useStatusMap}"/>
								</form:select><i></i>
								</label>
				</label>
				</section>