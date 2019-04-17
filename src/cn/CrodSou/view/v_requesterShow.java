package cn.CrodSou.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

public class v_requesterShow extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = -8534078762167265039L;
	v_requester_x1 v_requester_x1;
	v_requester_x2 v_requester_x2;
	v_requester_c1 v_requester_c1;
	v_requester_c2 v_requester_c2;
	v_requester_s1 v_requester_s1;
	v_requester_s2 v_requester_s2;
	v_requester_d v_requester_d;
	v_requester_delta v_requester_delta;
	JTabbedPane p;

	v_requesterShow() {
		setTitle("v_requester变化曲线图");
		v_requester_x1 = new v_requester_x1();
		v_requester_x2 = new v_requester_x2();
		v_requester_c1 = new v_requester_c1();
		v_requester_c2 = new v_requester_c2();
		v_requester_s1 = new v_requester_s1();
		v_requester_s2 = new v_requester_s2();
		v_requester_d = new v_requester_d();
		v_requester_delta = new v_requester_delta();
		p = new JTabbedPane();
		p.add("x1变化曲线", v_requester_x1);
		p.add("x2变化曲线", v_requester_x2);
		p.add("c1变化曲线", v_requester_c1);
		p.add("c2变化曲线", v_requester_c2);
		p.add("s1变化曲线", v_requester_s1);
		p.add("s2变化曲线", v_requester_s2);
		p.add("d变化曲线", v_requester_d);
		p.add("delta变化曲线", v_requester_delta);
		add(p, BorderLayout.CENTER);
		setSize(700, 370);
		// p.setBounds(10,10,570,390);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		validate();
	}
}
