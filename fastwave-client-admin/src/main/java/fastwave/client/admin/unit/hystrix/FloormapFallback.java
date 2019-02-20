package fastwave.client.admin.unit.hystrix;

import java.util.Map;

import org.springframework.stereotype.Component;

import fastwave.client.admin.unit.entity.Floormap;
import fastwave.client.admin.unit.feign.FloormapFeign;
import fastwave.lib.common.web.PageDataUtils;
import fastwave.lib.common.web.R;

/**
 * 
 * 
 * @author fastwave.developer
 * @date 2018-05-29 09:43:01
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Component
public class FloormapFallback implements FloormapFeign{
	
	@Override
	public Map<String, Object> list(Map<String, Object> params) {
		return PageDataUtils.buildHystrixList(this);
	}
	
	@Override
	public R save(Floormap floormap) {
		return R.buildEmptyR("添加");
		
	}

	@Override
	public R update(Floormap floormap) {
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
