package me.huqiao.smallcms.ppll.dao;
import java.util.List;

import me.huqiao.smallcms.common.dao.IBaseDao;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.entity.ProjectInfo;
import me.huqiao.smallcms.util.web.Page;

import org.hibernate.Criteria;
/**
 * 项目简介DAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IProjectInfoDao extends IBaseDao<ProjectInfo> {
    /**
     * 项目简介查询记录数量
     * @param projectInfo 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(ProjectInfo projectInfo);
	/**
	 * 项目简介历史记录数量
     * @param projectInfo 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(ProjectInfo projectInfo,Page pageInfo);
    /**
     * 项目简介分页查询
     * @param projectInfo 查询对象
     * @param pageInfo 分页查询对象
     * @return  List<ProjectInfo>  项目简介列表 
     */
    List<ProjectInfo> findListPage(ProjectInfo projectInfo, Page pageInfo);
	/**
	 * 项目简介历史记录分页查询
     * @param projectInfo 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<ProjectInfo>>  项目简介历史列表
	 */
    List<HistoryRecord<ProjectInfo>> findHistoryListPage(ProjectInfo projectInfo, Page pageInfo);
	/**
     * 项目简介版本号查询
     * @param version 版本号
	 * @return ProjectInfo 项目简介历史记录
     */
	ProjectInfo findByVersion(Integer version);
	/**
	 * 添加项目简介查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param projectInfo 查询对象
	 */
	public void queryCause(Criteria criteria, ProjectInfo projectInfo);
	/**
	 * 项目简介关键字查询
	 * @param  queryKey 查询关键字
	 * @return List<ProjectInfo> 项目简介列表
	 */
	List<ProjectInfo> findByKey(Page pageInfo,String queryKey);
	/**
	 * 项目简介关键字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个项目简介
     * @param  ids id数组
	 * @return List<ProjectInfo>  项目简介列表
     */
	List<ProjectInfo> findById(Integer[] ids);
}