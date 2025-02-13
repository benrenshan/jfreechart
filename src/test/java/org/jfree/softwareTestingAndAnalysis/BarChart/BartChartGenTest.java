package org.jfree.softwareTestingAndAnalysis.BarChart;

import org.jfree.chart.*;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;


public class BartChartGenTest {

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    {
        dataset.addValue(1.0, "Row1", "Column1");
    }

    @Test
    public void testBarChartNotNull() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "Category Axis", "Value Axis",
                dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertNotNull(chart);
    }

    @Test
    public void testBarChartTitle() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "Category Axis", "Value Axis",
                dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertEquals("Title", chart.getTitle().getText());
    }

    @Test
    public void testBarChartLegend() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "Category Axis", "Value Axis",
                dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertNotNull(chart.getLegend());
    }

    @Test
    public void testBarChartNoLegend() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "Category Axis", "Value Axis",
                dataset, PlotOrientation.VERTICAL, false, true, false);
        Assert.assertNull(chart.getLegend());
    }

    @Test
    public void testBarChartCategoryAxisLabel() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "Category Axis", "Value Axis",
                dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertEquals("Category Axis", ((CategoryPlot) chart.getPlot()).getDomainAxis().getLabel());
    }


    @Test
    public void testChartNotNull() {
        JFreeChart chart = ChartFactory.createBarChart("Chart Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertNotNull(chart);
    }

    @Test
    public void testChartTitle() {
        JFreeChart chart = ChartFactory.createBarChart("Chart Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertEquals("Chart Title", chart.getTitle().getText());
    }

    @Test
    public void testChartXAxisTitle() {
        JFreeChart chart = ChartFactory.createBarChart("Chart Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertEquals("X-Axis", chart.getCategoryPlot().getDomainAxis().getLabel());
    }

    @Test
    public void testChartYAxisTitle() {
        JFreeChart chart = ChartFactory.createBarChart("Chart Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertEquals("Y-Axis", chart.getCategoryPlot().getRangeAxis().getLabel());
    }

    @Test
    public void testChartLegendExists() {
        JFreeChart chart = ChartFactory.createBarChart("Chart Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertNotNull(chart.getLegend());
    }

    @Test
    public void testChartLegendNotExists() {
        JFreeChart chart = ChartFactory.createBarChart("Chart Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, false, true, false);
        Assert.assertNull(chart.getLegend());
    }


    @Test
    public void testChartOrientationVertical() {
        JFreeChart chart = ChartFactory.createBarChart("Chart Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertEquals(PlotOrientation.VERTICAL, chart.getCategoryPlot().getOrientation());
    }

    @Test
    public void testChartOrientationHorizontal() {
        JFreeChart chart = ChartFactory.createBarChart("Chart Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        Assert.assertEquals(PlotOrientation.HORIZONTAL, chart.getCategoryPlot().getOrientation());
    }

    @Test
    public void testBarChartTooltipsEnabled() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, true);
        Assert.assertTrue(chart.getCategoryPlot().getRenderer().getToolTipGenerator(0, 0) != null);
    }

    @Test
    public void testBarChartTooltipsDisabled() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertNotNull(chart.getCategoryPlot().getRenderer().getToolTipGenerator(0, 0));
    }

    @Test
    public void testBarChartURLsEnabled() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, true);
        Assert.assertTrue(chart.getCategoryPlot().getRenderer().getItemURLGenerator(0, 0) != null);
    }

    @Test
    public void testBarChartURLsDisabled() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertNull(chart.getCategoryPlot().getRenderer().getItemURLGenerator(0, 0));
    }

    @Test
    public void testBarChartLegendExists() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertNotNull(chart.getLegend());
    }

    @Test
    public void testBarChartLegendDoesNotExist() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, false, true, false);
        Assert.assertNull(chart.getLegend());
    }

    @Test
    public void testBarChartBackgroundColor() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(Color.GREEN);
        Assert.assertEquals(Color.GREEN, chart.getBackgroundPaint());
    }

    @Test
    public void testBarChartPlotColor() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.getCategoryPlot().setBackgroundPaint(Color.GREEN);
        Assert.assertEquals(Color.GREEN, chart.getCategoryPlot().getBackgroundPaint());
    }

    @Test
    public void testBarChartGridlineVisibility() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.getCategoryPlot().setDomainGridlinesVisible(true);
        Assert.assertTrue(chart.getCategoryPlot().isDomainGridlinesVisible());
    }

    @Test
    public void testBarChartGridlineNotVisible() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.getCategoryPlot().setDomainGridlinesVisible(false);
        Assert.assertFalse(chart.getCategoryPlot().isDomainGridlinesVisible());
    }

    @Test
    public void testBarChartOutlineVisible() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.getPlot().setOutlineVisible(true);
        Assert.assertTrue(chart.getPlot().isOutlineVisible());
    }

    @Test
    public void testBarChartOutlineNotVisible() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.getPlot().setOutlineVisible(false);
        Assert.assertFalse(chart.getPlot().isOutlineVisible());
    }

    @Test
    public void testBarChartSeriesCount() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertEquals(1, dataset.getRowCount());
    }

    @Test
    public void testBarChartCategoryCount() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertEquals(1, dataset.getColumnCount());
    }

    @Test
    public void testBarChartRemoveSeries() {
        dataset.removeRow("Row1");
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertEquals(0, dataset.getRowCount());
    }

    @Test
    public void testBarChartRemoveCategory() {
        dataset.removeColumn("Column1");
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertEquals(0, dataset.getColumnCount());
    }

    @Test
    public void testBarChartAddSeries() {
        dataset.addValue(4.0, "Row2", "Column4");
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertEquals(2, dataset.getRowCount());
    }

    @Test
    public void testBarChartAddCategory() {
        dataset.addValue(5.0, "Row1", "Column4");
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertEquals(2, dataset.getColumnCount());
    }

    @Test
    public void testBarChartEmptyDataset() {
        DefaultCategoryDataset emptyDataset = new DefaultCategoryDataset();
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", emptyDataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertEquals(0, emptyDataset.getRowCount());
    }

    @Test
    public void testBarChartNullDataset() {
        DefaultCategoryDataset nullDataset = null;
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", nullDataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertNull(chart.getCategoryPlot().getDataset());
    }

    @Test
    public void testBarChartDefaultColor() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertEquals(new Color(255, 85, 85), chart.getPlot().getDrawingSupplier().getNextPaint());
    }

    @Test
    public void testBarChartNextColor() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.getPlot().getDrawingSupplier().getNextPaint();
        Assert.assertEquals(new Color(85, 85, 255), chart.getPlot().getDrawingSupplier().getNextPaint());
    }

    @Test
    public void testBarChartGridLineColor() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.getCategoryPlot().setDomainGridlinePaint(Color.RED);
        Assert.assertEquals(Color.RED, chart.getCategoryPlot().getDomainGridlinePaint());
    }

    @Test
    public void testBarChartOutlineColor() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.getPlot().setOutlinePaint(Color.RED);
        Assert.assertEquals(Color.RED, chart.getPlot().getOutlinePaint());
    }

    @Test
    public void testBarChartValueAxisLocation() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.getCategoryPlot().setRangeAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        Assert.assertEquals(AxisLocation.BOTTOM_OR_RIGHT, chart.getCategoryPlot().getRangeAxisLocation());
    }

    @Test
    public void testBarChartCategoryAxisLocation() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.getCategoryPlot().setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        Assert.assertEquals(AxisLocation.BOTTOM_OR_RIGHT, chart.getCategoryPlot().getDomainAxisLocation());
    }

    @Test
    public void testBarChartAxisNotReversed() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertFalse(chart.getCategoryPlot().getRangeAxis().isInverted());
    }

    @Test
    public void testBarChartAxisReversed() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.getCategoryPlot().getRangeAxis().setInverted(true);
        Assert.assertTrue(chart.getCategoryPlot().getRangeAxis().isInverted());
    }

    @Test
    public void testBarChartNoCrosshair() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertFalse(chart.getCategoryPlot().isDomainCrosshairVisible());
    }
    @Test
    public void testBarChartCrosshair() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.getCategoryPlot().setDomainCrosshairVisible(true);
        Assert.assertTrue(chart.getCategoryPlot().isDomainCrosshairVisible());
    }

    @Test
    public void testBarChartNoAutoRange() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.getCategoryPlot().getRangeAxis().setAutoRange(false);
        Assert.assertFalse(chart.getCategoryPlot().getRangeAxis().isAutoRange());
    }

    @Test
    public void testBarChartAutoRange() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.getCategoryPlot().getRangeAxis().setAutoRange(true);
        Assert.assertTrue(chart.getCategoryPlot().getRangeAxis().isAutoRange());
    }

    @Test
    public void testBarChartNoAutoTickUnitSelection() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.getCategoryPlot().getRangeAxis().setAutoTickUnitSelection(false);
        Assert.assertFalse(chart.getCategoryPlot().getRangeAxis().isAutoTickUnitSelection());
    }

    @Test
    public void testBarChartAutoTickUnitSelection() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.getCategoryPlot().getRangeAxis().setAutoTickUnitSelection(true);
        Assert.assertTrue(chart.getCategoryPlot().getRangeAxis().isAutoTickUnitSelection());
    }

    @Test
    public void testBarChartTickMarkInside() {
        JFreeChart chart = ChartFactory.createBarChart("Title", "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.getCategoryPlot().getRangeAxis().setTickMarksVisible(true);
        Assert.assertTrue(chart.getCategoryPlot().getRangeAxis().isTickMarksVisible());
    }

}