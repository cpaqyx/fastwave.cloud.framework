package fastwave.service.admin.common.util;

import java.io.Serializable;
import java.util.Date;


/**
 * 简单实体
 * 
 * @author fastwave.developer
 * @date 
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
