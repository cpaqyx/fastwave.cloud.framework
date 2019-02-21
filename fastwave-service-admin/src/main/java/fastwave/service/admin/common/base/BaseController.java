package fastwave.service.admin.common.base;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import fastwave.lib.common.jwt.Signature;
import fastwave.lib.common.jwt.TokenModel;

/**
 * 
 * @ClassName:  BaseController   
 * @Description:base控制器   
 * @author: fastwave
 * @date:   
 */
@RestController
public class BaseController {
	@Autowired 
	public HttpServletRequest request; 
	
	/**
	 * 用户ID
	 * @return 用户ID
	 */
	public Long getUserId() {
		if(request.getParameter("userId") != null)
		{
			return Long.parseLong(request.getParameter("userId"));
		}
		else
		{
			return -1L;
		}
	}

	/**
	 * 用户名称
	 * @return 用户名称
	 */
	public String getUserName() {
		if(request.getParameter("userName") != null)
		{
			return request.getParameter("userName");
		}
		else
		{
			return "none";
		}
	}
	
	/**
	 * 客户标识ID
	 * @return 客户标识ID
	 */
	public Long getCustomerId() {
		if(request.getParameter("customerId") != null)
		{
			return Long.parseLong(request.getParameter("customerId"));
		}
		else
		{
			return -1L;
		}
	}

    /**
     * 用户类型 (0=一般用户，1=分级管理员，2=内置超级管理员)
     * @return 用户类型
     */
    public Integer getUserType() {
        if(request.getParameter("userType") != null)
        {
            return Integer.parseInt(request.getParameter("userType"));
        }
        else
        {
            return -1;
        }
    }
    
    /**
     * 用户角色名（String类型需要使用的自己转换）
     * @return 权限类型
     */
    public String getRoleName() {
		if (request.getParameter("roleNameList") != null) {
			return request.getParameter("roleNameList");
		} else {
			return null;
		}
	}

    /**
	 * 用户单位ID
	 * @return 用户单位ID
	 */
	public String getUnitId() {
		if (request.getParameter("unitId") != null) {
			return request.getParameter("unitId");
		} else {
			return null;
		}
	}
	
	/**
	 * 监控中心ID
	 * @return 监控中心ID
	 */
	public String getMonitorId() {
		if (request.getParameter("monitorId") != null) {
			return request.getParameter("monitorId");
		} else {
			return null;
		}
	}
	
	/**
	 * 组织编码
	 * @return 组织编码
	 */
	public String[] getOrgId() {
		if (request.getParameter("orgIdList") != null) {
			String orgId=request.getParameter("orgIdList");
			return orgId.split(",");
		} else {
			return null;
		}
	}
	
	/**
	 * 视频树监控中心ID
	 * @return 监控中心ID
	 */
	public String getFilterId() {
		if (request.getParameter("filterId") != null) {
			return request.getParameter("filterId");
		} else {
			return null;
		}
	}
	
	/**
	 * 视频树监控中心type
	 * @return 监控中心type
	 */
	public Integer getFilterType() {
		if (request.getParameter("filterType") != null) {
			return Integer.parseInt(request.getParameter("filterType"));
		} else {
			return -1;
		}
	}
	
    /**
     * 用户token
     * @return 用户token
     */
    public TokenModel getUserToken() {
        if(request.getHeader("token") != null)
        {
            TokenModel entity = Signature.unsign(request.getHeader("token"), TokenModel.class);
            return entity;
        }
        else
        {
            return null;
        }
    }

}
