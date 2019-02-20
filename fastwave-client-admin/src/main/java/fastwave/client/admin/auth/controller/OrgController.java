package fastwave.client.admin.auth.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fastwave.client.admin.auth.entity.Org;
import fastwave.client.admin.auth.feign.OrgFeign;

import org.springframework.web.bind.annotation.RequestBody;

import fastwave.lib.common.web.R;



/**
 * 客户组织架构
 * @author fastwave.developer
 * @date 2018-05-23 15:45:45
 * @Copyright: 2018 fastwave. All rights reserved.
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */

@RestController
@RequestMapping(value = {"/auth/org"}, produces="application/json;charset=UTF-8")
public class OrgController {
	@Autowired
	private OrgFeign orgFeignClient;

	@PostMapping("/treelist")
	public Map<String, Object> treelist(@RequestBody Map<String, Object> params) {
		return orgFeignClient.treelist(params);
	}

	/**
	 * @Description 依据指定参数查询结果集及分页信息
	 * @param params 实体和分页的一些信息
	 * @return 分页结果
	 */
	@PostMapping("/list")
	public Map<String, Object> list(@RequestBody Map<String, Object> params){
		Map<String, Object> reMap= this.orgFeignClient.list(params);
		return reMap;
	}

	/**
	 * @Description 查看单条数据
	 * @param params 主键
	 * @return 实体
	 */
	@PostMapping("/view")
	public Map<String, Object> get(@RequestBody Map<String, Object> params){
		Map<String, Object> reMap= this.orgFeignClient.view(params);
		return reMap;
	}

	/**
	 * @Description 保存指定数据
	 * @param params 实体
	 * @return 是否操作成功
	 */
	@PostMapping("/save")
	public R save(@RequestBody Map<String, Object> params){
		return orgFeignClient.save(params);
	}

	/**
	 * @Description 更新指定数据
	 * @param params 实体
	 * @return 是否操作成功
	 */
	@PostMapping("/update")
	public R update(@RequestBody Org org){
		return orgFeignClient.update(org);
	}

	/**
	 * @Description 批量删除数据
	 * @param params 实体数组
	 * @return 是否操作成功
	 */
	@PostMapping("/remove")
	public R remove(@RequestBody Map<String, Object> params){
		return orgFeignClient.remove(params);
	}
}
