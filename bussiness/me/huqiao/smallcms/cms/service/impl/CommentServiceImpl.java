package me.huqiao.smallcms.cms.service.impl;
import java.util.List;

import javax.annotation.Resource;

import me.huqiao.smallcms.cms.dao.ICommentDao;
import me.huqiao.smallcms.cms.entity.Comment;
import me.huqiao.smallcms.cms.service.ICommentService;
import me.huqiao.smallcms.common.service.impl.BaseServiceImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.stereotype.Service;
/**
 * 留言Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements ICommentService {
    /**留言DAO对象*/
    @Resource
    private ICommentDao commentDao;
    @Override
    public Page<Comment> getListPage(Comment comment,Page pageInfo) {
      	pageInfo.setTotalCount(commentDao.findListRowCount(comment).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "desc": pageInfo.getOrderDirection());
		pageInfo.setList(commentDao.findListPage(comment,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<Comment>> getHistoryListPage(Comment comment, Page pageInfo) {
		pageInfo.setTotalCount(commentDao.findHistoryListRowCount(comment,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(commentDao.findHistoryListPage(comment,pageInfo));
        return pageInfo;
	}
	@Override
	public Comment findByVersion(Integer version) {
		return commentDao.findByVersion(version);
	}
	@Override
	public Page<Comment> queryByKey(String queryKey, Page<Comment> pageInfo) {
		int countRecord = commentDao.findRowCount(queryKey).intValue();
		Page<Comment> page = new Page<Comment>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<Comment> commentList = commentDao.findByKey(pageInfo,queryKey);
		page.setList(commentList);
		return page;
	}
	@Override
	public List<Comment> queryById(Integer[] ids) {
		return commentDao.findById(ids);
	}
}