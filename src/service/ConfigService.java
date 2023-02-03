package service;

import com.sun.org.apache.xml.internal.security.Init;
import dao.ConfigDAO;
import entity.Config;

/**
 * @author zane
 * @date 2023-01-29-9:49
 */
public class ConfigService {
    public static final String budget = "budget";
    private static final String default_budget = "500";

    private static ConfigDAO configDAO = new ConfigDAO();

    static {
        init();
    }

    //初始化数据库的数据
    public static void init() {
        init(budget, default_budget);
    }
    private static void init(String key, String value) {
        Config config = configDAO.getByKey(key);
        if (config == null) {
            Config c = new Config();
            c.setKey(key);
            c.setValue(value);
            configDAO.add(c);
        }
    }
    public String get(String key) {
        return configDAO.getByKey(key).getValue();
    }
    public void update(String key, String value) {
        Config c = configDAO.getByKey(key);
        c.setValue(value);
        configDAO.update(c);
    }

    public int getIntBudget() {
        return Integer.parseInt(get(budget));
    }
}
