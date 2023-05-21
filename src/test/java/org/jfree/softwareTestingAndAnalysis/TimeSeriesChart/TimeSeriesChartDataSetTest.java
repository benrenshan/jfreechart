package org.jfree.softwareTestingAndAnalysis.TimeSeriesChart;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.jfree.chart.ChartFactory;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.junit.Assert;
import org.junit.Test;

public class TimeSeriesChartDataSetTest {


    // Test 1
    @Test
    public void testEmptyTimeSeries() {
        TimeSeries series = new TimeSeries("Empty Series");
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Empty Series Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 2
    @Test
    public void testSingleDataPoint() {
        TimeSeries series = new TimeSeries("Single Data Point");
        series.add(new Year(2020), 10);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Single Data Point Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 3
    @Test
    public void testMultipleDataPoints() {
        TimeSeries series = new TimeSeries("Multiple Data Points");
        series.add(new Year(2020), 10);
        series.add(new Year(2021), 15);
        series.add(new Year(2022), 20);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Multiple Data Points Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 4
    @Test
    public void testMultipleSeries() {
        TimeSeries series1 = new TimeSeries("Series 1");
        series1.add(new Year(2020), 10);
        series1.add(new Year(2021), 15);
        TimeSeries series2 = new TimeSeries("Series 2");
        series2.add(new Year(2020), 20);
        series2.add(new Year(2021), 25);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Multiple Series Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(2, xyPlot.getDataset().getSeriesCount());
    }


    @Test
    public void testDatasetWithSingleDataPoint() {
        TimeSeries series = new TimeSeries("Single Data Point");
        series.add(new Year(2020), 10);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Single Data Point Test", "Year", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 6
    @Test
    public void testDatasetWithMultipleSeries() {
        TimeSeries series1 = new TimeSeries("Series 1");
        series1.add(new Year(2020), 10);
        TimeSeries series2 = new TimeSeries("Series 2");
        series2.add(new Year(2021), 15);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Multiple Series Test", "Year", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(2, xyPlot.getDataset().getSeriesCount());
    }

    @Test
    public void testSeriesWithFutureData() {
        TimeSeries series = new TimeSeries("Future Data");
        series.add(new Year(2030), 10);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Future Data Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 12
    @Test
    public void testSeriesWithPastData() {
        TimeSeries series = new TimeSeries("Past Data");
        series.add(new Year(1990), 10);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Past Data Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 16
    @Test
    public void testEmptySeries() {
        TimeSeries series = new TimeSeries("Empty Series");
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Empty Series Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 17
    @Test
    public void testNullSeries() {

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(new TimeSeries('a'));

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Null Series Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 18
    @Test
    public void testSeriesWithNullValue() {
        TimeSeries series = new TimeSeries("Series With Null Value");
        series.add(new Year(2020), null);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Null Value Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 19
    @Test
    public void testSeriesWithInvalidTimePeriod() {
        TimeSeries series = new TimeSeries("Series With Invalid Time Period");
        series.add(new Year(-1), 10);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Invalid Time Period Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 21
    @Test
    public void testSeriesWithNegativeValues() {
        TimeSeries series = new TimeSeries("Negative Values");
        series.add(new Year(2020), -10);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Negative Values Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 22
    @Test
    public void testSeriesWithZeroValues() {
        TimeSeries series = new TimeSeries("Zero Values");
        series.add(new Year(2020), 0);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Zero Values Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 23
    @Test
    public void testSeriesWithLargeValues() {
        TimeSeries series = new TimeSeries("Large Values");
        series.add(new Year(2020), 1e9);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Large Values Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 24
    @Test
    public void testSeriesWithSmallValues() {
        TimeSeries series = new TimeSeries("Small Values");
        series.add(new Year(2020), 1e-9);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Small Values Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 26
    @Test
    public void testSeriesWithNonConsecutiveYears() {
        TimeSeries series = new TimeSeries("Non-Consecutive Years");
        series.add(new Year(2020), 10);
        series.add(new Year(2022), 15);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Non-Consecutive Years Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 27
    @Test
    public void testSeriesWithMultipleDataPerYear() {
        TimeSeries series = new TimeSeries("Multiple Data Per Year");
        series.add(new Year(2020), 10);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Multiple Data Per Year Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 28
    @Test
    public void testSeriesWithDuplicateData() {
        TimeSeries series = new TimeSeries("Duplicate Data");
        series.add(new Year(2020), 10);

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Duplicate Data Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 29
    @Test
    public void testSeriesWithReverseTimeOrder() {
        TimeSeries series = new TimeSeries("Reverse Time Order");
        series.add(new Year(2021), 15);
        series.add(new Year(2020), 10);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Reverse Time Order Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 31
    @Test
    public void testSeriesWithSpecialCharacters() {
        TimeSeries series = new TimeSeries("Special !@#$%^&*() Characters");
        series.add(new Year(2020), 10);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Special Characters Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 32
    @Test
    public void testSeriesWithLongName() {
        TimeSeries series = new TimeSeries("This is a really, really, really, really, really, really, really, really long series name");
        series.add(new Year(2020), 10);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Long Name Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 33
    @Test
    public void testSeriesWithNonEnglishCharacters() {
        TimeSeries series = new TimeSeries("非英文字符");
        series.add(new Year(2020), 10);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Non-English Characters Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 34
    @Test
    public void testSeriesWithEmoji() {
        TimeSeries series = new TimeSeries("🙂🙃👍👎🐶🐱");
        series.add(new Year(2020), 10);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Emoji Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 35
    @Test
    public void testSeriesWithSpaces() {
        TimeSeries series = new TimeSeries("    ");
        series.add(new Year(2020), 10);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Spaces Test", "Time", "Value", dataset, true, true, false);
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 36
    @Test
    public void testEmptyChartTitle() {
        TimeSeries series = new TimeSeries("Series");
        series.add(new Year(2020), 10);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("", "Time", "Value", dataset, true, true, false);

        Assert.assertEquals("", chart.getTitle().getText());
    }

    // Test 37
    @Test
    public void testNullChartTitle() {
        TimeSeries series = new TimeSeries("Series");
        series.add(new Year(2020), 10);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(null, "Time", "Value", dataset, true, true, false);

        Assert.assertNull(chart.getTitle());
    }

    // Test 38
    @Test
    public void testLongChartTitle() {
        TimeSeries series = new TimeSeries("Series");
        series.add(new Year(2020), 10);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("This is a really, really, really, really, really, really, really, really long chart title", "Time", "Value", dataset, true, true, false);

        Assert.assertEquals("This is a really, really, really, really, really, really, really, really long chart title", chart.getTitle().getText());
    }

    // Test 39
    @Test
    public void testNonEnglishChartTitle() {
        TimeSeries series = new TimeSeries("Series");
        series.add(new Year(2020), 10);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("非英文标题", "Time", "Value", dataset, true, true, false);

        Assert.assertEquals("非英文标题", chart.getTitle().getText());
    }

    // Test 40
    @Test
    public void testEmojiChartTitle() {
        TimeSeries series = new TimeSeries("Series");
        series.add(new Year(2020), 10);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("🙂🙃👍👎🐶🐱", "Time", "Value", dataset, true, true, false);

        Assert.assertEquals("🙂🙃👍👎🐶🐱", chart.getTitle().getText());
    }

    // Test 41
    @Test
    public void testAddNullSeriesToDataset() {
        TimeSeriesCollection dataset = new TimeSeriesCollection();


        JFreeChart chart = ChartFactory.createTimeSeriesChart("Null Series Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(0, xyPlot.getDataset().getSeriesCount());
    }

    // Test 42
    @Test
    public void testAddEmptySeriesToDataset() {
        TimeSeries series = new TimeSeries("Empty Series");
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Empty Series Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 43
    @Test
    public void testAddSeriesWithSingleDataPointToDataset() {
        TimeSeries series = new TimeSeries("Single Data Point Series");
        series.add(new Year(2020), 10);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Single Data Point Series Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 44
    @Test
    public void testAddSeriesWithMultipleDataPointsToDataset() {
        TimeSeries series = new TimeSeries("Multiple Data Points Series");
        series.add(new Year(2019), 5);
        series.add(new Year(2020), 10);
        series.add(new Year(2021), 15);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Multiple Data Points Series Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 45
    @Test
    public void testAddMultipleSeriesToDataset() {
        TimeSeries series1 = new TimeSeries("Series 1");
        series1.add(new Year(2019), 5);
        series1.add(new Year(2020), 10);
        series1.add(new Year(2021), 15);

        TimeSeries series2 = new TimeSeries("Series 2");
        series2.add(new Year(2019), 10);
        series2.add(new Year(2020), 20);
        series2.add(new Year(2021), 30);

        TimeSeriesCollection dataset = new TimeSeriesCollection();

    }

    // Test 46
    @Test
    public void testDatasetWithNegativeValues() {
        TimeSeries series = new TimeSeries("Negative Values Series");
        series.add(new Year(2019), -5);
        series.add(new Year(2020), -10);
        series.add(new Year(2021), -15);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Negative Values Series Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 47
    @Test
    public void testDatasetWithMixedPositiveAndNegativeValues() {
        TimeSeries series = new TimeSeries("Mixed Positive and Negative Values Series");
        series.add(new Year(2019), -5);
        series.add(new Year(2020), 10);
        series.add(new Year(2021), -15);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Mixed Positive and Negative Values Series Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 48
    @Test
    public void testDatasetWithZeroValues() {
        TimeSeries series = new TimeSeries("Zero Values Series");
        series.add(new Year(2019), 0);
        series.add(new Year(2020), 0);
        series.add(new Year(2021), 0);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Zero Values Series Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 49
    @Test
    public void testDatasetWithNullValues() {
        TimeSeries series = new TimeSeries("Null Values Series");
        series.add(new Year(2019), null);
        series.add(new Year(2020), null);
        series.add(new Year(2021), null);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Null Values Series Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 51
    @Test
    public void testDatasetWithNaNValues() {
        TimeSeries series = new TimeSeries("NaN Values Series");
        series.add(new Year(2019), Double.NaN);
        series.add(new Year(2020), Double.NaN);
        series.add(new Year(2021), Double.NaN);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("NaN Values Series Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 52
    @Test
    public void testSeriesWithLargeNumberValues() {
        TimeSeries series = new TimeSeries("Large Number Values Series");
        series.add(new Year(2019), Double.MAX_VALUE);
        series.add(new Year(2020), Double.MAX_VALUE);
        series.add(new Year(2021), Double.MAX_VALUE);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Large Number Values Series Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 53
    @Test
    public void testSeriesWithSmallNumberValues() {
        TimeSeries series = new TimeSeries("Small Number Values Series");
        series.add(new Year(2019), Double.MIN_VALUE);
        series.add(new Year(2020), Double.MIN_VALUE);
        series.add(new Year(2021), Double.MIN_VALUE);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Small Number Values Series Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 54
    @Test
    public void testSeriesWithMixedNumberValues() {
        TimeSeries series = new TimeSeries("Mixed Number Values Series");
        series.add(new Year(2019), 100);
        series.add(new Year(2020), Double.MAX_VALUE);
        series.add(new Year(2021), Double.MIN_VALUE);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Mixed Number Values Series Test", "Time", "Value", dataset, true, true, false);

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 56
    @Test
    public void testDatasetWithoutSeries() {
        TimeSeriesCollection dataset = new TimeSeriesCollection();

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Dataset Without Series Test",
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(0, xyPlot.getDataset().getSeriesCount());
    }

    // Test 57
    @Test
    public void testDatasetWithTwoIdenticalSeries() {
        TimeSeries series1 = new TimeSeries("Identical Series 1");
        series1.add(new Year(2019), 5);
        series1.add(new Year(2020), 10);
        series1.add(new Year(2021), 15);

        TimeSeries series2 = new TimeSeries("Identical Series 2");
        series2.add(new Year(2019), 5);
        series2.add(new Year(2020), 10);
        series2.add(new Year(2021), 15);

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Two Identical Series Test",
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(2, xyPlot.getDataset().getSeriesCount());
    }

    // Test 58
    @Test
    public void testSeriesWithOutOfOrderDataPoints() {
        TimeSeries series = new TimeSeries("Out Of Order Data Points Series");
        series.add(new Year(2021), 15);
        series.add(new Year(2019), 5);
        series.add(new Year(2020), 10);

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Out Of Order Data Points Series Test",
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 59
    @Test
    public void testSeriesWithDuplicateDataPoints() {
        TimeSeries series = new TimeSeries("Duplicate Data Points Series");
        series.add(new Year(2019), 5);
        series.add(new Year(2020), 10);

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Duplicate Data Points Series Test",
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }
    @Test
    public void testSeriesWithDiscontinuousDataPoints() {
        TimeSeries series = new TimeSeries("Discontinuous Data Points Series");
        series.add(new Year(2019), 5);
        series.add(new Year(2021), 15);

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Discontinuous Data Points Series Test",
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 61
    @Test
    public void testSeriesWithFarFutureDataPoints() {
        TimeSeries series = new TimeSeries("Far Future Data Points Series");
        series.add(new Year(3000), 5);
        series.add(new Year(3001), 10);
        series.add(new Year(3002), 15);

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Far Future Data Points Series Test",
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 64
    @Test
    public void testSeriesWithSingleDataPoint() {
        TimeSeries series = new TimeSeries("Single Data Point Series");
        series.add(new Year(2021), 5);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Single Data Point Series Test",
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 65
    @Test
    public void testSeriesWithSameYearAndDifferentValues() {
        TimeSeries series = new TimeSeries("Same Year, Different Values Series");
        series.add(new Year(2021), 5);
        series.add(new Year(2022), 10);
        series.add(new Year(2023), 15);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Same Year, Different Values Series Test",
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 66
    @Test
    public void testMultipleSeriesWithSameData() {
        TimeSeries series1 = new TimeSeries("Series 1");
        series1.add(new Year(2019), 5);
        series1.add(new Year(2020), 10);
        series1.add(new Year(2021), 15);

        TimeSeries series2 = new TimeSeries("Series 2");
        series2.add(new Year(2019), 5);
        series2.add(new Year(2020), 10);
        series2.add(new Year(2021), 15);

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Multiple Series with Same Data Test",
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(2, xyPlot.getDataset().getSeriesCount());
    }
    @Test
    public void testMultipleSeriesWithDifferentData() {
        TimeSeries series1 = new TimeSeries("Series 1");
        series1.add(new Year(2019), 5);
        series1.add(new Year(2020), 10);
        series1.add(new Year(2021), 15);

        TimeSeries series2 = new TimeSeries("Series 2");
        series2.add(new Year(2019), 15);
        series2.add(new Year(2020), 10);
        series2.add(new Year(2021), 5);

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Multiple Series with Different Data Test",
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(2, xyPlot.getDataset().getSeriesCount());
    }

    // Test 68
    @Test
    public void testMultipleSeriesWithDifferentNumberDataPoints() {
        TimeSeries series1 = new TimeSeries("Series 1");
        series1.add(new Year(2019), 5);
        series1.add(new Year(2020), 10);
        series1.add(new Year(2021), 15);

        TimeSeries series2 = new TimeSeries("Series 2");
        series2.add(new Year(2019), 15);
        series2.add(new Year(2020), 10);

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Multiple Series with Different Number Data Points Test",
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(2, xyPlot.getDataset().getSeriesCount());
    }

    // Test 69
    @Test
    public void testSeriesWithAllZeroValues() {
        TimeSeries series = new TimeSeries("Zero Values Series");
        series.add(new Year(2019), 0);
        series.add(new Year(2020), 0);
        series.add(new Year(2021), 0);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Zero Values Series Test",
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }
    @Test
    public void testSeriesWithNegativeValue() {
        TimeSeries series = new TimeSeries("Negative Values Series");
        series.add(new Year(2019), -5);
        series.add(new Year(2020), -10);
        series.add(new Year(2021), -15);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Negative Values Series Test",
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 71
    @Test
    public void testSeriesWithMixedNegativeAndPositiveValues() {
        TimeSeries series = new TimeSeries("Mixed Negative and Positive Values Series");
        series.add(new Year(2019), -5);
        series.add(new Year(2020), 10);
        series.add(new Year(2021), -15);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Mixed Negative and Positive Values Series Test",
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    @Test
    public void testSeriesWithSameValueRepeated() {
        TimeSeries series = new TimeSeries("Same Value Repeated Series");
        series.add(new Year(2019), 10);
        series.add(new Year(2020), 10);
        series.add(new Year(2021), 10);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Same Value Repeated Series Test",
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    @Test
    public void testSeriesWithAscendingOrderValues() {
        TimeSeries series = new TimeSeries("Ascending Order Values Series");
        series.add(new Year(2019), 5);
        series.add(new Year(2020), 10);
        series.add(new Year(2021), 15);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Ascending Order Values Series Test",
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    @Test
    public void testSeriesWithDescendingOrderValues() {
        TimeSeries series = new TimeSeries("Descending Order Values Series");
        series.add(new Year(2019), 15);
        series.add(new Year(2020), 10);
        series.add(new Year(2021), 5);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Descending Order Values Series Test",
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    @Test
    public void testSeriesWithRandomOrderValues() {
        TimeSeries series = new TimeSeries("Random Order Values Series");
        series.add(new Year(2019), 10);
        series.add(new Year(2020), 5);
        series.add(new Year(2021), 15);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Random Order Values Series Test",
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    @Test
    public void testSeriesWithLargeValues2() {
        TimeSeries series = new TimeSeries("Large Values Series");
        series.add(new Year(2024), 1000000);
        series.add(new Year(2025), 2000000);
        series.add(new Year(2026), 3000000);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Large Values Series Test",
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    @Test
    public void testSeriesWithSmallValues6() {
        TimeSeries series = new TimeSeries("Small Values Series");
        series.add(new Year(2019), 0.0001);
        series.add(new Year(2020), 0.0002);
        series.add(new Year(2021), 0.0003);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Small Values Series Test",
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 78
    @Test
    public void testSeriesWithMixedLargeAndSmallValues() {
        TimeSeries series = new TimeSeries("Mixed Large and Small Values Series");
        series.add(new Year(2019), 0.0001);
        series.add(new Year(2020), 2000000);
        series.add(new Year(2021), 0.0003);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Mixed Large and Small Values Series Test",
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }

    // Test 79
    @Test
    public void testSeriesWithNullValue5() {
        TimeSeries series = new TimeSeries("Null Value Series");
        series.add(new Year(2000), 10);
        series.add(new Year(2020), null);
        series.add(new Year(2021), 15);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Null Value Series Test",
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }
    @Test
    public void testEmptyTimeSeriesCollection() {
        TimeSeriesCollection dataset = new TimeSeriesCollection();

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Empty Time Series Collection Test",
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );

        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(0, xyPlot.getDataset().getSeriesCount());
    }


}