package fastwave.client.admin.config.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 行政区域，包含省／市／区县／乡镇街道四级
 * 
 * @author fastwave.developer
 * @date 2018-05-23 09:33:30
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class District implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//区域名称
	private String districtName;
	//区域编码（内部使用，包含下级设计）
	private String districtCode;
	//
	private Long pid;
	//国标编码，备用
	private String gbCode;
	//1=省，2=市，3=区县，4=乡镇街道
	private Integer level;
	//实际层数，根节点为1
	private Integer deepLevel;

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
	 * 设置：区域名称
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	/**
	 * 获取：区域名称
	 */
	public String getDistrictName() {
		return districtName;
	}
	/**
	 * 设置：区域编码（内部使用，包含下级设计）
	 */
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	/**
	 * 获取：区域编码（内部使用，包含下级设计）
	 */
	public String getDistrictCode() {
		return districtCode;
	}
	/**
	 * 设置：
	 */
	public void setPid(Long pid) {
		this.pid = pid;
	}
	/**
	 * 获取：
	 */
	public Long getPid() {
		return pid;
	}
	/**
	 * 设置：国标编码，备用
	 */
	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}
	/**
	 * 获取：国标编码，备用
	 */
	public String getGbCode() {
		return gbCode;
	}
	/**
	 * 设置：1=省，2=市，3=区县，4=乡镇街道
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 获取：1=省，2=市，3=区县，4=乡镇街道
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * 设置：实际层数，根节点为1
	 */
	public void setDeepLevel(Integer deepLevel) {
		this.deepLevel = deepLevel;
	}
	/**
	 * 获取：实际层数，根节点为1
	 */
	public Integer getDeepLevel() {
		return deepLevel;
	}
}
