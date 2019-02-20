package fastwave.lib.common.utils;

public class DeviceConstant {


	/*
	 * 设备状态标识：正常
	 */
	public static final Integer STATUS_FLAG_FINE = 1;

	/*
	 * 设备状态标识：故障
	 */
	public static final Integer STATUS_FLAG_FAULT = 2;

	/*
	 * 设备状态标识：报警
	 */
	public static final Integer STATUS_FLAG_WARN = 3;

	/*
	 * 设备状态标识：离线
	 */
	public static final Integer STATUS_FLAG_OFFLINE = 4;




	/*
	 * 设备类型系统：火灾自动报警系统
	 */
	public static final Long SYSTEM_FIRE_WARN = 1L;
	/*
	 * 设备类型系统：电气火灾监控系统
	 */
	public static final Long SYSTEM_ELECTRIC_FIRE_MONITOR = 2L;
	/*
	 * 设备类型系统：液压液位监控系统
	 */
	public static final Long SYSTEM_WATER_MONITOR = 3L;
	/*
	 * 设备类型系统：自动喷水灭火系统
	 */
	public static final Long SYSTEM_WATER_OUTFIRE = 4L;
	/*
	 * 设备类型系统：室内消火栓系统
	 */
	public static final Long SYSTEM_INDOOR_HYDRANT = 5L;
	/*
	 * 设备类型系统：消防视频监控系统
	 */
	public static final Long SYSTEM_VIDEO_MONITOR = 6L;
	/*
	 * 设备类型系统：气体报警系统
	 */
	public static final Long SYSTEM_GAS_WARN = 7L;
	/*
	 * 设备类型系统：充电桩监控系统
	 */
	public static final Long SYSTEM_CHARGING_MONITOR = 8L;
	/*
	 * 设备类型系统：防排烟系统
	 */
	public static final Long SYSTEM_SMOKE_CONTROL = 9L;
	/*
	 * 设备类型系统：泡沫灭火系统
	 */
	public static final Long SYSTEM_FOAM_OUTFIRE = 10L;
	/*
	 * 设备类型系统：气体灭火系统
	 */
	public static final Long SYSTEM_GAS_OUTFIRE = 11L;
	/*
	 * 设备类型系统：物联网关系统
	 */
	public static final Long SYSTEM_IOT = 12L;
	/*
	 * 设备类型系统：小场所安全监管系统
	 */
	public static final Long SYSTEM_SMALL_PLACE_MONITOR = 13L;





	/*
	 * 设备类型：液压液位监控系统  --  物联网传输装置
	 */
	public static final Long SYSTEM_WATER_MONITOR___IOT = 1L;
	/*
	 * 设备类型：液压液位监控系统  --  液位传感器
	 */
	public static final Long SYSTEM_WATER_MONITOR___LEVEL_SERSOR = 2L;
	/*
	 * 设备类型：液压液位监控系统  --  压力传感器
	 */
	public static final Long SYSTEM_WATER_MONITOR___PRESSURE_SERSOR = 3L;
	/*
	 * 设备类型：液压液位监控系统  --  温度传感器
	 */
	public static final Long SYSTEM_WATER_MONITOR___TEMPERATURE_SERSOR = 4L;
	/*
	 * 设备类型：液压液位监控系统  --  湿度传感器
	 */
	public static final Long SYSTEM_WATER_MONITOR___HUMIDITY_SERSOR = 5L;




}
