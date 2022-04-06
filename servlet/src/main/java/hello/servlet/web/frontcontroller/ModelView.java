package hello.servlet.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;

public class ModelView {
    private String viewName;
    private Map<String, Object> model = new HashMap<>(); // 실제로는 동시성을 고려해서 ConcurrentHashMap을 사용해야 한다는 것을 잊어서는 안 된다.

    public ModelView(String viewPath) {
        this.viewName = viewPath;
    }

    public String getViewName() {
        return this.viewName;
    }

    public void setViewName(String viewPath) {
        this.viewName = viewPath;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
