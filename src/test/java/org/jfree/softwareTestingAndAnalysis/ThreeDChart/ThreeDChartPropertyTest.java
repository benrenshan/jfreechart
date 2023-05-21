package org.jfree.softwareTestingAndAnalysis.ThreeDChart;

import java.awt.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.PieLabelLinkStyle;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.urls.StandardPieURLGenerator;
import org.jfree.chart.util.Rotation;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ThreeDChartPropertyTest {

    // Test 4: 检查PieChart3D图表的Legend是否可见
    @Test
    public void testPieChart3DLegendVisibility() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset, true, true, true);
        Assert.assertNotNull(chart.getLegend());
    }

    // Test 5: 检查PieChart3D图表的Legend是否不可见
    @Test
    public void testPieChart3DLegendInvisibility() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset, false, true, true);
        Assert.assertNull(chart.getLegend());
    }

    // Test 6: 检查PieChart3D图表的ToolTip是否可见
    @Test
    public void testPieChart3DToolTipVisibility() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset, true, true, true);
        Assert.assertTrue(((PiePlot3D) chart.getPlot()).getToolTipGenerator() != null);
    }

    // Test 7: 检查PieChart3D图表的ToolTip是否不可见
    @Test
    public void testPieChart3DToolTipInvisibility() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset, true, false, true);
        Assert.assertTrue(((PiePlot3D) chart.getPlot()).getToolTipGenerator() == null);
    }

    // Test 8: 检查PieChart3D图表的URL是否可见
    @Test
    public void testPieChart3DURLVisibility() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset, true, true, true);
        Assert.assertTrue(((PiePlot3D) chart.getPlot()).getURLGenerator() != null);
    }

    // Test 9: 检查PieChart3D图表的URL是否不可见
    @Test
    public void testPieChart3DURLInvisibility() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset, true, true, false);
        Assert.assertTrue(((PiePlot3D) chart.getPlot()).getURLGenerator() == null);
    }

    // Test 10: 检查PieChart3D图表的前景透明度设置是否正确
    // Test 12: 检查PieChart3D图表的label links是否可见
    @Test
    public void testPieChart3DLabelLinksVisibility() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setLabelLinksVisible(true);
        Assert.assertTrue(((PiePlot3D) chart.getPlot()).getLabelLinksVisible());
    }

    // Test 13: 检查PieChart3D图表的label links是否不可见
    @Test
    public void testPieChart3DLabelLinksInvisibility() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setLabelLinksVisible(false);
        Assert.assertFalse(((PiePlot3D) chart.getPlot()).getLabelLinksVisible());
    }

    // Test 14: 检查PieChart3D图表的label link style是否正确设置
    // Test 16: 检查PieChart3D图表的foreground alpha值是否正确设置
    @Test
    public void testPieChart3DForegroundAlpha() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setForegroundAlpha(0.5f);
        Assert.assertEquals(0.5f, ((PiePlot3D) chart.getPlot()).getForegroundAlpha(), 0.001f);
    }

    // Test 17: 检查PieChart3D图表的interior gap值是否正确设置
    @Test
    public void testPieChart3DInteriorGap() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setInteriorGap(0.4);
        Assert.assertEquals(0.4, ((PiePlot3D) chart.getPlot()).getInteriorGap(), 0.001);
    }

    // Test 18: 检查PieChart3D图表的label gap是否正确设置
    @Test
    public void testPieChart3DLabelGap() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setLabelGap(0.2);
        Assert.assertEquals(0.2, ((PiePlot3D) chart.getPlot()).getLabelGap(), 0.001);
    }

    // Test 19: 检查PieChart3D图表的maximum label width是否正确设置
    @Test
    public void testPieChart3DMaximumLabelWidth() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setMaximumLabelWidth(0.3);
        Assert.assertEquals(0.3, ((PiePlot3D) chart.getPlot()).getMaximumLabelWidth(), 0.001);
    }

    // Test 20: 检查PieChart3D图表的minimum arc angle to draw是否正确设置
    @Test
    public void testPieChart3DMinimumArcAngleToDraw() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setMinimumArcAngleToDraw(1.0);
        Assert.assertEquals(1.0, ((PiePlot3D) chart.getPlot()).getMinimumArcAngleToDraw(), 0.001);
    }

    // Test 21: 检查PieChart3D图表的label font是否正确设置
    @Test
    public void testPieChart3DLabelFont() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        Font font = new Font("Serif", Font.PLAIN, 18);
        ((PiePlot3D) chart.getPlot()).setLabelFont(font);
        Assert.assertEquals(font, ((PiePlot3D) chart.getPlot()).getLabelFont());
    }

    // Test 22: 检查PieChart3D图表的label link style是否正确设置
    @Test
    public void testPieChart3DLabelLinkStyle() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setLabelLinkStyle(PieLabelLinkStyle.CUBIC_CURVE);
        Assert.assertEquals(PieLabelLinkStyle.CUBIC_CURVE, ((PiePlot3D) chart.getPlot()).getLabelLinkStyle());
    }

    // Test 23: 检查PieChart3D图表的label link paint是否正确设置
    @Test
    public void testPieChart3DLabelLinkPaint() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setLabelLinkPaint(Color.RED);
        Assert.assertEquals(Color.RED, ((PiePlot3D) chart.getPlot()).getLabelLinkPaint());
    }

    // Test 24: 检查PieChart3D图表的label link stroke是否正确设置
    @Test
    public void testPieChart3DLabelLinkStroke1() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        BasicStroke stroke = new BasicStroke(1.0f);
        ((PiePlot3D) chart.getPlot()).setLabelLinkStroke(stroke);
        Assert.assertEquals(stroke, ((PiePlot3D) chart.getPlot()).getLabelLinkStroke());
    }

    // Test 25: 检查PieChart3D图表的label outline paint是否正确设置
    @Test
    public void testPieChart3DLabelOutlinePaint() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setLabelOutlinePaint(Color.BLUE);
        Assert.assertEquals(Color.BLUE, ((PiePlot3D) chart.getPlot()).getLabelOutlinePaint());
    }

    // Test 26: 检查PieChart3D图表的label outline stroke是否正确设置
    @Test
    public void testPieChart3DLabelOutlineStroke() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        BasicStroke stroke = new BasicStroke(2.0f);
        ((PiePlot3D) chart.getPlot()).setLabelOutlineStroke(stroke);
        Assert.assertEquals(stroke, ((PiePlot3D) chart.getPlot()).getLabelOutlineStroke());
    }

    // Test 27: 检查PieChart3D图表的label shadow paint是否正确设置
    @Test
    public void testPieChart3DLabelShadowPaint() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setLabelShadowPaint(Color.GRAY);
        Assert.assertEquals(Color.GRAY, ((PiePlot3D) chart.getPlot()).getLabelShadowPaint());
    }

    // Test 28: 检查PieChart3D图表的label background paint是否正确设置
    @Test
    public void testPieChart3DLabelBackgroundPaint() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setLabelBackgroundPaint(Color.YELLOW);
        Assert.assertEquals(Color.YELLOW, ((PiePlot3D) chart.getPlot()).getLabelBackgroundPaint());
    }

    // Test 29: 检查PieChart3D图表的label gaps是否正确设置
    @Test
    public void testPieChart3DLabelGaps() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setLabelGap(0.05);
        Assert.assertEquals(0.05, ((PiePlot3D) chart.getPlot()).getLabelGap(), 0.001);
    }

    // Test 30: 检查PieChart3D图表的maximum label width是否正确设置
    @Test
    public void testPieChart3DMaximumLabelWidth1() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setMaximumLabelWidth(0.2);
        Assert.assertEquals(0.2, ((PiePlot3D) chart.getPlot()).getMaximumLabelWidth(), 0.001);
    }

    // Test 34: 检查PieChart3D图表的label link stroke是否正确设置
    @Test
    public void testPieChart3DLabelLinkStroke() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setLabelLinkStroke(new BasicStroke(2.0f));
        Assert.assertEquals(new BasicStroke(2.0f), ((PiePlot3D) chart.getPlot()).getLabelLinkStroke());
    }

    // Test 35: 检查PieChart3D图表的simple labels是否正确设置
    @Test
    public void testPieChart3DSimpleLabels() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setSimpleLabels(true);
        Assert.assertEquals(true, ((PiePlot3D) chart.getPlot()).getSimpleLabels());
    }

    // Test 36: 检查PieChart3D图表的interior gap是否正确设置
    @Test
    public void testPieChart3DInteriorGap1() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setInteriorGap(0.33);
        Assert.assertEquals(0.33, ((PiePlot3D) chart.getPlot()).getInteriorGap(), 0.0001);
    }

    // Test 37: 检查PieChart3D图表的circular属性是否正确设置
    @Test
    public void testPieChart3DCircular() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setCircular(false);
        Assert.assertEquals(false, ((PiePlot3D) chart.getPlot()).isCircular());
    }

    // Test 38: 检查PieChart3D图表的start angle是否正确设置
    @Test
    public void testPieChart3DStartAngle() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setStartAngle(90);
        Assert.assertEquals(90, ((PiePlot3D) chart.getPlot()).getStartAngle(), 0.0001);
    }

    // Test 39: 检查PieChart3D图表的direction是否正确设置
    @Test
    public void testPieChart3DDirection() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setDirection(Rotation.CLOCKWISE);
        Assert.assertEquals(Rotation.CLOCKWISE, ((PiePlot3D) chart.getPlot()).getDirection());
    }

    // Test 40: 检查PieChart3D图表的shadow x offset是否正确设置
    @Test
    public void testPieChart3DShadowXOffset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setShadowXOffset(10.0);
        Assert.assertEquals(10.0, ((PiePlot3D) chart.getPlot()).getShadowXOffset(), 0.0001);
    }

    // Test 41: 检查PieChart3D图表的shadow y offset是否正确设置
    @Test
    public void testPieChart3DShadowYOffset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setShadowYOffset(10.0);
        Assert.assertEquals(10.0, ((PiePlot3D) chart.getPlot()).getShadowYOffset(), 0.0001);
    }

    // Test 42: 检查PieChart3D图表的label generator是否正确设置
    @Test
    public void testPieChart3DLabelGenerator() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        StandardPieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator("{0} : {1} ({2})");
        ((PiePlot3D) chart.getPlot()).setLabelGenerator(generator);
        Assert.assertEquals(generator, ((PiePlot3D) chart.getPlot()).getLabelGenerator());
    }

    // Test 43: 检查PieChart3D图表的tooltip generator是否正确设置
    @Test
    public void testPieChart3DToolTipGenerator() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        StandardPieToolTipGenerator generator = new StandardPieToolTipGenerator();
        ((PiePlot3D) chart.getPlot()).setToolTipGenerator(generator);
        Assert.assertEquals(generator, ((PiePlot3D) chart.getPlot()).getToolTipGenerator());
    }

    // Test 44: 检查PieChart3D图表的URL generator是否正确设置
    @Test
    public void testPieChart3DURLGenerator() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        StandardPieURLGenerator generator = new StandardPieURLGenerator();
        ((PiePlot3D) chart.getPlot()).setURLGenerator(generator);
        Assert.assertEquals(generator, ((PiePlot3D) chart.getPlot()).getURLGenerator());
    }

    // Test 45: 检查PieChart3D图表的legend item shape是否正确设置
    @Test
    public void testPieChart3DLegendItemShape() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        Rectangle shape = new Rectangle(10, 10);
        ((PiePlot3D) chart.getPlot()).setLegendItemShape(shape);
        Assert.assertEquals(shape, ((PiePlot3D) chart.getPlot()).getLegendItemShape());
    }

    // Test 46: 检查PieChart3D图表的exploded distance是否正确设置
    @Test
    public void testPieChart3DExplodedDistance() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setExplodePercent("One", 0.1);
        Assert.assertEquals(0.1, ((PiePlot3D) chart.getPlot()).getExplodePercent("One"), 0.0001);
    }
    @Test
    public void testPieChart3DExplodedDistance1() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setExplodePercent("One", 0.1);
        Assert.assertEquals(0.1, ((PiePlot3D) chart.getPlot()).getExplodePercent("One"), 0.0001);
    }
    @Test
    public void testPieChart3DExplodedDistance2() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setExplodePercent("One", 0.1);
        Assert.assertEquals(0.1, ((PiePlot3D) chart.getPlot()).getExplodePercent("One"), 0.0001);
    }
    @Test
    public void testPieChart3DExplodedDistance3() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setExplodePercent("Two", 0.1);
        Assert.assertEquals(0.1, ((PiePlot3D) chart.getPlot()).getExplodePercent("Two"), 0.0001);
    }
    @Test
    public void testPieChart3DExplodedDistance4() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setExplodePercent("Three", 0.1);
        Assert.assertEquals(0.1, ((PiePlot3D) chart.getPlot()).getExplodePercent("Three"), 0.0001);
    }
    @Test
    public void testPieChart3DExplodedDistance5() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setExplodePercent("Four", 0.1);
        Assert.assertEquals(0.1, ((PiePlot3D) chart.getPlot()).getExplodePercent("Four"), 0.0001);
    }
    @Test
    public void testPieChart3DExplodedDistance6() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setExplodePercent("Six", 0.1);
        Assert.assertEquals(0.1, ((PiePlot3D) chart.getPlot()).getExplodePercent("Six"), 0.0001);
    }
    @Test
    public void testPieChart3DExplodedDistance7() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setExplodePercent("Seven", 0.1);
        Assert.assertEquals(0.1, ((PiePlot3D) chart.getPlot()).getExplodePercent("Seven"), 0.0001);
    }
    // Test 47: 检查PieChart3D图表的maximum label width是否正确设置
    @Test
    public void testPieChart3DMaximumLabelWidth2() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setMaximumLabelWidth(0.3);
        Assert.assertEquals(0.3, ((PiePlot3D) chart.getPlot()).getMaximumLabelWidth(), 0.0001);
    }

    // Test 48: 检查PieChart3D图表的label padding是否正确设置
    @Test
    public void testPieChart3DLabelPadding() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        RectangleInsets insets = new RectangleInsets(10, 10, 10, 10);
        ((PiePlot3D) chart.getPlot()).setLabelPadding(insets);
        Assert.assertEquals(insets, ((PiePlot3D) chart.getPlot()).getLabelPadding());
    }

    // Test 49: 检查PieChart3D图表的label background paint是否正确设置
    @Test
    public void testPieChart3DLabelBackgroundPaint2() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setLabelBackgroundPaint(Color.YELLOW);
        Assert.assertEquals(Color.YELLOW, ((PiePlot3D) chart.getPlot()).getLabelBackgroundPaint());
    }

    @Test
    public void testPieChart3DLabelOutlinePaint2() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Test Title", dataset);
        ((PiePlot3D) chart.getPlot()).setLabelOutlinePaint(Color.BLUE);
        Assert.assertEquals(Color.BLUE, ((PiePlot3D) chart.getPlot()).getLabelOutlinePaint());
    }
}
