package fastwave.client.admin.video.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author fastwave.developer
 * @date 2018-06-19 19:14:43
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class Equipment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//设备名称
	private String equipmentName;
	//设备类型
	private Long equipmentType;
	//设备编号
	private String equipmentCode;
	//所属平台id
	private Long belongToPlatformId;
	//所属单位id
	private Long unitId;
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
	 * 设置：设备名称
	 */
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	/**
	 * 获取：设备名称
	 */
	public String getEquipmentName() {
		return equipmentName;
	}
	/**
	 * 设置：设备类型
	 */
	public void setEquipmentType(Long equipmentType) {
		this.equipmentType = equipmentType;
	}
	/**
	 * 获取：设备类型
	 */
	public Long getEquipmentType() {
		return equipmentType;
	}
	/**
	 * 设置：设备编号
	 */
	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}
	/**
	 * 获取：设备编号
	 */
	public String getEquipmentCode() {
		return equipmentCode;
	}
	/**
	 * 设置：所属平台id
	 */
	public void setBelongToPlatformId(Long belongToPlatformId) {
		this.belongToPlatformId = belongToPlatformId;
	}
	/**
	 * 获取：所属平台id
	 */
	public Long getBelongToPlatformId() {
		return belongToPlatformId;
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
