package me.huqiao.smallcms.cms.service.impl;
import java.util.List;

import javax.annotation.Resource;

import me.huqiao.smallcms.cms.dao.IAccessRecordDao;
import me.huqiao.smallcms.cms.entity.AccessRecord;
import me.huqiao.smallcms.cms.service.IAccessRecordService;
import me.huqiao.smallcms.common.service.impl.BaseServiceImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.stereotype.Service;
/**
 * 访问记录Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class AccessRecordServiceImpl extends BaseServiceImpl<AccessRecord> implements IAccessRecordService {
    /**访问记录DAO对象*/
    @Resource
    private IAccessRecordDao accessRecordDao;
    @Override
    public Page<AccessRecord> getListPage(AccessRecord accessRecord,Page pageInfo) {
      	pageInfo.setTotalCount(accessRecordDao.findListRowCount(accessRecord).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(accessRecordDao.findListPage(accessRecord,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<AccessRecord>> getHistoryListPage(AccessRecord accessRecord, Page pageInfo) {
		pageInfo.setTotalCount(accessRecordDao.findHistoryListRowCount(accessRecord,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(accessRecordDao.findHistoryListPage(accessRecord,pageInfo));
        return pageInfo;
	}
	@Override
	public AccessRecord findByVersion(Integer version) {
		return accessRecordDao.findByVersion(version);
	}
	@Override
	public Page<AccessRecord> queryByKey(String queryKey, Page<AccessRecord> pageInfo) {
		int countRecord = accessRecordDao.findRowCount(queryKey).intValue();
		Page<AccessRecord> page = new Page<AccessRecord>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<AccessRecord> accessRecordList = accessRecordDao.findByKey(pageInfo,queryKey);
		page.setList(accessRecordList);
		return page;
	}
	@Override
	public List<AccessRecord> queryById(Integer[] ids) {
		return accessRecordDao.findById(ids);
	}
	@Override
	public Long countBy(String key){
		return accessRecordDao.countBy(key);
	}
}