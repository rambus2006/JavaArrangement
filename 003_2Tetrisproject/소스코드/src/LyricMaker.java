import java.io.*;
import javax.swing.JTextArea;

/**
 * ���� ������ ��θ� �޾� ���� �̸��� ���� ���� ����(.txt)�� �ִ����� Ȯ���ϰ�
 * <br>���� ������ ������ ���� ������ ������ ǥ���ϴ� lyricText ������Ʈ�� �ִ� MainFrame���� �Ѱ��ݴϴ�.
 * 
 * @author team3
 * @since JDK 1.6
 * @version 1.0.0
 */

public class LyricMaker {
	/**
	 * Ŭ���� PlayAction�� Play �޼ҵ�κ��� ���� ������ ���(musicPath)�� �޾� Ȯ���ڸ� txt�� �ٲ� ��
	 * <br>�ٲ� ��θ� Ŭ���� LyricMaker�� makeLyric �޼ҵ忡�� �����ָ� ����â�� ǥ�ð� �˴ϴ�.
	 * 
	 * @param musicPath
	 */
	LyricMaker(String musicPath) {
		String lyricPath = musicPath.replaceAll(".wav", ".txt");
		lyricPath = lyricPath.replaceAll(".mp3", ".txt");
		makeLyric(lyricPath);
	}
	
	/**
	 * Ŭ���� LyricMake�� �����ڷκ��� ���� ������ ���(lyricPath)�� �޾� 
	 * <br> ���� ������ ������ ǥ���ϴ� lyricText�� ����� MainFrame�� ����â ������Ʈ���� �����ݴϴ�.
	 * <br> �츮�� �ѱ��� ǥ�ð� �� �� ���ɼ��� �����ؼ� MS949 ���ڵ��� ����߽��ϴ�.
	 * 
	 * @param lyricPath ����� ���������� ��ο��� Ȯ���ڸ� .txt �� �ٲ� ���
	 */
	void makeLyric(String lyricPath) {
		InputStream is;
		String lyric = "";
		byte buf[] = new byte[1024];
		try {
			is = new FileInputStream(lyricPath);
			int len = is.read(buf, 0, buf.length);
			lyric = new String(buf, 0, len, "MS949");
		} catch (IOException e1) {
			lyric = "���� ������ �����ϴ�.";
		}
		JTextArea lyricText = new JTextArea(lyric);
		lyricText.setEditable(false);
		MainFrame.updateLyric(lyricText);
	}
}