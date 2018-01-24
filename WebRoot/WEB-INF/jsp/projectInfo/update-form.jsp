<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-12">
					<label class="input">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.ProjectInfo.content"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:textarea path="content"
											id="projectInfo.content"
											cssClass="textInput required ckeditor-able"
											rows="10"
											cols="60"
											cssStyle="width:100%;"
											 />
				</label>
				</section>
