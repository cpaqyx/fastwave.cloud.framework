package fastwave.lib.common.utils;

/**
 * @author bootdo
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils{
	
	public static final long TOKEN_MAXAGE =24*60*60L;
	
	public static final String REDIS_ROLE="AUTH_ROLE";
	
	public static final String REDIS_MONITOR="AUTH_MONITOR";
	
	public static final String REDIS_UNIT="AUTH_UNIT";
	
	public static final String REDIS_DEVICENUMBER="AUTH_DEVICENUMBER";
}
