package gui.panel;

import javax.swing.*;

/**
 * @author zane
 * @date 2023-01-18-14:26
 */
public abstract class WorkingPanel extends JPanel {
    public abstract void updateData();
    public abstract void addListener();
}
