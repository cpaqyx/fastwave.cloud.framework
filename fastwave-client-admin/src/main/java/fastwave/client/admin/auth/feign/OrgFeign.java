package fastwave.client.admin.auth.feign;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fastwave.client.admin.auth.entity.Org;
import fastwave.client.admin.auth.hystrix.OrgFallback;
import fastwave.lib.common.web.R;

/**
 * 客户组织架构
 * @author fastwave.developer
 * @date 2018-05-23 15:45:45
 * @Copyright: 2018 fastwave. All rights reserved.
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@FeignClient(name = "fastwave-service-admin", fallback = OrgFallback.class)
public interface OrgFeign {

	/**
	 * @Description 依据指定参数查询结果集及分页信息
	 * @param params 实体和分页的一些信息
	 * @return 分页结果
	 */
	@RequestMapping(value = "/auth/org/list", method = RequestMethod.POST)
	public Map<String, Object> list(@RequestBody Map<String, Object> params);

	@RequestMapping(value = "/auth/org/treelist", method = RequestMethod.POST)
	public Map<String, Object> treelist(@RequestBody Map<String, Object> map);
	/**
	 * @Description 保存指定数据
	 * @param params 实体
	 * @return 是否操作成功
	 */
	@RequestMapping(value = "/auth/org/save", method = RequestMethod.POST)
	public R save(@RequestBody Map<String, Object> params);

	/**
	 * @Description 更新指定数据
	 * @param params 实体
	 * @return 是否操作成功
	 */
	@RequestMapping(value ="/auth/org/update", method = RequestMethod.POST)
	public R update(@RequestBody Org org) ;

	/**
	 * @Description 删除数据
	 * @param params 实体数组
	 * @return 是否操作成功
	 */
	@RequestMapping(value = "/auth/org/remove", method = RequestMethod.POST)
	public R remove(@RequestBody Map<String, Object> params);

	/**
	 * @Description 获取单条数据
	 * @param params 主键
	 * @return 实体
	 */
	@RequestMapping(value = "/auth/org/view", method = RequestMethod.POST)
	public Map<String, Object> view(@RequestBody Map<String, Object> params);

}
