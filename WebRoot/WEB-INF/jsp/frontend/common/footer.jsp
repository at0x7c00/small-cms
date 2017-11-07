<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="footer">
	<div class="footer-line"></div>
	<div class="footer-content">
		<div class="footer-detail">
			<div class="footer-column">
				<h1>网站导航</h1>
				<ul class="column-item">
					<li><a href="${basePath}index.do">网站首页</a></li>
					<li><a href="${basePath}zhengcedongtai.do">新闻动态</a></li>
					<li><a href="${basePath}zhiliangredian.do">质量新闻</a></li>
					<li><a href="${basePath}huiyuanfengcai.do">企业风采</a></li>
					<li><a href="${basePath}zhiliangdangan.do">质量档案</a></li>
				</ul>
				<div class="di"></div>
			</div>
			
			<div class="footer-column">
				<h1>关于我们</h1>
				<ul class="column-item">
					<li><a href="${basePath}zhiliangdangan.do#project">项目简介</a></li>
					<li><a href="javascript:void(0);" id="liuyan">在线留言</a></li>
					<li><a href="javascript:void(0);" id="chaxun">查询入口</a></li>
					<%--
					<li><a href="javascript:void(0);" id="ruhui">入会申请</a></li>
					 --%>
				</ul>
				<div class="di"></div>
			</div>
			
			<div class="footer-column" style="width:345px;">
				<h2 >咨询热线：400-822-5757</h2>
				<div style="text-align:center;">
					<img alt="" src="${basePath}resource/brcode.png"/>
					<h1 style="margin-top:5px;">扫描关注公众号</h1>
				</div>
			</div>
		</div>
<%-- 
		<div style="margin-top:20px;text-align:center;">
			 版权所有 &copy;${copyRight } 网站管理：${copyRight }网络中心
		</div>
		<div style="margin:5px;text-align:center;">
		地址：北京市朝阳区北三环东路18号  电话：010-64213739  邮编：100013		 
		</div>
		<div style="margin:5px;text-align:center;">
			
		</div> --%>
		
	</div>
	<div class="footer-sn">京ICP备17017591号-1号</div>
