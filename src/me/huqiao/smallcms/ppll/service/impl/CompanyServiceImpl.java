package me.huqiao.smallcms.ppll.service.impl;
import java.util.List;

import javax.annotation.Resource;

import me.huqiao.smallcms.common.service.impl.BaseServiceImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.dao.ICompanyDao;
import me.huqiao.smallcms.ppll.entity.Company;
import me.huqiao.smallcms.ppll.service.ICompanyService;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.stereotype.Service;
/**
 * 收录企业Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class CompanyServiceImpl extends BaseServiceImpl<Company> implements ICompanyService {
    /**收录企业DAO对象*/
    @Resource
    private ICompanyDao companyDao;
    @Override
    public Page<Company> getListPage(Company company,Page pageInfo) {
      	pageInfo.setTotalCount(companyDao.findListRowCount(company).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(companyDao.findListPage(company,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<Company>> getHistoryListPage(Company company, Page pageInfo) {
		pageInfo.setTotalCount(companyDao.findHistoryListRowCount(company,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(companyDao.findHistoryListPage(company,pageInfo));
        return pageInfo;
	}
	@Override
	public Company findByVersion(Integer version) {
		return companyDao.findByVersion(version);
	}
	@Override
	public Page<Company> queryByKey(String queryKey, Page<Company> pageInfo) {
		int countRecord = companyDao.findRowCount(queryKey).intValue();
		Page<Company> page = new Page<Company>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<Company> companyList = companyDao.findByKey(pageInfo,queryKey);
		page.setList(companyList);
		return page;
	}
	@Override
	public List<Company> queryById(Integer[] ids) {
		return companyDao.findById(ids);
	}
}