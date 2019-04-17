/**
 *
 */
package cn.hebyan.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author HerbertYang
 *
 */
public class FrameFactory {
	/**
	 * 创建修改背景颜色的设置窗体
	 *
	 * @return
	 */
	public static BackColorSettingFrame createDatabaseSettingFrame() {
		return new BackColorSettingFrame();
	};

	/**
	 * 创建点歌台窗口
	 *
	 * @return
	 */


}

class BackColorSettingFrame extends JFrame implements WindowListener, MouseListener {

	/**
	 *
	 */
	private static final long serialVersionUID = -5642229961752601686L;

	private List<JButton> button = null;
	private Color color[] = { Color.BLUE, Color.CYAN, Color.RED, Color.GRAY, Color.GREEN, Color.ORANGE, Color.YELLOW,
			Color.PINK, Color.WHITE };
	private String colorName[] = { "蓝色", "灰绿", "红色", "灰色", "绿色", "橙色", "黄色", "粉红", "白色" };

	public BackColorSettingFrame() throws HeadlessException {
		super("背景");
		init();
		registerListener();
	}

	private void init() {
		setSize(400, 299);
		Container contentPanel = this.getContentPane();
		contentPanel.setBackground(Color.WHITE);

		this.setLayout(new GridLayout(3, 3));
		button = new ArrayList<JButton>();
		for (int i = 0; i <= 8; i++) {
			button.add(new JButton(colorName[i]));
			button.get(i).setForeground(color[i]);
			contentPanel.add(button.get(i));
		}

		try {
			BufferedImage iconImage = ImageIO.read(new FileInputStream("img/iconImage.png"));
			this.setIconImage(iconImage);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Toolkit toolkit = this.getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		int screenHeight = dimension.height;
		int screenWidth = dimension.width;
		this.setLocation((screenWidth - this.getWidth()) / 2, (screenHeight - this.getHeight()) / 2);
		this.setVisible(true);
	}

	private void registerListener() {
		this.addWindowListener(this);
		for (int i = 0; i <= 8; i++) {
			button.get(i).addMouseListener(this);
		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		this.setVisible(false);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		for (int i = 0; i <= 8; i++) {
			if (arg0.getSource().equals(button.get(i))) {
				MainFrame.backColor = button.get(i).getForeground();
				new MainFrame();
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

}