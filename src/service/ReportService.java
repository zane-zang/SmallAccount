package service;

import dao.RecordDAO;
import entity.Record;
import util.DateUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author zane
 * @date 2023-01-29-13:46
 * 业务类 ReportService 对 record 数据库的业务进行封装，提供接口给ReportPanel使用
 */
public class ReportService {
    /**
     * @param date 指定的一天
     * @param monthData 这个月的所有数据的，record列表形式
     *
     */

    private int getDaySpend(Date date, List<Record> monthData) {
        int daySpend = 0;
        for (Record r : monthData) {
            if (r.getDate().equals(date)) {
                daySpend += r.getSpend();
            }
        }
        return daySpend;
    }

    public List<Record> MonthRecordList() {
        RecordDAO recordDAO = new RecordDAO();
        List<Record> monthData = recordDAO.monthList();
        List<Record> result = new ArrayList<>();
        Date monthBegin = DateUtil.monthBegin();
        int monthTotalDay = DateUtil.thisMonthTotalDay();
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < monthTotalDay; i++) {
            Record record = new Record();
            calendar.setTime(monthBegin);
            calendar.add(Calendar.DATE, i);
            Date theDayOfThisMonth = calendar.getTime();
            int daySpend = getDaySpend(theDayOfThisMonth,monthData);
            record.setSpend(daySpend);
            result.add(record);

        }
        return result;
    }
}
