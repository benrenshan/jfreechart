package org.jfree.softwareTestingAndAnalysis.XYChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.util.PublicCloneable;
import org.jfree.data.xy.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class XYChartGenerationTest {

    @Test
    public void testChartCreation() {
        XYSeries series = new XYSeries("Test Data");
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        XYSeriesCollection data = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart("Test Chart", "X", "Y", data);
        Assert.assertNotNull(chart);
        Assertions.assertEquals("Test Chart", chart.getTitle().getText());
    }

    @Test
    public void testSeriesCreation() {
        XYSeries series = new XYSeries("Test Data");
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        Assertions.assertEquals(2, series.getItemCount());
        Assertions.assertEquals(1.0, series.getX(0).doubleValue(), 0.001);
        Assertions.assertEquals(1.0, series.getY(0).doubleValue(), 0.001);
    }

    @Test
    public void testPlotProperties() {
        XYSeries series = new XYSeries("Test Data");
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        XYSeriesCollection data = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart("Test Chart", "X", "Y", data);
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertNotNull(plot);
        Assertions.assertEquals(0.0, plot.getDomainCrosshairValue(), 0.001);
    }

    @Test
    public void testMultipleSeries() {
        XYSeries series1 = new XYSeries("Test Data 1");
        series1.add(1.0, 1.0);
        series1.add(2.0, 2.0);
        XYSeries series2 = new XYSeries("Test Data 2");
        series2.add(3.0, 3.0);
        series2.add(4.0, 4.0);
        XYSeriesCollection data = new XYSeriesCollection();
        data.addSeries(series1);
        data.addSeries(series2);
        Assertions.assertEquals(2, data.getSeriesCount());
        Assertions.assertEquals(2, data.getItemCount(0));
        Assertions.assertEquals(2, data.getItemCount(1));
    }

    @Test
    public void testLegendCreation() {
        XYSeries series = new XYSeries("Test Data");
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        XYSeriesCollection data = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart("Test Chart", "X", "Y", data);
        Assert.assertNotNull(chart.getLegend());

    }

    @Test
    public void testRenderer() {
        XYSeries series = new XYSeries("Test Data");
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        XYSeriesCollection data = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart("Test Chart", "X", "Y", data);
        XYPlot plot = chart.getXYPlot();
        Assertions.assertTrue(plot.getRenderer() instanceof XYLineAndShapeRenderer);
    }

    @Test
    public void testAutoRange() {
        XYSeries series = new XYSeries("Test Data");
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        XYSeriesCollection data = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart("Test Chart", "X", "Y", data);
        XYPlot plot = chart.getXYPlot();
        Assertions.assertTrue(plot.getRangeAxis().isAutoRange());
    }

    @Test
    public void testAxisLabels() {
        XYSeries series = new XYSeries("Test Data");
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        XYSeriesCollection data = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart("Test Chart", "X", "Y", data);
        XYPlot plot = chart.getXYPlot();
        Assertions.assertEquals("X", plot.getDomainAxis().getLabel());
        Assertions.assertEquals("Y", plot.getRangeAxis().getLabel());
    }

    @Test
    public void testZeroCrosshairVisible() {
        XYSeries series = new XYSeries("Test Data");
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        XYSeriesCollection data = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart("Test Chart", "X", "Y", data);
        XYPlot plot = chart.getXYPlot();
        Assert.assertFalse(plot.isDomainZeroBaselineVisible());
        Assert.assertFalse(plot.isRangeZeroBaselineVisible());
    }

    @Test
    public void testSeriesKey() {
        XYSeries series = new XYSeries("Test Data");
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        XYSeriesCollection data = new XYSeriesCollection(series);
        Assertions.assertEquals("Test Data", data.getSeriesKey(0));
    }

    @Test
    public void testRemoveSeries() {
        XYSeries series = new XYSeries("Test Data");
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        XYSeriesCollection data = new XYSeriesCollection(series);
        data.removeSeries(0);
        Assertions.assertEquals(0, data.getSeriesCount());
    }

    @Test
    public void testGetSeries() {
        XYSeries series = new XYSeries("Test Data");
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        XYSeriesCollection data = new XYSeriesCollection(series);
        Assertions.assertSame(series, data.getSeries(0));
    }

    @Test
    public void testGetItemCount() {
        XYSeries series = new XYSeries("Test Data");
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        XYSeriesCollection data = new XYSeriesCollection(series);
        Assertions.assertEquals(2, data.getItemCount(0));
    }

    @Test
    public void testGetXValue() {
        XYSeries series = new XYSeries("Test Data");
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        XYSeriesCollection data = new XYSeriesCollection(series);
        Assertions.assertEquals(1.0, data.getXValue(0, 0), 0.001);
    }

    @Test
    public void testGetYValue() {
        XYSeries series = new XYSeries("Test Data");
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        XYSeriesCollection data = new XYSeriesCollection(series);
        Assertions.assertEquals(1.0, data.getYValue(0, 0), 0.001);

    }

    @Test
    public void testNullSeriesKey() {
        XYSeries series = new XYSeries('x');
        XYSeriesCollection data = new XYSeriesCollection(series);
        Assert.assertNotNull(data.getSeriesKey(0));
    }

    @Test
    public void testInitialDomainRange() {
        XYSeries series = new XYSeries("Test Data");
        XYSeriesCollection data = new XYSeriesCollection(series);
        Assertions.assertEquals(Double.NaN, data.getDomainLowerBound(false), 0.001);
        Assertions.assertEquals(Double.NaN, data.getDomainUpperBound(false), 0.001);
    }

    @Test
    public void testInitialRangeRange() {
        XYSeries series = new XYSeries("Test Data");
        XYSeriesCollection data = new XYSeriesCollection(series);
        Assertions.assertEquals(Double.NaN, data.getRangeLowerBound(false), 0.001);
        Assertions.assertEquals(Double.NaN, data.getRangeUpperBound(false), 0.001);
    }

    @Test
    public void testDomainRangeAfterAddingData() {
        XYSeries series = new XYSeries("Test Data");
        series.add(1.0, 2.0);
        XYSeriesCollection data = new XYSeriesCollection(series);
        Assertions.assertEquals(1.0, data.getDomainLowerBound(false), 0.001);
        Assertions.assertEquals(1.0, data.getDomainUpperBound(false), 0.001);
    }

    @Test
    public void testRangeRangeAfterAddingData() {
        XYSeries series = new XYSeries("Test Data");
        series.add(1.0, 2.0);
        XYSeriesCollection data = new XYSeriesCollection(series);
        Assertions.assertEquals(2.0, data.getRangeLowerBound(false), 0.001);
        Assertions.assertEquals(2.0, data.getRangeUpperBound(false), 0.001);
    }

    @Test
    public void testClearSeries() {
        XYSeries series = new XYSeries("Test Data");
        series.add(1.0, 2.0);
        series.clear();
        Assertions.assertEquals(0, series.getItemCount());
    }

    @Test
    public void testDeleteSeriesItem() {
        XYSeries series = new XYSeries("Test Data");
        series.add(1.0, 2.0);
        series.delete(0, 0);
        Assertions.assertEquals(0, series.getItemCount());
    }

    @Test
    public void testMaximumItemCount() {
        XYSeries series = new XYSeries("Test Data", true, false);
        series.setMaximumItemCount(1);
        series.add(1.0, 2.0);
        series.add(2.0, 3.0);
        Assertions.assertEquals(1, series.getItemCount());
    }

    @Test
    public void testNegativeValues() {
        XYSeries series = new XYSeries("Test Data");
        series.add(-1.0, -2.0);
        XYSeriesCollection data = new XYSeriesCollection(series);
        Assertions.assertEquals(-1.0, data.getXValue(0, 0), 0.001);
        Assertions.assertEquals(-2.0, data.getYValue(0, 0), 0.001);
    }

    @Test
    public void testAddSeries() {
        XYSeriesCollection data = new XYSeriesCollection();
        data.addSeries(new XYSeries("Test Data"));
        Assertions.assertEquals(1, data.getSeriesCount());
    }

    @Test
    public void testRemoveAllSeries() {
        XYSeriesCollection data = new XYSeriesCollection();
        data.addSeries(new XYSeries("Test Data 1"));
        data.addSeries(new XYSeries("Test Data 2"));
        data.removeAllSeries();
        Assertions.assertEquals(0, data.getSeriesCount());
    }

    @org.junit.jupiter.api.Test
    public void testEquals0() {
        MatrixSeries s1 = new MatrixSeries("Series", 2, 3);
        s1.update(0, 0, 1.1);
        MatrixSeriesCollection c1 = new MatrixSeriesCollection();
        c1.addSeries(s1);
        MatrixSeries s2 = new MatrixSeries("Series", 2, 3);
        s2.update(0, 0, 1.1);
        MatrixSeriesCollection c2 = new MatrixSeriesCollection();
        c2.addSeries(s2);
        Assertions.assertEquals(c1, c2);
        Assertions.assertEquals(c2, c1);

        c1.addSeries(new MatrixSeries("Empty Series", 1, 1));
        Assertions.assertNotEquals(c1, c2);

        c2.addSeries(new MatrixSeries("Empty Series", 1, 1));
        Assertions.assertEquals(c1, c2);
    }

    /**
     * Confirm that cloning works.
     */
    @org.junit.jupiter.api.Test
    public void testCloning0() throws CloneNotSupportedException {
        MatrixSeries s1 = new MatrixSeries("Series", 2, 3);
        s1.update(0, 0, 1.1);
        MatrixSeriesCollection c1 = new MatrixSeriesCollection();
        c1.addSeries(s1);
        MatrixSeriesCollection c2 = (MatrixSeriesCollection) c1.clone();

        Assertions.assertNotSame(c1, c2);
        Assertions.assertSame(c1.getClass(), c2.getClass());
        Assertions.assertEquals(c1, c2);

        // check independence
        s1.setDescription("XYZ");
        Assertions.assertNotEquals(c1, c2);
    }
    @org.junit.jupiter.api.Test
    public void testEquals() {
        XYSeries s1 = new XYSeries("Series");
        s1.add(1.2, 3.4);
        XYSeriesCollection c1 = new XYSeriesCollection();
        c1.addSeries(s1);
        IntervalXYDelegate d1 = new IntervalXYDelegate(c1);

        XYSeries s2 = new XYSeries("Series");
        XYSeriesCollection c2 = new XYSeriesCollection();
        s2.add(1.2, 3.4);
        c2.addSeries(s2);
        IntervalXYDelegate d2 = new IntervalXYDelegate(c2);

        Assertions.assertEquals(d1, d2);
        Assertions.assertEquals(d2, d1);

        d1.setAutoWidth(false);
        Assertions.assertNotEquals(d1, d2);
        d2.setAutoWidth(false);
        Assertions.assertEquals(d1, d2);

        d1.setIntervalPositionFactor(0.123);
        Assertions.assertNotEquals(d1, d2);
        d2.setIntervalPositionFactor(0.123);
        Assertions.assertEquals(d1, d2);

        d1.setFixedIntervalWidth(1.23);
        Assertions.assertNotEquals(d1, d2);
        d2.setFixedIntervalWidth(1.23);
        Assertions.assertEquals(d1, d2);
    }

    /**
     * Confirm that cloning works.
     */
    @org.junit.jupiter.api.Test
    public void testCloning() throws CloneNotSupportedException {
        XYSeries s1 = new XYSeries("Series");
        s1.add(1.2, 3.4);
        XYSeriesCollection c1 = new XYSeriesCollection();
        c1.addSeries(s1);
        IntervalXYDelegate d1 = new IntervalXYDelegate(c1);
        IntervalXYDelegate d2 = (IntervalXYDelegate) d1.clone();
        Assertions.assertNotSame(d1, d2);
        Assertions.assertSame(d1.getClass(), d2.getClass());
        Assertions.assertEquals(d1, d2);
    }


    @org.junit.jupiter.api.Test
    public void testSerialization0() {
        XYSeries s1 = new XYSeries("Series");
        s1.add(1.2, 3.4);
        XYSeriesCollection c1 = new XYSeriesCollection();
        c1.addSeries(s1);
        IntervalXYDelegate d1 = new IntervalXYDelegate(c1);
        IntervalXYDelegate d2 = d1;
        Assertions.assertEquals(d1, d2);
    }

    @org.junit.jupiter.api.Test
    public void testPublicCloneable() {
        MatrixSeriesCollection c1 = new MatrixSeriesCollection();
        Assertions.assertTrue(c1 instanceof PublicCloneable);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    @org.junit.jupiter.api.Test
    public void testSerialization() {
        MatrixSeries s1 = new MatrixSeries("Series", 2, 3);
        s1.update(0, 0, 1.1);
        MatrixSeriesCollection c1 = new MatrixSeriesCollection();
        c1.addSeries(s1);
        MatrixSeriesCollection c2 = c1;
        Assertions.assertEquals(c1, c2);
    }

    @Test
    public void testAutoSort() {
        XYSeries series = new XYSeries("Test Data", true, false);
        series.add(2.0, 3.0);
        series.add(1.0, 2.0);
        Assertions.assertEquals(1.0, series.getX(0).doubleValue(), 0.001);
        Assertions.assertEquals(2.0, series.getX(1).doubleValue(), 0.001);
    }

    @Test
    public void testNoAutoSort() {
        XYSeries series = new XYSeries("Test Data", false, false);
        series.add(2.0, 3.0);
        series.add(1.0, 2.0);
        Assertions.assertEquals(2.0, series.getX(0).doubleValue(), 0.001);
        Assertions.assertEquals(1.0, series.getX(1).doubleValue(), 0.001);
    }

    @Test
    public void testGetMinimumDomainValue() {
        XYSeries series = new XYSeries("Test Data");
        series.add(2.0, 3.0);
        series.add(1.0, 2.0);
        XYSeriesCollection data = new XYSeriesCollection(series);
        Assertions.assertEquals(1.0, data.getDomainLowerBound(false), 0.001);
    }

    @Test
    public void testGetMaximumDomainValue() {
        XYSeries series = new XYSeries("Test Data");
        series.add(2.0, 3.0);
        series.add(1.0, 2.0);
        XYSeriesCollection data = new XYSeriesCollection(series);
        Assertions.assertEquals(2.0, data.getDomainUpperBound(false), 0.001);
    }

    @Test
    public void testGetMinimumRangeValue() {
        XYSeries series = new XYSeries("Test Data");
        series.add(2.0, 3.0);
        series.add(1.0, 2.0);
        XYSeriesCollection data = new XYSeriesCollection(series);
        Assertions.assertEquals(2.0, data.getRangeLowerBound(false), 0.001);
    }

    public void testGetMaximumRangeValue() {
        XYSeries series = new XYSeries("Test Data");
        series.add(2.0, 3.0);
        series.add(1.0, 2.0);
        XYSeriesCollection data = new XYSeriesCollection(series);
        Assertions.assertEquals(3.0, data.getRangeUpperBound(false), 0.001);
    }

    @Test
    public void testAllowDuplicateXValues() {
        XYSeries series = new XYSeries("Test Data", true, true);
        series.add(1.0, 2.0);
        series.add(1.0, 3.0);
        Assertions.assertEquals(2, series.getItemCount());
    }

    @Test
    public void testDisallowDuplicateXValues() {
        XYSeries series = new XYSeries("Test Data", true, false);
        series.add(1.0, 2.0);
        series.add(2.0, 3.0);
        Assertions.assertEquals(2, series.getItemCount());
    }

    // ... Your previous test cases ...


    @Test
    public void testSetSeriesKeys() {
        XYSeries series1 = new XYSeries("Test Data 1");
        XYSeries series2 = new XYSeries("Test Data 2");
        XYSeriesCollection data = new XYSeriesCollection();
        data.addSeries(series1);
        data.addSeries(series2);
        Assertions.assertEquals("Test Data 1", data.getSeriesKey(0));
        Assertions.assertEquals("Test Data 2", data.getSeriesKey(1));
    }

    @Test
    public void testAddMultipleSeries() {
        XYSeries series1 = new XYSeries("Test Data 1");
        XYSeries series2 = new XYSeries("Test Data 2");
        XYSeriesCollection data = new XYSeriesCollection();
        data.addSeries(series1);
        data.addSeries(series2);
        Assertions.assertEquals(2, data.getSeriesCount());
    }


    @Test
    public void testIndexOf() {
        XYSeries series = new XYSeries("Test Data");
        XYSeriesCollection data = new XYSeriesCollection(series);
        Assertions.assertEquals(0, data.indexOf("Test Data"));
    }

    @Test
    public void testGetSeriesByIndex() {
        XYSeries series = new XYSeries("Test Data");
        XYSeriesCollection data = new XYSeriesCollection(series);
        Assertions.assertEquals(series, data.getSeries(0));
    }

    @Test
    public void testGetSeriesByKey() {
        XYSeries series = new XYSeries("Test Data");
        XYSeriesCollection data = new XYSeriesCollection(series);
        Assertions.assertEquals(series, data.getSeries("Test Data"));
    }

    @Test
    public void testGetSeriesCount() {
        XYSeries series1 = new XYSeries("Test Data 1");
        XYSeries series2 = new XYSeries("Test Data 2");
        XYSeriesCollection data = new XYSeriesCollection();
        data.addSeries(series1);
        data.addSeries(series2);
        Assertions.assertEquals(2, data.getSeriesCount());
    }

    @Test
    public void testGetItemCountForSeries() {
        XYSeries series = new XYSeries("Test Data");
        series.add(1.0, 2.0);
        series.add(2.0, 3.0);
        XYSeriesCollection data = new XYSeriesCollection(series);
        Assertions.assertEquals(2, data.getItemCount(0));
    }


}
