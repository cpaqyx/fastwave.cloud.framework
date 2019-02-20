package fastwave.client.admin.config.feign;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fastwave.client.admin.config.entity.AdminCustomerInfo;
import fastwave.client.admin.config.hystrix.AdminCustomerInfoFallback;
import fastwave.lib.common.web.R;

/**
 * 客户表
 * @author fastwave.developer
 * @date 2018-05-22 09:46:58
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@FeignClient(name = "fastwave-service-admin", fallback = AdminCustomerInfoFallback.class)
public interface AdminCustomerInfoFeign {
	
	/**
	 * @Description 依据指定参数查询结果集及分页信息
	 * @param params 实体和分页的一些信息
	 * @return 分页结果
	 */
	@RequestMapping(value = "/config/adminCustomerInfo/list", method = RequestMethod.POST)
	public Map<String, Object> list(@RequestBody Map<String, Object> params);
   
	/**
	 * @Description 保存指定数据
	 * @param params 实体
	 * @return 是否操作成功
	 */
	@RequestMapping(value = "/config/adminCustomerInfo/save", method = RequestMethod.POST)
	public R save(@RequestBody Map<String, Object>map);
	
	/**
	 * @Description 更新指定数据
	 * @param params 实体
	 * @return 是否操作成功
	 */
	@RequestMapping(value ="/config/adminCustomerInfo/update", method = RequestMethod.POST)
	public R update(@RequestBody AdminCustomerInfo adminCustomerInfo) ;
	
	/**
	 * @Description 删除数据
	 * @param params 实体数组
	 * @return 是否操作成功
	 */
	@RequestMapping(value = "/config/adminCustomerInfo/remove", method = RequestMethod.POST)
	public R remove(@RequestBody AdminCustomerInfo adminCustomerInfo);
	

	
}
