package org.jfree.homework.LineChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LineChartDataSetTest {

    private DefaultCategoryDataset dataset;

    @Before
    public void setup() {
        dataset = new DefaultCategoryDataset();
    }
    @Test
    public void testAddValuePositive() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Series1", "Category1");
        assertNotNull(dataset.getValue("Series1", "Category1"));
        assertEquals(10.0, dataset.getValue("Series1", "Category1"));
    }

    @Test
    public void testAddValueZero() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(0, "Series1", "Category1");
        assertNotNull(dataset.getValue("Series1", "Category1"));
        assertEquals(0.0, dataset.getValue("Series1", "Category1"));
    }

    @Test
    public void testAddValueNegative() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(-10, "Series1", "Category1");
        assertNotNull(dataset.getValue("Series1", "Category1"));
        assertEquals(-10.0, dataset.getValue("Series1", "Category1"));
    }

    @Test
    public void testAddValueNull() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(null, "Series1", "Category1");
        assertNull(dataset.getValue("Series1", "Category1"));
    }

    @Test
    public void testAddSeries() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Series1", "Category1");
        dataset.addValue(20, "Series2", "Category1");
        dataset.addValue(30, "Series3", "Category1");
        assertEquals(3, dataset.getRowCount());
    }

    @Test
    public void testRemoveSeries() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Series1", "Category1");
        dataset.addValue(20, "Series2", "Category1");
        dataset.addValue(30, "Series3", "Category1");
        dataset.removeRow("Series2");
        assertEquals(2, dataset.getRowCount());
    }

    // 等等
    @Test
    public void testDatasetWithOneCategoryOneSeries() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1, "Series1", "Category1");
        JFreeChart chart = ChartFactory.createLineChart("Title", "Category", "Value", dataset);
        assertNotNull(chart);
    }

    @Test
    public void testDatasetWithMultipleCategoriesOneSeries() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1, "Series1", "Category1");
        dataset.addValue(2, "Series1", "Category2");
        JFreeChart chart = ChartFactory.createLineChart("Title", "Category", "Value", dataset);
        assertNotNull(chart);
    }

    @Test
    public void testDatasetWithOneCategoryMultipleSeries() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1, "Series1", "Category1");
        dataset.addValue(2, "Series2", "Category1");
        JFreeChart chart = ChartFactory.createLineChart("Title", "Category", "Value", dataset);
        assertNotNull(chart);
    }

    @Test
    public void testDatasetWithMultipleCategoriesMultipleSeries() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1, "Series1", "Category1");
        dataset.addValue(2, "Series2", "Category1");
        dataset.addValue(3, "Series1", "Category2");
        dataset.addValue(4, "Series2", "Category2");
        JFreeChart chart = ChartFactory.createLineChart("Title", "Category", "Value", dataset);
        assertNotNull(chart);
    }

    @Test
    public void testDatasetWithNullValue() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(null, "Series1", "Category1");
        JFreeChart chart = ChartFactory.createLineChart("Title", "Category", "Value", dataset);
        assertNotNull(chart);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testDatasetWithNullSeriesNameAndCategoryName() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1, null, null);
        JFreeChart chart = ChartFactory.createLineChart("Title", "Category", "Value", dataset);
        assertNotNull(chart);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDatasetWithNullValueSeriesNameAndCategoryName() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(null, null, null);
        JFreeChart chart = ChartFactory.createLineChart("Title", "Category", "Value", dataset);
        assertNotNull(chart);
    }

    @Test
    public void testEmptyDataset() {
        assertEquals(0, dataset.getRowCount());
        assertEquals(0, dataset.getColumnCount());
    }

    // Adding values one by one
    @Test
    public void testAddValue1() {
        dataset.addValue(1.0, "Row1", "Column1");
        assertEquals(1, dataset.getRowCount());
        assertEquals(1, dataset.getColumnCount());
        assertEquals(1.0, dataset.getValue("Row1", "Column1").doubleValue(), 0.001);
    }

    @Test
    public void testAddNegativeValue() {
        dataset.addValue(-10.0, "Row31", "Column32");
        assertEquals(-10.0, dataset.getValue("Row31", "Column32").doubleValue(), 0.001);
    }

    @Test
    public void testAddZeroValue() {
        dataset.addValue(0.0, "Row32", "Column33");
        assertEquals(0.0, dataset.getValue("Row32", "Column33").doubleValue(), 0.001);
    }

    @Test
    public void testReplaceValue() {
        dataset.addValue(50.0, "Row1", "Column1");
        assertEquals(50.0, dataset.getValue("Row1", "Column1").doubleValue(), 0.001);
    }

    @Test
    public void testClearValues() {
        dataset.clear();
        assertEquals(0, dataset.getRowCount());
        assertEquals(0, dataset.getColumnCount());
    }

    @Test
    public void testRemoveNonExistentKey() {
        assertNull(dataset.removeValue("NonExistentRow", "NonExistentColumn"));
    }

    @Test
    public void testAddValueWithNegativeZero() {
        dataset.addValue(-0.0, "Row51", "Column51");
        assertEquals(-0.0, dataset.getValue("Row51", "Column51").doubleValue(), 0.001);
    }

    @Test
    public void testAddValueWithPositiveInfinity() {
        dataset.addValue(Double.POSITIVE_INFINITY, "Row52", "Column52");
        assertEquals(Double.POSITIVE_INFINITY, dataset.getValue("Row52", "Column52").doubleValue(), 0.001);
    }

    @Test
    public void testAddValueWithNegativeInfinity() {
        dataset.addValue(Double.NEGATIVE_INFINITY, "Row53", "Column53");
        assertEquals(Double.NEGATIVE_INFINITY, dataset.getValue("Row53", "Column53").doubleValue(), 0.001);
    }

    @Test
    public void testAddValueWithNaN() {
        dataset.addValue(Double.NaN, "Row54", "Column54");
        assertTrue(Double.isNaN(dataset.getValue("Row54", "Column54").doubleValue()));
    }

    @Test
    public void testGetRowCountAfterAddingValues() {
        assertEquals(0, dataset.getRowCount());
    }

    @Test
    public void testGetColumnCountAfterAddingValues() {
        assertEquals(0, dataset.getColumnCount());
    }

    @Test
    public void testGetRowIndexWithExistentKey() {
        assertEquals(-1, dataset.getRowIndex("Row1"));
    }

    @Test
    public void testGetRowIndexWithNonExistentKey() {
        assertEquals(-1, dataset.getRowIndex("NonExistentRow"));
    }

    @Test
    public void testGetColumnIndexWithExistentKey() {
        assertEquals(-1, dataset.getColumnIndex("Column1"));
    }

    @Test
    public void testGetColumnIndexWithNonExistentKey() {
        assertEquals(-1, dataset.getColumnIndex("NonExistentColumn"));
    }

    @Test
    public void testGetRowCountAfterIncrementValueWithNonExistentKeys() {
        assertEquals(0, dataset.getRowCount());
    }

    @Test
    public void testGetColumnCountAfterIncrementValueWithNonExistentKeys() {
        assertEquals(0, dataset.getColumnCount());
    }


    @Test
    public void testRemoveValueWithNonExistentKeys() {
        assertNull(dataset.removeValue("NonExistentRow", "NonExistentColumn"));
    }
    @Test
    public void testAddLargeValue() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10000000, "Series1", "Category1");
        assertNotNull(dataset.getValue("Series1", "Category1"));
        assertEquals(1.0E7, dataset.getValue("Series1", "Category1"));
    }

    @Test
    public void testAddSmallValue() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(-10000000, "Series1", "Category1");
        assertNotNull(dataset.getValue("Series1", "Category1"));
        assertEquals(-1.0E7, dataset.getValue("Series1", "Category1"));
    }

    @Test
    public void testAddDuplicateSeries() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Series1", "Category1");
        dataset.addValue(20, "Series1", "Category2");
        assertEquals(1, dataset.getRowCount());
        assertEquals(20.0, dataset.getValue("Series1", "Category2"));
    }

    @Test
    public void testRemoveNonExistentSeries() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Series1", "Category1");
    }

    @Test
    public void testGetValueForNonExistentSeries() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Series1", "Category1");
    }

    @Test
    public void testMultipleCategories() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Series1", "Category1");
        dataset.addValue(20, "Series1", "Category2");
        dataset.addValue(30, "Series1", "Category3");
        assertNotEquals(3.0, dataset.getColumnCount());
    }

    @Test
    public void testAddValueNaN() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(Double.NaN, "Series1", "Category1");
        assertTrue(Double.isNaN((Double)dataset.getValue("Series1", "Category1")));
    }
    @Test
    public void testGetRowIndex() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Series1", "Category1");
        assertEquals(0, dataset.getRowIndex("Series1"));
    }

    @Test
    public void testGetColumnIndex() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Series1", "Category1");
        assertEquals(0, dataset.getColumnIndex("Category1"));
    }

    @Test
    public void testGetRowIndexInvalidKey() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Series1", "Category1");
        assertEquals(-1, dataset.getRowIndex("InvalidSeries"));
    }

    @Test
    public void testGetColumnIndexInvalidKey() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Series1", "Category1");
        assertEquals(-1, dataset.getColumnIndex("InvalidCategory"));
    }

    @Test
    public void testGetRowKeys() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Series1", "Category1");
        dataset.addValue(20, "Series2", "Category2");
        List<Comparable> keys = dataset.getRowKeys();
        assertTrue(keys.contains("Series1"));
        assertTrue(keys.contains("Series2"));
    }

    @Test
    public void testGetColumnKeys() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Series1", "Category1");
        dataset.addValue(20, "Series2", "Category2");
        List<Comparable> keys = dataset.getColumnKeys();
        assertTrue(keys.contains("Category1"));
        assertTrue(keys.contains("Category2"));
    }

    @Test
    public void testRemoveRow() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Series1", "Category1");
        dataset.addValue(20, "Series2", "Category2");
        dataset.removeRow("Series1");
        assertFalse(dataset.getRowKeys().contains("Series1"));
    }

    @Test
    public void testRemoveColumn() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Series1", "Category1");
        dataset.addValue(20, "Series2", "Category2");
        dataset.removeColumn("Category1");
        assertFalse(dataset.getColumnKeys().contains("Category1"));
    }

    @Test
    public void testGetRowCountAfterRemovingRows() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Series1", "Category1");
        dataset.addValue(20, "Series2", "Category2");
        dataset.removeRow("Series1");
        assertEquals(1, dataset.getRowCount());
    }

    @Test
    public void testGetColumnCountAfterRemovingColumns() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Series1", "Category1");
        dataset.addValue(20, "Series2", "Category2");
        dataset.removeColumn("Category1");
        assertEquals(1, dataset.getColumnCount());
    }
}


