package me.huqiao.smallcms.ppll.service;
import java.util.List;

import me.huqiao.smallcms.common.service.IBaseService;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.entity.Brand;
import me.huqiao.smallcms.util.web.Page;
/**
 * 品牌展示Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IBrandService extends IBaseService<Brand> {
    /**
     * 品牌展示分页查询
     * @param brand 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<Brand> 品牌展示分页信息对象
     */
    public Page<Brand> getListPage(Brand brand,Page pageInfo);
	/**
	  * 品牌展示历史记录分页查询
	  * @param brand 查询对象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<Brand>> 品牌展示历史分页信息对象
	  */
	public Page<HistoryRecord<Brand>> getHistoryListPage(Brand brand,Page pageInfo);
	/**
	 * 品牌展示版本号查询
	 * @param version 查询版本号
	 * @return Brand 品牌展示历史记录
	 */
	public Brand findByVersion(Integer version);
	/**
	 * 品牌展示关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<Brand> 品牌展示分页信息对象
	 * 
	 */
	Page<Brand> queryByKey(String queryKey, Page<Brand> pageInfo);
	/**
	 * 查找多个品牌展示
	 * @param ids id数组
	 * @return List<Brand> 品牌展示列表
	 * 
	 */
	List<Brand> queryById(Integer[] ids);
}