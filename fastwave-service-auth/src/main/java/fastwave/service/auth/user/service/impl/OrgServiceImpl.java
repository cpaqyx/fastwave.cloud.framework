package fastwave.service.auth.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fastwave.service.auth.common.base.BaseService;
import fastwave.service.auth.user.dao.OrgDao;
import fastwave.service.auth.user.entity.Org;
import fastwave.service.auth.user.service.OrgService;

import java.util.List;
import java.util.Map;


/**
 * 客户组织架构
 * 
 * @author fastwave.developer
 * @date 
 */
@Service
public class OrgServiceImpl extends BaseService implements OrgService {
	@Autowired
	private OrgDao adminAuthOrgDao;
	
	@Override
	public Org get(Map<String, Object> params){
		return adminAuthOrgDao.get(params);
	}
	
	@Override
	public List<Org> list(Map<String, Object> map){
		return adminAuthOrgDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return adminAuthOrgDao.count(map);
	}
	
	@Override
	public int save(Org adminAuthOrg){
		return adminAuthOrgDao.save(adminAuthOrg);
	}
	
	@Override
	public int update(Org adminAuthOrg){
		return adminAuthOrgDao.update(adminAuthOrg);
	}
	
	@Override
	public int remove(List<Long> ids){
		return adminAuthOrgDao.remove(ids);
	}
	
	@Override
	public List<Org> listOrgByMonitorId(Long monitorId) {
		return adminAuthOrgDao.listOrgByMonitorId(monitorId);
	}
}
