package me.huqiao.smallcms.ppll.service.impl;
import java.util.List;

import javax.annotation.Resource;

import me.huqiao.smallcms.common.service.impl.BaseServiceImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.dao.IZwCodeDao;
import me.huqiao.smallcms.ppll.entity.ZwCode;
import me.huqiao.smallcms.ppll.service.IZwCodeService;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.stereotype.Service;
/**
 * 质维码Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class ZwCodeServiceImpl extends BaseServiceImpl<ZwCode> implements IZwCodeService {
    /**质维码DAO对象*/
    @Resource
    private IZwCodeDao zwCodeDao;
    @Override
    public Page<ZwCode> getListPage(ZwCode zwCode,Page pageInfo) {
      	pageInfo.setTotalCount(zwCodeDao.findListRowCount(zwCode).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "desc": pageInfo.getOrderDirection());
		pageInfo.setList(zwCodeDao.findListPage(zwCode,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<ZwCode>> getHistoryListPage(ZwCode zwCode, Page pageInfo) {
		pageInfo.setTotalCount(zwCodeDao.findHistoryListRowCount(zwCode,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "desc": pageInfo.getOrderDirection());
		pageInfo.setList(zwCodeDao.findHistoryListPage(zwCode,pageInfo));
        return pageInfo;
	}
	@Override
	public ZwCode findByVersion(Integer version) {
		return zwCodeDao.findByVersion(version);
	}
	@Override
	public Page<ZwCode> queryByKey(String queryKey, Page<ZwCode> pageInfo) {
		int countRecord = zwCodeDao.findRowCount(queryKey).intValue();
		Page<ZwCode> page = new Page<ZwCode>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<ZwCode> zwCodeList = zwCodeDao.findByKey(pageInfo,queryKey);
		page.setList(zwCodeList);
		return page;
	}
	@Override
	public List<ZwCode> queryById(Integer[] ids) {
		return zwCodeDao.findById(ids);
	}
}