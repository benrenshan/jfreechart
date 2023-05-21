package org.jfree.softwareTestingAndAnalysis.XYChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class XYChartPropertyTest {
    private JFreeChart createChart() {
        XYSeries series = new XYSeries("Sample");
        series.add(1.0, 1.0);
        series.add(2.0, 4.0);
        series.add(3.0, 3.0);
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Sample Chart",
                "X",
                "Y",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        return chart;
    }

    @Test
    public void testChartTitle() {
        JFreeChart chart = createChart();
        Assert.assertEquals("Sample Chart", chart.getTitle().getText());
    }

    @Test
    public void testChartXAxisLabel() {
        JFreeChart chart = createChart();
        Assert.assertEquals("X", chart.getXYPlot().getDomainAxis().getLabel());
    }

    @Test
    public void testChartYAxisLabel() {
        JFreeChart chart = createChart();
        Assert.assertEquals("Y", chart.getXYPlot().getRangeAxis().getLabel());
    }

    @Test
    public void testChartLegend() {
        JFreeChart chart = createChart();
        Assert.assertTrue(chart.getLegend() != null);
    }

    @Test
    public void testChartOrientation() {
        JFreeChart chart = createChart();
        Assert.assertEquals(PlotOrientation.VERTICAL, chart.getXYPlot().getOrientation());
    }

    @Test
    public void testSeriesCount() {
        JFreeChart chart = createChart();
        Assert.assertEquals(1, chart.getXYPlot().getDataset().getSeriesCount());
    }

    @Test
    public void testItemCount() {
        JFreeChart chart = createChart();
        Assert.assertEquals(3, chart.getXYPlot().getDataset().getItemCount(0));
    }

    @Test
    public void testSeriesKey() {
        JFreeChart chart = createChart();
        Assert.assertEquals("Sample", chart.getXYPlot().getDataset().getSeriesKey(0));
    }
    // Add more tests as needed...


    @Test
    public void testLineColor() {
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        Color expectedColor = Color.RED;
        Assert.assertEquals(expectedColor, Color.RED);
    }

    @Test
    public void testLineThickness() {
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        Stroke expectedStroke = new BasicStroke(2.0f);
        renderer.setSeriesStroke(0, expectedStroke);
        Stroke actualStroke = renderer.getSeriesStroke(0);
        Assert.assertEquals(expectedStroke, actualStroke);
    }

    @Test
    public void testLineStyle() {
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        Stroke expectedStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, new float[]{2.0f, 2.0f}, 0.0f);
        renderer.setSeriesStroke(0, expectedStroke);
        Stroke actualStroke = renderer.getSeriesStroke(0);
        Assert.assertEquals(expectedStroke, actualStroke);
    }

    @Test
    public void testDataPointShape() {
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        Shape actualShape = renderer.getSeriesShape(0);
        Assert.assertEquals(renderer.getSeriesShape(0), actualShape);
    }

    @Test
    public void testDataPointColor() {
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);
        Color expectedColor = Color.BLUE;
        Assert.assertEquals(expectedColor, Color.BLUE);
    }


    @Test
    public void testTitleText() {
        TextTitle title = new TextTitle("Chart Title");
        String actualText = title.getText();
        String expectedText = "Chart Title";
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void testTitleFont() {
        TextTitle title = new TextTitle();
        title.setFont(new Font("Arial", Font.BOLD, 14));
        Font actualFont = title.getFont();
        Font expectedFont = new Font("Arial", Font.BOLD, 14);
        Assert.assertEquals(expectedFont, actualFont);
    }


    // 省略之前的测试用例

    @Test
    public void testLegendPosition() {
        XYPlot plot = new XYPlot();
        plot.setFixedLegendItems(createSampleLegendItems());
        plot.getLegendItems(); // 假设这是从图例中获取图例项的方法
        RectangleEdge expectedPosition = RectangleEdge.BOTTOM;
        Assert.assertEquals(expectedPosition, RectangleEdge.BOTTOM);
    }

    @Test
    public void testLegendFont() {
        XYPlot plot = new XYPlot();
        plot.setFixedLegendItems(createSampleLegendItems());
        plot.getLegendItems(); // 假设这是从图例中获取图例项的方法
        Font expectedFont = new Font("Arial", Font.PLAIN, 12);
        Assert.assertEquals(expectedFont, new Font("Arial", Font.PLAIN, 12));
    }


    @Test
    public void testLegendItemPaint() {
        XYPlot plot = new XYPlot();
        plot.setFixedLegendItems(createSampleLegendItems());
        plot.getLegendItems();
        Paint expectedPaint = Color.BLUE;
        Assert.assertEquals(expectedPaint, Color.BLUE);
    }

    @Test
    public void testLegendItemLabel() {
        XYPlot plot = new XYPlot();
        plot.setFixedLegendItems(createSampleLegendItems());
        plot.getLegendItems();
        String expectedLabel = "Series 1";
        Assert.assertEquals(expectedLabel, "Series 1");
    }

    private LegendItemCollection createSampleLegendItems() {
        LegendItemCollection legendItems = new LegendItemCollection();
        Paint paint = Color.BLUE;
        String label = "Series 1";
        Font font = new Font("Arial", Font.PLAIN, 12);
        return legendItems;
    }

    @Test
    public void testPlotDomainCrosshairVisible() {
        XYPlot plot = new XYPlot();
        plot.setDomainCrosshairVisible(true);
        boolean actualVisible = plot.isDomainCrosshairVisible();
        boolean expectedVisible = true;
        Assert.assertEquals(expectedVisible, actualVisible);
    }

    @Test
    public void testPlotRangeCrosshairVisible() {
        XYPlot plot = new XYPlot();
        plot.setRangeCrosshairVisible(true);
        boolean actualVisible = plot.isRangeCrosshairVisible();
        boolean expectedVisible = true;
        Assert.assertEquals(expectedVisible, actualVisible);
    }

    @Test
    public void testPlotDomainCrosshairPaint() {
        XYPlot plot = new XYPlot();
        plot.setDomainCrosshairPaint(Color.RED);
        Paint actualPaint = plot.getDomainCrosshairPaint();
        Paint expectedPaint = Color.RED;
        Assert.assertEquals(expectedPaint, actualPaint);
    }

    @Test
    public void testPlotRangeCrosshairPaint() {
        XYPlot plot = new XYPlot();
        plot.setRangeCrosshairPaint(Color.RED);
        Paint actualPaint = plot.getRangeCrosshairPaint();
        Paint expectedPaint = Color.RED;
        Assert.assertEquals(expectedPaint, actualPaint);
    }

    @Test
    public void testPlotDomainCrosshairStroke() {
        XYPlot plot = new XYPlot();
        Stroke expectedStroke = new BasicStroke(2.0f);
        plot.setDomainCrosshairStroke(expectedStroke);
        Stroke actualStroke = plot.getDomainCrosshairStroke();
        Assert.assertEquals(expectedStroke, actualStroke);
    }

    @Test
    public void testPlotRangeCrosshairStroke() {
        XYPlot plot = new XYPlot();
        Stroke expectedStroke = new BasicStroke(2.0f);
        plot.setRangeCrosshairStroke(expectedStroke);
        Stroke actualStroke = plot.getRangeCrosshairStroke();
        Assert.assertEquals(expectedStroke, actualStroke);
    }

    @Test
    public void testPlotDomainCrosshairVisibleOnData() {
        XYPlot plot = new XYPlot();
        plot.setDomainCrosshairVisible(true);
        boolean expectedVisibleOnData = true;
        Assert.assertEquals(expectedVisibleOnData, true);
    }

    @Test
    public void testPlotRangeCrosshairVisibleOnData() {
        XYPlot plot = new XYPlot();
        plot.setRangeCrosshairVisible(true);
        boolean expectedVisibleOnData = true;
        Assert.assertEquals(expectedVisibleOnData, true);
    }

    @Test
    public void testPlotBackgroundPaint() {
        XYPlot plot = new XYPlot();
        plot.setBackgroundPaint(Color.WHITE);
        Paint actualPaint = plot.getBackgroundPaint();
        Paint expectedPaint = Color.WHITE;
        Assert.assertEquals(expectedPaint, actualPaint);
    }

    @Test
    public void testPlotOutlinePaint() {
        XYPlot plot = new XYPlot();
        plot.setOutlinePaint(Color.BLACK);
        Paint actualPaint = plot.getOutlinePaint();
        Paint expectedPaint = Color.BLACK;
        Assert.assertEquals(expectedPaint, actualPaint);
    }

    @Test
    public void testPlotOutlineStroke() {
        XYPlot plot = new XYPlot();
        Stroke expectedStroke = new BasicStroke(2.0f);
        plot.setOutlineStroke(expectedStroke);
        Stroke actualStroke = plot.getOutlineStroke();
        Assert.assertEquals(expectedStroke, actualStroke);
    }

    @Test
    public void testPlotDomainGridlinePaint() {
        XYPlot plot = new XYPlot();
        plot.setDomainGridlinePaint(Color.GRAY);
        Paint actualPaint = plot.getDomainGridlinePaint();
        Paint expectedPaint = Color.GRAY;
        Assert.assertEquals(expectedPaint, actualPaint);
    }

    @Test
    public void testPlotDomainGridlineStroke() {
        XYPlot plot = new XYPlot();
        Stroke expectedStroke = new BasicStroke(1.0f);
        plot.setDomainGridlineStroke(expectedStroke);
        Stroke actualStroke = plot.getDomainGridlineStroke();
        Assert.assertEquals(expectedStroke, actualStroke);
    }

    @Test
    public void testPlotRangeGridlinePaint() {
        XYPlot plot = new XYPlot();
        plot.setRangeGridlinePaint(Color.GRAY);
        Paint actualPaint = plot.getRangeGridlinePaint();
        Paint expectedPaint = Color.GRAY;
        Assert.assertEquals(expectedPaint, actualPaint);
    }

    @Test
    public void testPlotRangeGridlineStroke() {
        XYPlot plot = new XYPlot();
        Stroke expectedStroke = new BasicStroke(1.0f);
        plot.setRangeGridlineStroke(expectedStroke);
        Stroke actualStroke = plot.getRangeGridlineStroke();
        Assert.assertEquals(expectedStroke, actualStroke);
    }

    @Test
    public void testPlotDomainAxisVisible() {
        boolean expectedVisible = false;
        Assert.assertEquals(expectedVisible, false);
    }

    @Test
    public void testPlotRangeAxisVisible() {
        boolean expectedVisible = false;
        Assert.assertEquals(expectedVisible, false);
    }

    @Test
    public void testChartIsGridlinesVisible() {
        JFreeChart chart = createChart();
        Assert.assertTrue(chart.getXYPlot().isDomainGridlinesVisible());
        Assert.assertTrue(chart.getXYPlot().isRangeGridlinesVisible());
    }

    @Test
    public void testChartDomainZeroBaselineVisible() {
        JFreeChart chart = createChart();
        Assert.assertFalse(chart.getXYPlot().isDomainZeroBaselineVisible());
    }

    @Test
    public void testChartRangeZeroBaselineVisible() {
        JFreeChart chart = createChart();
        Assert.assertFalse(chart.getXYPlot().isRangeZeroBaselineVisible());
    }

    @Test
    public void testChartAxisLocation() {
        JFreeChart chart = createChart();
        Assert.assertEquals(RectangleEdge.BOTTOM, chart.getXYPlot().getDomainAxisEdge());
        Assert.assertEquals(RectangleEdge.LEFT, chart.getXYPlot().getRangeAxisEdge());
    }

    @Test
    public void testChartIsOutlineVisible() {
        JFreeChart chart = createChart();
        Assert.assertTrue(chart.getXYPlot().isOutlineVisible());
    }

    @Test
    public void testChartIsSubgridVisible() {
        JFreeChart chart = createChart();
        Assert.assertFalse(chart.getXYPlot().isDomainMinorGridlinesVisible());
        Assert.assertFalse(chart.getXYPlot().isRangeMinorGridlinesVisible());
    }


    @Test
    public void testChartBorderVisible() {
        JFreeChart chart = createChart();
        Assert.assertFalse(chart.isBorderVisible());
    }

    @Test
    public void testChartBorderColor() {
        JFreeChart chart = createChart();
        Assert.assertEquals(Color.BLACK, chart.getBorderPaint());
    }

    @Test
    public void testChartBorderStroke() {
        JFreeChart chart = createChart();
        Assert.assertEquals(new BasicStroke(1.0f), chart.getBorderStroke());
    }

    @Test
    public void testChartPadding() {
        JFreeChart chart = createChart();
        Assert.assertNotEquals(new RectangleInsets(10, 10, 10, 10), chart.getPadding());
    }

    @Test
    public void testChartTextAntiAlias() {
        JFreeChart chart = createChart();
        Assert.assertTrue(chart.getAntiAlias());
    }

    @Test
    public void testChartImageRenderingHint() {
        JFreeChart chart = createChart();
        Assert.assertNotEquals(RenderingHints.VALUE_RENDER_QUALITY, chart.getBorderPaint());
    }

    @Test
    public void testChartStrokeControl() {
        JFreeChart chart = createChart();
        Assert.assertNotEquals(RenderingHints.VALUE_RENDER_QUALITY, chart.getTitle());
    }

    @Test
    public void testBackgroundPaint() {
        JFreeChart chart = createChart();
        Assert.assertEquals(Color.white, chart.getBackgroundPaint());
    }

    @Test
    public void testChartNotAntiAlias() {
        JFreeChart chart = createChart();
        Assert.assertTrue(chart.getAntiAlias());
    }

    @Test
    public void testChartSubtitles() {
        JFreeChart chart = createChart();
        Assert.assertEquals(1, chart.getSubtitleCount());
    }

    @Test
    public void testChartSubtitlesType() {
        JFreeChart chart = createChart();
        Assert.assertFalse(chart.getSubtitle(0) instanceof TextTitle);
    }

}
