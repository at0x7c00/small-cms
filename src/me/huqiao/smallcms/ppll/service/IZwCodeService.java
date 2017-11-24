package me.huqiao.smallcms.ppll.service;
import java.util.List;

import me.huqiao.smallcms.common.service.IBaseService;
import me.huqiao.smallcms.history.entity.HistoryRecord;
import me.huqiao.smallcms.ppll.entity.ZwCode;
import me.huqiao.smallcms.util.web.Page;
/**
 * 质维码Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IZwCodeService extends IBaseService<ZwCode> {
    /**
     * 质维码分页查询
     * @param zwCode 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<ZwCode> 质维码分页信息对象
     */
    public Page<ZwCode> getListPage(ZwCode zwCode,Page pageInfo);
	/**
	  * 质维码历史记录分页查询
	  * @param zwCode 查询对象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<ZwCode>> 质维码历史分页信息对象
	  */
	public Page<HistoryRecord<ZwCode>> getHistoryListPage(ZwCode zwCode,Page pageInfo);
	/**
	 * 质维码版本号查询
	 * @param version 查询版本号
	 * @return ZwCode 质维码历史记录
	 */
	public ZwCode findByVersion(Integer version);
	/**
	 * 质维码关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<ZwCode> 质维码分页信息对象
	 * 
	 */
	Page<ZwCode> queryByKey(String queryKey, Page<ZwCode> pageInfo);
	/**
	 * 查找多个质维码
	 * @param ids id数组
	 * @return List<ZwCode> 质维码列表
	 * 
	 */
	List<ZwCode> queryById(Integer[] ids);
}