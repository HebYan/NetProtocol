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

public class beta_c2_line {
	public static void main(String[] args) {

	}

	public void c2line1(double beta[], double x1, double x2, double c1, double c2down, double c2up, double s1,
			double s2, double d, double delta) {

		StandardChartTheme mChartTheme = new StandardChartTheme("CN");
		mChartTheme.setLargeFont(new Font("����", Font.BOLD, 20));
		mChartTheme.setExtraLargeFont(new Font("����", Font.PLAIN, 15));
		mChartTheme.setRegularFont(new Font("����", Font.PLAIN, 15));
		ChartFactory.setChartTheme(mChartTheme);

		XYSeriesCollection mCollection = GetCollection(beta, c2down, c2up);
		JFreeChart mChart = ChartFactory.createXYLineChart("", "c2", "beta", mCollection, PlotOrientation.VERTICAL,
				true, true, false);

		// ����һ������
		TextTitle texttitle = new TextTitle();
		// ���ñ�������
		texttitle.setFont(new Font("����", 0, 15));
		// ���ñ������¶���
		texttitle.setPosition(RectangleEdge.BOTTOM);
		// ���ñ������Ҷ���
		texttitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
		// ����ͼ�����ӱ���
		mChart.addSubtitle(texttitle);
		ChartFrame mChartFrame = new ChartFrame("����c2��beta�仯����ͼ", mChart);
		mChartFrame.pack();
		mChartFrame.setVisible(true);

	}

	private XYSeriesCollection GetCollection(double beta[], double c2down, double c2up) {
		// TODO Auto-generated method stub
		XYSeriesCollection mCollection = new XYSeriesCollection();
		XYSeries mSeriesFirst = new XYSeries("c2");
		int i = 0;
		for (double c2 = c2down; c2 <= c2up; c2 = c2 + 0.05) {
			mSeriesFirst.add(c2, beta[i]);
			i++;
		}

		mCollection.addSeries(mSeriesFirst);
		return mCollection;

	}
}