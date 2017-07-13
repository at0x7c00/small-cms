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
import me.huqiao.smallcms.common.entity.enumtype.UseStatus;
import me.huqiao.smallcms.common.entity.propertyeditor.CommonFileEditor;
import me.huqiao.smallcms.common.service.ICommonFileService;
import me.huqiao.smallcms.ppll.entity.Brand;
import me.huqiao.smallcms.ppll.service.IBrandService;
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
 * 品牌展示控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("brand")
public class BrandController  extends BaseController {
   /**品牌展示服务*/
    @Resource
    private IBrandService brandService;
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
		  * @return Brand 品牌展示对象
		  */
		@ModelAttribute(value="brand")
		public Brand initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		Brand brand = null;
		if (manageKey == null ||manageKey.equals("")) {
			brand = new Brand();
		} else {
			brand =  brandService.getEntityByProperty(Brand.class,"manageKey", manageKey);
			if (brand==null) {
				brand=new Brand();
			}
		}
		return brand;
	}
    /**
     * 品牌展示分页查询
     * @param request HttpServletRequest对象
     * @param brand 品牌展示查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,Brand brand,Page pageInfo) {
        Page<Brand> brandPage = brandService.getListPage(brand,pageInfo);
        request.setAttribute("pageBean", brandPage);
		listFormParam(request,brand,pageInfo);
    }
 	/**
     * 为品牌展示分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param brand 品牌展示查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,Brand brand,Page pageInfo){
		//复杂关联关系数据准备
					List<CommonFile> commonFileList = commonFileService.getByProperties(CommonFile.class,null,null,null,null);
	request.setAttribute("commonFileList",commonFileList);
request.setAttribute("useStatusMap",UseStatus.useStatusMap);
	}
    /**
     * 添加品牌展示页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
					List<CommonFile> commonFileList = commonFileService.getByProperties(CommonFile.class,null,null,null,null);
	request.setAttribute("commonFileList",commonFileList);
request.setAttribute("useStatusMap",UseStatus.useStatusMap);
		//clearTempDataList(request.getSession(),"brand");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加品牌展示
     * @param request HttpServletRequest对象
     * @param brand 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("brand") Brand brand,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	//默认系统时间类型保存
	/*
		#ONE_TO_MANY_VALUE_SAVE_ADD
	*/
	    //保存多对多关联关系
		brand.setLogo(parseFilee(request,"logoKeys",null));
	//保持一对多关联关系
	brand.setManageKey(Md5Util.getManageKey());
    	brandService.add(brand);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改品牌展示页面
     * @param brand 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="brand") Brand brand,HttpServletRequest request) {
	request.setAttribute("tempBean", brand);
    	//复杂关联关系数据准备
					List<CommonFile> commonFileList = commonFileService.getByProperties(CommonFile.class,null,null,null,null);
	request.setAttribute("commonFileList",commonFileList);
request.setAttribute("useStatusMap",UseStatus.useStatusMap);
	//clearTempDataList(request.getSession(),"brand");
    }
    /**
     *  修改品牌展示 
     * @param brand 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="brand") Brand brand,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
	    //保存多对多关联关系
		String oldKey = null;
		if(brand.getLogo()!=null){
			oldKey = brand.getLogo().getManageKey();
		}
		brand.setLogo(parseFilee(request,"logoKeys",oldKey));
		//保持一对多关联关系
        brandService.update(brand);
	// jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看品牌展示页面
     * @param brand 需要查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="brand") Brand brand,HttpServletRequest request) {
	request.setAttribute("tempBean", brand);
    	//复杂关联关系数据准备
        listFormParam(request,brand,null);
    }
	/**
     * 删除单个品牌展示对象
     * @param request HttpServletRequest对象
     * @param brand 待删除对象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute Brand brand) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	brandService.delete(brand);
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
    	Brand brand = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			brand = brandService.getEntityByProperty(Brand.class,"manageKey",manageKey);
		markFileAsUnuse(brand.getLogo());
    			brandService.delete(brand);
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
		List<Brand> brands = new ArrayList<Brand>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				Brand temp_brand = brandService.getEntityByProperty(Brand.class, "manageKey", manageKey);
				if(temp_brand!=null && !brands.contains(temp_brand)){
					brands.add(temp_brand);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("brands",brands);
		return "brand/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param brand 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,Brand brand,Page pageInfo){
		Page<HistoryRecord<Brand>> brandPage = brandService.getHistoryListPage(brand, pageInfo);
		request.setAttribute("pageBean", brandPage);
		request.setAttribute("manageKey", brand.getManageKey());
	    return "brand/history-list";
	} */
	/**
	 * 查看历史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		Brand brand = brandService.findByVersion(version);
		Brand preBrand = (Brand)brandService.findByPreVersion(Brand.class,brand.getManageKey(),version);
		if(preBrand!=null && preBrand.getManageKey().equals(brand.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preBrand, brand);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", brand);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "brand/detail";
	}*/
	/**
	 * 根据关键字获取品牌展示select2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<Brand> 品牌展示Select2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<Brand> select2Query(String queryKey,Page<Brand> pageInfo, HttpServletResponse response) {
		Page<Brand> page = brandService.queryByKey(queryKey, pageInfo);
		Select2<Brand> select2 = new Select2<Brand>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个品牌展示
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<Brand> 品牌展示列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<Brand> queryById(Integer[] ids,HttpServletResponse response) {
		List<Brand> brandList = brandService.queryById(ids);
		return brandList;
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
			@ModelAttribute(value="brand") Brand brand,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",brand);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "brand/tab-add-form";
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
			@ModelAttribute(value="brand") Brand brand,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",brand);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "brand/tab-detail-form";
	}
}