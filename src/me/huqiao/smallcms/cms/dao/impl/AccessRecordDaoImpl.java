package me.huqiao.smallcms.cms.dao.impl;
import java.util.ArrayList;
import java.util.List;

import me.huqiao.smallcms.cms.dao.IAccessRecordDao;
import me.huqiao.smallcms.cms.entity.AccessRecord;
import me.huqiao.smallcms.common.dao.impl.BaseDaoImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.history.entity.TestRevisionEntity;
import me.huqiao.smallcms.util.web.Page;

import org.hibernate.Criteria;
import org.hibernate.Query;
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
 * 访问记录DAO实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Repository
public class AccessRecordDaoImpl extends BaseDaoImpl<AccessRecord> implements IAccessRecordDao {
    @Override
    public Long findListRowCount(AccessRecord accessRecord) {
        Criteria criteria = getSession().createCriteria(AccessRecord.class).setProjection(Projections.rowCount());
        queryCause(criteria,accessRecord);
        return (Long) criteria.uniqueResult();
    }
	@Override
	public Long findHistoryListRowCount(AccessRecord accessRecord,Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(AccessRecord.class, false, true);
		query.add(AuditEntity.property("manageKey").eq(accessRecord.getManageKey()));
		queryCause(query,pageInfo);
		query.addProjection(AuditEntity.property("manageKey").count());
		return (Long) query.getSingleResult();
	}
    @SuppressWarnings("unchecked")
    @Override
    public List<AccessRecord> findListPage(AccessRecord accessRecord, Page pageInfo){
    	Criteria criteria = getSession().createCriteria(AccessRecord.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
        queryCause(criteria,accessRecord);
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
	public List<HistoryRecord<AccessRecord>> findHistoryListPage(AccessRecord accessRecord, Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(AccessRecord.class, false, true);
		query.setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
		query.add(AuditEntity.property("manageKey").eq(accessRecord.getManageKey()));
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
		List<HistoryRecord<AccessRecord>> res = new ArrayList<HistoryRecord<AccessRecord>>();
		for(Object obj : list){
			Object[] array = (Object[])obj;
			HistoryRecord<AccessRecord> record = new HistoryRecord<AccessRecord>();
			record.setRecord((AccessRecord)array[0]);
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
	  * 根据查询对象往criteria对象增加查询条件
      * @param criteria Hibernate criteria对象
      * @param accessRecord 查询对象
	  */
    public void queryCause(Criteria criteria,AccessRecord accessRecord){
       if(accessRecord.getKey()!=null
 && ! accessRecord.getKey().trim().equals("")){
		criteria.add(Restrictions.like("key",accessRecord.getKey(),MatchMode.ANYWHERE));
}
if(accessRecord.getAccessTimeStart()!=null){
criteria.add(Restrictions.ge("accessTime",accessRecord.getAccessTimeStart()));
}
if(accessRecord.getAccessTimeEnd()!=null){
criteria.add(Restrictions.le("accessTime",accessRecord.getAccessTimeEnd()));
}
       if(accessRecord.getUrl()!=null
 && ! accessRecord.getUrl().trim().equals("")){
		criteria.add(Restrictions.like("url",accessRecord.getUrl(),MatchMode.ANYWHERE));
}
       if(accessRecord.getOrigin()!=null
 && ! accessRecord.getOrigin().trim().equals("")){
		criteria.add(Restrictions.like("origin",accessRecord.getOrigin(),MatchMode.ANYWHERE));
}
       if(accessRecord.getIp()!=null
 && ! accessRecord.getIp().trim().equals("")){
		criteria.add(Restrictions.like("ip",accessRecord.getIp(),MatchMode.ANYWHERE));
}
    }
	@Override
	public AccessRecord findByVersion(Integer version) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forEntitiesAtRevision(AccessRecord.class, version);
		query.add(AuditEntity.revisionNumber().eq(version));
		List list = query.getResultList();
		if(list!=null && list.size()>0){
			return (AccessRecord)list.get(0);
		}
		return null;
	}
	@Override
	public List<AccessRecord> findByKey(Page pageInfo,String queryKey) {
		Criteria criteria = getSession().createCriteria(AccessRecord.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage()).add(Restrictions.like("manageKey", queryKey,MatchMode.ANYWHERE));
		return criteria.list();
	}
	@Override
	public Long findRowCount(String queryKey) {
		Criteria criteria = getSession().createCriteria(AccessRecord.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.like("manageKey", queryKey,MatchMode.ANYWHERE));
		return (Long) criteria.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<AccessRecord> findById(Integer[] ids) {
		Criteria criteria = getSession().createCriteria(AccessRecord.class)
		.add(Restrictions.in("id", ids));
		return criteria.list();
	}
	@Override
	public Long countBy(String key) {
		String hql = "select count(id) from AccessRecord r where r.key=:key";
		Query query = getSession().createQuery(hql);
		query.setParameter("key", key);
		Object obj = query.uniqueResult();
		return (Long)obj;
	}
}