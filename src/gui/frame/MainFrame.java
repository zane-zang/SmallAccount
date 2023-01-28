package gui.frame;

import util.GuiUtil;

import javax.swing.*;

/**
 * @author zane
 * @date 2023-01-18-9:42
 *
 * 程序主窗体
 * 设置窗体的长宽、标题和退出等操作
 */
public class MainFrame extends JFrame {
    static {
        GuiUtil.setLookAndFeel();
    }
    public static MainFrame instance = new MainFrame();

    private MainFrame() {
        this.setSize(520,450);
        this.setTitle("Small Account");
        this.setContentPane(MainFrame.instance);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//3
    }

    public static void main(String[] args) {
        instance.setVisible(true);
    }
}
