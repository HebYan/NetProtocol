/**
 *
 */
package cn.hebyan.Util;

/**
 * 检查登录的用户
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
