package fastwave.service.auth.user.service;

import java.util.List;
import java.util.Map;

import fastwave.service.auth.user.entity.UserRole;

/**
 * 用户的角色
 * 
 * @author fastwave.developer
 * @date
 */
public interface UserRoleService {
	
	UserRole get(Map<String, Object> params);
	
	List<UserRole> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserRole userRole);
	
	int update(UserRole userRole);
	
	int remove(List<Long> ids);
	
}
