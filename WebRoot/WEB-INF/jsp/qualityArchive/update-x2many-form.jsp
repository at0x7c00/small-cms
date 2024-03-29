<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="tab-pane fade" id="attachments">
					<div style="padding:5px">
						<a class="btn btn-primary attachement-dialog-add-btn"
						   href="javascript:void(0)" style="padding:5px 15px;" 
						   data-selectlist="attachmentsSelectList" 
						   data-targetpanel="${targetPanel}"
						   data-maxfilesize="100"
						   data-acceptedfiles="${file_format_picture}"
						   data-width="230"
						   data-height="190"
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
						 data-groupname="coverKeys"
						 data-entityidname="manageKey"
						 data-method="POST"
						 data-initvalues="${tempBean.cover.manageKey }"
						 >
					</div>
				</div>
				

<div class="tab-pane fade" id="videoOrPicture">
	<div style="padding:5px">
		<a class="btn btn-primary attachement-dialog-add-btn"
		   href="javascript:void(0)" style="padding:5px 15px;" 
		   data-selectlist="videoOrPictureSelectList" 
		   data-targetpanel="${targetPanel}"
		   data-maxfilesize="100"
		  data-acceptedfiles=""
		  data-width="430"
		   data-height="330"
		   >
			<i class="fa fa-plus"></i> <spring:message code="base.function.add"/>
		</a>
	
		<a class="btn btn-danger select-list-delete-btn"
		   href="javascript:void(0)" style="padding:5px 15px;" data-selectlist="videoOrPictureSelectList">
			<i class="fa fa-trash-o"></i> <spring:message code="base.function.delete"/>
		</a>
	</div>
	
	<div class="dataTables_wrapper select-list" id="videoOrPictureSelectList" style="border-bottom:1px solid #ddd;" 
		 data-dataurl="filee/selectList.do"
		 data-groupname="videoOrPictureKeys"
		 data-entityidname="manageKey"
		 data-method="POST"
		 data-initvalues="${tempBean.detailCover.manageKey }"
		 >
	</div>
	<%--
	<div style="padding:5px">
		<input id="productDisplaySelect2" class="object-select" style="width:50%;" 
			   data-queryurl="filee/select2Query.do"
			   data-querydelay="250"
			   data-multiple="false"
			   data-querymethod="POST"
			   data-initurl=""
			   data-minlength="0"
			   data-renderdata="manageKey"
			   data-echodata="manageKey"
			   data-customcallback="selectListSelection"
			   data-selectlist="videoOrPictureSelectList"
			   placeholder="<spring:message code="base.function.add"/>"
			   />
		<a class="btn btn-danger select-list-delete-btn"
		   href="javascript:void(0)" style="padding:5px 15px;" data-selectlist="productDisplaySelectList">
			<i class="fa fa-trash-o"></i><spring:message code="base.function.delete"/>
		</a>
	</div>
	 --%>
