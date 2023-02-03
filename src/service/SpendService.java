package service;

import dao.RecordDAO;
import entity.Record;
import gui.page.SpendPage;
import util.DateUtil;

import java.util.List;

/**
 * @author zane
 * @date 2023-01-29-14:01
 * 业务类 SpendService 对多个数据库的业务进行封装，提供接口给SpendPanel使用
 */
public class SpendService {
    public SpendPage getSpendPage() {
        RecordDAO recordDAO = new RecordDAO();
        List<Record> monthRecordList = recordDAO.monthList();
        List<Record> todayRecordList = recordDAO.todayList();
        int monthTotalDays = DateUtil.thisMonthTotalDay();

        int monthSpend = 0;
        int todaySpend = 0;
        int avgSpendOfDays = 0;
        int monthSpendAvailable = 0;
        int avgDaySpendAvailable = 0;
        int monthLeftDay = 0;
        int usagePercentage = 0;
        int monthBudget = new ConfigService().getIntBudget();

        for (Record r : monthRecordList) {
            monthSpend += r.getSpend();
        }
        for (Record r : todayRecordList) {
            todaySpend += r.getSpend();
        }
        avgSpendOfDays = monthSpend / monthTotalDays;
        monthSpendAvailable = monthBudget - monthSpend;
        monthLeftDay = DateUtil.thisMonthLeftDay();
        avgDaySpendAvailable = monthSpendAvailable / monthLeftDay;
        usagePercentage = monthSpend * 100 / monthBudget;

        return new SpendPage(monthSpend, todaySpend, avgSpendOfDays, monthSpendAvailable,
                avgDaySpendAvailable, monthLeftDay, usagePercentage);

    }
}
