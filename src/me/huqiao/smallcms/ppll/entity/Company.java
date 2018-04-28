package me.huqiao.smallcms.ppll.entity;
import java.util.Date;

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
 * 收录企业
 * @author NOVOTS
 * @version Version 1.0
 */
@Entity
@Table(name="ppll_company")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})
public class Company
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
/**档案号*/
private String archiveId;
/**公司名称*/
private String name;
/**法人代表*/
private String lawPerson;
/**企业所在地*/
private String address;
/**收录年限（开始）*/
private Date timeStart;
	/**收录年限（开始）开始，用于查询*/
private Date timeStartStart;
	/**收录年限（开始）结束，用于查询*/
private Date timeStartEnd;
/**收录年限（结束）*/
private Date timeEnd;
	/**收录年限（结束）开始，用于查询*/
private Date timeEndStart;
	/**收录年限（结束）结束，用于查询*/
private Date timeEndEnd;
/**营业执照*/
private CommonFile license;
	/**营业执照模糊查询条件*/
private String licenseQuery;
/**入档申请表*/
private CommonFile apply;
	/**入档申请表模糊查询条件*/
private String applyQuery;

private String queryKey;
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
 * @param archiveId 要设置的档案号
 */
public void setArchiveId(String archiveId){
    this.archiveId = archiveId;
}
/**
 * @return String 档案号 
 */
@Column(name="archive_id",length=255,nullable=true)
public String getArchiveId(){
		return this.archiveId;	
}
/**
 * @param name 要设置的公司名称
 */
public void setName(String name){
    this.name = name;
}
/**
 * @return String 公司名称 
 */
@Column(name="name",length=255,nullable=true)
public String getName(){
		return this.name;	
}
/**
 * @param lawPerson 要设置的法人代表
 */
public void setLawPerson(String lawPerson){
    this.lawPerson = lawPerson;
}
/**
 * @return String 法人代表 
 */
@Column(name="law_person",length=255,nullable=true)
public String getLawPerson(){
		return this.lawPerson;	
}
/**
 * @param address 要设置的企业所在地
 */
public void setAddress(String address){
    this.address = address;
}
/**
 * @return String 企业所在地 
 */
@Column(name="address",length=255,nullable=true)
public String getAddress(){
		return this.address;	
}
/**
 * @param timeStart 要设置的收录年限（开始）
 */
public void setTimeStart(Date timeStart){
    this.timeStart = timeStart;
}
/**
 * @return Date 收录年限（开始） 
 */
@Column(name="time_start",nullable=true)
public Date getTimeStart(){
		return this.timeStart;	
}
/**
  * @param timeStartStart 要设置的收录年限（开始）开始日期
  */
public void setTimeStartStart(Date timeStartStart){
    this.timeStartStart = timeStartStart;
}
/**
  * @return Date 收录年限（开始）开始日期
  */
@Transient
public Date getTimeStartStart(){
    return this.timeStartStart;
}
/**
  * @param timeStartEnd 要设置的收录年限（开始）结束日期
  */
public void setTimeStartEnd(Date timeStartEnd){
    this.timeStartEnd = timeStartEnd;
}
/**
  * @return Date 收录年限（开始）结束日期
  */
@Transient
public Date getTimeStartEnd(){
    return this.timeStartEnd;
}
/**
 * @param timeEnd 要设置的收录年限（结束）
 */
public void setTimeEnd(Date timeEnd){
    this.timeEnd = timeEnd;
}
/**
 * @return Date 收录年限（结束） 
 */
@Column(name="time_end",nullable=true)
public Date getTimeEnd(){
		return this.timeEnd;	
}
/**
  * @param timeEndStart 要设置的收录年限（结束）开始日期
  */
public void setTimeEndStart(Date timeEndStart){
    this.timeEndStart = timeEndStart;
}
/**
  * @return Date 收录年限（结束）开始日期
  */
@Transient
public Date getTimeEndStart(){
    return this.timeEndStart;
}
/**
  * @param timeEndEnd 要设置的收录年限（结束）结束日期
  */
public void setTimeEndEnd(Date timeEndEnd){
    this.timeEndEnd = timeEndEnd;
}
/**
  * @return Date 收录年限（结束）结束日期
  */
@Transient
public Date getTimeEndEnd(){
    return this.timeEndEnd;
}
/**
 * @param license 要设置的营业执照
 */
public void setLicense(CommonFile license){
    this.license = license;
}
/**
 * @param licenseQuery 要设置的营业执照模糊查询条件
 */
public void setLicenseQuery(String licenseQuery){
    this.licenseQuery = licenseQuery;
}
/**
 * @return CommonFile 营业执照 
 */
@ManyToOne(targetEntity=me.huqiao.smallcms.common.entity.CommonFile.class,fetch=FetchType.LAZY)
@JoinColumn(name="license",nullable=true)
@Fetch(FetchMode.SELECT)
@JsonIgnore
public CommonFile getLicense(){
		return this.license;	
}
/**
 * @return  String 营业执照模糊查询条件
 */
@Transient
public String getLicenseQuery(){
    return this.licenseQuery;
}
/**
 * @param apply 要设置的入档申请表
 */
public void setApply(CommonFile apply){
    this.apply = apply;
}
/**
 * @param applyQuery 要设置的入档申请表模糊查询条件
 */
public void setApplyQuery(String applyQuery){
    this.applyQuery = applyQuery;
}
/**
 * @return CommonFile 入档申请表 
 */
@ManyToOne(targetEntity=me.huqiao.smallcms.common.entity.CommonFile.class,fetch=FetchType.LAZY)
@JoinColumn(name="apply",nullable=true)
@Fetch(FetchMode.SELECT)
@JsonIgnore
public CommonFile getApply(){
		return this.apply;	
}
/**
 * @return  String 入档申请表模糊查询条件
 */
@Transient
public String getApplyQuery(){
    return this.applyQuery;
}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Company other = null;
		try{
			other = (Company) obj;
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
		return "Company [manageKey=" + manageKey + "]";
	}
	
	@Transient
	public String getQueryKey() {
		return queryKey;
	}
	public void setQueryKey(String queryKey) {
		this.queryKey = queryKey;
	}
	
	
}