import java.io.*;

import javax.sound.sampled.*;
/**
 * wav�� mp3 ������ ����ϴ� Ŭ�����Դϴ�.
 * <br> �켱 wav ������ �������� �� �ʿ䰡 �ֽ��ϴ�.
 * <br> �Ҹ��� ����ȭ �Ǿ� �� �÷����� ���� ������ Ȯ���ڷ� �ٲ�� ����˴ϴ�. (�������, PCM ���� �̶�� �մϴ�.) 
 * <br> MS Windows �� wav Ȯ���ڸ�, MAC �� aiff ��, �������� ���н��� au ������ ������ ������ ��� ������� ä���ϰ� �ֽ��ϴ�.
 * <br> �츮�� �̷��� �⺻ Ȯ���ڵ��� ����ϱ� ���� javax.sound API �� ����մϴ�.
 * <br> �ڹٴ� WORA�� ���� sound API �� �� Ȯ���ڸ� �⺻���� �����ϵ��� ��������ϴ�. 
 * <br> ���� �� ���� Ȯ���ڴ� ����� �� �ǰ� ���α׷��Ӱ� �÷��������� �Ͽ��� ���� �߰��� ���� �ʿ䰡 �ֽ��ϴ�. 
 * <br> �� ������ �÷����� PCM Ÿ���� ���Ǹ� ����� �� �ֱ� �����Դϴ�. mp3�� ���ڵ� �� ���Ϸμ� ������� ������������ ������ �ʿ䰡 �ֽ��ϴ�. 
 * <br> sound API�� SPI(Service Provider Interface) �� �����ϰ� ���α׷��Ӵ� �̸� Ȯ���Ͽ�
 * <br> �ܺ� Ȯ���ڸ� ����� �� �ֽ��ϴ�.  
 * <br> ���� �츮�� mp3�� wav(PCM) �� ��ȯ�ϱ� ���� javazoom�� �ܺ� ���̺귯������ ����߽��ϴ�.
 * @author yunki, jihun
 * @since JDK 1.6
 */

public class PlayAction {
	// ��� ���¸� enum���� ������ (�ʱⰪ : STOP)
	enum State{ PLAY, PAUSE, STOP }
	static State playState = State.STOP;
	static Thread timer;

	// ����� ������ �ҷ��� ��Ʈ��
	static AudioInputStream in = null;
	static AudioInputStream din = null;

	// ����� ��ǲ ��Ʈ���� ����� �ý��ۿ� �ΰ��� �� Ŭ���� ����Ѵ�.
	public static Clip CLIP = null;

	// mp3 �� ��쿡�� �±׸� ���� ���� �� ������ wav �� �±׸� �������� �ʾƼ� ������ ó���մϴ�.
	public static File PCMInfo = null;

	// ���� ������� ������ ������(AudioFormat.EncodingŬ������ MASTER_GAIN���) ����˴ϴ�.
	public static float savedVolume;

	/**
	 * ó�� ����ÿ��� �̿�
	 * ������ ����ϰ� playState�� PLAY�� �ٲߴϴ�.
	 * ����� ���ÿ� ������ ��ü�ð��� Ŭ���� MainFrame�� updaterunningTime���� ���� ǥ���ϰ� �մϴ�.
	 * ���� LyricMake��ü�� ����� ���縦 ����� ǥ���ϰ� �մϴ�.
	 * @author yunki, jihun
	 */

	//<--���-->

	public static void start() {
		// ��� ��ư ������ �� ������ ����ִ� ���Ͱ� ������� ������ �ҷ��´�.
		if (PlayList.getListSize() == 0) {
			OpenAction open = new OpenAction();
			open.actionPerformed(null);
		}

		else {	
			try {
				// ����� ������ ���ڵ� �Ͽ� Ŭ���� �ø���.
				File audioFile = new File(PlayList.getPath());

				// �ҷ��� ����� ������ ��θ� �±׸� �����ִ� Ŭ�������� �����ݴϴ�.
				Tag tag = new Tag(audioFile);
				tag.getTags();

				// ���ڵ�
				decode(audioFile);

				// ���� ���
				CLIP = AudioSystem.getClip();
				CLIP.open(din);	// ���ڵ� �� ����� ��ǲ ��Ʈ���� ����.
				playState = State.PLAY;
				CLIP.start();

				// ���� �����̴� ���� �ٽ� �ҷ��ͼ� ���ο� Ŭ���� ����
				FloatControl gainControl = 
						(FloatControl) PlayAction.CLIP.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue(savedVolume);

				// ����� ������ ������ �� �ð��� MainFrame���� ���� ȭ�鿡 ǥ���ϰ� �����.
				MainFrame.updaterunningTime(CLIP.getMicrosecondLength());
				MainFrame.initializeSlider(CLIP.getMicrosecondLength());
				// ����� ������ ������ ��θ� LyricMaker�� ���� ���縦 ����� �Ѵ�.
				new LyricMaker(PlayList.getPath());

				timer = new Timer();
				timer.start();
				// ����ó��
			} catch (Exception e1) {  }
		}
	}

	// <--���ڵ�-->	

	/**
	 * PCM(wav,aiff...) Ÿ���� ���������̳� 
	 * <br> non PCM ( mp3, FLAC.. ) Ÿ���� ������ ���ڵ��Ͽ� PCM ���� �ٲ��ݴϴ�. 
	 * 
	 * @author yunki
	 * @param audioFile PCM�̳� non PCM ���Ϸν� ������ ���ڵ��� �����Դϴ�.
	 */
	public static void decode(File audioFile) {
		try {
			in = AudioSystem.getAudioInputStream(audioFile);	// ���ڵ��� ����

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
	 * �Ͻ����� ���¿��� �ٽ� �����ų �� �̿�
	 * @author jihun
	 */
	public static void restart() {
		CLIP.start();
		playState = State.PLAY;
	}

	/**
	 * ������ �����մϴ�.
	 * @author jihun
	 */
	public static void stop() {
		//playState�� �̹� STOP�̸� ������ ���� �ʴ´�. 
		if(!PlayAction.playState.equals(PlayAction.State.STOP)) {
			CLIP.close();
			MainFrame.updatecurrentTime(0);
			MainFrame.updateSlider(0);
			saveVolumeValue();  // ���� �ÿ��� ������ ������ �����صд�.
			playState = State.STOP;
			((Timer) timer).finish();
		}
	}

	/**
	 * ������ �Ͻ������մϴ�.
	 * @author jihun
	 */
	public static void pause() {
		if(!PlayAction.playState.equals(PlayAction.State.PAUSE)) {
			CLIP.stop();
			playState = State.PAUSE;
		}
	}

	//<--�����̴��� �����ġ ����-->

	/**
	 * Ÿ�ӽ����̴��� �����̸� ���� ������� ������ ��� ������ �ٲ�� ����ϴ�.
	 * @param position ����ϰ� ���� ��ġ
	 * @author jihun
	 */
	public static void changePosition(long position) {
		CLIP.setMicrosecondPosition(position);
	}

	//<--���� ����-->

	/**
	 * ���� ���������κ��� �������� �ΰ� �޾� �����صӴϴ�.
	 * @author yunki
	 */
	public static void saveVolumeValue() {
		savedVolume = MainFrame.VOLUME;
	}
}

//<--Ÿ�̸� ������-->

/**
 * �������  ����� ó�� ���۵� ������ ���۵ǰ� stop �� �� interrupt �˴ϴ�.
 * <br>�ϴ� �� : �ǽð����� �ð�label, �����̴� ���� / ������ ������ ����Ǹ� stop()ȣ��
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