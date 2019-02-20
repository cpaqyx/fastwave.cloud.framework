package fastwave.client.admin.unit.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author fastwave.developer
 * @date 2018-05-25 14:16:04
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class MiniStation implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//微型消防站
	private Long id;
	//微型消防站
	private String stationName;
	//所属单位id
	private Long unitId;
	//关联主要用户表id
	private Integer authUserId;
	//地址
	private String stationAddress;
	//备用字段
	private String remark;
	//所属客户
	private Long customerId;
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
	//水枪  单位：只
	private Integer waterGun;
	//水带  单位：条
	private Integer waterBelt;
	//灭火器   单位：个
	private Integer fireExtinguisher;
	//防护服   单位：双
	private Integer protectCloth;
	//消防头盔  单位：个
	private Integer fireHelmet;
	//防滑靴   单位：双
	private Integer protectBoots;
	//破拆工具
	private Integer breakTool;
	//微型消防车辆  单位：辆
	private Integer miniFireCar;

	/**
	 * 设置：微型消防站
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：微型消防站
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：微型消防站
	 */
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	/**
	 * 获取：微型消防站
	 */
	public String getStationName() {
		return stationName;
	}
	/**
	 * 设置：所属单位id
	 */
	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}
	/**
	 * 获取：所属单位id
	 */
	public Long getUnitId() {
		return unitId;
	}
	/**
	 * 设置：关联主要用户表id
	 */
	public void setAuthUserId(Integer authUserId) {
		this.authUserId = authUserId;
	}
	/**
	 * 获取：关联主要用户表id
	 */
	public Integer getAuthUserId() {
		return authUserId;
	}
	/**
	 * 设置：地址
	 */
	public void setStationAddress(String stationAddress) {
		this.stationAddress = stationAddress;
	}
	/**
	 * 获取：地址
	 */
	public String getStationAddress() {
		return stationAddress;
	}
	/**
	 * 设置：备用字段
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备用字段
	 */
	public String getRemark() {
		return remark;
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
	/**
	 * 设置：水枪  单位：只
	 */
	public void setWaterGun(Integer waterGun) {
		this.waterGun = waterGun;
	}
	/**
	 * 获取：水枪  单位：只
	 */
	public Integer getWaterGun() {
		return waterGun;
	}
	/**
	 * 设置：水带  单位：条
	 */
	public void setWaterBelt(Integer waterBelt) {
		this.waterBelt = waterBelt;
	}
	/**
	 * 获取：水带  单位：条
	 */
	public Integer getWaterBelt() {
		return waterBelt;
	}
	/**
	 * 设置：灭火器   单位：个
	 */
	public void setFireExtinguisher(Integer fireExtinguisher) {
		this.fireExtinguisher = fireExtinguisher;
	}
	/**
	 * 获取：灭火器   单位：个
	 */
	public Integer getFireExtinguisher() {
		return fireExtinguisher;
	}
	/**
	 * 设置：防护服   单位：双
	 */
	public void setProtectCloth(Integer protectCloth) {
		this.protectCloth = protectCloth;
	}
	/**
	 * 获取：防护服   单位：双
	 */
	public Integer getProtectCloth() {
		return protectCloth;
	}
	/**
	 * 设置：消防头盔  单位：个
	 */
	public void setFireHelmet(Integer fireHelmet) {
		this.fireHelmet = fireHelmet;
	}
	/**
	 * 获取：消防头盔  单位：个
	 */
	public Integer getFireHelmet() {
		return fireHelmet;
	}
	/**
	 * 设置：防滑靴   单位：双
	 */
	public void setProtectBoots(Integer protectBoots) {
		this.protectBoots = protectBoots;
	}
	/**
	 * 获取：防滑靴   单位：双
	 */
	public Integer getProtectBoots() {
		return protectBoots;
	}
	/**
	 * 设置：破拆工具
	 */
	public void setBreakTool(Integer breakTool) {
		this.breakTool = breakTool;
	}
	/**
	 * 获取：破拆工具
	 */
	public Integer getBreakTool() {
		return breakTool;
	}
	/**
	 * 设置：微型消防车辆  单位：辆
	 */
	public void setMiniFireCar(Integer miniFireCar) {
		this.miniFireCar = miniFireCar;
	}
	/**
	 * 获取：微型消防车辆  单位：辆
	 */
	public Integer getMiniFireCar() {
		return miniFireCar;
	}
}
