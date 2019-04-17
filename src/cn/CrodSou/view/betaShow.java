package cn.CrodSou.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

public class betaShow extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = -5271662110727371746L;
	beta_x1 beta_x1;
	beta_x2 beta_x2;
	beta_c1 beta_c1;
	beta_c2 beta_c2;
	beta_s1 beta_s1;
	beta_s2 beta_s2;
	beta_d beta_d;
	beta_delta beta_delta;
	JTabbedPane p;

	betaShow() {
		setTitle("beta变化曲线图");
		beta_x1 = new beta_x1();
		beta_x2 = new beta_x2();
		beta_c1 = new beta_c1();
		beta_c2 = new beta_c2();
		beta_s1 = new beta_s1();
		beta_s2 = new beta_s2();
		beta_d = new beta_d();
		beta_delta = new beta_delta();
		p = new JTabbedPane();
		p.add("x1变化曲线", beta_x1);
		p.add("x2变化曲线", beta_x2);
		p.add("c1变化曲线", beta_c1);
		p.add("c2变化曲线", beta_c2);
		p.add("s1变化曲线", beta_s1);
		p.add("s2变化曲线", beta_s2);
		p.add("d变化曲线", beta_d);
		p.add("delta变化曲线", beta_delta);
		add(p, BorderLayout.CENTER);
		setSize(700, 370);
		// p.setBounds(10,10,570,390);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		validate();
	}
}
