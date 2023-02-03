package gui.page;

import java.lang.reflect.Parameter;

/**
 * @author zane
 * @date 2023-01-29-14:03
 * SpendPanel的页面类，用来转载所有的数据
 */
public class SpendPage {
    public String monthSpend;
    public String todaySpend;
    public String avgSpendOfDays;
    public String monthSpendAvailable;
    public String avgDaySpendAvailable;
    public String monthLeftDay;
    public int usagePercentage;
    public boolean OverSpend = false;

    public SpendPage(int monthSpend, int todaySpend, int avgSpendOfDays,
                     int monthSpendAvailable, int avgDaySpendAvailable, int monthLeftDay,
                     int usagePercentage) {
        this.monthSpend = String.valueOf(monthSpend);
        this.todaySpend = String.valueOf(todaySpend);
        this.avgSpendOfDays = String.valueOf(avgSpendOfDays);

        if(monthSpendAvailable < 0) {
            OverSpend = true;
        }
        if(OverSpend) {
            this.monthSpendAvailable = String.valueOf(monthSpendAvailable);
            this.avgDaySpendAvailable = String.valueOf(avgDaySpendAvailable);
        } else {
            this.monthSpendAvailable = String.valueOf(-monthSpendAvailable);
            this.avgDaySpendAvailable = "0";
        }

        this.monthLeftDay = String.valueOf(monthLeftDay);
        this.usagePercentage = usagePercentage;

    }
}
