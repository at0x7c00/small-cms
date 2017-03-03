<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
				<c:if test="${not historyView}">
				<!-- 产品展示  productDisplay:many to many prop tab start -->
				<div class="tab-pane fade" id="productDisplay">
					<div class="dataTables_wrapper select-list" id="productDisplaySelectList" style="border-bottom:1px solid #ddd;" 
						 data-dataurl="commonFile/selectList.do?showCheckBox=false"
						 data-groupname="productDisplayKeys"
						 data-entityidname="manageKey"
						 data-method="POST"
						 data-initvalues="${nfn:serialKyes(tempBean.productDisplay,'manageKey')}"
						 >
					</div>
				</div>
				<!-- 产品展示 productDisplay:!-- many to many prop tab end -->
				</c:if>
				<c:if test="${not historyView}">
				<!-- 荣誉展示  gloryDisplay:many to many prop tab start -->
				<div class="tab-pane fade" id="gloryDisplay">
					<div class="dataTables_wrapper select-list" id="gloryDisplaySelectList" style="border-bottom:1px solid #ddd;" 
						 data-dataurl="commonFile/selectList.do?showCheckBox=false"
						 data-groupname="gloryDisplayKeys"
						 data-entityidname="manageKey"
						 data-method="POST"
						 data-initvalues="${nfn:serialKyes(tempBean.gloryDisplay,'manageKey')}"
						 >
					</div>
				</div>
				<!-- 荣誉展示 gloryDisplay:!-- many to many prop tab end -->
				</c:if>