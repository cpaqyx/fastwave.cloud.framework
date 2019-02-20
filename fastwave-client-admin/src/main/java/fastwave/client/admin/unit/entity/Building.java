package fastwave.client.admin.unit.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author fastwave.developer
 * @date 2018-05-29 09:43:01
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class Building implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//建筑物管理
	private Long id;
	//建筑物名称
	private String buildName;
	//建筑物地址
	private String buildAddress;
	//建筑物所属单位id   关联单位表，用选择框
	private Long unitId;
	//建筑长（楼长）  关联人员表，对应负责人，用选择框。
	private Long buildHead;
	//建筑物类别
	private String buildSpace;
	//建造日期  表示方法：YYYYDDMM
	private Date buildDate;
	//使用性质  见 GA/T 396—2002 表 A. 11
	private String useCharacter;
	//
	private String fireRisk;
	//耐火等级   见 GA/T 396—2002 表 A. 10
	private String fireResistanceRating;
	//结构类型   见 GA/T 396—2002 表 A. 9 
	private String structureType;
	//建筑高度  单位:m，精确到小数点后2位
	private Double buildHeight;
	//建筑面积  单位：㎡
	private Double buildAcerage;
	//占地面积  单位：㎡
	private Double areaCovered;
	//标准层面积   单位：㎡
	private Double standardLayerArea;
	//地上层数
	private Integer numberOfFloors;
	//地上层面积  单位：㎡
	private Double numberOfFloorsArea;
	//地上层数
	private Integer undergroundStoreys;
	//地下层面积  单位：㎡
	private Double undergroundStoreysArea;
	//隧道高度   单位:m，精确到小数点后2位
	private Double tunnelHeight;
	//隧道长度    单位：m，精确到小数点后2位
	private Double tunnelLength;
	//消防控制室位置
	private String controlRommPosition;
	//避难层数量
	private Integer refugeFloorNumber;
	//避难层总面积  单位：㎡
	private Double refugeFloorTotalArea;
	//避难层位置
	private String refugeFloorPosition;
	//安全出口数量
	private Integer safeExitNumber;
	//安全出口位置
	private String safeExitPosition;
	//安全出口形式
	private String safeExitForm;
	//消防电梯数量
	private Integer liftNumber;
	//消防电梯容纳总重量  单位：kg
	private Double liftTotalWeight;
	//日常工作时间人数
	private Integer dailyWorkingHours;
	//最大容纳人数
	private Integer maxNumber;
	//储存物名称
	private String storageName;
	//储存物数量
	private Integer storageNumber;
	//储存物性质
	private String storageNature;
	//储存物形态
	private String storageForm;
	//储存容积    单位：m³
	private Double storageVolume;
	//主要原料
	private String mainMaterials;
	//主要产品
	private String mainProduct;
	//毗邻建筑物情况   毗邻建筑物的使用性质、结构类型、建筑高度、与本建筑物的间距等信息
	private String adjacentBuildings;
	//地图默认中心    勾选，可在首页与实时监测里看到相应定位信息
	private Integer mapDefaultCenter;
	//是否有夹层    是否存在隔层、夹层。如有，勾选，后面输入层数
	private Integer isSandwich;
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

	/**
	 * 设置：建筑物管理
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：建筑物管理
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：建筑物名称
	 */
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	/**
	 * 获取：建筑物名称
	 */
	public String getBuildName() {
		return buildName;
	}
	/**
	 * 设置：建筑物地址
	 */
	public void setBuildAddress(String buildAddress) {
		this.buildAddress = buildAddress;
	}
	/**
	 * 获取：建筑物地址
	 */
	public String getBuildAddress() {
		return buildAddress;
	}
	/**
	 * 设置：建筑物所属单位id   关联单位表，用选择框
	 */
	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}
	/**
	 * 获取：建筑物所属单位id   关联单位表，用选择框
	 */
	public Long getUnitId() {
		return unitId;
	}
	/**
	 * 设置：建筑长（楼长）  关联人员表，对应负责人，用选择框。
	 */
	public void setBuildHead(Long buildHead) {
		this.buildHead = buildHead;
	}
	/**
	 * 获取：建筑长（楼长）  关联人员表，对应负责人，用选择框。
	 */
	public Long getBuildHead() {
		return buildHead;
	}
	/**
	 * 设置：建筑物类别
	 */
	public void setBuildSpace(String buildSpace) {
		this.buildSpace = buildSpace;
	}
	/**
	 * 获取：建筑物类别
	 */
	public String getBuildSpace() {
		return buildSpace;
	}
	/**
	 * 设置：建造日期  表示方法：YYYYDDMM
	 */
	public void setBuildDate(Date buildDate) {
		this.buildDate = buildDate;
	}
	/**
	 * 获取：建造日期  表示方法：YYYYDDMM
	 */
	public Date getBuildDate() {
		return buildDate;
	}
	/**
	 * 设置：使用性质  见 GA/T 396—2002 表 A. 11
	 */
	public void setUseCharacter(String useCharacter) {
		this.useCharacter = useCharacter;
	}
	/**
	 * 获取：使用性质  见 GA/T 396—2002 表 A. 11
	 */
	public String getUseCharacter() {
		return useCharacter;
	}
	/**
	 * 设置：
	 */
	public void setFireRisk(String fireRisk) {
		this.fireRisk = fireRisk;
	}
	/**
	 * 获取：
	 */
	public String getFireRisk() {
		return fireRisk;
	}
	/**
	 * 设置：耐火等级   见 GA/T 396—2002 表 A. 10
	 */
	public void setFireResistanceRating(String fireResistanceRating) {
		this.fireResistanceRating = fireResistanceRating;
	}
	/**
	 * 获取：耐火等级   见 GA/T 396—2002 表 A. 10
	 */
	public String getFireResistanceRating() {
		return fireResistanceRating;
	}
	/**
	 * 设置：结构类型   见 GA/T 396—2002 表 A. 9 
	 */
	public void setStructureType(String structureType) {
		this.structureType = structureType;
	}
	/**
	 * 获取：结构类型   见 GA/T 396—2002 表 A. 9 
	 */
	public String getStructureType() {
		return structureType;
	}
	/**
	 * 设置：建筑高度  单位:m，精确到小数点后2位
	 */
	public void setBuildHeight(Double buildHeight) {
		this.buildHeight = buildHeight;
	}
	/**
	 * 获取：建筑高度  单位:m，精确到小数点后2位
	 */
	public Double getBuildHeight() {
		return buildHeight;
	}
	/**
	 * 设置：建筑面积  单位：㎡
	 */
	public void setBuildAcerage(Double buildAcerage) {
		this.buildAcerage = buildAcerage;
	}
	/**
	 * 获取：建筑面积  单位：㎡
	 */
	public Double getBuildAcerage() {
		return buildAcerage;
	}
	/**
	 * 设置：占地面积  单位：㎡
	 */
	public void setAreaCovered(Double areaCovered) {
		this.areaCovered = areaCovered;
	}
	/**
	 * 获取：占地面积  单位：㎡
	 */
	public Double getAreaCovered() {
		return areaCovered;
	}
	/**
	 * 设置：标准层面积   单位：㎡
	 */
	public void setStandardLayerArea(Double standardLayerArea) {
		this.standardLayerArea = standardLayerArea;
	}
	/**
	 * 获取：标准层面积   单位：㎡
	 */
	public Double getStandardLayerArea() {
		return standardLayerArea;
	}
	/**
	 * 设置：地上层数
	 */
	public void setNumberOfFloors(Integer numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}
	/**
	 * 获取：地上层数
	 */
	public Integer getNumberOfFloors() {
		return numberOfFloors;
	}
	/**
	 * 设置：地上层面积  单位：㎡
	 */
	public void setNumberOfFloorsArea(Double numberOfFloorsArea) {
		this.numberOfFloorsArea = numberOfFloorsArea;
	}
	/**
	 * 获取：地上层面积  单位：㎡
	 */
	public Double getNumberOfFloorsArea() {
		return numberOfFloorsArea;
	}
	/**
	 * 设置：地上层数
	 */
	public void setUndergroundStoreys(Integer undergroundStoreys) {
		this.undergroundStoreys = undergroundStoreys;
	}
	/**
	 * 获取：地上层数
	 */
	public Integer getUndergroundStoreys() {
		return undergroundStoreys;
	}
	/**
	 * 设置：地下层面积  单位：㎡
	 */
	public void setUndergroundStoreysArea(Double undergroundStoreysArea) {
		this.undergroundStoreysArea = undergroundStoreysArea;
	}
	/**
	 * 获取：地下层面积  单位：㎡
	 */
	public Double getUndergroundStoreysArea() {
		return undergroundStoreysArea;
	}
	/**
	 * 设置：隧道高度   单位:m，精确到小数点后2位
	 */
	public void setTunnelHeight(Double tunnelHeight) {
		this.tunnelHeight = tunnelHeight;
	}
	/**
	 * 获取：隧道高度   单位:m，精确到小数点后2位
	 */
	public Double getTunnelHeight() {
		return tunnelHeight;
	}
	/**
	 * 设置：隧道长度    单位：m，精确到小数点后2位
	 */
	public void setTunnelLength(Double tunnelLength) {
		this.tunnelLength = tunnelLength;
	}
	/**
	 * 获取：隧道长度    单位：m，精确到小数点后2位
	 */
	public Double getTunnelLength() {
		return tunnelLength;
	}
	/**
	 * 设置：消防控制室位置
	 */
	public void setControlRommPosition(String controlRommPosition) {
		this.controlRommPosition = controlRommPosition;
	}
	/**
	 * 获取：消防控制室位置
	 */
	public String getControlRommPosition() {
		return controlRommPosition;
	}
	/**
	 * 设置：避难层数量
	 */
	public void setRefugeFloorNumber(Integer refugeFloorNumber) {
		this.refugeFloorNumber = refugeFloorNumber;
	}
	/**
	 * 获取：避难层数量
	 */
	public Integer getRefugeFloorNumber() {
		return refugeFloorNumber;
	}
	/**
	 * 设置：避难层总面积  单位：㎡
	 */
	public void setRefugeFloorTotalArea(Double refugeFloorTotalArea) {
		this.refugeFloorTotalArea = refugeFloorTotalArea;
	}
	/**
	 * 获取：避难层总面积  单位：㎡
	 */
	public Double getRefugeFloorTotalArea() {
		return refugeFloorTotalArea;
	}
	/**
	 * 设置：避难层位置
	 */
	public void setRefugeFloorPosition(String refugeFloorPosition) {
		this.refugeFloorPosition = refugeFloorPosition;
	}
	/**
	 * 获取：避难层位置
	 */
	public String getRefugeFloorPosition() {
		return refugeFloorPosition;
	}
	/**
	 * 设置：安全出口数量
	 */
	public void setSafeExitNumber(Integer safeExitNumber) {
		this.safeExitNumber = safeExitNumber;
	}
	/**
	 * 获取：安全出口数量
	 */
	public Integer getSafeExitNumber() {
		return safeExitNumber;
	}
	/**
	 * 设置：安全出口位置
	 */
	public void setSafeExitPosition(String safeExitPosition) {
		this.safeExitPosition = safeExitPosition;
	}
	/**
	 * 获取：安全出口位置
	 */
	public String getSafeExitPosition() {
		return safeExitPosition;
	}
	/**
	 * 设置：安全出口形式
	 */
	public void setSafeExitForm(String safeExitForm) {
		this.safeExitForm = safeExitForm;
	}
	/**
	 * 获取：安全出口形式
	 */
	public String getSafeExitForm() {
		return safeExitForm;
	}
	/**
	 * 设置：消防电梯数量
	 */
	public void setLiftNumber(Integer liftNumber) {
		this.liftNumber = liftNumber;
	}
	/**
	 * 获取：消防电梯数量
	 */
	public Integer getLiftNumber() {
		return liftNumber;
	}
	/**
	 * 设置：消防电梯容纳总重量  单位：kg
	 */
	public void setLiftTotalWeight(Double liftTotalWeight) {
		this.liftTotalWeight = liftTotalWeight;
	}
	/**
	 * 获取：消防电梯容纳总重量  单位：kg
	 */
	public Double getLiftTotalWeight() {
		return liftTotalWeight;
	}
	/**
	 * 设置：日常工作时间人数
	 */
	public void setDailyWorkingHours(Integer dailyWorkingHours) {
		this.dailyWorkingHours = dailyWorkingHours;
	}
	/**
	 * 获取：日常工作时间人数
	 */
	public Integer getDailyWorkingHours() {
		return dailyWorkingHours;
	}
	/**
	 * 设置：最大容纳人数
	 */
	public void setMaxNumber(Integer maxNumber) {
		this.maxNumber = maxNumber;
	}
	/**
	 * 获取：最大容纳人数
	 */
	public Integer getMaxNumber() {
		return maxNumber;
	}
	/**
	 * 设置：储存物名称
	 */
	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}
	/**
	 * 获取：储存物名称
	 */
	public String getStorageName() {
		return storageName;
	}
	/**
	 * 设置：储存物数量
	 */
	public void setStorageNumber(Integer storageNumber) {
		this.storageNumber = storageNumber;
	}
	/**
	 * 获取：储存物数量
	 */
	public Integer getStorageNumber() {
		return storageNumber;
	}
	/**
	 * 设置：储存物性质
	 */
	public void setStorageNature(String storageNature) {
		this.storageNature = storageNature;
	}
	/**
	 * 获取：储存物性质
	 */
	public String getStorageNature() {
		return storageNature;
	}
	/**
	 * 设置：储存物形态
	 */
	public void setStorageForm(String storageForm) {
		this.storageForm = storageForm;
	}
	/**
	 * 获取：储存物形态
	 */
	public String getStorageForm() {
		return storageForm;
	}
	/**
	 * 设置：储存容积    单位：m³
	 */
	public void setStorageVolume(Double storageVolume) {
		this.storageVolume = storageVolume;
	}
	/**
	 * 获取：储存容积    单位：m³
	 */
	public Double getStorageVolume() {
		return storageVolume;
	}
	/**
	 * 设置：主要原料
	 */
	public void setMainMaterials(String mainMaterials) {
		this.mainMaterials = mainMaterials;
	}
	/**
	 * 获取：主要原料
	 */
	public String getMainMaterials() {
		return mainMaterials;
	}
	/**
	 * 设置：主要产品
	 */
	public void setMainProduct(String mainProduct) {
		this.mainProduct = mainProduct;
	}
	/**
	 * 获取：主要产品
	 */
	public String getMainProduct() {
		return mainProduct;
	}
	/**
	 * 设置：毗邻建筑物情况   毗邻建筑物的使用性质、结构类型、建筑高度、与本建筑物的间距等信息
	 */
	public void setAdjacentBuildings(String adjacentBuildings) {
		this.adjacentBuildings = adjacentBuildings;
	}
	/**
	 * 获取：毗邻建筑物情况   毗邻建筑物的使用性质、结构类型、建筑高度、与本建筑物的间距等信息
	 */
	public String getAdjacentBuildings() {
		return adjacentBuildings;
	}
	/**
	 * 设置：地图默认中心    勾选，可在首页与实时监测里看到相应定位信息
	 */
	public void setMapDefaultCenter(Integer mapDefaultCenter) {
		this.mapDefaultCenter = mapDefaultCenter;
	}
	/**
	 * 获取：地图默认中心    勾选，可在首页与实时监测里看到相应定位信息
	 */
	public Integer getMapDefaultCenter() {
		return mapDefaultCenter;
	}
	/**
	 * 设置：是否有夹层    是否存在隔层、夹层。如有，勾选，后面输入层数
	 */
	public void setIsSandwich(Integer isSandwich) {
		this.isSandwich = isSandwich;
	}
	/**
	 * 获取：是否有夹层    是否存在隔层、夹层。如有，勾选，后面输入层数
	 */
	public Integer getIsSandwich() {
		return isSandwich;
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
}
