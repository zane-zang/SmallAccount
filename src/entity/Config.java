package entity;

/**
 * @author zane
 * @date 2023-01-28-14:08
 * 实体类 Config
 */
public class Config {
    private int id;
    private String key;
    private String value;

    public Config() {

    }

    public Config(int id, String key, String value) {
        this.id = id;
        this.key = key;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}