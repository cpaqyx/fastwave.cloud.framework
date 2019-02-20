package fastwave.client.admin.device.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fastwave.client.admin.device.entity.Producer;
import fastwave.client.admin.device.hystrix.ProducerFallback;
import fastwave.lib.common.web.R;

import java.util.Map;

/**
 * 设备生产商
 * @author fastwave.developer
 * @date 2018-05-24 12:09:00
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@FeignClient(name = "fastwave-service-admin", fallback = ProducerFallback.class)
public interface ProducerFeign {
	
	/**
	 * @Description 依据指定参数查询结果集及分页信息
	 * @param params 实体和分页的一些信息
	 * @return 分页结果
	 */
	@RequestMapping(value = "/device/producer/list", method = RequestMethod.POST)
	public Map<String, Object> list(@RequestBody Map<String, Object> params);
   
	/**
	 * @Description 保存指定数据
	 * @param params 实体
	 * @return 是否操作成功
	 */
	@RequestMapping(value = "/device/producer/save", method = RequestMethod.POST)
	public R save(@RequestBody Producer producer);
	
	/**
	 * @Description 更新指定数据
	 * @param params 实体
	 * @return 是否操作成功
	 */
	@RequestMapping(value ="/device/producer/update", method = RequestMethod.POST)
	public R update(@RequestBody Producer producer) ;
	
	/**
	 * @Description 删除数据
	 * @param params 实体数组
	 * @return 是否操作成功
	 */
	@RequestMapping(value = "/device/producer/remove", method = RequestMethod.POST)
	public R remove(@RequestBody Map<String, Object> params);
	
	/**
	 * @Description 获取单条数据
	 * @param params 主键
	 * @return 实体
	 */
	@RequestMapping(value = "/device/producer/view", method = RequestMethod.POST)
	public Map<String, Object> view(@RequestBody Map<String, Object> params);

	/**
	 *
	 * @param params 安生产厂家名搜索
	 * @return
	 */
	@RequestMapping(value = "/device/producer/getAll", method = RequestMethod.POST)
	public Map<String, Object> getAll(@RequestBody Map<String, Object> params);
}
