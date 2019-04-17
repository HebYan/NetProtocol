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

public class beta_c1_line {
	public static void main(String[] args) {

	}

	public void c1line1(double beta[], double x1, double x2, double c1down, double c1up, double c2, double s1,
			double s2, double d, double delta) {

		StandardChartTheme mChartTheme = new StandardChartTheme("CN");
		mChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 20));
		mChartTheme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 15));
		mChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));
		ChartFactory.setChartTheme(mChartTheme);

		XYSeriesCollection mCollection = GetCollection(beta, c1down, c1up);
		JFreeChart mChart = ChartFactory.createXYLineChart("", "c1", "beta", mCollection, PlotOrientation.VERTICAL,
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
		ChartFrame mChartFrame = new ChartFrame("关于c1的beta变化折线图", mChart);
		mChartFrame.pack();
		mChartFrame.setVisible(true);

	}

	private XYSeriesCollection GetCollection(double beta[], double c1down, double c1up) {
		// TODO Auto-generated method stub
		XYSeriesCollection mCollection = new XYSeriesCollection();
		XYSeries mSeriesFirst = new XYSeries("c1");
		int i = 0;
		for (double c1 = c1down; c1 <= c1up; c1 = c1 + 0.05) {
			mSeriesFirst.add(c1, beta[i]);
			i++;
		}

		mCollection.addSeries(mSeriesFirst);
		return mCollection;

	}
}