<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="content"
											id="projectInfo.content"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.ProjectInfo.content')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<label class="select">
										<form:select id="cover" path="cover" cssClass=" comboxed">
										<option value="">-<spring:message code="props.me.huqiao.smallcms.ppll.entity.ProjectInfo.cover"/>-</option>
											<form:options  items="${commonFileList}" itemValue="manageKey" itemLabel="manageKey"/>
										</form:select>
										<i></i>
										</label>
				</label>
				</section>