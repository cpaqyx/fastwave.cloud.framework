package fastwave.client.admin.customer.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fastwave.client.admin.customer.entity.CustomerInfo;
import fastwave.client.admin.customer.feign.CustomerInfoFeign;

import org.springframework.web.bind.annotation.RequestBody;

import fastwave.lib.common.web.R;



/**
 * 客户表
 * @author fastwave.developer
 * @date 2018-05-22 16:32:58
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
 
@RestController
@RequestMapping(value = {"/customer/customerInfo"}, produces="application/json;charset=UTF-8")
public class CustomerInfoController {
	@Autowired
	private CustomerInfoFeign customerInfoFeignClient;

	/**
	 * @param params 实体和分页的一些信息
	 * @return 分页结果
	 * @Description 依据指定参数查询结果集及分页信息
	 */
	@PostMapping("/list")
	public Map<String, Object> list(@RequestBody Map<String, Object> params) {
		Map<String, Object> reMap = this.customerInfoFeignClient.list(params);
		return reMap;
	}

	/**
	 * @param params 主键
	 * @return 实体
	 * @Description 查看单条数据
	 */
	@PostMapping("/view")
	public Map<String, Object> get(@RequestBody Map<String, Object> params) {
		Map<String, Object> reMap = this.customerInfoFeignClient.view(params);
		return reMap;
	}

	/**
	 * @Description 保存指定数据
	 * @param params 实体
	 * @return 是否操作成功
	 */
	@PostMapping("/save")
	public R save(@RequestBody Map<String, Object>map){
		return customerInfoFeignClient.save(map);
	}


	/**
	 * @param params 实体
	 * @return 是否操作成功
	 * @Description 更新指定数据
	 */
	@PostMapping("/update")
	public R update(@RequestBody CustomerInfo customerInfo) {
		return customerInfoFeignClient.update(customerInfo);
	}


	/**
	 * @Description 批量删除数据
	 * @param params 实体数组
	 * @return 是否操作成功
	 */
	@PostMapping("/remove")
	public R remove(@RequestBody Map<String, Object> params){
		return customerInfoFeignClient.remove(params);
	}
}