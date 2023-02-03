package gui.panel;

import util.DateUtil;
import util.GuiUtil;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * @author zane
 * @date 2023-01-29-16:41
 * MonthPickerPanel是HistoryPanel中的月份选择器
 * 通过调用MonthPickerPanel.instance.date来获取选择的时间
 *
 */
public class MonthPickerPanel extends WorkingPanel {
    static {
        GuiUtil.setLookAndFeel();
    }
    public static MonthPickerPanel instance = new MonthPickerPanel();

    //写死起始年份
    private final int startYear = 2022;
    //当前面板实例的时间
    public Date date = DateUtil.monthBegin();
    public JComboBox<Integer> comboBoxMonth = new JComboBox<>(makeMonths());
    public JComboBox<Integer> comboBoxYear = new JComboBox<>(makeYears());
    private JButton buttonSubmit = new JButton("查询");

    private MonthPickerPanel() {
        this.setLayout(new GridLayout(1, 3, 8,0));
    }

    @Override
    public void updateData() {

    }

    @Override
    public void addListener() {

    }
}
