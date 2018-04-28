package me.huqiao.smallcms.ppll.dao;
import java.util.List;

import me.huqiao.smallcms.common.dao.IBaseDao;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.entity.Company;
import me.huqiao.smallcms.util.web.Page;

import org.hibernate.Criteria;
/**
 * 收录企业DAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface ICompanyDao extends IBaseDao<Company> {
    /**
     * 收录企业查询记录数量
     * @param company 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(Company company);
	/**
	 * 收录企业历史记录数量
     * @param company 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(Company company,Page pageInfo);
    /**
     * 收录企业分页查询
     * @param company 查询对象
     * @param pageInfo 分页查询对象
     * @return  List<Company>  收录企业列表 
     */
    List<Company> findListPage(Company company, Page pageInfo);
	/**
	 * 收录企业历史记录分页查询
     * @param company 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<Company>>  收录企业历史列表
	 */
    List<HistoryRecord<Company>> findHistoryListPage(Company company, Page pageInfo);
	/**
     * 收录企业版本号查询
     * @param version 版本号
	 * @return Company 收录企业历史记录
     */
	Company findByVersion(Integer version);
	/**
	 * 添加收录企业查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param company 查询对象
	 */
	public void queryCause(Criteria criteria, Company company);
	/**
	 * 收录企业关键字查询
	 * @param  queryKey 查询关键字
	 * @return List<Company> 收录企业列表
	 */
	List<Company> findByKey(Page pageInfo,String queryKey);
	/**
	 * 收录企业关键字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个收录企业
     * @param  ids id数组
	 * @return List<Company>  收录企业列表
     */
	List<Company> findById(Integer[] ids);
}