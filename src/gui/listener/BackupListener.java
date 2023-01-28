package gui.listener;

import gui.panel.BackupPanel;
import util.SQLUtil;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @author zane
 * @date 2023-01-28-9:52
 */
public class BackupListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        BackupPanel backuppanel = BackupPanel.instance;
        JFileChooser jfc = new JFileChooser();
        jfc.setSelectedFile(new File("xiaoxiao.db"));

        jfc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".db");
            }

            @Override
            public String getDescription() {
                return ".db";
            }
        });

        int returnVal = jfc.showSaveDialog(backuppanel);
        File file = jfc.getSelectedFile();

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println(file);
            if (!file.getName().toLowerCase().endsWith(".db")) {
                file = new File(file.getParent(), file.getName() + ".db");
            }
            System.out.println(file);

            try {
                SQLUtil.backup(file.getAbsolutePath());
                JOptionPane.showMessageDialog(backuppanel, "备份成功，备份文件位于：\r\n" + file.getAbsolutePath());
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(backuppanel, "备份失败\r\n, 错误：\r\n" + e1.getMessage());
            }
        }
    }
}
