/**
 *
 */
package cn.hebyan.Main;

import cn.hebyan.frame.LoginFrame;

import javax.swing.*;
import java.awt.*;

/**
 * ����Э���漰��������
 *
 * @author HebYan
 *    
 */
public class Main {

	/**
	 * @param args
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws HeadlessException
	 */
	public static void main(String[] args) throws HeadlessException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		// UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
		new LoginFrame();
	}

}