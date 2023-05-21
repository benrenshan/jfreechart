package org.jfree.softwareTestingAndAnalysis.PieChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.Assert;
import org.junit.Test;

import java.awt.Color;

import static java.lang.Double.valueOf;
import static org.junit.Assert.*;


public class PieChartPropertyTest {
    private JFreeChart createTestChart() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", Double.valueOf(10.0));
        dataset.setValue("Two", Double.valueOf(20.0));
        dataset.setValue("Three", Double.valueOf(30.0));
        dataset.setValue("Four", Double.valueOf(40.0));

        return ChartFactory.createPieChart(
                "Test Chart",
                dataset,
                true,
                true,
                false
        );
    }

    @Test
    public void testChartTitle() {
        JFreeChart chart = createTestChart();
        Assert.assertEquals("Test Chart", chart.getTitle().getText());
    }

    @Test
    public void testChartBackgroundPaint() {
        JFreeChart chart = createTestChart();
        chart.setBackgroundPaint(Color.BLUE);
        Assert.assertEquals(Color.BLUE, chart.getBackgroundPaint());
    }

    // Repeat similar tests for 20 different chart properties. The following are a few examples.

    @Test
    public void testChartLegend() {
        JFreeChart chart = createTestChart();
        Assert.assertNotNull(chart.getLegend());
    }

    @Test
    public void testChartNoLegend() {
        JFreeChart chart = createTestChart();
        chart.removeLegend();
        Assert.assertNull(chart.getLegend());
    }

    @Test
    public void testChartSubtitleCount() {
        JFreeChart chart = createTestChart();
        Assert.assertEquals(1, chart.getSubtitleCount());
    }

    @Test
    public void testChartPlotBackgroundPaint() {
        JFreeChart chart = createTestChart();
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(Color.RED);
        Assert.assertEquals(Color.RED, plot.getBackgroundPaint());
    }

    @Test
    public void testChartPlotOutlinePaint() {
        JFreeChart chart = createTestChart();
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setOutlinePaint(Color.GREEN);
        Assert.assertEquals(Color.GREEN, plot.getOutlinePaint());
    }

    @Test
    public void testChartPlotLabelFont() {
        JFreeChart chart = createTestChart();
        PiePlot plot = (PiePlot) chart.getPlot();
        Assert.assertNotNull(plot.getLabelFont());
    }


    @Test
    public void testChartPlotLabelColor() {
        JFreeChart chart = createTestChart();
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelPaint(Color.BLUE);
        Assert.assertEquals(Color.BLUE, plot.getLabelPaint());
    }


    @Test
    public void testChartPlotLabelBackgroundPaint() {
        JFreeChart chart = createTestChart();
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelBackgroundPaint(Color.YELLOW);
        Assert.assertEquals(Color.YELLOW, plot.getLabelBackgroundPaint());
    }

    @Test
    public void testChartPlotOutlineVisible() {
        JFreeChart chart = createTestChart();
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setOutlineVisible(true);
        Assert.assertTrue(plot.isOutlineVisible());
    }

    @Test
    public void testChartPlotOutlineNotVisible() {
        JFreeChart chart = createTestChart();
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setOutlineVisible(false);
        Assert.assertFalse(plot.isOutlineVisible());
    }

    @Test
    public void testChartPlotLabelLinksVisible() {
        JFreeChart chart = createTestChart();
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelLinksVisible(true);
        Assert.assertTrue(plot.getLabelLinksVisible());
    }

    @Test
    public void testChartPlotLabelLinksNotVisible() {
        JFreeChart chart = createTestChart();
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelLinksVisible(false);
        Assert.assertFalse(plot.getLabelLinksVisible());
    }

    @Test
    public void testChartPlotShadowPaint() {
        JFreeChart chart = createTestChart();
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setShadowPaint(Color.GRAY);
        Assert.assertEquals(Color.GRAY, plot.getShadowPaint());
    }

    @Test
    public void testChartPlotShadowXOffset() {
        JFreeChart chart = createTestChart();
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setShadowXOffset(5.0);
        Assert.assertEquals(5.0, plot.getShadowXOffset(), 0.0001);
    }

    @Test
    public void testChartPlotShadowYOffset() {
        JFreeChart chart = createTestChart();
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setShadowYOffset(5.0);
        Assert.assertEquals(5.0, plot.getShadowYOffset(), 0.0001);
    }

}
