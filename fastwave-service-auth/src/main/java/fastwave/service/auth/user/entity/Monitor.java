package fastwave.service.auth.user.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 监控中心
 * 
 * @author fastwave.developer
 * @date 
 */
public class Monitor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//用户ID
	private Long id;
	//所属客户
	private Long customerId;
	//监控中心名称
	private String monitorName;
	//监控中心地址
	private String monitorAddress;
	//父子包含编码，每级别3位。
	private String code;
	//父id
	private Long pid;
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
	 * 设置：用户ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：用户ID
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
	 * 设置：监控中心名称
	 */
	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}
	/**
	 * 获取：监控中心名称
	 */
	public String getMonitorName() {
		return monitorName;
	}
	/**
	 * 设置：监控中心地址
	 */
	public void setMonitorAddress(String monitorAddress) {
		this.monitorAddress = monitorAddress;
	}
	/**
	 * 获取：监控中心地址
	 */
	public String getMonitorAddress() {
		return monitorAddress;
	}
	/**
	 * 设置：父子包含编码，每级别3位。
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：父子包含编码，每级别3位。
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：父id
	 */
	public void setPid(Long pid) {
		this.pid = pid;
	}
	/**
	 * 获取：父id
	 */
	public Long getPid() {
		return pid;
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
