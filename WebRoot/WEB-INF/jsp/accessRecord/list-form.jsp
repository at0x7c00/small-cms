<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="key"
											id="accessRecord.key"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.AccessRecord.key')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<i class="icon-append fa fa-calendar"></i>
								<input name="accessTimeStart" id="accessRecord.accessTime" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY}' value='${accessRecord.accessTimeStart}'/>" class="date_not_required textInput valid"  size="12"
									   placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.AccessRecord.accessTime')}(${nfn:i18nMessage(reqCtx,'base.common.form.start')})"
									   />
			</label>
				</section>
					<section class="col col-2">
					<label class="input"> 
								<i class="icon-append fa fa-calendar"></i>
								<input name="accessTimeEnd" id="accessRecord.accessTime" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY}' value='${accessRecord.accessTimeEnd}'/>" class="date_not_required textInput valid"  size="12"
									   placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.AccessRecord.accessTime')}(${nfn:i18nMessage(reqCtx,'base.common.form.end')})"
									   />
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="url"
											id="accessRecord.url"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.AccessRecord.url')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="origin"
											id="accessRecord.origin"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.AccessRecord.origin')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="ip"
											id="accessRecord.ip"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.AccessRecord.ip')}"/>
				</label>
				</section>