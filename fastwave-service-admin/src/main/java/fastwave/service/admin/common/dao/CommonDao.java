package fastwave.service.admin.common.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 
 * @author fastwave.developer
 * @date 2018-05-25 16:17:44
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Mapper
public interface CommonDao {

	int checkDuplicate(Map<String, Object> params);

}
