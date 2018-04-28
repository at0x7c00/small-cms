package me.huqiao.smallcms.ppll.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import me.huqiao.smallcms.ppll.entity.Company;
import me.huqiao.smallcms.ppll.service.ICompanyService;
/**
 * 收录企业编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class CompanyEditor extends PropertyEditorSupport{
    public ICompanyService companyService;
    public CompanyEditor(ICompanyService companyService){
        this.companyService = companyService;
    }
    public String getAsText(){
        Company company = (Company)getValue();
        if(company==null){
            return "";
        }
        return String.valueOf(company.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        Company company = null;
company = companyService.getEntityByProperty(Company.class,"manageKey",key);
if(company==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            company = companyService.getById(Company.class,integerId);
}
if(key!=null && !key.trim().equals("") && company==null){
company=new Company();
}
        setValue(company);
    }
}