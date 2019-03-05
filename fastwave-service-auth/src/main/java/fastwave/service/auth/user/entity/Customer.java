package fastwave.service.auth.user.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 客户表
 * 
 * @author fastwave.developer
 * @date 
 */
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//客户名称
	private String customerName;
	//组织模式。 1=行政区划，2=自建组织
	private Integer dataMode;
	//如果组织模式为行政区划时，客户所选行政区域的根区域
	private String districtCode;
	//联系人
	private String contactPerson;
	//联系电话
	private String contactTel;
	//license文件
	private String license;
	//过期时间
	private Date expireDate;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：客户名称
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * 获取：客户名称
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * 设置：组织模式。 1=行政区划，2=自建组织
	 */
	public void setDataMode(Integer dataMode) {
		this.dataMode = dataMode;
	}
	/**
	 * 获取：组织模式。 1=行政区划，2=自建组织
	 */
	public Integer getDataMode() {
		return dataMode;
	}
	/**
	 * 设置：如果组织模式为行政区划时，客户所选行政区域的根区域
	 */
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	/**
	 * 获取：如果组织模式为行政区划时，客户所选行政区域的根区域
	 */
	public String getDistrictCode() {
		return districtCode;
	}
	/**
	 * 设置：联系人
	 */
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	/**
	 * 获取：联系人
	 */
	public String getContactPerson() {
		return contactPerson;
	}
	/**
	 * 设置：联系电话
	 */
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}
	/**
	 * 获取：联系电话
	 */
	public String getContactTel() {
		return contactTel;
	}
	/**
	 * 设置：license文件
	 */
	public void setLicense(String license) {
		this.license = license;
	}
	/**
	 * 获取：license文件
	 */
	public String getLicense() {
		return license;
	}
	/**
	 * 设置：过期时间
	 */
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	/**
	 * 获取：过期时间
	 */
	public Date getExpireDate() {
		return expireDate;
	}
}
