package fastwave.service.auth.user.service;


import java.util.List;
import java.util.Map;

import fastwave.service.auth.user.entity.Role;

/**
 * 角色表
 * 
 * @author fastwave.developer
 * @date
 */
public interface RoleService {
	
	Role get(Map<String, Object> params);
	
	List<Role> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(Role role);
	
	int update(Role role);
	
	int remove(List<Long> ids);
	
}
