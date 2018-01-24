package me.huqiao.smallcms.ppll.service.impl;
import java.util.List;

import javax.annotation.Resource;

import me.huqiao.smallcms.common.service.impl.BaseServiceImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.dao.IProjectInfoDao;
import me.huqiao.smallcms.ppll.entity.ProjectInfo;
import me.huqiao.smallcms.ppll.service.IProjectInfoService;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.stereotype.Service;
/**
 * 项目简介Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class ProjectInfoServiceImpl extends BaseServiceImpl<ProjectInfo> implements IProjectInfoService {
    /**项目简介DAO对象*/
    @Resource
    private IProjectInfoDao projectInfoDao;
    @Override
    public Page<ProjectInfo> getListPage(ProjectInfo projectInfo,Page pageInfo) {
      	pageInfo.setTotalCount(projectInfoDao.findListRowCount(projectInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(projectInfoDao.findListPage(projectInfo,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<ProjectInfo>> getHistoryListPage(ProjectInfo projectInfo, Page pageInfo) {
		pageInfo.setTotalCount(projectInfoDao.findHistoryListRowCount(projectInfo,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(projectInfoDao.findHistoryListPage(projectInfo,pageInfo));
        return pageInfo;
	}
	@Override
	public ProjectInfo findByVersion(Integer version) {
		return projectInfoDao.findByVersion(version);
	}
	@Override
	public Page<ProjectInfo> queryByKey(String queryKey, Page<ProjectInfo> pageInfo) {
		int countRecord = projectInfoDao.findRowCount(queryKey).intValue();
		Page<ProjectInfo> page = new Page<ProjectInfo>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<ProjectInfo> projectInfoList = projectInfoDao.findByKey(pageInfo,queryKey);
		page.setList(projectInfoList);
		return page;
	}
	@Override
	public List<ProjectInfo> queryById(Integer[] ids) {
		return projectInfoDao.findById(ids);
	}
}