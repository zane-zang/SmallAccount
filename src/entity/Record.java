package entity;

import java.util.Date;

/**
 * @author zane
 * @date 2023-01-28-14:09
 * 实体类 Record
 */
public class Record {
    private int id;
    private int spend;
    private int categoryId;
    private String comment;
    private Date date;

    public Record() {

    }
    public Record(int id, int spend, int categoryId, String comment, Date date) {
        this.id = id;
        this.spend = spend;
        this.categoryId = categoryId;
        this.comment = comment;
        this.date = date;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getSpend() {
        return spend;
    }
    public void setSpend(int spend) {
        this.spend = spend;
    }

    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
