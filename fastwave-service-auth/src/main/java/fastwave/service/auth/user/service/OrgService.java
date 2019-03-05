package fastwave.service.auth.user.service;


import java.util.List;
import java.util.Map;

import fastwave.service.auth.user.entity.Org;

/**
 * 客户组织架构
 * 
 * @author fastwave.developer
 * @date 
 */
public interface OrgService {
	
	Org get(Map<String, Object> params);
	
	List<Org> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(Org adminAuthOrg);
	
	int update(Org adminAuthOrg);
	
	int remove(List<Long> ids);
	
	List<Org> listOrgByMonitorId(Long monitorId);
}
