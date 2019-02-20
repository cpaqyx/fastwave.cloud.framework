package fastwave.client.admin.customer.hystrix;

import java.util.Map;

import org.springframework.stereotype.Component;

import fastwave.client.admin.customer.entity.CustomerInfo;
import fastwave.client.admin.customer.feign.CustomerInfoFeign;
import fastwave.lib.common.web.PageDataUtils;
import fastwave.lib.common.web.R;

/**
 * 客户表
 * 
 * @author fastwave.developer
 * @date 2018-05-22 16:32:58
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Component
public class CustomerInfoFallback implements CustomerInfoFeign{
	
	@Override
	public Map<String, Object> list(Map<String, Object> params) {
		return PageDataUtils.buildHystrixList(this);
	}
	
	@Override
	public R save(Map<String, Object> params) {
		return R.buildEmptyR("添加");
		
	}

	@Override
	public R update(CustomerInfo customerInfo) {
		return R.buildEmptyR("更新");
	}

	@Override
	public R remove(Map<String, Object> params) {
		return R.buildEmptyR("删除");
	}

     @Override
	public Map<String, Object> view(Map<String, Object> params) {
		return PageDataUtils.buildHystrixRow("获取单条");
	}

}
