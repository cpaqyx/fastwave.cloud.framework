package fastwave.service.auth.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fastwave.service.auth.user.dao.UserDao;
import fastwave.service.auth.user.entity.User;
import fastwave.service.auth.user.service.UserService;

/**
 * 
 * 
 * @author fastwave.developer
 * @date 
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public User get(Map<String, Object> params){
		return userDao.get(params);
	}
	
	@Override
	public List<User> list(Map<String, Object> map){
		return userDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userDao.count(map);
	}
	
	@Override
	public int save(User user){
		return userDao.save(user);
	}
	
	@Override
	public int update(User user){
		return userDao.update(user);
	}
	
	@Override
	public int remove(List<Long> ids){
		return userDao.remove(ids);
	}

	@Override
	public Map<String, Object> getCustomerCoordinate(Map<String, Object> params) {
		return userDao.getCustomerCoordinate(params);
	}
	
}
