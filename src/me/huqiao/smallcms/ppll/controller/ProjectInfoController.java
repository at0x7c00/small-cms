package me.huqiao.smallcms.ppll.controller;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import me.huqiao.smallcms.common.controller.BaseController;
import me.huqiao.smallcms.common.entity.CommonFile;
import me.huqiao.smallcms.common.entity.Select2;
import me.huqiao.smallcms.common.entity.propertyeditor.CommonFileEditor;
import me.huqiao.smallcms.common.service.ICommonFileService;
import me.huqiao.smallcms.ppll.entity.ProjectInfo;
import me.huqiao.smallcms.ppll.service.IProjectInfoService;
import me.huqiao.smallcms.util.Md5Util;
import me.huqiao.smallcms.util.web.JsonResult;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 项目简介控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("projectInfo")
public class ProjectInfoController  extends BaseController {
   /**项目简介服务*/
    @Resource
    private IProjectInfoService projectInfoService;
 /**
  * 注册属性编辑器
  * @param binder 数据绑定器
  */
    @InitBinder
	public void initPropEditor(WebDataBinder binder){
         binder.registerCustomEditor(CommonFile.class,new CommonFileEditor(commonFileService));
	}
    //复杂关联关系的Service
@Resource private ICommonFileService commonFileService;
		/**
		  * 初始化ModelAttribute
		  * @param manageKey md5管理ID （非空时自动加载指定对象）
		  * @param model 页面model对象
		  * @return ProjectInfo 项目简介对象
		  */
		@ModelAttribute(value="projectInfo")
		public ProjectInfo initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		ProjectInfo projectInfo = null;
		if (manageKey == null ||manageKey.equals("")) {
			projectInfo = new ProjectInfo();
		} else {
			projectInfo =  projectInfoService.getEntityByProperty(ProjectInfo.class,"manageKey", manageKey);
			if (projectInfo==null) {
				projectInfo=new ProjectInfo();
			}
		}
		return projectInfo;
	}
    /**
     * 项目简介分页查询
     * @param request HttpServletRequest对象
     * @param projectInfo 项目简介查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,ProjectInfo projectInfo,Page pageInfo) {
        Page<ProjectInfo> projectInfoPage = projectInfoService.getListPage(projectInfo,pageInfo);
        request.setAttribute("pageBean", projectInfoPage);
		listFormParam(request,projectInfo,pageInfo);
    }
 	/**
     * 为项目简介分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param projectInfo 项目简介查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,ProjectInfo projectInfo,Page pageInfo){
		//复杂关联关系数据准备
					List<CommonFile> commonFileList = commonFileService.getByProperties(CommonFile.class,null,null,null,null);
	request.setAttribute("commonFileList",commonFileList);
	}
    /**
     * 添加项目简介页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
					List<CommonFile> commonFileList = commonFileService.getByProperties(CommonFile.class,null,null,null,null);
	request.setAttribute("commonFileList",commonFileList);
		//clearTempDataList(request.getSession(),"projectInfo");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加项目简介
     * @param request HttpServletRequest对象
     * @param projectInfo 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("projectInfo") ProjectInfo projectInfo,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	//默认系统时间类型保存
	/*
		#ONE_TO_MANY_VALUE_SAVE_ADD
	*/
	    //保存多对多关联关系
		projectInfo.setCover(parseFilee(request,"coverKeys",null));
	//保持一对多关联关系
	projectInfo.setManageKey(Md5Util.getManageKey());
    	projectInfoService.add(projectInfo);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改项目简介页面
     * @param projectInfo 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="projectInfo") ProjectInfo projectInfo,HttpServletRequest request) {
	request.setAttribute("tempBean", projectInfo);
    	//复杂关联关系数据准备
					List<CommonFile> commonFileList = commonFileService.getByProperties(CommonFile.class,null,null,null,null);
	request.setAttribute("commonFileList",commonFileList);
	//clearTempDataList(request.getSession(),"projectInfo");
    }
    /**
     *  修改项目简介 
     * @param projectInfo 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="projectInfo") ProjectInfo projectInfo,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
	    //保存多对多关联关系
		String oldKey = null;
		if(projectInfo.getCover()!=null){
			oldKey = projectInfo.getCover().getManageKey();
		}
		projectInfo.setCover(parseFilee(request,"coverKeys",oldKey));
		//保持一对多关联关系
        projectInfoService.update(projectInfo);
	// jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看项目简介页面
     * @param projectInfo 需要查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="projectInfo") ProjectInfo projectInfo,HttpServletRequest request) {
	request.setAttribute("tempBean", projectInfo);
    	//复杂关联关系数据准备
        listFormParam(request,projectInfo,null);
    }
	/**
     * 删除单个项目简介对象
     * @param request HttpServletRequest对象
     * @param projectInfo 待删除对象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute ProjectInfo projectInfo) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	projectInfoService.delete(projectInfo);
		} catch (RuntimeException re) {
			jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.delete.inuse"));
			return jsonResult;
		}catch (Exception e) {
			jsonResult.setMessage(e.toString());
			return jsonResult;
		}
	//jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.delete.success"));
        return jsonResult;
    }
    /**
     * 删除多个对象
     * @param manageKeys 唯一识别ID数组
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.POST)
    @ResponseBody
	public JsonResult batchDelete(HttpServletRequest request,@RequestParam("manageKeys") String[] manageKeys) {
    	ProjectInfo projectInfo = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			projectInfo = projectInfoService.getEntityByProperty(ProjectInfo.class,"manageKey",manageKey);
		markFileAsUnuse(projectInfo.getCover());
    			projectInfoService.delete(projectInfo);
			}catch (RuntimeException re) {
				jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.delete.inuse"));
				return jsonResult;
			}catch (Exception e) {
				jsonResult.setMessage(e.toString());
				return jsonResult;
			}
    	}
		jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.delete.success"));
    	return jsonResult;
    } 
	 /**
	  *选择对象返回html
      *@param request HttpServletRequest对象
	  *@param manageKeys manageKey 数组
	  *@return String 返回jsp页面路径
      */
	@RequestMapping(value = "/selectList",params = "htmlType")
	public String selectListWithHtml(HttpServletRequest request,
			@RequestParam(value = "manageKey",required = false)String[] manageKeys
			){
		List<ProjectInfo> projectInfos = new ArrayList<ProjectInfo>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				ProjectInfo temp_projectInfo = projectInfoService.getEntityByProperty(ProjectInfo.class, "manageKey", manageKey);
				if(temp_projectInfo!=null && !projectInfos.contains(temp_projectInfo)){
					projectInfos.add(temp_projectInfo);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("projectInfos",projectInfos);
		return "projectInfo/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param projectInfo 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,ProjectInfo projectInfo,Page pageInfo){
		Page<HistoryRecord<ProjectInfo>> projectInfoPage = projectInfoService.getHistoryListPage(projectInfo, pageInfo);
		request.setAttribute("pageBean", projectInfoPage);
		request.setAttribute("manageKey", projectInfo.getManageKey());
	    return "projectInfo/history-list";
	} */
	/**
	 * 查看历史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		ProjectInfo projectInfo = projectInfoService.findByVersion(version);
		ProjectInfo preProjectInfo = (ProjectInfo)projectInfoService.findByPreVersion(ProjectInfo.class,projectInfo.getManageKey(),version);
		if(preProjectInfo!=null && preProjectInfo.getManageKey().equals(projectInfo.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preProjectInfo, projectInfo);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", projectInfo);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "projectInfo/detail";
	}*/
	/**
	 * 根据关键字获取项目简介select2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<ProjectInfo> 项目简介Select2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<ProjectInfo> select2Query(String queryKey,Page<ProjectInfo> pageInfo, HttpServletResponse response) {
		Page<ProjectInfo> page = projectInfoService.queryByKey(queryKey, pageInfo);
		Select2<ProjectInfo> select2 = new Select2<ProjectInfo>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个项目��介
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<ProjectInfo> 项目简介列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<ProjectInfo> queryById(Integer[] ids,HttpServletResponse response) {
		List<ProjectInfo> projectInfoList = projectInfoService.queryById(ids);
		return projectInfoList;
	}
	/**
	 * tab页添加表单
	 * @param trTarget tr的target值
	 * @param trIndex tr的序号
     * @param propName 表单元素name前缀
	 * @return String jsp路径
	 */
	@RequestMapping(value = "/tabAddForm")
public String tabAddForm(
			@ModelAttribute(value="projectInfo") ProjectInfo projectInfo,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",projectInfo);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "projectInfo/tab-add-form";
	}
/**
	 * tab页查看详情页面
	 * @param trTarget tr的target值
	 * @param trIndex tr的序号
     * @param propName 表单元素name前缀
	 * @return String jsp路径
	 */
	@RequestMapping(value = "/tabDetailForm")
	public String tabDetailForm(
			@ModelAttribute(value="projectInfo") ProjectInfo projectInfo,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",projectInfo);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "projectInfo/tab-detail-form";
	}
}