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
import me.huqiao.smallcms.ppll.entity.ZwCode;
import me.huqiao.smallcms.ppll.service.IZwCodeService;
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
 * 质维码控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("zwCode")
public class ZwCodeController  extends BaseController {
   /**质维码服务*/
    @Resource
    private IZwCodeService zwCodeService;
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
		  * @return ZwCode 质维码对象
		  */
		@ModelAttribute(value="zwCode")
		public ZwCode initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		ZwCode zwCode = null;
		if (manageKey == null ||manageKey.equals("")) {
			zwCode = new ZwCode();
		} else {
			zwCode =  zwCodeService.getEntityByProperty(ZwCode.class,"manageKey", manageKey);
			if (zwCode==null) {
				zwCode=new ZwCode();
			}
		}
		return zwCode;
	}
    /**
     * 质维码分页查询
     * @param request HttpServletRequest对象
     * @param zwCode 质维码查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,ZwCode zwCode,Page pageInfo) {
        Page<ZwCode> zwCodePage = zwCodeService.getListPage(zwCode,pageInfo);
        request.setAttribute("pageBean", zwCodePage);
		listFormParam(request,zwCode,pageInfo);
    }
 	/**
     * 为质维码分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param zwCode 质维码查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,ZwCode zwCode,Page pageInfo){
		//复杂关联关系数据准备
					List<CommonFile> commonFileList = commonFileService.getByProperties(CommonFile.class,null,null,null,null);
	request.setAttribute("commonFileList",commonFileList);
	}
    /**
     * 添加质维码页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
					List<CommonFile> commonFileList = commonFileService.getByProperties(CommonFile.class,null,null,null,null);
	request.setAttribute("commonFileList",commonFileList);
		//clearTempDataList(request.getSession(),"zwCode");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加质维码
     * @param request HttpServletRequest对象
     * @param zwCode 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("zwCode") ZwCode zwCode,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	//默认系统时间类型保存
	/*
		#ONE_TO_MANY_VALUE_SAVE_ADD
	*/
	    //保存多对多关联关系
		zwCode.setCode(parseFilee(request,"codeKeys",null));
	//保持一对多关联关系
	zwCode.setManageKey(Md5Util.getManageKey());
    	zwCodeService.add(zwCode);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改质维码页面
     * @param zwCode 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="zwCode") ZwCode zwCode,HttpServletRequest request) {
	request.setAttribute("tempBean", zwCode);
    	//复杂关联关系数据准备
					List<CommonFile> commonFileList = commonFileService.getByProperties(CommonFile.class,null,null,null,null);
	request.setAttribute("commonFileList",commonFileList);
	//clearTempDataList(request.getSession(),"zwCode");
    }
    /**
     *  修改质维码 
     * @param zwCode 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="zwCode") ZwCode zwCode,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
	    //保存多对多关联关系
		String oldKey = null;
		if(zwCode.getCode()!=null){
			oldKey = zwCode.getCode().getManageKey();
		}
		zwCode.setCode(parseFilee(request,"codeKeys",oldKey));
		//保持一对多关联关系
        zwCodeService.update(zwCode);
	// jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看质维码页面
     * @param zwCode 需要查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="zwCode") ZwCode zwCode,HttpServletRequest request) {
	request.setAttribute("tempBean", zwCode);
    	//复杂关联关系数据准备
        listFormParam(request,zwCode,null);
    }
	/**
     * 删除单个质维码对象
     * @param request HttpServletRequest对象
     * @param zwCode 待删除对象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute ZwCode zwCode) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	zwCodeService.delete(zwCode);
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
    	ZwCode zwCode = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			zwCode = zwCodeService.getEntityByProperty(ZwCode.class,"manageKey",manageKey);
		markFileAsUnuse(zwCode.getCode());
    			zwCodeService.delete(zwCode);
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
		List<ZwCode> zwCodes = new ArrayList<ZwCode>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				ZwCode temp_zwCode = zwCodeService.getEntityByProperty(ZwCode.class, "manageKey", manageKey);
				if(temp_zwCode!=null && !zwCodes.contains(temp_zwCode)){
					zwCodes.add(temp_zwCode);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("zwCodes",zwCodes);
		return "zwCode/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param zwCode 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,ZwCode zwCode,Page pageInfo){
		Page<HistoryRecord<ZwCode>> zwCodePage = zwCodeService.getHistoryListPage(zwCode, pageInfo);
		request.setAttribute("pageBean", zwCodePage);
		request.setAttribute("manageKey", zwCode.getManageKey());
	    return "zwCode/history-list";
	} */
	/**
	 * 查看历史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		ZwCode zwCode = zwCodeService.findByVersion(version);
		ZwCode preZwCode = (ZwCode)zwCodeService.findByPreVersion(ZwCode.class,zwCode.getManageKey(),version);
		if(preZwCode!=null && preZwCode.getManageKey().equals(zwCode.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preZwCode, zwCode);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", zwCode);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "zwCode/detail";
	}*/
	/**
	 * 根据关键字获取质维码select2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<ZwCode> 质维码Select2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<ZwCode> select2Query(String queryKey,Page<ZwCode> pageInfo, HttpServletResponse response) {
		Page<ZwCode> page = zwCodeService.queryByKey(queryKey, pageInfo);
		Select2<ZwCode> select2 = new Select2<ZwCode>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个质维码
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<ZwCode> 质维码列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<ZwCode> queryById(Integer[] ids,HttpServletResponse response) {
		List<ZwCode> zwCodeList = zwCodeService.queryById(ids);
		return zwCodeList;
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
			@ModelAttribute(value="zwCode") ZwCode zwCode,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",zwCode);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "zwCode/tab-add-form";
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
			@ModelAttribute(value="zwCode") ZwCode zwCode,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",zwCode);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "zwCode/tab-detail-form";
	}
}