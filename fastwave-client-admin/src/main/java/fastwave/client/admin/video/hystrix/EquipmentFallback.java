package fastwave.client.admin.video.hystrix;

import java.util.Map;

import org.springframework.stereotype.Component;

import fastwave.client.admin.video.entity.Equipment;
import fastwave.client.admin.video.feign.EquipmentFeign;
import fastwave.lib.common.web.PageDataUtils;
import fastwave.lib.common.web.R;

/**
 * 
 * 
 * @author fastwave.developer
 * @date 2018-06-19 19:14:43
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Component
public class EquipmentFallback implements EquipmentFeign{
	
	@Override
	public Map<String, Object> list(Map<String, Object> params) {
		return PageDataUtils.buildHystrixList(this);
	}
	
	@Override
	public R save(Equipment equipment) {
		return R.buildEmptyR("添加");
		
	}

	@Override
	public R update(Equipment equipment) {
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
