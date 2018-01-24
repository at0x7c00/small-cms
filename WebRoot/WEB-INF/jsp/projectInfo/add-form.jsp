<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.ProjectInfo.content"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="content"
											id="projectInfo.content"
											cssClass="textInput required ckeditor-able"
											 />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.ProjectInfo.cover"/>:
				</label>
				</section>