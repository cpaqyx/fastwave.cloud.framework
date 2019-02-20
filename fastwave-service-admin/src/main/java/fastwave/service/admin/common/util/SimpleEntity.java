package fastwave.service.admin.common.util;

import java.io.Serializable;
import java.util.Date;


/**
 * 简单实体
 * 
 * @author fastwave.developer
 * @date 2018-05-22 15:42:43
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class SimpleEntity implements Serializable {

	private Long id;

	private String name;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
