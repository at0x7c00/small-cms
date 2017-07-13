package me.huqiao.smallcms.ppll.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import me.huqiao.smallcms.ppll.entity.Brand;
import me.huqiao.smallcms.ppll.service.IBrandService;
/**
 * 品牌展示编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class BrandEditor extends PropertyEditorSupport{
    public IBrandService brandService;
    public BrandEditor(IBrandService brandService){
        this.brandService = brandService;
    }
    public String getAsText(){
        Brand brand = (Brand)getValue();
        if(brand==null){
            return "";
        }
        return String.valueOf(brand.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        Brand brand = null;
brand = brandService.getEntityByProperty(Brand.class,"manageKey",key);
if(brand==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            brand = brandService.getById(Brand.class,integerId);
}
if(key!=null && !key.trim().equals("") && brand==null){
brand=new Brand();
}
        setValue(brand);
    }
}