package gui.panel;

import gui.page.SpendPage;
import service.SpendService;
import util.CircleProgressBar;
import util.ColorUtil;
import util.GuiUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @author zane
 * @date 2023-01-29-16:44
 * 界面类，SpendPanel，本月消费界面
 */
public class SpendPanel extends WorkingPanel {
    static {
        GuiUtil.setLookAndFeel();
    }
    public static SpendPanel instance = new SpendPanel();

    private JLabel labelMonthSpend = new JLabel("本月消费");
    private JLabel labelTodaySpend = new JLabel("今日消费");
    private JLabel labelAvgSpendOfDays = new JLabel("日均消费");
    private JLabel labelMonthSpendAvailable = new JLabel("本月剩余");
    private JLabel labelAvgDaySpendAvailable = new JLabel("日均可用");
    private JLabel labelMonthLeftDay = new JLabel("距离月末");

    private JLabel valueMonthSpend = new JLabel("2300");
    private JLabel valueTodaySpend = new JLabel("30");
    private JLabel valueAvgSpendOfDays = new JLabel("120");
    private JLabel valueMonthSpendAvailable = new JLabel("2000");
    private JLabel valueAvgDaySpendAvailable = new JLabel("200");
    private JLabel valueMonthLeftDay = new JLabel("10天");

    private CircleProgressBar circleProgressBar;

    private SpendPanel() {
        this.setLayout(new BorderLayout());
        circleProgressBar = new CircleProgressBar();
        circleProgressBar.setBackgroundColor(ColorUtil.blueColor);

        GuiUtil.setColor(ColorUtil.grayColor, labelMonthSpend, labelTodaySpend, labelAvgSpendOfDays,
                labelMonthSpendAvailable, labelAvgDaySpendAvailable, labelMonthLeftDay,
                valueAvgDaySpendAvailable, valueMonthSpendAvailable, valueAvgSpendOfDays,
                valueMonthLeftDay);

        GuiUtil.setColor(ColorUtil.blueColor, valueMonthSpend, valueTodaySpend);

        valueMonthSpend.setFont(new Font("微软雅黑", Font.BOLD, 24));
        valueTodaySpend.setFont(new Font("微软雅黑", Font.BOLD, 24));

        this.add(center(), BorderLayout.CENTER);
        this.add(south(), BorderLayout.SOUTH);

    }

    private JPanel center() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(west(), BorderLayout.WEST);
        panel.add(east(), BorderLayout.CENTER);

        return panel;

    }

    private JPanel south() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 4));
        panel.add(labelAvgSpendOfDays);
        panel.add(labelMonthSpendAvailable);
        panel.add(labelAvgDaySpendAvailable);
        panel.add(labelMonthLeftDay);
        panel.add(valueAvgSpendOfDays);
        panel.add(valueMonthSpendAvailable);
        panel.add(valueAvgDaySpendAvailable);
        panel.add(valueMonthLeftDay);

        return panel;

    }

    private JPanel west() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(labelMonthSpend);
        panel.add(valueMonthSpend);
        panel.add(labelTodaySpend);
        panel.add(valueTodaySpend);

        return panel;

    }

    private JPanel east() {
        return circleProgressBar;

    }

    public static void main(String[] args) {
        GuiUtil.showPanel(SpendPanel.instance);
    }

    @Override
    public void updateData() {
        SpendPage spendPage = new SpendService().getSpendPage();
        valueMonthSpend.setText(spendPage.monthSpend);
        valueTodaySpend.setText(spendPage.todaySpend);
        valueAvgSpendOfDays.setText(spendPage.avgSpendOfDays);
        valueAvgDaySpendAvailable.setText(spendPage.avgDaySpendAvailable);
        valueMonthSpendAvailable.setText(spendPage.monthSpendAvailable);
        valueMonthLeftDay.setText(spendPage.monthLeftDay);
        circleProgressBar.setProgress(spendPage.usagePercentage);

        if (spendPage.OverSpend) {
            valueMonthSpendAvailable.setForeground(ColorUtil.warningColor);
            valueMonthSpend.setForeground(ColorUtil.warningColor);
            valueTodaySpend.setForeground(ColorUtil.warningColor);
        } else {
            valueMonthSpendAvailable.setForeground(ColorUtil.grayColor);
            valueMonthSpend.setForeground(ColorUtil.blueColor);
            valueTodaySpend.setForeground(ColorUtil.blueColor);
        }
        circleProgressBar.setForegroundColor(ColorUtil.getByPercentage(spendPage.usagePercentage));
        addListener();

    }

    @Override
    public void addListener() {

    }
}
