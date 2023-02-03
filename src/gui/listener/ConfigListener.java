package gui.listener;

import com.sun.corba.se.impl.orb.ORBConfiguratorImpl;
import gui.panel.ConfigPanel;
import service.ConfigService;
import util.GuiUtil;
import util.SQLUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author zane
 * @date 2023-01-29-15:16
 * ConfigPanel的监听器
 */
public class ConfigListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        ConfigPanel configPanel = ConfigPanel.instance;
        if (configPanel == e.getSource()) {
            if (!GuiUtil.checkNumber(configPanel.textFieldBudget, "本月预算")) {
                return;
            }
            ConfigService configService = new ConfigService();
            //改操作
            configService.update(ConfigService.budget, configPanel.textFieldBudget.getText());
            JOptionPane.showMessageDialog(configPanel, "设置成功");
        }

        if (configPanel.buttonTruncate == e.getSource()) {
            if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(configPanel, "确认清空所有数据？")) {
                return;
            }
            SQLUtil.truncate();
            //重新初始化数据库
            ConfigService.init();
            JOptionPane.showMessageDialog(configPanel, "重置成功");
        }
    }
}
