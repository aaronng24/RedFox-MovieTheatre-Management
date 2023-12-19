/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.awt.Color;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.XChartPanel;

/**
 *
 * @author Nguyen Dinh Dung
 */
    public class Piechart {

    String title;
    public void displayChart(Map<String, Integer> map, String title) {
        PieChart chart = new PieChartBuilder().width(800).height(600).title(title).build();

        // Customize Chart
        Color[] sliceColors = new Color[]{Color.decode("#1D95F6"), Color.decode("#7CBA29"), Color.decode("#FBB300"), Color.decode("#29B998"), Color.decode("#F98300"), Color.decode("#CE3933"), Color.decode("#DA6F13")};
        chart.getStyler().setSeriesColors(sliceColors);

        // Series
        for(Map.Entry<String, Integer> item : map.entrySet())
        {
            chart.addSeries(item.getKey(), item.getValue());
        }

        JPanel jp = new XChartPanel(chart);
        JFrame wrapperFrame = new JFrame();
        wrapperFrame.add(jp);
        wrapperFrame.pack();
        wrapperFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        wrapperFrame.setLocationRelativeTo(null);
        wrapperFrame.setVisible(true);
    }
}


