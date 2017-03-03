<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
					<section class="col col-2">
						<label class="input"> 
										<label class="select">
										<form:select id="picture" path="picture" cssClass="required comboxed">
										<option value="">-<spring:message code="props.me.huqiao.smallcms.cms.entity.Carousel.picture"/>-</option>
											<form:options  items="${commonFileList}" itemValue="manageKey" itemLabel="manageKey"/>
										</form:select>
										<i></i>
										</label>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="url"
											id="carousel.url"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.Carousel.url')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<form:input path="orderNum"
									id="carousel.orderNum" type="text"
									cssClass="textInputdigits" size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.Carousel.orderNum')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<label class="select">
								<form:select id="status" path="status" cssClass="comboxed">
								<option value="">-${nfn:i18nMessage(reqCtx,'props.me.huqiao.smallcms.cms.entity.Carousel.status')}-</option>
									<form:options  items="${useStatusMap}"/>
								</form:select>
								<i></i>
								</label>
				</label>
				</section>