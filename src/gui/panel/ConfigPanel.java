package gui.panel;

import gui.listener.ConfigListener;
import service.ConfigService;
import util.ColorUtil;
import util.GuiUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @author zane
 * @date 2023-01-28-14:01
 * 界面类 ConfigPanel设置页
 */
public class ConfigPanel extends WorkingPanel{
    static {
        GuiUtil.setLookAndFeel();
    }
    public static ConfigPanel instance = new ConfigPanel();

    private JLabel labelBudget = new JLabel("本月预算");
    public JTextField textFieldBudget = new JTextField();
    public JButton buttonTruncate = new JButton("重置数据库");
    public JButton buttonSubmit = new JButton("提交");

    public ConfigPanel() {
        GuiUtil.setColor(ColorUtil.grayColor, labelBudget);
        GuiUtil.setColor(ColorUtil.blueColor, buttonSubmit);

        JPanel panelNorth = new JPanel();
        JPanel panelSouth = new JPanel();
        int gap = 40;
        panelNorth.setLayout(new GridLayout(3, 1, gap, gap));
        panelNorth.add(labelBudget);
        panelNorth.add(textFieldBudget);
        panelNorth.add(buttonSubmit);
        this.setLayout(new BorderLayout());
        this.add(panelNorth, BorderLayout.NORTH);

        panelSouth.add(buttonTruncate);
        this.add(panelSouth, BorderLayout.SOUTH);

        addListener();
    }

    public static void main(String[] args) {
        GuiUtil.showPanel(ConfigPanel.instance);
    }

    @Override
    public void updateData() {
        ConfigService configService = new ConfigService();
        textFieldBudget.setText(configService.get(ConfigService.budget));
        textFieldBudget.grabFocus();

    }

    @Override
    public void addListener() {
        ConfigListener configListener = new ConfigListener();
        buttonSubmit.addActionListener(configListener);
        buttonTruncate.addActionListener(configListener);

    }

}
