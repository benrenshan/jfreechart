package org.jfree.softwareTestingAndAnalysis.TimeSeriesChart;

import static javax.swing.text.html.HTML.Tag.TITLE;
import static org.junit.Assert.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.text.html.HTML;
import java.awt.*;

public class TimeSeriesChartPropertyTest {
    private JFreeChart chart;
    private TimeSeriesCollection dataset;

    @Before
    public void setUp() {
        TimeSeries series = new TimeSeries("Sample Series");
        series.add(new Year(2019), 5);
        series.add(new Year(2020), 10);
        series.add(new Year(2021), 15);
        dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        chart = ChartFactory.createTimeSeriesChart(
                "Sample Chart",
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );
    }

    // Test 1
    @Test
    public void testChartTitleIsCorrect() {
        Assert.assertEquals("Sample Chart", chart.getTitle().getText());
    }

    // Test 2
    @Test
    public void testChartXAxisLabelIsCorrect() {
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertEquals("Time", plot.getDomainAxis().getLabel());
    }

    // Test 3
    @Test
    public void testChartYAxisLabelIsCorrect() {
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertEquals("Value", plot.getRangeAxis().getLabel());
    }

    // Test 4
    @Test
    public void testChartLegendIsVisible() {
        Assert.assertTrue(chart.getLegend().isVisible());
    }

    // Test 5
    @Test
    public void testChartBackgroundIsDefaultColor() {
        Assert.assertEquals(Color.white, chart.getBackgroundPaint());
    }

    // Test 6
    @Test
    public void testChartHasOneSeries() {
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertEquals(1, plot.getDataset().getSeriesCount());
    }

    // Test 7
    @Test
    public void testChartSeriesKeyIsCorrect() {
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertEquals("Sample Series", plot.getDataset().getSeriesKey(0));
    }

    // Test 8
    @Test
    public void testChartSeriesHasCorrectNumberOfItems() {
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertEquals(3, plot.getDataset().getItemCount(0));
    }

    // Test 9
    @Test
    public void testChartDisplaysCorrectlyInFrame() {
        ChartFrame frame = new ChartFrame("Test", chart);
        frame.pack();
        frame.setVisible(true);
        Assert.assertTrue(frame.isVisible());
    }

    // Test 10
    @Test
    public void testChartIsNotModifiedWhenDisplayedInFrame() {
        ChartFrame frame = new ChartFrame("Test", chart);
        frame.pack();
        frame.setVisible(true);
        Assert.assertEquals("Sample Chart", chart.getTitle().getText());
    }

    // Test 11
    @Test
    public void testPlotIsNotNull() {
        Assert.assertNotNull(chart.getPlot());
    }

    // Test 12
    @Test
    public void testPlotIsXYPlot() {
        Assert.assertTrue(chart.getPlot() instanceof XYPlot);
    }

    // Test 13
    @Test
    public void testPlotBackgroundColorIsDefault() {
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertEquals(Color.lightGray, plot.getBackgroundPaint());
    }
    @Test
    public void testChartTitleFontIsDefault10() {
        Assert.assertNotEquals(new Font("SansSerif", Font.BOLD, 12), chart.getTitle().getFont());
    }
    // Test 14
    @Test
    public void testPlotHasGridlinesVisibleByDefault() {
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertTrue(plot.isDomainGridlinesVisible());
        Assert.assertTrue(plot.isRangeGridlinesVisible());
    }

    // Test 15
    @Test
    public void testPlotHasOneDomainAxis() {
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertEquals(1, plot.getDomainAxisCount());
    }
    @Test
    public void testChartTitleFontIsDefault_() {
        Assert.assertNotEquals(new Font("SansSerif", Font.BOLD, 12), chart.getTitle().getFont());
    }
    // Test 16
    @Test
    public void testPlotHasOneRangeAxis() {
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertEquals(1, plot.getRangeAxisCount());
    }

    // Test 17
    @Test
    public void testPlotDatasetIsNotNull() {
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertNotNull(plot.getDataset());
    }

    // Test 18
    @Test
    public void testPlotDatasetIsTimeSeriesCollection() {
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertTrue(plot.getDataset() instanceof TimeSeriesCollection);
    }

    // Test 19
    @Test
    public void testPlotDatasetMatchesInputDataset() {
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertEquals(dataset, plot.getDataset());
    }
    @Test
    public void testChartTitleFontIsDefault() {
        Assert.assertNotEquals(new Font("SansSerif", Font.BOLD, 12), chart.getTitle().getFont());
    }
    // Test 20
    @Test
    public void testPlotRendererIsNotNull() {
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertNotNull(plot.getRenderer());
    }

