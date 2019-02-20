package fastwave.service.admin.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fastwave.service.admin.common.util.CacheUtil;

@Service
public class RunAfterStart implements InitializingBean {

	@Autowired
	private CacheUtil cacheUtil;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
