package fastwave.client.admin.device.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 设备生产商
 * 
 * @author fastwave.developer
 * @date 2018-05-24 12:09:00
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class Producer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//厂商ID
	private Long id;
	//生厂商名称
	private String producerName;
	//联系人
	private String contactPerson;
	//联系电话
	private String contactPhone;
	//地址
	private String producerAddress;
	//创建人
	private Long createBy;
	//创建时间
	private Date createDate;
	//修改人
	private Long updateBy;
	//修改时间
	private Date updateDate;
	//是否删除
	private String delFlag;

	/**
	 * 设置：厂商ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：厂商ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：生厂商名称
	 */
	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}
	/**
	 * 获取：生厂商名称
	 */
	public String getProducerName() {
		return producerName;
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
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getContactPhone() {
		return contactPhone;
	}
	/**
	 * 设置：地址
	 */
	public void setProducerAddress(String producerAddress) {
		this.producerAddress = producerAddress;
	}
	/**
	 * 获取：地址
	 */
	public String getProducerAddress() {
		return producerAddress;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：创建人
	 */
	public Long getCreateBy() {
		return createBy;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：修改人
	 */
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
	/**
	 * 获取：修改人
	 */
	public Long getUpdateBy() {
		return updateBy;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 设置：是否删除
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取：是否删除
	 */
	public String getDelFlag() {
		return delFlag;
	}
}
