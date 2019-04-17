/**
 *
 */
package cn.hebyan.frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cn.CrodSou.view.text0;
import cn.TwoSide.view.TS;
import cn.hebyan.Util.SPB;

/**
 * 主体窗体的类文件
 *
 * @author Administrator
 *
 */
public class MainFrame extends JFrame implements MouseListener, WindowListener, ActionListener {

	public static Color backColor = Color.WHITE;
	private CardLayout cardLayout = new CardLayout();
	private JPanel cardPanel = null;
	private JPanel controlPanel = null;
	private JButton button_first = null;
	private JButton button_next = null;
	private JButton button_previous = null;
	private JButton button_last = null;
	private JButton button_config = null;
	private JLabel jLabel_SBPJ = null;
	private JLabel jLabel_QZGZ = null;
	private JLabel jLabel_NSXX = null;
	private int now_card = 0;
	private static int NUM_OF_CONTROLPANEL = -1;
	private List<String> nameList = null;
	private JMenuBar jMenuBar = null;
	private JMenu preferences = null;
	private JMenuItem preferences_back = null;
	private JMenu support = null;
	private JMenuItem support_video = null;
	private JMenuItem support_tel = null;
	private JMenuItem support_mail = null;
	private JMenu entertainment = null;
	private JMenuItem entertainment_music = null;
	private JMenu about = null;
	private JMenuItem about_help = null;
	/**
	 *
	 */
	private static final long serialVersionUID = 1399837871947135659L;

	public MainFrame() throws HeadlessException {
		super("协议选择");
		init();
		registerListener();
	}

	/**
	 * 主窗体的初始化函数
	 */
	private void init() {
		this.setSize(888, 666);
		Container contentPanel = this.getContentPane();

		Toolkit toolkit = this.getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		int screenHeight = dimension.height;
		int screenWidth = dimension.width;
		this.setLocation((screenWidth - this.getWidth()) / 2, (screenHeight - this.getHeight()) / 2);

		jMenuBar = new JMenuBar();
		jMenuBar.setBorder(BorderFactory.createRaisedBevelBorder());
		contentPanel.add(jMenuBar, BorderLayout.NORTH);
		preferences = new JMenu("首选项  ");
		preferences_back = new JMenuItem("设置背景  ");
		preferences.add(preferences_back);
		jMenuBar.add(preferences);
		support = new JMenu("技术支持  ");
		support_video = new JMenuItem("视频教程  ");
		support_tel = new JMenuItem("电话支持  ");
		support_mail = new JMenuItem("邮件咨询  ");
		support.add(support_video);
		support.add(support_mail);
		support.add(support_tel);
		jMenuBar.add(support);
		//entertainment = new JMenu("娱乐一下  ");
		//entertainment_music = new JMenuItem("点歌台  ");
		//entertainment.add(entertainment_music);
		//jMenuBar.add(entertainment);
		about = new JMenu("关于  ");
		about_help = new JMenuItem("帮助  ");
		about.add(about_help);
		jMenuBar.add(about);

		controlPanel = new JPanel();
		controlPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		controlPanel.setLayout(new FlowLayout(20, 23, 20));
		controlPanel.setBackground(backColor);
		contentPanel.add(controlPanel, BorderLayout.SOUTH);
		cardPanel = new JPanel();
		cardPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		cardPanel.setLayout(cardLayout);
		cardPanel.setBackground(backColor);
		contentPanel.add(cardPanel, BorderLayout.CENTER);

		button_first = new JButton("第一张");
		button_next = new JButton("下一张");
		button_previous = new JButton("上一张");
		button_last = new JButton("最后一张");
		button_config = new JButton("配置协议");
		controlPanel.add(button_first);
		controlPanel.add(button_next);
		controlPanel.add(button_previous);
		controlPanel.add(button_last);
		controlPanel.add(button_config);

		jLabel_NSXX = new JLabel();
		jLabel_QZGZ = new JLabel();
		jLabel_SBPJ = new JLabel();
		jLabel_NSXX.setText("<html>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp众包困境"
				+ "<br>&nbsp 这个协议是这样那样<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></html>");
		jLabel_QZGZ.setText("<html>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp群智感知"
				+ "<br>&nbsp 这个协议是这样那样<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></html>");
		jLabel_SBPJ.setText("<html>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp双边评级"
				+ "<br>&nbsp 这个协议是这样那样<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></html>");

		nameList = new ArrayList<String>();
		cardPanel.add(jLabel_NSXX);
		NUM_OF_CONTROLPANEL++;
		nameList.add("NSXX");
		cardPanel.add(jLabel_QZGZ);
		NUM_OF_CONTROLPANEL++;
		nameList.add("QZGZ");
		cardPanel.add(jLabel_SBPJ);
		NUM_OF_CONTROLPANEL++;
		nameList.add("SBPJ");

		this.add(cardPanel, BorderLayout.CENTER);
		this.add(controlPanel, BorderLayout.SOUTH);
		try {
			BufferedImage iconImage = ImageIO.read(new FileInputStream("img/iconImage.png"));
			this.setIconImage(iconImage);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.setVisible(true);
	}

	/**
	 * 为主窗体的组件添加监听器
	 */
	private void registerListener() {
		this.addWindowListener(this);
		button_previous.addMouseListener(this);
		button_next.addMouseListener(this);
		button_first.addMouseListener(this);
		button_last.addMouseListener(this);
		button_config.addMouseListener(this);
		preferences_back.addActionListener(this);
		support_video.addActionListener(this);
		support_tel.addActionListener(this);
		support_mail.addActionListener(this);
		//entertainment_music.addActionListener(this);
		about_help.addActionListener(this);
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	/**
	 * 主窗体的退出方式：退出程序
	 */
	public void windowClosing(WindowEvent e) {
		JOptionPane.showConfirmDialog(null, "退出程序？", "", 1);
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == button_previous) {
			cardLayout.previous(cardPanel);
			if (now_card != 0) {
				now_card--;
			} else {
				now_card = NUM_OF_CONTROLPANEL;
			}
		}
		if (arg0.getSource() == button_config) {
			if (nameList.get(now_card).equals("NSXX")) {
				System.out.println("NSXX");
				text0.CrodSide();

			}
			if (nameList.get(now_card).equals("QZGZ")) {
				System.out.println("QZGZ");
			}
			if (nameList.get(now_card).equals("SBPJ")) {
				System.out.println("SBPJ");
				TS.start();
				;
			}
		}
		if (arg0.getSource() == button_last) {
			cardLayout.last(cardPanel);
			now_card = NUM_OF_CONTROLPANEL;
		}
		if (arg0.getSource() == button_first) {
			cardLayout.first(cardPanel);
			now_card = 0;
		}
		if (arg0.getSource() == button_next) {
			cardLayout.next(cardPanel);
			if (now_card != NUM_OF_CONTROLPANEL) {
				now_card++;
			} else {
				now_card = 0;
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == preferences_back) {
			FrameFactory.createDatabaseSettingFrame();
			this.setVisible(false);
		}
		if (arg0.getSource() == support_mail) {
			JOptionPane.showMessageDialog(null, "我的邮箱hebyan@yeah.net", "", 3);
		}
		if (arg0.getSource() == support_video) {
			JOptionPane.showMessageDialog(null, "pan.com/Sos9199x.cn", "", 3);
		}
		if (arg0.getSource() == support_tel) {
			JOptionPane.showMessageDialog(null, "拨打15558699199", "", 3);
		}

		if (arg0.getSource() == about_help) {
			JOptionPane.showMessageDialog(null, "网络协议设计软件1.0", "", 3);
			SPB.borwer();

		}

	}

}
