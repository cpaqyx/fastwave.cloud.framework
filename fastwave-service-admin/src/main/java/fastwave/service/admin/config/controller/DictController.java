package fastwave.service.admin.config.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fastwave.lib.common.entity.DictTypeEntity;
import fastwave.lib.common.tree.TreeUtil;
import fastwave.lib.common.web.PageDataUtils;
import fastwave.lib.common.web.Query;
import fastwave.lib.common.web.R;
import fastwave.service.admin.common.base.BaseController;
import fastwave.service.admin.config.entity.Dict;
import fastwave.service.admin.config.service.DictService;


/**
 * 字典表
 * @author fastwave.developer
 * @date 
 * @Copyright: 
 */
 
@RestController
@RequestMapping(value = {"/config/dict"}, produces="application/json;charset=UTF-8")
public class DictController extends BaseController{
	@Autowired
	private DictService dictService;
	
	@Value("${server.port}")
	private int serverPort;
	
	/**
	 * @Description 依据指定参数查询结果集及分页信息
	 * @param params 实体和分页的
	 * 
	 * 一些信息
	 * @return 分页结果
	 */
	@PostMapping("/list")
	public Map<String, Object> list(@RequestBody Map<String, Object> params){
		//查询列表数据
		int port = serverPort;
        Query query = new Query(params);
		List<Dict> List = dictService.list(query);
		int total = dictService.count(query);
		return PageDataUtils.buildResultMap(List, total);
	}
	
	/**
	 * @Description 字典表树
	 * @param params 
	 * @return 
	 */
	@PostMapping("/treelist")
	public Map<String, Object> treelist(@RequestBody Map<String, Object> params){
		//查询字典表
		@SuppressWarnings("rawtypes")
		List<Map> alllist = dictService.treelist();
		//字典树
		@SuppressWarnings("rawtypes")
		List<Map> treelist = new ArrayList<Map>();
		TreeUtil.parseTreeDict(treelist, alllist);
		params.put("pid", 0);
		int total = dictService.countParse(params);
		//TODO 解析license，设置节点状态
		return PageDataUtils.buildResultMap(treelist,total);
      
	}
   
   /**
	 * @Description 获取单条数据
	 * @param params 主键
	 * @return 实体
	 */
   @PostMapping("/view")
	public Map<String, Object> view(@RequestBody Map<String, Object> params){
		Dict dict = dictService.get(params);
		return PageDataUtils.buildEntitytMap(dict);
	}
   
	/**
	 * @Description 保存指定数据
	 * @param dict 实体
	 * @return 是否操作成功
	 */
	@PostMapping("/save")
	public R save(@RequestBody Dict dict){

		//dict.setCustomer_id(this.getCustomerId());
//		String code = dictService.childMaxCode(dict.getParentId());
//		if (code != null) {
//			//已存在子类，code递增1
//			String last3Code = StringUtils.right(code,3);
//			last3Code = String.format("%03d", Integer.parseInt(last3Code) + 1);
//			code = code.substring(0,code.length()-3) + last3Code;
//		} else {
//			//不存在子监控中心，code=父节点code+"001"
//			if (dict.getParentId() == 0) {
//				code = "D" + "_001";   //根节点的第一个
//			} else {
//				Map map = new HashMap();
//				map.put("id", dict.getParentId());
//				code = dictService.get(map).getCode() + "001";
//			}
//		}
//			dict.setCode(code);
			
		    // 通用设置，如果没有此字段，请注释改代码
		    dict.setCreateBy(this.getUserId());
			dict.setUpdateBy(this.getUserId());
			dict.setCreateDate(new Date());
			dict.setUpdateDate(new Date());
			dict.setDelFlag("0");
		
			//dict.setParentId(dict.getId());
			System.out.println(dict.getParentId());
			Map<String, Object> map = new HashMap<>();
			map.put("name", dict.getName());
			//map.put("parentId", dict.getId());
			int row = dictService.count(map);
			if (row > 0) {
				return R.error("名称已存在！");
			}else {
				if(dictService.save(dict)>0){
					return R.ok();
				}
			}
	    
		return R.error();
	}
	
	/**
	 * @Description 更新指定数据
	 * @param dict 实体
	 * @return 是否操作成功
	 */
	@PostMapping("/update")
	public R update(@RequestBody Dict dict){
	    // 通用设置，如果没有请注释改代码
		dict.setUpdateBy(this.getUserId());
		dict.setUpdateDate(new Date());
		//判断名称是否唯一
		Map<String, Object> map = new HashMap<>();
		map.put("name", dict.getName());
		map.put("id", dict.getId());
		int row = dictService.countExcelSelf(map);
		if (row > 0) {
			return R.error("名称已存在！");
		}else {
			if(dictService.update(dict)>0){
				return R.ok();
			}
		}
		return R.error();
	}
	
	
	/**
	 * @Description删除数据
	 * @param params 主键数组
	 * @return 是否操作成功
	 */
	@PostMapping("/remove")
	public R remove(@RequestBody Map<String, Object> params){
	    ArrayList<Long> ids = (ArrayList<Long>)params.get("ids");
		if(dictService.remove(ids)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * @Description type类型集合
	 * @param params 
	 * @return map集合
	 */
	@PostMapping("/listType")
	public Map<String, Object> listType(){
		//查询指定数据列表数据
		List<Dict> List = dictService.listType();
		return PageDataUtils.buildResultMap(List);
	}
	
	/**
	 * @Description  通过type查询出对应的name和type的集合
	 * @param params 字典表的type字段
	 * @return map集合  type和nama的map集合
	 */
	@PostMapping("/ListDictItems_notCheck")
	public Map<String, Object> ListDictItems(@RequestBody Map<String, Object> params){
		//查询指定数据列表数据
		List<DictTypeEntity> listDictItems = dictService.ListDictItems(params);
		return PageDataUtils.ListDictItems(listDictItems);
	}
	
	/**
	 * @Description  字典表级联
	 * @param params 字典表的parent_id字段
	 * @return map集合  type和nama的map集合
	 */
	@PostMapping("/ListDictParents")
	public Map<String, Object> ListDictParents(@RequestBody Map<String, Object> params){
		//查询指定数据列表数据
		List<DictTypeEntity> listDictParents = dictService.ListDictParents(params);
		return PageDataUtils.ListDictItems(listDictParents);
	}
}