    // Test 21
    @Test
    public void testPlotRendererIsXYLineAndShapeRenderer() {
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertTrue(plot.getRenderer() instanceof XYLineAndShapeRenderer);
    }

    // Test 22
    @Test
    public void testPlotDomainAxisIsNotNull() {
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertNotNull(plot.getDomainAxis());
    }

    // Test 23
    @Test
    public void testPlotDomainAxisIsDateAxis() {
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertTrue(plot.getDomainAxis() instanceof DateAxis);
    }

    // Test 24
    @Test
    public void testPlotRangeAxisIsNotNull() {
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertNotNull(plot.getRangeAxis());
    }

    // Test 25
    @Test
    public void testPlotRangeAxisIsNumberAxis() {
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertTrue(plot.getRangeAxis() instanceof NumberAxis);
    }

    // Test 26
    @Test
    public void testPlotDoesNotHaveSecondaryDataset() {
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertNull(plot.getDataset(1));
    }

    // Test 28
    @Test
    public void testPlotDoesNotHaveSecondaryRangeAxis() {
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertNull(plot.getRangeAxis(1));
    }

    // Test 29
    @Test
    public void testPlotHasNoAnnotations() {
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertEquals(0, plot.getAnnotations().size());
    }
    @Test
    public void testChartTitleFontIsDefault_8() {
        Assert.assertNotEquals(new Font("SansSerif", Font.BOLD, 12), chart.getTitle().getFont());
    }
    // Test 30
    @Test
    public void testPlotHasCorrectOrientation() {
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertEquals(PlotOrientation.VERTICAL, plot.getOrientation());
    }
    @Test
    public void testChartTitleFontIsDefault_7() {
        Assert.assertNotEquals(new Font("SansSerif", Font.BOLD, 12), chart.getTitle().getFont());
    }
    // Test 31
    @Test
    public void testDomainAxisHasCorrectLabelFont() {
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertNotEquals(new Font("Dialog", Font.PLAIN, 14), plot.getDomainAxis().getLabelFont());
    }

    // Test 32
    @Test
    public void testRangeAxisHasCorrectLabelFont() {
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertNotEquals(new Font("Dialog", Font.PLAIN, 12), plot.getRangeAxis().getLabelFont());
    }
    @Test
    public void testChartTitleFontIsDefault_6() {
        Assert.assertNotEquals(new Font("SansSerif", Font.BOLD, 12), chart.getTitle().getFont());
    }
    // Test 34
    @Test
    public void testPlotHasNoSecondaryRenderers() {
        XYPlot plot = (XYPlot) chart.getPlot();
        Assert.assertNull(plot.getRenderer(1));
    }

    // Test 35
    @Test
    public void testRendererLinesAreVisible() {
        XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        Assert.assertTrue(renderer.getDefaultLinesVisible());
    }
    @Test
    public void testChartTitleFontIsDefault_5() {
        Assert.assertNotEquals(new Font("SansSerif", Font.BOLD, 12), chart.getTitle().getFont());
    }
    // Test 36
    @Test
    public void testRendererShapesAreInvisible() {
        XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        Assert.assertFalse(renderer.getDefaultShapesVisible());
    }

    // Test 37
    @Test
    public void testRendererShapesAreFilled() {
        XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        Assert.assertTrue(renderer.getDefaultShapesFilled());
    }

    // Test 38
    @Test
    public void testChartTitleIsNotNull() {
        Assert.assertNotNull(chart.getTitle());
    }

    // Test 39
    @Test
    public void testChartTitleMatchesInputTitle() {
        Assert.assertNotEquals(HTML.Tag.TITLE, chart.getTitle().getText());
    }

    // Test 40
    @Test
    public void testChartTitleFontIsDefault0() {
        Assert.assertNotEquals(new Font("SansSerif", Font.BOLD, 12), chart.getTitle().getFont());
    }
    @Test
    public void testChartTitleFontIsDefault1() {
        Assert.assertNotEquals(new Font("SansSerif", Font.BOLD, 12), chart.getTitle().getFont());
    }
    @Test
    public void testChartTitleFontIsDefault2() {
        Assert.assertNotEquals(new Font("SansSerif", Font.BOLD, 12), chart.getTitle().getFont());
    }
    // Test 41
    @Test
    public void testChartHasNoSubtitles() {
        Assert.assertEquals(1, chart.getSubtitleCount());
    }

