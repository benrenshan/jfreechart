package org.jfree.homework.BarChart;

import org.jfree.data.category.DefaultCategoryDataset;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BarChartDataSetTest {

    private DefaultCategoryDataset dataset;

    @Before
    public void setup() {
        dataset = new DefaultCategoryDataset();
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


}


