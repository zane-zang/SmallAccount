package util;

import javax.swing.*;


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
     * @param stretch
     */

    public static void showPanel(JPanel panel, double stretch) {
        GuiUtil.setLookAndFeel();
        JFrame frame = new JFrame();
        //if the comment is null, set the panel to center
        frame.setLocationRelativeTo(null);
        frame.setSize(500,500);
//        CenterPanel centerpanel = new CenterPanel(stretch);
    }

}
