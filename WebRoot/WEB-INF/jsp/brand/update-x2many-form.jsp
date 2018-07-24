<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
			<div class="tab-pane fade" id="logos">
					<div style="padding:5px">
						<a class="btn btn-primary attachement-dialog-add-btn"
						   href="javascript:void(0)" style="padding:5px 15px;" 
						   data-selectlist="logoSelectList" 
						   data-targetpanel="${targetPanel}"
						   data-maxfilesize="100"
						   data-acceptedfiles="${file_format_picture}"
						   data-width="150" data-height="50"
						   >
							<i class="fa fa-plus"></i> <spring:message code="base.function.add"/>
						</a>
						<a class="btn btn-danger select-list-delete-btn"
						   href="javascript:void(0)" style="padding:5px 15px;" data-selectlist="logoSelectList">
							<i class="fa fa-trash-o"></i> <spring:message code="base.function.delete"/>
						</a>
					</div>
				<div class="dataTables_wrapper select-list" id="logoSelectList" style="border-bottom:1px solid #ddd;" 
						 data-dataurl="filee/selectList.do"
					 	 data-groupname="logoKeys"
						 data-entityidname="manageKey"
						 data-method="POST"
					 	 data-initvalues="${tempBean.logo.manageKey }"
						 >
					</div>
				</div>