import java.util.*;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * OpenAction Ŭ������ ���������� ���� ��ε��� �����ϰ� �����͸� �����ϴ� Ŭ�����Դϴ�.
 * <br>1. AUDIO_LIST : ���� ���� ��ΰ� ����˴ϴ�. (������)
 * <br>2. NAME_LIST : ���� ������ �̸�(���丮�� ������ ����.Ȯ����)�� ����˴ϴ�.
 * <br> �߰��� �����İ� ���õ� ���� �޼ҵ尡 ������ �ο������� �����Ͻñ� �ٶ��ϴ�.
 * 
 * @author yunki, jihun
 * @version 1.0.0
 * @since JDK 1.6
 */
public class PlayList {
	private static Vector<String> 		AUDIO_LIST = new Vector<String>();	//���� ���� ��� ����
	private static Vector<String>		NAME_LIST = new Vector<String>();	//���� ���� �̸� ����

	private static JList<?> 			playList;							//MainFrame���� ������ �����ְ� ���ù޴� ����Ʈ
	private static int 					playNo = 0;							//���� ���� ���� ������ ��ȣ ����

	/**
	 * ���ϰ�θ� �޾� ������ ��ο� �̸��� ���� 
	 * <br> AUDIO_LIST, NAME_LIST ���Ϳ� �߰������ִ� �޼ҵ��Դϴ�.
	 * @param filepath ���� ������ ������ ������ ���
	 * @author jihun
	 */
	public static void add(String filepath) {
		String[] splitedPath = filepath.split("\\\\");
		String name = splitedPath[splitedPath.length - 1];

		String[] splitedName = name.split("\\.");
		if(!(splitedName[splitedName.length - 1].equals("wav")) && !(splitedName[splitedName.length - 1].equals("mp3"))) {
			JOptionPane.showMessageDialog(null, "�������� �ʴ� ���� �����Դϴ�..", 
					"���", JOptionPane.WARNING_MESSAGE);
			return;
		}

		//AUDIO_LIST�� ���ο� ���� ���� ��� �߰�
		AUDIO_LIST.add(filepath);   
		NAME_LIST.add(name);
		//���� ������ ��θ� '/'�� ���� �������� ��ġ�� ���� �̸��� NAME_LIST�� ����ִ´�. 

		//������ �߰������Ƿ� ���ο� JList(playList)�� ����� MainFrame���� �����ش�.
		playList = new JList<Object>(NAME_LIST);
		JListHandler handler = new JListHandler();
		playList.addListSelectionListener(handler);
		playList.setFocusable(false);
		MainFrame.updateList(playList);
	}

	/**
	 * ���� ��� ����, Ȥ�� ����� ������ ��ȣ�� �����մϴ�.
	 * @return playNo
	 * @author jihun, changhee
	 */
	public static int getplayNo() {
		return playNo;
	}

	/**
	 * ����Ʈ�� �����ϴ� ���������� �ε��� ��ȣ�� �����մϴ�.
	 * @param playNo ����Ʈ�� �����۵��� ���� �ε��� ��ȣ�Դϴ�. �����Ŀ� �����ϰ� ���˴ϴ�.
	 * @author jihun, changhee
	 */
	public static void setplayNo(int playNo) {
		PlayList.playNo = playNo;
	}

	/**
	 * ������� ������ ���� ������ ����մϴ�.
	 * <br>������� ������ ����Ʈ�� �������̸� ó�� ������ ����մϴ�.
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
	 * ������� ������ ���� ������ ����մϴ�.
	 * <br>������� ������ ����Ʈ�� ó���̸� ������ ������ ����մϴ�.
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
	 * �������� ��ΰ� ����ִ� ����(AUDIO_LIST)�� ũ�⸦ �����մϴ�.
	 * @return AUDIO_LIST.size()
	 * @author jihun, changhee
	 */
	public static int getListSize() {
		return AUDIO_LIST.size();
	}

	/**
	 * ���� ����� ���� ��θ� �����մϴ�.
	 * @return AUDIO_LIST.get(playNo)
	 * @author jihun, changhee
	 */
	public static String getPath() {
		return AUDIO_LIST.get(playNo);
	}

	/**
	 * PlayList�� ������ ������ �� �ֵ��� ����� ��鷯�Դϴ�.
	 * @author jihun
	 */
	public static class JListHandler implements ListSelectionListener
	{
		/**
		 * ����Ʈ�� �׸��� ������ �Ǹ�
		 * <br>playNo(��������� ��ȣ)�� ���õ� �׸��� ��ȣ�� �ٲߴϴ�.
		 */
		public void valueChanged(ListSelectionEvent arg0) {
			// getContentPane(): GUI ������Ʈ�� ������ ��ȯ
			// setBackground(): ������Ʈ�� ����� ����
			// getSelectedIndex(): ���õ� �׸��� �ε��� ��ȯ
			playNo = playList.getSelectedIndex();
		}
	}
}