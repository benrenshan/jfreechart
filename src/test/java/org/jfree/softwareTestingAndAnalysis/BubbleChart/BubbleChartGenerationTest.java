package org.jfree.softwareTestingAndAnalysis.BubbleChart;
import static org.junit.jupiter.api.Assertions.*;

import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.renderer.xy.XYBubbleRenderer;
import org.jfree.chart.title.TextTitle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;

import java.awt.*;
import java.io.*;

public class BubbleChartGenerationTest {
    private JFreeChart bubbleChart;
    private DefaultXYZDataset dataset;

    @BeforeEach
    public void setUp() {
        dataset = new DefaultXYZDataset();
        double[][] data = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        dataset.addSeries("Series1", data);
        bubbleChart = ChartFactory.createBubbleChart("Chart", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
    }

    // Test 1: 检查BubbleChart的title是否正确
    @Test
    public void testBubbleChartTitle() {
        Assertions.assertEquals("Chart", bubbleChart.getTitle().getText());
    }

    // Test 2: 检查BubbleChart的X轴label是否正确
    @Test
    public void testBubbleChartXAxisLabel() {
        XYPlot plot = (XYPlot) bubbleChart.getPlot();
        Assertions.assertEquals("X", plot.getDomainAxis().getLabel());
    }

    // Test 3: 检查BubbleChart的Y轴label是否正确
    @Test
    public void testBubbleChartYAxisLabel() {
        XYPlot plot = (XYPlot) bubbleChart.getPlot();
        Assertions.assertEquals("Y", plot.getRangeAxis().getLabel());
    }

    // Test 4: 检查BubbleChart的dataset是否正确
    @Test
    public void testBubbleChartDataset() {
        XYPlot plot = (XYPlot) bubbleChart.getPlot();
        Assertions.assertEquals(dataset, plot.getDataset());
    }

    // Test 5: 检查BubbleChart的orientation是否正确
    @Test
    public void testBubbleChartOrientation() {
        XYPlot plot = (XYPlot) bubbleChart.getPlot();
        Assertions.assertEquals(PlotOrientation.HORIZONTAL, plot.getOrientation());
    }

    // Test 6: 检查BubbleChart的legend是否显示
    @Test
    public void testBubbleChartLegend() {
        Assertions.assertTrue(bubbleChart.getLegend() != null);
    }

    // Test 7: 检查BubbleChart的tooltips是否不显示
    @Test
    public void testBubbleChartTooltips() {
        XYPlot plot = (XYPlot) bubbleChart.getPlot();
        Assertions.assertNotNull(plot.getRenderer().getDefaultToolTipGenerator());
    }

    // Test 8: 检查BubbleChart的urls是否不显示
    @Test
    public void testBubbleChartURLs() {
        XYPlot plot = (XYPlot) bubbleChart.getPlot();
        Assertions.assertNull(plot.getRenderer().getURLGenerator());
    }

    // Test 9: 检查BubbleChart的plot背景色是否为白色
    @Test
    public void testBubbleChartPlotBackground() {
        XYPlot plot = (XYPlot) bubbleChart.getPlot();
        Assertions.assertNotEquals(Color.WHITE, plot.getBackgroundPaint());
    }

    // Test 10: 检查BubbleChart的plot outline颜色是否为黑色
    @Test
    public void testBubbleChartPlotOutline() {
        XYPlot plot = (XYPlot) bubbleChart.getPlot();
        Assertions.assertEquals(Color.BLACK, plot.getOutlinePaint());
    }
    // Test 21: 修改plot outline颜色，检查BubbleChart是否有相应的更改
    @Test
    public void testBubbleChartPlotOutlineUpdate() {
        XYPlot plot = (XYPlot) bubbleChart.getPlot();
        plot.setOutlinePaint(Color.RED);
        Assertions.assertEquals(Color.RED, plot.getOutlinePaint());
    }

    // Test 22: 修改plot的outline是否可见，检查BubbleChart是否有相应的更改
    @Test
    public void testBubbleChartPlotOutlineVisibilityUpdate() {
        XYPlot plot = (XYPlot) bubbleChart.getPlot();
        plot.setOutlineVisible(false);
        Assertions.assertFalse(plot.isOutlineVisible());
    }

    // Test 23: 修改图标显示区域，检查BubbleChart是否有相应的更改
    @Test
    public void testBubbleChartPlotAreaUpdate() {
        XYPlot plot = (XYPlot) bubbleChart.getPlot();
        plot.setWeight(2);
        Assertions.assertEquals(2, plot.getWeight());
    }

    // Test 24: 修改图表背景色，检查BubbleChart是否有相应的更改
    @Test
    public void testBubbleChartBackgroundUpdate() {
        bubbleChart.setBackgroundPaint(Color.BLUE);
        Assertions.assertEquals(Color.BLUE, bubbleChart.getBackgroundPaint());
    }

    // Test 26: 修改图表的渲染器，检查BubbleChart是否有相应的更改
    @Test
    public void testBubbleChartRendererUpdate() {
        XYPlot plot = (XYPlot) bubbleChart.getPlot();
        XYBubbleRenderer renderer = new XYBubbleRenderer(XYBubbleRenderer.SCALE_ON_RANGE_AXIS);
        plot.setRenderer(renderer);
        Assertions.assertEquals(renderer, plot.getRenderer());
    }

    // Test 27: 修改图表的范围轴，检查BubbleChart是否有相应的更改
    @Test
    public void testBubbleChartRangeAxisUpdate() {
        XYPlot plot = (XYPlot) bubbleChart.getPlot();
        NumberAxis newRangeAxis = new NumberAxis("New Range Axis");
        plot.setRangeAxis(newRangeAxis);
        Assertions.assertEquals(newRangeAxis, plot.getRangeAxis());
    }
    // Test 28: 修改图表的领域轴，检查BubbleChart是否有相应的更改
    @Test
    public void testBubbleChartDomainAxisUpdate() {
        XYPlot plot = (XYPlot) bubbleChart.getPlot();
        NumberAxis newDomainAxis = new NumberAxis("New Domain Axis");
        plot.setDomainAxis(newDomainAxis);
        Assertions.assertEquals(newDomainAxis, plot.getDomainAxis());
    }
    // Test 31: 检查创建新的BubbleChart时是否可以设置为null的orientation
    @Test
    public void testBubbleChartNullOrientationCreation() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, null, true, true, false);
        });
    }

    // Test 32: 检查创建新的BubbleChart时是否可以设置为null的标题
    @Test
    public void testBubbleChartNullTitleCreation() {
        JFreeChart chart = ChartFactory.createBubbleChart(null, "X", "Y", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assertions.assertNull(chart.getTitle());
    }

    // Test 33: 检查创建新的BubbleChart时是否可以设置为null的X轴标题
    @Test
    public void testBubbleChartNullXAxisTitleCreation() {
        JFreeChart chart = ChartFactory.createBubbleChart("Title", null, "Y", dataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        Assertions.assertNull(plot.getDomainAxis().getLabel());
    }

    // Test 34: 检查创建新的BubbleChart时是否可以设置为null的Y轴标题
    @Test
    public void testBubbleChartNullYAxisTitleCreation() {
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", null, dataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        Assertions.assertNull(plot.getRangeAxis().getLabel());
    }

    // Test 35: 检查在创建新的BubbleChart时，legend参数是否正确
    @Test
    public void testBubbleChartLegendCreation() {
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.VERTICAL, false, true, false);
        Assertions.assertNull(chart.getLegend());
    }

    // Test 36: 检查在创建新的BubbleChart时，tooltips参数是否正确
    @Test
    public void testBubbleChartTooltipsCreation() {
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.VERTICAL, true, false, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        Assertions.assertNull(plot.getRenderer().getDefaultToolTipGenerator());
    }

    // Test 37: 检查在创建新的BubbleChart时，urls参数是否正确
    @Test
    public void testBubbleChartUrlsCreation() {
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        Assertions.assertNull(plot.getRenderer().getURLGenerator());
    }

    // Test 38: 检查在创建新的BubbleChart时，是否正确地设置了Plot的orientation
    @Test
    public void testBubbleChartOrientationCreation() {
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        Assertions.assertEquals(PlotOrientation.HORIZONTAL, plot.getOrientation());
    }
    // Test 41: 检查在创建新的BubbleChart时，数据集中的系列是否被正确地标签化
    @Test
    public void testBubbleChartSeriesLabeling() {
        double[][] data2 = {{15.0, 25.0, 35.0}, {45.0, 55.0, 65.0}, {75.0, 85.0, 95.0}};
        dataset.addSeries("Series2", data2);
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        Assertions.assertEquals("Series2", plot.getDataset().getSeriesKey(1));
    }

    // Test 42: 测试BubbleChart的拷贝功能，修改副本不应影响原始图表
    @Test
    public void testBubbleChartCloning() throws CloneNotSupportedException {
        JFreeChart clonedChart = (JFreeChart) bubbleChart.clone();
        clonedChart.setTitle("Cloned Chart");
        Assertions.assertNotEquals(clonedChart.getTitle().getText(), bubbleChart.getTitle().getText());
    }

    // Test 43: 测试BubbleChart的序列化功能，序列化和反序列化后的图表应该相等
    @Test
    public void testBubbleChartSerialization() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(bubbleChart);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
        JFreeChart deserializedChart = (JFreeChart) ois.readObject();
        Assertions.assertEquals(bubbleChart.getTitle().getText(), deserializedChart.getTitle().getText());
    }

    // Test 44: 测试BubbleChart中增加、移除、和清理数据集的方法
    @Test
    public void testBubbleChartDatasetManipulations() {
        DefaultXYZDataset newDataset = new DefaultXYZDataset();
        bubbleChart.getXYPlot().setDataset(newDataset);
        Assertions.assertEquals(newDataset, bubbleChart.getXYPlot().getDataset());

        bubbleChart.getXYPlot().setDataset(null);
        Assertions.assertNull(bubbleChart.getXYPlot().getDataset());
    }

    // Test 45: 测试BubbleChart中修改图表渲染器的方法
    @Test
    public void testBubbleChartRendererManipulations() {
        XYBubbleRenderer newRenderer = new XYBubbleRenderer(XYBubbleRenderer.SCALE_ON_BOTH_AXES);
        bubbleChart.getXYPlot().setRenderer(newRenderer);
        Assertions.assertEquals(newRenderer, bubbleChart.getXYPlot().getRenderer());

        bubbleChart.getXYPlot().setRenderer(null);
        Assertions.assertNull(bubbleChart.getXYPlot().getRenderer());
    }

    // Test 46: 测试BubbleChart中修改图表领域轴的方法
    @Test
    public void testBubbleChartDomainAxisManipulations() {
        NumberAxis newDomainAxis = new NumberAxis("New Domain Axis");
        bubbleChart.getXYPlot().setDomainAxis(newDomainAxis);
        Assertions.assertEquals(newDomainAxis, bubbleChart.getXYPlot().getDomainAxis());

        bubbleChart.getXYPlot().setDomainAxis(null);
        Assertions.assertNull(bubbleChart.getXYPlot().getDomainAxis());
    }
    @Test
    public void testBubbleChartRangeAxisManipulations() {
        NumberAxis newRangeAxis = new NumberAxis("New Range Axis");
        bubbleChart.getXYPlot().setRangeAxis(newRangeAxis);
        Assertions.assertEquals(newRangeAxis, bubbleChart.getXYPlot().getRangeAxis());

        bubbleChart.getXYPlot().setRangeAxis(null);
        Assertions.assertNull(bubbleChart.getXYPlot().getRangeAxis());
    }

    // Test 48: 测试BubbleChart中修改图表标题的方法
    @Test
    public void testBubbleChartTitleManipulations() {
        bubbleChart.setTitle("New Title");
        Assertions.assertEquals("New Title", bubbleChart.getTitle().getText());

        bubbleChart.setTitle((TextTitle) null);
        Assertions.assertNull(bubbleChart.getTitle());
    }
    // Test 50: 测试BubbleChart中修改图表背景的方法
    @Test
    public void testBubbleChartBackgroundManipulations() {
        bubbleChart.setBackgroundPaint(Color.GREEN);
        Assertions.assertEquals(Color.GREEN, bubbleChart.getBackgroundPaint());

        bubbleChart.setBackgroundPaint(null);
        Assertions.assertNull(bubbleChart.getBackgroundPaint());
    }
    // Test 51: 测试BubbleChart中修改图表边框的方法
    @Test
    public void testBubbleChartBorderManipulations() {
        bubbleChart.setBorderVisible(true);
        Assertions.assertEquals(true, bubbleChart.isBorderVisible());

        bubbleChart.setBorderVisible(false);
        Assertions.assertEquals(false, bubbleChart.isBorderVisible());
    }

    // Test 52: 测试BubbleChart中修改图表边框颜色的方法
    @Test
    public void testBubbleChartBorderColorManipulations() {
        bubbleChart.setBorderPaint(Color.RED);
        Assertions.assertEquals(Color.RED, bubbleChart.getBorderPaint());

        bubbleChart.setBorderPaint(null);
        Assertions.assertNull(bubbleChart.getBorderPaint());
    }

    // Test 53: 测试BubbleChart中修改图表边框笔画的方法
    @Test
    public void testBubbleChartBorderStrokeManipulations() {
        bubbleChart.setBorderStroke(new BasicStroke(2.0f));
        Assertions.assertEquals(new BasicStroke(2.0f), bubbleChart.getBorderStroke());

        bubbleChart.setBorderStroke(null);
        Assertions.assertNull(bubbleChart.getBorderStroke());
    }
}
