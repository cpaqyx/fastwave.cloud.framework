package fastwave.client.admin.config.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fastwave.client.admin.config.entity.Dict;
import fastwave.client.admin.config.feign.DictFeign;

import org.springframework.web.bind.annotation.RequestBody;

import fastwave.lib.common.entity.DictTypeEntity;
import fastwave.lib.common.web.PageDataUtils;
import fastwave.lib.common.web.R;



/**
 * 字典表
 * @author fastwave.developer
 * @date 2018-05-28 15:23:44
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
 
@RestController
@RequestMapping(value = {"/config/dict"}, produces="application/json;charset=UTF-8")
public class DictController {
	@Autowired
	private DictFeign dictFeignClient;
	
	/**
	 * @Description 依据指定参数查询结果集及分页信息
	 * @param params 实体和分页的一些信息
	 * @return 分页结果
	 */
	@PostMapping("/list")
	public Map<String, Object> list(@RequestBody Map<String, Object> params){
		Map<String, Object> reMap= this.dictFeignClient.list(params);
		return reMap;
	}
	
	/**
	 * @Description 查看单条数据
	 * @param params 主键
	 * @return 实体
	 */
	@PostMapping("/view")
	public Map<String, Object> get(@RequestBody Map<String, Object> params){
		Map<String, Object> reMap= this.dictFeignClient.view(params);
		return reMap;
	}
   
	/**
	 * @Description 保存指定数据
	 * @param params 实体
	 * @return 是否操作成功
	 */
	@PostMapping("/save")
	public R save(@RequestBody Dict dict){
		return dictFeignClient.save(dict);
	}
	
	/**
	 * @Description 更新指定数据
	 * @param params 实体
	 * @return 是否操作成功
	 */
	@PostMapping("/update")
	public R update(@RequestBody Dict dict){
		return dictFeignClient.update(dict);
	}
	
	/**
	 * @Description 批量删除数据
	 * @param params 实体数组
	 * @return 是否操作成功
	 */
	@PostMapping("/remove")
	public R remove(@RequestBody Map<String, Object> params){
		return dictFeignClient.remove(params);
	}
	
	 @PostMapping("/listType")
	public Map<String, Object> listType() {
	    return this.dictFeignClient.listType();
	}
	 
	 @PostMapping("/ListDictItems")
	public Map<String, Object> ListDictItems(@RequestBody Map<String, Object> params){
			//查询指定数据列表数据
		return this.dictFeignClient.ListDictItems(params);
			
		}
}
