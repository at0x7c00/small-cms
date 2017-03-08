package me.huqiao.smallcms.cms.controller;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import me.huqiao.smallcms.cms.entity.Advertisement;
import me.huqiao.smallcms.cms.entity.Carousel;
import me.huqiao.smallcms.cms.entity.Chapter;
import me.huqiao.smallcms.cms.entity.FriendLink;
import me.huqiao.smallcms.cms.service.IAdvertisementService;
import me.huqiao.smallcms.cms.service.ICarouselService;
import me.huqiao.smallcms.cms.service.IChapterService;
import me.huqiao.smallcms.cms.service.IFriendLinkService;
import me.huqiao.smallcms.common.controller.BaseController;
import me.huqiao.smallcms.common.entity.enumtype.UseStatus;
import me.huqiao.smallcms.ppll.entity.QualityArchive;
import me.huqiao.smallcms.ppll.entity.QualityArchiveCategory;
import me.huqiao.smallcms.ppll.service.IQualityArchiveCategoryService;
import me.huqiao.smallcms.ppll.service.IQualityArchiveService;
import me.huqiao.smallcms.util.StringUtil;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.stereotype.Controller;
/**
 * 轮播控制器
 * @author NOVOTS
 * @version Version 1.0
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping(value = "frontend")
public class FrontendController  extends BaseController {
	
	private Integer PAGE_ID_ZHENGCE = 1;
	private Integer PAGE_ID_ZHILIANGREDIAN = 2;
	private Integer PAGE_ID_HUIYUANFENGCAI = 3;
	private Integer PAGE_ID_HANGYEZIXUN = 4;
	
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
	
	
	
	@RequestMapping("index")
	public void index(HttpServletRequest request){
		
		prepareCarousel(request);
		
		zhengceTop(request);
		zhiliangTop(request);
		
		
		huiyuanTop(request);
		hangyeTop(request);
		
		//ad
		adTop(request);
		
		//friend link 
		friendLinkTop(request);
		
		qaTop(request);
		
	}

	private void qaTop(HttpServletRequest request) {
		List<QualityArchive> qualityArchiveList = qualityArchiveService.getByProperties(QualityArchive.class, new String[]{"status"}, new Object[]{UseStatus.InUse}, "orderNum", 10);
		request.setAttribute("qualityArchiveList", qualityArchiveList);
	}

	private void friendLinkTop(HttpServletRequest request) {
		List<FriendLink> flinkList = flinkService.getByProperties(FriendLink.class, new String[]{"status"}, new Object[]{UseStatus.InUse}, "orderNum", 10);
		request.setAttribute("flinkList", flinkList);
	}

	private void adTop(HttpServletRequest request) {
		List<Advertisement> adList = adService.getByProperties(Advertisement.class, new String[]{"status"}, new Object[]{UseStatus.InUse}, "orderNum", 10);
		request.setAttribute("adList", adList);
	}

	private void hangyeTop(HttpServletRequest request) {
		List<Chapter> hangyezixunList = chapterService.getTop(6, PAGE_ID_HANGYEZIXUN);
		request.setAttribute("hangyezixunList", hangyezixunList);
	}

	private void huiyuanTop(HttpServletRequest request) {
		List<Chapter> huiyuanfengcaiList = chapterService.getTop(7, PAGE_ID_HUIYUANFENGCAI);
		request.setAttribute("huiyuanfengcaiList", huiyuanfengcaiList);
	}

	private void zhiliangTop(HttpServletRequest request) {
		List<Chapter> zhiliangredianList = chapterService.getTop(7, PAGE_ID_ZHILIANGREDIAN);
		request.setAttribute("zhiliangredianList", zhiliangredianList);
	}

	private void zhengceTop(HttpServletRequest request) {
		List<Chapter> zhengcedongtaiList = chapterService.getTop(7, PAGE_ID_ZHENGCE);
		request.setAttribute("zhengcedongtaiList", zhengcedongtaiList);
	}
	
	private void zhengcePage(HttpServletRequest request,Page<Chapter> pageInfo) {
		Page<Chapter> page = chapterService.getAll(PAGE_ID_ZHENGCE,pageInfo);
		request.setAttribute("page", page);
	}
	private void zhiliangPage(HttpServletRequest request,Page<Chapter> pageInfo) {
		Page<Chapter> page = chapterService.getAll(PAGE_ID_ZHILIANGREDIAN,pageInfo);
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
	private void zhiliangdanganPage(HttpServletRequest request,Page<QualityArchive> pageInfo) {
		String categoryKey = request.getParameter("categoryKey");
		QualityArchiveCategory category = null;
		if(StringUtil.isNotEmpty(categoryKey)){
			category =  qualityArchiveCategoryService.getEntityByProperty(QualityArchiveCategory.class, "manageKey",categoryKey);
		}
		if(category==null || category.getStatus()==UseStatus.UnUse){
			List<QualityArchiveCategory> list = qualityArchiveCategoryService.getByProperties(QualityArchiveCategory.class, new String[]{"status"}, new Object[]{UseStatus.InUse}, "orderNum", 1);
			if(list.size()>0){
				category = list.get(0);
			}
		}
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
	
	@RequestMapping("zhiliangredian")
	public void zhiliangredian(HttpServletRequest request,Page<Chapter> pageInfo){
		prepareCarousel(request);
		zhengceTop(request);
		hangyeTop(request);
		pageInfo.setNumPerPage(15);
		zhiliangPage(request, pageInfo);
	}
	
	@RequestMapping("huiyuanfengcai")
	public void huiyuanfengcai(HttpServletRequest request,Page<Chapter> pageInfo){
		prepareCarousel(request);
		pageInfo.setNumPerPage(5);
		huiyuanPage(request, pageInfo);
	}
	
	@RequestMapping("zhiliangdangan")
	public void zhiliangdangan(HttpServletRequest request,Page<QualityArchive> pageInfo){
		prepareCarousel(request);
		zhiliangdanganPage(request,pageInfo);
		List<QualityArchiveCategory> categoryList = qualityArchiveCategoryService.getByProperties(QualityArchiveCategory.class, new String[]{"status"}, new Object[]{UseStatus.InUse}, "orderNum", null);
		request.setAttribute("categoryList",categoryList);
	}

	@RequestMapping("hangyezixun")
	public void hangyezixun(HttpServletRequest request,Page<Chapter> pageInfo){
		prepareCarousel(request);
		pageInfo.setNumPerPage(15);
		hangyePage(request, pageInfo);
	}
	@RequestMapping("danganDetail")
	public void danganDetail(HttpServletRequest request,@RequestParam("manageKey")String qaKey){
		QualityArchive qa = qualityArchiveService.getEntityByProperty(QualityArchive.class, "manageKey", qaKey);
		if(qa!=null && qa.getStatus()==UseStatus.InUse){
			request.setAttribute("qa", qa);
		}
	}
	
	@RequestMapping("about")
	public void about(HttpServletRequest request){
		prepareCarousel(request);
	}
	
	@RequestMapping("chapterDetail")
	public void chapterDetail(HttpServletRequest request,@RequestParam(value = "manageKey",required = false)String key){
		if(StringUtil.isEmpty(key)){
			key = request.getParameter("k");
		}
		prepareCarousel(request);
		request.setAttribute("p", chapterService.getEntityByProperty(Chapter.class, "manageKey", key));
		
		zhiliangTop(request);
	}
	
	
	
}