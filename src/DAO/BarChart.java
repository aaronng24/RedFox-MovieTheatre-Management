package DAO;

import java.awt.Color;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.XChartPanel;

/**
 *
 * @author MrCuong
 */
public class BarChart {

    private List<String> xData;
    private List<Integer> yData;
    private String title;
    private JPanel parent;
    private String xAsisTitle;
    private String yAxixTitle;
    private String seriesName;

    public BarChart(List<String> xData, List<Integer> yData, String title, JPanel parent, String xAsisTitle, String yAxixTitle, String seriesName) {
        this.xData = xData;
        this.yData = yData;
        this.title = title;
        this.parent = parent;
        this.xAsisTitle = xAsisTitle;
        this.yAxixTitle = yAxixTitle;
        this.seriesName = seriesName;
    }

    public void displayChart() {
        CategoryChart chart = new CategoryChartBuilder().title(title).xAxisTitle(this.xAsisTitle).yAxisTitle(this.yAxixTitle).build();
        Color[] sliceColors = new Color[]{Color.decode("#1D95F6")};
        chart.getStyler().setSeriesColors(sliceColors);
        //chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setDecimalPattern("##,###,###,###");

        chart.addSeries(this.seriesName, this.xData, this.yData);
        JPanel panel = new XChartPanel<CategoryChart>(chart);
        JFrame wrapperFrame = new JFrame();
        wrapperFrame.add(panel);
        wrapperFrame.pack();
        wrapperFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        wrapperFrame.setLocationRelativeTo(null);
        wrapperFrame.setVisible(true);
    }
}