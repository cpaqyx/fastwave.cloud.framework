package fastwave.service.auth.user.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import fastwave.service.auth.user.entity.Org;

/**
 * 客户组织架构
 * @author fastwave.developer
 * @date 
 */
@Mapper
public interface OrgDao {

	Org get(Map<String, Object> params);
	
	List<Org> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(Org adminAuthOrg);
	
	int update(Org adminAuthOrg);
	
	int remove(List<Long> ids);
	
	List<Org> listOrgByMonitorId(Long monitorId);
}
