package cn.CrodSou.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.CrodSou.Funtion.function;
import cn.CrodSou.line.alpha_d_line;

public class alpha_d extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = -8990929442309283844L;
	JButton button;
	JTextField text1, text2, text3, text4, text5, text6, text7, text8, text9;
	JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9;

	alpha_d() {
		setLayout(null);
		label1 = new JLabel("x1");
		text1 = new JTextField();
		label2 = new JLabel("x2");
		text2 = new JTextField();
		label3 = new JLabel("c1");
		text3 = new JTextField();
		label4 = new JLabel("c2");
		text4 = new JTextField();
		label5 = new JLabel("s1");
		text5 = new JTextField();
		label6 = new JLabel("s2");
		text6 = new JTextField();
		label7 = new JLabel("请输入d 的范围");
		text7 = new JTextField();
		label8 = new JLabel("-");
		text8 = new JTextField();
		label9 = new JLabel("delta");
		text9 = new JTextField();
		button = new JButton("生成曲线");
		add(label1);
		add(text1);
		add(label2);
		add(text2);
		add(label3);
		add(text3);
		add(label4);
		add(text4);
		add(label5);
		add(text5);
		add(label6);
		add(text6);
		add(label7);
		add(text7);
		add(label8);
		add(text8);
		add(label9);
		add(text9);
		add(button);
		label1.setBounds(80, 30, 100, 30);
		text1.setBounds(125, 30, 55, 30);
		label2.setBounds(450, 30, 45, 30);
		text2.setBounds(495, 30, 55, 30);
		label3.setBounds(80, 70, 100, 30);
		text3.setBounds(125, 70, 55, 30);
		label4.setBounds(450, 70, 100, 30);
		text4.setBounds(495, 70, 55, 30);
		label5.setBounds(80, 110, 100, 30);
		text5.setBounds(125, 110, 55, 30);
		label6.setBounds(450, 110, 100, 30);
		text6.setBounds(495, 110, 55, 30);
		label7.setBounds(10, 150, 100, 30);
		text7.setBounds(125, 150, 55, 30);
		label8.setBounds(197, 150, 100, 30);
		text8.setBounds(220, 150, 55, 30);
		label9.setBounds(450, 150, 45, 30);
		text9.setBounds(495, 150, 55, 30);
		button.setBounds(270, 190, 100, 30);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double x1 = Double.parseDouble(text1.getText().trim());
				double x2 = Double.parseDouble(text2.getText().trim());
				double c1 = Double.parseDouble(text3.getText().trim());
				double c2 = Double.parseDouble(text4.getText().trim());
				double s1 = Double.parseDouble(text5.getText().trim());
				double s2 = Double.parseDouble(text6.getText().trim());
				double ddown = Double.parseDouble(text7.getText().trim());
				double dup = Double.parseDouble(text8.getText().trim());
				double delta = Double.parseDouble(text9.getText().trim());
				double alpha[] = new double[100];
				int i = 0;

				function func = new function();

				func.setX1(x1);
				func.setX2(x2);
				func.setC1(c1);
				func.setC2(c2);
				func.setS1(s1);
				func.setS2(s2);
				func.setDelta(delta);
				for (double d = ddown; d <= dup; d = d + 0.01) {
					func.setD(d);
					alpha[i] = func.getAlpha();
					i++;
				}

				alpha_d_line alpha_d_line = new alpha_d_line();
				alpha_d_line.dline1(alpha, x1, x2, c1, c2, s1, s2, ddown, dup, delta);
			}
		});
	}
}
