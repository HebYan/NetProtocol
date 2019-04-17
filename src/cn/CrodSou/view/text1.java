package cn.CrodSou.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cn.CrodSou.Funtion.function1;
import cn.CrodSou.Funtion.function2;
import cn.CrodSou.Funtion.function3;
import cn.CrodSou.Funtion.function4;

public class text1 extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = -3837118271623908949L;

	text1() {
		setLayout(null);

		// 最上面的8个输入文本框
		JLabel x1 = new JLabel("x1");
		JLabel x2 = new JLabel("x2");
		JLabel c1 = new JLabel("c1");
		JLabel c2 = new JLabel("c2");
		JLabel s1 = new JLabel("s1");
		JLabel s2 = new JLabel("s2");
		JLabel d1 = new JLabel("d");
		JLabel d2 = new JLabel("delta");

		JTextField xx1 = new JTextField("0.1", 10);
		JTextField xx2 = new JTextField("0.1", 10);
		JTextField cc1 = new JTextField("0.1", 10);
		JTextField cc2 = new JTextField("0.1", 10);
		JTextField ss1 = new JTextField("0.1", 10);
		JTextField ss2 = new JTextField("0.1", 10);
		JTextField dd1 = new JTextField("0.3", 10);
		JTextField dd2 = new JTextField("0.95", 10);

		x1.setBounds(50, 50, 20, 20);
		xx1.setBounds(70, 50, 60, 25);
		x2.setBounds(180, 50, 20, 20);
		xx2.setBounds(200, 50, 60, 25);
		c1.setBounds(310, 50, 20, 20);
		cc1.setBounds(330, 50, 60, 25);
		c2.setBounds(440, 50, 20, 20);
		cc2.setBounds(460, 50, 60, 25);
		s1.setBounds(50, 90, 20, 20);
		ss1.setBounds(70, 90, 60, 25);
		s2.setBounds(180, 90, 20, 20);
		ss2.setBounds(200, 90, 60, 25);
		d1.setBounds(315, 90, 20, 20);
		dd1.setBounds(330, 90, 60, 25);
		d2.setBounds(425, 90, 40, 20);
		dd2.setBounds(460, 90, 60, 25);

		add(x1);
		add(xx1);
		add(x2);
		add(xx2);
		add(c1);
		add(cc1);
		add(c2);
		add(cc2);
		add(s1);
		add(ss1);
		add(s2);
		add(ss2);
		add(d1);
		add(dd1);
		add(d2);
		add(dd2);

		// 中间的4个输出文本框
		JLabel alpha = new JLabel("alpha");
		JLabel beta = new JLabel("beta");
		JLabel Rmax = new JLabel("Rmax");
		JLabel v_requester = new JLabel("v_requester");

		JTextField alpha1 = new JTextField("", 10);
		JTextField beta1 = new JTextField("", 10);
		JTextField Rmax1 = new JTextField("", 10);
		JTextField v_requester1 = new JTextField("", 10);

		alpha.setBounds(100, 180, 40, 20);
		alpha1.setBounds(150, 180, 60, 25);
		beta.setBounds(360, 180, 80, 20);
		beta1.setBounds(410, 180, 60, 25);
		Rmax.setBounds(100, 220, 40, 20);
		Rmax1.setBounds(150, 220, 60, 25);
		v_requester.setBounds(320, 220, 80, 20);
		v_requester1.setBounds(410, 220, 60, 25);

		add(alpha);
		add(alpha1);
		add(beta);
		add(beta1);
		add(Rmax);
		add(Rmax1);
		add(v_requester);
		add(v_requester1);

		// 精度选择下拉列表
		JLabel choice = new JLabel("请选择计算精度：");
		choice.setBounds(70, 140, 100, 20);
		add(choice);
		JComboBox<String> comBox = new JComboBox<String>();
		comBox.addItem("0.01");
		comBox.addItem("0.001");
		comBox.addItem("0.0001");
		comBox.addItem("0.00001");
		comBox.setBounds(170, 140, 100, 30);
		add(comBox);

		// 进度条
		JProgressBar progressBar = new JProgressBar();
		progressBar.setOrientation(SwingConstants.HORIZONTAL);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setBounds(50, 255, 475, 25);
		progressBar.setStringPainted(true);
		add(progressBar);

		// 上面的计算按钮
		JButton sub = new JButton("计算");
		sub.setBounds(350, 140, 100, 30);
		sub.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double x1 = Double.parseDouble(xx1.getText().trim());
				double x2 = Double.parseDouble(xx2.getText().trim());
				double c1 = Double.parseDouble(cc1.getText().trim());
				double c2 = Double.parseDouble(cc2.getText().trim());
				double s1 = Double.parseDouble(ss1.getText().trim());
				double s2 = Double.parseDouble(ss2.getText().trim());
				double d = Double.parseDouble(dd1.getText().trim());
				double delta = Double.parseDouble(dd2.getText().trim());

				// 已将文本框中的数据取出
				System.out.println(x1);
				System.out.println(x2);
				System.out.println(c1);
				System.out.println(c2);
				System.out.println(s1);
				System.out.println(s2);
				System.out.println(d);
				System.out.println(delta);

				// 读取下拉框
				String jd = comBox.getSelectedItem().toString();

				// 进度条显示
				if (e.getSource() == sub) {
					new Thread(new Runnable() {
						@Override
						public void run() {
							for (int i = 0; i <= 10; i++) {
								progressBar.setValue(i * 10);
								try {
									TimeUnit.SECONDS.sleep(0);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					}).start();
				}

				// 计算
				if (jd.equals("0.01")) {
					function1 func1 = new function1();
					func1.setX1(x1);
					func1.setX2(x2);
					func1.setC1(c1);
					func1.setC2(c2);
					func1.setS1(s1);
					func1.setS2(s2);
					func1.setD(d);
					func1.setDelta(delta);

					double alpha = func1.getAlpha();
					System.out.println(alpha);
					alpha1.setText(String.format("%.2f", alpha));

					double beta = func1.getBeta();
					System.out.println(beta);
					beta1.setText(String.format("%.2f", beta));

					double Rmax = func1.getRmax();
					System.out.println(Rmax);
					Rmax1.setText(String.format("%.2f", Rmax));

					double v_requester = func1.getV_requester();
					System.out.println(v_requester);
					v_requester1.setText(String.format("%.2f", v_requester));
				}

				if (jd.equals("0.001")) {
					function2 func2 = new function2();
					func2.setX1(x1);
					func2.setX2(x2);
					func2.setC1(c1);
					func2.setC2(c2);
					func2.setS1(s1);
					func2.setS2(s2);
					func2.setD(d);
					func2.setDelta(delta);

					double alpha = func2.getAlpha();
					System.out.println(alpha);
					alpha1.setText(String.format("%.2f", alpha));

					double beta = func2.getBeta();
					System.out.println(beta);
					beta1.setText(String.format("%.2f", beta));

					double Rmax = func2.getRmax();
					System.out.println(Rmax);
					Rmax1.setText(String.format("%.2f", Rmax));

					double v_requester = func2.getV_requester();
					System.out.println(v_requester);
					v_requester1.setText(String.format("%.2f", v_requester));
				}

				if (jd.equals("0.0001")) {
					function3 func3 = new function3();
					func3.setX1(x1);
					func3.setX2(x2);
					func3.setC1(c1);
					func3.setC2(c2);
					func3.setS1(s1);
					func3.setS2(s2);
					func3.setD(d);
					func3.setDelta(delta);

					double alpha = func3.getAlpha();
					System.out.println(alpha);
					alpha1.setText(String.format("%.2f", alpha));

					double beta = func3.getBeta();
					System.out.println(beta);
					beta1.setText(String.format("%.2f", beta));

					double Rmax = func3.getRmax();
					System.out.println(Rmax);
					Rmax1.setText(String.format("%.2f", Rmax));

					double v_requester = func3.getV_requester();
					System.out.println(v_requester);
					v_requester1.setText(String.format("%.2f", v_requester));
				}

				if (jd.equals("0.00001")) {
					function4 func4 = new function4();
					func4.setX1(x1);
					func4.setX2(x2);
					func4.setC1(c1);
					func4.setC2(c2);
					func4.setS1(s1);
					func4.setS2(s2);
					func4.setD(d);
					func4.setDelta(delta);

					double alpha = func4.getAlpha();
					System.out.println(alpha);
					alpha1.setText(String.format("%.2f", alpha));

					double beta = func4.getBeta();
					System.out.println(beta);
					beta1.setText(String.format("%.2f", beta));

					double Rmax = func4.getRmax();
					System.out.println(Rmax);
					Rmax1.setText(String.format("%.2f", Rmax));

					double v_requester = func4.getV_requester();
					System.out.println(v_requester);
					v_requester1.setText(String.format("%.2f", v_requester));
				}
			}
		});
		add(sub);
	}
}
