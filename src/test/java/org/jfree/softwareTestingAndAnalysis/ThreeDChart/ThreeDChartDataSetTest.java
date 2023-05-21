package org.jfree.softwareTestingAndAnalysis.ThreeDChart;
import java.io.*;
import java.util.Collections;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.Assert;
import org.junit.Test;

import static nl.jqno.equalsverifier.internal.util.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;


public class ThreeDChartDataSetTest {
    private JFreeChart createPieChart3D(DefaultPieDataset dataset) {
        return ChartFactory.createPieChart3D(
                "Pie Chart", // chart title
                dataset, // data
                true, // include legend
                true,
                false
        );
    }

    // Test 1: Valid data input
    @Test
    public void testValidInput() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 2: Null category
    @Test(expected = IllegalArgumentException.class)
    public void testNullCategory() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue(null, 1.0);
    }

    // Test 3: Negative value
    @Test
    public void testNegativeValue() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", -1.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 4: Zero value
    @Test
    public void testZeroValue() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 0.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 5: Null value
    @Test
    public void testNullValue() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", null);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 6: NaN value
    @Test
    public void testNaNValue() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", Double.NaN);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 7: Infinity value
    @Test
    public void testInfinityValue() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", Double.POSITIVE_INFINITY);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 8: Negative infinity value
    @Test
    public void testNegativeInfinityValue() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", Double.NEGATIVE_INFINITY);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 9: Empty dataset
    @Test
    public void testEmptyDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    @Test
    public void testEmptyCategoryName() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("", 1.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    @Test
    public void testLongCategoryName() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        String longName = String.join("", Collections.nCopies(1000, "Category"));
        dataset.setValue(longName, 1.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 11
    @Test
    public void testLargeNumberOfDataItems() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i < 1000; i++) {
            dataset.setValue("Category" + i, i);
        }
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 12
    @Test
    public void testLargeValues() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", Double.MAX_VALUE);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 13
    @Test
    public void testSmallValues() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", Double.MIN_VALUE);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 14
    @Test
    public void testMixedPositiveAndNegativeValues() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", -1.0);
        dataset.setValue("Category2", 1.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 15
    @Test
    public void testAllNegativeValues() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", -1.0);
        dataset.setValue("Category2", -2.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 16
    @Test
    public void testAllZeroValues() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 0.0);
        dataset.setValue("Category2", 0.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 17
    @Test
    public void testAllPositiveValues() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        dataset.setValue("Category2", 2.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 18
    @Test
    public void testMixedZeroAndNonZeroValues() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 0.0);
        dataset.setValue("Category2", 1.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 19
    @Test
    public void testMixedNaNAndNonNaNValues() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", Double.NaN);
        dataset.setValue("Category2", 1.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 20
    @Test
    public void testMixedNullAndNonNullValues() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", null);
        dataset.setValue("Category2", 1.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 23
    @Test
    public void testDuplicateCategoryNames() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category", 1.0);
        dataset.setValue("Category", 2.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 24
    @Test
    public void testNegativeInfinity() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category", Double.NEGATIVE_INFINITY);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 25
    @Test
    public void testMixedInfinityValues() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", Double.POSITIVE_INFINITY);
        dataset.setValue("Category2", Double.NEGATIVE_INFINITY);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 26
    @Test
    public void testIdenticalPositiveValues() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        dataset.setValue("Category2", 1.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 27
    @Test
    public void testIdenticalNegativeValues() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", -1.0);
        dataset.setValue("Category2", -1.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 28
    @Test
    public void testMixedIdenticalAndDifferentValues() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        dataset.setValue("Category2", 1.0);
        dataset.setValue("Category3", 2.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 29
    @Test
    public void testLargeNumberOfIdenticalValues() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i < 1000; i++) {
            dataset.setValue("Category" + i, 1.0);
        }
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 30
    @Test
    public void testNonEnglishCategoryNames() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Категория1", 1.0); // Russian
        dataset.setValue("カテゴリ2", 2.0); // Japanese
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 32
    @Test
    public void testSpacesInCategoryName() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category 1", 1.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 33
    @Test
    public void testSpecialCharactersInCategoryName() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category@1", 1.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 34
    @Test
    public void testCategoryNameWithNumbers() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category123", 1.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 35
    @Test
    public void testCategoryNameWithSymbols() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category-1", 1.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 36
    @Test
    public void testNegativeAndZeroValues() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", -1.0);
        dataset.setValue("Category2", 0.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 37
    @Test
    public void testPositiveAndZeroValues() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        dataset.setValue("Category2", 0.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 38
    @Test
    public void testPositiveAndNegativeInfinity() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", Double.POSITIVE_INFINITY);
        dataset.setValue("Category2", Double.NEGATIVE_INFINITY);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 39
    @Test
    public void testZeroAndPositiveInfinity() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 0.0);
        dataset.setValue("Category2", Double.POSITIVE_INFINITY);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 40
    @Test
    public void testZeroAndNegativeInfinity() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 0.0);
        dataset.setValue("Category2", Double.NEGATIVE_INFINITY);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 11: Large values
    @Test
    public void testLargeValues1() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", Double.MAX_VALUE);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 12: Small values
    @Test
    public void testSmallValues1() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", Double.MIN_VALUE);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 14: Large number of categories
    @Test
    public void testLargeNumberOfCategories() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i < 10000; i++) {
            dataset.setValue("Category" + i, 1.0);
        }
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 15: Multiple categories with same value
    @Test
    public void testSameValueCategories() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i < 100; i++) {
            dataset.setValue("Category" + i, 1.0);
        }
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 16: Value is a very small non-zero number
    @Test
    public void testSmallNonZeroValue() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", Double.MIN_NORMAL);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 17: Value is a large negative number
    @Test
    public void testLargeNegativeValue() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", Double.MIN_VALUE * -1);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 18: Dataset contains null and non-null values
    @Test
    public void testMixedNullNonNullValues() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        dataset.setValue("Category2", null);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 19: Category name contains special characters
    @Test
    public void testSpecialCharacterCategoryName() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category!", 1.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 20: Very long category name
    @Test
    public void testLongCategoryName1() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category" + "A".repeat(1000), 1.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 21: Dataset with only one category and one value
    @Test
    public void testSingleCategory() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 22: Category with no value
    @Test
    public void testCategoryWithoutValue() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", null);
    }

    // Test 23: Two categories with the same value
    @Test
    public void testTwoCategoriesSameValue() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        dataset.setValue("Category2", 1.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 24: Two categories with different values
    @Test
    public void testTwoCategoriesDifferentValues() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        dataset.setValue("Category2", 2.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 25: Category with large name and large value
    @Test
    public void testLargeNameAndValue() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category" + "A".repeat(10000), Double.MAX_VALUE);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 26: Dataset with two identical entries
    @Test
    public void testIdenticalEntries() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        dataset.setValue("Category1", 1.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 27: Two categories with very similar but not identical names
    @Test
    public void testSimilarNames() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        dataset.setValue("Category2", 1.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 28: Category name as an empty string
    @Test
    public void testEmptyStringName() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("", 1.0);
    }

    // Test 29: Category name with white spaces
    @Test
    public void testWhiteSpaceName() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue(" ", 1.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 30: Category names with Unicode characters
    @Test
    public void testUnicodeName() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category✨", 1.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 31: Empty Dataset
    @Test
    public void testEmptyDataset1() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        JFreeChart chart = createPieChart3D(dataset);
    }

    // Test 32: Dataset with negative value
    @Test
    public void testNegativeValue1() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", -1.0);
    }

    // Test 33: Dataset with zero value
    @Test
    public void testZeroValue1() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 0.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 34: Dataset with extremely large value
    @Test
    public void testLargeValue() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", Double.MAX_VALUE);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 35: Dataset with tiny value
    @Test
    public void testSmallValue() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", Double.MIN_VALUE);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 36: Dataset with NaN value
    @Test
    public void testNaNValue1() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", Double.NaN);
    }
    @Test
    public void testCategoryWithoutValue3() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", null);
    }

    // Test 37: Dataset with positive infinity value
    @Test
    public void testPositiveInfinityValue() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", Double.POSITIVE_INFINITY);
    }

    // Test 38: Dataset with negative infinity value
    @Test
    public void testNegativeInfinityValue1() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", Double.NEGATIVE_INFINITY);
    }

    // Test 39: Category with special characters
    @Test
    public void testCategorySpecialChars() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category$@#", 1.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 40: Multiple categories with same value
    @Test
    public void testMultipleCategoriesSameValue() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i < 10; i++) {
            dataset.setValue("Category" + i, 1.0);
        }
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }

    // Test 41: Dataset with null value
    @Test
    public void testNullValue3() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", null);
    }

    // Test 43: Two categories with the same key
    @Test
    public void testDuplicateKeys() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        dataset.setValue("Category1", 2.0);
    }

    // Test 44: Two categories with the same value but different keys
    @Test
    public void testSameValueDifferentKeys() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        dataset.setValue("Category2", 1.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }
    @Test
    public void testCategoryWithoutValue5() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", null);
    }

    // Test 47: Two categories, one with a much larger value than the other
    @Test
    public void testLargerValue() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        dataset.setValue("Category2", 1000000.0);
        JFreeChart chart = createPieChart3D(dataset);
        Assert.assertNotNull(chart);
    }


    // Test 51: Dataset with negative value
    @Test
    public void testNegativeValue2() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", -1.0);
    }

    // Test 52: Dataset with zero value
    @Test
    public void testZeroValue2() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 0.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Pie Chart 3D", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 53: Dataset with very large value
    @Test
    public void testVeryLargeValue() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", Double.MAX_VALUE);
        JFreeChart chart = ChartFactory.createPieChart3D("Pie Chart 3D", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 54: Dataset with very small value
    @Test
    public void testVerySmallValue() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", Double.MIN_VALUE);
        JFreeChart chart = ChartFactory.createPieChart3D("Pie Chart 3D", dataset);
        Assert.assertNotNull(chart);
    }
    @Test
    public void testCategoryWithoutValue6() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", null);
    }
    // Test 55: Two categories with negative values
    @Test
    public void testTwoNegativeValues() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", -1.0);
        dataset.setValue("Category2", -2.0);
    }

    // Test 56: Two categories with zero values
    @Test
    public void testTwoZeroValues() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 0.0);
        dataset.setValue("Category2", 0.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Pie Chart 3D", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 57: One category with zero value and one with positive value
    @Test
    public void testZeroAndPositiveValue() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 0.0);
        dataset.setValue("Category2", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Pie Chart 3D", dataset);
        Assert.assertNotNull(chart);
    }

    // Test 58: One category with zero value and one with negative value
    @Test
    public void testZeroAndNegativeValue() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 0.0);
        dataset.setValue("Category2", -1.0);
    }

    // Test 59: One category with positive value and one with negative value
    @Test
    public void testPositiveAndNegativeValue() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        dataset.setValue("Category2", -1.0);
    }

    // Test 60: Add and then remove a category
    @Test
    public void testAddAndRemoveCategory() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", 1.0);
        JFreeChart chart = ChartFactory.createPieChart3D("Pie Chart 3D", dataset);
        dataset.setValue("Category2", 2.0);
    }
    @Test
    public void testVerySmallValue3() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category1", Double.MIN_VALUE);
        JFreeChart chart = ChartFactory.createPieChart3D("Pie Chart 3D", dataset);
        Assert.assertNotNull(chart);
    }
}
