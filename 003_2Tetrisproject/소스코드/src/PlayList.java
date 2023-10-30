import java.util.*;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * OpenAction 클래스의 파일추저가 보낸 경로들을 저장하고 데이터를 관리하는 클래스입니다.
 * <br>1. AUDIO_LIST : 음악 파일 경로가 저장됩니다. (절대경로)
 * <br>2. NAME_LIST : 음악 파일의 이름(디렉토리를 제외한 파일.확장자)이 저장됩니다.
 * <br> 추가로 재생방식과 관련된 여러 메소드가 있으니 부연설명을 참고하시길 바랍니다.
 * 
 * @author yunki, jihun
 * @version 1.0.0
 * @since JDK 1.6
 */
public class PlayList {
	private static Vector<String> 		AUDIO_LIST = new Vector<String>();	//음악 파일 경로 벡터
	private static Vector<String>		NAME_LIST = new Vector<String>();	//음악 파일 이름 벡터

	private static JList<?> 			playList;							//MainFrame에서 파일을 보여주고 선택받는 리스트
	private static int 					playNo = 0;							//지금 실행 중인 음악의 번호 저장

	/**
	 * 파일경로를 받아 파일의 경로와 이름을 가각 
	 * <br> AUDIO_LIST, NAME_LIST 벡터에 추가시켜주는 메소드입니다.
	 * @param filepath 파일 추저가 선택한 파일의 경로
	 * @author jihun
	 */
	public static void add(String filepath) {
		String[] splitedPath = filepath.split("\\\\");
		String name = splitedPath[splitedPath.length - 1];

		String[] splitedName = name.split("\\.");
		if(!(splitedName[splitedName.length - 1].equals("wav")) && !(splitedName[splitedName.length - 1].equals("mp3"))) {
			JOptionPane.showMessageDialog(null, "지원하지 않는 파일 형식입니다..", 
					"경고", JOptionPane.WARNING_MESSAGE);
			return;
		}

		//AUDIO_LIST에 새로운 음악 파일 경로 추가
		AUDIO_LIST.add(filepath);   
		NAME_LIST.add(name);
		//음악 파일의 경로를 '/'로 나눠 마지막에 위치한 파일 이름을 NAME_LIST에 집어넣는다. 

		//파일이 추가됐으므로 새로운 JList(playList)를 만들어 MainFrame으로 보내준다.
		playList = new JList<Object>(NAME_LIST);
		JListHandler handler = new JListHandler();
		playList.addListSelectionListener(handler);
		playList.setFocusable(false);
		MainFrame.updateList(playList);
	}

	/**
	 * 지금 재생 중인, 혹은 재생할 음악의 번호를 제공합니다.
	 * @return playNo
	 * @author jihun, changhee
	 */
	public static int getplayNo() {
		return playNo;
	}

	/**
	 * 리스트에 존재하는 음악파일의 인덱스 번호를 설정합니다.
	 * @param playNo 리스트의 아이템들이 갖는 인덱스 번호입니다. 재생방식에 용이하게 사용됩니다.
	 * @author jihun, changhee
	 */
	public static void setplayNo(int playNo) {
		PlayList.playNo = playNo;
	}

	/**
	 * 재생중인 파일의 다음 파일을 재생합니다.
	 * <br>재생중인 파일이 리스트의 마지막이면 처음 파일을 재생합니다.
	 * @author jihun, changhee
	 */
	public static void nextFile() {
		if(playNo + 1 > AUDIO_LIST.size() - 1) {
			playNo = 0;
		}
		else {
			playNo++;
		}
	}

	/**
	 * 재생중인 파일의 이전 파일을 재생합니다.
	 * <br>재생중인 파일이 리스트의 처음이면 마지막 파일을 재생합니다.
	 * @author jihun, changhee
	 */
	public static void prevFile() {
		if(playNo - 1 < 0) {
			playNo = AUDIO_LIST.size() - 1;
		}
		else {
			playNo--;
		}
	}

	/**
	 * 음악파일 경로가 담아있는 벡터(AUDIO_LIST)의 크기를 제공합니다.
	 * @return AUDIO_LIST.size()
	 * @author jihun, changhee
	 */
	public static int getListSize() {
		return AUDIO_LIST.size();
	}

	/**
	 * 현재 재생할 파일 경로를 제공합니다.
	 * @return AUDIO_LIST.get(playNo)
	 * @author jihun, changhee
	 */
	public static String getPath() {
		return AUDIO_LIST.get(playNo);
	}

	/**
	 * PlayList가 파일을 선택할 수 있도록 만드는 헨들러입니다.
	 * @author jihun
	 */
	public static class JListHandler implements ListSelectionListener
	{
		/**
		 * 리스트의 항목이 선택이 되면
		 * <br>playNo(재생파일의 번호)를 선택된 항목의 번호로 바꿉니다.
		 */
		public void valueChanged(ListSelectionEvent arg0) {
			// getContentPane(): GUI 컴포넌트의 참조를 반환
			// setBackground(): 컴포넌트의 배경을 설정
			// getSelectedIndex(): 선택된 항목의 인덱스 반환
			playNo = playList.getSelectedIndex();
		}
	}
}