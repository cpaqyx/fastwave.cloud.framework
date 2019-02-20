package fastwave.client.admin.auth.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 客户组织架构
 * 
 * @author fastwave.developer
 * @date 2018-05-23 15:45:45
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class Org implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//所属客户
	private Long customerId;
	//组织名称
	private String orgName;
	//组织编码（自动生成，内部使用）
	private String orgCode;
	//
	private Long pid;
	//数据模式。 1=行政区划，2=组织架构。 data_mode=1时不允许删除
	private Integer dataMode;
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
	//记录行政区域树转换前的编号
	private Long transferCode;
	//实际层数，根节点为1
	private Integer deepLevel;

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
	 * 设置：所属客户
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	/**
	 * 获取：所属客户
	 */
	public Long getCustomerId() {
		return customerId;
	}
	/**
	 * 设置：组织名称
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	/**
	 * 获取：组织名称
	 */
	public String getOrgName() {
		return orgName;
	}
	/**
	 * 设置：组织编码（自动生成，内部使用）
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	/**
	 * 获取：组织编码（自动生成，内部使用）
	 */
	public String getOrgCode() {
		return orgCode;
	}
	/**
	 * 设置：
	 */
	public void setPid(Long pid) {
		this.pid = pid;
	}
	/**
	 * 获取：
	 */
	public Long getPid() {
		return pid;
	}
	/**
	 * 设置：数据模式。 1=行政区划，2=组织架构。 data_mode=1时不允许删除
	 */
	public void setDataMode(Integer dataMode) {
		this.dataMode = dataMode;
	}
	/**
	 * 获取：数据模式。 1=行政区划，2=组织架构。 data_mode=1时不允许删除
	 */
	public Integer getDataMode() {
		return dataMode;
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
	/**
	 * 设置：记录行政区域树转换前的编号
	 */
	public void setTransferCode(Long transferCode) {
		this.transferCode = transferCode;
	}
	/**
	 * 获取：记录行政区域树转换前的编号
	 */
	public Long getTransferCode() {
		return transferCode;
	}
	/**
	 * 设置：实际层数，根节点为1
	 */
	public void setDeepLevel(Integer deepLevel) {
		this.deepLevel = deepLevel;
	}
	/**
	 * 获取：实际层数，根节点为1
	 */
	public Integer getDeepLevel() {
		return deepLevel;
	}
}
