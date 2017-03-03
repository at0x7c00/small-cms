<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Carousel.picture"/>:
							<font style='color:red' class="required-mark">*</font>
										<label class="select">
										<form:select id="picture" path="picture" cssClass="required comboxed">
										<option value=""><spring:message code="base.common.selectone"/></option>
											<form:options  items="${commonFileList}" itemValue="manageKey" itemLabel="manageKey"/>
										</form:select><i></i>
										</label>
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Carousel.url"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="url"
											id="carousel.url"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Carousel.orderNum"/>:
							<font style='color:red' class="required-mark">*</font>
								<form:input path="orderNum"
									id="carousel.orderNum" type="text"
									cssClass="textInput required digits" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Carousel.status"/>:
							<font style='color:red' class="required-mark">*</font>
								<label class="select">
								<form:select id="status" path="status" cssClass="required comboxed">
								<option value=""><spring:message code="base.common.selectone"/></option>
									<form:options  items="${useStatusMap}"/>
								</form:select><i></i>
								</label>
				</label>
				</section>