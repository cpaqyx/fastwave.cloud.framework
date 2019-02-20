package fastwave.client.admin.config.hystrix;

import java.util.Map;

import org.springframework.stereotype.Component;

import fastwave.client.admin.config.entity.District;
import fastwave.client.admin.config.feign.DistrictFeign;
import fastwave.lib.common.web.PageDataUtils;
import fastwave.lib.common.web.R;

/**
 * 行政区域，包含省／市／区县／乡镇街道四级
 * 
 * @author fastwave.developer
 * @date 2018-05-23 09:33:30
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Component
public class DistrictFallback implements DistrictFeign{
	
	@Override
	public Map<String, Object> treelist(Map<String, Object> params) {
		return PageDataUtils.buildHystrixList(this);
	}
	
	@Override
	public Map<String, Object> list(Map<String, Object> params) {
		return PageDataUtils.buildHystrixList(this);
	}
	
	@Override
	public R save(District district) {
		return R.buildEmptyR("添加");
		
	}

	@Override
	public R update(District district) {
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
