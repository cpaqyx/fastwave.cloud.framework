package fastwave.service.admin.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fastwave.service.admin.common.base.BaseService;
import fastwave.service.admin.common.dao.CommonDao;
import fastwave.service.admin.common.service.CommonService;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author fastwave.developer
 * @date 
 */
@Service
public class CommonServiceImpl extends BaseService implements CommonService {

	@Autowired
	private CommonDao commonDao;

	@Override
	public boolean checkDuplicate(String tableName, String fieldName, Object value) {
		Map<String, Object> params = new HashMap<>();
		params.put("tableName", tableName);
		params.put("fieldName", fieldName);
		params.put("value", value);
		return commonDao.checkDuplicate(params) > 0;
	}

	@Override
	public boolean checkDuplicate(String tableName, String fieldName, Object value, Long id) {
		Map<String, Object> params = new HashMap<>();
		params.put("tableName", tableName);
		params.put("fieldName", fieldName);
		params.put("value", value);
		params.put("id", id);
		return commonDao.checkDuplicate(params) > 0;
	}

	@Override
	public boolean checkDuplicateForCustomer(String tableName, String fieldName, Object value, Long customerId) {
		Map<String, Object> params = new HashMap<>();
		params.put("tableName", tableName);
		params.put("fieldName", fieldName);
		params.put("value", value);
		params.put("customerId", customerId);
		return commonDao.checkDuplicate(params) > 0;
	}

	@Override
	public boolean checkDuplicateForCustomer(String tableName, String fieldName, Object value, Long id, Long customerId) {
		Map<String, Object> params = new HashMap<>();
		params.put("tableName", tableName);
		params.put("fieldName", fieldName);
		params.put("value", value);
		params.put("id", id);
		params.put("customerId", customerId);
		return commonDao.checkDuplicate(params) > 0;
	}

	@Override
	public boolean checkDuplicateForUnit(String tableName, String fieldName, Object value, Long unitId) {
		Map<String, Object> params = new HashMap<>();
		params.put("tableName", tableName);
		params.put("fieldName", fieldName);
		params.put("value", value);
		params.put("unitId", unitId);
		return commonDao.checkDuplicate(params) > 0;
	}

	@Override
	public boolean checkDuplicateForUnit(String tableName, String fieldName, Object value, Long id, Long unitId) {
		Map<String, Object> params = new HashMap<>();
		params.put("tableName", tableName);
		params.put("fieldName", fieldName);
		params.put("value", value);
		params.put("id", id);
		params.put("unitId", unitId);
		return commonDao.checkDuplicate(params) > 0;
	}

	@Override
	public boolean checkDuplicateForParent(String tableName, String fieldName, Object value, Long pid) {
		Map<String, Object> params = new HashMap<>();
		params.put("tableName", tableName);
		params.put("fieldName", fieldName);
		params.put("value", value);
		params.put("pid", pid);
		return commonDao.checkDuplicate(params) > 0;
	}

	@Override
	public boolean checkDuplicateForParent(String tableName, String fieldName, Object value, Long id, Long pid) {
		Map<String, Object> params = new HashMap<>();
		params.put("tableName", tableName);
		params.put("fieldName", fieldName);
		params.put("value", value);
		params.put("id", id);
		params.put("pid", pid);
		return commonDao.checkDuplicate(params) > 0;
	}
}
