package fastwave.client.admin.config.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fastwave.client.admin.config.entity.AdminCustomerInfo;
import fastwave.client.admin.config.feign.AdminCustomerInfoFeign;

import org.springframework.web.bind.annotation.RequestBody;

import fastwave.lib.common.web.R;



/**
 * 客户表
 * @author fastwave.developer
 * @date 2018-05-22 09:46:58
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
 
@RestController
@RequestMapping(value = {"/config/adminCustomerInfo"}, produces="application/json;charset=UTF-8")
public class AdminCustomerInfoController {
	@Autowired
	private AdminCustomerInfoFeign adminCustomerInfoFeignClient;
	
	/**
	 * @Description 依据指定参数查询结果集及分页信息
	 * @param params 实体和分页的一些信息
	 * @return 分页结果
	 */
	@PostMapping("/list")
	public Map<String, Object> list(@RequestBody Map<String, Object> params){
		Map<String, Object> reMap= this.adminCustomerInfoFeignClient.list(params);
		return reMap;
	}
   
	/**
	 * @Description 保存指定数据
	 * @param params 实体
	 * @return 是否操作成功
	 */
	@PostMapping("/save")
	public R save(@RequestBody Map<String, Object>map){
		return adminCustomerInfoFeignClient.save(map);
	}
	
	/**
	 * @Description 更新指定数据
	 * @param params 实体
	 * @return 是否操作成功
	 */
	@PostMapping("/update")
	public R update(@RequestBody AdminCustomerInfo adminCustomerInfo){
		return adminCustomerInfoFeignClient.update(adminCustomerInfo);
	}
	
	/**
	 * @Description 批量删除数据
	 * @param params 实体数组
	 * @return 是否操作成功
	 */
	@PostMapping("/remove")
	public R remove(@RequestBody AdminCustomerInfo adminCustomerInfo){
		return adminCustomerInfoFeignClient.remove(adminCustomerInfo);
	}
}
