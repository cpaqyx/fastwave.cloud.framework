package fastwave.service.admin.config.service;

import fastwave.lib.common.entity.DictTypeEntity;

import java.util.List;
import java.util.Map;

import fastwave.service.admin.config.entity.Dict;

/**
 * 字典表
 * 
 * @author fastwave.developer
 * @date 
 */
public interface DictService {
	
	Dict get(Map<String, Object> params);
	
	List<Dict> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(Dict dict);
	
	int update(Dict dict);
	
	int remove(List<Long> ids);
	
	List<Dict> listType();
	
	List<DictTypeEntity> ListDictItems(Map<String, Object> params);
	
	List<DictTypeEntity> ListDictParents(Map<String, Object> params);
	
	Dict getByName(Map<String, Object> params);

	List<Map> treelist();

	String childMaxCode(Long parentId);

	int countExcelSelf(Map<String, Object> map);

	int countParse(Map<String, Object> params);
}
