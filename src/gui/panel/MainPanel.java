package gui.panel;

import gui.listener.ToolBarListener;
import util.CenterPanel;
import util.GuiUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @author zane
 * @date 2023-01-18-15:53
 *
 * MainPanel
 *
 *
 * @see util.CenterPanel
 */
public class MainPanel extends JPanel {
    static {
        GuiUtil.setLookAndFeel();
    }

    public static MainPanel mainpanel = new MainPanel();
    private JToolBar toolbar = new JToolBar();
    public JButton jbSpend = new JButton();
    public JButton jbRecord = new JButton();
    public JButton jbHistory = new JButton();
    public JButton jbCategory = new JButton();
    public JButton jbReport = new JButton();
    public JButton jbConfig = new JButton();
    public JButton jbBackup = new JButton();
    public JButton jbRecover = new JButton();
    public CenterPanel workingPanel;

    private MainPanel(){
        GuiUtil.setImageIcon(jbSpend, "home.png","本月一栏");
        GuiUtil.setImageIcon(jbRecord, "record.png", "记一笔");
        GuiUtil.setImageIcon(jbRecover, "restore.png", "恢复");
        GuiUtil.setImageIcon(jbReport, "report.png", "月消费报表");
        GuiUtil.setImageIcon(jbHistory, "history.png", "历史消费");
        GuiUtil.setImageIcon(jbCategory, "category.png", "消费分类");
        GuiUtil.setImageIcon(jbBackup, "backup.png", "备份");
        GuiUtil.setImageIcon(jbConfig, "config.png", "设置");

        toolbar.add(jbSpend);
        toolbar.add(jbReport);
        toolbar.add(jbRecover);
        toolbar.add(jbRecord);
        toolbar.add(jbBackup);
        toolbar.add(jbCategory);
        toolbar.add(jbConfig);
        toolbar.add(jbHistory);
        toolbar.setFloatable(false);

        workingPanel = new CenterPanel(0.85);

        this.setLayout(new BorderLayout());
        this.add(toolbar, BorderLayout.NORTH);
        this.add(workingPanel, BorderLayout.CENTER);

        addListeners();
    }

    private void addListeners(){
        ToolBarListener listener = new ToolBarListener();
        jbSpend.addActionListener(listener);
        jbHistory.addActionListener(listener);
        jbCategory.addActionListener(listener);
        jbConfig.addActionListener(listener);
        jbRecord.addActionListener(listener);
        jbRecover.addActionListener(listener);
        jbReport.addActionListener(listener);
        jbBackup.addActionListener(listener);
    }

    public static void main(String[] args) {
        GuiUtil.showPanel(MainPanel.mainpanel,0.85);
    }

}