</div>
				<!-- 产品展示  productDisplay:many to many prop tab start -->
				<div class="tab-pane fade" id="productDisplay">
					<div style="padding:5px">
						<a class="btn btn-primary attachement-dialog-add-btn"
						   href="javascript:void(0)" style="padding:5px 15px;" 
						   data-selectlist="productDisplaySelectList" 
						   data-targetpanel="${targetPanel}"
						   data-maxfilesize="100"
						  data-acceptedfiles="${file_format_picture}"
						  data-width="300"
		  					 data-height="300"
						   >
							<i class="fa fa-plus"></i> <spring:message code="base.function.add"/>
						</a>
					
						<a class="btn btn-danger select-list-delete-btn"
						   href="javascript:void(0)" style="padding:5px 15px;" data-selectlist="productDisplaySelectList">
							<i class="fa fa-trash-o"></i> <spring:message code="base.function.delete"/>
						</a>
					</div>
					<div class="dataTables_wrapper select-list" id="productDisplaySelectList" style="border-bottom:1px solid #ddd;" 
						 data-dataurl="filee/selectList.do"
						 data-groupname="productDisplayKeys"
						 data-entityidname="manageKey"
						 data-method="POST"
						 data-initvalues="${nfn:serialKyes(tempBean.productDisplay,'manageKey')}"
						 >
					</div>
					
										<br/>
					<br/>
					<hr/>
					<br/>
				产品介绍:
					<textarea rows="5" cols="100" style="width:100%;" placeholder="以回车换行区分不同产品的介绍，顺序以产品图片顺序一致。" name="productDesc">${tempBean.productDesc}</textarea>
					<%--
					<div style="padding:5px">
						<input id="productDisplaySelect2" class="object-select" style="width:50%;" 
							   data-queryurl="commonFile/select2Query.do"
							   data-querydelay="250"
							   data-multiple="false"
							   data-querymethod="POST"
							   data-initurl=""
							   data-minlength="0"
							   data-renderdata="manageKey"
							   data-echodata="manageKey"
							   data-customcallback="selectListSelection"
							   data-selectlist="productDisplaySelectList"
							   placeholder="<spring:message code="base.function.add"/>"
							   />
						<a class="btn btn-danger select-list-delete-btn"
						   href="javascript:void(0)" style="padding:5px 15px;" data-selectlist="productDisplaySelectList">
							<i class="fa fa-trash-o"></i><spring:message code="base.function.delete"/>
						</a>
					</div>
					 --%>
				</div>
				<!-- 产品展示 productDisplay:!-- many to many prop tab end -->
				<!-- 荣誉展示  gloryDisplay:many to many prop tab start -->
				<div class="tab-pane fade" id="gloryDisplay">
					<div style="padding:5px">
						<a class="btn btn-primary attachement-dialog-add-btn"
						   href="javascript:void(0)" style="padding:5px 15px;" 
						   data-selectlist="gloryDisplaySelectList" 
						   data-targetpanel="${targetPanel}"
						   data-maxfilesize="100"
						  data-acceptedfiles="${file_format_picture}"
						  data-width="400"
		                  data-height="400"
						   >
							<i class="fa fa-plus"></i> <spring:message code="base.function.add"/>
						</a>
					
						<a class="btn btn-danger select-list-delete-btn"
						   href="javascript:void(0)" style="padding:5px 15px;" data-selectlist="gloryDisplaySelectList">
							<i class="fa fa-trash-o"></i> <spring:message code="base.function.delete"/>
						</a>
					</div>
					<div class="dataTables_wrapper select-list" id="gloryDisplaySelectList" style="border-bottom:1px solid #ddd;" 
						 data-dataurl="filee/selectList.do"
						 data-groupname="gloryDisplayKeys"
						 data-entityidname="manageKey"
						 data-method="POST"
						 data-initvalues="${nfn:serialKyes(tempBean.gloryDisplay,'manageKey')}"
						 >
					</div>
					<%--
					<div style="padding:5px">
						<input id="gloryDisplaySelect2" class="object-select" style="width:50%;" 
							   data-queryurl="commonFile/select2Query.do"
							   data-querydelay="250"
							   data-multiple="false"
							   data-querymethod="POST"
							   data-initurl=""
							   data-minlength="0"
							   data-renderdata="manageKey"
							   data-echodata="manageKey"
							   data-customcallback="selectListSelection"
							   data-selectlist="gloryDisplaySelectList"
							   placeholder="<spring:message code="base.function.add"/>"
							   />
						<a class="btn btn-danger select-list-delete-btn"
						   href="javascript:void(0)" style="padding:5px 15px;" data-selectlist="gloryDisplaySelectList">
							<i class="fa fa-trash-o"></i><spring:message code="base.function.delete"/>
						</a>
					</div>
					 --%>
				</div>
				<!-- 荣誉展示 gloryDisplay:!-- many to many prop tab end -->
				<!-- 二维码  gloryDisplay:many to many prop tab start -->
				<div class="tab-pane fade" id="code">
					<div style="padding:5px">
						<a class="btn btn-primary attachement-dialog-add-btn"
						   href="javascript:void(0)" style="padding:5px 15px;" 
						   data-selectlist="codeSelectList" 
						   data-targetpanel="${targetPanel}"
						   data-maxfilesize="100"
						  data-acceptedfiles="${file_format_picture}"
						   data-width="200"
		  				  data-height="200"
						   >
							<i class="fa fa-plus"></i> <spring:message code="base.function.add"/>
						</a>
					
						<a class="btn btn-danger select-list-delete-btn"
						   href="javascript:void(0)" style="padding:5px 15px;" data-selectlist="codeSelectList">
							<i class="fa fa-trash-o"></i> <spring:message code="base.function.delete"/>
						</a>
					</div>
					<div class="dataTables_wrapper select-list" id="codeSelectList" style="border-bottom:1px solid #ddd;" 
						 data-dataurl="filee/selectList.do"
						 data-groupname="codeKeys"
						 data-entityidname="manageKey"
						 data-method="POST"
						 data-initvalues="${tempBean.code.manageKey}"
						 >
					</div>
					<%--
					<div style="padding:5px">
						<input id="gloryDisplaySelect2" class="object-select" style="width:50%;" 
							   data-queryurl="commonFile/select2Query.do"
							   data-querydelay="250"
							   data-multiple="false"
							   data-querymethod="POST"
							   data-initurl=""
							   data-minlength="0"
							   data-renderdata="manageKey"
							   data-echodata="manageKey"
							   data-customcallback="selectListSelection"
							   data-selectlist="gloryDisplaySelectList"
							   placeholder="<spring:message code="base.function.add"/>"
							   />
						<a class="btn btn-danger select-list-delete-btn"
						   href="javascript:void(0)" style="padding:5px 15px;" data-selectlist="gloryDisplaySelectList">
							<i class="fa fa-trash-o"></i><spring:message code="base.function.delete"/>
						</a>
					</div>
					 --%>
				</div>
				<!-- 二维码 gloryDisplay:!-- many to many prop tab end -->
