<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
				<!-- 产品展示  productDisplay:many to many prop tab start -->
				<div class="tab-pane fade" id="productDisplay">
					<div class="dataTables_wrapper select-list" id="productDisplaySelectList" style="border-bottom:1px solid #ddd;" 
						 data-dataurl="commonFile/selectList.do"
						 data-groupname="productDisplayKeys"
						 data-entityidname="manageKey"
						 data-method="POST"
						 data-initvalues=""
						 >
					</div>
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
				</div>
				<!--产品展示  productDisplay:!-- many to many prop tab end -->
				<!-- 荣誉展示  gloryDisplay:many to many prop tab start -->
				<div class="tab-pane fade" id="gloryDisplay">
					<div class="dataTables_wrapper select-list" id="gloryDisplaySelectList" style="border-bottom:1px solid #ddd;" 
						 data-dataurl="commonFile/selectList.do"
						 data-groupname="gloryDisplayKeys"
						 data-entityidname="manageKey"
						 data-method="POST"
						 data-initvalues=""
						 >
					</div>
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
				</div>
				<!--荣誉展示  gloryDisplay:!-- many to many prop tab end -->