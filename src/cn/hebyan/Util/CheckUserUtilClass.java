/**
 *
 */
package cn.hebyan.Util;

/**
 * ����¼���û�
 *
 * @author Administrator
 *
 */
public class CheckUserUtilClass {

	public CheckUserUtilClass() {
		super();
	}

	public static boolean CheckUserUtilMethod(String name, String passWord) {
		boolean returnBoolean = false;

		if (name.equals(User.name) && passWord.equals(User.passWord)) {
			returnBoolean = true;
		} else {
			returnBoolean = false;
		}
		return returnBoolean;
	}

}
