package org.jfree.homework.PieChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.Test;

import java.awt.Color;

import static java.lang.Double.valueOf;
import static org.junit.Assert.*;


public class PieChartPropertyTest {
    private JFreeChart createTestChart() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", valueOf(10.0));
        dataset.setValue("Two", valueOf(20.0));
        dataset.setValue("Three", valueOf(30.0));
        dataset.setValue("Four", valueOf(40.0));

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
        assertEquals("Test Chart", chart.getTitle().getText());
    }

    @Test
    public void testChartBackgroundPaint() {
        JFreeChart chart = createTestChart();
        chart.setBackgroundPaint(Color.BLUE);
        assertEquals(Color.BLUE, chart.getBackgroundPaint());
    }

    // Repeat similar tests for 20 different chart properties. The following are a few examples.

    @Test
    public void testChartLegend() {
        JFreeChart chart = createTestChart();
        assertNotNull(chart.getLegend());
    }

    @Test
    public void testChartNoLegend() {
        JFreeChart chart = createTestChart();
        chart.removeLegend();
        assertNull(chart.getLegend());
    }

    @Test
    public void testChartSubtitleCount() {
        JFreeChart chart = createTestChart();
        assertEquals(1, chart.getSubtitleCount());
    }

    @Test
    public void testChartPlotBackgroundPaint() {
        JFreeChart chart = createTestChart();
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(Color.RED);
        assertEquals(Color.RED, plot.getBackgroundPaint());
    }

    @Test
    public void testChartPlotOutlinePaint() {
        JFreeChart chart = createTestChart();
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setOutlinePaint(Color.GREEN);
        assertEquals(Color.GREEN, plot.getOutlinePaint());
    }

    @Test
    public void testChartPlotLabelFont() {
        JFreeChart chart = createTestChart();
        PiePlot plot = (PiePlot) chart.getPlot();
        assertNotNull(plot.getLabelFont());
    }


    @Test
    public void testChartPlotLabelColor() {
        JFreeChart chart = createTestChart();
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelPaint(Color.BLUE);
        assertEquals(Color.BLUE, plot.getLabelPaint());
    }


    @Test
    public void testChartPlotLabelBackgroundPaint() {
        JFreeChart chart = createTestChart();
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelBackgroundPaint(Color.YELLOW);
        assertEquals(Color.YELLOW, plot.getLabelBackgroundPaint());
    }

    @Test
    public void testChartPlotOutlineVisible() {
        JFreeChart chart = createTestChart();
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setOutlineVisible(true);
        assertTrue(plot.isOutlineVisible());
    }

    @Test
    public void testChartPlotOutlineNotVisible() {
        JFreeChart chart = createTestChart();
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setOutlineVisible(false);
        assertFalse(plot.isOutlineVisible());
    }

    @Test
    public void testChartPlotLabelLinksVisible() {
        JFreeChart chart = createTestChart();
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelLinksVisible(true);
        assertTrue(plot.getLabelLinksVisible());
    }

    @Test
    public void testChartPlotLabelLinksNotVisible() {
        JFreeChart chart = createTestChart();
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelLinksVisible(false);
        assertFalse(plot.getLabelLinksVisible());
    }

    @Test
    public void testChartPlotShadowPaint() {
        JFreeChart chart = createTestChart();
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setShadowPaint(Color.GRAY);
        assertEquals(Color.GRAY, plot.getShadowPaint());
    }

    @Test
    public void testChartPlotShadowXOffset() {
        JFreeChart chart = createTestChart();
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setShadowXOffset(5.0);
        assertEquals(5.0, plot.getShadowXOffset(), 0.0001);
    }

    @Test
    public void testChartPlotShadowYOffset() {
        JFreeChart chart = createTestChart();
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setShadowYOffset(5.0);
        assertEquals(5.0, plot.getShadowYOffset(), 0.0001);
    }

}
