package fastwave.service.auth.user.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import fastwave.service.auth.user.entity.Role;

/**
 * 角色表
 * @author fastwave.developer
 * @date 
 */
@Mapper
public interface RoleDao {

	Role get(Map<String, Object> params);
	
	List<Role> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(Role role);
	
	int update(Role role);
	
	int remove(List<Long> ids);
	
}
