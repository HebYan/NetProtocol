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
		mChartTheme.setLargeFont(new Font("����", Font.BOLD, 20));
		mChartTheme.setExtraLargeFont(new Font("����", Font.PLAIN, 15));
		mChartTheme.setRegularFont(new Font("����", Font.PLAIN, 15));
		ChartFactory.setChartTheme(mChartTheme);

		XYSeriesCollection mCollection = GetCollection(Beta0, bdown, bup);
		JFreeChart mChart = ChartFactory.createXYLineChart("", "b", "��0", mCollection, PlotOrientation.VERTICAL, true,
				true, false);

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
		ChartFrame mChartFrame = new ChartFrame("����b�Ħ�0�仯����ͼ", mChart);
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
