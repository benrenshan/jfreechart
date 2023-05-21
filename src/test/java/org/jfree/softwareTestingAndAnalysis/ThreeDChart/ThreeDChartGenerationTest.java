package org.jfree.softwareTestingAndAnalysis.ThreeDChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class ThreeDChartGenerationTest {
    // Test 1: 生成一个空的饼图3D
    @Test
    public void testCreateEmptyPieChart3D() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        JFreeChart chart = ChartFactory.createPieChart3D("", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 2: 生成饼图3D时传入null数据集
    @Test
    public void testCreatePieChart3DWithNullDataset() {
        JFreeChart chart = ChartFactory.createPieChart3D("", null);
    }

    // Test 3: 生成饼图3D时，数据集中包含一个类别
    @Test
    public void testCreatePieChart3DWithOneCategory() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 4: 生成饼图3D时，数据集中包含多个类别
    @Test
    public void testCreatePieChart3DWithMultipleCategories() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        dataset.setValue("Category2", 2.0);
        dataset.setValue("Category3", 3.0);
        JFreeChart chart = ChartFactory.createPieChart3D("", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 5: 生成饼图3D时，数据集中的值都是0
    @Test
    public void testCreatePieChart3DWithZeroValues() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 0.0);
        dataset.setValue("Category2", 0.0);
        JFreeChart chart = ChartFactory.createPieChart3D("", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 6: 生成饼图3D时，数据集中的值都是负数
    @Test
    public void testCreatePieChart3DWithNegativeValues() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", -1.0);
        dataset.setValue("Category2", -2.0);
        ChartFactory.createPieChart3D("", dataset);
    }

    // Test 7: 生成饼图3D时，数据集中的值是正数和0
    @Test
    public void testCreatePieChart3DWithPositiveAndZeroValues() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        dataset.setValue("Category2", 0.0);
        JFreeChart chart = ChartFactory.createPieChart3D("", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 8: 生成饼图3D时，数据集中的值是正数和负数
    @Test
    public void testCreatePieChart3DWithPositiveAndNegativeValues() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        dataset.setValue("Category2", -1.0);
        ChartFactory.createPieChart3D("", dataset);
    }
    @Test
    public void testCreatePieChart3DWithPositiveAndZeroValues3() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        dataset.setValue("Category2", 0.0);
        JFreeChart chart = ChartFactory.createPieChart3D("", dataset);
        Assert.assertNotNull(chart);
    }
    // Test 11: 饼图3D的标题为null
    @Test
    public void testCreatePieChart3DWithNullTitle() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D(null, dataset);
        Assert.assertNull(chart.getTitle());
    }

    // Test 15: 饼图3D的类别名为空字符串
    @Test
    public void testCreatePieChart3DWithEmptyCategoryName() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Title", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 16: 饼图3D的类别名为null
    @Test(expected = IllegalArgumentException.class)
    public void testCreatePieChart3DWithNullCategoryName() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue(null, 1.0);
    }

    // Test 17: 饼图3D的类别名包含特殊字符
    @Test
    public void testCreatePieChart3DWithSpecialCharactersInCategoryName() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("@#$%^&*()_+", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Title", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 19: 饼图3D的类别名是非常长的字符串
    @Test
    public void testCreatePieChart3DWithLongCategoryName() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        String longCategoryName = new String(new char[1000]).replace("\0", "a");
        dataset.setValue(longCategoryName, 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Title", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 20: 饼图3D使用默认设置创建
    @Test
    public void testCreatePieChart3DWithDefaultSettings() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Title", dataset, true, true, false);
        Assert.assertNotNull(chart);
    }
    @Test
    public void testCreatePieChart3DWithPositiveAndZeroValues2() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        dataset.setValue("Category2", 0.1);
        JFreeChart chart = ChartFactory.createPieChart3D("", dataset);
        Assert.assertNotNull(chart);
    }
    // Test 21: 饼图3D禁用图例
    @Test
    public void testCreatePieChart3DWithoutLegend() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Title", dataset, false, true, false);
        Assert.assertNull(chart.getLegend());
    }

    // Test 22: 饼图3D禁用工具提示
    @Test
    public void testCreatePieChart3DWithoutTooltips() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Title", dataset, true, false, false);
        Assert.assertNotNull(chart);
        // Need to add verification for tooltips disabled
    }

    // Test 23: 饼图3D禁用URLs
    @Test
    public void testCreatePieChart3DWithoutURLs() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Title", dataset, true, true, false);
        Assert.assertNotNull(chart);
        // Need to add verification for URLs disabled
    }

    // Test 24: 饼图3D启用URLs
    @Test
    public void testCreatePieChart3DWithURLs() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Title", dataset, true, true, true);
        Assert.assertNotNull(chart);
        // Need to add verification for URLs enabled
    }

    // Test 25: 饼图3D时，数据集中包含正无穷大的值
    @Test
    public void testCreatePieChart3DWithPositiveInfinity() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", Double.POSITIVE_INFINITY);
        JFreeChart chart = ChartFactory.createPieChart3D("Title", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 37: 创建带有类别和数据的条形图
    @Test
    public void testCreateBarChartWithCategoriesAndValues() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "Row1", "Column1");
        JFreeChart chart = ChartFactory.createBarChart("Title", "CategoryAxisLabel", "ValueAxisLabel", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 38: 创建一个空的条形图
    @Test
    public void testCreateEmptyBarChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        JFreeChart chart = ChartFactory.createBarChart("Title", "CategoryAxisLabel", "ValueAxisLabel", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 41: 创建带有多个类别和数据的条形图
    @Test
    public void testCreateBarChartWithMultipleCategoriesAndValues() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "Row1", "Column1");
        dataset.addValue(2.0, "Row1", "Column2");
        dataset.addValue(3.0, "Row2", "Column1");
        dataset.addValue(4.0, "Row2", "Column2");
        JFreeChart chart = ChartFactory.createBarChart("Title", "CategoryAxisLabel", "ValueAxisLabel", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 43: 创建堆叠区域图时，行名为空字符串
    @Test
    public void testCreateStackedAreaChartWithEmptyRowName() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "", "Column1");
        JFreeChart chart = ChartFactory.createStackedAreaChart("Title", "CategoryAxisLabel", "ValueAxisLabel", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 45: 创建堆叠区域图时，列名为空字符串
    @Test
    public void testCreateStackedAreaChartWithEmptyColumnName() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "Row1", "");
        JFreeChart chart = ChartFactory.createStackedAreaChart("Title", "CategoryAxisLabel", "ValueAxisLabel", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 47: 创建堆叠区域图时，值为正无穷大
    @Test
    public void testCreateStackedAreaChartWithPositiveInfinity() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(Double.POSITIVE_INFINITY, "Row1", "Column1");
        JFreeChart chart = ChartFactory.createStackedAreaChart("Title", "CategoryAxisLabel", "ValueAxisLabel", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 48: 创建堆叠区域图时，值为负无穷大
    @Test
    public void testCreateStackedAreaChartWithNegativeInfinity() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(Double.NEGATIVE_INFINITY, "Row1", "Column1");
    }

    // Test 49: 创建堆叠区域图时，值为NaN
    @Test
    public void testCreateStackedAreaChartWithNaN() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(Double.NaN, "Row1", "Column1");
    }

    // Test 50: 创建堆叠区域图时，值为最大double值
    @Test
    public void testCreateStackedAreaChartWithMaxDouble() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(Double.MAX_VALUE, "Row1", "Column1");
        JFreeChart chart = ChartFactory.createStackedAreaChart("Title", "CategoryAxisLabel", "ValueAxisLabel", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 52: 创建堆叠区域图时，值为最小double值
    @Test
    public void testCreateStackedAreaChartWithMinDouble() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(Double.MIN_VALUE, "Row1", "Column1");
        JFreeChart chart = ChartFactory.createStackedAreaChart("Title", "CategoryAxisLabel", "ValueAxisLabel", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 53: 创建堆叠区域图时，行和列都为空
    @Test
    public void testCreateStackedAreaChartWithEmptyRowsAndColumns() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        JFreeChart chart = ChartFactory.createStackedAreaChart("Title", "CategoryAxisLabel", "ValueAxisLabel", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 54: 创建堆叠区域图时，使用默认设置
    @Test
    public void testCreateStackedAreaChartWithDefaultSettings() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "Row1", "Column1");
        JFreeChart chart = ChartFactory.createStackedAreaChart("Title", "CategoryAxisLabel", "ValueAxisLabel", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertNotNull(chart);
    }

    // Test 55: 创建堆叠区域图时，禁用图例
    @Test
    public void testCreateStackedAreaChartWithoutLegend() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "Row1", "Column1");
        JFreeChart chart = ChartFactory.createStackedAreaChart("Title", "CategoryAxisLabel", "ValueAxisLabel", dataset, PlotOrientation.VERTICAL, false, true, false);
        Assert.assertNull(chart.getLegend());
    }

    // Test 56: 创建堆叠区域图时，禁用工具提示
    @Test
    public void testCreateStackedAreaChartWithoutTooltips() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "Row1", "Column1");
        JFreeChart chart = ChartFactory.createStackedAreaChart("Title", "CategoryAxisLabel", "ValueAxisLabel", dataset, PlotOrientation.VERTICAL, true, false, false);
        Assert.assertNotNull(chart);
        // Need to add verification for tooltips disabled
    }

    // Test 57: 创建堆叠区域图时，禁用URL
    @Test
    public void testCreateStackedAreaChartWithoutUrls() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "Row1", "Column1");
        JFreeChart chart = ChartFactory.createStackedAreaChart("Title", "CategoryAxisLabel", "ValueAxisLabel", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertNotNull(chart);
        // Need to add verification for URLs disabled
    }

    // Test 58: 创建堆叠区域图时，图形方向为水平
    @Test
    public void testCreateStackedAreaChartWithHorizontalOrientation() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "Row1", "Column1");
        JFreeChart chart = ChartFactory.createStackedAreaChart("Title", "CategoryAxisLabel", "ValueAxisLabel", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        Assert.assertNotNull(chart);
    }

    // Test 60: 创建堆叠区域图时，标题为null
    @Test
    public void testCreateStackedAreaChartWithNullTitle() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "Row1", "Column1");
        JFreeChart chart = ChartFactory.createStackedAreaChart(null, "CategoryAxisLabel", "ValueAxisLabel", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 61: 创建堆叠区域图时，类别轴标签为null
    @Test
    public void testCreateStackedAreaChartWithNullCategoryAxisLabel() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "Row1", "Column1");
        JFreeChart chart = ChartFactory.createStackedAreaChart("Title", null, "ValueAxisLabel", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 62: 创建堆叠区域图时，值轴标签为null
    @Test
    public void testCreateStackedAreaChartWithNullValueAxisLabel() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "Row1", "Column1");
        JFreeChart chart = ChartFactory.createStackedAreaChart("Title", "CategoryAxisLabel", null, dataset);
        Assert.assertNotNull(chart);
    }

    // Test 63: 创建堆叠区域图时，数据集为null
    @Test
    public void testCreateStackedAreaChartWithNullDataset() {
        ChartFactory.createStackedAreaChart("Title", "CategoryAxisLabel", "ValueAxisLabel", null);
    }

    // Test 64: 测试创建堆叠区域图时，所有参数都是默认值
    @Test
    public void testCreateStackedAreaChartWithDefaultParameters() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        JFreeChart chart = ChartFactory.createStackedAreaChart("Title", "CategoryAxisLabel", "ValueAxisLabel", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 65: 测试创建堆叠区域图时，禁用legend
    @Test
    public void testCreateStackedAreaChartWithoutLegend1() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "Row1", "Column1");
        JFreeChart chart = ChartFactory.createStackedAreaChart("Title", "CategoryAxisLabel", "ValueAxisLabel", dataset, PlotOrientation.VERTICAL, false, true, false);
        Assert.assertNotNull(chart);
        // Need to add verification for legend disabled
    }

    // Test 66: 测试创建堆叠区域图时，禁用tooltips
    @Test
    public void testCreateStackedAreaChartWithoutTooltips2() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "Row1", "Column1");
        JFreeChart chart = ChartFactory.createStackedAreaChart("Title", "CategoryAxisLabel", "ValueAxisLabel", dataset, PlotOrientation.VERTICAL, true, false, false);
        Assert.assertNotNull(chart);
        // Need to add verification for tooltips disabled
    }

    // Test 67: 创建堆叠区域图时，标题为空字符串
    @Test
    public void testCreateStackedAreaChartWithEmptyTitle() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "Row1", "Column1");
        JFreeChart chart = ChartFactory.createStackedAreaChart("", "CategoryAxisLabel", "ValueAxisLabel", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 68: 创建堆叠区域图时，类别轴标签为空字符串
    @Test
    public void testCreateStackedAreaChartWithEmptyCategoryAxisLabel() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "Row1", "Column1");
        JFreeChart chart = ChartFactory.createStackedAreaChart("Title", "", "ValueAxisLabel", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 69: 创建堆叠区域图时，值轴标签为空字符串
    @Test
    public void testCreateStackedAreaChartWithEmptyValueAxisLabel() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "Row1", "Column1");
        JFreeChart chart = ChartFactory.createStackedAreaChart("Title", "CategoryAxisLabel", "", dataset);
        Assert.assertNotNull(chart);
    }

}
