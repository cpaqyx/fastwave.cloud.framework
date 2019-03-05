package fastwave.service.auth.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import fastwave.service.auth.user.entity.User;

/**
 * 
 * @author fastwave.developer
 * @date 
 */
@Mapper
public interface UserDao {

	User get(Map<String, Object> params);
	
	List<User> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(User user);
	
	int update(User user);
	
	int remove(List<Long> ids);
	
	Map<String, Object> getCustomerCoordinate(Map<String, Object> params);
	
}
