package org.jfree.softwareTestingAndAnalysis.PieChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.LegendItemSource;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.urls.PieURLGenerator;
import org.jfree.chart.urls.StandardPieURLGenerator;
import org.jfree.chart.util.DefaultShadowGenerator;
import org.jfree.chart.util.Rotation;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static java.lang.Double.valueOf;
import static org.junit.Assert.*;


/**
 * 在编写JUnit测试用例以测试JFreeChart中的PieChart功能时，我们可以将测试分为以下几个模块：
 * <p>
 * 1. 图形生成模块：测试在给定输入数据时，是否能正确生成饼图。此外，还需要测试在没有数据或数据无效时的行为。
 * 2. 图形属性模块：测试设置和获取饼图的各种属性，如标题，背景色，图例是否可见等。这部分测试是为了确保这些属性被正确地设置并反映在饼图上。
 * 3. 数据集处理模块：测试PieDataset的相关功能，比如是否可以正确地添加、删除或更新数据点。我们还需要检查PieDataset是否可以正确地触发图形的更新。
 * 4. 交互模块：如果应用程序包含交互性，比如点击图例以突出显示或隐藏某个部分，那么我们应该测试这些交互是否按预期工作。
 * 5. 导出模块：测试生成的饼图是否可以正确地导出为图片文件或者PDF等格式。
 */
public class PieChartGenerationTest {
    @Test
    public void testPieChartCreationWithTitle() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", Double.valueOf(10.0));

        JFreeChart chart = ChartFactory.createPieChart(
                "Test Chart",
                dataset,
                true,
                true,
                false
        );

