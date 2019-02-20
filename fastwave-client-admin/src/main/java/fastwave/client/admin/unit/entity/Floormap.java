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
public class Floormap implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//楼层图管理
	private Integer id;
	//所属单位id
	private Integer unitId;
	//所属建筑物id
	private Integer buildingId;
	//楼栋楼层号码
	private Integer floorNumber;
	//立面图
	private String facadePicUrl;
	// 楼层平面图
	private String floorPicUrl;
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

	/**
	 * 设置：楼层图管理
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：楼层图管理
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：所属单位id
	 */
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	/**
	 * 获取：所属单位id
	 */
	public Integer getUnitId() {
		return unitId;
	}
	/**
	 * 设置：所属建筑物id
	 */
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}
	/**
	 * 获取：所属建筑物id
	 */
	public Integer getBuildingId() {
		return buildingId;
	}
	/**
	 * 设置：楼栋楼层号码
	 */
	public void setFloorNumber(Integer floorNumber) {
		this.floorNumber = floorNumber;
	}
	/**
	 * 获取：楼栋楼层号码
	 */
	public Integer getFloorNumber() {
		return floorNumber;
	}
	/**
	 * 设置：立面图
	 */
	public void setFacadePicUrl(String facadePicUrl) {
		this.facadePicUrl = facadePicUrl;
	}
	/**
	 * 获取：立面图
	 */
	public String getFacadePicUrl() {
		return facadePicUrl;
	}
	/**
	 * 设置： 楼层平面图
	 */
	public void setFloorPicUrl(String floorPicUrl) {
		this.floorPicUrl = floorPicUrl;
	}
	/**
	 * 获取： 楼层平面图
	 */
	public String getFloorPicUrl() {
		return floorPicUrl;
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
}
