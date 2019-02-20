package fastwave.lib.common.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * pageDataUtils工具类
 * @author
 * @data 2018-05-15 19:08:07
 */
public  class PageDataUtils {
	/**
	 * 
	 * @Description (对应实体的list信息)
	 * @param
	 * @return
	 */
	public static Map<String, Object> buildResultMap(List<?> list, int total) {
		Map<String, Object> reMap=new HashMap<String, Object>();
		reMap.put("code", 200);
		reMap.put("message", "操作成功");
		reMap.put("list", list);
		reMap.put("total", total);
		return reMap;
	}

	/**
	 *
	 * @Description (针对统计值和合计值)
	 * @param
	 * @return
	 */
	public static Map<String, Object> buildResultMap(List<?> list, Map total) {
		Map<String, Object> reMap=new HashMap<String, Object>();
		reMap.put("code", 200);
		reMap.put("message", "操作成功");
		reMap.put("list", list);
		reMap.put("total", total);
		return reMap;
	}
	
	/**
	 * 
	 * @Description (针对字典表type的信息显示)
	 * @param
	 * @return
	 */
	public static Map<String, Object> buildResultMap(List<?> list) {
		Map<String, Object> reMap=new HashMap<String, Object>();
		reMap.put("code", 200);
		reMap.put("message", "操作成功");
		reMap.put("list", list);
		return reMap;
	}
	
	/**
	 * 
	 * @Description (TODO这里用一句话描述这个方法的作用)
	 * @param
	 * @return
	 */
	public static Map<String, Object> ListDictItems(List<?> list) {
		Map<String, Object> reMap=new HashMap<String, Object>();
		reMap.put("code", 200);
		reMap.put("message", "操作成功");
		reMap.put("list", list);
		return reMap;
	}
	
	/**
	 * 
	 * @Description (单个实体)
	 * @param
	 * @return
	 */
	public static Map<String, Object> buildEntitytMap(Object object) {
		Map<String, Object> reMap=new HashMap<String, Object>();
		reMap.put("code", 200);
		reMap.put("message", "操作成功");
		reMap.put("data", object);
		return reMap;
	}
	
	/**
	 * 
	 * @Description (TODO这里用一句话描述这个方法的作用)
	 * @param obj
	 * @return
	 */
	public static Map<String, Object> buildEmptyMap(Object obj) {
		Map<String, Object> reMap=new HashMap<String, Object>();
		reMap.put("code", 500);
		reMap.put("message", "请求超时，熔断器返回默认对象,类名信息 :" + obj.toString());
		Map<String, Object> responseMap=new HashMap<String, Object>();
		responseMap.put("list", null);
		responseMap.put("total", 0);
		return reMap;
	}
	
	
	public static Map<String, Object> buildHystrixList(Object obj) {
		Map<String, Object> reMap=new HashMap<String, Object>();
		reMap.put("code", 500);
		reMap.put("message", "请求超时，熔断器返回默认对象,类名信息 :" + obj.toString());
		Map<String, Object> responseMap=new HashMap<String, Object>();
		responseMap.put("list", null);
		responseMap.put("total", 0);
		return reMap;
	}
	
	public static Map<String, Object> buildHystrixRow(String message) {
		Map<String, Object> reMap=new HashMap<String, Object>();
		reMap.put("code", ResponseCode.API_CODE_CALL_ERROR);
		reMap.put("message", message+"超时，熔断器返回");
		reMap.put("data", null);
		return reMap;
	}

	public static Map<String, Object> buildResultList(Object obj,List list) {
		Map<String, Object> reMap=new HashMap<String, Object>();
		reMap.put("code", 200);
		reMap.put("data", obj);
		reMap.put("channelList", list);
		return reMap;
	}
}
