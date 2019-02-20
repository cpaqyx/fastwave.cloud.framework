package fastwave.lib.common.entity;

public class DictTypeEntity {
	
	    //类型
		 Long value;
		//描述
	    String title;
	    
	    Long parentId;
	    
	    String type;
	    
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public Long getParentId() {
			return parentId;
		}
		public void setParentId(Long parentId) {
			this.parentId = parentId;
		}
		public Long getValue() {
			return value;
		}
		public void setValue(Long value) {
			this.value = value;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
	    
		
	    
		
}
