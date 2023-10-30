import java.io.File;

import javax.sound.sampled.UnsupportedAudioFileException;

import javazoom.jlgui.player.amp.tag.MpegInfo;

//<--�±� �Ŵ���-->

/**
 * ���������� �±�����(������, ����, �帣...)�� �������� ����� �մϴ�.
 * <br> �츮�� ���α׷��� ����� �����̸����� �������� �˴ϴ�.
 * <br> wav ������ tag�� �������� �ʱ� ������ ������ ���ϸ��� ������ �� ���̰� 
 * <br> ������ �̸��� Various Artists �� ����ϵ��� ��������ϴ�.
 * 
 * @author changhee, yunki
 */
public class Tag {
	//�±� �Ŵ����� �ʱ�ȭ �մϴ�.
	MpegInfo tags;
	//����� ������ ��θ� �����ͼ� �±� �Ŵ������� �ǳ��� �����Դϴ�.
	File audioFile;

	public Tag(File audioFile) {
		this.audioFile = audioFile;
	}

	// mp3 ������ ��� �±� �Ŵ���(tag_info)�� �±� ������ �����ͼ� ����� �������� �����մϴ�.
	public void getTags() {
		MpegInfo tags = new MpegInfo();
		try {
			tags.load(audioFile);
			String title = new String(tags.getTitle());
			String artist = new String(tags.getArtist());
			MainFrame.updateTag(title, artist);
		}

		// �±״� mp3 �� �˴ϴ�. ���� wav ������ ��쿡�� String ��ü�� �޼ҵ带 ����Ͽ� ����� �������� �����մϴ�. 
		catch( UnsupportedAudioFileException e ) {
			String title = audioFile.getName().split(".wav")[0];
			MainFrame.updateTag(title, "Various Artists");
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
}