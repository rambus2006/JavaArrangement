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
 * GUI의 뼈대라고 할 수 있는 클래스로 다음과 같은 기능을 합니다.
 * <br>1. 기본적으로는 컴포넌트들의 배치를 돕는 클래스입니다.
 * 
 * <br>2. 음악 파일 재생이나 리스트 변경과 같은 복잡한 기능들은 따로 어노니 머스 이너 클래스를 사용하거나
 * <br>별도의 클래스를 만들어 add() 하여 사용하고 있습니다.
 * 
 * <br>3. 단축키 기능을 갖는 이너클래스가 존재합니다. 
 * 
 * <br>4. 배경색을 바꿔주는 핸들러를 이너 클래스로 갖고 있습니다.
 * 
 * <br>5. 컴포넌트들을 항시 최신상태로 업데이트 해주는 메소드를 가지고 있습니다. 
 * 
 * @author team3
 * @version 1.0.0
 * @since JDK 1.6
 */
public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	// 컴포넌트 
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
	// 현재 재생중인 클립의 볼륨을 저장합니다.
	public static float 				VOLUME;				
	
	

	/**
	 * 화면에 여러 컴포넌트를 표시하고 사용자와 상호작용 합니다.
	 * 
	 * @throws IOException 입출력 예외
	 * @throws UnsupportedAudioFileException wav, mp3 만 지원가능, 그 외에는 모두 예외 처리
	 * @throws LineUnavailableException 아무런 오디오 파일이 올라와 있지 않은 상태에서 음악 재생을 하면 예외 처리
	 */
	public MainFrame() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		/* 리소스 */ 
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
		
		// 0. (Frame) 프레임 셋팅
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(icon_image));
		setResizable(false);	// 프레임 크기 고정
		setTitle("Music Player");
		setSize(450,720);
		setVisible(true);

		// 단축키를 사용할 때 메인 프레임이 포커싱을 잃지 않도록 만들어야 합니다. 
		requestFocus();
		addKeyListener(new HotKey());		
		getContentPane().setLayout(null);		// 레이아웃 관리자는 절대좌표를 사용합니다.

		// <--컴포넌트 시작-->
		/*태그*/	
		// 1-1. (Label_Text) 곡명
		JLabel musicName_L = new JLabel("제목");
		musicName_L.setBounds(18, 21, 28, 18);
		musicName_L.setFocusable(false);
		getContentPane().add(musicName_L);

		// 1-2. (Label_Text) 가수명
		JLabel singerName_L = new JLabel("가수");
		singerName_L.setBounds(280, 21, 28, 18);
		singerName_L.setFocusable(false);
		getContentPane().add(singerName_L);

		// 1-3. (TextField) 곡명
		musicName_T = new JTextField();
		musicName_T.setBounds(56, 18, 205, 24); 
		musicName_T.setEditable(false);			// 수정 불가
		musicName_T.setFocusable(false);
		getContentPane().add(musicName_T);
		musicName_T.setColumns(10);				// 표시할 문자열의 길이

		// 1-4. (TextField) 가수명
		singerName_T = new JTextField();
		singerName_T.setBounds(319, 18, 106, 24);
		singerName_T.setEditable(false);
		singerName_T.setFocusable(false);
		getContentPane().add(singerName_T);
		singerName_T.setColumns(10);


		/*슬라이더*/		
		// 2. (Slider_H) 타임 슬라이더
		timeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
		timeSlider.setBackground(null);
		timeSlider.setBounds(57, 78, 301, 23);
		timeSlider.addChangeListener(new EventtimeSlider());
		timeSlider.setFocusable(false);
		timeSlider.setValue(0);
		getContentPane().add(timeSlider);

		/*재생시간*/
		// 3-1. (Label) 재생한 시간 
		currentTimeLabel = new JLabel("00:00");
		currentTimeLabel.setBounds(261, 106, 37, 18);
		currentTimeLabel.setFocusable(false);
		getContentPane().add(currentTimeLabel);

		// 3-2. (Label) 총 재생 시간
		runningTimeLabel = new JLabel("/ 00:00");
		runningTimeLabel.setBounds(303, 106, 48, 18);
		runningTimeLabel.setFocusable(false);
		getContentPane().add(runningTimeLabel);

		/*볼륨 슬라이더 및 아이콘*/
		// 4-1. (Slider) 볼륨 슬라이더
		volumeSlider = new JSlider(JSlider.VERTICAL, -40, 6, 6);
		volumeSlider.setBackground(null);
		volumeSlider.setBounds(420, 49, 10, 82);
		volumeSlider.addChangeListener(new EventvolumeSlider());
		volumeSlider.setFocusable(false);
		getContentPane().add(volumeSlider);

		// 4-2. (Label_Image) 볼륨 이미지
		JLabel volumeLabel = new JLabel();
		volumeLabel.setIcon(new ImageIcon(volume_image));
		volumeLabel.setBounds(364, 67, 45, 45);
		volumeLabel.setFocusable(false);
		getContentPane().add(volumeLabel);

		// <--재생관련 버튼들--> 

		// 5-1. (Button) 재생
		btnPlayPause = new JButton();
		btnPlayPause.setIcon(new ImageIcon(play_image));
		btnPlayPause.setBounds(197, 144, 50, 50);
		btnPlayPause.addActionListener(new EventbtnPlayPause());

		btnPlayPause.setFocusable(false);
		btnPlayPause.setBackground(null);
		getContentPane().add(btnPlayPause);

		// 5-2. (Button) 이전 파일
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

		// 5-3. (Button) 다음 파일
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

		// 5-4. (Button) 정지
		JButton btnStop = new JButton();
		btnStop.setIcon(new ImageIcon(stop_image));
		btnStop.setBounds(82, 144, 50, 50);
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				PlayAction.stop();
				btnPlayPause.setIcon(new ImageIcon(play_image));	//버튼 이미지을 일시정지에서 재생으로 바꿈
			}
		});
		btnStop.setFocusable(false);
		btnStop.setBackground(null);
		getContentPane().add(btnStop);

		// 5-5. (Button) 파일 열기
		JButton btnOpen = new JButton();
		btnOpen.setIcon(new ImageIcon(open_image));
		btnOpen.setBounds(26, 144, 50, 50);
		btnOpen.addActionListener(new OpenAction());
		btnOpen.setFocusable(false);
		btnOpen.setBackground(null);
		getContentPane().add(btnOpen);

		/*재생 방식*/	
		// 5-6. (Button) 재생 방식
		btnPlayType = new JButton();
		btnPlayType.setIcon(new ImageIcon(streight_image));
		btnPlayType.setBounds(313, 144, 50, 50);
		btnPlayType.addActionListener(new EventbtnPlayType());
		btnPlayType.setFocusable(false);
		btnPlayType.setBackground(null);
		getContentPane().add(btnPlayType);

		// 5-7. (Button) 스킨 선택
		JButton btnSkin = new JButton();
		btnSkin.setIcon(new ImageIcon(skin_image));
		btnSkin.setBounds(373, 144, 50, 50);
		btnSkin.setFocusable(false);
		btnSkin.setBackground(null);
		btnSkin.addActionListener(new ColorAction());
		getContentPane().add(btnSkin);

		//<--가사창-->		

		// 6. (scrollPane) 가사창 + 스크롤 패인
		scrollLyric = new JScrollPane();
		scrollLyric.setBounds(30, 215, 389, 149);
		scrollLyric.setFocusable(false);
		JTextArea defaultText = new JTextArea("파일을 재생하면 가사가 표시됩니다.");
		defaultText.setEditable(false);
		defaultText.setFocusable(false);
		scrollLyric.setViewportView(defaultText);
		getContentPane().add(scrollLyric);

		//<--플레이 리스트-->	

		// 7-1. (ScrollPane) 플레이 리스트 스크롤 창
		scrollPlayList = new JScrollPane();
		scrollPlayList.setBounds(20, 400, 406, 270);
		scrollPlayList.setFocusable(false);
		JList<?> defaultList = new JList<Object>();
		defaultList.setFocusable(false);
		scrollPlayList.setViewportView(defaultList);
		getContentPane().add(scrollPlayList);

		// 7-2. (Label_Text & Image) 플레이 리스트 아이콘
		JLabel labelPlayList = new JLabel("Play List");
		labelPlayList.setIcon(new ImageIcon(list_image));
		labelPlayList.setBounds(20, 370, 120, 25);
		labelPlayList.setFocusable(false);
		getContentPane().add(labelPlayList);

		// 대망의 랜더링 시작
		repaint();	
	}

	// <--이너 클래스-->	

	/**
	 * 사용자가 timeSlider을 움직이면 그에 맞춰서 Clip의 position을 변경하는 클래스입니다.
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
	 * 사용자가 volumeSlider을 움직이면 그에 맞춰서 Clip의 volume을 변경하는 클래스입니다.
	 * @author yunki
	 */
	class EventvolumeSlider implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			VOLUME = (float)volumeSlider.getValue();	// 슬라이더 노브값 가져오기

			// 현재 재생중인 음악파일의 볼륨을 설정합니다. ( gainControl 은 전체볼륨 상수입니다. )
			try {
				FloatControl gainControl = 
						(FloatControl) PlayAction.CLIP.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue( VOLUME );			// 얻어온 노브값을 가지고 볼륨을 변경합니다.

			} catch( Exception ee ) {
				return;
			}
		}
	}

	/**
	 * 사용자가 btnPlayPause을 누르면 playstate에 적합한 기능을 명령하는 클래스입니다. 
	 * @author jihun
	 */
	class EventbtnPlayPause implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			final URL play_image = this.getClass().getResource("images/play.gif");
			final URL pause_image = this.getClass().getResource("images/pause.gif");
			if(PlayAction.playState.equals(PlayAction.State.STOP)) {
				//STOP -> PLAY : 음악을 처음 재생, 버튼 이미지 play->pause
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
				//PLAY -> PAUSE : 재생되는 상태에서 일시정지시킴, 버튼 이미지 pause->play
				PlayAction.pause();
				btnPlayPause.setIcon(new ImageIcon(play_image));
			}
			else if(PlayAction.playState.equals(PlayAction.State.PAUSE)){
				//PAUSE -> PLAY : 일시정지 상태에서 다시 재생시킴, 버튼 이미지 play->pause
				PlayAction.restart();
				btnPlayPause.setIcon(new ImageIcon(pause_image));
			}
		}
	}
	
	/**
	 * 사용자가 btnPlayType을 누르면 playOrder을 바꾸는 클래스입니다. 
	 * @author jihun
	 */
	class EventbtnPlayType implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			final URL replay_image = this.getClass().getResource("images/replay.gif");
			final URL random_image = this.getClass().getResource("images/random.gif");
			final URL streight_image = this.getClass().getResource("images/streight.gif");
			if(NextPlay.playOrder.equals(NextPlay.Order.STRAIGHT)) {
				//STRAIGHT -> RANDOM : 리스트 안 파일을 임의로 선택, 버튼 이미지 straight->random
				btnPlayType.setIcon(new ImageIcon(random_image));
				NextPlay.playOrder = NextPlay.Order.RANDOM;
			}
			else if(NextPlay.playOrder.equals(NextPlay.Order.RANDOM)) {
				//RANDOM -> REPLAY : 지금 재생 중인 음악을 다시 재생, 버튼 이미지 random->replay
				btnPlayType.setIcon(new ImageIcon(replay_image));
				NextPlay.playOrder = NextPlay.Order.REPLAY;
			}
			else if(NextPlay.playOrder.equals(NextPlay.Order.REPLAY)) {
				//REPLAY -> STRAIGHT : 음악을 리스트 순서대로 재생, 버튼 이미지 replay->straight
				btnPlayType.setIcon(new ImageIcon(streight_image));
				NextPlay.playOrder = NextPlay.Order.STRAIGHT;
			}
		}
	}
	
	/**
	 * 단축키 기능을 담당하는 클래스입니다.
	 * <br>O : 파일 추저 다이얼로그 열기
	 * <br>s : 정지
	 * <br>SPACE BAR: 재생 및 일시정지
	 * <br>C : 스킨선택창 열기
	 * @author jihun, yunki
	 */
	class HotKey extends KeyAdapter {
		/**
		 * 눌러진 자판이 무엇인가 판단하여 그에 맞는 기능을 수행한다.
		 */
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch(keyCode){
			case KeyEvent.VK_O:   				//열기
				OpenAction o = new OpenAction();
				o.actionPerformed(null);
				break;
			case KeyEvent.VK_S:   				//정지
				PlayAction.stop();	
				break;
			case KeyEvent.VK_SPACE:  			//재생
				if ( PlayAction.playState.equals(PlayAction.State.PLAY) ) PlayAction.pause();
				else if ( PlayAction.playState.equals(PlayAction.State.PAUSE) ) PlayAction.restart();
				else PlayAction.start(); 
				break;
			case KeyEvent.VK_C:  			 	//스킨
				ColorAction c = new ColorAction();
				c.actionPerformed(null);
				break;
			}
		}
	}


	/**
	 * JColorChooser를 이용하여 사용자가 선택한 색을 가지고 배경색을 바꿉니다.
	 * @author jihun
	 */
	class ColorAction implements ActionListener {
		/**
		 * JColorChooser를 이용하여 사용자로부터 Color 객체를 받고 해당색을 배경색으로 합니다.
		 */
		public void actionPerformed(ActionEvent e) {
			// 사용자가 선택한 색을 리턴한다.
			Color selectedColor = JColorChooser.showDialog(null,"Background",null);
			if(selectedColor != null) {	// 사용자가 색을 선택했으면
				getContentPane().setBackground(selectedColor);
			}
		}
	}

	//<--컴포넌트 업데이트 메소드-->

	/**
	 * 파일을 추가할 때마다 
	 * <br>PlayList의 add() 메소드에서 새로운 List(playList)를 받아 
	 * <br>scrollPlayList를 업데이트 합니다.
	 * @param playList 오디오 패스가 저장되어 있는 벡터
	 * @author jihun, changhee
	 */
	public static void updateList(JList<?> playList) {
		scrollPlayList.setViewportView(playList);
		scrollPlayList.setFocusable(false);
	}

	/**
	 * 파일이 재생될 때마다 
	 * <br>LyricMaker의 makeLyric 메소드에서 새로운 JTextArea(lyricText)를 받아 
	 * <br>scrollLyric을 업데이트합니다.
	 * @param lyricText 가사내용
	 * @author jihun, changhee
	 */
	public static void updateLyric(JTextArea lyricText) {
		lyricText.setFocusable(false);
		scrollLyric.setViewportView(lyricText);
		scrollLyric.setFocusable(false);
	}

	/**
	 * 현재 재생중인 음악의 재생위치를(long currentTime) 받아 currentTimeLabel에 지속적으로 표시합니다.
	 * @param currentTime 현재 재생중인 시각
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
	 * 파일이 재생될 때마다 PlayAction의 play 메소드에서 재생되는 음악의 전체 시간을(long runninTime) 받아
	 * <br> runningTimeLabel에 지속적으로 업데이트 해줍니다.
	 * @param runningTime 현재 재생중인 음악 파일의 총 길이
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
	 * 재생될 음악의 총 길이에 맞게 슬라이더 노브가 움직일 수 있는 최대 길이를 설정합니다.
	 * @param runningTime 현재 재생중인 음악 파일의 총 길이
	 * @author jihun
	 */
	public static void initializeSlider(long runningTime){
		timeSlider.setMinimum(0);
		timeSlider.setMaximum((int) runningTime);
	}

	/**
	 * PlayAction(.java)의 스레드로부터 1초마다 currentTime을 받아 
	 * <br> 그에 맞게 슬라이드를 움직입니다.
	 * @param currentTime 현재 재생중인 구간의 시각
	 * @author jihun
	 */
	public static void updateSlider(long currentTime) {
		timeSlider.setValue((int) currentTime);
	}

	/**
	 * PlayAction 클래스의 getTags()에서 태그를 받아 화면에 표시합니다.
	 * @param title 제목 태그
	 * @param artist 가수명 태그
	 * @author changhee
	 */
	public static void updateTag(String title, String artist) {
		musicName_T.setText(title);
		singerName_T.setText(artist);
	}
	
	//<--메인 메소드-->

	/**
	 * GUI 프레임(MainFrame)을 생성합니다.
	 * 
	 * @author team3
	 * 
	 * @param args 선택인자 사용 안 합니다.
	 * 
	 * @throws IOException 입출력 익셉션
	 * @throws UnsupportedAudioFileException mp3, wav 이외의 확장자는 예외 처리합니다.
	 * @throws LineUnavailableException 라인에 음악이 하나도 안 올라와 있으면 예외를 발생시킵니다.
	 */
	public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		new MainFrame();			  // 프레임 생성

		// 플랫폼 종속적인 룩앤필 가져오기, 윈도우의 경우엔 윈도우 룩앤필을 가져옵니다.
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}