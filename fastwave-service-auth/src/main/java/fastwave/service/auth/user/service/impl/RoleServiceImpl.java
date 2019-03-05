package fastwave.service.auth.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fastwave.service.auth.common.base.BaseService;
import fastwave.service.auth.user.dao.RoleDao;
import fastwave.service.auth.user.entity.Role;
import fastwave.service.auth.user.service.RoleService;

import java.util.List;
import java.util.Map;


/**
 * 角色表
 * 
 * @author fastwave.developer
 * @date 
 */
@Service
public class RoleServiceImpl extends BaseService implements RoleService {
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public Role get(Map<String, Object> params){
		return roleDao.get(params);
	}
	
	@Override
	public List<Role> list(Map<String, Object> map){
		return roleDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return roleDao.count(map);
	}
	
	@Override
	public int save(Role role){
		return roleDao.save(role);
	}
	
	@Override
	public int update(Role role){
		return roleDao.update(role);
	}
	
	@Override
	public int remove(List<Long> ids){
		return roleDao.remove(ids);
	}
	
}
