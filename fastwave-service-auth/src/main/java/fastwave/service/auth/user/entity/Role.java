package fastwave.service.auth.user.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 角色表
 * 
 * @author fastwave.developer
 * @date 
 */
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//所属客户
	private Long customerId;
	//角色名称
	private String roleName;
	//（0=不是，1=是）系统默认角色。超级管理员创建的角色system_default=1，所有客户都拥有这些角色
	private Integer systemDefault;
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
	 * 设置：角色名称
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * 获取：角色名称
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * 设置：（0=不是，1=是）系统默认角色。超级管理员创建的角色system_default=1，所有客户都拥有这些角色
	 */
	public void setSystemDefault(Integer systemDefault) {
		this.systemDefault = systemDefault;
	}
	/**
	 * 获取：（0=不是，1=是）系统默认角色。超级管理员创建的角色system_default=1，所有客户都拥有这些角色
	 */
	public Integer getSystemDefault() {
		return systemDefault;
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
