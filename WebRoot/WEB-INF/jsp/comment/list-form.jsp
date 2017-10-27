<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-2">
						<label class="input"> 
										<form:input path="user"
											id="comment.user"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.Comment.user')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="phone"
											id="comment.phone"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.Comment.phone')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="email"
											id="comment.email"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.Comment.email')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="content"
											id="comment.content" size="12"
											 placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.Comment.content')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<i class="icon-append fa fa-calendar"></i>
								<input name="createTimeStart" id="comment.createTime" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY}' value='${comment.createTimeStart}'/>" class="date_not_required textInput valid"  size="12"
									   placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.Comment.createTime')}(${nfn:i18nMessage(reqCtx,'base.common.form.start')})"
									   />
			</label>
				</section>
					<section class="col col-2">
					<label class="input"> 
								<i class="icon-append fa fa-calendar"></i>
								<input name="createTimeEnd" id="comment.createTime" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY}' value='${comment.createTimeEnd}'/>" class="date_not_required textInput valid"  size="12"
									   placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.Comment.createTime')}(${nfn:i18nMessage(reqCtx,'base.common.form.end')})"
									   />
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<label class="select">
								<form:select id="replyStatus" path="replyStatus" cssClass="comboxed">
								<option value="">-${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.Comment.replyStatus')}-</option>
									<form:options  items="${yesNoMap}"/>
								</form:select>
								<i></i>
								</label>
				</label>
				</section>
				<section class="col col-2">
						<label class="input"> 
										<form:input path="remark"
											id="comment.remark" size="12"
											 placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.Comment.remark')}"/>
				</label>
				</section>