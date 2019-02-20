package fastwave.lib.common.jpush;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sx on 2018/6/27.
 */
public class PushData {

    private String title;

    private String content;

    private Map<String,String> params = new HashMap<>();

    private List<String> registrationId = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public List<String> getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(List<String> registrationId) {
        this.registrationId = registrationId;
    }
}
