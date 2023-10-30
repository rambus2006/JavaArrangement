import java.io.*;
import javax.swing.JTextArea;

/**
 * 음악 파일의 경로를 받아 같은 이름을 가진 가사 파일(.txt)이 있는지를 확인하고
 * <br>가사 파일이 있으면 가사 파일의 내용을 표시하는 lyricText 컴포넌트가 있는 MainFrame에게 넘겨줍니다.
 * 
 * @author team3
 * @since JDK 1.6
 * @version 1.0.0
 */

public class LyricMaker {
	/**
	 * 클래스 PlayAction의 Play 메소드로부터 음악 파일의 경로(musicPath)를 받아 확장자만 txt로 바꾼 뒤
	 * <br>바뀐 경로를 클래스 LyricMaker의 makeLyric 메소드에게 보내주면 가사창에 표시가 됩니다.
	 * 
	 * @param musicPath
	 */
	LyricMaker(String musicPath) {
		String lyricPath = musicPath.replaceAll(".wav", ".txt");
		lyricPath = lyricPath.replaceAll(".mp3", ".txt");
		makeLyric(lyricPath);
	}
	
	/**
	 * 클래스 LyricMake의 생성자로부터 가사 파일의 경로(lyricPath)를 받아 
	 * <br> 가사 파일의 내용을 표시하는 lyricText를 만들어 MainFrame의 가사창 컴포넌트에게 보내줍니다.
	 * <br> 우리는 한글이 표시가 안 될 가능성을 생각해서 MS949 인코딩을 사용했습니다.
	 * 
	 * @param lyricPath 재생할 음악파일의 경로에서 확장자를 .txt 로 바꾼 경로
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
			lyric = "가사 파일이 없습니다.";
		}
		JTextArea lyricText = new JTextArea(lyric);
		lyricText.setEditable(false);
		MainFrame.updateLyric(lyricText);
	}
}