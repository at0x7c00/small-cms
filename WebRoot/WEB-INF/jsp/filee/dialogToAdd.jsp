<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>
<section id="widget-grid" class="">
	<div class="row">
		<article class="col-sm-12 col-md-12 col-lg-12">
			<div class="jarviswidget jarviswidget-color-blueLight" id="wid-id-0" data-widget-editbutton="false">
				<div style="border-top:1px solid #ccc;">
					<div class="widget-body">
						<form action="${basePath}filee/add.do" class="attachement-dropzone dropzone" 
						data-selectlist="${selectlist}" 
						data-formtargetpanel = "${formTargetPanel }"
						data-maxfilesize = "${maxFilesize }"
						data-acceptedfiles = "${acceptedFiles }"
						data-width = "${width }"
						data-height = "${height }"
						>
							<input type="hidden" name="folderId" value="1" />
							<input type="hidden" name="width" value="${width}" />
							<input type="hidden" name="height" value="${height}" />
						</form>
					</div>
				</div>
			</div>
		</article>
	</div>
</section>
<%@include file="/WEB-INF/jsp/common/pageSetJS.jsp"%>