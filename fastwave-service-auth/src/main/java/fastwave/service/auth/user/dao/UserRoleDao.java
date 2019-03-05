package fastwave.service.auth.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import fastwave.service.auth.user.entity.UserRole;

/**
 * 用户的角色
 * @author fastwave.developer
 * @date 
 */
@Mapper
public interface UserRoleDao {

	UserRole get(Map<String, Object> params);
	
	List<UserRole> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(UserRole userRole);
	
	int update(UserRole userRole);
	
	int remove(List<Long> ids);
	
}
