package fastwave.service.admin.common.cache;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fastwave.service.admin.common.util.CacheUtil;
import fastwave.service.admin.config.entity.Dict;
import fastwave.service.admin.config.service.DictService;

@Component
public class DictCache {

	@Autowired
	private CacheUtil cacheUtil;

	@Autowired
	private DictService dictService;

	String KEY_DICT_ALL_ITEMS = "KEY_DICT_ALL_ITEMS";
	
	public String getNameById(String id)
	{
		if(id == null || id.equals(""))
		{
			return "";
		}
		return getNameById(Long.parseLong((id)));
	}
	
	public String getNameById(Integer id)
	{
		if(id == null)
		{
			return "";
		}
		return getNameById(Long.valueOf(id));
	}

	@SuppressWarnings("unchecked")
	public String getNameById(Long id) {
		if (id == null) {
			return "";
		}
		// 1.读取缓存中的字典集合
		HashMap<Long, String> allDictItems = null;
		Object obj = cacheUtil.get(KEY_DICT_ALL_ITEMS);
		if (obj == null) {

			// 从数据库取出来放到缓存中
			List<Dict> list = dictService.list(null);
			allDictItems = new HashMap<Long, String>();
			for (Dict dict : list) {
				allDictItems.put(dict.getId(), dict.getName());
			}

			cacheUtil.set(KEY_DICT_ALL_ITEMS, allDictItems);
		} else {
			allDictItems = (HashMap<Long, String>) obj;
		}

		String title = allDictItems.get(id);

		return title;
	}

}
