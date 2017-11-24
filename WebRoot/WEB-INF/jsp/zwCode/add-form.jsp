<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-12">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.ZwCode.companyName"></spring:message>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="companyName"
											id="zwCode.companyName"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
