package me.huqiao.smallcms.ppll.dao;
import java.util.List;

import me.huqiao.smallcms.common.dao.IBaseDao;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.entity.Brand;
import me.huqiao.smallcms.util.web.Page;

import org.hibernate.Criteria;
/**
 * 品牌展示DAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IBrandDao extends IBaseDao<Brand> {
    /**
     * 品牌展示查询记录数量
     * @param brand 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(Brand brand);
	/**
	 * 品牌展示历史记录数量
     * @param brand 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(Brand brand,Page pageInfo);
    /**
     * 品牌展示分页查询
     * @param brand 查询对象
     * @param pageInfo 分页查询对象
     * @return  List<Brand>  品牌展示列表 
     */
    List<Brand> findListPage(Brand brand, Page pageInfo);
	/**
	 * 品牌展示历史记录分页查询
     * @param brand 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<Brand>>  品牌展示历史列表
	 */
    List<HistoryRecord<Brand>> findHistoryListPage(Brand brand, Page pageInfo);
	/**
     * 品牌展示版本号查询
     * @param version 版本号
	 * @return Brand 品牌展示历史记录
     */
	Brand findByVersion(Integer version);
	/**
	 * 添加品牌展示查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param brand 查询对象
	 */
	public void queryCause(Criteria criteria, Brand brand);
	/**
	 * 品牌展示关键字查询
	 * @param  queryKey 查询关键字
	 * @return List<Brand> 品牌展示列表
	 */
	List<Brand> findByKey(Page pageInfo,String queryKey);
	/**
	 * 品牌展示关键字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个品牌展示
     * @param  ids id数组
	 * @return List<Brand>  品牌展示列表
     */
	List<Brand> findById(Integer[] ids);
}