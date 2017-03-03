<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="workNum"
											id="worker.workNum"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.Worker.workNum')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<label class="select">
										<form:select id="photoFile" path="photoFile" cssClass=" comboxed">
										<option value="">-<spring:message code="props.me.huqiao.smallcms.ppll.entity.Worker.photoFile"/>-</option>
											<form:options  items="${commonFileList}" itemValue="manageKey" itemLabel="manageKey"/>
										</form:select>
										<i></i>
										</label>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="name"
											id="worker.name"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.Worker.name')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="area"
											id="worker.area"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.Worker.area')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="job"
											id="worker.job"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.ppll.entity.Worker.job')}"/>
				</label>
				</section>