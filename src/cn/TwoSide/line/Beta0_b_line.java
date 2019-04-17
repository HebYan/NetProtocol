package cn.TwoSide.line;

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

public class Beta0_b_line {
	public static void main(String[] args) {

	}

	public void bline1(double Beta0[], double bdown, double bup, double c, double s, double k, double w, double e) {
		StandardChartTheme mChartTheme = new StandardChartTheme("CN");
		mChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 20));
		mChartTheme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 15));
		mChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));
		ChartFactory.setChartTheme(mChartTheme);

		XYSeriesCollection mCollection = GetCollection(Beta0, bdown, bup);
		JFreeChart mChart = ChartFactory.createXYLineChart("", "b", "β0", mCollection, PlotOrientation.VERTICAL, true,
				true, false);

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
		ChartFrame mChartFrame = new ChartFrame("关于b的β0变化折线图", mChart);
		mChartFrame.pack();
		mChartFrame.setVisible(true);

	}

	private XYSeriesCollection GetCollection(double beta0[], double bdown, double bup) {
		// TODO Auto-generated method stub
		XYSeriesCollection mCollection = new XYSeriesCollection();
		XYSeries mSeriesFirst = new XYSeries("b");
		int i = 0;
		for (double b = bdown; b <= bup; b = b + 0.05) {
			mSeriesFirst.add(b, beta0[i]);
			i++;
		}

		mCollection.addSeries(mSeriesFirst);
		return mCollection;

	}
}
