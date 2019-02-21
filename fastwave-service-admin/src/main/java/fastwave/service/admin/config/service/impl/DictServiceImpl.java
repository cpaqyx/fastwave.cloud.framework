package fastwave.service.admin.config.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fastwave.service.admin.common.base.BaseService;
import fastwave.service.admin.config.dao.DictDao;
import fastwave.service.admin.config.entity.Dict;
import fastwave.service.admin.config.service.DictService;

import java.util.List;
import java.util.Map;

import fastwave.lib.common.entity.DictTypeEntity;

/**
 * 字典表
 * 
 * @author fastwave.developer
 * @date 
 */
@Service
public class DictServiceImpl extends BaseService implements DictService {
	@Autowired
	private DictDao dictDao;
	
	@Override
	public Dict get(Map<String, Object> params){
		return dictDao.get(params);
	}
	
	@Override
	public List<Dict> list(Map<String, Object> map){
		return dictDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return dictDao.count(map);
	}
	
	@Override
	public int save(Dict dict){
		return dictDao.save(dict);
	}
	
	@Override
	public int update(Dict dict){
		return dictDao.update(dict);
	}
	
	@Override
	public int remove(List<Long> ids){
		return dictDao.remove(ids);
	}

	@Override
	public List<Dict> listType() {
		return dictDao.listType();
	}

	@Override
	public List<DictTypeEntity> ListDictItems(Map<String, Object> params) {
		return dictDao.ListDictItems(params);
	}

	@Override
	public List<DictTypeEntity> ListDictParents(Map<String, Object> params) {
		return dictDao.ListDictParents(params);
	}

	@Override
	public Dict getByName(Map<String, Object> params) {
		return dictDao.getByName(params);
	}

	@Override
	public List<Map> treelist() {
		
		return dictDao.treelist();
	}

	@Override
	public String childMaxCode(Long parentId) {
		
		return dictDao.childMaxCode(parentId);
	}

	@Override
	public int countExcelSelf(Map<String, Object> map) {
		
		return dictDao.countExcelSelf(map);
	}

	@Override
	public int countParse(Map<String, Object> params) {
		return dictDao.countParse(params);
	}	
	
}
