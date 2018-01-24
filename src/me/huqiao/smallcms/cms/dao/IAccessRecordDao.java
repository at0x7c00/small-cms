package me.huqiao.smallcms.cms.dao;
import java.util.List;

import me.huqiao.smallcms.cms.entity.AccessRecord;
import me.huqiao.smallcms.common.dao.IBaseDao;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;

import org.hibernate.Criteria;
/**
 * 访问记录DAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IAccessRecordDao extends IBaseDao<AccessRecord> {
    /**
     * 访问记录查询记录数量
     * @param accessRecord 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(AccessRecord accessRecord);
	/**
	 * 访问记录历史记录数量
     * @param accessRecord 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(AccessRecord accessRecord,Page pageInfo);
    /**
     * 访问记��分页查询
     * @param accessRecord 查询对象
     * @param pageInfo 分页查询对象
     * @return  List<AccessRecord>  访问记录列表 
     */
    List<AccessRecord> findListPage(AccessRecord accessRecord, Page pageInfo);
	/**
	 * 访问记录历史记录分页查询
     * @param accessRecord 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<AccessRecord>>  访问记录历史列表
	 */
    List<HistoryRecord<AccessRecord>> findHistoryListPage(AccessRecord accessRecord, Page pageInfo);
	/**
     * 访问记录版本号查询
     * @param version 版本号
	 * @return AccessRecord 访问记录历史记录
     */
	AccessRecord findByVersion(Integer version);
	/**
	 * 添加访问记录查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param accessRecord 查询对象
	 */
	public void queryCause(Criteria criteria, AccessRecord accessRecord);
	/**
	 * 访问记录关键字查询
	 * @param  queryKey 查询关键字
	 * @return List<AccessRecord> 访问记录列表
	 */
	List<AccessRecord> findByKey(Page pageInfo,String queryKey);
	/**
	 * 访问记录关键字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个访问记录
     * @param  ids id数组
	 * @return List<AccessRecord>  访问记录列表
     */
	List<AccessRecord> findById(Integer[] ids);
	Long countBy(String key);
}