package fastwave.service.auth.user.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import fastwave.service.auth.user.entity.Resource;
import fastwave.service.auth.user.entity.RoleResource;

/**
 * 
 * @author fastwave.developer
 * @date
 */
@Mapper
public interface RoleResourceDao {

	RoleResource get(Map<String, Object> params);
	
	List<RoleResource> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(RoleResource adminAuthRoleResource);
	
	int update(RoleResource adminAuthRoleResource);
	
	int remove(List<Long> ids);
	
	List<Resource> listResource(Long roleId);
	
}