        Assert.assertNotNull(chart);
        Assert.assertTrue(chart.getTitle() instanceof TextTitle);
        Assert.assertEquals("Test Chart", chart.getTitle().getText());
    }


    @Test
    public void testPieChartCreationWithoutTitle() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", Double.valueOf(10.0));

        JFreeChart chart = ChartFactory.createPieChart(
                null,
                dataset,
                true,
                true,
                false
        );

        Assert.assertNotNull(chart);
        Assert.assertNull(chart.getTitle());
    }

    @Test
    public void testPieChartCreationWithSingleDataPoint() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", Double.valueOf(10.0));

        JFreeChart chart = ChartFactory.createPieChart(
                "Test Chart",
                dataset,
                true,
                true,
                false
        );

        Assert.assertNotNull(chart);
        Assert.assertTrue(chart.getPlot() instanceof PiePlot);
    }

    @Test
    public void testPieChartCreationWithMultipleDataPoints() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", Double.valueOf(10.0));
        dataset.setValue("Two", Double.valueOf(20.0));
        dataset.setValue("Three", Double.valueOf(30.0));
        dataset.setValue("Four", Double.valueOf(40.0));

        JFreeChart chart = ChartFactory.createPieChart(
                "Test Chart",
                dataset,
                true,
                true,
                false
        );

        Assert.assertNotNull(chart);
        Assert.assertTrue(chart.getPlot() instanceof PiePlot);
    }

    @Test()
    public void testPieChartCreationWithNullData() {
        JFreeChart chart = ChartFactory.createPieChart(
                "Test Chart",
                null,
                true,
                true,
                false
        );
        Assert.assertNotNull(chart);
        Assert.assertTrue(chart.getPlot() instanceof PiePlot);
    }

    @Test
    public void testPieChartCreationWithEmptyData() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        JFreeChart chart = ChartFactory.createPieChart(
                "Test Chart",
                dataset,
                true,
                true,
                false
        );

        Assert.assertNotNull(chart);
        Assert.assertTrue(chart.getPlot() instanceof PiePlot);
    }

    // Tests for legend property
    @Test
    public void testPieChartCreationWithLegend() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", Double.valueOf(10.0));

        JFreeChart chart = ChartFactory.createPieChart(
                "Test Chart",
                dataset,
                true, // legend
                true,
                false
        );

        Assert.assertNotNull(chart);
    }

    public void testPieChartCreationWithoutLegend() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", Double.valueOf(10.0));

        JFreeChart chart = ChartFactory.createPieChart(
                "Test Chart",
                dataset,
                false, // no legend
                true,
                false
        );

        Assert.assertNotNull(chart);
    }

    // Tests for tooltips property
    @Test
    public void testPieChartCreationWithTooltips() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", Double.valueOf(10.0));

        JFreeChart chart = ChartFactory.createPieChart(
                "Test Chart",
                dataset,
                true,
                true, // tooltips
                false
        );

        Assert.assertNotNull(chart);
        Assert.assertTrue(((PiePlot) chart.getPlot()).getToolTipGenerator() != null);
    }

    @Test
    public void testPieChartCreationWithoutTooltips() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", Double.valueOf(10.0));

        JFreeChart chart = ChartFactory.createPieChart(
                "Test Chart",
                dataset,
                true,
                false, // no tooltips
                false
        );

        Assert.assertNotNull(chart);
        Assert.assertTrue(((PiePlot) chart.getPlot()).getToolTipGenerator() == null);
    }

    // Tests for URL generation property
    @Test
    public void testPieChartCreationWithURLGeneration() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", Double.valueOf(10.0));

        JFreeChart chart = ChartFactory.createPieChart(
                "Test Chart",
                dataset,
                true,
                true,
                true // URL generation
        );

        Assert.assertNotNull(chart);
        Assert.assertTrue(((PiePlot) chart.getPlot()).getURLGenerator() != null);
    }

    @Test
    public void testPieChartCreationWithoutURLGeneration() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", Double.valueOf(10.0));

        JFreeChart chart = ChartFactory.createPieChart(
                "Test Chart",
                dataset,
                true,
                true,
                false // no URL generation
        );

        Assert.assertNotNull(chart);
        Assert.assertTrue(((PiePlot) chart.getPlot()).getURLGenerator() == null);
    }

    // Test for null value data point
    @Test
    public void testPieChartCreationWithNullValueDataPoint() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", null);

        JFreeChart chart = ChartFactory.createPieChart(
                "Test Chart",
                dataset,
                true,
                true,
                false
        );

        Assert.assertNotNull(chart);
        Assert.assertTrue(chart.getPlot() instanceof PiePlot);
    }

    // Test for negative value data point
    @Test()
    public void testPieChartCreationWithNegativeValueDataPoint() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", Double.valueOf(-10.0));

        JFreeChart chart = ChartFactory.createPieChart(
                "Test Chart",
                dataset,
                true,
                true,
                false
        );

        Assert.assertNotNull(chart);
        Assert.assertTrue(chart.getPlot() instanceof PiePlot);
    }

    // Test for zero value data point
    @Test
    public void testPieChartCreationWithZeroValueDataPoint() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", Double.valueOf(0.0));

        JFreeChart chart = ChartFactory.createPieChart(
                "Test Chart",
                dataset,
                true,
                true,
                false
        );

        Assert.assertNotNull(chart);
        Assert.assertTrue(chart.getPlot() instanceof PiePlot);
    }

    // Test for multiple data points sum to 100
    @Test
    public void testPieChartCreationWithDataPointsSumTo100() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", Double.valueOf(20.0));
        dataset.setValue("Two", Double.valueOf(30.0));
        dataset.setValue("Three", Double.valueOf(50.0));

        JFreeChart chart = ChartFactory.createPieChart(
                "Test Chart",
                dataset,
                true,
                true,
                false
        );

        Assert.assertNotNull(chart);
        Assert.assertTrue(chart.getPlot() instanceof PiePlot);
    }

    // Test for data points exceed 100
    @Test
    public void testPieChartCreationWithDataPointsExceed100() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", Double.valueOf(60.0));
        dataset.setValue("Two", Double.valueOf(60.0));

        JFreeChart chart = ChartFactory.createPieChart(
                "Test Chart",
                dataset,
                true,
                true,
                false
        );

        Assert.assertNotNull(chart);
        Assert.assertTrue(chart.getPlot() instanceof PiePlot);
    }

    // Test for data points less than 100
    @Test
    public void testPieChartCreationWithDataPointsLessThan100() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", Double.valueOf(30.0));
        dataset.setValue("Two", Double.valueOf(30.0));

        JFreeChart chart = ChartFactory.createPieChart(
                "Test Chart",
                dataset,
                true,
                true,
                false
        );

        Assert.assertNotNull(chart);
        Assert.assertTrue(chart.getPlot() instanceof PiePlot);
    }


    private DefaultPieDataset dataset;
    private JFreeChart chart;

    @Before
    public void setUp() {
        // 初始化数据集和图表对象
        dataset = new DefaultPieDataset();
        dataset.setValue("A", 20);
        dataset.setValue("B", 30);
        dataset.setValue("C", 50);
        chart = ChartFactory.createPieChart("Test Chart", dataset);
    }

    @Test
    public void testGetTitle() {
        // 测试获取饼图的标题
        Assert.assertEquals("Test Chart", chart.getTitle().getText());
    }

    @Test
    public void testGetDataset() {
        // 测试获取饼图的数据集
        PiePlot plot = (PiePlot) chart.getPlot();
        Assert.assertEquals(dataset, plot.getDataset());
    }

    @Test
    public void testGetLegend() {
        // 测试获取饼图的图例
        Assert.assertNotNull(chart.getLegend());
    }

    @Test
    public void testGetPlot() {
        // 测试获取饼图的绘图区域
        Assert.assertNotNull(chart.getPlot());
    }


    @Test
    public void testGetDatasetValue() {
        // 测试获取饼图数据集中特定项的值
        Assert.assertEquals(20.0, dataset.getValue("A"));
        Assert.assertEquals(30.0, dataset.getValue("B"));
        Assert.assertEquals(50.0, dataset.getValue("C"));
    }

    @Test
    public void testSetDatasetValue() {
        // 测试设置饼图数据集中特定项的值
        dataset.setValue("A", 25);
        Assert.assertEquals(25.0, dataset.getValue("A"));
    }

    @Test
    public void testGetDatasetKeys() {
        // 测试获取饼图数据集中的所有键
        Assert.assertEquals(3, dataset.getKeys().size());
        Assert.assertTrue(dataset.getKeys().contains("A"));
        Assert.assertTrue(dataset.getKeys().contains("B"));
        Assert.assertTrue(dataset.getKeys().contains("C"));
    }


    @Test
    public void testGetDatasetItemCount() {
        // 测试获取饼图数据集中的项数
        Assert.assertEquals(3, dataset.getItemCount());
    }

    @Test
    public void testClearDataset() {
        // 测试清空饼图数据集中的所有数据
        dataset.clear();
        Assert.assertEquals(0, dataset.getItemCount());
    }

    @Test
    public void testCreateChart() {
        // 测试创建饼图
        JFreeChart chart = ChartFactory.createPieChart("Test Chart", dataset);
        Assert.assertNotNull(chart);
    }

    @Test
    public void testCreate3DPieChart() {
        // 测试创建3D饼图
        JFreeChart chart = ChartFactory.createPieChart3D("Test Chart", dataset);
        Assert.assertNotNull(chart);
    }

    @Test
    public void testCreateRingChart() {
        // 测试创建环形图
        JFreeChart chart = ChartFactory.createRingChart("Test Chart", dataset, false, false, false);
        Assert.assertNotNull(chart);
    }


    @Test
    public void testCreatePieChartWithNullData() {
        // 测试创建饼图时传入空数据集
        try {
            ChartFactory.createPieChart("Test Chart", null);

        } catch (IllegalArgumentException e) {
            Assert.fail("Should have thrown an IllegalArgumentException");
            Assert.assertEquals("Null 'dataset' argument.", e.getMessage());
        }
    }

    @Test
    public void testCreatePieChartWithEmptyData() {
        // 测试创建饼图时传入空数据集
        try {
            ChartFactory.createPieChart("Test Chart", new DefaultPieDataset());
        } catch (IllegalArgumentException e) {
            Assert.fail("Should have thrown an IllegalArgumentException");
            Assert.assertEquals("No data in dataset.", e.getMessage());
        }
    }

    @Test
    public void testCreatePieChartWithNullTitle() {
        // 测试创建饼图时传入空标题
        try {
            ChartFactory.createPieChart(null, dataset);

        } catch (IllegalArgumentException e) {
            Assert.fail("Should have thrown an IllegalArgumentException");
            Assert.assertEquals("Null 'title' argument.", e.getMessage());
        }
    }

    @Test
    public void testCreatePieChartWithEmptyTitle() {
        // 测试创建饼图时传入空标题
        try {
            ChartFactory.createPieChart("", dataset);

        } catch (IllegalArgumentException e) {
            Assert.fail("Should have thrown an IllegalArgumentException");
            Assert.assertEquals("Invalid title.", e.getMessage());
        }
    }

    @Test
    public void testSetPieChartTitle() {
        // 测试设置饼图的标题
        chart.setTitle("New Test Chart");
        Assert.assertEquals("New Test Chart", chart.getTitle().getText());
    }


    @Test
    public void testSetPieChartBackgroundPaint() {
        // 测试设置饼图的背景颜色
        chart.setBackgroundPaint(Color.WHITE);
        Assert.assertEquals(Color.WHITE, chart.getBackgroundPaint());
    }


    @Test
    public void testSetPieChartAntiAlias() {
        // 测试设置饼图的抗锯齿效果
        chart.setAntiAlias(true);
        Assert.assertTrue(chart.getAntiAlias());
    }

    @Test
    public void testSetPieChartLegend() {
        // 测试设置饼图的图例
        chart.removeLegend();
        Assert.assertNull(chart.getLegend());
        chart.addLegend(new LegendTitle(new LegendItemSource() {
            public LegendItemCollection getLegendItems() {
                return new LegendItemCollection();
            }
        }));
        Assert.assertNotNull(chart.getLegend());
    }


    @Test
    public void testSetPieChartToolTipGenerator() {
        // 测试设置饼图的提示信息生成器
        PieToolTipGenerator generator = new StandardPieToolTipGenerator();
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setToolTipGenerator(generator);
        Assert.assertEquals(generator, plot.getToolTipGenerator());
    }

    @Test
    public void testSetPieChartURL() {
        // 测试设置饼图的URL生成器
        PieURLGenerator generator = new StandardPieURLGenerator();
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setURLGenerator(generator);
        Assert.assertEquals(generator, plot.getURLGenerator());
    }

    @Test
    public void testSetPieChartSectionPaint() {
        // 测试设置饼图的扇形区域颜色
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionPaint("A", Color.RED);
        Assert.assertEquals(Color.RED, plot.getSectionPaint("A"));
    }


    @Test
    public void testSetPieChartSectionOutlineStroke() {
        // 测试设置饼图的扇形区域轮廓线条样式
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionOutlineStroke("A", new BasicStroke(2));
        Assert.assertEquals(new BasicStroke(2), plot.getSectionOutlineStroke("A"));
    }

    @Test
    public void testSetPieChartSectionExplodePercent() {
        // 测试设置饼图的扇形区域爆炸半径
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setExplodePercent("A", 0.1);
        Assert.assertEquals(0.1, plot.getExplodePercent("A"), 0.0001);
    }

    @Test
    public void testSetPieChartSectionLabelGenerator() {
        // 测试设置饼图的扇形区域标签生成器
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} = {1}"));
        Assert.assertNotNull(plot.getLabelGenerator());
    }

    @Test
    public void testSetPieChartSectionLabelFont() {
        // 测试设置饼图的扇形区域标签字体
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("Arial", Font.PLAIN, 12));
        Assert.assertEquals(new Font("Arial", Font.PLAIN, 12), plot.getLabelFont());
    }

    @Test
    public void testSetPieChartSectionLabelPaint() {
        // 测试设置饼图的扇形区域标签颜色
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelPaint(Color.BLACK);
        Assert.assertEquals(Color.BLACK, plot.getLabelPaint());
    }

    @Test
    public void testSetPieChartSectionLabelBackgroundPaint() {
        // 测试设置饼图的扇形区域标签背景颜色
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelBackgroundPaint(Color.WHITE);
        Assert.assertEquals(Color.WHITE, plot.getLabelBackgroundPaint());
    }

    @Test
    public void testSetPieChartSectionLabelOutlinePaint() {
        // 测试设置饼图的扇形区域标签轮廓颜色
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelOutlinePaint(Color.BLACK);
        Assert.assertEquals(Color.BLACK, plot.getLabelOutlinePaint());
    }

    @Test
    public void testSetPieChartSectionLabelOutlineStroke() {
        // 测试设置饼图的扇形区域标签轮廓线条样式
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelOutlineStroke(new BasicStroke(2));
        Assert.assertEquals(new BasicStroke(2), plot.getLabelOutlineStroke());
    }

    @Test
    public void testSetPieChartSectionLabelShadowPaint() {
        // 测试设置饼图的扇形区域标签阴影颜色
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelShadowPaint(Color.GRAY);
        Assert.assertEquals(Color.GRAY, plot.getLabelShadowPaint());
    }

    @Test
    public void testSetPieChartSectionLabelLinksVisible() {
        // 测试设置饼图的扇形区域标签链接是否可见
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelLinksVisible(true);
        Assert.assertTrue(plot.getLabelLinksVisible());
    }

    @Test
    public void testSetPieChartSectionLabelLinkMargin() {
        // 测试设置饼图的扇形区域标签链接边距
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelLinkMargin(0.1);
        Assert.assertEquals(0.1, plot.getLabelLinkMargin(), 0.0001);
    }

    @Test
    public void testSetPieChartSectionLabelLinkPaint() {
        // 测试设置饼图的扇形区域标签链接颜色
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelLinkPaint(Color.BLACK);
        Assert.assertEquals(Color.BLACK, plot.getLabelLinkPaint());
    }

    @Test
    public void testSetPieChartSectionLabelLinkStroke() {
        // 测试设置饼图的扇形区域标签链接线条样式
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelLinkStroke(new BasicStroke(2));
        Assert.assertEquals(new BasicStroke(2), plot.getLabelLinkStroke());
    }


    @Test
    public void testSetPieChartSectionRotationAngle() {
        // 测试设置饼图的旋转角度
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setStartAngle(45);
        Assert.assertEquals(45, plot.getStartAngle(), 0);
    }

    @Test
    public void testSetPieChartSectionDirection() {
        // 测试设置饼图的旋转方向
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setDirection(Rotation.CLOCKWISE);
        Assert.assertEquals(Rotation.CLOCKWISE, plot.getDirection());
    }

    @Test
    public void testSetPieChartSectionInteriorGap() {
        // 测试设置饼图的内部间隙
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setInteriorGap(0.05);
        Assert.assertEquals(0.05, plot.getInteriorGap(), 0.0001);
    }

    @Test
    public void testSetPieChartSectionShadowPaint() {
        // 测试设置饼图的阴影颜色
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setShadowPaint(Color.GRAY);
        Assert.assertEquals(Color.GRAY, plot.getShadowPaint());
    }

    @Test
    public void testSetPieChartSectionShadowXOffset() {
        // 测试设置饼图的阴影X偏移量
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setShadowXOffset(5);
        Assert.assertEquals(5, plot.getShadowXOffset(), 0);
    }

    @Test
    public void testSetPieChartSectionShadowYOffset() {
        // 测试设置饼图的阴影Y偏移量
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setShadowYOffset(5);
        Assert.assertEquals(5, plot.getShadowYOffset(), 0);
    }

    @Test
    public void testSetPieChartSectionOutlineVisible() {
        // 测试设置饼图的轮廓线是否可见
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionOutlinesVisible(true);
        Assert.assertTrue(plot.getSectionOutlinesVisible());
    }

    @Test
    public void testSetPieChartSectionOutlinePaint() {
        // 测试设置饼图的轮廓线颜色
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionOutlinePaint("A", Color.BLACK);
        Assert.assertEquals(Color.BLACK, plot.getSectionOutlinePaint("A"));
    }

    @Test
    public void testSetPieChartSectionShadowGenerator() {
        // 测试设置饼图的阴影生成器
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setShadowGenerator(new DefaultShadowGenerator());
        Assert.assertNotNull(plot.getShadowGenerator());
    }

    @Test
    public void testSetPieChartSectionLabelGeneratorWithFormatSpecifier() {
        // 测试使用格式化字符串设置饼图的扇形区域标签生成器
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} = {1,number,#.##}"));
        Assert.assertNotNull(plot.getLabelGenerator());
    }

}
