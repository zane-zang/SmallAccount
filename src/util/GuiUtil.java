package util;

import javax.swing.*;
import java.awt.*;
import java.io.File;


/**
 * @author zane
 * @date 2023-01-18-9:46
 *
 * GUI Util
 *
 */
public class GuiUtil {
    //Image file
    private static final String imgFolder = "resource/img/";

    //Look and feel
    public static void setLookAndFeel(){
        try {
            javax.swing.UIManager.setLookAndFeel("com.pagosoft.plaf.PgsLookAndFell");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param textField
     * @param textName
     *
     */
    public static boolean checkNumber(JTextField textField, String textName) {
        String text = textField.getText().trim();
        if (text.length() <= 0) {
            JOptionPane.showMessageDialog(null, "The input is invalid, please try again.");
            //set focus in text to re-input
            textField.grabFocus();
            return false;
        }
        try {
            Integer.parseInt(text);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The input is invalid " + textName + " is not numbers.");
            textField.grabFocus();
            return false;
        }
        return true;


    }

    /**
     * @param panel
     * @param stretchrate
     */

    public static void showPanel(JPanel panel, double stretchrate) {
        GuiUtil.setLookAndFeel();
        JFrame jf = new JFrame();
        //if the comment is null, set the panel to center
        jf.setLocationRelativeTo(null);
        jf.setSize(500,500);
        CenterPanel centerpanel = new CenterPanel(stretchrate);
        jf.setContentPane(centerpanel);
        jf.setDefaultCloseOperation(3);
        jf.setVisible(true);
        centerpanel.show(panel);
    }

    public static void showPanel(JPanel panel) {
        showPanel(panel, 0.85);
    }

    /**
     * Set a button with image and text
     *
     * @param button
     * @param imgName
     * @param buttonText
     */

    public static void setImageIcon(JButton button,String imgName,String buttonText) {
        ImageIcon i = new ImageIcon((new File(imgFolder, imgName)).getAbsolutePath());
        button.setIcon(i);
        button.setPreferredSize(new Dimension(61,81));
        button.setToolTipText(buttonText);
        button.setVerticalTextPosition(JButton.BOTTOM);//3
        button.setHorizontalTextPosition(JButton.CENTER);//0
        button.setText(buttonText);
    }

    /**
     * Set colors of Component
     *
     * @param color
     * @param component
     */
    //JComponent... a list of JComponent
    public static void setColor(Color color, JComponent... component) {
        for (JComponent cs : component) {
            cs.setForeground(color);
        }
    }
}
