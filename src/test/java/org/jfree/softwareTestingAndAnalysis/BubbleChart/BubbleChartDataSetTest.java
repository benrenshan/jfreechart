package org.jfree.softwareTestingAndAnalysis.BubbleChart;

import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYZDataset;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;


public class BubbleChartDataSetTest {

    @Test
    public void testBubbleChart_1() {
        XYZDataset dataset = createDataset(1, 2, 3);
        JFreeChart chart = ChartFactory.createBubbleChart(
                "Bubble Chart Test",
                "X",
                "Y",
                dataset,
                PlotOrientation.HORIZONTAL,
                true,
                true,
                false);
        Assertions.assertNotNull(chart);
    }

    @Test
    public void testBubbleChart_2() {
        XYZDataset dataset = createDataset(2, 3, 4);
        JFreeChart chart = ChartFactory.createBubbleChart(
                "Bubble Chart Test",
                "X",
                "Y",
                dataset,
                PlotOrientation.HORIZONTAL,
                true,
                true,
                false);
        Assertions.assertNotNull(chart);
    }

    @Test
    public void testBubbleChart_4() {
        XYZDataset dataset = createDataset(2, 5, 4);
        JFreeChart chart = ChartFactory.createBubbleChart(
                "Bubble Chart Test",
                "X",
                "Y",
                dataset,
                PlotOrientation.HORIZONTAL,
                true,
                true,
                false);
        Assertions.assertNotNull(chart);
    }

    @Test
    public void testBubbleChart_5() {
        XYZDataset dataset = createDataset(2, 3, 8);
        JFreeChart chart = ChartFactory.createBubbleChart(
                "Bubble Chart Test",
                "X",
                "Y",
                dataset,
                PlotOrientation.HORIZONTAL,
                true,
                true,
                false);
        Assertions.assertNotNull(chart);
    }

    @Test
    public void testBubbleChart_6() {
        XYZDataset dataset = createDataset(2, 3, 40000);
        JFreeChart chart = ChartFactory.createBubbleChart(
                "Bubble Chart Test",
                "X",
                "Y",
                dataset,
                PlotOrientation.HORIZONTAL,
                true,
                true,
                false);
        Assertions.assertNotNull(chart);
    }

    // Create a dataset with a single series "S1"
    private XYZDataset createDataset(double x, double y, double z) {
        DefaultXYZDataset dataset = new DefaultXYZDataset();
        double[] xs = {x};
        double[] ys = {y};
        double[] zs = {z};
        double[][] series = {xs, ys, zs};
        dataset.addSeries("S1", series);
        return dataset;
    }

    @Test
    public void testBubbleChart0() {
        XYZDataset dataset = createDataset(1, 2, 3);
        JFreeChart chart = ChartFactory.createBubbleChart(
                "Bubble Chart Test",
                "X",
                "Y",
                dataset,
                PlotOrientation.HORIZONTAL,
                true,
                true,
                false);
        Assertions.assertNotNull(chart);
    }

    @Test
    public void testBubbleChart() {
        XYZDataset dataset = createDataset(2, 3, 4);
        JFreeChart chart = ChartFactory.createBubbleChart(
                "Bubble Chart Test",
                "X",
                "Y",
                dataset,
                PlotOrientation.HORIZONTAL,
                true,
                true,
                false);
        Assertions.assertNotNull(chart);
    }

    @Test
    public void testBubbleChart_9() {
        XYZDataset dataset = createDataset(2, 50, 4);
        JFreeChart chart = ChartFactory.createBubbleChart(
                "Bubble Chart Test",
                "X",
                "Y",
                dataset,
                PlotOrientation.HORIZONTAL,
                true,
                true,
                false);
        Assertions.assertNotNull(chart);
    }

    @Test
    public void testBubbleChart_3() {
        XYZDataset dataset = createDataset(2, 3, 8);
        JFreeChart chart = ChartFactory.createBubbleChart(
                "Bubble Chart Test",
                "X",
                "Y",
                dataset,
                PlotOrientation.HORIZONTAL,
                true,
                true,
                false);
        Assertions.assertNotNull(chart);
    }

    @Test
    public void testBubbleChart_8() {
        XYZDataset dataset = createDataset(2, 3, 40000);
        JFreeChart chart = ChartFactory.createBubbleChart(
                "Bubble Chart Test",
                "X",
                "Y",
                dataset,
                PlotOrientation.HORIZONTAL,
                true,
                true,
                false);
        Assertions.assertNotNull(chart);
    }


}


