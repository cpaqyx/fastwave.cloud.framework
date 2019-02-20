package fastwave.lib.common.entity;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;



public class CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
    @Override
    public String toString() {
        try {
            Map<String, String> map = BeanUtils.describe(this);
            Iterator<String> iter = map.keySet().iterator();
            StringBuffer result = new StringBuffer("[");
            
            while (iter.hasNext()) {
                Object key = iter.next();
                Object val = map.get(key);
                result.append(key).append(" = ").append(val).append(",");
            }
            
            if (result.length() > 0 && result.lastIndexOf(",") > -1) {
                result.deleteCharAt(result.lastIndexOf(","));
            }
            return result.append("]").toString();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return super.toString();
    }
    
    

}
