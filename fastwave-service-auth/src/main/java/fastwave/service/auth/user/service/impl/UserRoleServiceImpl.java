package fastwave.service.auth.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fastwave.service.auth.common.base.BaseService;
import fastwave.service.auth.user.dao.UserRoleDao;
import fastwave.service.auth.user.entity.UserRole;
import fastwave.service.auth.user.service.UserRoleService;

import java.util.List;
import java.util.Map;

/**
 * 用户的角色
 * 
 * @author fastwave.developer
 * @date 
 */
@Service
public class UserRoleServiceImpl extends BaseService implements UserRoleService {
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Override
	public UserRole get(Map<String, Object> params){
		return userRoleDao.get(params);
	}
	
	@Override
	public List<UserRole> list(Map<String, Object> map){
		return userRoleDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userRoleDao.count(map);
	}
	
	@Override
	public int save(UserRole userRole){
		return userRoleDao.save(userRole);
	}
	
	@Override
	public int update(UserRole userRole){
		return userRoleDao.update(userRole);
	}
	
	@Override
	public int remove(List<Long> ids){
		return userRoleDao.remove(ids);
	}
	
}
