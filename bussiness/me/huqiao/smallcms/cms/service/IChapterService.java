package me.huqiao.smallcms.cms.service;
import java.util.List;

import me.huqiao.smallcms.cms.entity.Chapter;
import me.huqiao.smallcms.cms.entity.SearchResult;
import me.huqiao.smallcms.common.service.IBaseService;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;
/**
 * 文章Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IChapterService extends IBaseService<Chapter> {
    /**
     * 文章分页查询
     * @param chapter 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<Chapter> 文章分页信息对象
     */
    public Page<Chapter> getListPage(Chapter chapter,Page pageInfo);
	/**
	  * 文章历史记录分页查询
	  * @param chapter 查询对象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<Chapter>> 文章历史分页信息对象
	  */
	public Page<HistoryRecord<Chapter>> getHistoryListPage(Chapter chapter,Page pageInfo);
	/**
	 * 文章版本号查询
	 * @param version 查询版本号
	 * @return Chapter 文章历史记录
	 */
	public Chapter findByVersion(Integer version);
	/**
	 * 文章关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<Chapter> 文章分页信息对象
	 * 
	 */
	Page<Chapter> queryByKey(String queryKey, Page<Chapter> pageInfo);
	/**
	 * 查找多个文章
	 * @param ids id数组
	 * @return List<Chapter> 文章列表
	 * 
	 */
	List<Chapter> queryById(Integer[] ids);
	
	public List<Chapter> getTop(Integer top,Integer type);
	
	public Page<Chapter> getAll(Integer type,Page<Chapter> pageInfo);
	
	public List<Chapter> getTop10OfAll();
	
	public Page<SearchResult> search(String key,Page pageInfo);
	
}