package cn.CrodSou.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

public class RmaxShow extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = -3467290095650251217L;
	Rmax_x1 Rmax_x1;
	Rmax_x2 Rmax_x2;
	Rmax_c1 Rmax_c1;
	Rmax_c2 Rmax_c2;
	Rmax_s1 Rmax_s1;
	Rmax_s2 Rmax_s2;
	Rmax_d Rmax_d;
	Rmax_delta Rmax_delta;
	JTabbedPane p;

	RmaxShow() {
		setTitle("Rmax�仯����ͼ");
		Rmax_x1 = new Rmax_x1();
		Rmax_x2 = new Rmax_x2();
		Rmax_c1 = new Rmax_c1();
		Rmax_c2 = new Rmax_c2();
		Rmax_s1 = new Rmax_s1();
		Rmax_s2 = new Rmax_s2();
		Rmax_d = new Rmax_d();
		Rmax_delta = new Rmax_delta();
		p = new JTabbedPane();
		p.add("x1�仯����", Rmax_x1);
		p.add("x2�仯����", Rmax_x2);
		p.add("c1�仯����", Rmax_c1);
		p.add("c2�仯����", Rmax_c2);
		p.add("s1�仯����", Rmax_s1);
		p.add("s2�仯����", Rmax_s2);
		p.add("d�仯����", Rmax_d);
		p.add("delta�仯����", Rmax_delta);
		add(p, BorderLayout.CENTER);
		setSize(700, 370);
		// p.setBounds(10,10,570,390);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		validate();
	}
}
