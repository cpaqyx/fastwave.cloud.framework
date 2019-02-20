package fastwave.client.admin.device.hystrix;

import org.springframework.stereotype.Component;

import fastwave.client.admin.device.entity.Producer;
import fastwave.client.admin.device.feign.ProducerFeign;
import fastwave.lib.common.web.PageDataUtils;
import fastwave.lib.common.web.R;

import java.util.Map;

/**
 * 设备生产商
 * 
 * @author fastwave.developer
 * @date 2018-05-24 12:09:00
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Component
public class ProducerFallback implements ProducerFeign {
	
	@Override
	public Map<String, Object> list(Map<String, Object> params) {
		return PageDataUtils.buildHystrixList(this);
	}



	@Override
	public R save(Producer producer) {
		return R.buildEmptyR("添加");
		
	}

	@Override
	public R update(Producer producer) {
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

	@Override
	public Map<String, Object> getAll(Map<String, Object> params) {
		return PageDataUtils.buildHystrixRow("获取单条");
	}

}
