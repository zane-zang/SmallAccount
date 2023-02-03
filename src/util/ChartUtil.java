package util;

import com.objectplanet.chart.BarChart;
import com.objectplanet.chart.Chart;
import com.objectplanet.chart.Chart2;
import entity.Record;
import service.ReportService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author zane
 * @date 2023-01-28-9:46
 * 工具类，CharUtil，图表
 */
public class ChartUtil {
    /**
     * @param recordList
     * @param width
     * @param height
     */
    public static Image getImage(List<Record> recordList, int width, int height) {
        //样本数据
        double[] sampleValues = getSampleValues(recordList);
        //样本标签
        String[] sampleLabels = getSampleLabels(recordList);
        int maxValue = max(sampleValues);
        Color[] sampleColors = new Color[]{ColorUtil.blueColor};
        //柱状图
        BarChart barChart = new BarChart();
        barChart.setSampleCount(sampleValues.length);
        barChart.setSampleValues(0, sampleValues);
        barChart.setSampleLabels(sampleLabels);
        barChart.setSampleColors(sampleColors);
        barChart.setRange(0, maxValue * 1.2);
        //显示背景横线
        barChart.setValueLinesOn(true);
        barChart.setSampleLabelsOn(true);
        barChart.setSampleLabelStyle(Chart.BELOW);
        //样本值的字体
        barChart.setFont("rangeLabelFont", new Font("Arial", Font.BOLD, 12));
        //显示图例说明
        barChart.setLegendOn(true);
        barChart.setLegendPosition(Chart.LEFT);
        barChart.setLegendLabels(new String[]{"月度消费表"});
        //图列说明的字体
        barChart.setFont("legendFont", new Font("Dialog", Font.BOLD, 13));
        //样本标签字体
        barChart.setFont("sampleLabelFont", new Font("Dialog", Font.BOLD, 13));
        barChart.setChartBackground(Color.white);
        barChart.setBackground(ColorUtil.backgroundColor);

        return barChart.getImage(width, height);


    }

    /**
     *
     * @param recordList 每天record数据组成的列表
     * @return 每天消费金额组成的数组
     */

    private static double[] getSampleValues(List<Record> recordList) {
        double[] result = new double[recordList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = recordList.get(i).getSpend();

        }
        return result;
    }
    private static int max(double[] sampleValues) {
        int max = 0;
        for(double v : sampleValues) {
            if (v > max) {
                max = (int) v;
            }

        }
        return max;
    }

    private static String[] getSampleLabels(List<Record> recordList) {
        String[] sampleLabels = new String[recordList.size()];
        for (int i = 0; i < sampleLabels.length; i++) {
            if (i % 5 == 0) {
                sampleLabels[i] = String.valueOf(i + 1) + "日";
            }

        }
        return sampleLabels;
    }

    public static void main(String[] args) {
        JPanel Panel = new JPanel();
        JLabel label = new JLabel();
        Image img = ChartUtil.getImage(new ReportService().MonthRecordList(), 400, 300);
        Icon icon = new ImageIcon(img);
        label.setIcon(icon);
        Panel.add(label);
        GuiUtil.showPanel(Panel);
    }
}
