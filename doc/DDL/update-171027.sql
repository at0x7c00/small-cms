#留言-----------------------------------------------
INSERT INTO `sys_function_point` (`id`,`is_display`, `name`, `order_num`, `url`, `parent`)VALUES ('910',1,'留言管理','850','comment/list.do','706');
INSERT INTO `sys_function_point` (`id`,`is_display`, `name`, `order_num`, `url`, `parent`)VALUES ('911',0,'留言添加','1','comment/add.do','910');
INSERT INTO `sys_function_point` (`id`,`is_display`, `name`, `order_num`, `url`, `parent`)VALUES ('912',0,'删除留言','2','comment/delete.do','910');
INSERT INTO `sys_function_point` (`id`,`is_display`, `name`, `order_num`, `url`, `parent`)VALUES ('913',0,'留言修改','3','comment/update.do','910');
INSERT INTO `sys_function_point` (`id`,`is_display`, `name`, `order_num`, `url`, `parent`)VALUES ('915',0,'留言查看','5','comment/detail.do','910');

INSERT INTO `cms_web_page` VALUES ('5', 'zhiliangbaoguang', 'acad77c0ffc4d644bf9c33fbed994915', '质量曝光', '5', 'InUse');
INSERT INTO `cms_web_page` VALUES ('6', 'huodonghuigu', '6f6789a5054377b7a999eb0cfaeb4dc7', '活动回顾', '6', 'InUse');
INSERT INTO `cms_web_page` VALUES ('7', 'shishiredian', '7c35c0be8d4b7f32f8abfa119c007950', '时事热点', '7', 'InUse');
INSERT INTO `cms_web_page` VALUES ('8', 'zhiliangqiangqi', '37decc6f9170fbc1128d56ef76d5cbff', '质量强企', '8', 'InUse');

INSERT INTO `sys_role_function_point` VALUES ('1', '910');
INSERT INTO `sys_role_function_point` VALUES ('1', '911');
INSERT INTO `sys_role_function_point` VALUES ('1', '912');
INSERT INTO `sys_role_function_point` VALUES ('1', '913');
INSERT INTO `sys_role_function_point` VALUES ('1', '915');