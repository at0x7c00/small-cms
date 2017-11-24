package me.huqiao.smallcms.ppll.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import me.huqiao.smallcms.ppll.entity.ZwCode;
import me.huqiao.smallcms.ppll.service.IZwCodeService;
/**
 * 质维码编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class ZwCodeEditor extends PropertyEditorSupport{
    public IZwCodeService zwCodeService;
    public ZwCodeEditor(IZwCodeService zwCodeService){
        this.zwCodeService = zwCodeService;
    }
    public String getAsText(){
        ZwCode zwCode = (ZwCode)getValue();
        if(zwCode==null){
            return "";
        }
        return String.valueOf(zwCode.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        ZwCode zwCode = null;
zwCode = zwCodeService.getEntityByProperty(ZwCode.class,"manageKey",key);
if(zwCode==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            zwCode = zwCodeService.getById(ZwCode.class,integerId);
}
if(key!=null && !key.trim().equals("") && zwCode==null){
zwCode=new ZwCode();
}
        setValue(zwCode);
    }
}