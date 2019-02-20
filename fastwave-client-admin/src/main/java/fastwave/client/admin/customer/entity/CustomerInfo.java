package fastwave.client.admin.customer.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 客户表
 * 
 * @author fastwave.developer
 * @date 2018-05-22 16:32:58
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class CustomerInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//客户名称
	private String customerName;
	//数据模式。 1=行政区划，2=组织架构
	private Integer dataMode;
	//如果权限模式为行政区划时，客户所选行政区域的根区域
	private String districtCode;
	//联系人
	private String contactPerson;
	//联系电话
	private String contactTel;
	//license文件
	private String license;
	//过期时间
	private Date expireDate;
	//
	private Long createBy;
	//
	private Date createDate;
	//
	private Long updateBy;
	//
	private Date updateDate;
	//删除标志（0=未删，1=已删）
	private String delFlag;

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
	 * 设置：数据模式。 1=行政区划，2=组织架构
	 */
	public void setDataMode(Integer dataMode) {
		this.dataMode = dataMode;
	}
	/**
	 * 获取：数据模式。 1=行政区划，2=组织架构
	 */
	public Integer getDataMode() {
		return dataMode;
	}
	/**
	 * 设置：如果权限模式为行政区划时，客户所选行政区域的根区域
	 */
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	/**
	 * 获取：如果权限模式为行政区划时，客户所选行政区域的根区域
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
	/**
	 * 设置：
	 */
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：
	 */
	public Long getCreateBy() {
		return createBy;
	}
	/**
	 * 设置：
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：
	 */
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
	/**
	 * 获取：
	 */
	public Long getUpdateBy() {
		return updateBy;
	}
	/**
	 * 设置：
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 设置：删除标志（0=未删，1=已删）
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取：删除标志（0=未删，1=已删）
	 */
	public String getDelFlag() {
		return delFlag;
	}
}
