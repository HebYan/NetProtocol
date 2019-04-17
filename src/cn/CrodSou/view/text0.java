package cn.CrodSou.view;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

public class text0 extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 3950036336753597024L;

	public text0() {
		setTitle("面向众包竞争困境的剥削与合作激励机制定制软件");
		setLayout(new GridLayout(2, 1));
		Container c = getContentPane();

		text1 text1 = new text1();
		text3 text3 = new text3();
		c.add(text1);
		c.add(text3);

		Border border1 = BorderFactory.createTitledBorder("输入/输出参数");
		text1.setBorder(border1);
		Border border3 = BorderFactory.createTitledBorder("曲线图");
		text3.setBorder(border3);

		setSize(600, 620);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		validate();
	}

	public static void CrodSide( ){
		/*try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");// Nimbus风格，jdk6
																							// update10版本以后的才会出现
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		new text0();
	}
}
