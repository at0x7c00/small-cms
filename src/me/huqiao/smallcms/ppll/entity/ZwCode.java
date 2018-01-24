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
 * 质维码
 * @author NOVOTS
 * @version Version 1.0
 */
@Entity
@Table(name="ppll_zw_code")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})
public class ZwCode
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
/**企业名称*/
private String companyName;
/**二维码*/
private CommonFile code;
	/**二维码模糊查询条件*/
private String codeQuery;

private String url;
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
 * @param companyName 要设置的企业名称
 */
public void setCompanyName(String companyName){
    this.companyName = companyName;
}
/**
 * @return String 企业名称 
 */
@Column(name="company_name",length=255,nullable=true)
public String getCompanyName(){
		return this.companyName;	
}
/**
 * @param code 要设置的二维码
 */
public void setCode(CommonFile code){
    this.code = code;
}
/**
 * @param codeQuery 要设置的二维码模糊查询条件
 */
public void setCodeQuery(String codeQuery){
    this.codeQuery = codeQuery;
}
/**
 * @return CommonFile 二维码 
 */
@ManyToOne(targetEntity=me.huqiao.smallcms.common.entity.CommonFile.class,fetch=FetchType.LAZY)
@JoinColumn(name="code",nullable=true)
@Fetch(FetchMode.SELECT)
@JsonIgnore
public CommonFile getCode(){
		return this.code;	
}
/**
 * @return  String 二维码模糊查询条件
 */
@Transient
public String getCodeQuery(){
    return this.codeQuery;
}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		ZwCode other = null;
		try{
			other = (ZwCode) obj;
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
		return "ZwCode [manageKey=" + manageKey + "]";
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	private Integer wechatAccessCount;
	private Integer btnAccessCount;
	
	@Transient
	public Integer getWechatAccessCount() {
		return wechatAccessCount;
	}
	public void setWechatAccessCount(Integer wechatAccessCount) {
		this.wechatAccessCount = wechatAccessCount;
	}
	@Transient
	public Integer getBtnAccessCount() {
		return btnAccessCount;
	}
	public void setBtnAccessCount(Integer btnAccessCount) {
		this.btnAccessCount = btnAccessCount;
	}
	

	@Transient
	public String getCodeId(){
		String url = this.url;
		if(url==null || !url.contains("?") || !url.contains("=")){
			return "none";
		}
		url = url.substring(url.indexOf("?")+1);
		for(String pv : url.split("&")){
			String[] pair = pv.split("=");
			if(pair[0].equals("id")){
				return pair[1];
			}
		}
		return "none";
	}
	
}