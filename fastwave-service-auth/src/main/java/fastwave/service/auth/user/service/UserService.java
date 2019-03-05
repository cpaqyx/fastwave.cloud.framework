package fastwave.service.auth.user.service;

import java.util.List;
import java.util.Map;

import fastwave.service.auth.user.entity.User;

/**
 * 
 * 
 * @author fastwave.developer
 * @date 
 */
public interface UserService {
	
	User get(Map<String, Object> params);
	
	List<User> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(User user);
	
	int update(User user);
	
	int remove(List<Long> ids);
	
	Map<String, Object> getCustomerCoordinate(Map<String, Object> params);
	
}
