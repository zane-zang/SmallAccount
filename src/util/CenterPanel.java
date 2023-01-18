package util;

import gui.panel.WorkingPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author zane
 * @date 2023-01-18-11:06
 * CenterPanel
 */
public class CenterPanel extends JPanel {
    private double rate;
    private JComponent jc;
    private boolean stretchflag;

    /**
     * @param rate         rate of stretch
     * @param stretchflag
     */

    public CenterPanel(double rate, boolean stretchflag) {
        this.setLayout(null);
        this.rate = rate;
        this.stretchflag = stretchflag;
    }

    public CenterPanel(double rate) {
        this(rate, true);
    }


    /**
     * Using this method(repaint) to refresh the page.
     */
    public void repaint() {
        if ( jc != null) {
            Dimension containerSize = this.getSize();
            Dimension componentSize = jc.getPreferredSize();

            if (stretchflag) {
                jc.setSize((int) (containerSize.width * rate),
                        (int) (containerSize.height * rate));
            } else {
                jc.setSize(componentSize);
            }
            //reset the location and set it in the center
            jc.setLocation(containerSize.width / 2 - jc.getSize().width / 2,
                    containerSize.height / 2 - jc.getSize().height / 2);
        }

        //
        super.repaint();

    }

    /**
     * Using method(show) to show the panel new from CenterPanel in the center.
     * @param panel
     */
    public void show(JComponent panel) {
        this.jc = panel;
        //get all the child panels of this panel
        Component[] cs = this.getComponents();
        //remove all
        for (Component c : cs) {
            remove(c);
        }

        this.add(panel);

        //If panel is the instance of WorkingPanel, call the updateData method.
        if ((panel instanceof WorkingPanel)) {
            ((WorkingPanel) panel).updateData();
        }
        this.updateUI();

    }

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(400,400);
        jf.setLocationRelativeTo(null);
        CenterPanel cp = new CenterPanel(0.8);
        jf.setContentPane(cp);
        jf.setDefaultCloseOperation(3);
        jf.setVisible(true);
        JButton jb = new JButton("Love");
        cp.show(jb);
    }

}
