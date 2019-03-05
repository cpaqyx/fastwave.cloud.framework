package fastwave.service.auth.user.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fastwave.lib.common.jwt.Signature;
import fastwave.lib.common.jwt.TokenModel;
import fastwave.lib.common.utils.PasswordEncoder;
import fastwave.lib.common.utils.StringUtils;
import fastwave.lib.common.web.R;
import fastwave.service.auth.user.entity.Customer;
import fastwave.service.auth.user.entity.Org;
import fastwave.service.auth.user.entity.User;
import fastwave.service.auth.user.entity.UserRole;
import fastwave.service.auth.user.service.CustomerService;
import fastwave.service.auth.user.service.OrgService;
import fastwave.service.auth.user.service.UserRoleService;
import fastwave.service.auth.user.service.UserService;
import fastwave.service.auth.util.CacheUtil;

@RestController
@RequestMapping(value = { "/auth/user" }, produces = "application/json;charset=UTF-8")
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRoleService userRoleService;

	@Autowired
	private OrgService orgService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CacheUtil cacheUtil;

	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody Map<String, Object> params) {
		// 1.验证接收到的参数
		if (params.get("useraccount") == null && params.get("password") == null) {
			return R.error(302, "用户名密码为空，请重新输入！"); // to do 中文用指定的标识符号代表
		}
		// 2.数据库中验证，用户名密码是否正确
		String useraccount = params.get("useraccount").toString();
		String password = params.get("password").toString();

		String encPassword = PasswordEncoder.getEncPasswordAndSalt(useraccount, password);
		// 3.验证用户名密码是否正确
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("userAccount", useraccount);
		userMap.put("userPassword", encPassword); // to do 密码MD5散列值计算
		List<User> userList = userService.list(userMap);

		if (userList == null || userList.size() == 0) {
			return R.error(302, "用户名或密码不正确，请重新输入！");
		}

		// 4.构建用户token对象，即JWT的载体部分（PAYLOAD）
		TokenModel payload = new TokenModel();
		User user = userList.get(0);
		if (user.getUserType() == 1) {
			Map<String, Object> usersMap = new HashMap<String, Object>();
			usersMap.put("customerId", user.getCustomerId());
			Map<String, Object> customerCoordinate = userService.getCustomerCoordinate(usersMap);
			if (customerCoordinate != null && customerCoordinate.get("coordinate") != null) {
				user.setCustomerCoordinate(String.valueOf(customerCoordinate.get("coordinate")));
			}
		}
		Long userId = user.getId();
		Long monitorId = 0L, fireBrigadeId = 0L;
		if (user.getMonitorId() != null) {
			monitorId = user.getMonitorId();
		}
		if (user.getFireBrigadeId() != null) {
			fireBrigadeId = user.getFireBrigadeId();
		}

		// 4.1设置用户基本信息
		payload.setUserId(userId);
		payload.setCustomerId(user.getCustomerId());
		payload.setUserName(user.getUserName());
		payload.setUserType(user.getUserType());
		payload.setMonitorId(monitorId);
		payload.setFireBrigadeId(fireBrigadeId);

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String timestamp = df.format(new Date());
		payload.setTimestamp(timestamp);

		// 4.2设置角色基本信息
		Map<String, Object> roleMap = new HashMap<String, Object>();
		roleMap.put("userId", userId);
		List<UserRole> roles = userRoleService.list(roleMap);
		if (roles != null && roles.size() > 0) {
			List<Long> roleList = new ArrayList<Long>();
			for (UserRole role : roles) {
				roleList.add(role.getRoleId());
			}
			payload.setRoles(roleList);
		}

		if (monitorId != 0) {
			// 4.3设置单位组织信息
			Map<String, Object> orgCodeMap = new HashMap<String, Object>();
			orgCodeMap.put("monitorId", monitorId);
			List<Org> userOrgs = orgService.listOrgByMonitorId(monitorId);
			if (userOrgs != null && userOrgs.size() > 0) {
				List<Long> orgIdList = new ArrayList<Long>();
				for (Org org : userOrgs) {
					orgIdList.add(org.getId());
				}
				payload.setOrgId(orgIdList);
			}
		}

		// 4.2设置客户基本信息
		roleMap.put("id", user.getCustomerId());
		Customer customer = customerService.get(roleMap);

		// 5 签名类加密负载信息
		String token = Signature.sign(payload);
		if (token == null) {
			return R.error(301, "生成token失败");
		}

		// 5.1 将token加载到缓存中
		try {
			cacheUtil.set(token, StringUtils.TOKEN_MAXAGE, StringUtils.TOKEN_MAXAGE);
		} catch (Exception eee) {
			return R.error(305, "加载缓存失敗！");
		}

		// 6组装返回TOKEN
		HashMap<String, Object> tokenMap = new HashMap<String, Object>();
		tokenMap.put("code", 200);
		tokenMap.put("message", "生成token成功");
		user.setUserPassword("");
		tokenMap.put("user", user);
		tokenMap.put("customer", customer);
		tokenMap.put("token", token);

		// 7.test
		// TokenModel entity = Signature.unsign(token, TokenModel.class);
		
		return tokenMap;
	}

	@PostMapping("/logout")
	public R logout(@RequestBody Map<String, Object> params) {
		// 1.验证接收到的参数
		if (params.get("token") == null || params.get("token").equals("")) {
			return R.error("token为空，无法注销！"); // to do 中文用指定的标识符号代表
		}

		// 2.移除token,注销用户登录
		try {
			String token = params.get("token").toString();
			cacheUtil.remove(token);
		} catch (Exception ee) {
			return R.error("清除失败！");
		}

		return R.ok("注销成功！");

	}
}