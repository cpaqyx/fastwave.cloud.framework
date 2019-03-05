package fastwave.service.auth.user.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author fastwave.developer
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	// 用户ID
	private Long id;
	// 所属客户
	private Long customerId;
	// 用户昵称
	private String userName;
	// 用户名
	private String userAccount;
	// 用户密码
	private String userPassword;
	// 用户类型。 0=一般用户，1=分级管理员，2=内置超级管理员
	private Integer userType;
	// 监控中心用户所管监控中心
	private Long monitorId;
	// 用户邮箱
	private String userEmail;
	// 用户手机号
	private String userMobile;
	// 身份证号码
	private String userIdcard;
	// 图片url
	private String userPic;
	// 最后登录时间
	private Date lastLoginTime;
	// 用户状态，0=账户正常，1=已冻结
	private Integer userStatus;
	// 单位，仅作展示，不涉及数据权限
	private Long unitId;
	// 部门，仅作展示，不涉及数据权限
	private Long deptId;
	//
	private Long createBy;
	//
	private Date createDate;
	//
	private Long updateBy;
	//
	private Date updateDate;
	// 删除标志（0=未删，1=已删）
	private String delFlag;

	private String unitName;
	//消防大队id
	private Long fireBrigadeId;

	private String monitorName;
	
	private String unitcoordinate;
	
	private String monitorcoordinate;
	
	private String customerCoordinate;

	public String getCustomerCoordinate() {
		return customerCoordinate;
	}

	public void setCustomerCoordinate(String customerCoordinate) {
		this.customerCoordinate = customerCoordinate;
	}

	public String getUnitcoordinate() {
		return unitcoordinate;
	}

	public void setUnitcoordinate(String unitcoordinate) {
		this.unitcoordinate = unitcoordinate;
	}

	public String getMonitorcoordinate() {
		return monitorcoordinate;
	}

	public void setMonitorcoordinate(String monitorcoordinate) {
		this.monitorcoordinate = monitorcoordinate;
	}

	public String getMonitorName() {
		return monitorName;
	}

	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

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
	 * 设置：用户昵称
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获取：用户昵称
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置：用户名
	 */
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	/**
	 * 获取：用户名
	 */
	public String getUserAccount() {
		return userAccount;
	}

	/**
	 * 设置：用户密码
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * 获取：用户密码
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * 设置：用户类型 0=一般用户，1=分级管理员，2=内置超级管理员
	 */
	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	/**
	 * 获取：用户类型。 0=一般用户，1=分级管理员，2=内置超级管理员
	 */
	public Integer getUserType() {
		return userType;
	}

	/**
	 * 设置：用户邮箱
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * 获取：用户邮箱
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * 设置：用户手机号
	 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	/**
	 * 获取：用户手机号
	 */
	public String getUserMobile() {
		return userMobile;
	}

	/**
	 * 设置：身份证号码
	 */
	public void setUserIdcard(String userIdcard) {
		this.userIdcard = userIdcard;
	}

	/**
	 * 获取：身份证号码
	 */
	public String getUserIdcard() {
		return userIdcard;
	}

	/**
	 * 设置：图片url
	 */
	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	/**
	 * 获取：图片url
	 */
	public String getUserPic() {
		return userPic;
	}

	/**
	 * 设置：最后登录时间
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * 获取：最后登录时间
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * 设置：用户状态，0=账户正常，1=已冻结
	 */
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	/**
	 * 获取：用户状态，0=账户正常，1=已冻结
	 */
	public Integer getUserStatus() {
		return userStatus;
	}

	/**
	 * 设置：部门，仅作展示，不涉及数据权限
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	/**
	 * 获取：部门，仅作展示，不涉及数据权限
	 */
	public Long getDeptId() {
		return deptId;
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

	public Long getMonitorId() {
		return monitorId;
	}

	public void setMonitorId(Long monitorId) {
		this.monitorId = monitorId;
	}
	public Long getFireBrigadeId() {
		return fireBrigadeId;
	}
	public void setFireBrigadeId(Long fireBrigadeId) {
		this.fireBrigadeId = fireBrigadeId;
	}
	
}
