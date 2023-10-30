import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * GUI�� ������ �� �� �ִ� Ŭ������ ������ ���� ����� �մϴ�.
 * <br>1. �⺻�����δ� ������Ʈ���� ��ġ�� ���� Ŭ�����Դϴ�.
 * 
 * <br>2. ���� ���� ����̳� ����Ʈ ����� ���� ������ ��ɵ��� ���� ���� �ӽ� �̳� Ŭ������ ����ϰų�
 * <br>������ Ŭ������ ����� add() �Ͽ� ����ϰ� �ֽ��ϴ�.
 * 
 * <br>3. ����Ű ����� ���� �̳�Ŭ������ �����մϴ�. 
 * 
 * <br>4. ������ �ٲ��ִ� �ڵ鷯�� �̳� Ŭ������ ���� �ֽ��ϴ�.
 * 
 * <br>5. ������Ʈ���� �׽� �ֽŻ��·� ������Ʈ ���ִ� �޼ҵ带 ������ �ֽ��ϴ�. 
 * 
 * @author team3
 * @version 1.0.0
 * @since JDK 1.6
 */
public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	// ������Ʈ 
	private static JTextField 			musicName_T;
	private static JTextField 			singerName_T;
	private static JSlider 				volumeSlider;
	private static JSlider 				timeSlider;
	private static JScrollPane			scrollPlayList;
	private static JScrollPane 			scrollLyric;
	private static JLabel 				runningTimeLabel;
	private static JLabel				currentTimeLabel;
	private static JButton				btnPlayPause;
	private static JButton				btnPlayType;
	// ���� ������� Ŭ���� ������ �����մϴ�.
	public static float 				VOLUME;				
	
	

	/**
	 * ȭ�鿡 ���� ������Ʈ�� ǥ���ϰ� ����ڿ� ��ȣ�ۿ� �մϴ�.
	 * 
	 * @throws IOException ����� ����
	 * @throws UnsupportedAudioFileException wav, mp3 �� ��������, �� �ܿ��� ��� ���� ó��
	 * @throws LineUnavailableException �ƹ��� ����� ������ �ö�� ���� ���� ���¿��� ���� ����� �ϸ� ���� ó��
	 */
	public MainFrame() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		/* ���ҽ� */ 
		final URL icon_image = this.getClass().getResource("images/icon.gif");
		final URL volume_image = this.getClass().getResource("images/volume.gif");
		final URL list_image = this.getClass().getResource("images/list.gif");
		final URL prev_image = this.getClass().getResource("images/prev.gif");
		final URL next_image = this.getClass().getResource("images/next.gif");
		final URL open_image = this.getClass().getResource("images/open.gif");
		final URL play_image = this.getClass().getResource("images/play.gif");
		final URL stop_image = this.getClass().getResource("images/stop.gif");
		final URL streight_image = this.getClass().getResource("images/streight.gif");
		final URL skin_image = this.getClass().getResource("images/skin.gif");
		
		// 0. (Frame) ������ ����
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(icon_image));
		setResizable(false);	// ������ ũ�� ����
		setTitle("Music Player");
		setSize(450,720);
		setVisible(true);

		// ����Ű�� ����� �� ���� �������� ��Ŀ���� ���� �ʵ��� ������ �մϴ�. 
		requestFocus();
		addKeyListener(new HotKey());		
		getContentPane().setLayout(null);		// ���̾ƿ� �����ڴ� ������ǥ�� ����մϴ�.

		// <--������Ʈ ����-->
		/*�±�*/	
		// 1-1. (Label_Text) ���
		JLabel musicName_L = new JLabel("����");
		musicName_L.setBounds(18, 21, 28, 18);
		musicName_L.setFocusable(false);
		getContentPane().add(musicName_L);

		// 1-2. (Label_Text) ������
		JLabel singerName_L = new JLabel("����");
		singerName_L.setBounds(280, 21, 28, 18);
		singerName_L.setFocusable(false);
		getContentPane().add(singerName_L);

		// 1-3. (TextField) ���
		musicName_T = new JTextField();
		musicName_T.setBounds(56, 18, 205, 24); 
		musicName_T.setEditable(false);			// ���� �Ұ�
		musicName_T.setFocusable(false);
		getContentPane().add(musicName_T);
		musicName_T.setColumns(10);				// ǥ���� ���ڿ��� ����

		// 1-4. (TextField) ������
		singerName_T = new JTextField();
		singerName_T.setBounds(319, 18, 106, 24);
		singerName_T.setEditable(false);
		singerName_T.setFocusable(false);
		getContentPane().add(singerName_T);
		singerName_T.setColumns(10);


		/*�����̴�*/		
		// 2. (Slider_H) Ÿ�� �����̴�
		timeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
		timeSlider.setBackground(null);
		timeSlider.setBounds(57, 78, 301, 23);
		timeSlider.addChangeListener(new EventtimeSlider());
		timeSlider.setFocusable(false);
		timeSlider.setValue(0);
		getContentPane().add(timeSlider);

		/*����ð�*/
		// 3-1. (Label) ����� �ð� 
		currentTimeLabel = new JLabel("00:00");
		currentTimeLabel.setBounds(261, 106, 37, 18);
		currentTimeLabel.setFocusable(false);
		getContentPane().add(currentTimeLabel);

		// 3-2. (Label) �� ��� �ð�
		runningTimeLabel = new JLabel("/ 00:00");
		runningTimeLabel.setBounds(303, 106, 48, 18);
		runningTimeLabel.setFocusable(false);
		getContentPane().add(runningTimeLabel);

		/*���� �����̴� �� ������*/
		// 4-1. (Slider) ���� �����̴�
		volumeSlider = new JSlider(JSlider.VERTICAL, -40, 6, 6);
		volumeSlider.setBackground(null);
		volumeSlider.setBounds(420, 49, 10, 82);
		volumeSlider.addChangeListener(new EventvolumeSlider());
		volumeSlider.setFocusable(false);
		getContentPane().add(volumeSlider);

		// 4-2. (Label_Image) ���� �̹���
		JLabel volumeLabel = new JLabel();
		volumeLabel.setIcon(new ImageIcon(volume_image));
		volumeLabel.setBounds(364, 67, 45, 45);
		volumeLabel.setFocusable(false);
		getContentPane().add(volumeLabel);

		// <--������� ��ư��--> 

		// 5-1. (Button) ���
		btnPlayPause = new JButton();
		btnPlayPause.setIcon(new ImageIcon(play_image));
		btnPlayPause.setBounds(197, 144, 50, 50);
		btnPlayPause.addActionListener(new EventbtnPlayPause());

		btnPlayPause.setFocusable(false);
		btnPlayPause.setBackground(null);
		getContentPane().add(btnPlayPause);

		// 5-2. (Button) ���� ����
		JButton btnPrevious = new JButton();
		btnPrevious.setIcon(new ImageIcon(prev_image));
		btnPrevious.setBounds(139, 144, 50, 50);
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				PlayList.prevFile();
				PlayAction.stop();
				PlayAction.start();
			}
		});
		btnPrevious.setFocusable(false);
		btnPrevious.setBackground(null);
		getContentPane().add(btnPrevious);

		// 5-3. (Button) ���� ����
		JButton btnNext = new JButton();
		btnNext.setIcon(new ImageIcon(next_image));
		btnNext.setBounds(255, 144, 50, 50);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				PlayList.nextFile();
				PlayAction.stop();
				PlayAction.start();
			}
		});
		btnNext.setFocusable(false);
		btnNext.setBackground(null);
		getContentPane().add(btnNext);

		// 5-4. (Button) ����
		JButton btnStop = new JButton();
		btnStop.setIcon(new ImageIcon(stop_image));
		btnStop.setBounds(82, 144, 50, 50);
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				PlayAction.stop();
				btnPlayPause.setIcon(new ImageIcon(play_image));	//��ư �̹����� �Ͻ��������� ������� �ٲ�
			}
		});
		btnStop.setFocusable(false);
		btnStop.setBackground(null);
		getContentPane().add(btnStop);

		// 5-5. (Button) ���� ����
		JButton btnOpen = new JButton();
		btnOpen.setIcon(new ImageIcon(open_image));
		btnOpen.setBounds(26, 144, 50, 50);
		btnOpen.addActionListener(new OpenAction());
		btnOpen.setFocusable(false);
		btnOpen.setBackground(null);
		getContentPane().add(btnOpen);

		/*��� ���*/	
		// 5-6. (Button) ��� ���
		btnPlayType = new JButton();
		btnPlayType.setIcon(new ImageIcon(streight_image));
		btnPlayType.setBounds(313, 144, 50, 50);
		btnPlayType.addActionListener(new EventbtnPlayType());
		btnPlayType.setFocusable(false);
		btnPlayType.setBackground(null);
		getContentPane().add(btnPlayType);

		// 5-7. (Button) ��Ų ����
		JButton btnSkin = new JButton();
		btnSkin.setIcon(new ImageIcon(skin_image));
		btnSkin.setBounds(373, 144, 50, 50);
		btnSkin.setFocusable(false);
		btnSkin.setBackground(null);
		btnSkin.addActionListener(new ColorAction());
		getContentPane().add(btnSkin);

		//<--����â-->		

		// 6. (scrollPane) ����â + ��ũ�� ����
		scrollLyric = new JScrollPane();
		scrollLyric.setBounds(30, 215, 389, 149);
		scrollLyric.setFocusable(false);
		JTextArea defaultText = new JTextArea("������ ����ϸ� ���簡 ǥ�õ˴ϴ�.");
		defaultText.setEditable(false);
		defaultText.setFocusable(false);
		scrollLyric.setViewportView(defaultText);
		getContentPane().add(scrollLyric);

		//<--�÷��� ����Ʈ-->	

		// 7-1. (ScrollPane) �÷��� ����Ʈ ��ũ�� â
		scrollPlayList = new JScrollPane();
		scrollPlayList.setBounds(20, 400, 406, 270);
		scrollPlayList.setFocusable(false);
		JList<?> defaultList = new JList<Object>();
		defaultList.setFocusable(false);
		scrollPlayList.setViewportView(defaultList);
		getContentPane().add(scrollPlayList);

		// 7-2. (Label_Text & Image) �÷��� ����Ʈ ������
		JLabel labelPlayList = new JLabel("Play List");
		labelPlayList.setIcon(new ImageIcon(list_image));
		labelPlayList.setBounds(20, 370, 120, 25);
		labelPlayList.setFocusable(false);
		getContentPane().add(labelPlayList);

		// ����� ������ ����
		repaint();	
	}

	// <--�̳� Ŭ����-->	

	/**
	 * ����ڰ� timeSlider�� �����̸� �׿� ���缭 Clip�� position�� �����ϴ� Ŭ�����Դϴ�.
	 * @author jihun
	 */
	class EventtimeSlider implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider)e.getSource();  
			if (source.getValueIsAdjusting()) {
				long position = source.getValue();  
				PlayAction.pause();
				PlayAction.changePosition(position);
				PlayAction.restart();
			}
		}
	}

	/**
	 * ����ڰ� volumeSlider�� �����̸� �׿� ���缭 Clip�� volume�� �����ϴ� Ŭ�����Դϴ�.
	 * @author yunki
	 */
	class EventvolumeSlider implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			VOLUME = (float)volumeSlider.getValue();	// �����̴� ��갪 ��������

			// ���� ������� ���������� ������ �����մϴ�. ( gainControl �� ��ü���� ����Դϴ�. )
			try {
				FloatControl gainControl = 
						(FloatControl) PlayAction.CLIP.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue( VOLUME );			// ���� ��갪�� ������ ������ �����մϴ�.

			} catch( Exception ee ) {
				return;
			}
		}
	}

	/**
	 * ����ڰ� btnPlayPause�� ������ playstate�� ������ ����� ����ϴ� Ŭ�����Դϴ�. 
	 * @author jihun
	 */
	class EventbtnPlayPause implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			final URL play_image = this.getClass().getResource("images/play.gif");
			final URL pause_image = this.getClass().getResource("images/pause.gif");
			if(PlayAction.playState.equals(PlayAction.State.STOP)) {
				//STOP -> PLAY : ������ ó�� ���, ��ư �̹��� play->pause
				if (PlayList.getListSize() == 0) {
					OpenAction open = new OpenAction();
					open.actionPerformed(null);
				}
				else {
					PlayAction.start(); 
					btnPlayPause.setIcon(new ImageIcon(pause_image));
				}
			}
			else if(PlayAction.playState.equals(PlayAction.State.PLAY)){
				//PLAY -> PAUSE : ����Ǵ� ���¿��� �Ͻ�������Ŵ, ��ư �̹��� pause->play
				PlayAction.pause();
				btnPlayPause.setIcon(new ImageIcon(play_image));
			}
			else if(PlayAction.playState.equals(PlayAction.State.PAUSE)){
				//PAUSE -> PLAY : �Ͻ����� ���¿��� �ٽ� �����Ŵ, ��ư �̹��� play->pause
				PlayAction.restart();
				btnPlayPause.setIcon(new ImageIcon(pause_image));
			}
		}
	}
	
	/**
	 * ����ڰ� btnPlayType�� ������ playOrder�� �ٲٴ� Ŭ�����Դϴ�. 
	 * @author jihun
	 */
	class EventbtnPlayType implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			final URL replay_image = this.getClass().getResource("images/replay.gif");
			final URL random_image = this.getClass().getResource("images/random.gif");
			final URL streight_image = this.getClass().getResource("images/streight.gif");
			if(NextPlay.playOrder.equals(NextPlay.Order.STRAIGHT)) {
				//STRAIGHT -> RANDOM : ����Ʈ �� ������ ���Ƿ� ����, ��ư �̹��� straight->random
				btnPlayType.setIcon(new ImageIcon(random_image));
				NextPlay.playOrder = NextPlay.Order.RANDOM;
			}
			else if(NextPlay.playOrder.equals(NextPlay.Order.RANDOM)) {
				//RANDOM -> REPLAY : ���� ��� ���� ������ �ٽ� ���, ��ư �̹��� random->replay
				btnPlayType.setIcon(new ImageIcon(replay_image));
				NextPlay.playOrder = NextPlay.Order.REPLAY;
			}
			else if(NextPlay.playOrder.equals(NextPlay.Order.REPLAY)) {
				//REPLAY -> STRAIGHT : ������ ����Ʈ ������� ���, ��ư �̹��� replay->straight
				btnPlayType.setIcon(new ImageIcon(streight_image));
				NextPlay.playOrder = NextPlay.Order.STRAIGHT;
			}
		}
	}
	
	/**
	 * ����Ű ����� ����ϴ� Ŭ�����Դϴ�.
	 * <br>O : ���� ���� ���̾�α� ����
	 * <br>s : ����
	 * <br>SPACE BAR: ��� �� �Ͻ�����
	 * <br>C : ��Ų����â ����
	 * @author jihun, yunki
	 */
	class HotKey extends KeyAdapter {
		/**
		 * ������ ������ �����ΰ� �Ǵ��Ͽ� �׿� �´� ����� �����Ѵ�.
		 */
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch(keyCode){
			case KeyEvent.VK_O:   				//����
				OpenAction o = new OpenAction();
				o.actionPerformed(null);
				break;
			case KeyEvent.VK_S:   				//����
				PlayAction.stop();	
				break;
			case KeyEvent.VK_SPACE:  			//���
				if ( PlayAction.playState.equals(PlayAction.State.PLAY) ) PlayAction.pause();
				else if ( PlayAction.playState.equals(PlayAction.State.PAUSE) ) PlayAction.restart();
				else PlayAction.start(); 
				break;
			case KeyEvent.VK_C:  			 	//��Ų
				ColorAction c = new ColorAction();
				c.actionPerformed(null);
				break;
			}
		}
	}


	/**
	 * JColorChooser�� �̿��Ͽ� ����ڰ� ������ ���� ������ ������ �ٲߴϴ�.
	 * @author jihun
	 */
	class ColorAction implements ActionListener {
		/**
		 * JColorChooser�� �̿��Ͽ� ����ڷκ��� Color ��ü�� �ް� �ش���� �������� �մϴ�.
		 */
		public void actionPerformed(ActionEvent e) {
			// ����ڰ� ������ ���� �����Ѵ�.
			Color selectedColor = JColorChooser.showDialog(null,"Background",null);
			if(selectedColor != null) {	// ����ڰ� ���� ����������
				getContentPane().setBackground(selectedColor);
			}
		}
	}

	//<--������Ʈ ������Ʈ �޼ҵ�-->

	/**
	 * ������ �߰��� ������ 
	 * <br>PlayList�� add() �޼ҵ忡�� ���ο� List(playList)�� �޾� 
	 * <br>scrollPlayList�� ������Ʈ �մϴ�.
	 * @param playList ����� �н��� ����Ǿ� �ִ� ����
	 * @author jihun, changhee
	 */
	public static void updateList(JList<?> playList) {
		scrollPlayList.setViewportView(playList);
		scrollPlayList.setFocusable(false);
	}

	/**
	 * ������ ����� ������ 
	 * <br>LyricMaker�� makeLyric �޼ҵ忡�� ���ο� JTextArea(lyricText)�� �޾� 
	 * <br>scrollLyric�� ������Ʈ�մϴ�.
	 * @param lyricText ���系��
	 * @author jihun, changhee
	 */
	public static void updateLyric(JTextArea lyricText) {
		lyricText.setFocusable(false);
		scrollLyric.setViewportView(lyricText);
		scrollLyric.setFocusable(false);
	}

	/**
	 * ���� ������� ������ �����ġ��(long currentTime) �޾� currentTimeLabel�� ���������� ǥ���մϴ�.
	 * @param currentTime ���� ������� �ð�
	 * @author jihun, changhee
	 */
	public static void updatecurrentTime(long currentTime) {
		int min = (int) (currentTime) / 1000 / 1000 / 60;
		int sec = (int) (currentTime) / 1000 / 1000 % 60;
		String time = "";
		if(min < 10) {
			time = "0" + min + ":";
		}
		else {
			time = min + ":";
		}
		if(sec < 10) {
			time = time + "0" + sec;
		}
		else {
			time = time + sec + "";
		}
		currentTimeLabel.setText(time);
		currentTimeLabel.setFocusable(false);
	}

	/**
	 * ������ ����� ������ PlayAction�� play �޼ҵ忡�� ����Ǵ� ������ ��ü �ð���(long runninTime) �޾�
	 * <br> runningTimeLabel�� ���������� ������Ʈ ���ݴϴ�.
	 * @param runningTime ���� ������� ���� ������ �� ����
	 * @author jihun, changhee
	 */
	public static void updaterunningTime(long runningTime) {
		int min = (int) (runningTime) / 1000 / 1000 / 60;
		int sec = (int) (runningTime) / 1000 / 1000 % 60;
		String time = "";
		if(min < 10) {
			time = "/ 0" + min + ":";
		}
		else {
			time = "/ " + min + ":";
		}
		if(sec < 10) {
			time = time + "0" + sec;
		}
		else {
			time = time + sec + "";
		}
		runningTimeLabel.setText(time);
		runningTimeLabel.setFocusable(false);
	}

	/**
	 * ����� ������ �� ���̿� �°� �����̴� ��갡 ������ �� �ִ� �ִ� ���̸� �����մϴ�.
	 * @param runningTime ���� ������� ���� ������ �� ����
	 * @author jihun
	 */
	public static void initializeSlider(long runningTime){
		timeSlider.setMinimum(0);
		timeSlider.setMaximum((int) runningTime);
	}

	/**
	 * PlayAction(.java)�� ������κ��� 1�ʸ��� currentTime�� �޾� 
	 * <br> �׿� �°� �����̵带 �����Դϴ�.
	 * @param currentTime ���� ������� ������ �ð�
	 * @author jihun
	 */
	public static void updateSlider(long currentTime) {
		timeSlider.setValue((int) currentTime);
	}

	/**
	 * PlayAction Ŭ������ getTags()���� �±׸� �޾� ȭ�鿡 ǥ���մϴ�.
	 * @param title ���� �±�
	 * @param artist ������ �±�
	 * @author changhee
	 */
	public static void updateTag(String title, String artist) {
		musicName_T.setText(title);
		singerName_T.setText(artist);
	}
	
	//<--���� �޼ҵ�-->

	/**
	 * GUI ������(MainFrame)�� �����մϴ�.
	 * 
	 * @author team3
	 * 
	 * @param args �������� ��� �� �մϴ�.
	 * 
	 * @throws IOException ����� �ͼ���
	 * @throws UnsupportedAudioFileException mp3, wav �̿��� Ȯ���ڴ� ���� ó���մϴ�.
	 * @throws LineUnavailableException ���ο� ������ �ϳ��� �� �ö�� ������ ���ܸ� �߻���ŵ�ϴ�.
	 */
	public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		new MainFrame();			  // ������ ����

		// �÷��� �������� ����� ��������, �������� ��쿣 ������ ������� �����ɴϴ�.
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}