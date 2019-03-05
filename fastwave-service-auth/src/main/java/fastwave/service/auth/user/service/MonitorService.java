package fastwave.service.auth.user.service;


import java.util.List;
import java.util.Map;

import fastwave.service.auth.user.entity.Monitor;
import fastwave.service.auth.user.entity.Org;

/**
 * 监控中心
 * 
 * @author fastwave.developer
 * @date 
 */
public interface MonitorService {
	
	Monitor get(Map<String, Object> params);
	
	List<Monitor> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(Monitor adminAuthMonitor);
	
	int update(Monitor adminAuthMonitor);
	
	int remove(List<Long> ids);
	
	List<Org> listOrgByMonitorId(Long monitorId);
}
