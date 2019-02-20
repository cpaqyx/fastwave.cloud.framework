package fastwave.cloud.zuul.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import fastwave.cloud.zuul.util.CacheUtil;
import fastwave.lib.common.jwt.Signature;
import fastwave.lib.common.jwt.TokenModel;
import fastwave.lib.common.utils.Constant;
import fastwave.lib.common.utils.StringUtils;

/**
 * 
 * @author Administrator
 * 描述：自定义Filter
 */
public class Filter extends ZuulFilter {

	//private static Logger logger = LoggerFactory.getLogger(Filter.class);

	@Autowired
	private CacheUtil cacheUtil;

	/**
	 * 定义filter的类型，有pre、route、post、error四种
	 */
	@Override
	public String filterType() {
		return "pre";// 前置过滤器
	}

	/**
	 * 定义filter的顺序，数字越小表示顺序越高，越先执行
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/**
	 * 表示是否需要执行该filter，true表示执行，false表示不执行
	 */
	@Override
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		// 登录接口无需校验权限，一律放行
		if (request.getRequestURI().contains("/auth/user/login")
				|| request.getRequestURI().contains("/uploadFile/default/")
				|| request.getRequestURI().contains("/importTemplate/")) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * filter需要执行的具体操作
	 */
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String uri = request.getRequestURI();
		String token = request.getHeader("token");
		
		
		//app后台直接调用，无需token直接放行
		String pattern = ".*_notToken$";
		boolean isMatch = Pattern.matches(pattern, uri);
		

		// 判断token是否过期及解析token给request设置请求用户的基本信息，判断该用户是否拥有该uri的访问权限
		if (isMatch) {// 判断token是否为空
			ctx.setSendZuulResponse(true);
			ctx.setResponseStatusCode(200);
			ctx.set("isSuccess", true);

		} else if (null == token || token.equals("")) {// 判断token是否为空
			 ctx.setSendZuulResponse(false);
			 ctx.setResponseStatusCode(301);
			 ctx.setResponseBody("{\"code\":\"301\" , \"message\":\"token is null !\"}");
			 ctx.set("isSuccess", false);

		} else if (!cacheUtil.exists(token)) {// 判断token是否存在
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(303);
			ctx.setResponseBody("{\"code\":\"303\" , \"message\":\"token is not exists !\"}");
			ctx.set("isSuccess", false);

		} else if (isOrNotExpired(token)) {// 判断token是否过期
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(305);
			ctx.setResponseBody("{\"code\":\"305\" , \"message\":\"token is expired !\"}");
			ctx.set("isSuccess", false);

		} else if (!deParseToken(token, uri)) {// 判断token是否可解析
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(306);
			ctx.setResponseBody("{\"code\":\"306\" , \"message\":\"Request illegal !\"}");
			ctx.set("isSuccess", false);

		} else {
			ctx.setSendZuulResponse(true);
			ctx.setResponseStatusCode(200);
			ctx.set("isSuccess", true);
		}

		return null;
	}

	/**
	 * 判断token是否过期
	 * 
	 * @param token
	 * @return boolean
	 */
	private boolean isOrNotExpired(String token) {
		Boolean isOrNotExpired = false;
		Long time = cacheUtil.getExpired(token);
		if (time > 0 && time <= 20) {
			isOrNotExpired = false;
			cacheUtil.set(token, StringUtils.TOKEN_MAXAGE, StringUtils.TOKEN_MAXAGE);
		} else if (time > 20) {
			isOrNotExpired = false;
		} else {
			isOrNotExpired = true;
		}

		return isOrNotExpired;
	}

	/**
	 * 解析token给request设置请求用户的基本信息，判断该用户是否拥有该uri的访问权限
	 * 
	 * @param token
	 * @param uri
	 * @return boolean
	 */
	private boolean deParseToken(String token, String uri) {

		Boolean auth = false;

		String roleName = "";

		TokenModel entity = Signature.unsign(token, TokenModel.class);

		RequestContext ctx = RequestContext.getCurrentContext();
		//HttpServletRequest request = ctx.getRequest();

		Map<String, List<String>> qp = new HashMap<String, List<String>>();
		List<String> userIdList = new ArrayList<String>();
		List<String> roleList = new ArrayList<String>();
		List<String> customerIdList = new ArrayList<String>();
		List<String> userNameList = new ArrayList<String>();
		List<String> userTypeList = new ArrayList<String>();
		List<String> orgIdList = new ArrayList<String>();
		List<String> unitIdList = new ArrayList<String>();
		List<String> monitorIdList = new ArrayList<String>();
		List<String> fireBrigadeIdList = new ArrayList<String>();

		userIdList.add("" + entity.getUserId());
		userNameList.add("" + entity.getUserName());
		userTypeList.add("" + entity.getUserType());
		customerIdList.add("" + entity.getCustomerId());
		unitIdList.add("" + entity.getUnitId());

		if (entity.getMonitorId() != 0) {
			monitorIdList.add("" + entity.getMonitorId());
		}
		if (entity.getFireBrigadeId() != 0) {
			fireBrigadeIdList.add("" + entity.getFireBrigadeId());
		}

		if (entity.getRoles() != null) {
			for (int i = 0; i < entity.getRoles().size(); i++) {
				roleName += entity.getRoles().get(i) + ",";
			}
			roleList.add(roleName.substring(0, roleName.length() - 1));
		}

		String pattern = ".*_notCheck$";
		String pattern2 = ".*/list$";

		boolean isMatch = Pattern.matches(pattern, uri);
		boolean isMatch2 = Pattern.matches(pattern2, uri);
		boolean isMatch3 = uri.contains("/fastwave-service-app/");
		boolean isMatch4 = uri.contains("/fastwave-service-website/");

		if (entity.getUserType() == Constant.USER_TYPE_ADMIN || entity.getUserType() == Constant.USER_TYPE_SUPER) {
			auth = true;
		} else if (isMatch || isMatch2 || isMatch3 || isMatch4) {
			auth = true;
		} else {
			for (int i = 0; i < entity.getRoles().size(); i++) {
				@SuppressWarnings("unchecked")
				HashMap<String, Boolean> authMap = (HashMap<String, Boolean>) cacheUtil.get(StringUtils.REDIS_ROLE + entity.getRoles().get(i));
				System.out.println(authMap);
				if (subStrCount(uri, "-") > 2) {
					String uri2 = uri.substring(0, uri.lastIndexOf("-"));
					String uri3 = uri.substring(uri.indexOf("/", 1));
					uri = uri2 + uri3;
				}

				if (auth = authMap.containsKey(uri) == true) {
					break;
				}
			}
		}

		String orgIdString = "";
		if (entity.getOrgId() != null) {
			for (int i = 0; i < entity.getOrgId().size(); i++) {
				// orgIdList.add(entity.getOrgId().get(i).toString());
				orgIdString += entity.getOrgId().get(i).toString() + ",";
			}
		}
		orgIdList.add(orgIdString);

		qp.put("userId", userIdList);
		qp.put("roleNameList", roleList);
		qp.put("customerId", customerIdList);
		qp.put("userName", userNameList);
		qp.put("userType", userTypeList);
		qp.put("orgIdList", orgIdList);
		qp.put("unitId", unitIdList);
		qp.put("monitorId", monitorIdList);
		qp.put("fireBrigadeId", fireBrigadeIdList);

		ctx.setRequestQueryParams(qp);

		return auth;
	}

	private int subStrCount(String string, String substr) {
		int i = string.length() - string.replace(substr, "").length();
		return i;
	}
}