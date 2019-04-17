package cn.CrodSou.line;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;

public class Rmax_x2_line {
	public static void main(String[] args) {

	}

	public void x2line1(double Rmax[], double x1, double x2down, double x2up, double c1, double c2, double s1,
			double s2, double d, double delta) {

		StandardChartTheme mChartTheme = new StandardChartTheme("CN");
		mChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 20));
		mChartTheme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 15));
		mChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));
		ChartFactory.setChartTheme(mChartTheme);

		XYSeriesCollection mCollection = GetCollection(Rmax, x2down, x2up);
		JFreeChart mChart = ChartFactory.createXYLineChart("", "x2", "Rmax", mCollection, PlotOrientation.VERTICAL,
				true, true, false);

		// 创建一个标题
		TextTitle texttitle = new TextTitle();
		// 设置标题字体
		texttitle.setFont(new Font("黑体", 0, 15));
		// 设置标题向下对齐
		texttitle.setPosition(RectangleEdge.BOTTOM);
		// 设置标题向右对齐
		texttitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
		// 添加图表的子标题
		mChart.addSubtitle(texttitle);
		ChartFrame mChartFrame = new ChartFrame("关于x2的Rmax变化折线图", mChart);
		mChartFrame.pack();
		mChartFrame.setVisible(true);

	}

	private XYSeriesCollection GetCollection(double Rmax[], double x2down, double x2up) {
		// TODO Auto-generated method stub
		XYSeriesCollection mCollection = new XYSeriesCollection();
		XYSeries mSeriesFirst = new XYSeries("x2");
		int i = 0;
		for (double x2 = x2down; x2 <= x2up; x2 = x2 + 0.05) {
			mSeriesFirst.add(x2, Rmax[i]);
			i++;
		}

		mCollection.addSeries(mSeriesFirst);
		return mCollection;

	}
}