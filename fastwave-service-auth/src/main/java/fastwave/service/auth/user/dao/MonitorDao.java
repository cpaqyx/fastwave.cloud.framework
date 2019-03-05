package fastwave.service.auth.user.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import fastwave.service.auth.user.entity.Monitor;
import fastwave.service.auth.user.entity.Org;

/**
 * 监控中心
 * @author fastwave.developer
 * @date 
 */
@Mapper
public interface MonitorDao {

	Monitor get(Map<String, Object> params);
	
	List<Monitor> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(Monitor adminAuthMonitor);
	
	int update(Monitor adminAuthMonitor);
	
	int remove(List<Long> ids);
	
	List<Org> listOrgByMonitorId(Long monitorId);
}
