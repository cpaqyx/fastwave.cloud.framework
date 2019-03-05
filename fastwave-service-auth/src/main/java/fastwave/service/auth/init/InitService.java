package fastwave.service.auth.init;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fastwave.lib.common.utils.StringUtils;
import fastwave.service.auth.user.entity.Monitor;
import fastwave.service.auth.user.entity.Org;
import fastwave.service.auth.user.entity.Resource;
import fastwave.service.auth.user.entity.Role;
import fastwave.service.auth.user.service.MonitorService;
import fastwave.service.auth.user.service.RoleResourceService;
import fastwave.service.auth.user.service.RoleService;
import fastwave.service.auth.util.CacheUtil;

@Service
public class InitService implements InitializingBean {

	@Autowired
	private CacheUtil cacheUtil;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RoleResourceService roleResourceService;
	
	
	@Autowired
	private MonitorService monitorService;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
		List<Role> roleList = roleService.list(null);
		
		for (Role role : roleList) {
			HashMap<String, Boolean> map = new HashMap<String, Boolean>();
			List<Resource> resourceList = roleResourceService.listResource(role.getId());
			for (Resource resource : resourceList) {
				map.put(resource.getResourceUrl(),true );
			}
			cacheUtil.set(StringUtils.REDIS_ROLE+role.getId(), map);
			
			System.out.println(cacheUtil.get(StringUtils.REDIS_ROLE+role.getId()).toString());
		}
		
		
		List<Monitor> monitorList = monitorService.list(null);
		
		for (Monitor monitor : monitorList) {
			List<Org> orgList = monitorService.listOrgByMonitorId(monitor.getId());
			System.out.println(orgList.toString());
			String orgCode="";
			for (Org org : orgList) {
				orgCode+=org.getOrgCode()+",";
				System.out.println(org.getOrgCode());
			}
			
			if(orgCode=="") {
				cacheUtil.set(StringUtils.REDIS_MONITOR+monitor.getId(), orgCode);
			}else {
				cacheUtil.set(StringUtils.REDIS_MONITOR+monitor.getId(), orgCode.substring(0,orgCode.length()-1));
			}
		}
	}

}
