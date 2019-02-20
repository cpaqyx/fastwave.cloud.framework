package fastwave.lib.common.utils;

public class Constant {


	/*
	 * 用户类型：客户单位用户
	 */
	public static final Integer USER_TYPE_UNIT = 0;
	/*
	 * 用户类型：客户系统管理员
	 */
	public static final Integer USER_TYPE_ADMIN = 1;
	/*
	 * 用户类型：超级管理员
	 */
	public static final Integer USER_TYPE_SUPER = 2;
	/*
	 * 用户类型：客户监控中心用户
	 */
	public static final Integer USER_TYPE_MONITOR = 3;
	/*
	 * 用户类型：消防队用户
	 */
	public static final Integer USER_TYPE_FIRE_BRIGADE = 9;



	/*
	 * 过滤类型，单位树的节点级别：监控中心
	 */
	public static final String FILTER_TYPE_MONITOR = "1";
	/*
	 * 过滤类型，单位树的节点级别：组织
	 */
	public static final String FILTER_TYPE_ORG = "2";
	/*
	 * 过滤类型，单位树的节点级别：单位
	 */
	public static final String FILTER_TYPE_UNIT = "3";
	/*
	 * 过滤类型，单位树的节点级别：消防队
	 */
	public static final String FILTER_TYPE_FIRE_BRIGADE = "9";




	/*
	* 系统默认角色ID：监控中心管理员
	*/
	public static final Long ROLL_ID_MONITOR_MANAGER = 1L;
	/*
	 * 系统默认角色ID：监控中心法人
	 */
	public static final Long ROLL_ID_MONITOR_LEGAL = 2L;
	/*
	 * 系统默认角色ID：单位管理员
	 */
	public static final Long ROLL_ID_UNIT_MANAGER = 3L;
	/*
	 * 系统默认角色ID：单位法人
	 */
	public static final Long ROLL_ID_UNIT_LEGAL = 4L;
	/*
	 * 系统默认角色ID：单位专(兼)职消防管理人
	 */
	public static final Long ROLL_ID_UNIT_FIREMAN = 5L;
	/*
	 * 系统默认角色ID：消防队管理员
	 */
	public static final Long ROLL_ID_FIRE_BRIGADE = 6L;
	/*
	 * 系统默认角色ID：维保厂家人员
	 */
	public static final Long ROLL_ID_MAINTAIN_MAN = 7L;
}
