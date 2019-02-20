package fastwave.client.admin.config.hystrix;

import java.util.Map;

import org.springframework.stereotype.Component;

import fastwave.client.admin.config.entity.AdminCustomerInfo;
import fastwave.client.admin.config.feign.AdminCustomerInfoFeign;
import fastwave.lib.common.web.PageDataUtils;
import fastwave.lib.common.web.R;

/**
 * 客户表
 * 
 * @author fastwave.developer
 * @date 2018-05-22 09:46:58
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Component
public class AdminCustomerInfoFallback implements AdminCustomerInfoFeign {
	
	@Override
	public Map<String, Object> list(Map<String, Object> params) {
		return null;
	}

	@Override
	public R save(Map<String, Object> map) {
		return null;
	}

	@Override
	public R update(AdminCustomerInfo adminCustomerInfo) {
		return null;
	}

	@Override
	public R remove(AdminCustomerInfo adminCustomerInfo) {
		return null;
	}

}
