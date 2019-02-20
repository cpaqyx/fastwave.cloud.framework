package fastwave.client.admin.config.hystrix;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import fastwave.client.admin.config.entity.Dict;
import fastwave.client.admin.config.feign.DictFeign;
import fastwave.lib.common.web.PageDataUtils;
import fastwave.lib.common.web.R;

/**
 * 字典表
 * 
 * @author fastwave.developer
 * @date 2018-05-28 15:23:44
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Component
public class DictFallback implements DictFeign{
	
	@Override
	public Map<String, Object> list(Map<String, Object> params) {
		return PageDataUtils.buildHystrixList(this);
	}
	
	@Override
	public R save(Dict dict) {
		return R.buildEmptyR("添加");
		
	}

	@Override
	public R update(Dict dict) {
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
	public Map<String, Object> listType() {
		return R.buildEmptyR("获取type集合");
	}

	@Override
	public Map<String, Object> ListDictItems( Map<String, Object> params) {
		return R.buildEmptyR("字典表中type类型获取");
	}

}
