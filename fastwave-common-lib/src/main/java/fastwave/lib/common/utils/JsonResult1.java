package fastwave.lib.common.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fastwave.lib.common.utils.JsonResult1;
import fastwave.lib.common.web.ResponseCode;

public class JsonResult1 extends HashMap<String, Object> implements Serializable {
	private static final long serialVersionUID = 1L;

	public JsonResult1() {
		super();
		put("code", ResponseCode.API_CODE_CALL_SUCCESS);
		put("message", "操作成功");
	}

	public static JsonResult1 error() {
		return error(ResponseCode.API_CODE_CALL_ERROR, "操作失败");
	}

	public static JsonResult1 error(String message) {
		return error(ResponseCode.API_CODE_CALL_ERROR, message);
	}

	public static JsonResult1 error(int code, String message) {
		JsonResult1 r = new JsonResult1();
		r.put("code", code);
		r.put("message", message);
		return r;
	}

	public static JsonResult1 error(int code) {
		JsonResult1 r = new JsonResult1();
		r.put("code", code);
		r.put("message", "");
		return r;
	}

	public static JsonResult1 ok(String message) {
		JsonResult1 r = new JsonResult1();
		r.put("message", message);
		return r;
	}

	public static JsonResult1 ok(Map<String, Object> map) {
		JsonResult1 r = new JsonResult1();
		r.putAll(map);
		return r;
	}

	public static JsonResult1 ok() {
		return new JsonResult1();
	}

	@Override
	public JsonResult1 put(String key, Object value) {
		super.put(key, value);
		return this;
	}
	
	public static JsonResult1 buildEmptyR(String message) {
		JsonResult1 r = new JsonResult1();
		r.put("code", ResponseCode.API_CODE_CALL_ERROR);
		r.put("message", message+"超时，熔断器返回");
		return r;
	}
	
}
