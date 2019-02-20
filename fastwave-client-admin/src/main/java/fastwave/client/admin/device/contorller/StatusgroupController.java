package fastwave.client.admin.device.contorller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fastwave.client.admin.device.entity.Statusgroup;
import fastwave.client.admin.device.feign.StatusgroupFeign;

import org.springframework.web.bind.annotation.RequestBody;

import fastwave.lib.common.web.R;



/**
 * 设备状态组，字典数据，无需后台配置
 * @author fastwave.developer
 * @date 2018-05-25 13:56:09
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
 
@RestController
@RequestMapping(value = {"/device/statusgroup"}, produces="application/json;charset=UTF-8")
public class StatusgroupController {
	@Autowired
	private StatusgroupFeign statusgroupFeignClient;
	
	/**
	 * @Description 依据指定参数查询结果集及分页信息
	 * @param params 实体和分页的一些信息
	 * @return 分页结果
	 */
	@PostMapping("/list")
	public Map<String, Object> list(@RequestBody Map<String, Object> params){
		Map<String, Object> reMap= this.statusgroupFeignClient.list(params);
		return reMap;
	}
	
	/**
	 * @Description 查看单条数据
	 * @param params 主键
	 * @return 实体
	 */
	@PostMapping("/view")
	public Map<String, Object> get(@RequestBody Map<String, Object> params){
		Map<String, Object> reMap= this.statusgroupFeignClient.view(params);
		return reMap;
	}
   
	/**
	 * @Description 保存指定数据
	 * @param params 实体
	 * @return 是否操作成功
	 */
	@PostMapping("/save")
	public R save(@RequestBody Statusgroup statusgroup){
		return statusgroupFeignClient.save(statusgroup);
	}
	
	/**
	 * @Description 更新指定数据
	 * @param params 实体
	 * @return 是否操作成功
	 */
	@PostMapping("/update")
	public R update(@RequestBody Statusgroup statusgroup){
		return statusgroupFeignClient.update(statusgroup);
	}
	
	/**
	 * @Description 批量删除数据
	 * @param params 实体数组
	 * @return 是否操作成功
	 */
	@PostMapping("/remove")
	public R remove(@RequestBody Map<String, Object> params){
		return statusgroupFeignClient.remove(params);
	}
}
