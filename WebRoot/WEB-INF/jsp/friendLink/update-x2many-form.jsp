<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="tab-pane fade" id="attachments">
	<div style="padding:5px">
		<a class="btn btn-primary attachement-dialog-add-btn"
		   href="javascript:void(0)" style="padding:5px 15px;" 
		   data-selectlist="attachmentsSelectList" 
		   data-targetpanel="${targetPanel}"
		   data-maxfilesize="100"
		  data-acceptedfiles="${file_format_picture}"
		   >
			<i class="fa fa-plus"></i> <spring:message code="base.function.add"/>
		</a>
	
		<a class="btn btn-danger select-list-delete-btn"
		   href="javascript:void(0)" style="padding:5px 15px;" data-selectlist="attachmentsSelectList">
			<i class="fa fa-trash-o"></i> <spring:message code="base.function.delete"/>
		</a>
		
	</div>
	<div class="dataTables_wrapper select-list" id="attachmentsSelectList" style="border-bottom:1px solid #ddd;" 
		 data-dataurl="filee/selectList.do"
		 data-groupname="pictureKeys"
		 data-entityidname="manageKey"
		 data-method="POST"
		 data-initvalues="${tempBean.picture.manageKey}"
		 >
	</div>
</div>

