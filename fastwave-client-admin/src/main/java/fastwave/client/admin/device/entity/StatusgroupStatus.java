package fastwave.client.admin.device.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 状态组包含的状态，字典数据，无需后台配置
 * 
 * @author fastwave.developer
 * @date 2018-05-25 13:56:09
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class StatusgroupStatus implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer deviceStatusgroupId;
	//
	private Integer deviceStatusId;

	/**
	 * 设置：
	 */
	public void setDeviceStatusgroupId(Integer deviceStatusgroupId) {
		this.deviceStatusgroupId = deviceStatusgroupId;
	}
	/**
	 * 获取：
	 */
	public Integer getDeviceStatusgroupId() {
		return deviceStatusgroupId;
	}
	/**
	 * 设置：
	 */
	public void setDeviceStatusId(Integer deviceStatusId) {
		this.deviceStatusId = deviceStatusId;
	}
	/**
	 * 获取：
	 */
	public Integer getDeviceStatusId() {
		return deviceStatusId;
	}
}
