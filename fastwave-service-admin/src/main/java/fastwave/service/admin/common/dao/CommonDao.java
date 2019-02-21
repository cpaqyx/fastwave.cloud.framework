package fastwave.service.admin.common.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 
 * @author fastwave.developer
 * @date 
 */
@Mapper
public interface CommonDao {

	int checkDuplicate(Map<String, Object> params);

}
