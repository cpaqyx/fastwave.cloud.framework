package fastwave.client.admin.device.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 设备信息
 * 
 * @author fastwave.developer
 * @date 2018-05-25 14:32:21
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//所属客户
	private Long customerId;
	//所属单位
	private Long unitId;
	//所属类型系统
	private Long deviceTypegroupId;
	//
	private Long deviceTypeId;
	//设备编码（自动生成，内部使用）
	private String deviceCode;
	//设备名称 -----------以此开始为公有属性-----------
	private String deviceName;
	//系统地址
	private String systemAddress;
	//设备状态
	private Long deviceStatus;
	//连接方式  [TCP, UDP, HTTP]
	private String connectMode;
	//负责人，关联user表
	private Long manageUserId;
	//生产商
	private Long producerId;
	//生成日期
	private Date productDate;
	//投运日期
	private Date useDate;
	//使用年限
	private String expiredLimit;
	//建筑物
	private Long buildingId;
	//楼层
	private Long floorId;
	//设备协议类型 [国标，自有协议]
	private String protocolType;
	//地址
	private String deviceAddress;
	//硬件版本
	private String hardwareVersion;
	//软件版本-----------公有属性结束-----------
	private String softwareVersion;
	//设备编号-----------以此开始为私有属性-----------
	private String deviceNumber;
	//父设备
	private Long pid;
	//父设备SN编号
	private String fatherSn;
	//探测器通道号
	private String detectorChannel;
	//部件单元回路号
	private String unitLoop;
	//下限告警值
	private String warnLowLimit;
	//上限告警值
	private String warnHighLimit;
	//消控室
	private Long fireControlRoomId;
	//防火分区
	private String firePreventionDivision;
	//2路8路-----------私有属性结束-----------
	private String roadNumber;
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
	 * 设置：所属单位
	 */
	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}
	/**
	 * 获取：所属单位
	 */
	public Long getUnitId() {
		return unitId;
	}
	/**
	 * 设置：所属类型系统
	 */
	public void setDeviceTypegroupId(Long deviceTypegroupId) {
		this.deviceTypegroupId = deviceTypegroupId;
	}
	/**
	 * 获取：所属类型系统
	 */
	public Long getDeviceTypegroupId() {
		return deviceTypegroupId;
	}
	/**
	 * 设置：
	 */
	public void setDeviceTypeId(Long deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}
	/**
	 * 获取：
	 */
	public Long getDeviceTypeId() {
		return deviceTypeId;
	}
	/**
	 * 设置：设备编码（自动生成，内部使用）
	 */
	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}
	/**
	 * 获取：设备编码（自动生成，内部使用）
	 */
	public String getDeviceCode() {
		return deviceCode;
	}
	/**
	 * 设置：设备名称 -----------以此开始为公有属性-----------
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	/**
	 * 获取：设备名称 -----------以此开始为公有属性-----------
	 */
	public String getDeviceName() {
		return deviceName;
	}
	/**
	 * 设置：系统地址
	 */
	public void setSystemAddress(String systemAddress) {
		this.systemAddress = systemAddress;
	}
	/**
	 * 获取：系统地址
	 */
	public String getSystemAddress() {
		return systemAddress;
	}
	/**
	 * 设置：设备状态
	 */
	public void setDeviceStatus(Long deviceStatus) {
		this.deviceStatus = deviceStatus;
	}
	/**
	 * 获取：设备状态
	 */
	public Long getDeviceStatus() {
		return deviceStatus;
	}
	/**
	 * 设置：连接方式  [TCP, UDP, HTTP]
	 */
	public void setConnectMode(String connectMode) {
		this.connectMode = connectMode;
	}
	/**
	 * 获取：连接方式  [TCP, UDP, HTTP]
	 */
	public String getConnectMode() {
		return connectMode;
	}
	/**
	 * 设置：负责人，关联user表
	 */
	public void setManageUserId(Long manageUserId) {
		this.manageUserId = manageUserId;
	}
	/**
	 * 获取：负责人，关联user表
	 */
	public Long getManageUserId() {
		return manageUserId;
	}
	/**
	 * 设置：生产商
	 */
	public void setProducerId(Long producerId) {
		this.producerId = producerId;
	}
	/**
	 * 获取：生产商
	 */
	public Long getProducerId() {
		return producerId;
	}
	/**
	 * 设置：生成日期
	 */
	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}
	/**
	 * 获取：生成日期
	 */
	public Date getProductDate() {
		return productDate;
	}
	/**
	 * 设置：投运日期
	 */
	public void setUseDate(Date useDate) {
		this.useDate = useDate;
	}
	/**
	 * 获取：投运日期
	 */
	public Date getUseDate() {
		return useDate;
	}
	/**
	 * 设置：使用年限
	 */
	public void setExpiredLimit(String expiredLimit) {
		this.expiredLimit = expiredLimit;
	}
	/**
	 * 获取：使用年限
	 */
	public String getExpiredLimit() {
		return expiredLimit;
	}
	/**
	 * 设置：建筑物
	 */
	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}
	/**
	 * 获取：建筑物
	 */
	public Long getBuildingId() {
		return buildingId;
	}
	/**
	 * 设置：楼层
	 */
	public void setFloorId(Long floorId) {
		this.floorId = floorId;
	}
	/**
	 * 获取：楼层
	 */
	public Long getFloorId() {
		return floorId;
	}
	/**
	 * 设置：设备协议类型 [国标，自有协议]
	 */
	public void setProtocolType(String protocolType) {
		this.protocolType = protocolType;
	}
	/**
	 * 获取：设备协议类型 [国标，自有协议]
	 */
	public String getProtocolType() {
		return protocolType;
	}
	/**
	 * 设置：地址
	 */
	public void setDeviceAddress(String deviceAddress) {
		this.deviceAddress = deviceAddress;
	}
	/**
	 * 获取：地址
	 */
	public String getDeviceAddress() {
		return deviceAddress;
	}
	/**
	 * 设置：硬件版本
	 */
	public void setHardwareVersion(String hardwareVersion) {
		this.hardwareVersion = hardwareVersion;
	}
	/**
	 * 获取：硬件版本
	 */
	public String getHardwareVersion() {
		return hardwareVersion;
	}
	/**
	 * 设置：软件版本-----------公有属性结束-----------
	 */
	public void setSoftwareVersion(String softwareVersion) {
		this.softwareVersion = softwareVersion;
	}
	/**
	 * 获取：软件版本-----------公有属性结束-----------
	 */
	public String getSoftwareVersion() {
		return softwareVersion;
	}
	/**
	 * 设置：设备编号-----------以此开始为私有属性-----------
	 */
	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}
	/**
	 * 获取：设备编号-----------以此开始为私有属性-----------
	 */
	public String getDeviceNumber() {
		return deviceNumber;
	}
	/**
	 * 设置：父设备
	 */
	public void setPid(Long pid) {
		this.pid = pid;
	}
	/**
	 * 获取：父设备
	 */
	public Long getPid() {
		return pid;
	}
	/**
	 * 设置：父设备SN编号
	 */
	public void setFatherSn(String fatherSn) {
		this.fatherSn = fatherSn;
	}
	/**
	 * 获取：父设备SN编号
	 */
	public String getFatherSn() {
		return fatherSn;
	}
	/**
	 * 设置：探测器通道号
	 */
	public void setDetectorChannel(String detectorChannel) {
		this.detectorChannel = detectorChannel;
	}
	/**
	 * 获取：探测器通道号
	 */
	public String getDetectorChannel() {
		return detectorChannel;
	}
	/**
	 * 设置：部件单元回路号
	 */
	public void setUnitLoop(String unitLoop) {
		this.unitLoop = unitLoop;
	}
	/**
	 * 获取：部件单元回路号
	 */
	public String getUnitLoop() {
		return unitLoop;
	}
	/**
	 * 设置：下限告警值
	 */
	public void setWarnLowLimit(String warnLowLimit) {
		this.warnLowLimit = warnLowLimit;
	}
	/**
	 * 获取：下限告警值
	 */
	public String getWarnLowLimit() {
		return warnLowLimit;
	}
	/**
	 * 设置：上限告警值
	 */
	public void setWarnHighLimit(String warnHighLimit) {
		this.warnHighLimit = warnHighLimit;
	}
	/**
	 * 获取：上限告警值
	 */
	public String getWarnHighLimit() {
		return warnHighLimit;
	}
	/**
	 * 设置：消控室
	 */
	public void setFireControlRoomId(Long fireControlRoomId) {
		this.fireControlRoomId = fireControlRoomId;
	}
	/**
	 * 获取：消控室
	 */
	public Long getFireControlRoomId() {
		return fireControlRoomId;
	}
	/**
	 * 设置：防火分区
	 */
	public void setFirePreventionDivision(String firePreventionDivision) {
		this.firePreventionDivision = firePreventionDivision;
	}
	/**
	 * 获取：防火分区
	 */
	public String getFirePreventionDivision() {
		return firePreventionDivision;
	}
	/**
	 * 设置：2路8路-----------私有属性结束-----------
	 */
	public void setRoadNumber(String roadNumber) {
		this.roadNumber = roadNumber;
	}
	/**
	 * 获取：2路8路-----------私有属性结束-----------
	 */
	public String getRoadNumber() {
		return roadNumber;
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
