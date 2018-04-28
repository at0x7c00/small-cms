package me.huqiao.smallcms.ppll.service;
import java.util.List;

import me.huqiao.smallcms.common.service.IBaseService;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.entity.Company;
import me.huqiao.smallcms.util.web.Page;
/**
 * 收录企业Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface ICompanyService extends IBaseService<Company> {
    /**
     * 收录企业分页查询
     * @param company 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<Company> 收录企业分页信息对象
     */
    public Page<Company> getListPage(Company company,Page pageInfo);
	/**
	  * 收录企业历史记录分页查询
	  * @param company 查询对象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<Company>> 收录企业历史分页信息对象
	  */
	public Page<HistoryRecord<Company>> getHistoryListPage(Company company,Page pageInfo);
	/**
	 * 收录企业版本号查询
	 * @param version 查询版本号
	 * @return Company 收录企业历史记录
	 */
	public Company findByVersion(Integer version);
	/**
	 * 收录企业关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<Company> 收录企业分页信息对象
	 * 
	 */
	Page<Company> queryByKey(String queryKey, Page<Company> pageInfo);
	/**
	 * 查找多个收录企业
	 * @param ids id数组
	 * @return List<Company> 收录企业列表
	 * 
	 */
	List<Company> queryById(Integer[] ids);
}