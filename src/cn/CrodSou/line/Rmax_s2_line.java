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

public class Rmax_s2_line {
	public static void main(String[] args) {

	}

	public void s2line1(double Rmax[], double x1, double x2, double c1, double c2, double s1, double s2down,
			double s2up, double d, double delta) {

		StandardChartTheme mChartTheme = new StandardChartTheme("CN");
		mChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 20));
		mChartTheme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 15));
		mChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));
		ChartFactory.setChartTheme(mChartTheme);

		XYSeriesCollection mCollection = GetCollection(Rmax, s2down, s2up);
		JFreeChart mChart = ChartFactory.createXYLineChart("", "s2", "Rmax", mCollection, PlotOrientation.VERTICAL,
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
		ChartFrame mChartFrame = new ChartFrame("关于s2的Rmax变化折线图", mChart);
		mChartFrame.pack();
		mChartFrame.setVisible(true);

	}

	private XYSeriesCollection GetCollection(double Rmax[], double s2down, double s2up) {
		// TODO Auto-generated method stub
		XYSeriesCollection mCollection = new XYSeriesCollection();
		XYSeries mSeriesFirst = new XYSeries("s2");
		int i = 0;
		for (double s2 = s2down; s2 <= s2up; s2 = s2 + 0.05) {
			mSeriesFirst.add(s2, Rmax[i]);
			i++;
		}

		mCollection.addSeries(mSeriesFirst);
		return mCollection;

	}
}