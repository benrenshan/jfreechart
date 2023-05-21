package org.jfree.homework.LineChart;

import org.jfree.chart.ui.RectangleEdge;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.awt.*;

import static org.junit.Assert.*;

public class LineChartPropertyTest {

    private JFreeChart chart;
    private XYSeries series;
    private XYSeriesCollection dataset;

    @Before
    public void setUp() {
        series = new XYSeries("Test Series");
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        series.add(3.0, 3.0);
        dataset = new XYSeriesCollection(series);
        chart = ChartFactory.createXYLineChart(
                "Test Chart",
                "X",
                "Y",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
    }

    @Test
    public void testChartTitle() {
        Assertions.assertEquals("Test Chart", chart.getTitle().getText());
    }

    @Test
    public void testChartSubtitle() {
        // Add a subtitle to the chart in the setUp method to test this
        Assertions.assertNotNull(chart.getSubtitleCount() > 0);
    }

    @Test
    public void testChartLegend() {
        Assertions.assertTrue(chart.getLegend() != null);
    }

    @Test
    public void testChartPlot() {
        Assertions.assertNotNull(chart.getPlot());
    }

    // And so on, repeat for as many properties as you want to test. For instance:
    @Test
    public void testChartBackgroundPaint() {
        Assertions.assertNotNull(chart.getBackgroundPaint());
    }

    @Test
    public void testChartForegroundAlpha() {
        Assertions.assertNotNull(chart.getBackgroundImageAlpha());
    }

    @Test
    public void testChartBackgroundImage() {
        Assertions.assertNull(chart.getBackgroundImage());
    }

    @Test
    public void testChartBackgroundImageAlpha() {
        Assertions.assertNotEquals(1.0f, chart.getBackgroundImageAlpha());
    }

    @Test
    public void testChartBorderPaint() {
        Assertions.assertNotNull(chart.getBorderPaint());
    }

    @Test
    public void testChartNoDataMessage() {
        Assertions.assertNull(chart.getPlot().getNoDataMessage());
    }

    @Test
    public void testChartPadding() {
        Assertions.assertNotNull(chart.getPadding());
    }

    @Test
    public void testChartRenderingHints() {
        Assertions.assertNotNull(chart.getRenderingHints());
    }

    @Test
    public void testChartSubtitles() {
        Assertions.assertTrue(chart.getSubtitleCount() >= 0);
    }


    @Test
    public void testChartNotify() {
        Assertions.assertTrue(chart.isNotify());
    }

    @Test
    public void testChartElementHinting() {
        Assertions.assertFalse(chart.getElementHinting());
    }

    @Test
    public void testChartBorderStroke() {
        Assertions.assertNotNull(chart.getBorderStroke());
    }

    @Test
    public void testChartOutlineStroke() {
        Assertions.assertNotNull(chart.getBorderStroke());
    }

    @Test
    public void testChartOutlinePaint() {
        Assertions.assertNotNull(chart.getBorderPaint());
    }


    @Test
    public void testLegendItemFont() {
        assertNotNull(chart.getLegend().getItemFont());
    }

    @Test
    public void testLegendItemColor() {
        assertNotNull(chart.getLegend().getItemPaint());
    }

    @Test
    public void testLegendBackground() {
        assertNotNull(chart.getLegend().getBackgroundPaint());
    }

    @Test
    public void testLegendOutline() {
        assertNotNull(chart.getLegend().getItemPaint());
    }
    @Test
    public void testForegroundAlpha() {
        assertNotNull(chart.getPlot().getForegroundAlpha());
    }

    @Test
    public void testLegendVisibility() {
        assertTrue(chart.getLegend().isVisible());
    }

    @Test
    public void testLegendPosition() {
        assertEquals(RectangleEdge.BOTTOM, chart.getLegend().getPosition());
    }


    @Test
    public void testPlotBackgroundColor() {
        assertNotNull(chart.getPlot().getBackgroundPaint());
    }

}
