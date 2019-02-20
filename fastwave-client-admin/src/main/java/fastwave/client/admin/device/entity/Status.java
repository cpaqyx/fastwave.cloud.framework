package fastwave.client.admin.device.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 设备状态，字典数据，无需后台配置
 * 
 * @author fastwave.developer
 * @date 2018-05-25 13:56:09
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//状态名称
	private String statusName;
	//排序，数字小在前
	private Integer orderId;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：状态名称
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	/**
	 * 获取：状态名称
	 */
	public String getStatusName() {
		return statusName;
	}
	/**
	 * 设置：排序，数字小在前
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：排序，数字小在前
	 */
	public Integer getOrderId() {
		return orderId;
	}
}
