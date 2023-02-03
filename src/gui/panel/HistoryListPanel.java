package gui.panel;

import util.GuiUtil;

/**
 * @author zane
 * @date 2023-01-29-16:30
 * HistoryListPanel是HistoryPanel中的历史记录面板
 */
public class HistoryListPanel extends WorkingPanel {
    static {
        GuiUtil.setLookAndFeel();
    }

    public static HistoryListPanel instance = new HistoryListPanel();
    @Override
    public void updateData() {

    }

    @Override
    public void addListener() {

    }
}
