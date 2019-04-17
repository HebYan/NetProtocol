package cn.CrodSou.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.CrodSou.Funtion.function;
import cn.CrodSou.line.Rmax_x1_line;

public class Rmax_x1 extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 646968881385761802L;
	JButton button;
	JTextField text1, text2, text3, text4, text5, text6, text7, text8, text9;
	JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9;

	Rmax_x1() {
		setLayout(null);
		label1 = new JLabel("请输入x1的范围");
		text1 = new JTextField();
		label2 = new JLabel("-");
		text2 = new JTextField();
		label3 = new JLabel("x2");
		text3 = new JTextField();
		label4 = new JLabel("c1");
		text4 = new JTextField();
		label5 = new JLabel("c2");
		text5 = new JTextField();
		label6 = new JLabel("s1");
		text6 = new JTextField();
		label7 = new JLabel("s2");
		text7 = new JTextField();
		label8 = new JLabel("d");
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
		label1.setBounds(10, 30, 100, 30);
		text1.setBounds(125, 30, 55, 30);
		label2.setBounds(197, 30, 45, 30);
		text2.setBounds(220, 30, 55, 30);
		label3.setBounds(450, 30, 100, 30);
		text3.setBounds(495, 30, 55, 30);
		label4.setBounds(80, 70, 100, 30);
		text4.setBounds(125, 70, 55, 30);
		label5.setBounds(450, 70, 100, 30);
		text5.setBounds(495, 70, 55, 30);
		label6.setBounds(80, 110, 100, 30);
		text6.setBounds(125, 110, 55, 30);
		label7.setBounds(450, 110, 45, 30);
		text7.setBounds(495, 110, 55, 30);
		label8.setBounds(80, 150, 100, 30);
		text8.setBounds(125, 150, 55, 30);
		label9.setBounds(450, 150, 45, 30);
		text9.setBounds(495, 150, 55, 30);
		button.setBounds(270, 190, 100, 30);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double x1down = Double.parseDouble(text1.getText().trim());
				double x1up = Double.parseDouble(text2.getText().trim());
				double x2 = Double.parseDouble(text3.getText().trim());
				double c1 = Double.parseDouble(text4.getText().trim());
				double c2 = Double.parseDouble(text5.getText().trim());
				double s1 = Double.parseDouble(text6.getText().trim());
				double s2 = Double.parseDouble(text7.getText().trim());
				double d = Double.parseDouble(text8.getText().trim());
				double delta = Double.parseDouble(text9.getText().trim());
				double Rmax[] = new double[100];
				int i = 0;

				function func = new function();

				func.setX2(x2);
				func.setC1(c1);
				func.setC2(c2);
				func.setS1(s1);
				func.setS2(s2);
				func.setD(d);
				func.setDelta(delta);
				for (double x1 = x1down; x1 <= x1up; x1 = x1 + 0.01) {
					func.setX1(x1);
					Rmax[i] = func.getRmax();
					i++;
				}

				Rmax_x1_line Rmax_x1_line = new Rmax_x1_line();
				Rmax_x1_line.x1line1(Rmax, x1down, x1up, x2, c1, c2, s1, s2, d, delta);
			}
		});
	}
}
