package fastwave.client.admin.auth.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 数据组的组织
 * 
 * @author fastwave.developer
 * @date 2018-05-24 13:56:03
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class DatagroupOrg implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private Long datagroupId;
	//
	private Long orgId;
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
	public void setDatagroupId(Long datagroupId) {
		this.datagroupId = datagroupId;
	}
	/**
	 * 获取：
	 */
	public Long getDatagroupId() {
		return datagroupId;
	}
	/**
	 * 设置：
	 */
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	/**
	 * 获取：
	 */
	public Long getOrgId() {
		return orgId;
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
