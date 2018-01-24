package me.huqiao.smallcms.ppll.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import me.huqiao.smallcms.common.entity.CommonFile;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 项目简介
 * @author NOVOTS
 * @version Version 1.0
 */
@Entity
@Table(name="ppll_project_info")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})
public class ProjectInfo
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
/**简介内容*/
private String content;
/**图片或视频*/
private CommonFile cover;
	/**图片或视频模糊查询条件*/
private String coverQuery;
	/**MD5管理ID*/
	protected String manageKey;
	/**@return String MD5管理ID */
	@Column(name = "manage_key")
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
 * @param content 要设置的简介内容
 */
public void setContent(String content){
    this.content = content;
}
/**
 * @return String 简介内容 
 */
@Column(name="content",length=255,columnDefinition="text",nullable=true)
public String getContent(){
		return this.content;	
}
/**
 * @param cover 要设置的图片或视频
 */
public void setCover(CommonFile cover){
    this.cover = cover;
}
/**
 * @param coverQuery 要设置的图片或视频模糊查询条件
 */
public void setCoverQuery(String coverQuery){
    this.coverQuery = coverQuery;
}
/**
 * @return CommonFile 图片或视频 
 */
@ManyToOne(targetEntity=me.huqiao.smallcms.common.entity.CommonFile.class,fetch=FetchType.LAZY)
@JoinColumn(name="cover_id",nullable=true)
@Fetch(FetchMode.SELECT)
@JsonIgnore
public CommonFile getCover(){
		return this.cover;	
}
/**
 * @return  String 图片或视频模糊查询条件
 */
@Transient
public String getCoverQuery(){
    return this.coverQuery;
}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		ProjectInfo other = null;
		try{
			other = (ProjectInfo) obj;
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
		return "ProjectInfo [manageKey=" + manageKey + "]";
	}
}