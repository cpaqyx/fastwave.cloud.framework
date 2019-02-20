package fastwave.client.admin.device.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 设备类型
 * 
 * @author fastwave.developer
 * @date 2018-05-25 16:31:04
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class Type implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//设备类型名称
	private String deviceTypeName;
	//所属类型组
	private Long deviceTypegroupId;
	//设备状态组
	private Integer deviceStatusgroupId;
	//下限告警值单位
	private String warnLowLimitUnit;
	//上限告警值单位
	private String warnHighLimitUnit;
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
	 * 设置：设备类型名称
	 */
	public void setDeviceTypeName(String deviceTypeName) {
		this.deviceTypeName = deviceTypeName;
	}
	/**
	 * 获取：设备类型名称
	 */
	public String getDeviceTypeName() {
		return deviceTypeName;
	}
	/**
	 * 设置：所属类型组
	 */
	public void setDeviceTypegroupId(Long deviceTypegroupId) {
		this.deviceTypegroupId = deviceTypegroupId;
	}
	/**
	 * 获取：所属类型组
	 */
	public Long getDeviceTypegroupId() {
		return deviceTypegroupId;
	}
	/**
	 * 设置：设备状态组
	 */
	public void setDeviceStatusgroupId(Integer deviceStatusgroupId) {
		this.deviceStatusgroupId = deviceStatusgroupId;
	}
	/**
	 * 获取：设备状态组
	 */
	public Integer getDeviceStatusgroupId() {
		return deviceStatusgroupId;
	}
	/**
	 * 设置：下限告警值单位
	 */
	public void setWarnLowLimitUnit(String warnLowLimitUnit) {
		this.warnLowLimitUnit = warnLowLimitUnit;
	}
	/**
	 * 获取：下限告警值单位
	 */
	public String getWarnLowLimitUnit() {
		return warnLowLimitUnit;
	}
	/**
	 * 设置：上限告警值单位
	 */
	public void setWarnHighLimitUnit(String warnHighLimitUnit) {
		this.warnHighLimitUnit = warnHighLimitUnit;
	}
	/**
	 * 获取：上限告警值单位
	 */
	public String getWarnHighLimitUnit() {
		return warnHighLimitUnit;
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
