package cn.CrodSou.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

public class alphaShow extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = -7047934599225516122L;
	alpha_x1 alpha_x1;
	alpha_x2 alpha_x2;
	alpha_c1 alpha_c1;
	alpha_c2 alpha_c2;
	alpha_s1 alpha_s1;
	alpha_s2 alpha_s2;
	alpha_d alpha_d;
	alpha_delta alpha_delta;
	JTabbedPane p;

	alphaShow() {
		setTitle("alpha�仯����ͼ");
		alpha_x1 = new alpha_x1();
		alpha_x2 = new alpha_x2();
		alpha_c1 = new alpha_c1();
		alpha_c2 = new alpha_c2();
		alpha_s1 = new alpha_s1();
		alpha_s2 = new alpha_s2();
		alpha_d = new alpha_d();
		alpha_delta = new alpha_delta();
		p = new JTabbedPane();
		p.add("x1�仯����", alpha_x1);
		p.add("x2�仯����", alpha_x2);
		p.add("c1�仯����", alpha_c1);
		p.add("c2�仯����", alpha_c2);
		p.add("s1�仯����", alpha_s1);
		p.add("s2�仯����", alpha_s2);
		p.add("d�仯����", alpha_d);
		p.add("delta�仯����", alpha_delta);
		add(p, BorderLayout.CENTER);
		setSize(700, 370);
		// p.setBounds(10,10,570,390);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		validate();
	}
}
