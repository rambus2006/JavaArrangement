import java.io.*;

import javax.sound.sampled.*;
/**
 * wav와 mp3 파일을 재생하는 클래스입니다.
 * <br> 우선 wav 파일이 무엇인지 알 필요가 있습니다.
 * <br> 소리는 양자화 되어 각 플랫폼에 따라 적절한 확장자로 바뀌어 저장됩니다. (비압축형, PCM 포맷 이라고 합니다.) 
 * <br> MS Windows 는 wav 확장자를, MAC 은 aiff 를, 리눅스나 유닉스는 au 파일을 각자의 고유한 재생 방식으로 채택하고 있습니다.
 * <br> 우리는 이러한 기본 확장자들을 재생하기 위해 javax.sound API 를 사용합니다.
 * <br> 자바는 WORA를 위해 sound API 에 세 확장자를 기본으로 제공하도록 만들었습니다. 
 * <br> 따라서 그 외의 확장자는 재생이 안 되고 프로그래머가 플러그인으로 하여금 따로 추가를 해줄 필요가 있습니다. 
 * <br> 그 이유는 플랫폼이 PCM 타입의 음악만 재생할 수 있기 때문입니다. mp3는 인코딩 된 파일로서 비압축형 음악파일임을 유의할 필요가 있습니다. 
 * <br> sound API는 SPI(Service Provider Interface) 를 제공하고 프로그래머는 이를 확장하여
 * <br> 외부 확장자를 사용할 수 있습니다.  
 * <br> 따라서 우리는 mp3를 wav(PCM) 로 변환하기 위해 javazoom의 외부 라이브러리들을 사용했습니다.
 * @author yunki, jihun
 * @since JDK 1.6
 */

public class PlayAction {
	// 재생 상태를 enum으로 저장함 (초기값 : STOP)
	enum State{ PLAY, PAUSE, STOP }
	static State playState = State.STOP;
	static Thread timer;

	// 오디오 파일을 불러올 스트림
	static AudioInputStream in = null;
	static AudioInputStream din = null;

	// 오디오 인풋 스트림을 오디오 시스템에 인계한 후 클립이 재생한다.
	public static Clip CLIP = null;

	// mp3 의 경우에는 태그를 쉽게 얻어올 수 있지만 wav 는 태그를 지원하지 않아서 별도로 처리합니다.
	public static File PCMInfo = null;

	// 현재 재생중인 파일의 볼륨이(AudioFormat.Encoding클래스의 MASTER_GAIN상수) 저장됩니다.
	public static float savedVolume;

	/**
	 * 처음 재생시에만 이용
	 * 음악을 재생하고 playState를 PLAY로 바꿉니다.
	 * 재생과 동시에 음악의 전체시간를 클래스 MainFrame의 updaterunningTime으로 보내 표시하게 합니다.
	 * 또한 LyricMake객체를 만들어 가사를 만들어 표시하게 합니다.
	 * @author yunki, jihun
	 */

	//<--재생-->

	public static void start() {
		// 재생 버튼 눌렀을 때 파일이 들어있는 벡터가 비었으면 파일을 불러온다.
		if (PlayList.getListSize() == 0) {
			OpenAction open = new OpenAction();
			open.actionPerformed(null);
		}

		else {	
			try {
				// 오디오 파일을 디코딩 하여 클립에 올린다.
				File audioFile = new File(PlayList.getPath());

				// 불러온 오디오 파일의 경로를 태그를 구해주는 클래스에게 보내줍니다.
				Tag tag = new Tag(audioFile);
				tag.getTags();

				// 디코딩
				decode(audioFile);

				// 음악 재생
				CLIP = AudioSystem.getClip();
				CLIP.open(din);	// 디코딩 된 오디오 인풋 스트림을 연다.
				playState = State.PLAY;
				CLIP.start();

				// 볼륨 슬라이더 값을 다시 불러와서 새로운 클립에 적용
				FloatControl gainControl = 
						(FloatControl) PlayAction.CLIP.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue(savedVolume);

				// 재생을 시작한 음악의 총 시간을 MainFrame으로 보내 화면에 표시하게 만든다.
				MainFrame.updaterunningTime(CLIP.getMicrosecondLength());
				MainFrame.initializeSlider(CLIP.getMicrosecondLength());
				// 재생을 시작한 음악의 경로를 LyricMaker로 보내 가사를 만들게 한다.
				new LyricMaker(PlayList.getPath());

				timer = new Timer();
				timer.start();
				// 예외처리
			} catch (Exception e1) {  }
		}
	}

