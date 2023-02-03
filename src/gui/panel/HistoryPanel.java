package gui.panel;

import util.GuiUtil;

/**
 * @author zane
 * @date 2023-01-29-16:34
 * 界面类HistoryPanel历史消费页
 * 调用了MonthPickerPanel 和HistoryListPanel两个子面板
 *
 */
public class HistoryPanel extends WorkingPanel{
    static {
        GuiUtil.setLookAndFeel();
    }
    public static HistoryPanel instance = new HistoryPanel();

    @Override
    public void updateData() {

    }

    @Override
    public void addListener() {

    }
}
