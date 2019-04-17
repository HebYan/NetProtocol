/**
 *
 */
package cn.hebyan.frame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;

import cn.hebyan.Util.CheckUserUtilClass;

/**
 * ��¼����
 *
 * @author Administrator
 *
 */
public class LoginFrame extends JFrame implements MouseListener {

	private JLabel jLabel_name = null;
	private JLabel jLabel_passWord = null;
	private JLabel loginImage = null;
	private JTextField jTextField_name = null;
	private JPasswordField jTextField_passWord = null;
	private JButton jButton_login = null;
	private JButton jButton_register = null;

	/**
	 *
	 */
	private static final long serialVersionUID = 2795101183540876292L;

	public LoginFrame() throws HeadlessException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		super("��¼");
		init();
		registerListener();
	}

	/**
	 * ��¼����ĳ�ʼ������
	 */
	private void init() {
		this.setLayout(null);

		Container container = this.getContentPane();
		ImageIcon icon_un = new ImageIcon("img/un.png");
		jLabel_name = new JLabel();
		jLabel_name.setIcon(icon_un);
		ImageIcon icon_up = new ImageIcon("img/up.png");
		jLabel_passWord = new JLabel();
		jLabel_passWord.setIcon(icon_up);
		loginImage = new JLabel();
		loginImage.setBounds(0, 0, 200, 200);
		jTextField_name = new JTextField();
		jTextField_passWord = new JPasswordField(13);
		jButton_login = new JButton("��¼");
		jButton_register = new JButton("ע��");
		jLabel_name.setBounds(230, 64, 100, 50);
		jLabel_passWord.setBounds(230, 99, 100, 50);
		jTextField_name.setBounds(270, 77, 128, 25);
		jTextField_passWord.setBounds(270, 111, 128, 25);
		jButton_login.setBounds(230, 141, 82, 30);
		jButton_register.setBounds(317, 141, 83, 30);
		container.add(jLabel_name);
		container.add(jLabel_passWord);
		container.add(jTextField_name);
		container.add(jTextField_passWord);
		container.add(jButton_login);
		container.add(jButton_register);
		container.setBackground(Color.WHITE);

		this.setSize(444, 260);
		Toolkit toolkit = container.getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		int screenWidth = dimension.width;
		int screenHeight = dimension.height;
		this.setLocation((screenWidth - this.getWidth()) / 2, (screenHeight - this.getHeight()) / 2);

		// �޸Ŀ���ͼ��
		try {
			BufferedImage image = ImageIO.read(new FileInputStream("img/iconImage.png"));
			Icon icon = new ImageIcon("img/login.png");
			this.loginImage.setIcon(icon);
			this.setIconImage(image);
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
		container.add(loginImage);

		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * Ϊ��¼����������Ӽ�����
	 */
	private void registerListener() {
		jButton_login.addMouseListener(this);
		jButton_register.addMouseListener(this);
	}

	@SuppressWarnings("deprecation")
	@Override
	/**
	 * ��¼��ť�Ĵ�����
	 */
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(jButton_login)) {
			if (CheckUserUtilClass.CheckUserUtilMethod(jTextField_name.getText(), jTextField_passWord.getText())) {
				JOptionPane.showMessageDialog(null, "<html>��¼�ɹ�</html>", "", 1);
				this.setVisible(false);
				new MainFrame();
			} else {
				JOptionPane.showMessageDialog(null, "<html>�û��������������<br/>����������</html>", "", 1);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}