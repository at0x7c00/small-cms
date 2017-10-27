package me.huqiao.smallcms.cms.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import me.huqiao.smallcms.cms.entity.Comment;
import me.huqiao.smallcms.cms.service.ICommentService;
/**
 * 留言编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class CommentEditor extends PropertyEditorSupport{
    public ICommentService commentService;
    public CommentEditor(ICommentService commentService){
        this.commentService = commentService;
    }
    public String getAsText(){
        Comment comment = (Comment)getValue();
        if(comment==null){
            return "";
        }
        return String.valueOf(comment.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        Comment comment = null;
comment = commentService.getEntityByProperty(Comment.class,"manageKey",key);
if(comment==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            comment = commentService.getById(Comment.class,integerId);
}
if(key!=null && !key.trim().equals("") && comment==null){
comment=new Comment();
}
        setValue(comment);
    }
}