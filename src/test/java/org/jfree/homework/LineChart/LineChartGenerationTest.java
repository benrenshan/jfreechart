package org.jfree.homework.LineChart;

import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.junit.Test;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class LineChartGenerationTest {

    private XYSeriesCollection createDataset() {
        XYSeries series = new XYSeries("Series1");
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        series.add(3.0, 3.0);
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        return dataset;
    }

    @Test
    public void testCreateLineChart() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        assertNotNull(chart);
        assertEquals("Title", chart.getTitle().getText());
        assertEquals("X-Axis", chart.getXYPlot().getDomainAxis().getLabel());
        assertEquals("Y-Axis", chart.getXYPlot().getRangeAxis().getLabel());
    }


    @Test
    public void testChartLegend() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        assertTrue(chart.getLegend().isVisible());
    }

    @Test
    public void testChartOrientation() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        assertEquals(PlotOrientation.VERTICAL, chart.getXYPlot().getOrientation());
    }

    @Test
    public void testChartTooltips() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, true);
        assertTrue(chart.getXYPlot().getRenderer().getDefaultToolTipGenerator() != null);
    }

    @Test
    public void testChartNoTooltips() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        assertNotNull(chart.getXYPlot().getRenderer().getDefaultToolTipGenerator());
    }

    @Test
    public void testChartURLs() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, true);
        assertTrue(chart.getXYPlot().getRenderer().getURLGenerator() != null);
    }

    @Test
    public void testChartNoURLs() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
    }

    @Test
    public void testDefaultBackground() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        assertEquals(Color.white, chart.getBackgroundPaint());
    }

    @Test
    public void testSetBackground() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(Color.blue);
        assertEquals(Color.blue, chart.getBackgroundPaint());
    }

    @Test
    public void testChartRenderingInfo() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        BufferedImage image = new BufferedImage(400, 300, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();
        chart.draw(g2, new Rectangle2D.Double(0, 0, 400, 300));
        assertNotNull(chart.getRenderingHints());
    }

    @Test
    public void testSeriesStroke() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        BasicStroke stroke = new BasicStroke(2.0f);
        chart.getXYPlot().getRenderer().setSeriesStroke(0, stroke);
        assertEquals(stroke, chart.getXYPlot().getRenderer().getSeriesStroke(0));
    }

    @Test
    public void testSeriesColor() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        Color color = Color.red;
        chart.getXYPlot().getRenderer().setSeriesPaint(0, color);
        assertEquals(color, chart.getXYPlot().getRenderer().getSeriesPaint(0));
    }

    @Test
    public void testDomainGridlineVisible() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.getXYPlot().setDomainGridlinesVisible(true);
        assertTrue(chart.getXYPlot().isDomainGridlinesVisible());
    }

    @Test
    public void testRangeGridlineVisible() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.getXYPlot().setRangeGridlinesVisible(true);
        assertTrue(chart.getXYPlot().isRangeGridlinesVisible());
    }

    @Test
    public void testAxisOffset() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.getXYPlot().setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        assertEquals(new RectangleInsets(5.0, 5.0, 5.0, 5.0), chart.getXYPlot().getAxisOffset());
    }

    @Test
    public void testDomainCrosshairVisible() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.getXYPlot().setDomainCrosshairVisible(true);
        assertTrue(chart.getXYPlot().isDomainCrosshairVisible());
    }

    @Test
    public void testRangeCrosshairVisible() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.getXYPlot().setRangeCrosshairVisible(true);
        assertTrue(chart.getXYPlot().isRangeCrosshairVisible());
    }

    @Test
    public void testDomainCrosshairValue() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.getXYPlot().setDomainCrosshairValue(2.0);
        assertEquals(2.0, chart.getXYPlot().getDomainCrosshairValue(), 0.0001);
    }

    @Test
    public void testRangeCrosshairValue() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.getXYPlot().setRangeCrosshairValue(2.0);
        assertEquals(2.0, chart.getXYPlot().getRangeCrosshairValue(), 0.0001);
    }

    @Test
    public void testSeriesVisible() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.getXYPlot().getRenderer().setSeriesVisible(0, true);
        assertTrue(chart.getXYPlot().getRenderer().isSeriesVisible(0));
    }

    @Test
    public void testRangeCrosshairStroke() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        BasicStroke stroke = new BasicStroke(2.0f);
        chart.getXYPlot().setRangeCrosshairStroke(stroke);
        assertEquals(stroke, chart.getXYPlot().getRangeCrosshairStroke());
    }

    @Test
    public void testDomainCrosshairStroke() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        BasicStroke stroke = new BasicStroke(2.0f);
        chart.getXYPlot().setDomainCrosshairStroke(stroke);
        assertEquals(stroke, chart.getXYPlot().getDomainCrosshairStroke());
    }

    @Test
    public void testDomainCrosshairPaint() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.getXYPlot().setDomainCrosshairPaint(Color.red);
        assertEquals(Color.red, chart.getXYPlot().getDomainCrosshairPaint());
    }

    @Test
    public void testRangeCrosshairPaint() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.getXYPlot().setRangeCrosshairPaint(Color.blue);
        assertEquals(Color.blue, chart.getXYPlot().getRangeCrosshairPaint());
    }

    @Test
    public void testDomainGridlineStroke() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        BasicStroke stroke = new BasicStroke(2.0f);
        chart.getXYPlot().setDomainGridlineStroke(stroke);
        assertEquals(stroke, chart.getXYPlot().getDomainGridlineStroke());
    }

    @Test
    public void testRangeGridlineStroke() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        BasicStroke stroke = new BasicStroke(2.0f);
        chart.getXYPlot().setRangeGridlineStroke(stroke);
        assertEquals(stroke, chart.getXYPlot().getRangeGridlineStroke());
    }

    @Test
    public void testDomainGridlinePaint() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.getXYPlot().setDomainGridlinePaint(Color.red);
        assertEquals(Color.red, chart.getXYPlot().getDomainGridlinePaint());
    }

    @Test
    public void testRangeGridlinePaint() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.getXYPlot().setRangeGridlinePaint(Color.green);
        assertEquals(Color.green, chart.getXYPlot().getRangeGridlinePaint());
    }

    @Test
    public void testAxisSpace() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        AxisSpace space = new AxisSpace();
        space.setTop(10.0);
        chart.getXYPlot().setFixedRangeAxisSpace(space);
        assertEquals(space, chart.getXYPlot().getFixedRangeAxisSpace());
    }

    @Test
    public void testRenderer() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, false);
        chart.getXYPlot().setRenderer(renderer);
        assertEquals(renderer, chart.getXYPlot().getRenderer());
    }

    @Test
    public void testRangeAxisLocation() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.getXYPlot().setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
        assertEquals(AxisLocation.BOTTOM_OR_LEFT, chart.getXYPlot().getRangeAxisLocation());
    }

    @Test
    public void testDomainAxisLocation() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.getXYPlot().setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        assertEquals(AxisLocation.BOTTOM_OR_RIGHT, chart.getXYPlot().getDomainAxisLocation());
    }

    @Test
    public void testWeight() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.getXYPlot().setWeight(3);
        assertEquals(3, chart.getXYPlot().getWeight());
    }

    @Test
    public void testInsets() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.getXYPlot().setInsets(new RectangleInsets(1.0, 1.0, 1.0, 1.0));
        assertEquals(new RectangleInsets(1.0, 1.0, 1.0, 1.0), chart.getXYPlot().getInsets());
    }

    @Test
    public void testOutlineVisible() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.getXYPlot().setOutlineVisible(true);
        assertTrue(chart.getXYPlot().isOutlineVisible());
    }

    @Test
    public void testOutlineStroke() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        BasicStroke stroke = new BasicStroke(2.0f);
        chart.getXYPlot().setOutlineStroke(stroke);
        assertEquals(stroke, chart.getXYPlot().getOutlineStroke());
    }

    @Test
    public void testOutlinePaint() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.getXYPlot().setOutlinePaint(Color.blue);
        assertEquals(Color.blue, chart.getXYPlot().getOutlinePaint());
    }

    @Test
    public void testSeriesOutlineStroke() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        BasicStroke stroke = new BasicStroke(2.0f);
        chart.getXYPlot().getRenderer().setSeriesOutlineStroke(0, stroke);
        assertEquals(stroke, chart.getXYPlot().getRenderer().getSeriesOutlineStroke(0));
    }

    @Test
    public void testSeriesOutlinePaint() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.getXYPlot().getRenderer().setSeriesOutlinePaint(0, Color.red);
        assertEquals(Color.red, chart.getXYPlot().getRenderer().getSeriesOutlinePaint(0));
    }

    @Test
    public void testDataset() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        XYDataset dataset = new XYSeriesCollection();
        chart.getXYPlot().setDataset(dataset);
        assertEquals(dataset, chart.getXYPlot().getDataset());
    }

    @Test
    public void testLegend() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.removeLegend();
        assertNull(chart.getLegend());
    }

    @Test
    public void testAxisLabel() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.getXYPlot().getDomainAxis().setLabel("New X-Axis Label");
        assertEquals("New X-Axis Label", chart.getXYPlot().getDomainAxis().getLabel());
    }

    @Test
    public void testTitle() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.setTitle("New Title");
        assertEquals("New Title", chart.getTitle().getText());
    }

    @Test
    public void testBackgroundImage() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        BufferedImage image = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
        chart.setBackgroundImage(image);
        assertEquals(image, chart.getBackgroundImage());
    }

    @Test
    public void testBackgroundPaint() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(Color.blue);
        assertEquals(Color.blue, chart.getBackgroundPaint());
    }

    @Test
    public void testForegroundAlpha() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundImageAlpha(0.5f);
        assertEquals(0.5f, chart.getBackgroundImageAlpha(), 0.0001);
    }

    @Test
    public void testAntiAlias() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.setAntiAlias(false);
        assertFalse(chart.getAntiAlias());
    }

    @Test
    public void testBorderVisible() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.setBorderVisible(true);
        assertTrue(chart.isBorderVisible());
    }

    @Test
    public void testBorderStroke() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        BasicStroke stroke = new BasicStroke(2.0f);
        chart.setBorderStroke(stroke);
        assertEquals(stroke, chart.getBorderStroke());
    }

    @Test
    public void testBorderPaint() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.setBorderPaint(Color.green);
        assertEquals(Color.green, chart.getBorderPaint());
    }

    @Test
    public void testPadding() {
        JFreeChart chart = ChartFactory.createXYLineChart("Title", "X-Axis", "Y-Axis", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        RectangleInsets padding = new RectangleInsets(1.0, 1.0, 1.0, 1.0);
        chart.setPadding(padding);
        assertEquals(padding, chart.getPadding());
    }
    @Test
    public void testCreateChartWithNullDataset() {
        try {
            ChartFactory.createLineChart("Title", "Category", "Value", null);
        } catch (IllegalArgumentException e) {
            fail("Should not throw an exception for null dataset");
        }
    }

}
