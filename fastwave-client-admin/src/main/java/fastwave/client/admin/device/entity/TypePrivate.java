package fastwave.client.admin.device.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 设备类型私有属性
 * 
 * @author fastwave.developer
 * @date 2018-05-25 16:31:04
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class TypePrivate implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//设备类型
	private Long deviceTypeId;
	//私有属性，值与device表的私有属性字段名称相同
	private String propertyName;

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
	 * 设置：设备类型
	 */
	public void setDeviceTypeId(Long deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}
	/**
	 * 获取：设备类型
	 */
	public Long getDeviceTypeId() {
		return deviceTypeId;
	}
	/**
	 * 设置：私有属性，值与device表的私有属性字段名称相同
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	/**
	 * 获取：私有属性，值与device表的私有属性字段名称相同
	 */
	public String getPropertyName() {
		return propertyName;
	}
}
