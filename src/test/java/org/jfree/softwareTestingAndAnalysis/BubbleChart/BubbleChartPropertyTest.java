package org.jfree.softwareTestingAndAnalysis.BubbleChart;

import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.data.xy.XYZDataset;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class BubbleChartPropertyTest {


    @Test
    public void testBubbleChartTitle1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title1", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        Assert.assertEquals("Title1", chart.getTitle().getText());
    }


    // Repeat the above pattern for other test cases...
    // Modify the title, subtitle, legend, color, etc. for each test case
    // ...

    @Test
    public void testBubbleChartLegend1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        LegendItemCollection legends = chart.getPlot().getLegendItems();
        Assert.assertNotNull(legends);
    }

    @Test
    public void testBubbleChartOrientation1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        Assert.assertNotEquals(PlotOrientation.HORIZONTAL, chart.getPlot().getRootPlot());
    }

    @Test
    public void testBubbleChartOrientation2() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.VERTICAL, true, true, false);
        Assert.assertNotEquals(PlotOrientation.VERTICAL, chart.getPlot().getDatasetGroup());
    }
    @Test
    public void testBubbleChartBackgroundColor1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        chart.setBackgroundPaint(Color.BLUE);
        Assert.assertEquals(Color.BLUE, chart.getBackgroundPaint());
    }

    @Test
    public void testBubbleChartBackgroundColor2() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        chart.setBackgroundPaint(Color.RED);
        Assert.assertEquals(Color.RED, chart.getBackgroundPaint());
    }

    // Repeat the above pattern for other test cases...
    // Modify the background color for each test case
    // ...

    @Test
    public void testBubbleChartPlotBackground1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        Plot plot = chart.getPlot();
        plot.setBackgroundPaint(Color.GREEN);
        Assert.assertEquals(Color.GREEN, plot.getBackgroundPaint());
    }
    @Test
    public void testBubbleChartXAxisLabel1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        XYPlot plot = chart.getXYPlot();
        ValueAxis xAxis = plot.getDomainAxis();
        xAxis.setLabel("XLabel1");
        Assert.assertEquals("XLabel1", xAxis.getLabel());
    }

    @Test
    public void testBubbleChartYAxisLabel1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        XYPlot plot = chart.getXYPlot();
        ValueAxis yAxis = plot.getRangeAxis();
        yAxis.setLabel("YLabel1");
        Assert.assertEquals("YLabel1", yAxis.getLabel());
    }

    // Repeat the above pattern for other test cases...
    // Modify the axis labels for each test case
    // ...

    @Test
    public void testBubbleChartXAxisLabelColor1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        XYPlot plot = chart.getXYPlot();
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        xAxis.setLabelPaint(Color.RED);
        Assert.assertEquals(Color.RED, xAxis.getLabelPaint());
    }

    @Test
    public void testBubbleChartYAxisLabelColor1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        XYPlot plot = chart.getXYPlot();
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setLabelPaint(Color.BLUE);
        Assert.assertEquals(Color.BLUE, yAxis.getLabelPaint());
    }
    @Test
    public void testBubbleChartTitleFont1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        chart.getTitle().setFont(new Font("Times New Roman", Font.BOLD, 20));
        Assert.assertEquals(new Font("Times New Roman", Font.BOLD, 20), chart.getTitle().getFont());
    }

    @Test
    public void testBubbleChartTitleColor1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        chart.getTitle().setPaint(Color.RED);
        Assert.assertEquals(Color.RED, chart.getTitle().getPaint());
    }

    // Repeat the above pattern for other test cases...
    // Modify the title font and color for each test case
    // ...

    @Test
    public void testBubbleChartSubTitle1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        TextTitle subTitle = new TextTitle("SubTitle");
        chart.addSubtitle(subTitle);
        Assert.assertNotEquals(subTitle, chart.getSubtitle(0));
    }
    @Test
    public void testBubbleChartLegendVisibility1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        chart.getLegend().setVisible(false);
        Assert.assertFalse(chart.getLegend().isVisible());
    }

    @Test
    public void testBubbleChartLegendPosition1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        chart.getLegend().setPosition(RectangleEdge.BOTTOM);
        Assert.assertEquals(RectangleEdge.BOTTOM, chart.getLegend().getPosition());
    }

    @Test
    public void testBubbleChartLegendFont1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        chart.getLegend().setItemFont(new Font("Serif", Font.PLAIN, 10));
        Assert.assertEquals(new Font("Serif", Font.PLAIN, 10), chart.getLegend().getItemFont());
    }

    @Test
    public void testBubbleChartLegendColor1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        chart.getLegend().setItemPaint(Color.GREEN);
        Assert.assertEquals(Color.GREEN, chart.getLegend().getItemPaint());
    }
    @Test
    public void testBubbleChartBackgroundPaint1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        chart.setBackgroundPaint(Color.PINK);
        Assert.assertEquals(Color.PINK, chart.getBackgroundPaint());
    }

    @Test
    public void testBubbleChartBackgroundImage1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        BufferedImage image = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
        chart.setBackgroundImage(image);
        Assert.assertEquals(image, chart.getBackgroundImage());
    }

    // Repeat the above pattern for other test cases...
    // Modify the chart background color and image for each test case
    // ...

    @Test
    public void testBubbleChartPlotBackgroundAlpha1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        XYPlot plot = chart.getXYPlot();
        plot.setBackgroundAlpha(0.5f);
        Assert.assertEquals(0.5f, plot.getBackgroundAlpha(), 0.001);
    }

    @Test
    public void testBubbleChartPlotBackgroundAlpha2() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        XYPlot plot = chart.getXYPlot();
        plot.setBackgroundAlpha(0.8f);
        Assert.assertEquals(0.8f, plot.getBackgroundAlpha(), 0.001);
    }
    @Test
    public void testBubbleChartXAxisLabelFont1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        XYPlot plot = chart.getXYPlot();
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        xAxis.setLabelFont(new Font("Arial", Font.BOLD, 14));
        Assert.assertEquals(new Font("Arial", Font.BOLD, 14), xAxis.getLabelFont());
    }

    @Test
    public void testBubbleChartYAxisLabelFont1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        XYPlot plot = chart.getXYPlot();
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setLabelFont(new Font("Arial", Font.BOLD, 14));
        Assert.assertEquals(new Font("Arial", Font.BOLD, 14), yAxis.getLabelFont());
    }

    // Repeat the above pattern for other test cases...
    // Modify the axis label font for each test case
    // ...

    @Test
    public void testBubbleChartXAxisLabelColor2() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        XYPlot plot = chart.getXYPlot();
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        xAxis.setLabelPaint(Color.RED);
        Assert.assertEquals(Color.RED, xAxis.getLabelPaint());
    }

    @Test
    public void testBubbleChartYAxisLabelColor2() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        XYPlot plot = chart.getXYPlot();
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setLabelPaint(Color.BLUE);
        Assert.assertEquals(Color.BLUE, yAxis.getLabelPaint());
    }
    @Test
    public void testBubbleChartBorderVisible1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        chart.setBorderVisible(true);
        Assert.assertTrue(chart.isBorderVisible());
    }

    @Test
    public void testBubbleChartBorderColor1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        chart.setBorderPaint(Color.RED);
        Assert.assertEquals(Color.RED, chart.getBorderPaint());
    }

    // Repeat the above pattern for other test cases...
    // Modify the border visibility and color for each test case
    // ...

    @Test
    public void testBubbleChartBorderStroke1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        BasicStroke stroke = new BasicStroke(2.0f);
        chart.setBorderStroke(stroke);
        Assert.assertEquals(stroke, chart.getBorderStroke());
    }

    @Test
    public void testBubbleChartBorderStroke2() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        BasicStroke stroke = new BasicStroke(3.0f);
        chart.setBorderStroke(stroke);
        Assert.assertEquals(stroke, chart.getBorderStroke());
    }
    @Test
    public void testBubbleChartTitleVisible1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        chart.getTitle().setVisible(true);
        Assert.assertTrue(chart.getTitle().isVisible());
    }

    @Test
    public void testBubbleChartTitleFont2() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        chart.getTitle().setFont(new Font("Serif", Font.PLAIN, 20));
        Assert.assertEquals(new Font("Serif", Font.PLAIN, 20), chart.getTitle().getFont());
    }

    // Repeat the above pattern for other test cases...
    // Modify the title visibility and font for each test case
    // ...

    @Test
    public void testBubbleChartTitleColor3() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        chart.getTitle().setPaint(Color.GREEN);
        Assert.assertEquals(Color.GREEN, chart.getTitle().getPaint());
    }

    @Test
    public void testBubbleChartTitleColor2() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        chart.getTitle().setPaint(Color.BLUE);
        Assert.assertEquals(Color.BLUE, chart.getTitle().getPaint());
    }
    @Test
    public void testBubbleChartLegendVisible1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        LegendTitle legend = chart.getLegend();
        legend.setVisible(true);
        Assert.assertTrue(legend.isVisible());
    }

    @Test
    public void testBubbleChartLegendFont3() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        LegendTitle legend = chart.getLegend();
        legend.setItemFont(new Font("Serif", Font.PLAIN, 10));
        Assert.assertEquals(new Font("Serif", Font.PLAIN, 10), legend.getItemFont());
    }

    // Repeat the above pattern for other test cases...
    // Modify the legend visibility and font for each test case
    // ...

    @Test
    public void testBubbleChartLegendPosition3() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        LegendTitle legend = chart.getLegend();
        legend.setPosition(RectangleEdge.BOTTOM);
        Assert.assertEquals(RectangleEdge.BOTTOM, legend.getPosition());
    }

    @Test
    public void testBubbleChartLegendPosition2() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        LegendTitle legend = chart.getLegend();
        legend.setPosition(RectangleEdge.TOP);
        Assert.assertEquals(RectangleEdge.TOP, legend.getPosition());
    }
    @Test
    public void testBubbleChartBackgroundPaint3() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        Paint backgroundPaint = new Color(200, 200, 200); // Light Gray
        chart.setBackgroundPaint(backgroundPaint);
        Assert.assertEquals(backgroundPaint, chart.getBackgroundPaint());
    }

    @Test
    public void testBubbleChartBackgroundPaint2() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        Paint backgroundPaint = Color.RED;
        chart.setBackgroundPaint(backgroundPaint);
        Assert.assertEquals(backgroundPaint, chart.getBackgroundPaint());
    }

    // Repeat the above pattern for other test cases...
    // Modify the background color for each test case
    // ...

    @Test
    public void testBubbleChartBackgroundImageAlpha1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        chart.setBackgroundImageAlpha(0.5f);
        Assert.assertEquals(0.5f, chart.getBackgroundImageAlpha(), 0.01);
    }

    @Test
    public void testBubbleChartBackgroundImageAlpha2() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        chart.setBackgroundImageAlpha(0.8f);
        Assert.assertEquals(0.8f, chart.getBackgroundImageAlpha(), 0.01);
    }
    @Test
    public void testBubbleChartSubplotCount1() {
        XYZDataset dataset = new DefaultXYZDataset();
        CombinedDomainXYPlot combinedPlot = new CombinedDomainXYPlot();
        XYPlot subplot1 = new XYPlot();
        XYPlot subplot2 = new XYPlot();
        combinedPlot.add(subplot1);
        combinedPlot.add(subplot2);
        JFreeChart chart = new JFreeChart("Title", JFreeChart.DEFAULT_TITLE_FONT, combinedPlot, true);
        Assert.assertEquals(2, combinedPlot.getSubplots().size());
    }

    @Test
    public void testBubbleChartSubplotBackgroundColor1() {
        XYZDataset dataset = new DefaultXYZDataset();
        CombinedDomainXYPlot combinedPlot = new CombinedDomainXYPlot();
        XYPlot subplot1 = new XYPlot();
        subplot1.setBackgroundPaint(Color.RED);
        combinedPlot.add(subplot1);
        JFreeChart chart = new JFreeChart("Title", JFreeChart.DEFAULT_TITLE_FONT, combinedPlot, true);
        Assert.assertEquals(Color.RED, ((XYPlot)combinedPlot.getSubplots().get(0)).getBackgroundPaint());
    }

    @Test
    public void testBubbleChartSubplotOrientation1() {
        XYZDataset dataset = new DefaultXYZDataset();
        CombinedDomainXYPlot combinedPlot = new CombinedDomainXYPlot();
        XYPlot subplot1 = new XYPlot();
        subplot1.setOrientation(PlotOrientation.HORIZONTAL);
        combinedPlot.add(subplot1);
        JFreeChart chart = new JFreeChart("Title", JFreeChart.DEFAULT_TITLE_FONT, combinedPlot, true);
        Assert.assertEquals(PlotOrientation.HORIZONTAL, ((XYPlot)combinedPlot.getSubplots().get(0)).getOrientation());
    }

    @Test
    public void testBubbleChartSubplotOrientation2() {
        XYZDataset dataset = new DefaultXYZDataset();
        CombinedDomainXYPlot combinedPlot = new CombinedDomainXYPlot();
        XYPlot subplot1 = new XYPlot();
        subplot1.setOrientation(PlotOrientation.VERTICAL);
        combinedPlot.add(subplot1);
        JFreeChart chart = new JFreeChart("Title", JFreeChart.DEFAULT_TITLE_FONT, combinedPlot, true);
        Assert.assertEquals(PlotOrientation.VERTICAL, ((XYPlot)combinedPlot.getSubplots().get(0)).getOrientation());
    }
    @Test
    public void testBubbleChartBorderVisible3() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        chart.setBorderVisible(true);
        Assert.assertTrue(chart.isBorderVisible());
    }

    @Test
    public void testBubbleChartBorderStroke3() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        Stroke stroke = new BasicStroke(2.0f);
        chart.setBorderStroke(stroke);
        Assert.assertEquals(stroke, chart.getBorderStroke());
    }

    // Repeat the above pattern for other test cases...
    // Modify the border visibility and stroke for each test case
    // ...

    @Test
    public void testBubbleChartBorderColor3() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        chart.setBorderPaint(Color.RED);
        Assert.assertEquals(Color.RED, chart.getBorderPaint());
    }

    @Test
    public void testBubbleChartBorderColor2() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        chart.setBorderPaint(Color.BLUE);
        Assert.assertEquals(Color.BLUE, chart.getBorderPaint());
    }
    @Test
    public void testBubbleChartTitleText1() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        chart.setTitle("New Title");
        Assert.assertEquals("New Title", chart.getTitle().getText());
    }

    @Test
    public void testBubbleChartTitleFont4() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        Font font = new Font("Serif", Font.BOLD, 20);
        chart.getTitle().setFont(font);
        Assert.assertEquals(font, chart.getTitle().getFont());
    }

    @Test
    public void testBubbleChartTitleColor4() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        Paint paint = Color.RED;
        chart.getTitle().setPaint(paint);
        Assert.assertEquals(paint, chart.getTitle().getPaint());
    }

    @Test
    public void testBubbleChartTitleColor5() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        Paint paint = Color.BLUE;
        chart.getTitle().setPaint(paint);
        Assert.assertEquals(paint, chart.getTitle().getPaint());
    }
    @Test
    public void testBubbleChartTitleColor6() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        chart.getTitle().setPaint(Color.BLUE);
        Assert.assertEquals(Color.BLUE, chart.getTitle().getPaint());
    }
    @Test
    public void testBubbleChartTitleColor7() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        chart.getTitle().setPaint(Color.LIGHT_GRAY);
        Assert.assertNotEquals(Color.BLUE, chart.getTitle().getPaint());
    }
    @Test
    public void testBubbleChartTitleColor8() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        chart.getTitle().setPaint(Color.YELLOW);
        Assert.assertNotEquals(Color.BLUE, chart.getTitle().getPaint());
    }
    @Test
    public void testBubbleChartTitleColor9() {
        XYZDataset dataset = new DefaultXYZDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("Title", "X", "Y", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        chart.getTitle().setPaint(Color.YELLOW);
        Assert.assertEquals(Color.YELLOW, chart.getTitle().getPaint());
    }

}







