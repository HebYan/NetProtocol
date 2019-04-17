package cn.CrodSou.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class text3 extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = -6608552726989505905L;

	text3() {
		setLayout(null);
		// ��ѡ��ѡ��Ҫ��ͼ�ı���
		JRadioButton jr1 = new JRadioButton("alpha�仯����ͼ");
		JRadioButton jr2 = new JRadioButton("beta�仯����ͼ");
		JRadioButton jr3 = new JRadioButton("Rmax�仯����ͼ");
		JRadioButton jr4 = new JRadioButton("v_requester�仯����ͼ");

		ButtonGroup group = new ButtonGroup();
		group.add(jr1);
		group.add(jr2);
		group.add(jr3);
		group.add(jr4);

		jr1.setBounds(90, 100, 170, 20);
		jr2.setBounds(340, 100, 170, 20);
		jr3.setBounds(90, 140, 170, 20);
		jr4.setBounds(340, 140, 170, 20);

		add(jr1);
		add(jr2);
		add(jr3);
		add(jr4);

		// ������Ļ�ͼ��ť
		JButton draw = new JButton("��ͼ");
		draw.setBounds(240, 190, 100, 30);
		draw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jr1.isSelected()) {
					new alphaShow();
				}
				if (jr2.isSelected()) {
					new betaShow();
				}
				if (jr3.isSelected()) {
					new RmaxShow();
				}
				if (jr4.isSelected()) {
					new v_requesterShow();
				}
			}
		});
		add(draw);
	}
}
