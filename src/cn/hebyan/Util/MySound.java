/**
 *
 */
package cn.hebyan.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
/**
 * @author HerbertYang
 *
 */
import java.util.logging.Level;
import java.util.logging.Logger;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * 点歌台
 *
 * @author HerbertYang
 *
 */
public class MySound extends Thread {

	private String musicName = null;

	// 加载音乐
	public MySound(String musicName) {
		this.musicName = musicName;
	}

	// 播放音乐
	public static void play(String musicName) throws FileNotFoundException {
		try {
			FileInputStream mp3 = new FileInputStream(musicName);
			new Player(mp3).play();
		} catch (JavaLayerException ex) {
			Logger.getLogger(MySound.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// 循环播放音乐
	public void loop() {
		this.start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				new Player(getClass().getResourceAsStream(musicName)).play();
			} catch (JavaLayerException ex) {
				Logger.getLogger(MySound.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

}
