package fastwave.service.auth.user.service;


import java.util.List;
import java.util.Map;

import fastwave.service.auth.user.entity.Resource;
import fastwave.service.auth.user.entity.RoleResource;

/**
 * 
 * 
 * @author fastwave.developer
 * @date 
 */
public interface RoleResourceService {
	
	RoleResource get(Map<String, Object> params);
	
	List<RoleResource> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RoleResource adminAuthRoleResource);
	
	int update(RoleResource adminAuthRoleResource);
	
	int remove(List<Long> ids);
	
	List<Resource> listResource(Long roleId);
	
}
