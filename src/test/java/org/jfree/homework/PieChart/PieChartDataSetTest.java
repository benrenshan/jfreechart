package org.jfree.homework;

import static org.junit.Assert.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
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
        assertEquals(dataset, plot.getDataset());

    }

    @Test
    public void testGetDatasetValue() {
        // 测试获取饼图数据集中特定项的值
        assertEquals(20.0, dataset.getValue("A"));
        assertEquals(30.0, dataset.getValue("B"));
        assertEquals(50.0, dataset.getValue("C"));
    }

    @Test
    public void testSetDatasetValue() {
        // 测试设置饼图数据集中特定项的值
        dataset.setValue("A", 25);
        assertEquals(25.0, dataset.getValue("A"));
    }

    @Test
    public void testGetDatasetKeys() {
        // 测试获取饼图数据集中的所有键
        assertEquals(3, dataset.getKeys().size());
        assertTrue(dataset.getKeys().contains("A"));
        assertTrue(dataset.getKeys().contains("B"));
        assertTrue(dataset.getKeys().contains("C"));
    }


    @Test
    public void testGetDatasetItemCount() {
        // 测试获取饼图数据集中的项数
        assertEquals(3, dataset.getItemCount());
    }

    @Test
    public void testClearDataset() {
        // 测试清空饼图数据集中的所有数据
        dataset.clear();
        assertEquals(0, dataset.getItemCount());
    }

    @Test
    public void testUpdateValue() {
        dataset.setValue("Item1", 10);
        dataset.setValue("Item1", 20);
        assertEquals(20, dataset.getValue("Item1").doubleValue(), 0.001);
    }


    @Test
    public void testDatasetInitiallyEmpty() {
        assertEquals(3, dataset.getItemCount());
    }

    @Test
    public void testAddSingleValue() {
        dataset.setValue("Item1", 10);
        assertEquals(10, dataset.getValue("Item1").doubleValue(), 0.001);
    }

    @Test
    public void testAddMultipleValues() {
        for (int i = 0; i < 10; i++) {
            dataset.setValue("Item" + i, i);
        }

        for (int i = 0; i < 10; i++) {
            assertEquals(i, dataset.getValue("Item" + i).doubleValue(), 0.001);
        }
    }


    @Test
    public void testClear() {
        for (int i = 0; i < 10; i++) {
            dataset.setValue("Item" + i, i);
        }

        dataset.clear();
        assertEquals(0, dataset.getItemCount());
    }

    @Test
    public void testNegativeValue() {
        dataset.setValue("Item1", -10);
        assertEquals(-10, dataset.getValue("Item1").doubleValue(), 0.001);
    }

    @Test
    public void testZeroValue() {
        dataset.setValue("Item1", 0);
        assertEquals(0, dataset.getValue("Item1").doubleValue(), 0.001);
    }

    @Test
    public void testSetSameValueMultipleTimes() {
        dataset.setValue("Item1", 10);
        dataset.setValue("Item1", 10);
        assertEquals(10, dataset.getValue("Item1").doubleValue(), 0.001);
    }

    @Test
    public void testSetNullValue() {
        dataset.setValue("Item1", null);
        assertNull(dataset.getValue("Item1"));
    }


    @Test
    public void testSetValuesWithLargeNumbers() {
        for (int i = 0; i < 10; i++) {
            dataset.setValue("Item" + i, i * 1000000);
        }
        assertEquals(5000000, dataset.getValue("Item5").doubleValue(), 0.001);
    }


    @Test
    public void testAddKeyWithNullValue() {
        dataset.setValue("Item1", null);
        assertNull(dataset.getValue("Item1"));
    }


}