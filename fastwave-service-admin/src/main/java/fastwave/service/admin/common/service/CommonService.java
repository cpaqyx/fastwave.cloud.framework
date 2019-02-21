package fastwave.service.admin.common.service;

/**
 *
 * @author fastwave.developer
 * @date 
 */
public interface CommonService {


	/**
	 * 检查是否重复，全系统检查，适用于新增操作
	 */
	boolean checkDuplicate(String tableName, String fieldName, Object value);

	/**
	 * 检查是否重复，全系统检查，适用于编辑操作
	 */
	boolean checkDuplicate(String tableName, String fieldName, Object value, Long id);

	/**
	 * 检查是否重复，同一客户下检查，适用于新增操作
	 * 确保表里含有customer_id字段
	 */
	boolean checkDuplicateForCustomer(String tableName, String fieldName, Object value, Long customerId);

	/**
	 * 检查是否重复，同一客户下检查，适用于编辑操作
	 * 确保表里含有customer_id字段
	 */
	boolean checkDuplicateForCustomer(String tableName, String fieldName, Object value, Long id, Long customerId);

	/**
	 * 检查是否重复，同一单位下检查，适用于新增操作
	 * 确保表里含有unit_id字段
	 */
	boolean checkDuplicateForUnit(String tableName, String fieldName, Object value, Long unitId);

	/**
	 * 检查是否重复，同一单位下检查，适用于编辑操作
	 * 确保表里含有unit_id字段
	 */
	boolean checkDuplicateForUnit(String tableName, String fieldName, Object value, Long id, Long unitId);

	/**
	 * 检查是否重复，同一父节点下检查，适用于新增操作
	 * 确保表里含有pid字段
	 */
	boolean checkDuplicateForParent(String tableName, String fieldName, Object value, Long pid);

	/**
	 * 检查是否重复，同一父节点下检查，适用于编辑操作
	 * 确保表里含有pid字段
	 */
	boolean checkDuplicateForParent(String tableName, String fieldName, Object value, Long id, Long pid);


}
