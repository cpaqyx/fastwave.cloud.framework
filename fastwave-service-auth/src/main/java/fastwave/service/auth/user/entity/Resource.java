package fastwave.service.auth.user.entity;

import java.io.Serializable;


/**
 * 功能资源表
 * 
 * @author fastwave.developer
 * @date
 */
public class Resource implements Serializable {
	private static final long serialVersionUID = 1L;

	//主键id
	private Long id;
	//名称
	private String resourceName;
	//资源路径
	private String resourceUrl;
	//父节点ID
	private Long pid;
	//图标
	private String iconCls;
	//类型，分为菜单和功能
	private String type;
	//排序
	private Integer seq;
	//菜单类别1=后台菜单，2=前台菜单，3=app菜单
	private Integer category;

	//超级管理员专用(0=否，1=是)，父子“菜单”节点间super_only必须相同
	private Integer superOnly;

	//客户管理员使用(0=否，1=是)
	private Integer adminUse;

	//监控中心用户使用(0=否，1=是)
	private Integer monitorUse;

	//单位用户使用(0=否，1=是)
	private Integer unitUse;

	/**
	 * 设置：主键id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：名称
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	/**
	 * 获取：名称
	 */
	public String getResourceName() {
		return resourceName;
	}
	/**
	 * 设置：资源路径
	 */
	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}
	/**
	 * 获取：资源路径
	 */
	public String getResourceUrl() {
		return resourceUrl;
	}
	/**
	 * 设置：父节点ID
	 */
	public void setPid(Long pid) {
		this.pid = pid;
	}
	/**
	 * 获取：父节点ID
	 */
	public Long getPid() {
		return pid;
	}
	/**
	 * 设置：图标
	 */
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	/**
	 * 获取：图标
	 */
	public String getIconCls() {
		return iconCls;
	}
	/**
	 * 设置：类型，分为菜单和功能
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型，分为菜单和功能
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：排序
	 */
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSeq() {
		return seq;
	}
	/**
	 * 设置：菜单类别1=后台菜单，2=前台菜单，3=app菜单
	 */
	public void setCategory(Integer category) {
		this.category = category;
	}
	/**
	 * 获取：菜单类别1=后台菜单，2=前台菜单，3=app菜单
	 */
	public Integer getCategory() {
		return category;
	}


	public Integer getSuperOnly() {
		return superOnly;
	}

	public void setSuperOnly(Integer superOnly) {
		this.superOnly = superOnly;
	}

	public Integer getAdminUse() {
		return adminUse;
	}

	public void setAdminUse(Integer adminUse) {
		this.adminUse = adminUse;
	}

	public Integer getMonitorUse() {
		return monitorUse;
	}

	public void setMonitorUse(Integer monitorUse) {
		this.monitorUse = monitorUse;
	}

	public Integer getUnitUse() {
		return unitUse;
	}

	public void setUnitUse(Integer unitUse) {
		this.unitUse = unitUse;
	}
}