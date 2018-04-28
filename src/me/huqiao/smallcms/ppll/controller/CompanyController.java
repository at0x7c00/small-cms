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
import me.huqiao.smallcms.ppll.entity.Company;
import me.huqiao.smallcms.ppll.service.ICompanyService;
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
 * 收录企业控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("company")
public class CompanyController  extends BaseController {
   /**收录企业服务*/
    @Resource
    private ICompanyService companyService;
 /**
  * 注册属性编辑器
  * @param binder 数据绑定器
  */
    @InitBinder
	public void initPropEditor(WebDataBinder binder){
         binder.registerCustomEditor(CommonFile.class,new CommonFileEditor(commonFileService));
         binder.registerCustomEditor(CommonFile.class,new CommonFileEditor(commonFileService));
	}
    //复杂关联关系的Service
    @Resource private ICommonFileService commonFileService;
		/**
		  * 初始化ModelAttribute
		  * @param manageKey md5管理ID （非空时自动加载指定对象）
		  * @param model 页面model对象
		  * @return Company 收录企业对象
		  */
		@ModelAttribute(value="company")
		public Company initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		Company company = null;
		if (manageKey == null ||manageKey.equals("")) {
			company = new Company();
		} else {
			company =  companyService.getEntityByProperty(Company.class,"manageKey", manageKey);
			if (company==null) {
				company=new Company();
			}
		}
		return company;
	}
    /**
     * 收录企业分页查询
     * @param request HttpServletRequest对象
     * @param company 收录企业查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,Company company,Page pageInfo) {
        Page<Company> companyPage = companyService.getListPage(company,pageInfo);
        request.setAttribute("pageBean", companyPage);
		listFormParam(request,company,pageInfo);
    }
 	/**
     * 为收录企业分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param company 收录企业查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,Company company,Page pageInfo){
		//复杂关联关系数据准备
					List<CommonFile> commonFileList = commonFileService.getByProperties(CommonFile.class,null,null,null,null);
	request.setAttribute("commonFileList",commonFileList);
	}
    /**
     * 添加收录企业页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
					List<CommonFile> commonFileList = commonFileService.getByProperties(CommonFile.class,null,null,null,null);
	request.setAttribute("commonFileList",commonFileList);
		//clearTempDataList(request.getSession(),"company");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加收录企业
     * @param request HttpServletRequest对象
     * @param company 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("company") Company company,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	//默认系统时间类型保存
	/*
		#ONE_TO_MANY_VALUE_SAVE_ADD
	*/
	    //保存多对多关联关系
		company.setLicense(parseFilee(request,"licenseKeys",null));
		company.setApply(parseFilee(request,"applyKeys",null));
	//保持一对多关联关系
	company.setManageKey(Md5Util.getManageKey());
    	companyService.add(company);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改收录企业页面
     * @param company 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="company") Company company,HttpServletRequest request) {
	request.setAttribute("tempBean", company);
    	//复杂关联关系数据准备
					List<CommonFile> commonFileList = commonFileService.getByProperties(CommonFile.class,null,null,null,null);
	request.setAttribute("commonFileList",commonFileList);
	//clearTempDataList(request.getSession(),"company");
    }
    /**
     *  修改收录企业 
     * @param company 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="company") Company company,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
	    //保存多对多关联关系
		String oldKey = null;
		if(company.getLicense()!=null){
			oldKey = company.getLicense().getManageKey();
		}
		company.setLicense(parseFilee(request,"licenseKeys",oldKey));
		String oldKey2 = null;
		if(company.getApply()!=null){
			oldKey2 = company.getApply().getManageKey();
		}
		company.setApply(parseFilee(request,"applyKeys",oldKey2));
		//保持一对多关联关系
        companyService.update(company);
	// jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看收录企业页面
     * @param company 需要查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="company") Company company,HttpServletRequest request) {
	request.setAttribute("tempBean", company);
    	//复杂关联关系数据准备
        listFormParam(request,company,null);
    }
	/**
     * 删除单个收录企业对象
     * @param request HttpServletRequest对象
     * @param company 待删除对象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute Company company) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	companyService.delete(company);
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
    	Company company = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			company = companyService.getEntityByProperty(Company.class,"manageKey",manageKey);
		markFileAsUnuse(company.getLicense());
		markFileAsUnuse(company.getApply());
    			companyService.delete(company);
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
		List<Company> companys = new ArrayList<Company>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				Company temp_company = companyService.getEntityByProperty(Company.class, "manageKey", manageKey);
				if(temp_company!=null && !companys.contains(temp_company)){
					companys.add(temp_company);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("companys",companys);
		return "company/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param company 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,Company company,Page pageInfo){
		Page<HistoryRecord<Company>> companyPage = companyService.getHistoryListPage(company, pageInfo);
		request.setAttribute("pageBean", companyPage);
		request.setAttribute("manageKey", company.getManageKey());
	    return "company/history-list";
	} */
	/**
	 * 查看历史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		Company company = companyService.findByVersion(version);
		Company preCompany = (Company)companyService.findByPreVersion(Company.class,company.getManageKey(),version);
		if(preCompany!=null && preCompany.getManageKey().equals(company.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preCompany, company);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", company);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "company/detail";
	}*/
	/**
	 * 根据关键字获取收录企业select2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<Company> 收录企业Select2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<Company> select2Query(String queryKey,Page<Company> pageInfo, HttpServletResponse response) {
		Page<Company> page = companyService.queryByKey(queryKey, pageInfo);
		Select2<Company> select2 = new Select2<Company>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个收录企业
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<Company> 收录企业列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<Company> queryById(Integer[] ids,HttpServletResponse response) {
		List<Company> companyList = companyService.queryById(ids);
		return companyList;
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
			@ModelAttribute(value="company") Company company,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",company);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "company/tab-add-form";
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
			@ModelAttribute(value="company") Company company,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",company);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "company/tab-detail-form";
	}
}