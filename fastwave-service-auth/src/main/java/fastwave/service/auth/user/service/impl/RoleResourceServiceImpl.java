package fastwave.service.auth.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fastwave.service.auth.common.base.BaseService;
import fastwave.service.auth.user.dao.RoleResourceDao;
import fastwave.service.auth.user.entity.Resource;
import fastwave.service.auth.user.entity.RoleResource;
import fastwave.service.auth.user.service.RoleResourceService;

import java.util.List;
import java.util.Map;


/**
 * 
 * 
 * @author fastwave.developer
 * @date 
 */
@Service
public class RoleResourceServiceImpl extends BaseService implements RoleResourceService {
	@Autowired
	private RoleResourceDao adminAuthRoleResourceDao;
	
	@Override
	public RoleResource get(Map<String, Object> params){
		return adminAuthRoleResourceDao.get(params);
	}
	
	@Override
	public List<RoleResource> list(Map<String, Object> map){
		return adminAuthRoleResourceDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return adminAuthRoleResourceDao.count(map);
	}
	
	@Override
	public int save(RoleResource adminAuthRoleResource){
		return adminAuthRoleResourceDao.save(adminAuthRoleResource);
	}
	
	@Override
	public int update(RoleResource adminAuthRoleResource){
		return adminAuthRoleResourceDao.update(adminAuthRoleResource);
	}
	
	@Override
	public int remove(List<Long> ids){
		return adminAuthRoleResourceDao.remove(ids);
	}

	@Override
	public List<Resource> listResource(Long roleId) {
		return adminAuthRoleResourceDao.listResource(roleId);
	}
	
}
