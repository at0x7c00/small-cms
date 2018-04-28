package me.huqiao.smallcms.ppll.dao.impl;
import java.util.ArrayList;
import java.util.List;

import me.huqiao.smallcms.common.dao.impl.BaseDaoImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.history.entity.TestRevisionEntity;
import me.huqiao.smallcms.ppll.dao.ICompanyDao;
import me.huqiao.smallcms.ppll.entity.Company;
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
 * 收录企业DAO实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Repository
public class CompanyDaoImpl extends BaseDaoImpl<Company> implements ICompanyDao {
    @Override
    public Long findListRowCount(Company company) {
        Criteria criteria = getSession().createCriteria(Company.class).setProjection(Projections.rowCount());
        queryCause(criteria,company);
        return (Long) criteria.uniqueResult();
    }
	@Override
	public Long findHistoryListRowCount(Company company,Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(Company.class, false, true);
		query.add(AuditEntity.property("manageKey").eq(company.getManageKey()));
		queryCause(query,pageInfo);
		query.addProjection(AuditEntity.property("manageKey").count());
		return (Long) query.getSingleResult();
	}
    @SuppressWarnings("unchecked")
    @Override
    public List<Company> findListPage(Company company, Page pageInfo){
    	Criteria criteria = getSession().createCriteria(Company.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
        queryCause(criteria,company);
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
	public List<HistoryRecord<Company>> findHistoryListPage(Company company, Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(Company.class, false, true);
		query.setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
		query.add(AuditEntity.property("manageKey").eq(company.getManageKey()));
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
		List<HistoryRecord<Company>> res = new ArrayList<HistoryRecord<Company>>();
		for(Object obj : list){
			Object[] array = (Object[])obj;
			HistoryRecord<Company> record = new HistoryRecord<Company>();
			record.setRecord((Company)array[0]);
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
      * @param company 查询对象
	  */
    public void queryCause(Criteria criteria,Company company){
       if(company.getArchiveId()!=null
 && ! company.getArchiveId().trim().equals("")){
		criteria.add(Restrictions.like("archiveId",company.getArchiveId(),MatchMode.ANYWHERE));
}
       if(company.getName()!=null
 && ! company.getName().trim().equals("")){
		criteria.add(Restrictions.eq("name",company.getName()));
}
       if(company.getQueryKey()!=null
 && ! company.getQueryKey().trim().equals("")){
		criteria.add(Restrictions.or(Restrictions.eq("name",company.getQueryKey()),Restrictions.eq("archiveId",company.getQueryKey())));
}
       
       if(company.getLawPerson()!=null
 && ! company.getLawPerson().trim().equals("")){
		criteria.add(Restrictions.like("lawPerson",company.getLawPerson(),MatchMode.ANYWHERE));
}
       if(company.getAddress()!=null
 && ! company.getAddress().trim().equals("")){
		criteria.add(Restrictions.like("address",company.getAddress(),MatchMode.ANYWHERE));
}
if(company.getTimeStartStart()!=null){
criteria.add(Restrictions.ge("timeStart",company.getTimeStartStart()));
}
if(company.getTimeStartEnd()!=null){
criteria.add(Restrictions.le("timeStart",company.getTimeStartEnd()));
}
if(company.getTimeEndStart()!=null){
criteria.add(Restrictions.ge("timeEnd",company.getTimeEndStart()));
}
if(company.getTimeEndEnd()!=null){
criteria.add(Restrictions.le("timeEnd",company.getTimeEndEnd()));
}
				if(company.getLicense()!=null && company.getLicense().getId() != null ){
					criteria.add(Restrictions.eq("license",company.getLicense()));
				}
				if(company.getApply()!=null && company.getApply().getId() != null ){
					criteria.add(Restrictions.eq("apply",company.getApply()));
				}
    }
	@Override
	public Company findByVersion(Integer version) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forEntitiesAtRevision(Company.class, version);
		query.add(AuditEntity.revisionNumber().eq(version));
		List list = query.getResultList();
		if(list!=null && list.size()>0){
			return (Company)list.get(0);
		}
		return null;
	}
	@Override
	public List<Company> findByKey(Page pageInfo,String queryKey) {
		Criteria criteria = getSession().createCriteria(Company.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage()).add(Restrictions.like("name", queryKey,MatchMode.ANYWHERE));
		return criteria.list();
	}
	@Override
	public Long findRowCount(String queryKey) {
		Criteria criteria = getSession().createCriteria(Company.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.like("name", queryKey,MatchMode.ANYWHERE));
		return (Long) criteria.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findById(Integer[] ids) {
		Criteria criteria = getSession().createCriteria(Company.class)
		.add(Restrictions.in("id", ids));
		return criteria.list();
	}
}