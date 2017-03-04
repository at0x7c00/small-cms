package me.huqiao.smallcms.cms.controller;
import me.huqiao.smallcms.common.controller.BaseController;

import org.springframework.stereotype.Controller;
/**
 * 轮播控制器
 * @author NOVOTS
 * @version Version 1.0
 */
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping(value = "frontend")
public class FrontendController  extends BaseController {
	
	@RequestMapping("index")
	public void index(){
		
	}
	
}