package me.huqiao.smallcms.cms.controller;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import me.huqiao.smallcms.cms.entity.Comment;
import me.huqiao.smallcms.cms.service.ICommentService;
import me.huqiao.smallcms.common.controller.BaseController;
import me.huqiao.smallcms.common.entity.Select2;
import me.huqiao.smallcms.sys.entity.enumtype.YesNo;
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
 * 留言控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("comment")
public class CommentController  extends BaseController {
   /**留言服务*/
    @Resource
    private ICommentService commentService;
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
		  * @return Comment 留言对象
		  */
		@ModelAttribute(value="comment")
		public Comment initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		Comment comment = null;
		if (manageKey == null ||manageKey.equals("")) {
			comment = new Comment();
		} else {
			comment =  commentService.getEntityByProperty(Comment.class,"manageKey", manageKey);
			if (comment==null) {
				comment=new Comment();
			}
		}
		return comment;
	}
    /**
     * 留言分页查询
     * @param request HttpServletRequest对象
     * @param comment 留言查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,Comment comment,Page pageInfo) {
        Page<Comment> commentPage = commentService.getListPage(comment,pageInfo);
        request.setAttribute("pageBean", commentPage);
		listFormParam(request,comment,pageInfo);
    }
 	/**
     * 为留言分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param comment 留言查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,Comment comment,Page pageInfo){
		//复杂关联关系数据准备
request.setAttribute("yesNoMap",YesNo.yesNoMap);
	}
    /**
     * 添加留言页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
request.setAttribute("yesNoMap",YesNo.yesNoMap);
		//clearTempDataList(request.getSession(),"comment");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加留言
     * @param request HttpServletRequest对象
     * @param comment 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("comment") Comment comment,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	//默认系统时间类型保存
	/*
		#ONE_TO_MANY_VALUE_SAVE_ADD
	*/
	    //保存多对多关联关系
	//保持一对多关联关系
	comment.setManageKey(Md5Util.getManageKey());
    	commentService.add(comment);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改留言页面
     * @param comment 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="comment") Comment comment,HttpServletRequest request) {
	request.setAttribute("tempBean", comment);
    	//复杂关联关系数据准备
request.setAttribute("yesNoMap",YesNo.yesNoMap);
	//clearTempDataList(request.getSession(),"comment");
    }
    /**
     *  修改留言 
     * @param comment 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="comment") Comment comment,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
	    //保存多对多关联关系
		//保持一对多关联关系
        commentService.update(comment);
	// jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看留言页面
     * @param comment 需要查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="comment") Comment comment,HttpServletRequest request) {
	request.setAttribute("tempBean", comment);
    	//复杂关联关系数据准备
        listFormParam(request,comment,null);
    }
	/**
     * 删除单个留言对象
     * @param request HttpServletRequest对象
     * @param comment 待删除对象
     * @return JsonResult 操作结��
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute Comment comment) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	commentService.delete(comment);
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
    	Comment comment = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			comment = commentService.getEntityByProperty(Comment.class,"manageKey",manageKey);
    			commentService.delete(comment);
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
		List<Comment> comments = new ArrayList<Comment>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				Comment temp_comment = commentService.getEntityByProperty(Comment.class, "manageKey", manageKey);
				if(temp_comment!=null && !comments.contains(temp_comment)){
					comments.add(temp_comment);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("comments",comments);
		return "comment/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param comment 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,Comment comment,Page pageInfo){
		Page<HistoryRecord<Comment>> commentPage = commentService.getHistoryListPage(comment, pageInfo);
		request.setAttribute("pageBean", commentPage);
		request.setAttribute("manageKey", comment.getManageKey());
	    return "comment/history-list";
	} */
	/**
	 * 查看历史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		Comment comment = commentService.findByVersion(version);
		Comment preComment = (Comment)commentService.findByPreVersion(Comment.class,comment.getManageKey(),version);
		if(preComment!=null && preComment.getManageKey().equals(comment.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preComment, comment);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", comment);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "comment/detail";
	}*/
	/**
	 * 根据关键字获取留言select2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<Comment> 留言Select2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<Comment> select2Query(String queryKey,Page<Comment> pageInfo, HttpServletResponse response) {
		Page<Comment> page = commentService.queryByKey(queryKey, pageInfo);
		Select2<Comment> select2 = new Select2<Comment>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个留言
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<Comment> 留言列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<Comment> queryById(Integer[] ids,HttpServletResponse response) {
		List<Comment> commentList = commentService.queryById(ids);
		return commentList;
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
			@ModelAttribute(value="comment") Comment comment,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",comment);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "comment/tab-add-form";
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
			@ModelAttribute(value="comment") Comment comment,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",comment);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "comment/tab-detail-form";
	}
}