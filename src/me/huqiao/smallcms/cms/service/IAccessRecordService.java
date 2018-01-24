package me.huqiao.smallcms.cms.service;
import java.util.List;

import me.huqiao.smallcms.cms.entity.AccessRecord;
import me.huqiao.smallcms.common.service.IBaseService;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;
/**
 * 访问记录Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IAccessRecordService extends IBaseService<AccessRecord> {
    /**
     * 访问记录分页查询
     * @param accessRecord 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<AccessRecord> 访问记录分页信息对象
     */
    public Page<AccessRecord> getListPage(AccessRecord accessRecord,Page pageInfo);
	/**
	  * 访问记录历史记录分页查询
	  * @param accessRecord 查询对象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<AccessRecord>> 访问记录历史分页信息对象
	  */
	public Page<HistoryRecord<AccessRecord>> getHistoryListPage(AccessRecord accessRecord,Page pageInfo);
	/**
	 * 访问记录版本号查询
	 * @param version 查询版本号
	 * @return AccessRecord 访问记录历史记录
	 */
	public AccessRecord findByVersion(Integer version);
	/**
	 * 访问记录关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<AccessRecord> 访问记录分页信息对象
	 * 
	 */
	Page<AccessRecord> queryByKey(String queryKey, Page<AccessRecord> pageInfo);
	/**
	 * 查找多个访问记录
	 * @param ids id数组
	 * @return List<AccessRecord> 访问记录列表
	 * 
	 */
	List<AccessRecord> queryById(Integer[] ids);
	
	public Long countBy(String key);
}