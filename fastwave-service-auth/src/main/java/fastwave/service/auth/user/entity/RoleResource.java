package fastwave.service.auth.user.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author fastwave.developer
 * @date 
 */
public class RoleResource implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private Long roleId;
	//
	private Long resourceId;
	//
	private Long createBy;
	//
	private Date createDate;

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
	 * 设置：
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：
	 */
	public Long getRoleId() {
		return roleId;
	}
	/**
	 * 设置：
	 */
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
	/**
	 * 获取：
	 */
	public Long getResourceId() {
		return resourceId;
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
}
