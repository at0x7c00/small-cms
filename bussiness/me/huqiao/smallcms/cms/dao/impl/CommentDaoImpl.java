package me.huqiao.smallcms.cms.dao.impl;
import java.util.ArrayList;
import java.util.List;

import me.huqiao.smallcms.cms.dao.ICommentDao;
import me.huqiao.smallcms.cms.entity.Comment;
import me.huqiao.smallcms.common.dao.impl.BaseDaoImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.history.entity.TestRevisionEntity;
import me.huqiao.smallcms.util.web.Page;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.hibernate.envers.query.AuditQueryCreator;
import org.springframework.stereotype.Repository;
/**
 * 留言DAO实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Repository
public class CommentDaoImpl extends BaseDaoImpl<Comment> implements ICommentDao {
    @Override
    public Long findListRowCount(Comment comment) {
        Criteria criteria = getSession().createCriteria(Comment.class).setProjection(Projections.rowCount());
        queryCause(criteria,comment);
        return (Long) criteria.uniqueResult();
    }
	@Override
	public Long findHistoryListRowCount(Comment comment,Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(Comment.class, false, true);
		query.add(AuditEntity.property("manageKey").eq(comment.getManageKey()));
		queryCause(query,pageInfo);
		query.addProjection(AuditEntity.property("manageKey").count());
		return (Long) query.getSingleResult();
	}
    @SuppressWarnings("unchecked")
    @Override
    public List<Comment> findListPage(Comment comment, Page pageInfo){
    	Criteria criteria = getSession().createCriteria(Comment.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
        queryCause(criteria,comment);
        if(pageInfo.getOrderField()!=null && !pageInfo.getOrderField().trim().equals("")){
         	if(pageInfo.getOrderDirection()==null || pageInfo.getOrderDirection().trim().equals("asc")){
         		criteria.addOrder(Order.asc(pageInfo.getOrderField()));
         	}else{
         		criteria.addOrder(Order.desc(pageInfo.getOrderField()));
         	}
         }else{
         	criteria.addOrder(Order.asc("id")); 
         }
        return criteria.list();
    }
	@SuppressWarnings("unchecked")
	@Override
	public List<HistoryRecord<Comment>> findHistoryListPage(Comment comment, Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(Comment.class, false, true);
		query.setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
		query.add(AuditEntity.property("manageKey").eq(comment.getManageKey()));
		queryCause(query,pageInfo);
		if (pageInfo.getOrderField() != null && !pageInfo.getOrderField().trim().equals("")) {
			if (pageInfo.getOrderDirection() == null || pageInfo.getOrderDirection().trim().equals("asc")) {
				query.addOrder(AuditEntity.property(pageInfo.getOrderField()).asc());
			} else {
				query.addOrder(AuditEntity.property(pageInfo.getOrderField()).desc());
			}
		} else {
			query.addOrder(AuditEntity.property("id").desc());
		}
		List list = query.getResultList();
		List<HistoryRecord<Comment>> res = new ArrayList<HistoryRecord<Comment>>();
		for(Object obj : list){
			Object[] array = (Object[])obj;
			HistoryRecord<Comment> record = new HistoryRecord<Comment>();
			record.setRecord((Comment)array[0]);
			record.setRevisionEntity((TestRevisionEntity)array[1]);
			record.setType((RevisionType)array[2]);
			res.add(record);
		}
		return res;
	}
	/**
	  * 添加历史记录查询条件
      * @param query 历史查询对象
      * @param pageInfo 历史记录分页查询对象
	  */
	public void queryCause(AuditQuery query,Page pageInfo) {
		if(pageInfo.getOperateDateStart()!=null){
			query.add(AuditEntity.revisionProperty("timestamp").ge(pageInfo.getOperateDateStart()));
		}
		if(pageInfo.getOperateDateEnd()!=null){
			query.add(AuditEntity.revisionProperty("timestamp").le(pageInfo.getOperateDateEnd()));
		}
		if(pageInfo.getOperator()!=null && !pageInfo.getOperator().trim().equals("")){
			query.add(AuditEntity.revisionProperty("username").like(pageInfo.getOperator(),MatchMode.ANYWHERE));
		}
		if(pageInfo.getOperateType()!=null && !pageInfo.getOperateType().trim().equals("")){
			query.add(AuditEntity.revisionType().eq(RevisionType.valueOf(pageInfo.getOperateType())));
		}
	}
	/**
	  * 根据查��对象往criteria对象增加查询条件
      * @param criteria Hibernate criteria对象
      * @param comment 查询对象
	  */
    public void queryCause(Criteria criteria,Comment comment){
       if(comment.getUser()!=null
 && ! comment.getUser().trim().equals("")){
		criteria.add(Restrictions.like("user",comment.getUser(),MatchMode.ANYWHERE));
}
       if(comment.getRemark()!=null
 && ! comment.getRemark().trim().equals("")){
		criteria.add(Restrictions.like("remark",comment.getRemark(),MatchMode.ANYWHERE));
}
       if(comment.getPhone()!=null
 && ! comment.getPhone().trim().equals("")){
		criteria.add(Restrictions.like("phone",comment.getPhone(),MatchMode.ANYWHERE));
}
       if(comment.getEmail()!=null
 && ! comment.getEmail().trim().equals("")){
		criteria.add(Restrictions.like("email",comment.getEmail(),MatchMode.ANYWHERE));
}
       if(comment.getContent()!=null
 && ! comment.getContent().trim().equals("")){
		criteria.add(Restrictions.like("content",comment.getContent(),MatchMode.ANYWHERE));
}
if(comment.getCreateTimeStart()!=null){
criteria.add(Restrictions.ge("createTime",comment.getCreateTimeStart()));
}
if(comment.getCreateTimeEnd()!=null){
criteria.add(Restrictions.le("createTime",comment.getCreateTimeEnd()));
}
       if(comment.getReplyStatus()!=null
){
		criteria.add(Restrictions.eq("replyStatus",comment.getReplyStatus()));
}
    }
	@Override
	public Comment findByVersion(Integer version) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forEntitiesAtRevision(Comment.class, version);
		query.add(AuditEntity.revisionNumber().eq(version));
		List list = query.getResultList();
		if(list!=null && list.size()>0){
			return (Comment)list.get(0);
		}
		return null;
	}
	@Override
	public List<Comment> findByKey(Page pageInfo,String queryKey) {
		Criteria criteria = getSession().createCriteria(Comment.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage()).add(Restrictions.like("manageKey", queryKey,MatchMode.ANYWHERE));
		return criteria.list();
	}
	@Override
	public Long findRowCount(String queryKey) {
		Criteria criteria = getSession().createCriteria(Comment.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.like("manageKey", queryKey,MatchMode.ANYWHERE));
		return (Long) criteria.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> findById(Integer[] ids) {
		Criteria criteria = getSession().createCriteria(Comment.class)
		.add(Restrictions.in("id", ids));
		return criteria.list();
	}
}