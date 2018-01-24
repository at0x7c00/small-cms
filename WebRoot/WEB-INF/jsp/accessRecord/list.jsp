<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>
<section id="widget-grid" class="">
	<div class="row">
		<article class="col-sm-12 col-md-12 col-lg-12">
			<div class="jarviswidget" id="wid-id-0" 
			data-widget-colorbutton="false" data-widget-editbutton="false" 
			data-widget-deletebutton="false"
			data-widget-custombutton="false">
				<header>
					<span class="widget-icon"> <i class="fa fa-file"></i> </span>
					<h2><spring:message code="funcs.AccessRecord.list"></spring:message></h2>
				</header>
				<div>
					<div class="jarviswidget-editbox">
					</div>
					<div class="widget-body no-padding">
						<form:form action="accessRecord/list.do" class="smart-form smart-form-search" onsubmit="return ajaxSearch(this,'${targetPanel}')" commandName="accessRecord">
							<input type="hidden" name="pageNum" value="${pageBean.pageNum}"/>
							<input type="hidden" name="orderField" value="${pageBean.orderField}"/>
							<input type="hidden" name="orderDirection" value="${pageBean.orderDirection}"/>
							<input type="hidden" name="targetPanel" value="${targetPanel}"/>
							<div id="form-search-mobile" class="btn-header transparent pull-left" style="margin-top:-5px;">
								<span> <a href="javascript:void(0)" title="Search"><i class="fa fa-search"></i></a> </span>
							</div>
						    <fieldset>
							<div class="row" style="display:none;">
							<%@include file="/WEB-INF/jsp/accessRecord/list-form.jsp" %>
							</div>
							</fieldset>
							<div class="dataTables_wrapper" style="border-bottom:1px solid #ddd;"> 
							<table id="dt_basic" class="table table-striped table-bordered table-hover" style="border:1px solid red;">
							<thead>
							<tr>
								<th align="center" width="16px">
										<label class="checkbox">
											<input type="checkbox" name="checkbox" class="smart-form-checkall" data-groupname="manageKeys">
										<i></i></label>
								</th>
								<%@include file="/WEB-INF/jsp/accessRecord/list-head.jsp" %>
							</tr>
							</thead>
							<tbody>
								<c:if test="${empty pageBean.list}">
									<tr>
										<td colspan="7">
											<center>
												<font style="color: gray;"><spring:message code="base.function.table.info.nodata" /> </font>
											</center>
										</td>
									</tr>
								</c:if>
								<c:forEach var="tempBean" items="${pageBean.list}"
									varStatus="stauts">
									<tr target="manageKeys" rel="${tempBean.manageKey}">
										<td align="center"  width="16">
										<label class="checkbox">
											<input name="manageKeys" type="checkbox" value="${tempBean.manageKey}"/><i></i>
										</label>
										</td>
										<%@include file="/WEB-INF/jsp/accessRecord/list-body.jsp" %>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						</div>
						<%@include file="/WEB-INF/jsp/common/pageBar.jsp" %>
						</form:form>
					</div>
				</div>
			</div>
		</article>
	</div>
</section>
<%@include file="/WEB-INF/jsp/common/pageSetJS.jsp" %>