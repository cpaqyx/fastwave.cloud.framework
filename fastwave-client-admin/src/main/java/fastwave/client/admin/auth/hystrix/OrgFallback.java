package fastwave.client.admin.auth.hystrix;

import java.util.Map;

import org.springframework.stereotype.Component;

import fastwave.client.admin.auth.entity.Org;
import fastwave.client.admin.auth.feign.OrgFeign;
import fastwave.lib.common.web.PageDataUtils;
import fastwave.lib.common.web.R;

/**
 * 客户组织架构
 *
 * @author fastwave.developer
 * @date 2018-05-23 15:45:45
 * @Copyright: 2018 fastwave. All rights reserved.
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Component
public class OrgFallback implements OrgFeign{

	@Override
	public Map<String, Object> list(Map<String, Object> params) {
		return PageDataUtils.buildHystrixList(this);
}

	@Override
	public Map<String, Object> treelist(Map<String, Object> map) {
		return PageDataUtils.buildHystrixList(this);
	}

	@Override
	public R save(Map<String, Object> params) {
		return R.buildEmptyR("添加");

	}

	@Override
	public R update(Org org) {
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
