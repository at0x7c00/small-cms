package me.huqiao.smallcms.cms.dao;
import java.util.List;

import me.huqiao.smallcms.cms.entity.Comment;
import me.huqiao.smallcms.common.dao.IBaseDao;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;

import org.hibernate.Criteria;
/**
 * 留言DAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface ICommentDao extends IBaseDao<Comment> {
    /**
     * 留言查询记录数量
     * @param comment 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(Comment comment);
	/**
	 * 留言历史记录数量
     * @param comment 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(Comment comment,Page pageInfo);
    /**
     * 留言分页查询
     * @param comment 查询对象
     * @param pageInfo 分页查询对象
     * @return  List<Comment>  留言列表 
     */
    List<Comment> findListPage(Comment comment, Page pageInfo);
	/**
	 * 留言历史记录分页查询
     * @param comment 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<Comment>>  留言历史列表
	 */
    List<HistoryRecord<Comment>> findHistoryListPage(Comment comment, Page pageInfo);
	/**
     * 留言版本号查询
     * @param version 版本号
	 * @return Comment 留言历史记录
     */
	Comment findByVersion(Integer version);
	/**
	 * 添加留言查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param comment 查询对象
	 */
	public void queryCause(Criteria criteria, Comment comment);
	/**
	 * 留言关键字查询
	 * @param  queryKey 查询关键字
	 * @return List<Comment> 留言列表
	 */
	List<Comment> findByKey(Page pageInfo,String queryKey);
	/**
	 * 留言关键字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个留言
     * @param  ids id数组
	 * @return List<Comment>  留言列表
     */
	List<Comment> findById(Integer[] ids);
}