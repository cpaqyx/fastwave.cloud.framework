package fastwave.client.admin.device.contorller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fastwave.client.admin.device.entity.Producer;
import fastwave.client.admin.device.feign.ProducerFeign;
import fastwave.lib.common.web.R;

import java.util.Map;


/**
 * 设备生产商
 * @author fastwave.developer
 * @date 2018-05-24 12:09:00
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
 
@RestController
@RequestMapping(value = {"/device/producer"}, produces="application/json;charset=UTF-8")
public class ProducerController {
	@Autowired
	private ProducerFeign producerFeignClient;
	
	/**
	 * @Description 依据指定参数查询结果集及分页信息
	 * @param params 实体和分页的一些信息
	 * @return 分页结果
	 */
	@PostMapping("/list")
	public Map<String, Object> list(@RequestBody Map<String, Object> params){

		Map<String, Object> reMap= this.producerFeignClient.list(params);
		return reMap;
	}
	
	/**
	 * @Description 查看单条数据
	 * @param params 主键
	 * @return 实体
	 */
	@PostMapping("/view")
	public Map<String, Object> get(@RequestBody Map<String, Object> params){
		Map<String, Object> reMap= this.producerFeignClient.view(params);
		return reMap;
	}
   
	/**
	 * @Description 保存指定数据
	 * @param params 实体
	 * @return 是否操作成功
	 */
	@PostMapping("/save")
	public R save(@RequestBody Producer producer){
		return producerFeignClient.save(producer);
	}
	
	/**
	 * @Description 更新指定数据
	 * @param params 实体
	 * @return 是否操作成功
	 */
	@PostMapping("/update")
	public R update(@RequestBody Producer producer){
		return producerFeignClient.update(producer);
	}
	
	/**
	 * @Description 批量删除数据
	 * @param params 实体数组
	 * @return 是否操作成功
	 */
	@PostMapping("/remove")
	public R remove(@RequestBody Map<String, Object> params){
		return producerFeignClient.remove(params);
	}

	@PostMapping("/getAll")
	public Map<String, Object> getAll(@RequestBody Map<String, Object> params){
		Map<String, Object> reMap= this.producerFeignClient.getAll(params);
		return reMap;
	}

}
