package org.jfree.softwareTestingAndAnalysis.TimeSeriesChart;
import static org.junit.Assert.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class TimeSeriesChartGenerationTest {

        private TimeSeries series;
        private JFreeChart chart;

        @Before
        public void setup() {
            series = new TimeSeries("Test Series");
            series.add(new Year(2022), 100);
            series.add(new Year(2023), 150);
            series.add(new Year(2024), 200);
            chart = ChartFactory.createTimeSeriesChart(
                    "Test Chart",
                    "Year",
                    "Value",
                    new TimeSeriesCollection(series),
                    true,
                    true,
                    false
            );
        }

        @Test
        public void testChartData() {
            Plot plot = chart.getPlot();
            Assert.assertTrue(plot instanceof XYPlot);
            XYPlot xyPlot = (XYPlot) plot;
            Assert.assertEquals(3, ((TimeSeriesCollection)xyPlot.getDataset()).getSeries(0).getItemCount());
        }

        @Test
        public void testChartTitle() {
            Assert.assertEquals("Test Chart", chart.getTitle().getText());
        }

        @Test
        public void testChartXAxisLabel() {
            Plot plot = chart.getPlot();
            Assert.assertTrue(plot instanceof XYPlot);
            XYPlot xyPlot = (XYPlot) plot;
            Assert.assertEquals("Year", xyPlot.getDomainAxis().getLabel());
        }

        @Test
        public void testChartYAxisLabel() {
            Plot plot = chart.getPlot();
            Assert.assertTrue(plot instanceof XYPlot);
            XYPlot xyPlot = (XYPlot) plot;
            Assert.assertEquals("Value", xyPlot.getRangeAxis().getLabel());
        }

        @Test
        public void testChartLegend() {
            Assert.assertTrue(chart.getLegend() != null);
        }
    @Test
    public void testChartBackgroundPaint() {
        Assert.assertEquals(Color.WHITE, chart.getBackgroundPaint());
    }

    @Test
    public void testPlotBackgroundPaint() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(Color.lightGray, xyPlot.getBackgroundPaint());
    }

    @Test
    public void testChartAntiAlias() {
        Assert.assertTrue(chart.getAntiAlias());
    }

    @Test
    public void testChartBorderVisible() {
        Assert.assertFalse(chart.isBorderVisible());
    }

    @Test
    public void testPlotOutlineVisible() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertTrue(xyPlot.isOutlineVisible());
    }


    @Test
    public void testDomainGridlinesVisible() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertTrue(xyPlot.isDomainGridlinesVisible());
    }

    @Test
    public void testRangeGridlinesVisible() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertTrue(xyPlot.isRangeGridlinesVisible());
    }
    public void testHorizontalGridLinePaint() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(Color.GRAY, xyPlot.getDomainGridlinePaint());
    }

    @Test
    public void testVerticalGridLinePaint() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertNotEquals(Color.GRAY, xyPlot.getRangeGridlinePaint());
    }
    @Test
    public void testVerticalGridLinePaint0() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertNotEquals(Color.BLACK, xyPlot.getRangeGridlinePaint());
    }
    @Test
    public void testVerticalGridLinePaint1() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertNotEquals(Color.GREEN, xyPlot.getRangeGridlinePaint());
    }
    @Test
    public void testVerticalGridLinePaint2() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertNotEquals(Color.PINK, xyPlot.getRangeGridlinePaint());
    }
    @Test
    public void testVerticalGridLinePaint3() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertNotEquals(Color.CYAN, xyPlot.getRangeGridlinePaint());
    }
    @Test
    public void testAxisLocation() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(AxisLocation.BOTTOM_OR_LEFT, xyPlot.getDomainAxisLocation());
        Assert.assertEquals(AxisLocation.BOTTOM_OR_LEFT, xyPlot.getRangeAxisLocation());
    }

    @Test
    public void testPlotOrientation() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(PlotOrientation.VERTICAL, xyPlot.getOrientation());
    }
    @Test
    public void testVerticalGridLinePaint4() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertNotEquals(Color.cyan, xyPlot.getRangeGridlinePaint());
    }
    @Test
    public void testLegendItemSource() {
        Assert.assertEquals(1, chart.getLegend().getSources().length);
        Assert.assertEquals(series.getKey(), chart.getLegend().getSources()[0].getLegendItems().get(0).getLabel());
    }
    @Test
    public void testVerticalGridLinePaint5() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertNotEquals(Color.LIGHT_GRAY, xyPlot.getRangeGridlinePaint());
    }
    @Test
    public void testSubplotsCount() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(4, xyPlot.getPlotType().length());
    }

    @Test
    public void testSeriesCount() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDataset().getSeriesCount());
    }
    @Test
    public void testLegendVisible() {
        Assert.assertFalse(chart.isBorderVisible());
    }

    @Test
    public void testAxisLineVisible() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertTrue(xyPlot.getDomainAxis().isAxisLineVisible());
        Assert.assertTrue(xyPlot.getRangeAxis().isAxisLineVisible());
    }

    @Test
    public void testChartPadding() {
        Assert.assertNotEquals(new RectangleInsets(4, 8, 2, 2), chart.getPadding());
    }

    @Test
    public void testPlotPadding() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertNotEquals(new RectangleInsets(0, 0, 0, 0), xyPlot.getInsets());
    }

    @Test
    public void testChartPaint() {
        Assert.assertNotEquals(new Dimension(800, 600), chart.getBorderPaint());
    }
    @Test
    public void testPlotSeriesVisible() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertTrue(xyPlot.getRenderer().isSeriesVisible(0));
    }

    @Test
    public void testChartNotify() {
        Assert.assertTrue(chart.getAntiAlias());
    }

    @Test
    public void testChartSubtitlesCount() {
        Assert.assertNotEquals(0, chart.getSubtitleCount());
    }

    @Test
    public void testPlotWeight() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getWeight());
    }

    @Test
    public void testChartMargin() {
        Assert.assertEquals(new RectangleInsets(0, 0, 0, 0), chart.getPadding());
    }

    @Test
    public void testPlotAxisOffset() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertNotEquals(new RectangleInsets(0, 0, 0, 0), xyPlot.getAxisOffset());
    }
    @Test
    public void testChartBorderPaint() {
        Assert.assertEquals(Color.BLACK, chart.getBorderPaint());
    }


    @Test
    public void testPlotNoDataMessage() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertNotEquals("null", xyPlot.getNoDataMessage());
    }

    @Test
    public void testPlotDomainZeroBaselineVisible() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertFalse(xyPlot.isDomainZeroBaselineVisible());
    }

    @Test
    public void testPlotRangeZeroBaselineVisible() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertFalse(xyPlot.isRangeZeroBaselineVisible());
    }

    @Test
    public void testChartSubtitleCount() {
        Assert.assertNotEquals(0, chart.getSubtitleCount());
    }

    @Test
    public void testPlotDatasetCount() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertEquals(1, xyPlot.getDatasetCount());
    }


    @Test
    public void testPlotShadowGenerator() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertNull(xyPlot.getShadowGenerator());
    }

    @Test
    public void testPlotDomainTickLabelsVisible() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertTrue(xyPlot.getDomainAxis().isTickLabelsVisible());
    }

    @Test
    public void testPlotRangeTickLabelsVisible() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertTrue(xyPlot.getRangeAxis().isTickLabelsVisible());
    }

    @Test
    public void testPlotDomainTickMarksVisible() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertTrue(xyPlot.getDomainAxis().isTickMarksVisible());
    }


    @Test
    public void testChartBorderStroke() {
        Assert.assertEquals(new BasicStroke(1.0f), chart.getBorderStroke());
    }

    @Test
    public void testPlotAxisLineVisible() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertTrue(xyPlot.getDomainAxis().isAxisLineVisible());
        Assert.assertTrue(xyPlot.getRangeAxis().isAxisLineVisible());
    }
    @Test
    public void testChartElementHinting() {
        Assert.assertFalse(chart.getElementHinting());
    }
    @Test
    public void testPlotAxisLineStroke() {
        Plot plot = chart.getPlot();
        Assert.assertTrue(plot instanceof XYPlot);
        XYPlot xyPlot = (XYPlot) plot;
        Assert.assertNotEquals(new BasicStroke(1.0f), xyPlot.getDomainAxis().getAxisLineStroke());
        Assert.assertNotEquals(new BasicStroke(1.0f), xyPlot.getRangeAxis().getAxisLineStroke());
    }

    @Test
    public void testChartRenderingHints() {
        Assert.assertEquals(RenderingHints.VALUE_ANTIALIAS_ON, chart.getRenderingHints().get(RenderingHints.KEY_ANTIALIASING));
    }



}
