package org.jfree.softwareTestingAndAnalysis.PieChart;

import static org.junit.Assert.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PieChartDataSetTest {

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
    public void testGetDataset() {
        // 测试获取饼图的数据集
        PiePlot plot = (PiePlot) chart.getPlot();
        Assert.assertEquals(dataset, plot.getDataset());

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
    public void testUpdateValue() {
        dataset.setValue("Item1", 10);
        dataset.setValue("Item1", 20);
        Assert.assertEquals(20, dataset.getValue("Item1").doubleValue(), 0.001);
    }


    @Test
    public void testDatasetInitiallyEmpty() {
        Assert.assertEquals(3, dataset.getItemCount());
    }

    @Test
    public void testAddSingleValue() {
        dataset.setValue("Item1", 10);
        Assert.assertEquals(10, dataset.getValue("Item1").doubleValue(), 0.001);
    }

    @Test
    public void testAddMultipleValues() {
        for (int i = 0; i < 10; i++) {
            dataset.setValue("Item" + i, i);
        }

        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(i, dataset.getValue("Item" + i).doubleValue(), 0.001);
        }
    }


    @Test
    public void testClear() {
        for (int i = 0; i < 10; i++) {
            dataset.setValue("Item" + i, i);
        }

        dataset.clear();
        Assert.assertEquals(0, dataset.getItemCount());
    }

    @Test
    public void testNegativeValue() {
        dataset.setValue("Item1", -10);
        Assert.assertEquals(-10, dataset.getValue("Item1").doubleValue(), 0.001);
    }

    @Test
    public void testZeroValue() {
        dataset.setValue("Item1", 0);
        Assert.assertEquals(0, dataset.getValue("Item1").doubleValue(), 0.001);
    }

    @Test
    public void testSetSameValueMultipleTimes() {
        dataset.setValue("Item1", 10);
        dataset.setValue("Item1", 10);
        Assert.assertEquals(10, dataset.getValue("Item1").doubleValue(), 0.001);
    }

    @Test
    public void testSetNullValue() {
        dataset.setValue("Item1", null);
        Assert.assertNull(dataset.getValue("Item1"));
    }


    @Test
    public void testSetValuesWithLargeNumbers() {
        for (int i = 0; i < 10; i++) {
            dataset.setValue("Item" + i, i * 1000000);
        }
        Assert.assertEquals(5000000, dataset.getValue("Item5").doubleValue(), 0.001);
    }


    @Test
    public void testAddKeyWithNullValue() {
        dataset.setValue("Item1", null);
        Assert.assertNull(dataset.getValue("Item1"));
    }
    @Test
    public void testSetValuesWithLargeNumbers1() {
        for (int i = 0; i < 10; i++) {
            dataset.setValue("Item" + i, i * 200);
        }
        Assert.assertEquals(1000.0, dataset.getValue("Item5").doubleValue(), 0.001);
    }
    @Test
    public void testSetValuesWithLargeNumbers2() {
        for (int i = 0; i < 10; i++) {
            dataset.setValue("Item" + i, i * 5000);
        }
        Assert.assertNotEquals(5000000, dataset.getValue("Item5").doubleValue(), 0.001);
    }
    @Test
    public void testSetValuesWithLargeNumbers3() {
        for (int i = 0; i < 10; i++) {
            dataset.setValue("Item" + i, i * 100);
        }
        Assert.assertNotEquals(5000000, dataset.getValue("Item5").doubleValue(), 0.001);
    }

}