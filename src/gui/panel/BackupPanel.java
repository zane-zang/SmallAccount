package gui.panel;

import gui.listener.BackupListener;
import util.ColorUtil;
import util.GuiUtil;

import javax.swing.*;

/**
 * @author zane
 * @date 2023-01-28-9:34
 */
public class BackupPanel extends WorkingPanel{
    static {
        GuiUtil.setLookAndFeel();
    }
    public static BackupPanel instance = new BackupPanel();
    private JButton jbBackup = new JButton("备份");

    public BackupPanel() {
        GuiUtil.setColor(ColorUtil.blueColor, jbBackup);
        this.add(jbBackup);
        addListener();
    }
    public static void main(String[] args) {
        GuiUtil.showPanel(BackupPanel.instance);
    }

    @Override
    public void updateData() {

    }

    @Override
    public void addListener() {
        BackupListener backupListener = new BackupListener();
        jbBackup.addActionListener(backupListener);

    }
}
