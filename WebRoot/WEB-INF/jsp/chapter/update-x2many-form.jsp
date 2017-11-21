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
						 data-groupname="coverKeys"
						 data-entityidname="manageKey"
						 data-method="POST"
						 data-initvalues="${tempBean.cover.manageKey }"
						 >
					</div>
					<strong>说明</strong>
					<ul>
					<li style="list-style-type: none;">中等大小图片，推荐图片尺寸：高：360像素，宽480像素，或高宽等比图片</li>
					<li style="list-style-type: none;">上传一张图片，多余图片将被忽略</li>
					<li style="list-style-type: none;">目前使用位置：新闻动态轮播图、首页行业资讯和企业风采头条、企业风采栏目缩略图</li>
					</ul>
				</div>
				
				
				<div class="tab-pane fade" id="attachmentsSmall">
	<div style="padding:5px">
		<a class="btn btn-primary attachement-dialog-add-btn"
		   href="javascript:void(0)" style="padding:5px 15px;" 
		   data-selectlist="attachmentsSmallSelectList" 
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
	<div class="dataTables_wrapper select-list" id="attachmentsSmallSelectList" style="border-bottom:1px solid #ddd;" 
		 data-dataurl="filee/selectList.do"
		 data-groupname="smallCoverKeys"
		 data-entityidname="manageKey"
		 data-method="POST"
		 data-initvalues="${tempBean.coverSmall.manageKey }"
		 >
	</div>
	<strong>说明</strong>
	<ul>
	<li style="list-style-type: none;">推荐图片尺寸：高：100像素，宽145像素</li>
	<li style="list-style-type: none;">上传一张图片，多余图片将被忽略</li>
	<li style="list-style-type: none;">目前使用位置：首页行业资讯和企业风采头条小图,搜索结果 </li>
	</ul>
</div>


<div class="tab-pane fade" id="attachmentsLarge">
	<div style="padding:5px">
		<a class="btn btn-primary attachement-dialog-add-btn"
		   href="javascript:void(0)" style="padding:5px 15px;" 
		   data-selectlist="attachmentsLargeSelectList" 
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
	<div class="dataTables_wrapper select-list" id="attachmentsLargeSelectList" style="border-bottom:1px solid #ddd;" 
		 data-dataurl="filee/selectList.do"
		 data-groupname="largeCoverKeys"
		 data-entityidname="manageKey"
		 data-method="POST"
		 data-initvalues="${tempBean.coverLarge.manageKey }"
		 >
	</div>
	<strong>说明</strong>
	<ul>
	<li style="list-style-type: none;">推荐图片尺寸：高：700像素，宽400像素</li>
	<li style="list-style-type: none;">上传一张图片，多余图片将被忽略</li>
	<li style="list-style-type: none;">目前使用位置：栏目页左侧滚动图</li>
	</ul>
</div>