package fastwave.lib.common.web;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询参数
 */
public class Query extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	// 默认分页参数
	private static final int PAGESIZE = 10;

	// 跳过多少条
	private int offset;
	// 每页条数
	private int limit;

	public Query(Map<String, Object> params) {
		// 1.加入所有参数到参数集中，将传递到数据库访问存作为sql的条件参数
		this.putAll(params);

		// 2.判断参数来构建出分页参数，有三种可能性，详见2.1、2.2、2.3
		// 2.1传入的是:当前页号(pageIndex)、每页记录数（pageSize）
		if (params.get("page") != null && params.get("pagesize") != null) {
			int pageIndex = Integer.parseInt(params.get("page").toString());
			int pageSize = Integer.parseInt(params.get("pagesize").toString());
			this.offset = (pageIndex - 1) * pageSize;
			this.limit = pageSize;
		}
		// 2.2如果分页参数为空，则默认返回第一页，记录数量为10
		else if (params.get("page") == null && params.get("offset") == null) {
			this.offset = 0;
			this.limit = PAGESIZE;
		}
		// 2.2如果分页参数为空，则默认返回第一页，记录数量为10
		else if (params.get("offset") != null && params.get("limit") != null) {
			this.offset = Integer.parseInt(params.get("offset").toString());
			this.limit = Integer.parseInt(params.get("limit").toString());
		}
 		// 3.设置分页参数
		this.put("offset", this.offset);
		this.put("page", this.offset / this.limit + 1);
		this.put("limit", this.limit);
		
		// 4.
		this.put("dataGroupCond", "");
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.put("offset", offset);
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
}