</div>
<script type="text/javascript">
 		$(function(){
 			$("#ruhui").on("click",function(){
 				loadWaitDialog();
 				$.get(basePath + 'apply.do?notice=yes',function(d){
 					closeWaitDialog();
 					$('<div class="dialog-content" id="applyNotice" style="width:735px;height:505px;overflow:auto;"></div>').html(d).dialog({
 	 					title : "申请条件",
 	 					width:600,
 	 					height:400,
 	 					modal:true,
 	 					buttons: {
 	 						"同意":function(){
 	 							loadApplyUI();
 	 							return true;
 	 						},
 	 					},
 	 				});
 					
 					$("#verifyCodeImage").click(function(){
 						loadVerifyCode("verifyCodeImage");
 					});
 					loadVerifyCode("verifyCodeImage");
 					
 				});
 			});
 			
 			$("#liuyan").on("click",function(){
 				loadWaitDialog();
 				$.get(basePath + 'liuyan.do',function(d){
 					closeWaitDialog();
 					$('<div class="dialog-content" id="applyNotice" style="width:500px;height:400px;overflow:auto;"></div>').html(d).dialog({
 	 					title : "在线留言",
 	 					width:500,
 	 					height:300,
 	 					modal:true,
 	 					buttons: {
 	 						"提交":function(){
 	 							if($("#liuyan-form").valid({errorPlacement:function(){}})){
 	 								var data = $("#liuyan-form").serializeArray();
 	 								if(!$("#liuyanPhone").val() && !$("#liuyanEmail").val()){
 	 									$("<div style='text-align:center;font-size:18px;'> 电话或邮箱至少需要填写一个 </div>").dialog({
 											title:'提示',
 											buttons: {
 					 	 						"确定":function(){
 					 	 							return true;
 					 	 						}
 											}
 										});
 	 									return false;
 	 		 						}
 	 								$.post(basePath + "liuyan.do",data,function(res){
 	 									if(res.statusCode!='200'){
 	 										//alert(res.message);
 	 										$("<div style='text-align:center;font-size:18px;'>" + res.message + "</div>").dialog({
 	 											title:'提示',
 	 											buttons: {
 	 					 	 						"确定":function(){
 	 					 	 							return true;
 	 					 	 						}
 	 											}
 	 										});
 	 									}else{
 	 										$("<div style='text-align:center;font-size:18px;margin-top:10px;'>" + res.message + "</div>").dialog({
 	 											title:'提示',
 	 											buttons: {
 	 					 	 						"确定":function(){
 	 					 	 						$("#apply").dialog("close");
 	 				 	 							$(".xdsoft_close").trigger("click");
 	 					 	 							return true;
 	 					 	 						}
 	 											}
 	 										});
 	 									}
 	 								});
 	 							}
 	 							return false;
 	 						},
 	 					},
 	 				});
 					
 					$("#verifyCodeImage2").click(function(){
 						loadVerifyCode("verifyCodeImage2");
 					});
 					
 					loadVerifyCode("verifyCodeImage2");
 					
 					$("#liuyanContent").keyup(function(){
 						var _this = $(this);
 						var inputCount = _this.val().length;
 						var avaliable = 300 - inputCount;
 						if(avaliable<0){
 							_this.val(_this.val().substring(0,300));
 							avaliable = 0;
 						}
 						$("#wordLimit").html(avaliable);
 						
 					});
 					
 				});
 			});
 			
 			$("#chaxun").click(function(){
 				loadWaitDialog();
 				$.get(basePath + 'query.do',function(d){
 					closeWaitDialog();
 					var dialog = $('<div class="dialog-content" id="query" style="width:500px;height:300px;"></div>').html(d).dialog({
 	 					title : "查询中心",
 	 					width:600,
 	 					height:400,
 	 					modal:true,
 	 					buttons: {
 	 						/* "关闭" : function(){
 	 							$(".xdsoft_close").trigger("click");
 	 							return false;
 	 						} */
 	 					},
 	 				});
 					
 					$(".input-center").unbind("keydown").on("keydown",function(e){
 						if(e.keyCode==13){
	 						e.preventDefault();
	 						
	 						$(this).parent().parent().find(".query-btn").first().trigger("click");
	 						
	 						return false;
 						}
 					});
 					
 					$("#query").find(".query-btn").each(function(){
 						var _this = $(this);
 						_this.click(function(){
 							var input = _this.parents("td").first().find("input").first();
 							var key = input.val();
 							if(!key || key.trim()==""){
 								$("<div><strong>请输入要查询的关键字</strong></div>").dialog({
 									title:'提示',
									buttons: {
			 	 						"确定":function(){
			 	 							input.focus();
			 	 							input.val("");
			 	 							return true;
			 	 						}
									}
 								});
 								return;
 							}
 							var queryType = _this.data("query-type");
 							var title = '会员单位';
 							if(queryType=='qualityArchive'){
 								title = "质量档案";
 							}else if(queryType =='authOrg'){
 								title = "授权机构";
 							}else if(queryType =='worker'){
 								title = "工作人员";
 							}
 							$.post(basePath + "query.do",{key:key,queryType:queryType},function(res){
 								$('<div class="dialog-content" id="query" style="width:500px;height:380px;overflow:auto;">'  + res + '</div>').dialog({
 									title:title,
									buttons: {
			 	 					/* 	"关闭":function(){
			 	 							return true;
			 	 						} */
									}
 								});
 							});
 						});
 					});
 					
 					
 				});
 				
 			});
 			
 			
 		});
 		
 		function loadVerifyCode(id){
	  		$("#" + id).attr("src","${basePath}verifyimage.create?t="+new Date().getTime());
	  	}
 		
 		function loadWaitDialog(){
 			$("<div class='jquery-dialog-wait' id='wait-dialog'></div>").dialog({
 				modal:true,
 				closeBtn:false,
 				title:'加载中，请稍后'
 			});
 		}
 		function closeWaitDialog(){
 			window.setTimeout(function(){
	 			$("#wait-dialog").parents(".xdsoft_dialog_shadow_effect").first().find(".xdsoft_close").first().trigger("click");
 			},200);
 		}
 		
 		
 		function loadApplyUI(){
 			$.get(basePath + 'apply.do',function(d){
					closeWaitDialog();
					$('<div class="dialog-content" id="apply" style="width:735px;height:400px;"></div>').html(d).dialog({
	 					title : "申请信息",
	 					width:600,
	 					height:400,
	 					modal:true,
	 					buttons: {
	 						"提交":function(){
	 							if($("#apply-form").valid({errorPlacement:function(){}})){
	 								var data = $("#apply-form").serializeArray();
	 								$.post(basePath + "apply.do",data,function(res){
	 									if(res.statusCode!='200'){
	 										//alert(res.message);
	 										$("<div style='text-align:center;font-size:18px;'>" + res.message + "</div>").dialog({
	 											title:'提示',
	 											buttons: {
	 					 	 						"确定":function(){
	 					 	 							return true;
	 					 	 						}
	 											}
	 										});
	 									}else{
	 										$("<div style='text-align:center;font-size:18px;margin-top:10px;'>" + res.message + "</div>").dialog({
	 											title:'提示',
	 											buttons: {
	 					 	 						"确定":function(){
 	 					 	 						$("#apply").dialog("close");
 	 	 	 		 	 							$(".xdsoft_close").trigger("click");
	 					 	 							return true;
	 					 	 						}
	 											}
	 										});
	 									}
	 								});
	 							}
	 							return false;
	 						},
	 						/* "取消" : function(){
	 							$("#apply").dialog("close");
	 							$(".xdsoft_close").trigger("click");
	 							return false;
	 						} */
	 					},
	 				});
					
					for(var i = 0;i<cities.length;i++){
						$("#p").append($("<option value='"+ cities[i].name +"'>" + cities[i].name +  "</option>"));
					}
					$("#p").change(function(){
						var _p = $(this).val();
						$("#s").html("<option value=''>市辖区</option>");
						$("#c").html("<option value=''>城区</option>");
						for(var i = 0;i<cities.length;i++){
							if(cities[i].name == _p){
								for(var j  = 0;j<cities[i].city.length;j++){
									$("#s").append($("<option value='"+ cities[i].city[j].name +"'>" + cities[i].city[j].name +  "</option>"));
								}
								break;
							}
						}
					});
					
					$("#s").change(function(){
						var _s = $(this).val();
						$("#c").html("<option value=''>城区</option>");
						for(var i = 0;i<cities.length;i++){
							for(var j  = 0;j<cities[i].city.length;j++){
								if(cities[i].city[j].name == _s){
									for(var x  = 0;x<cities[i].city[j].area.length;x++){
										$("#c").append($("<option value='"+ cities[i].city[j].area[x] +"'>" + cities[i].city[j].area[x] +  "</option>"));
									}
									break;
								}
							}
						}
					});
					
					$("#c").change(function(){
						
						$("#address").val($("#p").val() + "," + $("#s").val() + "," + $("#c").val());
						
					});
					
					$("#verifyCodeImage").click(function(){
						loadVerifyCode();
					});
					loadVerifyCode();
					
				});
 		}
 		</script>
 		<script type="text/javascript" src="${basePath}js/city.js"></script>
		  