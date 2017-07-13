package me.huqiao.smallcms.ppll.dao.impl;
import java.util.ArrayList;
import java.util.List;

import me.huqiao.smallcms.common.dao.impl.BaseDaoImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.history.entity.TestRevisionEntity;
import me.huqiao.smallcms.ppll.dao.IBrandDao;
import me.huqiao.smallcms.ppll.entity.Brand;
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
 * 品牌展示DAO实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Repository
public class BrandDaoImpl extends BaseDaoImpl<Brand> implements IBrandDao {
    @Override
    public Long findListRowCount(Brand brand) {
        Criteria criteria = getSession().createCriteria(Brand.class).setProjection(Projections.rowCount());
        queryCause(criteria,brand);
        return (Long) criteria.uniqueResult();
    }
	@Override
	public Long findHistoryListRowCount(Brand brand,Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(Brand.class, false, true);
		query.add(AuditEntity.property("manageKey").eq(brand.getManageKey()));
		queryCause(query,pageInfo);
		query.addProjection(AuditEntity.property("manageKey").count());
		return (Long) query.getSingleResult();
	}
    @SuppressWarnings("unchecked")
    @Override
    public List<Brand> findListPage(Brand brand, Page pageInfo){
    	Criteria criteria = getSession().createCriteria(Brand.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
        queryCause(criteria,brand);
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
	public List<HistoryRecord<Brand>> findHistoryListPage(Brand brand, Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(Brand.class, false, true);
		query.setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
		query.add(AuditEntity.property("manageKey").eq(brand.getManageKey()));
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
		List<HistoryRecord<Brand>> res = new ArrayList<HistoryRecord<Brand>>();
		for(Object obj : list){
			Object[] array = (Object[])obj;
			HistoryRecord<Brand> record = new HistoryRecord<Brand>();
			record.setRecord((Brand)array[0]);
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
      * @param brand 查询对象
	  */
    public void queryCause(Criteria criteria,Brand brand){
       if(brand.getName()!=null
 && ! brand.getName().trim().equals("")){
		criteria.add(Restrictions.like("name",brand.getName(),MatchMode.ANYWHERE));
}
       if(brand.getUrl()!=null
 && ! brand.getUrl().trim().equals("")){
		criteria.add(Restrictions.like("url",brand.getUrl(),MatchMode.ANYWHERE));
}
				if(brand.getLogo()!=null && brand.getLogo().getId() != null ){
					criteria.add(Restrictions.eq("logo",brand.getLogo()));
				}
       if(brand.getOrderNum()!=null
){
		criteria.add(Restrictions.eq("orderNum",brand.getOrderNum()));
}
       if(brand.getStatus()!=null
){
		criteria.add(Restrictions.eq("status",brand.getStatus()));
}
    }
	@Override
	public Brand findByVersion(Integer version) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forEntitiesAtRevision(Brand.class, version);
		query.add(AuditEntity.revisionNumber().eq(version));
		List list = query.getResultList();
		if(list!=null && list.size()>0){
			return (Brand)list.get(0);
		}
		return null;
	}
	@Override
	public List<Brand> findByKey(Page pageInfo,String queryKey) {
		Criteria criteria = getSession().createCriteria(Brand.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage()).add(Restrictions.like("name", queryKey,MatchMode.ANYWHERE));
		return criteria.list();
	}
	@Override
	public Long findRowCount(String queryKey) {
		Criteria criteria = getSession().createCriteria(Brand.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.like("name", queryKey,MatchMode.ANYWHERE));
		return (Long) criteria.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Brand> findById(Integer[] ids) {
		Criteria criteria = getSession().createCriteria(Brand.class)
		.add(Restrictions.in("id", ids));
		return criteria.list();
	}
}