package fastwave.client.admin.video.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author fastwave.developer
 * @date 2018-06-19 16:10:31
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class Platform implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//平台名称
	private String platformName;
	//连接方式
	private String connectionMode;
	//ip地址
	private String ipAddress;
	//端口
	private Long port;
	//用户名
	private String userName;
	//用户密码
	private String userPaw;
	//删除标志（0=未删，1=已删）
	private String delFlag;
	//
	private Long createBy;
	//
	private Date createDate;
	//
	private Long updateBy;
	//
	private Date updateDate;

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
	 * 设置：平台名称
	 */
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	/**
	 * 获取：平台名称
	 */
	public String getPlatformName() {
		return platformName;
	}
	/**
	 * 设置：连接方式
	 */
	public void setConnectionMode(String connectionMode) {
		this.connectionMode = connectionMode;
	}
	/**
	 * 获取：连接方式
	 */
	public String getConnectionMode() {
		return connectionMode;
	}
	/**
	 * 设置：ip地址
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	/**
	 * 获取：ip地址
	 */
	public String getIpAddress() {
		return ipAddress;
	}
	/**
	 * 设置：端口
	 */
	public void setPort(Long port) {
		this.port = port;
	}
	/**
	 * 获取：端口
	 */
	public Long getPort() {
		return port;
	}
	/**
	 * 设置：用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：用户名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：用户密码
	 */
	public void setUserPaw(String userPaw) {
		this.userPaw = userPaw;
	}
	/**
	 * 获取：用户密码
	 */
	public String getUserPaw() {
		return userPaw;
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
}