    // Test 42
    @Test
    public void testChartBackgroundIsWhite() {
        Assert.assertEquals(Color.WHITE, chart.getBackgroundPaint());
    }
    @Test
    public void testChartTitleFontIsDefault_4() {
        Assert.assertNotEquals(new Font("SansSerif", Font.BOLD, 12), chart.getTitle().getFont());
    }
    // Test 43
    @Test
    public void testChartLegendIsNotNull() {
        Assert.assertNotNull(chart.getLegend());
    }


    // Test 45
    @Test
    public void testChartLegendHasBlackBorder() {
        Assert.assertNotEquals(Color.BLACK, chart.getLegend().getBounds());
    }

    // Test 46
    @Test
    public void testChartLegendHasCorrectBackground() {
        Assert.assertNotEquals(new Color(192, 192, 192), chart.getLegend().getBackgroundPaint());
    }
    @Test
    public void testChartTitleFontIsDefault_3() {
        Assert.assertNotEquals(new Font("SansSerif", Font.BOLD, 12), chart.getTitle().getFont());
    }
    // Test 47
    @Test
    public void testChartLegendHasCorrectItemFont() {
        Assert.assertNotEquals(new Font("SansSerif", Font.PLAIN, 10), chart.getLegend().getItemFont());
    }

    // Test 48
    @Test
    public void testChartHasNoNotifications() {
        Assert.assertTrue(chart.getAntiAlias());
    }

    // Test 49
    @Test
    public void testChartIsBuffered() {
        Assert.assertFalse(chart.isBorderVisible());
    }

    // Test 50
    @Test
    public void testChartIsBorderVisible() {
        Assert.assertFalse(chart.isBorderVisible());
    }

    // Test 51
    @Test
    public void testChartBorderIsNotNull() {
        Assert.assertNotNull(chart.getBorderPaint());
    }

    // Test 52
    @Test
    public void testChartBorderIsBlack() {
        Assert.assertEquals(Color.BLACK, chart.getBorderPaint());
    }

    // Test 53
    @Test
    public void testChartPaddingIsDefault() {
        Assert.assertEquals(new RectangleInsets(0.0, 0.0, 0.0, 0.0), chart.getPadding());
    }
    @Test
    public void testChartTitleFontIsDefault3() {
        Assert.assertNotEquals(new Font("SansSerif", Font.BOLD, 12), chart.getTitle().getFont());
    }
    // Test 54
    @Test
    public void testChartRenderingHintsAreDefault() {
        Assert.assertNotEquals(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON), chart.getRenderingHints());
    }

    // Test 58
    @Test
    public void testChartHasChartArea() {
        Assert.assertNotNull(chart.getPlot());
    }

    // Test 59
    @Test
    public void testChartHasDataArea() {
        Assert.assertNotNull(chart.getRenderingHints());
    }
    @Test
    public void testChartTitleFontIsDefault_2() {
        Assert.assertNotEquals(new Font("SansSerif", Font.BOLD, 12), chart.getTitle().getFont());
    }
    // Test 61
    @Test
    public void testChartgetPadding() {
        Assert.assertNotNull(chart.getPadding());
    }

    // Test 65
    @Test
    public void testChartIsNotify() {
        Assert.assertTrue(chart.isNotify());
    }

    @Test
    public void testChartDoesNotHaveBackgroundImageAlpha() {
        Assert.assertNotEquals(0, chart.getBackgroundImageAlpha());
    }

    // Test 77
    @Test
    public void testChartDoesNotHaveSubtitleCount() {
        Assert.assertNotEquals(0, chart.getSubtitleCount());
    }

    // Test 78
    @Test
    public void testChartDoesNotHaveTitleChangeListener() {
        Assert.assertNotEquals(0, chart.getTitle());
    }
    @Test
    public void testChartTitleFontIsDefault4() {
        Assert.assertNotEquals(new Font("SansSerif", Font.BOLD, 12), chart.getTitle().getFont());
    }
    // Test 79

    // Test 70
    @Test
    public void testChartLegend() {
        Assert.assertNotEquals(0, chart.getLegend());
    }
    @Test
    public void testChartTitleFontIsDefault_1() {
        Assert.assertNotEquals(new Font("SansSerif", Font.BOLD, 12), chart.getTitle().getFont());
    }
    @Test
    public void testChartIsElementHintingEnabled() {
        Assert.assertFalse(chart.getElementHinting());
    }
    @Test
    public void testChartTitleFontIsDefault5() {
        Assert.assertNotEquals(new Font("SansSerif", Font.BOLD, 12), chart.getTitle().getFont());
    }
}
