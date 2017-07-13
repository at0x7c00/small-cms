package me.huqiao.smallcms.ppll.service.impl;
import java.util.List;

import javax.annotation.Resource;

import me.huqiao.smallcms.common.service.impl.BaseServiceImpl;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.dao.IBrandDao;
import me.huqiao.smallcms.ppll.entity.Brand;
import me.huqiao.smallcms.ppll.service.IBrandService;
import me.huqiao.smallcms.util.web.Page;

import org.springframework.stereotype.Service;
/**
 * 品牌展示Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class BrandServiceImpl extends BaseServiceImpl<Brand> implements IBrandService {
    /**品牌展示DAO对象*/
    @Resource
    private IBrandDao brandDao;
    @Override
    public Page<Brand> getListPage(Brand brand,Page pageInfo) {
      	pageInfo.setTotalCount(brandDao.findListRowCount(brand).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(brandDao.findListPage(brand,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<Brand>> getHistoryListPage(Brand brand, Page pageInfo) {
		pageInfo.setTotalCount(brandDao.findHistoryListRowCount(brand,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(brandDao.findHistoryListPage(brand,pageInfo));
        return pageInfo;
	}
	@Override
	public Brand findByVersion(Integer version) {
		return brandDao.findByVersion(version);
	}
	@Override
	public Page<Brand> queryByKey(String queryKey, Page<Brand> pageInfo) {
		int countRecord = brandDao.findRowCount(queryKey).intValue();
		Page<Brand> page = new Page<Brand>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<Brand> brandList = brandDao.findByKey(pageInfo,queryKey);
		page.setList(brandList);
		return page;
	}
	@Override
	public List<Brand> queryById(Integer[] ids) {
		return brandDao.findById(ids);
	}
}