package me.huqiao.smallcms.cms.controller;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import me.huqiao.smallcms.cms.entity.AccessRecord;
import me.huqiao.smallcms.cms.service.IAccessRecordService;
import me.huqiao.smallcms.common.controller.BaseController;
import me.huqiao.smallcms.common.entity.Select2;
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
 * 访问记录控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("accessRecord")
public class AccessRecordController  extends BaseController {
   /**访问记录服务*/
    @Resource
    private IAccessRecordService accessRecordService;
 /**
  * 注册属性编辑器
  * @param binder 数据绑定器
  */
    @InitBinder
	public void initPropEditor(WebDataBinder binder){
	}
    //复杂关联关系的Service
		/**
		  * 初始化ModelAttribute
		  * @param manageKey md5管理ID （非空时自动加载指定对象）
		  * @param model 页面model对象
		  * @return AccessRecord 访问记录对象
		  */
		@ModelAttribute(value="accessRecord")
		public AccessRecord initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		AccessRecord accessRecord = null;
		if (manageKey == null ||manageKey.equals("")) {
			accessRecord = new AccessRecord();
		} else {
			accessRecord =  accessRecordService.getEntityByProperty(AccessRecord.class,"manageKey", manageKey);
			if (accessRecord==null) {
				accessRecord=new AccessRecord();
			}
		}
		return accessRecord;
	}
    /**
     * 访问记录分页查询
     * @param request HttpServletRequest对象
     * @param accessRecord 访问记录查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,AccessRecord accessRecord,Page pageInfo) {
        Page<AccessRecord> accessRecordPage = accessRecordService.getListPage(accessRecord,pageInfo);
        request.setAttribute("pageBean", accessRecordPage);
		listFormParam(request,accessRecord,pageInfo);
    }
 	/**
     * 为访问记录分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param accessRecord 访问记录查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,AccessRecord accessRecord,Page pageInfo){
		//复杂关联关系数据准备
	}
    /**
     * 添加访问记录页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
		//clearTempDataList(request.getSession(),"accessRecord");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加访问记录
     * @param request HttpServletRequest对象
     * @param accessRecord 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("accessRecord") AccessRecord accessRecord,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	//默认系统时间类型保存
	/*
		#ONE_TO_MANY_VALUE_SAVE_ADD
	*/
	    //保存多对多关联关系
	//保持一对多关联关系
	accessRecord.setManageKey(Md5Util.getManageKey());
    	accessRecordService.add(accessRecord);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改访问记录页面
     * @param accessRecord 需要修改的对象实体
     * @param request HttpServletRequest���求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="accessRecord") AccessRecord accessRecord,HttpServletRequest request) {
	request.setAttribute("tempBean", accessRecord);
    	//复杂关联关系数据准备
	//clearTempDataList(request.getSession(),"accessRecord");
    }
    /**
     *  修改访问记录 
     * @param accessRecord 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="accessRecord") AccessRecord accessRecord,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
	    //保存多对多关联关系
		//保持一对多关联关系
        accessRecordService.update(accessRecord);
	// jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看访问记录页面
     * @param accessRecord 需要查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="accessRecord") AccessRecord accessRecord,HttpServletRequest request) {
	request.setAttribute("tempBean", accessRecord);
    	//复杂关联关系数据准备
        listFormParam(request,accessRecord,null);
    }
	/**
     * 删除单个访问记录对象
     * @param request HttpServletRequest对象
     * @param accessRecord 待删除���象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute AccessRecord accessRecord) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	accessRecordService.delete(accessRecord);
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
    	AccessRecord accessRecord = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			accessRecord = accessRecordService.getEntityByProperty(AccessRecord.class,"manageKey",manageKey);
    			accessRecordService.delete(accessRecord);
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
		List<AccessRecord> accessRecords = new ArrayList<AccessRecord>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				AccessRecord temp_accessRecord = accessRecordService.getEntityByProperty(AccessRecord.class, "manageKey", manageKey);
				if(temp_accessRecord!=null && !accessRecords.contains(temp_accessRecord)){
					accessRecords.add(temp_accessRecord);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("accessRecords",accessRecords);
		return "accessRecord/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param accessRecord 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,AccessRecord accessRecord,Page pageInfo){
		Page<HistoryRecord<AccessRecord>> accessRecordPage = accessRecordService.getHistoryListPage(accessRecord, pageInfo);
		request.setAttribute("pageBean", accessRecordPage);
		request.setAttribute("manageKey", accessRecord.getManageKey());
	    return "accessRecord/history-list";
	} */
	/**
	 * 查看历史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		AccessRecord accessRecord = accessRecordService.findByVersion(version);
		AccessRecord preAccessRecord = (AccessRecord)accessRecordService.findByPreVersion(AccessRecord.class,accessRecord.getManageKey(),version);
		if(preAccessRecord!=null && preAccessRecord.getManageKey().equals(accessRecord.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preAccessRecord, accessRecord);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", accessRecord);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "accessRecord/detail";
	}*/
	/**
	 * 根据关键字获取访问记录select2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<AccessRecord> 访问记录Select2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<AccessRecord> select2Query(String queryKey,Page<AccessRecord> pageInfo, HttpServletResponse response) {
		Page<AccessRecord> page = accessRecordService.queryByKey(queryKey, pageInfo);
		Select2<AccessRecord> select2 = new Select2<AccessRecord>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个访问记录
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<AccessRecord> 访问记录列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<AccessRecord> queryById(Integer[] ids,HttpServletResponse response) {
		List<AccessRecord> accessRecordList = accessRecordService.queryById(ids);
		return accessRecordList;
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
			@ModelAttribute(value="accessRecord") AccessRecord accessRecord,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",accessRecord);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "accessRecord/tab-add-form";
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
			@ModelAttribute(value="accessRecord") AccessRecord accessRecord,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",accessRecord);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "accessRecord/tab-detail-form";
	}
}