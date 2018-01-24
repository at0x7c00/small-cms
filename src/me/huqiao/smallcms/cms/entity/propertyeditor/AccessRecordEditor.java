package me.huqiao.smallcms.cms.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import me.huqiao.smallcms.cms.entity.AccessRecord;
import me.huqiao.smallcms.cms.service.IAccessRecordService;
/**
 * 访问记录编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class AccessRecordEditor extends PropertyEditorSupport{
    public IAccessRecordService accessRecordService;
    public AccessRecordEditor(IAccessRecordService accessRecordService){
        this.accessRecordService = accessRecordService;
    }
    public String getAsText(){
        AccessRecord accessRecord = (AccessRecord)getValue();
        if(accessRecord==null){
            return "";
        }
        return String.valueOf(accessRecord.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        AccessRecord accessRecord = null;
accessRecord = accessRecordService.getEntityByProperty(AccessRecord.class,"manageKey",key);
if(accessRecord==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            accessRecord = accessRecordService.getById(AccessRecord.class,integerId);
}
if(key!=null && !key.trim().equals("") && accessRecord==null){
accessRecord=new AccessRecord();
}
        setValue(accessRecord);
    }
}