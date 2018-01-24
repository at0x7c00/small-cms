package me.huqiao.smallcms.ppll.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import me.huqiao.smallcms.ppll.entity.ProjectInfo;
import me.huqiao.smallcms.ppll.service.IProjectInfoService;
/**
 * 项目简介编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class ProjectInfoEditor extends PropertyEditorSupport{
    public IProjectInfoService projectInfoService;
    public ProjectInfoEditor(IProjectInfoService projectInfoService){
        this.projectInfoService = projectInfoService;
    }
    public String getAsText(){
        ProjectInfo projectInfo = (ProjectInfo)getValue();
        if(projectInfo==null){
            return "";
        }
        return String.valueOf(projectInfo.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        ProjectInfo projectInfo = null;
projectInfo = projectInfoService.getEntityByProperty(ProjectInfo.class,"manageKey",key);
if(projectInfo==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            projectInfo = projectInfoService.getById(ProjectInfo.class,integerId);
}
if(key!=null && !key.trim().equals("") && projectInfo==null){
projectInfo=new ProjectInfo();
}
        setValue(projectInfo);
    }
}