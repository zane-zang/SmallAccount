package gui.listener;

import gui.panel.BackupPanel;
import gui.panel.MainPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author zane
 * @date 2023-01-18-16:27
 */
public class ToolBarListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        MainPanel mainpanel = MainPanel.instance;
        JButton jbutton = (JButton) e.getSource();
        if (jbutton == mainpanel.jbBackup) {
            mainpanel.workingPanel.show(BackupPanel.instance);
        }

    }
}
