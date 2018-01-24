package me.huqiao.smallcms.ppll.service;
import java.util.List;

import me.huqiao.smallcms.common.service.IBaseService;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.entity.ProjectInfo;
import me.huqiao.smallcms.util.web.Page;
/**
 * 项目简介Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IProjectInfoService extends IBaseService<ProjectInfo> {
    /**
     * 项目简介分页查询
     * @param projectInfo 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<ProjectInfo> 项目简介分页信息对象
     */
    public Page<ProjectInfo> getListPage(ProjectInfo projectInfo,Page pageInfo);
	/**
	  * 项目简介历史记录分页查询
	  * @param projectInfo 查询对象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<ProjectInfo>> 项目简介历史分页信息对象
	  */
	public Page<HistoryRecord<ProjectInfo>> getHistoryListPage(ProjectInfo projectInfo,Page pageInfo);
	/**
	 * 项目简介版本号查询
	 * @param version 查询版本号
	 * @return ProjectInfo 项目简介历史记录
	 */
	public ProjectInfo findByVersion(Integer version);
	/**
	 * 项目简介关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<ProjectInfo> 项目简介分页信息对象
	 * 
	 */
	Page<ProjectInfo> queryByKey(String queryKey, Page<ProjectInfo> pageInfo);
	/**
	 * 查找多个项目简介
	 * @param ids id数组
	 * @return List<ProjectInfo> 项目简介列表
	 * 
	 */
	List<ProjectInfo> queryById(Integer[] ids);
}