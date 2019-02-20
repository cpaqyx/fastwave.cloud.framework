package fastwave.client.admin.device.hystrix;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import fastwave.client.admin.device.entity.Type;
import fastwave.client.admin.device.feign.TypeFeign;
import fastwave.lib.common.web.PageDataUtils;
import fastwave.lib.common.web.R;

/**
 * 设备类型
 * 
 * @author fastwave.developer
 * @date 2018-05-25 16:31:04
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Component
public class TypeFallback implements TypeFeign{

	@Override
	public Map<String, Object> list(Map<String, Object> params) {
		return PageDataUtils.buildHystrixList(this);
	}
	
	@Override
	public R save( Map<String, Object> map) {
		return R.buildEmptyR("添加");
	}

	@Override
	public R update(Map<String, Object> map) {
		return R.buildEmptyR("更新");
	}

	@Override
	public R remove(Map<String, Object> params) {
		return R.buildEmptyR("删除");
	}

	@Override
	public List<Map> getByGroup(Map<String, Object> params) {
		return null;
	}

     @Override
	public Map<String, Object> view(Map<String, Object> params) {
		return PageDataUtils.buildHystrixRow("获取单条");
	}

}
