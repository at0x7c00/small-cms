package me.huqiao.smallcms.cms.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.huqiao.smallcms.cms.entity.AccessRecord;
import me.huqiao.smallcms.cms.entity.Advertisement;
import me.huqiao.smallcms.cms.entity.Carousel;
import me.huqiao.smallcms.cms.entity.Chapter;
import me.huqiao.smallcms.cms.entity.Comment;
import me.huqiao.smallcms.cms.entity.FriendLink;
import me.huqiao.smallcms.cms.entity.SearchResult;
import me.huqiao.smallcms.cms.entity.propertyeditor.CommentEditor;
import me.huqiao.smallcms.cms.service.IAccessRecordService;
import me.huqiao.smallcms.cms.service.IAdvertisementService;
import me.huqiao.smallcms.cms.service.ICarouselService;
import me.huqiao.smallcms.cms.service.IChapterService;
import me.huqiao.smallcms.cms.service.ICommentService;
import me.huqiao.smallcms.cms.service.IFriendLinkService;
import me.huqiao.smallcms.common.entity.CommonFile;
import me.huqiao.smallcms.common.entity.enumtype.UseStatus;
import me.huqiao.smallcms.ppll.entity.Apply;
import me.huqiao.smallcms.ppll.entity.AuthOrg;
import me.huqiao.smallcms.ppll.entity.Brand;
import me.huqiao.smallcms.ppll.entity.Company;
import me.huqiao.smallcms.ppll.entity.MemberOrganization;
import me.huqiao.smallcms.ppll.entity.ProjectInfo;
import me.huqiao.smallcms.ppll.entity.QualityArchive;
import me.huqiao.smallcms.ppll.entity.QualityArchiveCategory;
import me.huqiao.smallcms.ppll.entity.QualityArchiveCompany;
import me.huqiao.smallcms.ppll.entity.Worker;
import me.huqiao.smallcms.ppll.entity.ZwCode;
import me.huqiao.smallcms.ppll.service.IApplyService;
import me.huqiao.smallcms.ppll.service.IAuthOrgService;
import me.huqiao.smallcms.ppll.service.IBrandService;
import me.huqiao.smallcms.ppll.service.ICompanyService;
import me.huqiao.smallcms.ppll.service.IMemberOrganizationService;
import me.huqiao.smallcms.ppll.service.IProjectInfoService;
import me.huqiao.smallcms.ppll.service.IQualityArchiveCategoryService;
import me.huqiao.smallcms.ppll.service.IQualityArchiveCompanyService;
import me.huqiao.smallcms.ppll.service.IQualityArchiveService;
import me.huqiao.smallcms.ppll.service.IWorkerService;
import me.huqiao.smallcms.ppll.service.IZwCodeService;
import me.huqiao.smallcms.servlet.VerifyImageServlet;
import me.huqiao.smallcms.util.Md5Util;
import me.huqiao.smallcms.util.StringUtil;
import me.huqiao.smallcms.util.web.JsonResult;
import me.huqiao.smallcms.util.web.Page;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * 轮播控制器
 * @author NOVOTS
 * @version Version 1.0
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class FrontendController {
	
	static Logger log = Logger.getLogger(FrontendController.class);
	
	private Integer PAGE_ID_ZHENGCE = 1;
	private Integer PAGE_ID_ZHILIANGREDIAN = 2;
	private Integer PAGE_ID_HUIYUANFENGCAI = 3;
	private Integer PAGE_ID_HANGYEZIXUN = 4;
	
	private Integer PAGE_ID_ZHILIANGBAOGUANG = 5;
	private Integer PAGE_ID_HUODONGHUIGU = 6;
	
	private Integer PAGE_ID_SHISHIREDIAN= 7;
	private Integer PAGE_ID_ZHILIANGQIANGQI= 8;
	
	@Resource
	private IChapterService chapterService;
	@Resource
	private ICarouselService carouselService;
	@Resource
	private IAdvertisementService adService;
	@Resource
	private IFriendLinkService flinkService;
	@Resource
	private IQualityArchiveService qualityArchiveService;
	@Resource
	private IQualityArchiveCategoryService qualityArchiveCategoryService;
	@Resource
	private IApplyService applyService;
	@Resource
	private IMemberOrganizationService memberOrgService;
	@Resource
	private IQualityArchiveCompanyService qaCompanyService;
	@Resource
	private ICompanyService comanyService;
	@Resource
	private IAuthOrgService authOrgService;
	@Resource
	private IWorkerService workerService;
	@Resource
	private IBrandService brandService;
	@Resource
	private ICommentService commentService;
	@Resource
	private IZwCodeService zwCodeService;
	@Resource
	private IAccessRecordService accessRecordService;
	@Resource
	IProjectInfoService projectInfoService;
	
	 /**
	  * 注册属性编辑器
	  * @param binder 数据绑定器
	  */
	    @InitBinder
		public void initPropEditor(WebDataBinder binder){
	    	binder.registerCustomEditor(Comment.class, new CommentEditor(commentService));
		}
	
	
	
	@RequestMapping("index")
	public void index(HttpServletRequest request){
		
		prepareCarousel(request);
		
		zhengceTop(request);
		currentEventsTop(request);
		zhiliangTop(request);
		qualityExposureTop(request);
		
		
		huiyuanTop(request);
		hangyeTop(request);
		
		//ad
		adTop(request);
		
		//friend link 
		friendLinkTop(request);
		
		qaTop(request);
		
		brand(request);
		
	}

	private void brand(HttpServletRequest request) {
		List<Brand> brandList = brandService.getByProperties(Brand.class, new String[]{"status"}, new Object[]{UseStatus.InUse}, "orderNum desc", 10000);
		/*List<List<Brand[]>> brandList = new ArrayList<List<Brand[]>>();
		
		log.info(qualityArchiveList.size());
		List<Brand[]> bList = new ArrayList<Brand[]>();
		Brand[] bPair = new Brand[2];
		
		int count = 0;
		int pairIndex = 0;
		for(Brand brand : qualityArchiveList){
			count++;
			bPair[pairIndex++] = brand;
			if(pairIndex>1 || pairIndex>=qualityArchiveList.size()-1){
				bList.add(bPair);
				bPair = new Brand[2];
				pairIndex = 0;
			}
			if(count==48 || count==qualityArchiveList.size()){
				brandList.add(bList);
				bList = new ArrayList<Brand[]>();
				count=0;
			}
		}
		if(bPair[0]!=null && bPair[1]!=null){
			bList.add(bPair);
		}
		if(bList.size()>0){
			brandList.add(bList);
		}
		log.info(brandList.size());*/
		request.setAttribute("brandList", brandList);
	}

	private void qaTop(HttpServletRequest request) {
		List<QualityArchive> qualityArchiveList = qualityArchiveService.getByProperties(QualityArchive.class, new String[]{"status"}, new Object[]{UseStatus.InUse}, "orderNum desc", 10);
		request.setAttribute("qualityArchiveList", qualityArchiveList);
	}

	private void friendLinkTop(HttpServletRequest request) {
		List<FriendLink> flinkList = flinkService.getByProperties(FriendLink.class, new String[]{"status"}, new Object[]{UseStatus.InUse}, "orderNum", null);
		request.setAttribute("flinkList", flinkList);
	}

	private void adTop(HttpServletRequest request) {
		List<Advertisement> adList = adService.getByProperties(Advertisement.class, new String[]{"status"}, new Object[]{UseStatus.InUse}, "orderNum", 10);
		request.setAttribute("adList", adList);
	}

	private void hangyeTop(HttpServletRequest request) {
		List<Chapter> hangyezixunList = chapterService.getTop(9, PAGE_ID_HANGYEZIXUN);
		if(hangyezixunList.size()>0){
			request.setAttribute("hangyezixunTop", hangyezixunList.get(0));
		}
		List<Chapter> hangyezixunList1 = new ArrayList<Chapter>();
		List<Chapter> hangyezixunList2 = new ArrayList<Chapter>();
		List<Chapter> hangyezixunList3 = new ArrayList<Chapter>();
		for(int i = 1;i<hangyezixunList.size();i++){
			if(hangyezixunList1.size()<3 && i%2==1){
				hangyezixunList1.add(hangyezixunList.get(i));
			}
			if(hangyezixunList2.size()<3 && i%2==0){
				hangyezixunList2.add(hangyezixunList.get(i));
			}
			hangyezixunList3.add(hangyezixunList.get(i));
		}
		request.setAttribute("hangyezixunList1", hangyezixunList1);
		request.setAttribute("hangyezixunList2", hangyezixunList2);
		request.setAttribute("hangyezixunList", hangyezixunList3);
	}

	private void huiyuanTop(HttpServletRequest request) {
		List<Chapter> huiyuanfengcaiList = chapterService.getTop(8, PAGE_ID_HUIYUANFENGCAI);
		request.setAttribute("huiyuanfengcaiList", huiyuanfengcaiList);
		if(huiyuanfengcaiList.size()>0){
			request.setAttribute("qiyefengcaiTop", huiyuanfengcaiList.get(0));
		}
		
		List<Chapter> huiyuanfengcaiList1 = new ArrayList<Chapter>();
		List<Chapter> huiyuanfengcaiList2 = new ArrayList<Chapter>();
		for(int i = 1;i<huiyuanfengcaiList.size();i++){
			if(i<3){
				huiyuanfengcaiList1.add(huiyuanfengcaiList.get(i));
			}else if(i<5){
				huiyuanfengcaiList2.add(huiyuanfengcaiList.get(i));
			}
		}
		request.setAttribute("huiyuanfengcaiList1", huiyuanfengcaiList1);
		request.setAttribute("huiyuanfengcaiList2", huiyuanfengcaiList2);
	}

	private void zhiliangTop(HttpServletRequest request) {
		List<Chapter> zhiliangredianList = chapterService.getTop(8, PAGE_ID_ZHILIANGREDIAN);
		request.setAttribute("zhiliangredianList", zhiliangredianList);
	}
	private void qualityExposureTop(HttpServletRequest request) {
		List<Chapter> list = chapterService.getTop(8, PAGE_ID_ZHILIANGBAOGUANG);
		request.setAttribute("qualityExposureList", list);
	}

	private void zhengceTop(HttpServletRequest request) {
		List<Chapter> zhengcedongtaiList = chapterService.getTop(5, PAGE_ID_ZHENGCE);
		request.setAttribute("zhengcedongtaiList", zhengcedongtaiList);
	}
	private void currentEventsTop(HttpServletRequest request) {
		List<Chapter> list = chapterService.getTop(8, PAGE_ID_SHISHIREDIAN);
		request.setAttribute("shishiredianList", list);
	}
	
	private void zhengcePage(HttpServletRequest request,Page<Chapter> pageInfo) {
		Page<Chapter> page = chapterService.getAll(PAGE_ID_ZHENGCE,pageInfo);
		request.setAttribute("page", page);
	}
	private void zhiliangbaoguangPage(HttpServletRequest request,Page<Chapter> pageInfo) {
		Page<Chapter> page = chapterService.getAll(PAGE_ID_ZHILIANGBAOGUANG,pageInfo);
		request.setAttribute("page", page);
	}
	private void huodonghuiguPage(HttpServletRequest request,Page<Chapter> pageInfo) {
		Page<Chapter> page = chapterService.getAll(PAGE_ID_HUODONGHUIGU,pageInfo);
		request.setAttribute("page", page);
	}
	private void zhiliangPage(HttpServletRequest request,Page<Chapter> pageInfo) {
		Page<Chapter> page = chapterService.getAll(PAGE_ID_ZHILIANGREDIAN,pageInfo);
		request.setAttribute("page", page);
	}
	private void shishiPage(HttpServletRequest request,Page<Chapter> pageInfo) {
		Page<Chapter> page = chapterService.getAll(PAGE_ID_SHISHIREDIAN,pageInfo);
		request.setAttribute("page", page);
	}
	private void hangyePage(HttpServletRequest request,Page<Chapter> pageInfo) {
		Page<Chapter> page = chapterService.getAll(PAGE_ID_HANGYEZIXUN,pageInfo);
		request.setAttribute("page", page);
	}
	private void huiyuanPage(HttpServletRequest request,Page<Chapter> pageInfo) {
		Page<Chapter> page = chapterService.getAll(PAGE_ID_HUIYUANFENGCAI,pageInfo);
		request.setAttribute("page", page);
	}
	private void zhiliangqiangqiTop(HttpServletRequest request) {
		List<Chapter> list = chapterService.getTop(8,PAGE_ID_ZHILIANGQIANGQI);
		request.setAttribute("zhiliangqiangqiList", list);
	}
	private void zhiliangdanganPage(HttpServletRequest request,Page<QualityArchive> pageInfo) {
		String categoryKey = request.getParameter("categoryKey");
		QualityArchiveCategory category = null;
		if(StringUtil.isNotEmpty(categoryKey)){
			category =  qualityArchiveCategoryService.getEntityByProperty(QualityArchiveCategory.class, "manageKey",categoryKey);
		}
		//if(category==null || category.getStatus()==UseStatus.UnUse){
			///List<QualityArchiveCategory> list = qualityArchiveCategoryService.getByProperties(QualityArchiveCategory.class, new String[]{"status"}, new Object[]{UseStatus.InUse}, "orderNum", 1);
			//if(list.size()>0){
			//	category = list.get(0);
			//}
		//}
		request.setAttribute("category", category);
		Page<QualityArchive> page = qualityArchiveService.getAll(category,pageInfo);
		request.setAttribute("page", page);
	}

	private void prepareCarousel(HttpServletRequest request) {
		List<Carousel> carouselList = carouselService.getByProperties(Carousel.class, new String[]{"status"}, new Object[]{UseStatus.InUse}, "orderNum", 10);
		request.setAttribute("carouselList", carouselList);
	}
	
	@RequestMapping("zhengcedongtai")
	public void zhengcedongtai(HttpServletRequest request,Page<Chapter> pageInfo){
		prepareCarousel(request);
		zhiliangTop(request);
		hangyeTop(request);
		pageInfo.setNumPerPage(15);
		zhengcePage(request, pageInfo);
	}
	@RequestMapping("zhiliangbaoguang")
	public void zhiliangbaoguang(HttpServletRequest request,Page<Chapter> pageInfo){
		prepareCarousel(request);
		zhiliangTop(request);
		hangyeTop(request);
		pageInfo.setNumPerPage(15);
		zhiliangbaoguangPage(request, pageInfo);
	}
	@RequestMapping("huodonghuigu")
	public void huodonghuigu(HttpServletRequest request,Page<Chapter> pageInfo){
		prepareCarousel(request);
		zhiliangTop(request);
		hangyeTop(request);
		pageInfo.setNumPerPage(15);
		huodonghuiguPage(request, pageInfo);
	}
	
	@RequestMapping("zhiliangredian")
	public void zhiliangredian(HttpServletRequest request,Page<Chapter> pageInfo){
		prepareCarousel(request);
		zhengceTop(request);
		hangyeTop(request);
		pageInfo.setNumPerPage(15);
		zhiliangPage(request, pageInfo);
	}
	@RequestMapping("shishiredian")
	public void shishiredian(HttpServletRequest request,Page<Chapter> pageInfo){
		prepareCarousel(request);
		zhengceTop(request);
		hangyeTop(request);
		pageInfo.setNumPerPage(15);
		shishiPage(request, pageInfo);
	}
	
	@RequestMapping("huiyuanfengcai")
	public void huiyuanfengcai(HttpServletRequest request,Page<Chapter> pageInfo){
		prepareCarousel(request);
		pageInfo.setNumPerPage(4);
		huiyuanPage(request, pageInfo);
	}
	
	@RequestMapping("zhiliangdangan")
	public String zhiliangdangan(HttpServletRequest request,Page<QualityArchive> pageInfo){
		prepareCarousel(request);
		pageInfo.setNumPerPage(24000);
		zhiliangdanganPage(request,pageInfo);
		zhiliangqiangqiTop(request);
		request.setAttribute("projectInfo", projectInfoService.getById(ProjectInfo.class, 1));
		return "zhiliangdangan";
	}
	
	@RequestMapping("zhiliangdanganList")
	public String zhiliangdanganList(HttpServletRequest request,Page<QualityArchive> pageInfo){
		prepareCarousel(request);
		zhiliangdanganPage(request,pageInfo);
		List<QualityArchiveCategory> categoryList = qualityArchiveCategoryService.getByProperties(QualityArchiveCategory.class, new String[]{"status"}, new Object[]{UseStatus.InUse}, "orderNum", null);
		request.setAttribute("categoryList",categoryList);
		return "zhiliangdanganList";
	}

	@RequestMapping("hangyezixun")
	public void hangyezixun(HttpServletRequest request,Page<Chapter> pageInfo){
		prepareCarousel(request);
		pageInfo.setNumPerPage(15);
		hangyePage(request, pageInfo);
	}
	@RequestMapping("danganDetail")
	public String danganDetail(HttpServletRequest request,@RequestParam("manageKey")String qaKey){
		QualityArchive qa = qualityArchiveService.getEntityByProperty(QualityArchive.class, "manageKey", qaKey);
		if(qa!=null && qa.getStatus()==UseStatus.InUse){
			request.setAttribute("qa", qa);
		}
		return "dangan";
	}
	
	@RequestMapping("dangan")
	public String danganDetail(HttpServletRequest request,@RequestParam("id")Integer id){
		QualityArchive qa = qualityArchiveService.getById(QualityArchive.class, id);
		if(qa!=null && qa.getStatus()==UseStatus.InUse){
			request.setAttribute("qa", qa);
		}
		
		accessRecord(request,id);
		
		return "dangan";
	}
	
	@RequestMapping("dangan/{uid}")
	public String danganDetail2(HttpServletRequest request,@PathVariable("uid")String uid){
		QualityArchive qa = qualityArchiveService.getEntityByProperty(QualityArchive.class, "uid", uid);
		if(qa==null){
			qa = qualityArchiveService.getEntityByProperty(QualityArchive.class, "title", uid);
		}
		if(qa!=null && qa.getStatus()==UseStatus.InUse){
			request.setAttribute("qa", qa);
			accessRecord(request,qa.getId());
		}
		return "dangan";
	}
	
	private void accessRecord(HttpServletRequest request, Integer id) {
		String userAgent = request.getHeader("user-agent");
		String referer =  request.getHeader("referer");
		
		userAgent= userAgent==null ? "" : userAgent;
		/*Enumeration<String> headers = request.getHeaderNames();
		while(headers.hasMoreElements()){
			String header = headers.nextElement();
			log.info(header + ":" + request.getHeader(header));
		}*/
		boolean isWechat = userAgent.toLowerCase().contains("micromessenger");
		AccessRecord record = new AccessRecord();
		record.setAccessTime(new Date());
		record.setIp(request.getRemoteHost());
		record.setManageKey(Md5Util.getManageKey());
		record.setOrigin(referer);
		
		StringBuffer requestURL = request.getRequestURL();
	    String queryString = request.getQueryString();

	    if (queryString != null) {
	        requestURL.append('?').append(queryString).toString();
	    }
	    
		record.setUrl(requestURL.toString());
		
		String key = null;
		if(isWechat){
			key = "zlda_wechat";
		}else{
			if("button".equals(request.getParameter("from"))){
				key = "zlda_code_button";
			}else{
				key = "zlda_web";
			}
		}
		key += "_" + id;
		record.setKey(key);
		accessRecordService.add(record);
	}



	@RequestMapping("about")
	public void about(HttpServletRequest request){
		prepareCarousel(request);
	}
	
	@RequestMapping("search")
	public void search(HttpServletRequest request,@RequestParam(value = "key")String key,Page<Chapter> pageInfo){
		if(StringUtil.isEmpty(key)){
			return;
		}
		request.setAttribute("key", key);
		Page<SearchResult> searchResultPage = chapterService.search(key, pageInfo);
		request.setAttribute("page", searchResultPage);
	}
	

	@RequestMapping("chapterDetail")
	public String chapterDetail(HttpServletRequest request,@RequestParam(value = "manageKey",required = false)String key){
		if(StringUtil.isEmpty(key)){
			key = request.getParameter("k");
		}
		prepareCarousel(request);
		
		Chapter chapter = chapterService.getEntityByProperty(Chapter.class, "manageKey", key);
		if(chapter!=null){
			chapter.setReadCount(chapter.getReadCount()==null ? 1 : (chapter.getReadCount()+1));
			chapterService.update(chapter); 
		}
		request.setAttribute("p", chapter);
		
		zhiliangTop(request);
		
		request.setAttribute("top10ChapterList",chapterService.getTop10OfAll());
		if(chapter.getPage().getKey().equals("zhiliangqiangqi")){
			return "../jsp/chapterDetail-qiangqi";
		}else{
			return "chapterDetail";
		}
	}
	
	
	@RequestMapping(value = "apply",method = RequestMethod.GET,params = "notice")
	public String applyNotice(){
		return "applyNotice";
	}
	
	@RequestMapping(value = "apply",method = RequestMethod.GET)
	public void applyUI(){
		
	}
	@RequestMapping(value = "apply",method = RequestMethod.POST)
	@ResponseBody
	public JsonResult apply(HttpServletRequest request,@ModelAttribute("apply") Apply apply,
			@RequestParam(value = "verifyCode")String checkcode){
		String checkCodeInSession = (String)request.getSession().getAttribute(VerifyImageServlet.SIMPLE_CAPCHA_SESSION_KEY);
		checkCodeInSession = checkCodeInSession==null ? null : checkCodeInSession.toLowerCase();
		if(!(checkcode!=null && checkcode.toLowerCase().equals(checkCodeInSession))){
			return JsonResult.error("验证码错误!");
		}
		request.getSession().removeAttribute(VerifyImageServlet.SIMPLE_CAPCHA_SESSION_KEY);
		apply.setManageKey(Md5Util.getManageKey());
		apply.setCreateTime(new Date());
		applyService.add(apply);
		return JsonResult.success("申请成功!");
	}
	
	@RequestMapping(value = "liuyan",method = RequestMethod.GET)
	public void liuyanUI(){
		
	}
	
	@RequestMapping(value = "liuyan",method = RequestMethod.POST)
	@ResponseBody
	public JsonResult liuyan(HttpServletRequest request,@ModelAttribute("comment") Comment comment,
			@RequestParam(value = "verifyCode")String checkcode){
		String checkCodeInSession = (String)request.getSession().getAttribute(VerifyImageServlet.SIMPLE_CAPCHA_SESSION_KEY);
		checkCodeInSession = checkCodeInSession==null ? null : checkCodeInSession.toLowerCase();
		if(!(checkcode!=null && checkcode.toLowerCase().equals(checkCodeInSession))){
			return JsonResult.error("验证码错误!");
		}
		request.getSession().removeAttribute(VerifyImageServlet.SIMPLE_CAPCHA_SESSION_KEY);
		comment.setManageKey(Md5Util.getManageKey());
		comment.setCreateTime(new Date());
		commentService.add(comment);
		return JsonResult.success("留言成功!");
	}
	
	@RequestMapping(value = "query",method = RequestMethod.GET)
	public String queryUI(){
		return "frontend/query";
	}
	
	@RequestMapping(value = "query",method = RequestMethod.POST,params = "queryType=memberOrg")
	public String queryMemberOrg(HttpServletRequest request, @RequestParam("key")String key){
		MemberOrganization memberOrganization = new MemberOrganization();
		Page<MemberOrganization> pageInfo = new Page<MemberOrganization>();
		memberOrganization.setName(key);
		pageInfo = memberOrgService.getListPage(memberOrganization, pageInfo);
		if(pageInfo.getList().size()>0){
			request.setAttribute("tempBean", pageInfo.getList().get(0));
		}
		return "frontend/queryMemberOrg";
	}
	@RequestMapping(value = "zwQuery",method = RequestMethod.POST)
	public String zwQuery(HttpServletRequest request, @RequestParam("key")String key){
		request.setAttribute("tempBean",zwCodeService.getEntityByProperty(ZwCode.class, "companyName", key));
		return "frontend/zwCode";
	}
	
	@RequestMapping(value = "query",method = RequestMethod.POST,params = "queryType=qualityArchive")
	public String queryQualityArchive(HttpServletRequest request,@RequestParam("key")String key){
		if(key!=null){
			key = key.trim();
		}
		Worker worker = new Worker();
		Page<Worker> pageInfo = new Page<Worker>();
		worker.setName(key);
		pageInfo = workerService.getListPage(worker, pageInfo);
		if(pageInfo.getList().size()>0){
			request.setAttribute("tempBean", pageInfo.getList().get(0));
			return "frontend/queryWorker";
		}else{
			Company company = new Company();
			Page<Company> pageInfo2 = new Page<Company>();
			company.setQueryKey(key);
			pageInfo2 = comanyService.getListPage(company, pageInfo2);
			if(pageInfo2.getList().size()>0){
				request.setAttribute("tempBean", pageInfo2.getList().get(0));
			}
			
			return "frontend/queryQualityArchiveCompany";
		}
	}
	
	@RequestMapping(value = "query",method = RequestMethod.POST,params = "queryType=authOrg")
	public String queryAuthOrg(HttpServletRequest request,@RequestParam("key")String key){
		AuthOrg authOrg = new AuthOrg();
		Page<AuthOrg> pageInfo = new Page<AuthOrg>();
		authOrg.setName(key);
		pageInfo = authOrgService.getListPage(authOrg, pageInfo);
		if(pageInfo.getList().size()>0){
			request.setAttribute("tempBean", pageInfo.getList().get(0));
		}
		return "frontend/queryAuthOrg";
	}
	
	@RequestMapping(value = "query",method = RequestMethod.POST,params = "queryType=worker")
	public String queryWorker(HttpServletRequest request,@RequestParam("key")String key){
		Worker worker = new Worker();
		Page<Worker> pageInfo = new Page<Worker>();
		worker.setName(key);
		pageInfo = workerService.getListPage(worker, pageInfo);
		if(pageInfo.getList().size()>0){
			request.setAttribute("tempBean", pageInfo.getList().get(0));
		}
		
		return "frontend/queryWorker";
	}
	
	
	
	@RequestMapping(value = "pictureXML/{key}",produces = "application/xml")
	public ResponseEntity<String> pictureXML(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "key")String key){
		
		QualityArchive qa = qualityArchiveService.getEntityByProperty(QualityArchive.class, "manageKey", key);
		
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.add("Content-Type", "application/xml; charset=utf-8");
	    
	    StringBuffer content = new StringBuffer();
	    
	    content.append("<?xml version='1.0' encoding='utf-8'?>");
	    content.append("<contentsRotator>");
	    
	    String path = request.getContextPath();
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
	    
		if(qa.getProductDisplay()!=null){
		    int i = 0;
		    for(CommonFile file : qa.getProductDisplay()){
		    	int index = (++i);
		    	String c = "";
		    	if(index<=5){
		    		c = "E";
		    	}else if(index<=8){
		    		c = "S";
		    	}else{
		    		c = "B";
		    	}
		    	content.append(" <item order='"+index+"' category='"+ c +"' type='image' title='请勿用于商业用途' image='"+ basePath +"filee/viewPic.do?manageKey="+file.getManageKey()+"' source='http://www.baidu.com' target='_self' />");
		    }
		}
	    
		int total = qa.getProductDisplay()==null ? 0 : qa.getProductDisplay().size();
	    
		for(;total<7;total++){
	    	content.append("<item order='"+  (total + 1) + "' category='S' type='video' title='666666666' image='http://localhost:1987/cms/js/flash-3d-gallery/zsimg/01.gif' source='http://www.baidu.com' />");
		}
	    
	    content.append("</contentsRotator>");
	    
	    
	    ResponseEntity<String> res =  new ResponseEntity<String>(content.toString(), responseHeaders, HttpStatus.OK);
	    
	    return res;
	}
	
	
	
	@RequestMapping(value = "search",method = RequestMethod.GET,params = "target=qa")
	@ResponseBody
	public List<QualityArchive> searchQualityArchive(HttpServletRequest request,@RequestParam("term")String key){
		Page<QualityArchive> pageInfo = new Page<QualityArchive>();
		pageInfo.setNumPerPage(20);
		QualityArchive qualityArchive = new QualityArchive();
		qualityArchive.setTitle(key);
		return qualityArchiveService.getListPage(qualityArchive, pageInfo).getList();
	}
	
	
	@RequestMapping(value = "api/code/download",method = RequestMethod.GET)
	public void code(HttpServletRequest request, @RequestParam("key")String key){
		ZwCode zwCode = zwCodeService.getEntityByProperty(ZwCode.class, "manageKey", key);
		request.setAttribute("tempBean", zwCode);
	}
	
	@RequestMapping(value = "api/code/js",method = RequestMethod.GET)
	public String js(
			HttpServletRequest request,
			@RequestParam("key")String key,
			@RequestParam("display")String display,
			@RequestParam("width")Integer width,
			@RequestParam("height")String height,
			@RequestParam("top")String top,
			@RequestParam("bg")String bg,
			@RequestParam("enable")String enable
			){
		ZwCode zwCode = zwCodeService.getEntityByProperty(ZwCode.class, "manageKey", key);
		request.setAttribute("tempBean", zwCode);
		request.setAttribute("key", key);
		String targetUrl = zwCode.getUrl();
		if(StringUtil.isNotEmpty(targetUrl)){
			if(targetUrl.contains("?")){
				targetUrl += "&from=button";
			}else{
				targetUrl += "?from=button";
			}
			request.setAttribute("targetUrl", targetUrl);
		}
		request.setAttribute("cssUrl", getBasePath(request) + "api/code/css.do?key=" + key 
				+ "&display=" + display
				+ "&width=" + width
				+ "&height=" + height
				+ "&top=" + top
				+ "&bg=" + bg
				+ "&enable=" + enable
				);
		return "/api/code/js";
	}
	@RequestMapping(value = "api/code/css",method = RequestMethod.GET)
	public String css(
			HttpServletRequest request,
			@RequestParam("key")String key,
			@RequestParam("display")String display,
			@RequestParam("width")Integer width,
			@RequestParam("height")String height,
			@RequestParam("top")String top,
			@RequestParam("bg")String bg,
			@RequestParam("enable")String enable
			){
		request.setAttribute("display",display );
		request.setAttribute("width",width );
		request.setAttribute("height",height );
		request.setAttribute("top",top );
		request.setAttribute("bg",bg );
		request.setAttribute("enable",enable );
		
		return "/api/code/css";
	}
	
	private String getBasePath(HttpServletRequest request){
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
		return basePath;
	}
	
}