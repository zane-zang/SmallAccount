package util;

import javax.swing.*;
import java.awt.*;

/**
 * @author zane
 * @date 2023-01-29-16:45
 * 工具类CircleProgressBar 环形图
 */
public class CircleProgressBar extends JPanel {
    private int minimumProgress;
    private int maximumProgress;
    private int progress;
    private String progressText;
    private Color backgroundColor;
    private Color foregroundColor;

    public CircleProgressBar() {
        minimumProgress = 0;
        maximumProgress = 100;
        progressText = "0%";
    }

    /**
     * 根据百分比绘制环形图
     * @param graph
     */

    public void paint(Graphics graph) {
        super.paint(graph);
        Graphics2D graphics2D = (Graphics2D) graph;
        //开启抗锯齿
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x;
        int y;
        int width;
        int height;
        int fontSize;
        if(getWidth() >= getHeight()) {
            x = (getWidth() - getHeight()) / 2 + 25;
            y = 25;
            width = getHeight() - 50;
            height = getHeight() - 50;
            fontSize = getWidth() / 8;
        } else {
            x = 25;
            y = (getHeight() - getWidth()) / 2 + 25;
            width = getWidth() - 50;
            height = getWidth() - 50;
            fontSize = getHeight() / 8;
        }
        //java2d可以使用setStroke改变笔画属性，原graphics绘图类使用的笔画属性是粗细为1像素的正方形
        graphics2D.setStroke(new BasicStroke(20.0f));
        graphics2D.setColor(backgroundColor);
        graphics2D.drawArc(x, y, width, height, 0, 360);
        graphics2D.setColor(foregroundColor);
        graphics2D.drawArc(x, y, width, height, 90,
                -(int)(360 * (progress *1.0) / 100.0));
    }
    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        if (progress >= minimumProgress && progress <= maximumProgress) {
            this.progress = progress;
        }
        if (progress > maximumProgress) {
            this.progress = maximumProgress;
        }
        this.progressText = String.valueOf(progress) + "%";
        this.repaint();
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        this.repaint();
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
        this.repaint();
    }
}
