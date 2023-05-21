package org.jfree.softwareTestingAndAnalysis.BarChart;

import org.jfree.chart.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class BarChartPropertyTest {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    {
        dataset.addValue(1.0, "Row1", "Column1");
    }

    @Test
    public void testBarChartTitle() {
        JFreeChart chart = ChartFactory.createBarChart("Test Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertEquals("Test Title", chart.getTitle().getText());
    }

    @Test
    public void testBarChartXAxisLabel() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "Test X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertEquals("Test X-Axis", chart.getCategoryPlot().getDomainAxis().getLabel());
    }

    @Test
    public void testBarChartYAxisLabel() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Test Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertEquals("Test Y-Axis", chart.getCategoryPlot().getRangeAxis().getLabel());
    }

    @Test
    public void testBarChartLegend() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertTrue(chart.getLegend() != null);
    }

    @Test
    public void testBarChartNoLegend() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, false, true, false);
        Assert.assertTrue(chart.getLegend() == null);
    }

    @Test
    public void testBarChartBackgroundPaint() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(Color.GREEN);
        Assert.assertEquals(Color.GREEN, chart.getBackgroundPaint());
    }

    @Test
    public void testBarChartRotation() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        Assert.assertTrue(chart.getCategoryPlot().getOrientation() == PlotOrientation.HORIZONTAL);
    }

    @Test
    public void testBarChartSeriesPaint() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.getCategoryPlot().getRenderer().setSeriesPaint(0, Color.RED);
        Assert.assertEquals(Color.RED, chart.getCategoryPlot().getRenderer().getSeriesPaint(0));
    }

    @Test
    public void testBarChartSeriesOutlinePaint() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.getCategoryPlot().getRenderer().setSeriesOutlinePaint(0, Color.YELLOW);
        Assert.assertEquals(Color.YELLOW, chart.getCategoryPlot().getRenderer().getSeriesOutlinePaint(0));
    }

    @Test
    public void testBarChartShadowXOffset() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setShadowXOffset(5.0);
        Assert.assertEquals(5.0, renderer.getShadowXOffset(), 0.001);
    }

    @Test
    public void testBarChartShadowYOffset() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setShadowYOffset(5.0);
        Assert.assertEquals(5.0, renderer.getShadowYOffset(), 0.001);
    }

    @Test
    public void testBarChartItemMargin() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setItemMargin(0.1);
        Assert.assertEquals(0.1, renderer.getItemMargin(), 0.001);
    }

    @Test
    public void testBarChartMaximumBarWidth() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setMaximumBarWidth(0.1);
        Assert.assertEquals(0.1, renderer.getMaximumBarWidth(), 0.001);
    }

    @Test
    public void testBarChartMinimumBarLength() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setMinimumBarLength(0.1);
        Assert.assertEquals(0.1, renderer.getMinimumBarLength(), 0.001);
    }

    @Test
    public void testBarChartGridlinePaint() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.getCategoryPlot().setDomainGridlinePaint(Color.GREEN);
        Assert.assertEquals(Color.GREEN, chart.getCategoryPlot().getDomainGridlinePaint());
    }

    @Test
    public void testBarChartGridlineStroke() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Stroke stroke = new BasicStroke(2.0f);
        chart.getCategoryPlot().setDomainGridlineStroke(stroke);
        Assert.assertEquals(stroke, chart.getCategoryPlot().getDomainGridlineStroke());
    }

    @Test
    public void testBarChartOutlinePaint() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.getCategoryPlot().setOutlinePaint(Color.BLACK);
        Assert.assertEquals(Color.BLACK, chart.getCategoryPlot().getOutlinePaint());
    }

    @Test
    public void testBarChartOutlineStroke() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Stroke stroke = new BasicStroke(2.0f);
        chart.getCategoryPlot().setOutlineStroke(stroke);
        Assert.assertEquals(stroke, chart.getCategoryPlot().getOutlineStroke());
    }

    @Test
    public void testBarChartSeriesVisible() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setSeriesVisible(1, true);
        Assert.assertTrue(renderer.getSeriesVisible(1));
    }

    @Test
    public void testBarChartSeriesNotVisible() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setSeriesVisible(1, false);
        Assert.assertFalse(renderer.getSeriesVisible(1));
    }

    @Test
    public void testBarChartLegendVisible() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertTrue(chart.getLegend().isVisible());
    }

    @Test
    public void testBarChartLegendNotVisible() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.getLegend().setVisible(false);
        Assert.assertFalse(chart.getLegend().isVisible());
    }

    @Test
    public void testBarChartLegendPosition() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.getLegend().setPosition(RectangleEdge.BOTTOM);
        Assert.assertEquals(RectangleEdge.BOTTOM, chart.getLegend().getPosition());
    }

    @Test
    public void testBarChartNoBackgroundImage() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertNull(chart.getBackgroundImage());
    }

    @Test
    public void testBarChartBackgroundImageAlpha() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundImageAlpha(0.5f);
        Assert.assertEquals(0.5f, chart.getBackgroundImageAlpha(), 0.001);
    }

    @Test
    public void testBarChartShadowPaint() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setShadowPaint(Color.BLUE);
        Assert.assertEquals(Color.BLUE, renderer.getShadowPaint());
    }

    @Test
    public void testBarChartSeriesOutlineStroke() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        Stroke expectedStroke = new BasicStroke(2.0f);
        renderer.setSeriesOutlineStroke(0, expectedStroke);
        Assert.assertEquals(expectedStroke, renderer.getSeriesOutlineStroke(0));
    }

    @Test
    public void testBarChartSeriesItemMargin() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setItemMargin(0.1);
        Assert.assertEquals(0.1, renderer.getItemMargin(), 0.001);
    }

    @Test
    public void testBarChartSeriesPositiveItemLabelPositionFallback() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        ItemLabelPosition position = new ItemLabelPosition();
        renderer.setPositiveItemLabelPositionFallback(position);
        Assert.assertEquals(position, renderer.getPositiveItemLabelPositionFallback());
    }

    @Test
    public void testBarChartSeriesNegativeItemLabelPositionFallback() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        ItemLabelPosition position = new ItemLabelPosition();
        renderer.setNegativeItemLabelPositionFallback(position);
        Assert.assertEquals(position, renderer.getNegativeItemLabelPositionFallback());
    }

    @Test
    public void testBarChartAutoPopulateSeriesStroke() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setAutoPopulateSeriesStroke(false);
        Assert.assertEquals(false, renderer.getAutoPopulateSeriesStroke());
    }

    @Test
    public void testBarChartShadowVisible() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setShadowVisible(true);
        Assert.assertEquals(true, renderer.getShadowsVisible());
    }


}
