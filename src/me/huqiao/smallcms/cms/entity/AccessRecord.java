package me.huqiao.smallcms.cms.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
/**
 * 访问记录
 * @author NOVOTS
 * @version Version 1.0
 */
@Entity
@Table(name="cms_access_record")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})
public class AccessRecord
{
	public static final String key_zlda_wechat = "zlda_wechat";
	public static final String key_zlda_code_button = "zlda_code_button";
	public static final String key_zlda_web = "zlda_web";
/**唯一识别ID号 */
protected Integer id;
	/**@param id 要设置的唯一标示号*/
public void setId(Integer id){this.id=id;}
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(columnDefinition="integer")
	/**@return Integer 唯一标示号*/
public Integer getId(){return this.id;}
/**Key*/
private String key;
/**访问时间*/
private Date accessTime;
	/**访问时间开始，用于查询*/
private Date accessTimeStart;
	/**访问时间结束，用于查询*/
private Date accessTimeEnd;
/**访问地址*/
private String url;
/**来源*/
private String origin;
/**IP*/
private String ip;
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
 * @param key 要设置的Key
 */
public void setKey(String key){
    this.key = key;
}
/**
 * @return String Key 
 */
@Column(name="_key",length=255,nullable=true)
public String getKey(){
		return this.key;	
}
/**
 * @param accessTime 要设置的访问时间
 */
public void setAccessTime(Date accessTime){
    this.accessTime = accessTime;
}
/**
 * @return Date 访问时间 
 */
@Column(name="access_time",nullable=true)
public Date getAccessTime(){
		return this.accessTime;	
}
/**
  * @param accessTimeStart 要设置的访问时间开始日期
  */
public void setAccessTimeStart(Date accessTimeStart){
    this.accessTimeStart = accessTimeStart;
}
/**
  * @return Date 访问时间开始日期
  */
@Transient
public Date getAccessTimeStart(){
    return this.accessTimeStart;
}
/**
  * @param accessTimeEnd 要设置的访问时间结束日期
  */
public void setAccessTimeEnd(Date accessTimeEnd){
    this.accessTimeEnd = accessTimeEnd;
}
/**
  * @return Date 访问时间结束日期
  */
@Transient
public Date getAccessTimeEnd(){
    return this.accessTimeEnd;
}
/**
 * @param url 要设置的访问地址
 */
public void setUrl(String url){
    this.url = url;
}
/**
 * @return String 访问地址 
 */
@Column(name="url",length=255,nullable=true)
public String getUrl(){
		return this.url;	
}
/**
 * @param origin 要设置的来源
 */
public void setOrigin(String origin){
    this.origin = origin;
}
/**
 * @return String 来源 
 */
@Column(name="origin",length=255,nullable=true)
public String getOrigin(){
		return this.origin;	
}
/**
 * @param ip 要设置的IP
 */
public void setIp(String ip){
    this.ip = ip;
}
/**
 * @return String IP 
 */
@Column(name="ip",length=255,nullable=true)
public String getIp(){
		return this.ip;	
}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		AccessRecord other = null;
		try{
			other = (AccessRecord) obj;
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
		return "AccessRecord [id=" + id + ", key=" + key + ", accessTime="
				+ accessTime + ", accessTimeStart=" + accessTimeStart
				+ ", accessTimeEnd=" + accessTimeEnd + ", url=" + url
				+ ", origin=" + origin + ", ip=" + ip + ", manageKey="
				+ manageKey + "]";
	}
	
	
}