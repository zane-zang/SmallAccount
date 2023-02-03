package gui.panel;

import service.RecordService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author zane
 * @date 2023-01-29-16:14
 * HistoryListPanel的监听器，监听按钮后进行record的删除操作，增改操作由RecordPanel完成
 */
public class HistoryListListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        RecordService recordService = new RecordService();
        HistoryListPanel historyListPanel = HistoryListPanel.instance;
    }
}