	// <--디코딩-->	

	/**
	 * PCM(wav,aiff...) 타입의 음악파일이나 
	 * <br> non PCM ( mp3, FLAC.. ) 타입의 음원을 디코딩하여 PCM 으로 바꿔줍니다. 
	 * 
	 * @author yunki
	 * @param audioFile PCM이나 non PCM 파일로써 앞으로 디코딩될 파일입니다.
	 */
	public static void decode(File audioFile) {
		try {
			in = AudioSystem.getAudioInputStream(audioFile);	// 디코딩할 파일

			AudioFormat baseFormat = in.getFormat();
			AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
					baseFormat.getSampleRate(),
					16,
					baseFormat.getChannels(),
					baseFormat.getChannels() * 2,
					baseFormat.getSampleRate(),
					false);
			din = AudioSystem.getAudioInputStream(decodedFormat, in);

		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 일시정지 상태에서 다시 재생시킬 때 이용
	 * @author jihun
	 */
	public static void restart() {
		CLIP.start();
		playState = State.PLAY;
	}

	/**
	 * 음악을 정지합니다.
	 * @author jihun
	 */
	public static void stop() {
		//playState가 이미 STOP이면 동작을 하지 않는다. 
		if(!PlayAction.playState.equals(PlayAction.State.STOP)) {
			CLIP.close();
			MainFrame.updatecurrentTime(0);
			MainFrame.updateSlider(0);
			saveVolumeValue();  // 정지 시에는 마스터 볼륨을 저장해둔다.
			playState = State.STOP;
			((Timer) timer).finish();
		}
	}

	/**
	 * 음악을 일시정지합니다.
	 * @author jihun
	 */
	public static void pause() {
		if(!PlayAction.playState.equals(PlayAction.State.PAUSE)) {
			CLIP.stop();
			playState = State.PAUSE;
		}
	}

	//<--슬라이더의 재생위치 변경-->

	/**
	 * 타임슬라이더를 움직이면 현재 재생중인 음악의 재생 구간이 바뀌게 만듭니다.
	 * @param position 재생하고 싶은 위치
	 * @author jihun
	 */
	public static void changePosition(long position) {
		CLIP.setMicrosecondPosition(position);
	}

	//<--볼륨 저장-->

	/**
	 * 메인 프레임으로부터 볼륨값을 인계 받아 저장해둡니다.
	 * @author yunki
	 */
	public static void saveVolumeValue() {
		savedVolume = MainFrame.VOLUME;
	}
}

//<--타이머 스레드-->

/**
 * 스레드는  재생이 처음 시작될 때부터 시작되고 stop 일 때 interrupt 됩니다.
 * <br>하는 일 : 실시간으로 시간label, 슬라이더 갱신 / 음악이 완전히 종료되면 stop()호출
 *
 * @author jihun
 */
class Timer extends Thread {
	boolean interruptFlag = false;
	public void run() {
		while(true){
			MainFrame.updatecurrentTime(PlayAction.CLIP.getMicrosecondPosition());
			MainFrame.updateSlider(PlayAction.CLIP.getMicrosecondPosition());
			if(PlayAction.CLIP.getMicrosecondPosition() == PlayAction.CLIP.getMicrosecondLength())	{
				new NextPlay();
				PlayAction.stop();
				PlayAction.start();
			}
			try {
				Thread.sleep(1);
				if(interruptFlag == true) {
					return;
				}
			} catch (InterruptedException e) {
				return;
			}
		}
	}

	void finish() {
		this.interruptFlag = true;
	}
}