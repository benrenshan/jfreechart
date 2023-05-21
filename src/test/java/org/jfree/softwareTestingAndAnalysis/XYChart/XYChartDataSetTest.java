package org.jfree.softwareTestingAndAnalysis.XYChart;

import org.jfree.data.general.SeriesException;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.YIntervalSeries;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class XYChartDataSetTest {

    private XYSeries series;

    @Before
    public void setUp() {
        series = new XYSeries("Test Series");
    }

    @Test
    public void testAddSinglePoint() {
        series.add(1.0, 1.0);
        Assertions.assertEquals(1, series.getItemCount());
    }

    @Test
    public void testAddMultiplePoints() {
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        series.add(3.0, 3.0);
        Assertions.assertEquals(3, series.getItemCount());
    }

    @Test
    public void testAddPointWithNegativeX() {
        series.add(-1.0, 1.0);
        Assertions.assertEquals(1, series.getItemCount());
    }

    @Test
    public void testAddPointWithNegativeY() {
        series.add(1.0, -1.0);
        Assertions.assertEquals(1, series.getItemCount());
    }

    @Test
    public void testAddPointWithZeroX() {
        series.add(0.0, 1.0);
        Assertions.assertEquals(1, series.getItemCount());
    }

    @Test
    public void testAddPointWithZeroY() {
        series.add(1.0, 0.0);
        Assertions.assertEquals(1, series.getItemCount());
    }

    @Test
    public void testAddPointWithNullX() {
        series.add(2.0, 1.0);
        Assertions.assertEquals(1, series.getItemCount());
    }

    @Test
    public void testAddPointWithNullY() {
        series.add(1.0, null);
        Assertions.assertEquals(1, series.getItemCount());
    }

    @Test
    public void testAddDuplicatePoints() {
        series.add(1.0, 1.0);
        series.add(1.0, 1.0);
        Assertions.assertEquals(2, series.getItemCount());
    }

    @Test
    public void testAddPointsInDescendingOrder() {
        series.add(3.0, 3.0);
        series.add(2.0, 2.0);
        series.add(1.0, 1.0);
        Assertions.assertEquals(3, series.getItemCount());
    }

    @Test
    public void testAddPointsInRandomOrder() {
        series.add(2.0, 2.0);
        series.add(3.0, 3.0);
        series.add(1.0, 1.0);
        Assertions.assertEquals(3, series.getItemCount());
    }

    @Test
    public void testAddLargeNumberOfPoints() {
        for (int i = 0; i < 1000; i++) {
            series.add((double) i, (double) i);
        }
        Assertions.assertEquals(1000, series.getItemCount());
    }

    @Test
    public void testClearPoints() {
        series.add(1.0, 1.0);
        series.clear();
        Assertions.assertEquals(0, series.getItemCount());
    }

    @Test
    public void testRemoveSinglePoint() {
        series.add(1.0, 1.0);
        series.remove(0);
        Assertions.assertEquals(0, series.getItemCount());
    }

    @Test
    public void testRemoveMultiplePoints() {
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        series.remove(0);
        series.remove(0);
        Assertions.assertEquals(0, series.getItemCount());
    }

    @Test
    public void testAddPointWithNaN() {
        series.add(Double.NaN, 1.0);
        Assertions.assertEquals(1, series.getItemCount());
    }

    @Test
    public void testMaximumItemCount() {
        series.setMaximumItemCount(2);
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        series.add(3.0, 3.0);
        Assertions.assertEquals(2, series.getItemCount());
    }

    @Test
    public void testAutoSort() {
        series.add(3.0, 3.0);
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);

        series.getAutoSort();
        Assertions.assertEquals(1.0, series.getX(0).doubleValue(), 0.0001);
    }

    @Test
    public void testAllowDuplicateXValues() {
        series.getAllowDuplicateXValues();
        series.add(1.0, 1.0);
        series.add(1.0, 2.0);
        Assertions.assertNotEquals(3.0, series.getItemCount());
    }

    @Test
    public void testRemoveItem() {
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        series.remove(0);
        Assertions.assertEquals(1, series.getItemCount());
    }

    @Test
    public void testAddOrUpdate() {
        series.addOrUpdate(1.0, 1.0);
        series.addOrUpdate(1.0, 2.0);
        Assertions.assertNotEquals(1, series.getItemCount());
        Assertions.assertEquals(1.0, series.getY(0).doubleValue(), 0.0001);
    }

    @Test
    public void testIndexOf() {
        series.add(2.0, 2.0);
        series.add(1.0, 1.0);
        Assertions.assertEquals(0, series.indexOf(1.0));
    }

    @Test
    public void testGetMinX() {
        series.add(2.0, 2.0);
        series.add(1.0, 1.0);
        Assertions.assertEquals(1.0, series.getMinX(), 0.0001);
    }
    @org.junit.jupiter.api.Test
    public void testEquals() {

        YIntervalSeries s1 = new YIntervalSeries("s1");
        YIntervalSeries s2 = new YIntervalSeries("s1");
        Assertions.assertEquals(s1, s2);

        // seriesKey
        s1 = new YIntervalSeries("s2");
        Assertions.assertNotEquals(s1, s2);
        s2 = new YIntervalSeries("s2");
        Assertions.assertEquals(s1, s2);

        // autoSort
        s1 = new YIntervalSeries("s2", false, true);
        Assertions.assertNotEquals(s1, s2);
        s2 = new YIntervalSeries("s2", false, true);
        Assertions.assertEquals(s1, s2);

        // allowDuplicateValues
        s1 = new YIntervalSeries("s2", false, false);
        Assertions.assertNotEquals(s1, s2);
        s2 = new YIntervalSeries("s2", false, false);
        Assertions.assertEquals(s1, s2);

        // add a value
        s1.add(1.0, 0.5, 1.5, 2.0);
        Assertions.assertNotEquals(s1, s2);
        s2.add(1.0, 0.5, 1.5, 2.0);
        Assertions.assertEquals(s2, s1);

        // add another value
        s1.add(2.0, 0.5, 1.5, 2.0);
        Assertions.assertNotEquals(s1, s2);
        s2.add(2.0, 0.5, 1.5, 2.0);
        Assertions.assertEquals(s2, s1);

        // remove a value
        s1.remove(1.0);
        Assertions.assertNotEquals(s1, s2);
        s2.remove(1.0);
        Assertions.assertEquals(s2, s1);
    }

    @org.junit.jupiter.api.Test
    public void testCloning() throws CloneNotSupportedException {
        YIntervalSeries s1 = new YIntervalSeries("s1");
        s1.add(1.0, 0.5, 1.5, 2.0);
        YIntervalSeries s2 = (YIntervalSeries) s1.clone();
        Assertions.assertNotSame(s1, s2);
        Assertions.assertSame(s1.getClass(), s2.getClass());
        Assertions.assertEquals(s1, s2);
    }

    @org.junit.jupiter.api.Test
    public void testSerialization() {
        YIntervalSeries s1 = new YIntervalSeries("s1");
        s1.add(1.0, 0.5, 1.5, 2.0);
        YIntervalSeries s2 = s1;
        Assertions.assertEquals(s1, s2);
    }

    @org.junit.jupiter.api.Test
    public void testIndexOf2() {
        YIntervalSeries s1 = new YIntervalSeries("Series 1", false, true);
        s1.add(1.0, 1.0, 1.0, 2.0);
        s1.add(3.0, 3.0, 3.0, 3.0);
        s1.add(2.0, 2.0, 2.0, 2.0);
        Assertions.assertEquals(0, s1.indexOf(1.0));
        Assertions.assertEquals(1, s1.indexOf(3.0));
        Assertions.assertEquals(2, s1.indexOf(2.0));
    }

    /**
     * Simple test for the remove() method.
     */
    @org.junit.jupiter.api.Test
    public void testRemove() {
        YIntervalSeries s1 = new YIntervalSeries("Series 1");
        s1.add(1.0, 1.0, 1.0, 2.0);
        s1.add(2.0, 2.0, 2.0, 2.0);
        s1.add(3.0, 3.0, 3.0, 3.0);
        Assertions.assertEquals(3, s1.getItemCount());

        s1.remove(2.0);
        Assertions.assertEquals(3.0, s1.getX(1));

        s1.remove(1.0);
        Assertions.assertEquals(3.0, s1.getX(0));
    }

    private static final double EPSILON = 0.0000000001;

    /**
     * When items are added with duplicate x-values, we expect them to remain
     * in the order they were added.
     */
    @org.junit.jupiter.api.Test
    public void testAdditionOfDuplicateXValues() {
        YIntervalSeries s1 = new YIntervalSeries("Series 1");
        s1.add(1.0, 1.0, 1.0, 1.0);
        s1.add(2.0, 2.0, 2.0, 2.0);
        s1.add(2.0, 3.0, 3.0, 3.0);
        s1.add(2.0, 4.0, 4.0, 4.0);
        s1.add(3.0, 5.0, 5.0, 5.0);
        Assertions.assertEquals(1.0, s1.getYValue(0), EPSILON);
        Assertions.assertEquals(2.0, s1.getYValue(1), EPSILON);
        Assertions.assertEquals(3.0, s1.getYValue(2), EPSILON);
        Assertions.assertEquals(4.0, s1.getYValue(3), EPSILON);
        Assertions.assertEquals(5.0, s1.getYValue(4), EPSILON);
    }

    /**
     * Some checks for the add() method for an UNSORTED series.
     */
    @org.junit.jupiter.api.Test
    public void testAdd() {
        YIntervalSeries series = new YIntervalSeries("Series", false, true);
        series.add(5.0, 5.50, 5.50, 5.50);
        series.add(5.1, 5.51, 5.51, 5.51);
        series.add(6.0, 6.6, 6.6, 6.6);
        series.add(3.0, 3.3, 3.3, 3.3);
        series.add(4.0, 4.4, 4.4, 4.4);
        series.add(2.0, 2.2, 2.2, 2.2);
        series.add(1.0, 1.1, 1.1, 1.1);
        Assertions.assertEquals(5.5, series.getYValue(0), EPSILON);
        Assertions.assertEquals(5.51, series.getYValue(1), EPSILON);
        Assertions.assertEquals(6.6, series.getYValue(2), EPSILON);
        Assertions.assertEquals(3.3, series.getYValue(3), EPSILON);
        Assertions.assertEquals(4.4, series.getYValue(4), EPSILON);
        Assertions.assertEquals(2.2, series.getYValue(5), EPSILON);
        Assertions.assertEquals(1.1, series.getYValue(6), EPSILON);
    }

    @Test
    public void testSetMaximumItemCount1() {
        YIntervalSeries s1 = new YIntervalSeries("S1");
        Assertions.assertEquals(Integer.MAX_VALUE, s1.getMaximumItemCount());
        s1.setMaximumItemCount(2);
        Assertions.assertEquals(2, s1.getMaximumItemCount());
        s1.add(1.0, 1.1, 1.1, 1.1);
        s1.add(2.0, 2.2, 2.2, 2.2);
        s1.add(3.0, 3.3, 3.3, 3.3);
        Assertions.assertEquals(2.0, s1.getX(0).doubleValue(), EPSILON);
        Assertions.assertEquals(3.0, s1.getX(1).doubleValue(), EPSILON);
    }
    @Test
    public void testSetMaximumItemCount3() {
        YIntervalSeries s1 = new YIntervalSeries("S1");
        Assertions.assertEquals(Integer.MAX_VALUE, s1.getMaximumItemCount());
        s1.setMaximumItemCount(2);
        Assertions.assertEquals(2, s1.getMaximumItemCount());
        s1.add(1.0, 1.1, 1.1, 1.1);
        s1.add(2.0, 2.2, 2.2, 2.2);
        s1.add(3.0, 3.3, 3.3, 3.3);
        Assertions.assertEquals(2.0, s1.getX(0).doubleValue(), EPSILON);
        Assertions.assertEquals(3.0, s1.getX(1).doubleValue(), EPSILON);
    }
    @Test
    public void testSetMaximumItemCount4() {
        YIntervalSeries s1 = new YIntervalSeries("S1");
        Assertions.assertEquals(Integer.MAX_VALUE, s1.getMaximumItemCount());
        s1.setMaximumItemCount(2);
        Assertions.assertEquals(2, s1.getMaximumItemCount());
        s1.add(1.0, 1.1, 1.1, 1.1);
        s1.add(2.0, 2.2, 2.2, 2.2);
        s1.add(4.0, 3.3, 3.3, 3.3);
        Assertions.assertEquals(2.0, s1.getX(0).doubleValue(), EPSILON);
        Assertions.assertNotEquals(3.0, s1.getX(1).doubleValue(), EPSILON);
    }
    @Test
    public void testSetMaximumItemCount5() {
        YIntervalSeries s1 = new YIntervalSeries("S1");
        Assertions.assertEquals(Integer.MAX_VALUE, s1.getMaximumItemCount());
        s1.setMaximumItemCount(2);
        Assertions.assertEquals(2, s1.getMaximumItemCount());
        s1.add(1.0, 1.1, 1.1, 1.1);
        s1.add(2.0, 2.2, 2.2, 2.2);
        s1.add(3.0, 3.3, 3.3, 3.3);
        Assertions.assertEquals(2.0, s1.getX(0).doubleValue(), EPSILON);
        Assertions.assertEquals(3.0, s1.getX(1).doubleValue(), EPSILON);
    }
    @org.junit.jupiter.api.Test
    public void testSetMaximumItemCount2() {
        YIntervalSeries s1 = new YIntervalSeries("S1");
        s1.add(1.0, 1.1, 1.1, 1.1);
        s1.add(2.0, 2.2, 2.2, 2.2);
        s1.add(3.0, 3.3, 3.3, 3.3);
        s1.setMaximumItemCount(2);
        Assertions.assertEquals(2.0, s1.getX(0).doubleValue(), EPSILON);
        Assertions.assertEquals(3.0, s1.getX(1).doubleValue(), EPSILON);
    }
    @Test
    public void testGetMaxX() {
        series.add(2.0, 2.0);
        series.add(1.0, 1.0);
        Assertions.assertEquals(2.0, series.getMaxX(), 0.0001);
    }

    @Test
    public void testGetMinY() {
        series.add(1.0, 2.0);
        series.add(1.0, 1.0);
        Assertions.assertEquals(1.0, series.getMinY(), 0.0001);
    }

    @Test
    public void testGetMaxY() {
        series.add(1.0, 2.0);
        series.add(1.0, 1.0);
        Assertions.assertEquals(2.0, series.getMaxY(), 0.0001);
    }

    @Test
    public void testGetItems() {
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        Assertions.assertEquals(2, series.getItems().size());
    }

    @Test
    public void testGetKey() {
        Assertions.assertEquals("Test Series", series.getKey());
    }

    @Test
    public void testSetKey() {
        series.setKey("New Key");
        Assertions.assertEquals("New Key", series.getKey());
    }
    @Test
    public void testEquals1() {
        XYDataItem i1 = new XYDataItem(2.0, 1.1);
        XYDataItem i2 = new XYDataItem(1.0, 1.1);
        Assertions.assertNotEquals(i1, i2);
        Assertions.assertNotEquals(i2, i1);

        i1.setY(9.9);
        Assertions.assertNotEquals(i1, i2);

        i2.setY(9.9);
        Assertions.assertNotEquals(i1, i2);
    }


    @org.junit.jupiter.api.Test
    public void testCloning0() {
        XYDataItem i1 = new XYDataItem(1.0, 1.1);
        XYDataItem i2 = (XYDataItem) i1.clone();
        Assertions.assertNotSame(i1, i2);
        Assertions.assertSame(i1.getClass(), i2.getClass());
        Assertions.assertEquals(i1, i2);
    }


    @org.junit.jupiter.api.Test
    public void testSerialization0() {
        XYDataItem i1 = new XYDataItem(1.0, 1.1);
        XYDataItem i2 = i1;
        Assertions.assertEquals(i1, i2);
    }
    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(series.isEmpty());
        series.add(1.0, 1.0);
        Assertions.assertFalse(series.isEmpty());
    }

    @Test
    public void testDelete() {
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        series.delete(0, 1);
        Assertions.assertEquals(0, series.getItemCount());
    }

    @Test
    public void testDeleteOutOfBounds() {
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        series.delete(2, 1);
        Assertions.assertEquals(2, series.getItemCount());
    }

    @Test
    public void testGetItem() {
        series.add(1.0, 1.0);
        Assertions.assertNotNull(series.getDataItem(0));
    }

    @Test
    public void testGetItemOutOfBounds() {
        series.add(1.0, 1.0);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> series.getDataItem(1));
    }

    @Test
    public void testGetXOutOfBounds() {
        series.add(1.0, 1.0);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> series.getX(1));
    }

    @Test
    public void testGetYOutOfBounds() {
        series.add(1.0, 1.0);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> series.getY(1));
    }

    @Test
    public void testGetDataItem() {
        series.add(1.0, 1.0);
        Assertions.assertEquals(1.0, series.getDataItem(0).getXValue(), 0.0001);
        Assertions.assertEquals(1.0, series.getDataItem(0).getYValue(), 0.0001);
    }

    @Test
    public void testDeleteStartGreaterThanEnd() {
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        Assertions.assertNotEquals(2.0, series.getY(0).doubleValue(), 0.0001);
    }

    @Test
    public void testUpdateByIndex() {
        series.add(1.0, 1.0);
        series.updateByIndex(0, 2.0);
        Assertions.assertEquals(2.0, series.getY(0).doubleValue(), 0.0001);
    }

    @Test
    public void testUpdateByIndexOutOfBounds() {
        series.add(1.0, 1.0);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> series.updateByIndex(1, 2.0));
    }
    @Test
    public void testUpdateByKey() {
        series.add(1.0, 1.0);
        series.update((Number)1.0, 2.0);
        Assertions.assertEquals(2.0, series.getY(0).doubleValue(), 0.0001);
    }

    @Test
    public void testUpdateByKeyNotFound() {
        series.add(1.0, 1.0);
        Assertions.assertThrows(SeriesException.class, () -> series.update((Number)2.0, 2.0));
    }

    @Test
    public void testUpdateByIndexWithNaN() {
        series.add(1.0, 1.0);
        series.updateByIndex(0, Double.NaN);
        Assertions.assertEquals(Double.NaN, series.getY(0).doubleValue(), 0.0001);
    }

    @Test
    public void testAddOrUpdateWithNaN() {
        series.addOrUpdate(1.0, Double.NaN);
        Assertions.assertEquals(Double.NaN, series.getY(0).doubleValue(), 0.0001);
    }

    @Test
    public void testRemoveAllItems() {
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        series.remove(1);
        Assertions.assertEquals(1, series.getItemCount());
    }

    @Test
    public void testRemoveItemByKey() {
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        series.remove((Number)1.0);
        Assertions.assertEquals(1, series.getItemCount());
    }


    @Test
    public void testSetNotify() {
        series.setNotify(false);
        Assertions.assertFalse(series.getNotify());
    }
    @Test
    public void testGetDataItemCount() {
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        Assertions.assertEquals(2, series.getItemCount());
    }
    @Test
    public void testEquals2() {
        XYDataItem i1 = new XYDataItem(2.0, 1.1);
        XYDataItem i2 = new XYDataItem(1.0, 1.1);
        Assertions.assertNotEquals(i1, i2);
        Assertions.assertNotEquals(i2, i1);

        i1.setY(9.9);
        Assertions.assertNotEquals(i1, i2);

        i2.setY(9.9);
        Assertions.assertNotEquals(i1, i2);
    }

    /**
     * Confirm that cloning works.
     */
    @Test
    public void testCloning1() {
        XYDataItem i1 = new XYDataItem(2.0, 1.1);
        XYDataItem i2 = (XYDataItem) i1.clone();
        Assertions.assertNotSame(i1, i2);
        Assertions.assertSame(i1.getClass(), i2.getClass());
        Assertions.assertEquals(i1, i2);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    @org.junit.jupiter.api.Test
    public void testSerialization1() {
        XYDataItem i1 = new XYDataItem(1.0, 1.1);
        XYDataItem i2 = i1;
        Assertions.assertEquals(i1, i2);
    }
    @Test
    public void testGetXValueOutOfBounds() {
        series.add(1.0, 1.0);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> series.getX(1));
    }


    @Test
    public void testGetYValueOutOfBounds() {
        series.add(1.0, 1.0);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> series.getY(1));
    }

    @Test
    public void testSetMaximumItemCount() {
        series.setMaximumItemCount(1);
        series.add(1.0, 1.0);
        series.add(2.0, 2.0);
        Assertions.assertEquals(1, series.getItemCount());
    }

    @Test
    public void testSetAutoSort() {
        series.add(2.0, 2.0);
        series.add(1.0, 1.0);
        Assertions.assertEquals(1.0, series.getX(0).doubleValue(), 0.0001);
    }

    @Test
    public void testSetAllowDuplicateXValues() {
        series.add(1.0, 1.0);
        series.add(1.0, 2.0);
        Assertions.assertEquals(2, series.getItemCount());
    }

}
