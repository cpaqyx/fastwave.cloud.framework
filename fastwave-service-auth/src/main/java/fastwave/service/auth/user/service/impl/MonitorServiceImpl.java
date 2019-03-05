package fastwave.service.auth.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fastwave.service.auth.common.base.BaseService;
import fastwave.service.auth.user.dao.MonitorDao;
import fastwave.service.auth.user.entity.Monitor;
import fastwave.service.auth.user.entity.Org;
import fastwave.service.auth.user.service.MonitorService;

import java.util.List;
import java.util.Map;


/**
 * 监控中心
 * 
 * @author fastwave.developer
 * @date 
 */
@Service
public class MonitorServiceImpl extends BaseService implements MonitorService {
	@Autowired
	private MonitorDao adminAuthMonitorDao;
	
	@Override
	public Monitor get(Map<String, Object> params){
		return adminAuthMonitorDao.get(params);
	}
	
	@Override
	public List<Monitor> list(Map<String, Object> map){
		return adminAuthMonitorDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return adminAuthMonitorDao.count(map);
	}
	
	@Override
	public int save(Monitor adminAuthMonitor){
		return adminAuthMonitorDao.save(adminAuthMonitor);
	}
	
	@Override
	public int update(Monitor adminAuthMonitor){
		return adminAuthMonitorDao.update(adminAuthMonitor);
	}
	
	@Override
	public int remove(List<Long> ids){
		return adminAuthMonitorDao.remove(ids);
	}
	
	@Override
	public List<Org> listOrgByMonitorId(Long monitorId) {
		return adminAuthMonitorDao.listOrgByMonitorId(monitorId);
	}
}
