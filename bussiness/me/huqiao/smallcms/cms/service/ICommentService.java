package me.huqiao.smallcms.cms.service;
import java.util.List;

import me.huqiao.smallcms.cms.entity.Comment;
import me.huqiao.smallcms.common.service.IBaseService;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;
/**
 * 留言Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface ICommentService extends IBaseService<Comment> {
    /**
     * 留言分页查询
     * @param comment 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<Comment> 留言分页信息对象
     */
    public Page<Comment> getListPage(Comment comment,Page pageInfo);
	/**
	  * 留言历史记录分页查询
	  * @param comment 查询对象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<Comment>> 留言历史分页信息对象
	  */
	public Page<HistoryRecord<Comment>> getHistoryListPage(Comment comment,Page pageInfo);
	/**
	 * 留言版本号查询
	 * @param version 查询版本号
	 * @return Comment 留言历史记录
	 */
	public Comment findByVersion(Integer version);
	/**
	 * 留言关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<Comment> 留言分页信息对象
	 * 
	 */
	Page<Comment> queryByKey(String queryKey, Page<Comment> pageInfo);
	/**
	 * 查找多个留言
	 * @param ids id数组
	 * @return List<Comment> 留言列表
	 * 
	 */
	List<Comment> queryById(Integer[] ids);
}