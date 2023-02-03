package service;

import dao.RecordDAO;
import entity.Record;
import util.DateUtil;

import java.util.Date;
import java.util.List;

/**
 * @author zane
 * @date 2023-01-29-10:01
 */
public class RecordService {
    private static RecordDAO recordDAO = new RecordDAO();

    public void add(int spend, int categoryId, String comment, Date date) {
        Record record = new Record();
        record.setSpend(spend);
        record.setCategoryId(categoryId);
        record.setComment(comment);
        record.setDate(date);
        recordDAO.add(record);
    }

    public void update(int id, int spend, int categoryId, String comment, Date date) {
        Record record = new Record();
        record.setId(id);
        record.setSpend(spend);
        record.setCategoryId(categoryId);
        record.setComment(comment);
        record.setDate(date);
        recordDAO.update(record);
    }

    public void delete(int id) {
        recordDAO.delete(id);
    }

    /**
     * 获取指定月的record数据
     * @param startDay 指定月的第一天
     * @return record 的列表
     */

    public List<Record> listMonth(Date startDay) {
        Date endDay = DateUtil.monthEnd(startDay);
        return recordDAO.list(startDay, endDay);
    }
}
