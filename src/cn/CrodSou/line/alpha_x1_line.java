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

public class alpha_x1_line {
	public static void main(String[] args) {

	}

	public void x1line1(double alpha[], double x1down, double x1up, double x2, double c1, double c2, double s1,
			double s2, double d, double delta) {

		StandardChartTheme mChartTheme = new StandardChartTheme("CN");
		mChartTheme.setLargeFont(new Font("����", Font.BOLD, 20));
		mChartTheme.setExtraLargeFont(new Font("����", Font.PLAIN, 15));
		mChartTheme.setRegularFont(new Font("����", Font.PLAIN, 15));
		ChartFactory.setChartTheme(mChartTheme);

		XYSeriesCollection mCollection = GetCollection(alpha, x1down, x1up);
		JFreeChart mChart = ChartFactory.createXYLineChart("", "x1", "alpha", mCollection, PlotOrientation.VERTICAL,
				true, true, false);

		// ����һ������
		TextTitle texttitle = new TextTitle();
		// ���ñ�������
		texttitle.setFont(new Font("����", 0, 15));
		// ���ñ������¶���
		texttitle.setPosition(RectangleEdge.BOTTOM);
		// ���ñ������Ҷ���
		texttitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
		// ���ͼ����ӱ���
		mChart.addSubtitle(texttitle);
		ChartFrame mChartFrame = new ChartFrame("����x1��alpha�仯����ͼ", mChart);
		mChartFrame.pack();
		mChartFrame.setVisible(true);

	}

	private XYSeriesCollection GetCollection(double alpha[], double x1down, double x1up) {
		// TODO Auto-generated method stub
		XYSeriesCollection mCollection = new XYSeriesCollection();
		XYSeries mSeriesFirst = new XYSeries("x1");
		int i = 0;
		for (double x1 = x1down; x1 <= x1up; x1 = x1 + 0.05) {
			mSeriesFirst.add(x1, alpha[i]);
			i++;
		}

		mCollection.addSeries(mSeriesFirst);
		return mCollection;

	}
}