package me.huqiao.smallcms.cms.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import me.huqiao.smallcms.sys.entity.enumtype.YesNo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
/**
 * 留言
 * @author NOVOTS
 * @version Version 1.0
 */
@Entity
@Table(name="cms_comment")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})
public class Comment
{
/**唯一识别ID号 */
protected Integer id;
	/**@param id 要设置的唯一标示号*/
public void setId(Integer id){this.id=id;}
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(columnDefinition="integer")
	/**@return Integer 唯一标示号*/
public Integer getId(){return this.id;}
/**姓名*/
private String user;
/**备注*/
private String remark;
/**电话*/
private String phone;
/**邮箱*/
private String email;
/**内容*/
private String content;
/**创建时间*/
private Date createTime;
	/**创建时间开始，用于���询*/
private Date createTimeStart;
	/**创建时间结束，用于查询*/
private Date createTimeEnd;
/**处理状态*/
private YesNo replyStatus;
	/**MD5管理ID*/
	protected String manageKey;
	/**@return String MD5管理ID */
	public String getManageKey() {
		return manageKey;
	}
	/**
	 * @param manageKey 要设置的MD5管理ID 
	 */
	public void setManageKey(String manageKey) {
		this.manageKey = manageKey;
	}
/**
 * @param user 要设置的姓名
 */
public void setUser(String user){
    this.user = user;
}
/**
 * @return String 姓名 
 */
@Column(name="user",length=255,nullable=true)
public String getUser(){
		return this.user;	
}
/**
 * @param remark 要设置的备注
 */
public void setRemark(String remark){
    this.remark = remark;
}
/**
 * @return String 备注 
 */
@Column(name="remark",length=255,columnDefinition="text",nullable=true)
public String getRemark(){
		return this.remark;	
}
/**
 * @param phone 要设置的电话
 */
public void setPhone(String phone){
    this.phone = phone;
}
/**
 * @return String 电话 
 */
@Column(name="phone",length=255,nullable=true)
public String getPhone(){
		return this.phone;	
}
/**
 * @param email 要设置的邮箱
 */
public void setEmail(String email){
    this.email = email;
}
/**
 * @return String 邮箱 
 */
@Column(name="email",length=255,nullable=true)
public String getEmail(){
		return this.email;	
}
/**
 * @param content 要设置的内容
 */
public void setContent(String content){
    this.content = content;
}
/**
 * @return String 内容 
 */
@Column(name="conent",length=300,columnDefinition="text",nullable=true)
public String getContent(){
		return this.content;	
}
/**
 * @param createTime 要设置的创建时间
 */
public void setCreateTime(Date createTime){
    this.createTime = createTime;
}
/**
 * @return Date 创建时间 
 */
@Column(name="create_time",nullable=true)
public Date getCreateTime(){
		return this.createTime;	
}
/**
  * @param createTimeStart 要设置的创建时间开始日期
  */
public void setCreateTimeStart(Date createTimeStart){
    this.createTimeStart = createTimeStart;
}
/**
  * @return Date 创建时间开始日期
  */
@Transient
public Date getCreateTimeStart(){
    return this.createTimeStart;
}
/**
  * @param createTimeEnd 要设置的创建时间结束日期
  */
public void setCreateTimeEnd(Date createTimeEnd){
    this.createTimeEnd = createTimeEnd;
}
/**
  * @return Date 创建时间结束日期
  */
@Transient
public Date getCreateTimeEnd(){
    return this.createTimeEnd;
}
/**
 * @param replyStatus 要设置的处理状态
 */
public void setReplyStatus(YesNo replyStatus){
    this.replyStatus = replyStatus;
}
/**
 * @return YesNo 处理状态 
 */
@Column(name="reply_status",nullable=true,columnDefinition="enum('Yes','No')")
@Enumerated(EnumType.STRING)
public YesNo getReplyStatus(){
		return this.replyStatus;	
}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Comment other = null;
		try{
			other = (Comment) obj;
		}catch(Exception e){
			return false;
		}
		if (manageKey == null) {
			if (other.getManageKey() != null)
				return false;
		} else if (!manageKey.equals(other.getManageKey()))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((manageKey == null) ? 0 : manageKey.hashCode());
		return result;
	}
	@Override
	public String toString() {
		return "Comment [manageKey=" + manageKey + "]";
	}
}