package fastwave.lib.common.jwt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TokenModel {
	private String userName;
	private Long userId;
	private long customerId;
	private List<Long> roles;
	private List<Long> orgId;
	private int userType;
	private Long unitId;
	private String timestamp;
	private Long monitorId;
	private Long fireBrigadeId;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public List<Long> getRoles() {
		return roles;
	}
	public void setRoles(List<Long> roles) {
		this.roles = roles;
	}
	public List<Long> getOrgId() {
		return orgId;
	}
	public void setOrgId(List<Long> orgId) {
		this.orgId = orgId;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public Long getUnitId() {
		return unitId;
	}
	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public Long getMonitorId() {
		return monitorId;
	}
	public void setMonitorId(Long monitorId) {
		this.monitorId = monitorId;
	}
	public Long getFireBrigadeId() {
		return fireBrigadeId;
	}
	public void setFireBrigadeId(Long fireBrigadeId) {
		this.fireBrigadeId = fireBrigadeId;
	}
	
	
	
}
