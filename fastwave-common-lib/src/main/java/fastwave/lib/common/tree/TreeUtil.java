package fastwave.lib.common.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TreeUtil {

    public static void parseTree(List<Map> maps, List<Map> allList) {
    	if(null == allList || allList.size() == 0)
    	{
    		return;
    	}
        for (Map map : allList) {
            if (Integer.valueOf(map.get("pid").toString()) == 0) {
                maps.add(map);
            }
        }
        for (Map map : maps) {
            getChildren(map, allList);
        }
    }
    
    public static void parseTreeDict(List<Map> maps, List<Map> allList) {
        for (Map map : allList) {
            if (Integer.valueOf(map.get("parent_id").toString()) == 0) {
                maps.add(map);
            }
        }
        for (Map map : maps) {
        	getChildrenDict(map, allList);
        }
    }
    private static void getChildrenDict(Map map, List<Map> allList) {
        List<Map> children = getChildDict(Integer.valueOf(map.get("id").toString()), allList);
        if (children != null && children.size() > 0) {
            map.put("childNode",children);
            for (Map tree2 : children) {
            	getChildrenDict(tree2, allList);
            }
        }
    }
	/*
	 * 子节点本身已有childNode的使用，将子节点本身与已有的childNode合并
	 */
	public static void parseTree2(List<Map> maps, List<Map> allList) {
		for (Map map : allList) {
			if (Integer.valueOf(map.get("pid").toString()) == 0) {
				maps.add(map);
			}
		}
		for (Map map : maps) {
			getChildren2(map, allList);
		}
	}

    private static void getChildren(Map map, List<Map> allList) {
        List<Map> children = getChild(Integer.valueOf(map.get("id").toString()), allList);
        if (children != null && children.size() > 0) {
            map.put("childNode",children);
            for (Map tree2 : children) {
                getChildren(tree2, allList);
            }
        }
    }

	private static void getChildren2(Map map, List<Map> allList) {
		List<Map> children = getChild(Integer.valueOf(map.get("id").toString()), allList);
		if (children != null && children.size() > 0) {
			List<Map> allChildren = (List<Map>)((ArrayList)children).clone() ;
			if(map.get("childNode") != null) {   //节点可能已有childNode，将新的children与已有的childNode合并
				allChildren.addAll((List<Map>)map.get("childNode"));
			}
			map.put("childNode",allChildren);
			for (Map tree2 : children) {
				getChildren2(tree2, allList);
			}
		}
	}

    private static List<Map> getChild(long id, List<Map> allList) {
        List<Map> children = new ArrayList<Map>();
        if (allList != null && allList.size() > 0) {
            for (Map map : allList) {
                if (Integer.valueOf(map.get("pid").toString()) == id) {
                    children.add(map);
                }
            }
        }
        return children;
    }
    
    private static List<Map> getChildDict(long id, List<Map> allList) {
        List<Map> children = new ArrayList<Map>();
        if (allList != null && allList.size() > 0) {
            for (Map map : allList) {
                if (Integer.valueOf(map.get("parent_id").toString()) == id) {
                    children.add(map);
                }
            }
        }
        return children;
    }
}
